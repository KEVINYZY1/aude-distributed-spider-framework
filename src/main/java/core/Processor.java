package core;

import mq.MessageQueue;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/16.
 * <p>
 * 解析器的接口.解析器用于提取关键信息,使用jsoup或者正则表达式完成任务
 */
public interface Processor {

    /**
     * 处理下载下来的页面源码
     *
     * @param page HTML源代码
     * @param map  提供把消息发送到各个消息队列的方法
     * @throws IOException
     */
    public void process(Object page, Map<String, MessageQueue> map) throws IOException;
}
