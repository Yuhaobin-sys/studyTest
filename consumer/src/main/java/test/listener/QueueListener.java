package test.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import test.config.RabbitMQConfig;

@Component
public class QueueListener {

    @RabbitListener(queues = RabbitMQConfig.queue2)
    public void receiveMessage(String message){
        System.out.println("queue2接到消息："+message);
    }

    @RabbitListener(queues = RabbitMQConfig.queue5)
    public void receiveMessage5(String message){
        System.out.println("queue5接到消息："+message);
    }

    @RabbitListener(queues = RabbitMQConfig.queue6)
    public void receiveMessage6(String message){
        System.out.println("queue6接到消息："+message);
    }
}
