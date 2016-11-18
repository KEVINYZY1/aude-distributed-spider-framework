package util;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import mq.MQItem;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * Created by lrkin on 2016/11/18.
 * <p>
 * 注意,这个类比较重要,但是看名字又比较难理解
 * <p>
 * 这个类的作用是:在程序开始的时候,在MQ里面发送第一条URL,用作初始值.这样"才能展开后续工作"
 */
public class FirstMsgSender {
    private ConnectionFactory factory = new ConnectionFactory();
    private Connection connection;
    private Channel channel;
    private String queueName;
    private Gson gson = new Gson();
    private Logger logger = Logger.getLogger("firstMsgSender");

    public FirstMsgSender(String host, int port, String queueName) throws IOException, TimeoutException {
        super();
        factory.setHost(host);
        factory.setPort(port);
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
        this.queueName = queueName;
    }

    public static FirstMsgSender create(String host, int port, String queueName) throws IOException, TimeoutException {
        return new FirstMsgSender(host, port, queueName);
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }

    public FirstMsgSender add(String key, Object msg) throws IOException {
        channel.basicPublish("", this.queueName, MessageProperties.PERSISTENT_TEXT_PLAIN
                , gson.toJson(new MQItem(key, msg)).getBytes());
        logger.info("first add finish!");
        return this;
    }

    public FirstMsgSender addUrl(Object url) throws IOException {
        return add("url", url);
    }

    public FirstMsgSender addPage(Object page) throws IOException {
        return add("page", page);
    }

    public FirstMsgSender addResult(Object result) throws IOException {
        return add("result", result);
    }


}
