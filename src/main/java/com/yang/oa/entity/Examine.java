package com.yang.oa.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [申诉类]
 * @createTime :[2022/4/4 16:01]
 */
@Data
public class Examine extends PageHelper{

    @ExcelProperty("申诉id")
    private String examineId;
    @ExcelProperty("申诉签到时间段")
    private String num;
    @ExcelProperty("员工id")
    private String userId;
    @ExcelProperty("员工姓名")
    private String userName;
    @ExcelProperty("申诉理由")
    private String reason;
    @ExcelProperty("申诉日期")
    private String dataDt;
    @ExcelProperty("申诉状态")
    private String status;
}
