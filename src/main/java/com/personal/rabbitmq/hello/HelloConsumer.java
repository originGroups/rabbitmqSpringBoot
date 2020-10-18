package com.personal.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 袁强
 * @data 2020/10/18 20:53
 * @Description
 */
@Component //组件,保证被springFactory工厂扫描到
//rabbitmq消费者监听,并指定监听哪个队列的消息,queuesToDeclare申明队列,不存在则创建,@Queue用于定义队列的属性:队列名/是否持久化/是否独占/是否自动删除
@RabbitListener(queuesToDeclare = @Queue(value="hello",durable = "false",exclusive = "false",autoDelete = "true"))
public class HelloConsumer {

    //消费消息,方法名任意
    @RabbitHandler  //表示接受信息后的回调函数,该回调函数用于处理消息的业务逻辑
    public void receiveMessage(String message){
        System.out.println("message: " + message);
    }
}
