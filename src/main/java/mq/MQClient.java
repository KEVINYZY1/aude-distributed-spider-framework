package mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lrkin on 2016/11/18.
 * <p>
 * 这个类是把RabbitMQ略繁琐的队列声明给封装了一下,成了一个client对象
 */
public class MQClient {
    protected ConnectionFactory factory = new ConnectionFactory();
    protected Connection connection;
    protected Channel channel;
    protected String queueName;

    public MQClient(String host, int port, String queue_name) throws IOException, TimeoutException {
        factory.setHost(host);
        factory.setPort(port);
        this.queueName = queue_name;
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queue_name, true, false, false, null);
    }
}


