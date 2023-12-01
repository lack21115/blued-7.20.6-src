package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DownloadProxy.class */
public class DownloadProxy {
    private static volatile IDownloadProxy downloadIndependentProxy;
    private static volatile IDownloadProxy downloadProxy;

    public static IDownloadProxy get(boolean z) {
        if (z && DownloadComponentManager.supportMultiProc()) {
            if (downloadIndependentProxy == null) {
                synchronized (DownloadProxy.class) {
                    try {
                        if (downloadIndependentProxy == null) {
                            downloadIndependentProxy = DownloadComponentManager.getIndependentHolderCreator().createProxy();
                        }
                    } finally {
                    }
                }
            }
            return downloadIndependentProxy;
        }
        if (downloadProxy == null) {
            synchronized (DownloadProxy.class) {
                try {
                    if (downloadProxy == null) {
                        downloadProxy = new ProcessDownloadHandler();
                    }
                } finally {
                }
            }
        }
        return downloadProxy;
    }
}
