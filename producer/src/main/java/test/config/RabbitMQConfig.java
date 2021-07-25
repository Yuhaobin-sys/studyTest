package test.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public static final String exchange1 = "exchange1";

    public static final String exchange3 = "exchange3";

    public static final String queue1 = "queue1";
    public static final String queue2 = "queue2";

    public static final String queue5 = "queue5";
    public static final String queue6 = "queue6";

    //路由key
    public static final String add = "add";
    //路由key
    public static final String delete = "delete";

    //声明路由交换机
    //durable参数是是否持久化，默认为true
    @Bean(exchange1)
    public Exchange exchange1(){
        return ExchangeBuilder.directExchange(exchange1).durable(true).build();
    }

    //申明通配符交换机
    @Bean(exchange3)
    public Exchange exchange3(){
        return ExchangeBuilder.topicExchange(exchange3).durable(true).build();
    }

    //声明队列
    @Bean(queue1)
    public Queue queue1(){ return new Queue(queue1); }
    @Bean(queue2)
    public Queue queue2(){return new Queue(queue2); }

    @Bean(queue5)
    public Queue queue5(){return new Queue(queue5); }
    @Bean(queue6)
    public Queue queue6(){return new Queue(queue6); }

    //队列绑定交换机1
    @Bean
    public Binding bindingQueue2(@Qualifier(queue2) Queue queue, @Qualifier(exchange1) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(add).noargs();
    }
    @Bean
    public Binding bindingQueue1(@Qualifier(queue1) Queue queue, @Qualifier(exchange1) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(delete).noargs();
    }

    //队列绑定交换机3
    //*（星号）：可以（只能）匹配一个单词
    //#（井号）：可以匹配多个单词（或者零个）
    @Bean
    public Binding bindingQueue5(@Qualifier(queue5) Queue queue, @Qualifier(exchange3) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#").noargs();
    }
    @Bean
    public Binding bindingQueue6(@Qualifier(queue6) Queue queue, @Qualifier(exchange3) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#").noargs();
    }

}
