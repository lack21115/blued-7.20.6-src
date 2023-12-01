package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/lz.class */
public class lz {
    public static int mb(int i, int i2) {
        return (i2 <= 0 || i2 >= 100) ? i2 : !mb(i) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long mb(int i, long j, long j2) {
        if (mb(i)) {
            if (j <= 0) {
                return 0L;
            }
            return j2 <= 0 ? j : (j2 * mb(i, (int) ((j * 100) / j2))) / 100;
        }
        return j;
    }

    public static DownloadShortInfo mb(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null) {
            if (!mb((int) downloadShortInfo.id)) {
                return downloadShortInfo;
            }
            downloadShortInfo.currentBytes = mb((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean mb(int i) {
        boolean z = false;
        if (DownloadSetting.obtain(i).optInt("pause_optimise_pretend_download_percent_switch", 0) == 1) {
            z = false;
            if (DownloadSetting.obtain(i).optInt("pause_optimise_switch", 0) == 1) {
                z = true;
            }
        }
        return z;
    }
}
