package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/hj.class */
public class hj {
    private ScheduledExecutorService b;
    private ExecutorService mb;
    private ExecutorService ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/hj$mb.class */
    public static class mb {
        private static hj mb = new hj();
    }

    private hj() {
    }

    public static hj mb() {
        return mb.mb;
    }

    public ExecutorService b() {
        if (this.ox == null) {
            synchronized (hj.class) {
                try {
                    if (this.ox == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.ox = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new DefaultThreadFactory(ww.class.getName() + "-IOThreadPool"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.ox;
    }

    public void h() {
        mb(new Runnable() { // from class: com.ss.android.downloadlib.hj.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (hj.class) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        try {
                            if (i2 >= 13) {
                                break;
                            }
                            try {
                                SharedPreferences sharedPreferences = x.getContext().getSharedPreferences(new String[]{"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"}[i2], 0);
                                if (sharedPreferences != null) {
                                    sharedPreferences.edit().clear().apply();
                                }
                                i = i2 + 1;
                            } catch (Throwable th) {
                            }
                        } finally {
                        }
                    }
                    IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
                    if (downloadCache instanceof DefaultDownloadCache) {
                        SparseArray<DownloadInfo> downloadInfoMap = ((DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                        int size = downloadInfoMap.size();
                        while (true) {
                            int i3 = size - 1;
                            if (i3 < 0) {
                                break;
                            }
                            DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(i3));
                            if (downloadInfo != null) {
                                Downloader.getInstance(x.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                            size = i3;
                        }
                    }
                }
            }
        });
    }

    public ScheduledExecutorService hj() {
        if (this.b == null) {
            synchronized (hj.class) {
                try {
                    if (this.b == null) {
                        this.b = new ScheduledThreadPoolExecutor(0, new DefaultThreadFactory(ww.class.getName() + "-ScheduledThreadPool"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    public void mb(Runnable runnable) {
        mb(runnable, false);
    }

    public void mb(Runnable runnable, long j) {
        try {
            hj().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void mb(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || jb.mb()) {
            ox().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public ExecutorService ox() {
        if (this.mb == null) {
            synchronized (hj.class) {
                try {
                    if (this.mb == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.mb = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new DefaultThreadFactory(ww.class.getName() + "-CPUThreadPool"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.mb;
    }

    public void ox(Runnable runnable) {
        ox(runnable, false);
    }

    public void ox(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || jb.mb()) {
            b().execute(runnable);
        } else {
            runnable.run();
        }
    }
}
