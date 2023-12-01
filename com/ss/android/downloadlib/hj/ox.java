package com.ss.android.downloadlib.hj;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.socialbase.appdownloader.b.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/hj/ox.class */
public class ox implements x {
    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, lz lzVar) {
        com.ss.android.downloadad.api.mb.ox mb;
        if (downloadInfo != null && (mb = u.mb().mb(downloadInfo)) != null) {
            downloadInfo.setLinkMode(mb.yr());
        }
        if (lzVar != null) {
            lzVar.mb();
        }
    }
}
