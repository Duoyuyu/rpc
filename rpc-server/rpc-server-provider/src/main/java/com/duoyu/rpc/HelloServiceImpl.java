package com.duoyu.rpc;

/**
 * @Description
 * @Author wangxc
 * @Date 2021/8/19
 */
public class HelloServiceImpl implements HelloService{
    // 要将服务暴露出去
    @Override
    public String sayHello(String name) {
        return "receive hello:" + name;
    }
}
