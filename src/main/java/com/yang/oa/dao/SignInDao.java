package com.yang.oa.dao;


import com.yang.oa.entity.SignIn;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SignInDao {

    int initSignIn(@Param("userIds") List<String> userIds);

    int queryIsExist(String userId);

    int addSignIn(@Param("status") String status);

    int updateSignIn(@Param("reason") String reason,
                     @Param("signinTm") String signinTm,@Param("userId") String userId,
                     @Param("dataDt") String dataDt);

    List<SignIn> querySignIn(SignIn signIn);

    int querySignInNum(SignIn signIn);

    List<SignIn> querySignInToExcel(SignIn signIn);

    Map<String,String> queryIsSuccess(@Param("userId") String userId, @Param("dataDt") String dataDt);

    int updateSignInStatus(@Param("userId") String userId, @Param("dataDt") String dataDt,
                         @Param("status") String status);
}
