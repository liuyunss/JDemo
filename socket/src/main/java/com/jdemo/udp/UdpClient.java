package com.jdemo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
/**
 * Created by Administrator on 2023/7/28.
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        // 1.定义服务器的地址、端口号、数据
        InetAddress address = InetAddress.getByName("localhost");
        // 2.定义服务器端口
        int port = 3333;

        // 3.创建发送端对象：发送端自带默认端口号
        DatagramSocket socket = new DatagramSocket(2222);

        // 4.客户端启动成功，输出提示信息
        System.out.println("****客户端启动成功****");

        // 5.向服务端发送信息
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("请输入：");
                    // 5.1 从键盘接受数据
                    Scanner sc = new Scanner(System.in);
                    // 5.2 nextLine方式接受字符串
                    String msg = sc.nextLine();
                    // 5.3 创建一个数据包对象封装数据
                    byte[] buffer = msg.getBytes();
                    DatagramPacket packets = new DatagramPacket(buffer, buffer.length, address, port);
                    // 5.4 发送数据出去
                    socket.send(packets);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // 6.通过循环不停的向服务器接收数据
        new Thread(() -> {
            try {
                while (true) {
                    // 6.1 创建一个数据包对象接收数据
                    byte[] buf = new byte[1024 * 64];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    // 6.2 接收服务器响应的数据
                    socket.receive(packet);
                    // 6.3 取出数据
                    int len = packet.getLength();
                    String rs = new String(buf, 0, len);
                    System.out.println("收到了ip为：" + packet.getAddress() + " 端口号为：" + packet.getPort() + "的消息：" + rs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
