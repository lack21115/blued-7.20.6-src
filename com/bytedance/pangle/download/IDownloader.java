package com.bytedance.pangle.download;

import android.content.Context;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/download/IDownloader.class */
public interface IDownloader {
    void downloader(Context context, String str, String str2, boolean z, String str3, int i, String str4, List<String> list, IZeusDownloadListener iZeusDownloadListener, IZeusDownloadInterceptor iZeusDownloadInterceptor);
}
