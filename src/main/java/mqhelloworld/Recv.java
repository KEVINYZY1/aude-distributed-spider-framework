package mqhelloworld;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by lrkin on 2016/11/16.
 */
public class Recv {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
    }
}
