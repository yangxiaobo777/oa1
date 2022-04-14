package com.yang.oa.dao;

import com.yang.oa.entity.Examine;

import java.util.List;

public interface ExamineDao {

    Integer addExamine(Examine examine);

    List<Examine> queryExamine(Examine examine,String staDt,String endDt);

    Integer queryExamineNum(Examine examine,String staDt,String endDt);

    List<Examine> queryExamineToExcel(Examine examine,String staDt,String endDt);
}
