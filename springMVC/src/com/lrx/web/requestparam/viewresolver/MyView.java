package com.lrx.web.requestparam.viewresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.swing.text.View;
import java.util.Map;

/**
 * @author lrx
 * {@code @date} 2025/3/11 下午9:20
 */
@Component(value = "view")
public class MyView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {


        System.out.println("进入到自己的视图");
// 这里我们自己来确定到哪个页面去,默认的视图解析机制就无效
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/my_view.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
