package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/ITTNetHandler.class */
public interface ITTNetHandler {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/ITTNetHandler$DefaultTTNetHandler.class */
    public static class DefaultTTNetHandler implements ITTNetHandler {
        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public IDownloadHeadHttpService getTTNetDownloadHeadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public IDownloadHttpService getTTNetDownloadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isResponseCode304Error(Throwable th) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isTTNetEnable() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public DownloadTTNetException translateTTNetException(Throwable th, String str) {
            return null;
        }
    }

    IDownloadHeadHttpService getTTNetDownloadHeadHttpService();

    IDownloadHttpService getTTNetDownloadHttpService();

    boolean isResponseCode304Error(Throwable th);

    boolean isTTNetEnable();

    DownloadTTNetException translateTTNetException(Throwable th, String str);
}
