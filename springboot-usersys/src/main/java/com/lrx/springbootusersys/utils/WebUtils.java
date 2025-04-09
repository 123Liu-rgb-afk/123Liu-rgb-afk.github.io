package com.lrx.springbootusersys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lrx
 * {@code @date} 2025/4/9 下午5:48
 */
public class WebUtils {

    public static String UPLOAD_FILE = "static/images/upload/";

    public static String getUploadFile() {
        return UPLOAD_FILE + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

}
