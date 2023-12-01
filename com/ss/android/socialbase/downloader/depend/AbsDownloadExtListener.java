package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/AbsDownloadExtListener.class */
public abstract class AbsDownloadExtListener extends AbsDownloadListener implements IDownloadExtListener {
    private static final String TAG = AbsDownloadExtListener.class.getSimpleName();

    public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Logger.d(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
