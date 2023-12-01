package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/b.class */
public class b {
    private static String mb = b.class.getSimpleName();
    private static volatile b ox;
    private ConcurrentHashMap<Long, Runnable> b;

    public b() {
        this.b = null;
        this.b = new ConcurrentHashMap<>();
    }

    public static b mb() {
        if (ox == null) {
            synchronized (b.class) {
                try {
                    if (ox == null) {
                        ox = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    private void mb(long j, boolean z, int i) {
        AdEventHandler.mb().mb(j, z, i);
        if (z) {
            x.gm().mb(null, null, null, null, null, 3);
        }
    }

    public static boolean mb(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }

    public void mb(final h hVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.ox.h.mb().mb(new com.ss.android.downloadlib.ox.hj() { // from class: com.ss.android.downloadlib.addownload.b.1
            @Override // com.ss.android.downloadlib.ox.hj
            public void mb(boolean z) {
                b.this.mb(hVar, z, i, downloadModel);
            }
        }, ox());
    }

    public void mb(h hVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (z) {
                mb(id, true, 2);
                return;
            }
            mb(id, false, 2);
            hVar.ox(false);
        } else if (i == 5) {
            if (z) {
                mb(id, true, 1);
                return;
            }
            mb(id, false, 1);
            hVar.b(false);
        } else if (i != 7) {
        } else {
            Runnable remove = this.b.remove(Long.valueOf(id));
            if (z) {
                AdEventHandler.mb().mb(id, 1);
                mb(id, true, 1);
                return;
            }
            if (remove != null) {
                com.ss.android.downloadlib.ko.mb().ox().post(remove);
            }
            mb(id, false, 1);
        }
    }

    public long ox() {
        return x.lz().optLong("quick_app_check_internal", 1200L);
    }
}
