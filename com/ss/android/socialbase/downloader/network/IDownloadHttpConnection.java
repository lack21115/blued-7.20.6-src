package com.ss.android.socialbase.downloader.network;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/IDownloadHttpConnection.class */
public interface IDownloadHttpConnection extends IDownloadHeadHttpConnection {
    void end();

    InputStream getInputStream() throws IOException;
}
