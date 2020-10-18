package com.personal.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 袁强
 * @data 2020/10/18 21:15
 * @Description
 *  @RabbitListener 该注解还可以加在方法上,一个方法表示一个消费者,如果方法上加了该注解,则会处理当前方法监听的队列的回调函数,所以不必再加@RabbitHandler注解表示当前方法为回调函数
 */
@Component
public class WorkQueueConsumer {

    //消费者1
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void receiveConsumer1(String message){
        System.out.println("消费者1消费的消息为: " + message);
    }
    //消费者2
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void receiveConsumer2(String message){
        System.out.println("消费者2消费的消息为: " + message);
    }
}
