package com.yang.oa.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.oa.annotations.ResultResponse;
import com.yang.oa.entity.PageHelper;
import com.yang.oa.entity.Post;
import com.yang.oa.exceptions.OaException;
import com.yang.oa.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [该类的功能]
 * @createTime :[2022/3/29 21:57]
 */
@Slf4j
@Controller

@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping("/queryPost")
    @ResponseBody
    public JSONObject queryPost(@RequestParam Map<String,Object> map){
        log.info("==进来了==");
        log.info("map:{}",map);
        return service.queryPost(map);
    }

    @GetMapping("/queryPostToExcel")
    @ResponseBody
    public void queryPostToExcel(@RequestParam Map<String,Object> map, HttpServletResponse response){
         service.queryPostToExcel(map,response);
    }

    @PostMapping("/addPost")
    @ResponseBody
    public void addPost(@RequestBody Post post){
         service.addPost(post);
    }

    @PostMapping("/branchAddPost")
    @ResponseBody
    public void branchAddPost(MultipartFile file){
         service.branchAddPost(file);
    }

    @PostMapping("/updatePost")
    @ResponseBody
    public void updatePost(@RequestBody Post post){
         service.updatePost(post);
    }

    @PostMapping("/deletePost")
    @ResponseBody
    public void deletePost(String postId){
         service.deletePost(postId);
    }

    @PostMapping("/branchDeletePost")
    @ResponseBody
    public void branchDeletePost(@RequestBody List<String> postIds){
         service.branchDeletePost(postIds);
    }

    @PostMapping("/queryIsExistPost")
    @ResponseBody
    public boolean queryIsExistPost(String postId){
        return service.queryIsExistPost(postId);
    }

    @PostMapping("/getPost")
    @ResponseBody
    public Map<String,String> getPost(){
        return service.getPost();
    }

    @GetMapping("/queryOnePost")
    public ModelAndView queryOnePost(String postId){
        ModelAndView modelAndView = new ModelAndView();
        Post post = service.queryOnePost(postId);
        modelAndView.addObject("post",post);
        modelAndView.setViewName("/posts/updatePost.html");
        return modelAndView;
    }

    @GetMapping("/t")
    public String get(){
        return "a";
    }



 }
