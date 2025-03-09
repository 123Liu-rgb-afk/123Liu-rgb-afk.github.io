package com.lrx.spring.ioc;

import com.lrx.spring.annotation.Autowired;
import com.lrx.spring.annotation.Component;
import com.lrx.spring.annotation.ComponentScan;
import com.lrx.spring.annotation.Scope;
import com.lrx.spring.process.BeanPostProcess;
import com.lrx.spring.process.InitializingBean;
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
 * {@code @date} 2025/3/8 上午11:25
 */
public class LrxSpringApplicatinContext {

    private Class configClass;
    private ConcurrentHashMap<String, Object> singletonObject
            = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap
            = new ConcurrentHashMap<>();

    private List<BeanPostProcess>
    beanPostProcessList = new ArrayList<>();

    public LrxSpringApplicatinContext(Class configClass) {
        this.configClass = configClass;
        //System.out.println("configClass = " + this.configClass);
        beanDefinitionByScan(configClass);

        Enumeration<String> keys = beanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            String beanName = keys.nextElement();
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().equalsIgnoreCase("singleton")) {

                Object bean = createBean(beanName,beanDefinition);
                singletonObject.put(beanName,bean);
            }

        }

        System.out.println(singletonObject);
        System.out.println(beanDefinitionMap);

    }
    public void beanDefinitionByScan(Class configClass) {
        ComponentScan componentScan
                = (ComponentScan) this.configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value();
        System.out.println("path:" + path);

        path = path.replace(".", "/");
        ClassLoader classLoader = LrxSpringApplicatinContext.class.getClassLoader();
        URI resource = null;
        try {
            resource = classLoader.getResource(path).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        File file = new File(resource.getPath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                // System.out.println("file:"+file1.getAbsolutePath());
                String absolutePath = file1.getAbsolutePath();


                if (absolutePath.endsWith(".class")) {
                    //得到类名
                    String className = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
                    //System.out.println("className:"+className);
                    //得到全类名
                    String classFullName = path.replace("/", ".") + "." + className;
                    System.out.println(classFullName);


                    try {

                        Class<?> aClass = classLoader.loadClass(classFullName);
                        if (aClass.isAnnotationPresent(Component.class)) {

                            if(BeanPostProcess.class.isAssignableFrom(aClass) ) {
                                beanPostProcessList.add((BeanPostProcess) aClass.newInstance());
                                continue;
                            }
                            System.out.println("是bean" + aClass + " " + className);

                            Component componentA = aClass.getDeclaredAnnotation(Component.class);
                            String beanName = componentA.value();
                            if ("".equals(beanName)) {

                                beanName = StringUtils.uncapitalize(className);
                            }
                            BeanDefinition beanDefinition = new BeanDefinition();
                            if (aClass.isAnnotationPresent(Scope.class)) {
                                beanDefinition.setScope(aClass.getAnnotation(Scope.class).value());

                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinition.setClazz(aClass);


                            beanDefinitionMap.put(beanName, beanDefinition);

//                                Class<?> clazz = Class.forName(classFullName);
//                                Object bean = clazz.newInstance();
//
//                                ioc.put(className,bean);
                        } else {
                            System.out.println("不是bean");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }

    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
                return singletonObject.get(beanName);
            } else {
                return createBean(beanName,beanDefinition);
            }

        }else {
            throw new RuntimeException("没有bean");
        }
    }

    public Object createBean(String beanName,BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();


        try {
            Object instance = clazz.getConstructor().newInstance();
//            for(Field filed : clazz.getDeclaredFields()){
//                if(filed.isAnnotationPresent(Autowired.class)){
//                    String name = filed.getName();
//                    Object bean = getBean(name);
//
//                    filed.setAccessible(true);
//                    filed.set(instance,bean);
//
//
//                }
//            }
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    String name = declaredField.getName();
                    Object bean = getBean(name);
                    declaredField.setAccessible(true);
                    declaredField.set(instance, bean);
                }

            }

            for (BeanPostProcess beanPostProcess : beanPostProcessList) {
                Object current = beanPostProcess.processBeforeInitialization(instance, beanName);
                if(current != null){
                    instance = current;

                }



            }

            System.out.println("创建好bean" + instance);
            if(instance instanceof InitializingBean) {
                try {
                    ((InitializingBean)instance).afterPropertiesSet();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            for (BeanPostProcess beanPostProcess : beanPostProcessList) {
                Object current = beanPostProcess.processAfterInitialization(instance, beanName);
                if (current != null) {
                    instance = current;
                }


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
}




