package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.jb;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ww.class */
public class ww {
    private static volatile ww mb;
    private final ko b;
    private com.ss.android.downloadad.api.ox h;
    private final com.ss.android.downloadad.api.mb hj;
    private final com.ss.android.download.api.mb ox;
    private long u;

    private ww(Context context) {
        this.b = ko.mb();
        this.ox = new h();
        this.u = System.currentTimeMillis();
        ox(context);
        this.hj = mb.mb();
    }

    public static ww mb(final Context context) {
        if (mb == null) {
            synchronized (ww.class) {
                try {
                    if (mb == null) {
                        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ww unused = ww.mb = new ww(Context.this);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    private void ox(Context context) {
        x.mb(context);
        Downloader.getInstance(x.getContext());
        com.ss.android.downloadlib.addownload.model.u.mb().ox();
        com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), "misc_config", new com.ss.android.downloadlib.b.ko(), new com.ss.android.downloadlib.b.u(context), new b());
        com.ss.android.downloadlib.b.hj hjVar = new com.ss.android.downloadlib.b.hj();
        com.ss.android.socialbase.appdownloader.hj.x().mb(hjVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(hjVar);
        com.ss.android.socialbase.appdownloader.hj.x().mb(new jb());
        DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.b.h());
        com.ss.android.socialbase.appdownloader.hj.x().mb(com.ss.android.downloadlib.hj.b.mb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ko ww() {
        return this.b;
    }

    public void b() {
        this.u = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.ox h() {
        if (this.h == null) {
            this.h = ox.mb();
        }
        return this.h;
    }

    public com.ss.android.downloadad.api.mb hj() {
        return this.hj;
    }

    public void ko() {
        hj.mb().h();
    }

    public com.ss.android.download.api.mb mb() {
        return this.ox;
    }

    public com.ss.android.download.api.mb mb(String str) {
        com.ss.android.download.api.config.u ox = u.mb().ox();
        return (ox == null || !ox.mb(str)) ? this.ox : ox.ox(str);
    }

    public void mb(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.4
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public void mb(com.ss.android.download.api.download.mb.mb mbVar) {
        ww().mb(mbVar);
    }

    public void mb(final String str, final int i) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.2
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, i);
            }
        });
    }

    public void mb(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.6
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    public void mb(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.7
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    public void mb(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.5
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    public void mb(final String str, final boolean z) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.3
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, z);
            }
        });
    }

    public long ox() {
        return this.u;
    }

    public DownloadInfo ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), str);
    }

    public String u() {
        return x.nk();
    }
}
