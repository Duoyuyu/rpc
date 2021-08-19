package com.duoyu.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Description
 * @Author wangxc
 * @Date 2021/8/19
 */
public class ProcessHandlerThread implements Runnable{
    Socket socket;
    Object service;

    public ProcessHandlerThread(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        // 数据通讯的处理
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())){
            RpcRequest request = (RpcRequest)inputStream.readObject();
            Object invoke = invoke(request);
            outputStream.writeObject(invoke);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName(request.getClassName());
        Method method = aClass.getMethod(request.getMethodName(), request.getTypes());
        return method.invoke(service, request.getParams());
    }
}
