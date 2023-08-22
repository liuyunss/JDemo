package com.jdemo.tcp;

import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2023/7/28.
 */
public class TcpClient {
    public static void main(String[] args)throws Exception{
        // 创建客户端的Socket服务，指定目的主机和端口。
        Socket s=new Socket("127.0.0.1",10003);

        // 为了发送数据，应该获取Socket流中的输出流。
        OutputStream out=s.getOutputStream();

        out.write("Tcp Dmeo...".getBytes());

        s.close();
    }
}
