package core;

import mq.MessageQueue;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/16.
 */
public interface FreeStaff {
    public void doSomething(String key, String msg, Map<String, MessageQueue> map) throws IOException;
}
