package com.yang.oa.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [岗位信息]
 * @createTime :[2022/3/24 0:10]
 */
@Data
@ToString
public class Post extends Page{

    @ExcelProperty(value = "岗位id")
    private String postId;

    @ExcelProperty(value = "岗位名称")
    private String postNm;

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

    @ExcelProperty(value = "岗位状态")
    private String status;
}
