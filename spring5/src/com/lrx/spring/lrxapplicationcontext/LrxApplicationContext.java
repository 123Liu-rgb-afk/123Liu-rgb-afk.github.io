package com.lrx.spring.lrxapplicationcontext;

//简单spring容器机制


import com.lrx.spring.bean.Monster;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LrxApplicationContext {
    private ConcurrentHashMap<String,Object> singleton = new ConcurrentHashMap<>();

    public LrxApplicationContext(String iocBeanXmlFile) throws Exception {

        //1. 得到类加载路径
        String path = this.getClass().getResource("/").getPath();
        System.out.println("path= " + path);

        //2. 创建 Saxreader

        SAXReader saxReader = new SAXReader();
        String fullPath = path + iocBeanXmlFile;
        System.out.println("fullPath = " + fullPath);


        File file1 = new File(path + iocBeanXmlFile);
        System.out.println("file1 = " + file1);
        //3. 得到Document对象
        //Document document = saxReader.read(new File(path+iocBeanXmlFile));
        Document document = saxReader.read(file1);
        System.out.println("document = " + document);



    }
    }


