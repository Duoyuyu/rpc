package com.duoyu.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author wangxc
 * @Date 2021/8/19
 */
public class RpcProxyServer {

    /**
     *
     * @param service 发布服务
     * @param port  端口
     */
    public void publisher(Object service, int port){

        // 线程池，一个客户端链接交给一个线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // BIO（阻塞IO）
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){ // 不断监听客户端链接
                // 当没有客户端链接，accept链接会阻塞
                Socket socket = serverSocket.accept();// 等待连接
                // IO阻塞|建立链接，没有数据传输过来也会阻塞
                // 一个客户端链接交给一个线程，提高处理链接数量
                executorService.execute(new ProcessHandlerThread(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
