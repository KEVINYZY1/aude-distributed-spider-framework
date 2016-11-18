package mq;

import java.io.IOException;

/**
 * Created by lrkin on 2016/11/18.
 * 一个MQ的功能的接口
 */
public interface MessageQueue {
    public void sendUrl(Object url) throws IOException;

    public void sendPage(Object page) throws IOException;

    public void sendResult(Object result) throws IOException;

    public void send(String key, Object msg) throws IOException;
}
