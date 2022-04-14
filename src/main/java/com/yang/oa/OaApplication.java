package com.yang.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**@Title
*@Description
*@Param
*@return
*@author yang
*@date  2022/3/24
*/
@SpringBootApplication
@EnableScheduling
@MapperScan("com.yang.oa.dao")
public class OaApplication {
  public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
    }

}
