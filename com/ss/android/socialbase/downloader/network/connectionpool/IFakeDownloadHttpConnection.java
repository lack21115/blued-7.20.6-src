package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/IFakeDownloadHttpConnection.class */
public interface IFakeDownloadHttpConnection {
    void execute() throws Exception;

    boolean isRequesting();

    boolean isSuccessful();

    boolean isValid();

    void joinExecute() throws InterruptedException;
}
