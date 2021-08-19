package com.duoyu.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author wangxc
 * @Date 2021/8/19
 */
public class RpcClientProxy {
    public <T> T clientProxy(final Class<T> interfaceClass, String host, int port){
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new RemoteInvocationHandler(host, port));
    }
}
