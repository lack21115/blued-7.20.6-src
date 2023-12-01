package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/IDownloadHttpService.class */
public interface IDownloadHttpService {
    IDownloadHttpConnection downloadWithConnection(int i, String str, List<HttpHeader> list) throws IOException;
}
