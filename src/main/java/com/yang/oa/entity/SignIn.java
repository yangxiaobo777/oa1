package com.yang.oa.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [签到信息]
 * @createTime :[2022/3/24 0:10]
 */
public class SignIn extends Page {

    @ExcelProperty(value = "员工微信号")
    private String userId;

    @ExcelProperty(value = "人员姓名")
    private String userName;

    @ExcelProperty(value = "该岗位第一次签到时间")
    @ColumnWidth(value = 20)
    private String signTmOne;

    @ExcelProperty(value = "该岗位第二次签到时间")
    @ColumnWidth(value = 20)
    private String signTmTwo;

    @ExcelProperty(value = "该岗位第三次签到时间")
    @ColumnWidth(value = 20)
    private String signTmThree;

    @ExcelProperty(value = "该岗位第四次签到时间")
    @ColumnWidth(value = 20)
    private String signTmFour;

    @ExcelProperty(value = "员工状态")
    private String status;

    @ExcelProperty(value = "时间")
    private String Datadt;

    @ExcelProperty(value = "申诉理由")
    private String reasin;


}
