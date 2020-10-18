package com.personal.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 袁强
 * @data 2020/10/18 21:31
 * @Description 广播模型[发布/订阅] publish/subscribe
 */
@Component
public class FanoutConsumer {

    //bindings属性用于绑定队列和交换机
    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue, //@Queue如果没有指定value,则表示创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout") //绑定的交换机类型为fanout,交换机名称为logs
            )
    })
    public void receiveConsumer1(String message){
        System.out.println("consumer1: " + message);
    }

    //bindings属性用于绑定队列和交换机
    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue, //@Queue如果没有指定value,则表示创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout") //绑定的交换机类型为fanout,交换机名称为logs
            )
    })
    public void receiveConsumer2(String message){
        System.out.println("consumer2: " + message);
    }
}
