package com.ss.android.socialbase.downloader.exception;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/exception/DownloadFileExistException.class */
public class DownloadFileExistException extends BaseException {
    private String existTargetFileName;

    public DownloadFileExistException(String str) {
        this.existTargetFileName = str;
    }

    public String getExistTargetFileName() {
        return this.existTargetFileName;
    }
}
