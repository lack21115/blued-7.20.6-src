package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/b/u.class */
public class u {
    private static u mb;
    private List<hj> ox;

    private u() {
        ArrayList arrayList = new ArrayList();
        this.ox = arrayList;
        arrayList.add(new h());
        this.ox.add(new ko());
        this.ox.add(new ox());
        this.ox.add(new mb());
    }

    public static u mb() {
        if (mb == null) {
            synchronized (u.class) {
                try {
                    if (mb == null) {
                        mb = new u();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar, int i, b bVar) {
        List<hj> list = this.ox;
        if (list == null || list.size() == 0 || oxVar == null) {
            bVar.mb(oxVar);
            return;
        }
        DownloadInfo ox = ww.mb((Context) null).ox(oxVar.mb());
        if (ox == null || !AdBaseConstants.MIME_APK.equals(ox.getMimeType())) {
            bVar.mb(oxVar);
            return;
        }
        boolean z = DownloadSetting.obtain(oxVar.m()).optInt("pause_optimise_switch", 0) == 1;
        for (hj hjVar : this.ox) {
            if (z || (hjVar instanceof ko)) {
                if (hjVar.mb(oxVar, i, bVar)) {
                    return;
                }
            }
        }
        bVar.mb(oxVar);
    }
}
