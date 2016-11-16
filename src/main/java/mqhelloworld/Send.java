package mqhelloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lrkin on 2016/11/16.
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();//工厂模式拿到connection
        Channel channel = connection.createChannel();//拿到channel

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);//幂等地声明队列
        String message = "HELLO WORLD!!!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));//用channel发送消息(因为重要的api都在channel里面)
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();//关闭隧道
        connection.close();//关闭和rabbitmq的server
    }
}
