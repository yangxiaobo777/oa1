package com.yang.oa.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [excel导入导出]
 * @createTime :[2022/3/28 21:54]
 */

public class ExcelUtil {

    public static <T> List<T> upLoad(MultipartFile file, Class<T> head, AnalysisEventListener listener){
        List<T> retList = null;
        try {
            //1.获取工作簿
            ExcelReaderBuilder readBook = EasyExcel.read(file.getInputStream(), head, listener);
            //2.获取sheet
            ExcelReaderSheetBuilder sheet = readBook.sheet();
            //3.获取Excel中的数据
            retList = sheet.doReadSync();

        } catch (IOException e) {

        }
        return retList;
    }

    public  static void downLoad(String fileName , Class head,
                                  HttpServletResponse response, List list) {
        try {
            ServletOutputStream outputStream = getOutputStream(fileName,response);
            ExcelWriterBuilder writeBook = EasyExcel.write(outputStream, head);
            ExcelWriterSheetBuilder sheet = writeBook.sheet(fileName);
            sheet.doWrite(list);
        } catch (Exception e) {

        }
    }

    /**
     * 导出文件时为Writer生成OutputStream.
     *
     * @param fileName 文件名
     * @param response response
     * @return ""
     */
    private static ServletOutputStream getOutputStream(String fileName,
                                                       HttpServletResponse response) throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置响应的类型
            response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
            //设置响应的编码格式
            response.setCharacterEncoding("utf8");
            //设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {

            throw new Exception("导出excel表格失败!", e);
        }
    }
}






