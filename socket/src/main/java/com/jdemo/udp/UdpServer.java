package com.jdemo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by Administrator on 2023/7/28.
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        // 1.创建服务器端：注册端口
        DatagramSocket socket = new DatagramSocket(3333);

        // 2.创建一个数据包对象接收客户端发送的数据
        // 创建字节数组，指定接收的数据包的大小
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 3.服务器启动成功，输出提示信息
        System.out.println("****服务器端启动成功****");

        // 4.通过循环不停的向客户接收数据
        new Thread(() -> {
            while (true) {
                try {
                    // 4.1 等待接收数据,此方法在接收到数据报之前会一直阻塞
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 4.2 读取数据
                int len = packet.getLength();
                String rs = new String(buf, 0, len);
                System.out.println("收到了ip为：" + packet.getAddress() + " 端口号为：" + packet.getPort() + "的消息：" + rs);
            }
        }).start();

        final InetAddress[] address = {null};
        final int[] port = {0};
        final boolean[] flag = {false};
        // 5.向客户端发送信息
        new Thread(() -> {
            while (true) {
                if (!flag[0]) {
                    // 5.1 定义客户端的地址、端口号、数据
                    address[0] = packet.getAddress();//获取发送端的地址
                    port[0] = packet.getPort();//获取 发送端进程所绑定的端口
                    flag[0] = true;
                }
                System.out.println("请输入：");
                // 5.2 从键盘接受数据
                Scanner scanner = new Scanner(System.in);
                //nextLine方式接受字符串
                String msg = scanner.nextLine();
                // 5.3 创建一个数据包对象封装数据
                byte[] buffer = msg.getBytes();
                // 5.4 创建数据报，包含响应的数据信息
                DatagramPacket packets = new DatagramPacket(buffer, buffer.length, address[0], port[0]);
                try {
                    // 5.5 发送数据给客户端
                    socket.send(packets);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
