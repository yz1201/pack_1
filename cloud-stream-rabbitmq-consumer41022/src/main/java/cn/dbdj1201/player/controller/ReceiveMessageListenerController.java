package cn.dbdj1201.player.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yz1201
 * @date 2020-07-19 14:48
 **/
@Slf4j
@EnableBinding(Sink.class)
@Component
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者2号，------》接收到的消息：" + message.getPayload() + "\t port: " + serverPort);
    }

}
