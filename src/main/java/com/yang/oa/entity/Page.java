package com.yang.oa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [分页]
 * @createTime :[2022/3/26 15:25]
 */
@Data
public class Page implements Serializable{

   private int limit;
   private int page;
   private int offset;

}
