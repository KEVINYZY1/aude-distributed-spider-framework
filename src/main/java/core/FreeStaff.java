package core;

import mq.MessageQueue;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/16.
 */
public interface FreeStaff {
    /**
     * 自定义的处理函数
     * @param key 自定义的消息标记
     * @param msg 消息队列推送的消息
     * @param map
     * @throws IOException
     */
    public void doSomething(String key, Object msg, Map<String, MessageQueue> map) throws IOException;
}
