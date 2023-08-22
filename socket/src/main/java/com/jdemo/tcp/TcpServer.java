package com.jdemo.tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2023/7/28.
 */
public class TcpServer {
    public static void  main(String[] args)throws Exception{
        // 建立服务端Socket服务，并监听一个端口。
        ServerSocket ss=new ServerSocket(10003);
        // 通过accept()方法获取连接过来的客户端对象。
        Socket s=ss.accept();

        String ip=s.getInetAddress().getHostAddress();
        System.out.println(ip+" is connected");

        // 获取客户端发送过来的数据，那么套使用客户端对象的读取流来读取数据。
        InputStream in=s.getInputStream();

        byte[] buf=new byte[1024];
        int len=in.read(buf);

        System.out.println(new String(buf,0,len));

        s.close();	// 关闭客户端。
        ss.close();	//	关闭服务器。

    }
}
