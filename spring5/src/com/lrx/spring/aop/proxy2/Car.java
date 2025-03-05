package com.lrx.spring.aop.proxy2;

import org.junit.jupiter.api.Test;

/**
 * @author lrx
 * {@code @date} 2025/3/4 下午10:29
 */
public class Car implements Vehicle{

    @Override
    public void run() {
        System.out.println("汽车");
    }
    @Test
    public void proxyRun() {
        Vehicle car = new Car();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(car);
        Vehicle proxy = vehicleProxyProvider.getProxy();
        proxy.run();

    }
}
