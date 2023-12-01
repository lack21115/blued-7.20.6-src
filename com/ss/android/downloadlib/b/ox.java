package com.ss.android.downloadlib.b;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/ox.class */
public class ox implements IDownloadCompleteHandler {
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo mb = com.ss.android.socialbase.appdownloader.b.mb(x.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (mb != null) {
            downloadInfo.setAppVersionCode(mb.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.utils.hj.ox() && downloadInfo.getPackageInfo() == null;
    }
}
