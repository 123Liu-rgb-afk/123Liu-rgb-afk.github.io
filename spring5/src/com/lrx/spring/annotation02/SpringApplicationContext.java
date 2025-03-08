package com.lrx.spring.annotation02;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午9:38
 */
public class SpringApplicationContext {
    private Class springConfig;
    private ConcurrentHashMap<String,Object> singleton
            = new ConcurrentHashMap();

    public SpringApplicationContext(Class springConfig) {
        this.springConfig = springConfig;

        annotationScan(this.springConfig);

    }
    public void annotationScan(Class springConfig) {
        //System.out.println(springConfig);
        ComponentScan component
                = (ComponentScan) springConfig.getDeclaredAnnotation(ComponentScan.class);
        String path = component.value();
        //System.out.println("path:"+path);

        path = path.replace(".","/");

        ClassLoader classLoader = SpringApplicationContext.class.getClassLoader();
        URI resource = null;
        try {
            resource = classLoader.getResource(path).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("resource:"+resource);

        File file = new File(resource.getPath());
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f : files) {
                System.out.println(f.getAbsolutePath());
                String absolutePath = f.getAbsolutePath();

                if(absolutePath.endsWith(".class")) {
                    //得到类名
                    String className
                            = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
                    //System.out.println(className);
                    //得到全路径
                    String classFullPath = path.replace("/", ".") + "." + className;
                    System.out.println(classFullPath);

                    try {
                        Class<?> aClass = classLoader.loadClass(classFullPath);
                        if (aClass.isAnnotationPresent(Component.class) ||
                                aClass.isAnnotationPresent(Repository.class) ||
                                aClass.isAnnotationPresent(Service.class) ||
                                aClass.isAnnotationPresent(Controller.class) ){

                            Class<?> clazz1 = Class.forName(classFullPath);
                            Object bean = clazz1.newInstance();

                            singleton.put(StringUtils.uncapitalize(className),bean);



                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }

        }
    }
    public Object getBean(String beanName) {
        return singleton.get(beanName);
    }
}
