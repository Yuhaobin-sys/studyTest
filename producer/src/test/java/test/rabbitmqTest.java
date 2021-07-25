package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest()
@RunWith(SpringRunner.class)
public class rabbitmqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testConfirm(){
        rabbitTemplate.convertAndSend("exchange3","asd","hello topic");
    }

    @Test
    public void testReturn(){
        rabbitTemplate.convertAndSend("exchange1","asd","hello message");
    }
}
