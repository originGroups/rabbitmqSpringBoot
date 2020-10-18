package com.personal.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 袁强
 * @data 2020/10/18 22:06
 * @Description
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(name = "topics",type = "topic"), //指定交换机
                    key = {"user.save","user.*","#.user.#"} //通配符"*"只匹配一个单词,"#"匹配一个或多个单词,单词之间使用"."分割
            )
    })
    public void receiveConsumer1(String message){
        System.out.println("consumer1: " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(name = "topics",type = "topic"), //指定交换机
                    key = {"order.#","produce.*"}  //通配符"*"只匹配一个单词,"#"匹配一个或多个单词,单词之间使用"."分割
            )
    })
    public void receiveConsumer2(String message){
        System.out.println("consumer2: " + message);
    }
}
