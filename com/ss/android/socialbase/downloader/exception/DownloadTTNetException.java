package com.ss.android.socialbase.downloader.exception;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/exception/DownloadTTNetException.class */
public class DownloadTTNetException extends BaseException {
    public DownloadTTNetException(int i, String str) {
        super(i, str);
    }

    public DownloadTTNetException(int i, Throwable th) {
        super(i, th);
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public DownloadTTNetException setRequestLog(String str) {
        setExtraInfo(str);
        return this;
    }
}
