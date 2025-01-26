package com.lrx.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class MyHttpServletRequest {
    private InputStream inputStream = null;
    private String method;
    private String uri;
    private HashMap<String,String> parametersMapping = new HashMap<>();

    public MyHttpServletRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        init();

    }
    public void init() {
        //先把inputStream 转换 bufferedRead
        try {
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(inputStream));
            String readRequest = bufferedReader.readLine();
            String[] requestLineArr = readRequest.split(" ");
            method = requestLineArr[0];
            int indexOf = requestLineArr[1].indexOf("?");
            if(indexOf == -1) {
                uri = requestLineArr[1];
            }
            else{
                uri = requestLineArr[1].substring(0,indexOf);
                String parameter = requestLineArr[1].substring(indexOf + 1);
                String[] parametersPair = parameter.split("&");
                if(null != parametersPair && !"".equals(parametersPair)) {
                    for (String parameterPair : parametersPair) {
                        String[] parameterVal = parameterPair.split("=");
                        if(parameterVal.length == 2) {
                            parametersMapping.put(parameterVal[0], parameterVal[1]);
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getParameter(String name) {
        if(parametersMapping.containsKey(name)) {
            return parametersMapping.get(name);
        }
        return "";
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setParametersMapping(HashMap<String, String> parametersMapping) {
        this.parametersMapping = parametersMapping;
    }

    @Override
    public String toString() {
        return "MyHttpServletRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", parametersMapping=" + parametersMapping +
                '}';
    }
}
