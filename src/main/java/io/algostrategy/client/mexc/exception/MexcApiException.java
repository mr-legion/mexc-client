package io.algostrategy.client.mexc.exception;

import io.algostrategy.client.mexc.MexcApiError;

/**
 * An exception which can occur while invoking methods of the Mexc API.
 */
public class MexcApiException extends RuntimeException {

    private static final long serialVersionUID = -2909492920308202303L;

    private MexcApiError error;

    public MexcApiException(MexcApiError error) {
        this.error = error;
    }

    public MexcApiException() {
        super();
    }

    public MexcApiException(String message) {
        super(message);
    }

    public MexcApiException(Throwable cause) {
        super(cause);
    }

    public MexcApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Mexc API.
     */
    public MexcApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
