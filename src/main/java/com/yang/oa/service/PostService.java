package com.yang.oa.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.oa.analy.PostAnalysisEvent;
import com.yang.oa.dao.PostDao;
import com.yang.oa.entity.PageHelper;
import com.yang.oa.entity.Post;
import com.yang.oa.exceptions.OaException;
import com.yang.oa.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [岗位维护]
 * @createTime :[2022/3/28 21:32]
 */
@Slf4j
@Service
public class PostService {

    @Resource
    private PostDao dao;



    /**@Title
    *@Description 岗位查询
    *@Param [post]
    *@return com.yang.oa.entity.PageHelper<com.yang.oa.entity.Post>
    *@Author yang
    *@Date  2022/3/29
    */
    @Transactional(readOnly = true)
    public JSONObject queryPost(Map<String,Object> param){
        JSONObject ret = new JSONObject();
        try{
            List<Post> posts = dao.queryPost(param);
            Integer total = dao.queryPostNum(param);
            ret.put("aaData",posts);
            ret.put("iTotalRecords",total);
            ret.put("iTotalDisplayRecords",total);
            ret.put("sEcho",Integer.parseInt("0")+1);
            return ret;
        }catch (Exception e){
            throw new OaException(500,"查询岗位信息报错!");
        }

    }

    @Transactional(readOnly = true)
    public void queryPostToExcel(Map<String,Object> map, HttpServletResponse response){
        try{
            List<Post> posts = dao.queryPostToExcel(map);
            ExcelUtil.downLoad("员工岗位",Post.class,response,posts);
        }catch (Exception e){
            throw new OaException(500,"导出岗位信息失败!");
        }

    }

    @Transactional
    public void addPost(Post post){
        try{
            dao.addPost(post);
        }catch (Exception e){
            log.error("新增岗位信息失败:{}",e.getMessage(),e);
            throw new OaException(500,"新增岗位信息失败");
        }

    }

    @Transactional
    public void branchAddPost(MultipartFile file){
        try {
            List<Post> posts = ExcelUtil.upLoad(file, Post.class, new PostAnalysisEvent());
            dao.branchAddPost(posts);
        }catch (Exception e){
            throw new OaException(500,"批量新增岗位报错");
        }

    }

    @Transactional
    public void updatePost(Post post){
        try {
            dao.updatePost(post);
        }catch (Exception e){
            throw new OaException(500,"更新岗位信息报错");
        }

    }

    @Transactional
    public void deletePost(String postId){
        try{
            dao.deletePost(postId);
        }catch (Exception e){
            throw new OaException(500,"删除岗位信息报错");
        }

    }

    @Transactional
    public void branchDeletePost(List<String> postIds){
        try{
            dao.branchDeletePost(postIds);
        }catch (Exception e){
            throw new OaException(500,"批量删除岗位信息报错");
        }

    }

    @Transactional
    public boolean queryIsExistPost(String postId){
        try{
            Integer flag = dao.queryIsExistPost(postId);
            return 0 < flag;
        }catch (Exception e){
            throw new OaException(500,"判断岗位是否存在报错");
        }

    }
}
