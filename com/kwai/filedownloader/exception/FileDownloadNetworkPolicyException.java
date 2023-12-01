package com.kwai.filedownloader.exception;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/exception/FileDownloadNetworkPolicyException.class */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
