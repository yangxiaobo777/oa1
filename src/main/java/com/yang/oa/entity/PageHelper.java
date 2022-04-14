package com.yang.oa.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [信息返回类]
 * @createTime :[2022/3/28 20:46]
 */
@Data
public class PageHelper<T> {

    private List<T> rows = new ArrayList<T>();

    private Integer total;
}
