package com.ss.android.socialbase.downloader.network;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/IDownloadHeadHttpConnection.class */
public interface IDownloadHeadHttpConnection {
    void cancel();

    int getResponseCode() throws IOException;

    String getResponseHeaderField(String str);
}
