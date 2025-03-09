package com.lrx.spring01.proxy;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午2:12
 */

public interface InitializingBean {
   void afterPropertiesSet() throws Exception;
}
