package com.lrx.spring.annotation;

import java.io.File;
import java.net.URL;
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
        String value = componentScan.value();

        value = value.replace(".","/");
        System.out.println("value:"+value);

        ClassLoader classLoader
                = LrxSpringApplicationContext.class.getClassLoader();

        URL resource = classLoader.getResource(value);
        System.out.println("resource:"+resource);

        File file = new File(resource.getFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getAbsolutePath());
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println(f.getAbsolutePath());

            }
        }

    }

}
