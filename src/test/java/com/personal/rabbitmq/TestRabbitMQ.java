package com.personal.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 袁强
 * @data 2020/10/18 18:19
 * @Description
 * springboot 提供 RabbitTemplate 模板来简化操作rabbit,一旦配置好配置文件,spring boot项目构建的时候会自动创建该模板对象,所以使用的时候直接在项目中注入该模板对象即可使用
 */
@SpringBootTest(classes = RabbitmqSpringBootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * rabbitmq第一种模型:provider---queue---consumer
     * 参数1:队列名称
     * 参数2:消息体
     * 注意!!!spring boot集成rabbitmq,队列和交换机的创建不是由生产者控制的,而已由消费者控制,当消费者启动的时候,如果该队列或交换机不存在那么就会创建
     */
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    /**
     * rabbitmq第二种模型:provider---queue---consumer1/consumer2/...
     * 参数1:队列名称
     * 参数2:消息体
     *
     */
    @Test
    public void testWorkQueue(){
        for (int i =1 ; i<= 10 ; i++){
            rabbitTemplate.convertAndSend("work","workQueue工作队列模型"+i);
        }
    }

    /**
     * rabbitmq第三种模型:provider---exchange---consumer1/consumer2/...
     * 参数1:交换机名称
     * 参数2:广播模型的队列无意义
     * 参数3:消息体
     *
     */
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","publish/subscribe 广播模型");
    }
}
