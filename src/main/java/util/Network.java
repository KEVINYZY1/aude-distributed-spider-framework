package util;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by lrkin on 2016/11/18.
 * <p>
 * 使用的是apache的httpClient
 */
public class Network {
    private String agent = null;
    private String cookie = null;
    private int timeout = 10000;
    private String proxy = null;

    public static Network create() {
        return new Network();
    }

    /**
     * 设置下载传输参数
     **/
    public Network setUserAgent(String s) {
        this.agent = s;
        return this;
    }

    public Network setCookie(String c) {
        this.cookie = c;
        return this;
    }

    public Network setTimeout(int t) {
        this.timeout = t;
        return this;
    }

    public Network setProxy(String p) {
        this.proxy = p;
        return this;
    }

    /**
     * 下载网页
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String downloader(String url) throws ClientProtocolException, IOException {
        String res = "";
        Request request = Request.Get(url).connectTimeout(this.timeout);
        if (this.agent != null) {
            request = request.userAgent(this.agent);
        }
        if (this.cookie != null) {
            request = request.addHeader("Cookie", this.cookie);
        }
        if (this.proxy != null) {
            request = request.viaProxy(this.proxy);
        }
        res = request.execute().returnContent().asString();
        return res;
    }
}
