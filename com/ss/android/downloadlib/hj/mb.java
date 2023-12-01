package com.ss.android.downloadlib.hj;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.ox.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/hj/mb.class */
public class mb implements x {
    /* JADX INFO: Access modifiers changed from: private */
    public void ox(DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox mb = u.mb().mb(downloadInfo);
        boolean mb2 = com.ss.android.downloadlib.ox.u.mb(mb);
        boolean ox = com.ss.android.downloadlib.ox.u.ox(mb);
        if (mb2 && ox) {
            com.ss.android.downloadlib.ox.b.mb(mb, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.3
                @Override // com.ss.android.downloadlib.guide.install.mb
                public void mb() {
                    mbVar.mb();
                }
            });
        } else {
            mbVar.mb();
        }
    }

    public void mb(final DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox mb = u.mb().mb(downloadInfo);
        if (mb == null || !lz.mb(mb)) {
            ox(downloadInfo, mbVar);
        } else {
            TTDelegateActivity.mb(mb, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.2
                @Override // com.ss.android.downloadlib.guide.install.mb
                public void mb() {
                    mb.this.ox(downloadInfo, mbVar);
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, final com.ss.android.socialbase.appdownloader.b.lz lzVar) {
        mb(downloadInfo, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.1
            @Override // com.ss.android.downloadlib.guide.install.mb
            public void mb() {
                lzVar.mb();
            }
        });
    }
}
