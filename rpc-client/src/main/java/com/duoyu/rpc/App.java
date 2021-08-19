package com.duoyu.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        // helloService是一个动态代理类，先实现动态代理
        HelloService helloService = rpcClientProxy.clientProxy(HelloService.class, "localhost", 8080);
        // 网络通讯调用
        String msg = helloService.sayHello("duoyu");
        System.out.println( msg );
    }
}
