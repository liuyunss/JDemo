package com.jdemo.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description Server-sent events
 *  由客户端发起建立的使用HTTP协议，单向通道，
 *  数据只能由服务端发送给客户端，服务端响应的
 *  是 text/event-stream 的数据流。
 *  优:
 *      自动重新连接，事件ID，发送任意事件
*   缺：
 *      只能由服务端发送给客户端，只能发送文本
 *      消息，不能发送二进制数据
 * @Date 2023/8/22 11:06
 */
@RestController
@Slf4j
@RequestMapping("/sse")
public class SSEController {

    //可有用 Multimap 替换，做到多客户端订阅场景
    private static Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 创建连接
     *
     * @date: 2022/7/12 14:51
     */
    @GetMapping(path = "sse/{userId}")
    public SseEmitter connect(@PathVariable String userId) {
        try {
            // 设置超时时间，0表示不过期。默认30秒
            SseEmitter sseEmitter = new SseEmitter(0L);
            // 注册回调
//            sseEmitter.onCompletion(completionCallBack(userId));
            sseEmitter.onCompletion(() ->{
                System.out.println("注册成功");
            });
//            sseEmitter.onError(errorCallBack(userId));
            sseEmitter.onTimeout(() -> {
                System.out.println("超时，过期");
            });
            sseEmitterMap.put(userId, sseEmitter);
            return sseEmitter;
        } catch (Exception e) {
            log.info("创建新的sse连接异常，当前用户：{}", userId);
        }
        return null;
    }

    /**
     * 给指定用户发送消息
     *
     * @date: 2022/7/12 14:51
     */
    @GetMapping(path = "watch/{userId}/{message}")
    public static void sendMessage(@PathVariable String userId,@PathVariable String message) {

        if (sseEmitterMap.containsKey(userId)) {
            try {
                sseEmitterMap.get(userId).send(message);
            } catch (IOException e) {
                log.error("用户[{}]推送异常:{}", userId, e.getMessage());
//                removeUser(userId);
            }
        }
    }

}
