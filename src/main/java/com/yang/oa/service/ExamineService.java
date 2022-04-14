package com.yang.oa.service;


import com.yang.oa.dao.ExamineDao;
import com.yang.oa.entity.Examine;
import com.yang.oa.entity.PageHelper;
import com.yang.oa.exceptions.OaException;
import com.yang.oa.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [申诉维护]
 * @createTime :[2022/3/28 21:32]
 */
@Slf4j
@Service
public class ExamineService {

    @Resource
    private ExamineDao dao;

    @Transactional(readOnly = true)
    public PageHelper<Examine> queryExamine(Examine examine,String staDt,String endDt){
        try{
            PageHelper<Examine> postPageHelper = new PageHelper<>();
            List<Examine> posts = dao.queryExamine(examine,staDt,endDt);
            Integer total = dao.queryExamineNum(examine,staDt,endDt);
            postPageHelper.setRows(posts);
            postPageHelper.setTotal(total);
            return postPageHelper;
        }catch (Exception e){
            throw new OaException(500,"查询申诉信息报错!");
        }

    }


    @Transactional(readOnly = true)
    public void queryExamineToExcel(Examine examine, String staDt,String endDt,HttpServletResponse response){
        try{
            List<Examine> employees = dao.queryExamineToExcel(examine,staDt,endDt);
            ExcelUtil.downLoad("员工信息",Examine.class,response,employees);
        }catch (Exception e){
            throw new OaException(500,"导出申诉信息报错!");
        }
 }

    @Transactional
    public void addExamine(Examine examine){
        try{
            dao.addExamine(examine);
        }catch (Exception e){
            throw new OaException(500,"新增申诉信息报错!");
        }

    }




}
