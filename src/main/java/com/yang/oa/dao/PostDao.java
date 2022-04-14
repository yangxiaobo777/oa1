package com.yang.oa.dao;

import com.yang.oa.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostDao {

    List<Post> queryPost(Map<String,Object> param);

    Integer queryPostNum(Map<String,Object> param);

    List<Post> queryPostToExcel(Map<String,Object> param);

    int addPost(Post post);

    int branchAddPost(List<Post> posts);

    int updatePost(Post post);

    int deletePost(String postId);

    int branchDeletePost(List<String> postIds);

    int queryIsExistPost(String postId);




}
