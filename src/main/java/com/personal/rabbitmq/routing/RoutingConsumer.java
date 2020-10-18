package com.personal.rabbitmq.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 袁强
 * @data 2020/10/18 21:53
 * @Description
 */
@Component
public class RoutingConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), //指定交换机
                    key = {"infos","errors","warns"}  //指定routingKey
            )
    })
    public void receiveConsumer1(String message){
        System.out.println("consumer1: " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), //指定交换机
                    key = {"infos","errors"}  //指定routingKey
            )
    })
    public void receiveConsumer2(String message){
        System.out.println("consumer2: " + message);
    }
}
