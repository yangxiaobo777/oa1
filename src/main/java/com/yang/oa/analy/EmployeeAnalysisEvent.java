package com.yang.oa.analy;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yang.oa.entity.Post;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author :[yang]
 * @version :1.0
 * @description : [该类的功能]
 * @createTime :[2022/3/29 21:41]
 */
@Component
@Scope("prototype")
public class EmployeeAnalysisEvent extends AnalysisEventListener<Post> {
    @Override
    public void invoke(Post data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
