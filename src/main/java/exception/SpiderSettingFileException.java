package exception;

/**
 * Created by lrkin on 2016/11/18.
 */
public class SpiderSettingFileException extends Exception{
    public SpiderSettingFileException() {
        super("Spider's setting file is wrong! Please check it out!");
    }
}
