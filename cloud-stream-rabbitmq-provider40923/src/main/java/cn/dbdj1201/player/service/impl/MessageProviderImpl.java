package cn.dbdj1201.player.service.impl;

import cn.dbdj1201.player.service.IMessageProvider;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-19 11:51
 **/
@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    //消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("***serial: " + serial + "***");
//        return null;
        return serial;
    }
}
