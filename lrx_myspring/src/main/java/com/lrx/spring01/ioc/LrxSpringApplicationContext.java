package com.lrx.spring01.ioc;



import com.lrx.spring01.anootation.Autowired;
import com.lrx.spring01.anootation.Component;
import com.lrx.spring01.anootation.ComponentScan;
import com.lrx.spring01.anootation.Scope;
import com.lrx.spring01.proxy.BeanPostProcess;
import com.lrx.spring01.proxy.InitializingBean;
import org.apache.commons.lang.StringUtils;

import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Enumeration;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午6:59
 * ioc容器实现
 */
public class LrxSpringApplicationContext {
    private Class springConfig;
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,BenaDifinition> benaDifinitions = new ConcurrentHashMap<>();
    private List<BeanPostProcess> beanPostProcesses = new ArrayList<>();


    public LrxSpringApplicationContext(Class springConfig) {
        this.springConfig = springConfig;
        componentScan(springConfig);

        Enumeration<String> keys = benaDifinitions.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            BenaDifinition benaDifinition = (BenaDifinition)benaDifinitions.get(key);
            String scope = benaDifinition.getScope();
            if("singleton".equalsIgnoreCase(scope)) {
                Object bean = createBean(key,benaDifinition);
                singletonObjects.put(key,bean);
            }

        }
        System.out.println(singletonObjects);
        System.out.println(benaDifinitions);

    }


//扫描包，把信息封装到BeanDifinitions集合中
    public void componentScan(Class springConfig) {
        ComponentScan componentScan
                = (ComponentScan)springConfig.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value();
        //System.out.println("path = " + path);

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
                String absolutePath = file1.getAbsolutePath();
                System.out.println("absolutePath = " + absolutePath);

                if(absolutePath.endsWith(".class")) {
                    //得到类名
                    String className = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
                    //System.out.println("className = " + className);

                    //得到全类名
                    String classFullPath = path.replace("/", ".") + "." + className;
                    //System.out.println("classFullPath = " + classFullPath);

                    try {
                        Class<?> aClass = classLoader.loadClass(classFullPath);
                        if(aClass.isAnnotationPresent(Component.class)) {
                            if(BeanPostProcess.class.isAssignableFrom(aClass)) {
                                beanPostProcesses.add((BeanPostProcess)aClass.getDeclaredConstructor().newInstance());
                                continue;
                            }
                            System.out.println("是bean " + className);
                            Component declaredAnnotation = aClass.getDeclaredAnnotation(Component.class);
                            String value = declaredAnnotation.value();
                            if("".equals(value)) {
                                value = StringUtils.uncapitalize(className);
                            }
                            BenaDifinition benaDifinition = new BenaDifinition();
                            if(aClass.isAnnotationPresent(Scope.class)) {
                                Scope declaredAnnotation1 = aClass.getDeclaredAnnotation(Scope.class);
                                String value1 = declaredAnnotation1.value();
                                benaDifinition.setScope(value1);
                            }else {
                                benaDifinition.setScope("singleton");
                            }
                            benaDifinition.setClazz(aClass);
                            benaDifinitions.put(value, benaDifinition);

                            //System.out.println(benaDifinitions);


                        }else {
                            System.out.println("不是bean " + className);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }



            }
        }

    }
    public Object createBean(String className , BenaDifinition benaDifinition) {
        Class clazz = benaDifinition.getClazz();
        try {
            Object instance = clazz.getConstructor().newInstance();
            for (Field declaredField : clazz.getDeclaredFields()) {
                if(declaredField.isAnnotationPresent(Autowired.class)){
                    String name = declaredField.getName();
                    Object bean = getBean(name);
                    declaredField.setAccessible(true);
                    declaredField.set(instance,bean);
                }

            }


            for (BeanPostProcess beanPostProcess : beanPostProcesses) {
                beanPostProcess.processBeforeInitialization(instance,className);

            }
            System.out.println("创建好的bean " + instance);
            if(instance instanceof InitializingBean) {
                try {
                    ((InitializingBean)instance).afterPropertiesSet();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            for (BeanPostProcess beanPostProcess : beanPostProcesses) {
                beanPostProcess.processAfterInitialization(instance,className);

            }

            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }
    public Object getBean(String className) {
        if(benaDifinitions.containsKey(className) ) {
            BenaDifinition benaDifinition = benaDifinitions.get(className);
            String scope = benaDifinition.getScope();
            if ("singleton".equalsIgnoreCase(scope)) {
                return singletonObjects.get(className);
            }else {
                return createBean(className,benaDifinition);
            }

        }else {
            throw new RuntimeException("没有这个bean");
        }

    }

}
