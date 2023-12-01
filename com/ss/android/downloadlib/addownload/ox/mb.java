package com.ss.android.downloadlib.addownload.ox;

import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ox/mb.class */
public class mb implements IDownloadDiskSpaceHandler {
    private int mb;

    private void mb() {
        com.ss.android.download.api.config.h lc = x.lc();
        if (lc != null) {
            lc.mb();
        }
        b.mb();
        b.ox();
    }

    private void mb(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(this.mb);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.mb.mb().mb(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean mb(DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - hj.mb().ox() >= downloadSetting.optLong("clear_space_min_time_interval", 600000L);
    }

    private long ox(DownloadSetting downloadSetting) {
        long optLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (optLong <= 0) {
            return 0L;
        }
        long j = optLong;
        if (optLong > 5000) {
            j = 5000;
        }
        com.ss.android.downloadlib.utils.x.ox("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + j, null);
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.utils.x.ox("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j, long j2, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        long j3;
        DownloadSetting obtain = DownloadSetting.obtain(this.mb);
        if (mb(obtain)) {
            long currentTimeMillis = System.currentTimeMillis();
            hj.mb().b();
            long mb = jb.mb(0L);
            mb();
            long mb2 = jb.mb(0L);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (mb2 < j2) {
                j3 = ox(obtain);
                if (j3 > 0) {
                    mb2 = jb.mb(0L);
                }
            } else {
                j3 = 0;
            }
            com.ss.android.downloadlib.utils.x.ox("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + mb2 + ", cleaned = " + (mb2 - mb), null);
            mb(mb, mb2, j2, currentTimeMillis2 - currentTimeMillis, j3);
            if (mb2 < j2) {
                return false;
            }
            if (iDownloadDiskSpaceCallback != null) {
                iDownloadDiskSpaceCallback.onDiskCleaned();
                return true;
            }
            return true;
        }
        return false;
    }

    public void mb(int i) {
        this.mb = i;
    }
}
