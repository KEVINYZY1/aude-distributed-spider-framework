package core;

import mq.MessageQueue;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/16.
 *
 * 数据持久化的接口
 */
public interface Saver {

    /**
     * 处理最终解析得到的结果
     * @param result 消息队列推送过来的结果消息
     * @param map
     * @throws IOException
     */
    public void save(Object result, Map<String, MessageQueue> map) throws IOException;
}
