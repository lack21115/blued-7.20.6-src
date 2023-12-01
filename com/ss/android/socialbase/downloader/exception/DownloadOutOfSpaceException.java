package com.ss.android.socialbase.downloader.exception;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/exception/DownloadOutOfSpaceException.class */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.avaliableSpaceBytes = j;
        this.requiredSpaceBytes = j2;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
