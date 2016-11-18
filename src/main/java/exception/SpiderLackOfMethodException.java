package exception;

/**
 * Created by lrkin on 2016/11/18.
 */
public class SpiderLackOfMethodException extends Exception {
    public SpiderLackOfMethodException(String method) {
        super("Spider lack of "+method+"method!");
    }
}
