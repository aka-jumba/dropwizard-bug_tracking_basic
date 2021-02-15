package in.dreamplug.userservice.exception;

import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.WebServiceException;


public class AppException extends WebServiceException {
    private String errorCode;
    private Integer statusCode;
    private String message;
    private String header;
    private Map<String, Object> information = new HashMap();

    public AppException(String errorCode, Integer statusCode, String message, String header, Map<String, Object> information) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.message = message;
        this.header = header;
        this.information = information;
    }

    public static AppException.AppExceptionBuilder builder() {
        return new AppException.AppExceptionBuilder();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getHeader() {
        return this.header;
    }

    public Map<String, Object> getInformation() {
        return this.information;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setInformation(Map<String, Object> information) {
        this.information = information;
    }

    public AppException() {
    }

    public String toString() {
        return "AppException(errorCode=" + this.getErrorCode() + ", statusCode=" + this.getStatusCode() + ", message=" + this.getMessage() + ", header=" + this.getHeader() + ", information=" + this.getInformation() + ")";
    }

    public static class AppExceptionBuilder {
        private String errorCode;
        private Integer statusCode;
        private String message;
        private String header;
        private Map<String, Object> information;

        AppExceptionBuilder() {
        }

        public AppException.AppExceptionBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public AppException.AppExceptionBuilder statusCode(Integer statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public AppException.AppExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public AppException.AppExceptionBuilder header(String header) {
            this.header = header;
            return this;
        }

        public AppException.AppExceptionBuilder information(Map<String, Object> information) {
            this.information = information;
            return this;
        }

        public AppException build() {
            return new AppException(this.errorCode, this.statusCode, this.message, this.header, this.information);
        }

        public String toString() {
            return "AppException.AppExceptionBuilder(errorCode=" + this.errorCode + ", statusCode=" + this.statusCode + ", message=" + this.message + ", header=" + this.header + ", information=" + this.information + ")";
        }
    }
}
