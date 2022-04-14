package com.yang.oa.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [员工信息]
 * @createTime :[2022/3/24 0:11]
 */
@Data
public class Employee extends Page {

    @ExcelProperty("员工id")
    private String userId;

    @ExcelProperty("员工姓名")
    private String userName;

    @ExcelProperty("员工岗位")
    private String post;

    @ExcelProperty("员工性别")
    private String sex;

    @ExcelProperty("员工工作地点")
    private String workAddress;

    @ExcelProperty("员工状态")
    private String status;
}
