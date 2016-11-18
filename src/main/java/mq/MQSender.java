package mq;

import com.google.gson.Gson;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lrkin on 2016/11/18.
 */
public class MQSender extends MQClient implements MessageQueue {
    private Gson gson = new Gson();

    public MQSender(String host, int port, String queue_name) throws IOException, TimeoutException {
        super(host, port, queue_name);
    }

    public void send(MQItem item) throws IOException {
        channel.basicPublish("", this.queueName, MessageProperties.PERSISTENT_TEXT_PLAIN
                , gson.toJson(item).getBytes());
    }

    public void sendUrl(Object url) throws IOException {
        send(new MQItem("url", url));
    }

    public void sendPage(Object page) throws IOException {
        send(new MQItem("page", page));
    }

    public void sendResult(Object result) throws IOException {
        send(new MQItem("result", result));
    }

    public void send(String key, Object msg) throws IOException {
        send(new MQItem(key, msg));
    }
}
