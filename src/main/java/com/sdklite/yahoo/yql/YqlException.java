package com.sdklite.yahoo.yql;

/**
 * @author johnsonlee
 */
public class YqlException extends Exception {

    private static final long serialVersionUID = -1106246509009248567L;

    public YqlException() {
        super();
    }

    public YqlException(String message, Throwable cause) {
        super(message, cause);
    }

    public YqlException(String message) {
        super(message);
    }

    public YqlException(Throwable cause) {
        super(cause);
    }

}
