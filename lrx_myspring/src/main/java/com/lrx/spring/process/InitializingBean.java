package com.lrx.spring.process;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午2:12
 */

public interface InitializingBean {
   void afterPropertiesSet() throws Exception;
}
