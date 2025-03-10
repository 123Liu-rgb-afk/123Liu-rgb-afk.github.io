package com.lrx.spring.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lrx
 * {@code @date} 2025/3/4 下午9:35
 *
 */
public class LrxSpringApplicationContext {
    private Class configClass;
    private ConcurrentHashMap<String,Object> ioc
            = new ConcurrentHashMap<>();

    public LrxSpringApplicationContext(Class configClass) {
        this.configClass = configClass;
        //System.out.println("configClass = " + this.configClass);
        ComponentScan componentScan
                = (ComponentScan)this.configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value();
        System.out.println("path:"+path);

        path = path.replace(".","/");
        ClassLoader classLoader = LrxSpringApplicationContext.class.getClassLoader();
        URI resource = null;
        try {
             resource = classLoader.getResource(path).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        File file = new File(resource.getPath());
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
               // System.out.println("file:"+file1.getAbsolutePath());
                String absolutePath = file1.getAbsolutePath();


                if(absolutePath.endsWith(".class")) {
                    //得到类名
                    String className = absolutePath.substring(absolutePath.lastIndexOf("\\")+1,absolutePath.indexOf(".class"));
                    //System.out.println("className:"+className);
                    //得到全类名
                    String classFullName = path.replace("/",".") + "." + className;
                    System.out.println(classFullName);


                    try {

                        Class<?> aClass = classLoader.loadClass(classFullName);
                        if(aClass.isAnnotationPresent(Component.class)||
                                aClass.isAnnotationPresent(Repository.class)||
                                aClass.isAnnotationPresent(Service.class)||
                                aClass.isAnnotationPresent(Controller.class)
                        ) {
                            if(aClass.isAnnotationPresent(Component.class)){
                                Component component = aClass.getDeclaredAnnotation(Component.class);
                                String id = component.value();
                                if(!"".equals(id)){
                                    className = id;
                                }


                            }
                            Class<?> clazz = Class.forName(classFullName);
                            Object bean = clazz.newInstance();

                            ioc.put(StringUtils.uncapitalize(className),bean);


                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }


    }
    public Object getBean(String beanName) {
        return ioc.get(beanName);
    }

}
