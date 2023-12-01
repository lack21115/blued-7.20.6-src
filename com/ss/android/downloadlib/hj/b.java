package com.ss.android.downloadlib.hj;

import com.ss.android.socialbase.appdownloader.b.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/hj/b.class */
public class b implements x {
    private static volatile b mb;
    private List<x> ox;

    private b() {
        ArrayList arrayList = new ArrayList();
        this.ox = arrayList;
        arrayList.add(new ox());
        this.ox.add(new mb());
    }

    public static b mb() {
        if (mb == null) {
            synchronized (b.class) {
                try {
                    if (mb == null) {
                        mb = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(final DownloadInfo downloadInfo, final int i, final lz lzVar) {
        if (i == this.ox.size() || i < 0) {
            lzVar.mb();
        } else {
            this.ox.get(i).mb(downloadInfo, new lz() { // from class: com.ss.android.downloadlib.hj.b.1
                @Override // com.ss.android.socialbase.appdownloader.b.lz
                public void mb() {
                    b.this.mb(downloadInfo, i + 1, lzVar);
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, lz lzVar) {
        if (downloadInfo != null && this.ox.size() != 0) {
            mb(downloadInfo, 0, lzVar);
        } else if (lzVar != null) {
            lzVar.mb();
        }
    }
}
