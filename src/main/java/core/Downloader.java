package core;

import mq.MessageQueue;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lrkin on 2016/11/16.
 */
public interface Downloader {
    public void download(Object url, Map<String, MessageQueue> map) throws IOException;
}
