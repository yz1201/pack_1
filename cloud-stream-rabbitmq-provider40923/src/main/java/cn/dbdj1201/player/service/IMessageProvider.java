package cn.dbdj1201.player.service;

import org.springframework.cloud.stream.annotation.Input;

/**
 * @author yz1201
 * @date 2020-07-19 11:49
 **/
public interface IMessageProvider {
    public String send();
}
