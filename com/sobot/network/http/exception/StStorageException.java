package com.sobot.network.http.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/exception/StStorageException.class */
public class StStorageException extends Exception {
    private static final long serialVersionUID = 178946465;

    public StStorageException() {
    }

    public StStorageException(String str) {
        super(str);
    }

    public StStorageException(String str, Throwable th) {
        super(str, th);
    }

    public StStorageException(Throwable th) {
        super(th);
    }

    public static StStorageException NOT_AVAILABLE() {
        return new StStorageException("SDCard isn't available, please check SD card and permission: WRITE_EXTERNAL_STORAGE, and you must pay attention to Android6.0 RunTime Permissions!");
    }
}
