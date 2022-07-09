package com.example.live.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置
 * 1、@ServerEndpoint("/api/pushMessage/{userId}") 前端通过此 URI 和后端交互，建立连接
 * 2、@Component 不用说将此类交给 spring 管理
 * 3、@OnOpen websocket 建立连接的注解，前端触发上面 URI 时会进入此注解标注的方法
 * 4、@OnMessage 收到前端传来的消息后执行的方法
 * 5、@OnClose 顾名思义关闭连接，销毁 session
 * 6、因为WebSocket是类似客户端服务端的形式(采用ws协议)，那么这里的WebSocketServer其实就相当于一个ws协议的Controller
 * 7、新建一个ConcurrentHashMap webSocketMap 用于接收当前userId的WebSocket，方便IM之间对userId进行推送消息
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/9 16:26
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
