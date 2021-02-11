package in.dreamplug.userservice.exception;

/**
 * @author sidhant.aggarwal
 * @since 12/01/2020
 */
public class WebException extends RuntimeException {
    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    public WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WebException() {
    }

    public String toString() {
        return "WebException()";
    }
}