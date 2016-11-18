package mq;

import com.google.gson.Gson;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lrkin on 2016/11/18.
 */
public class MQReceiver extends MQClient {
    private QueueingConsumer consumer;
    private Gson gson = new Gson();

    public MQReceiver(String host, int port, String queue_name, int qos) throws IOException, TimeoutException {
        super(host, port, queue_name);
        channel.basicQos(qos);
        consumer = new QueueingConsumer(channel);
        channel.basicConsume(queue_name, false, consumer);
    }

    public MQItem recv() throws InterruptedException, IOException {
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
        MQItem item = gson.fromJson(new String(delivery.getBody()), MQItem.class);
        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        return item;
    }

}
