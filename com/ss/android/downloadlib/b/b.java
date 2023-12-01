package com.ss.android.downloadlib.b;

import com.ss.android.download.api.config.nk;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/b.class */
public class b implements IDownloadCompleteHandler {
    private File mb(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        nk x = x.x();
        if (downloadInfo == null || x == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File mb = mb(packageName, targetFilePath);
        com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        x.mb(packageName, targetFilePath, mb, mb2 != null ? jb.mb(mb2.ko()) : null);
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(mb.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.b.ox.mb(DownloadSetting.obtain(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }
}
