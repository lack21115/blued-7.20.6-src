package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.igexin.push.config.c;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ww.class */
public class ww {
    private long b;
    private SoftReference<JumpUnknownSourceActivity> h;
    private long hj;
    private Runnable ko;
    private final Queue<Integer> mb;
    private boolean ox;
    private Handler u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ww$mb.class */
    public static class mb {
        private static final ww mb = new ww();
    }

    private ww() {
        this.mb = new ArrayDeque();
        this.ox = false;
        this.u = new Handler(Looper.getMainLooper());
        this.ko = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.1
            @Override // java.lang.Runnable
            public void run() {
                ww.this.b();
            }
        };
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.appdownloader.ww.2
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (ww.this.mb.isEmpty()) {
                    return;
                }
                long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", c.l);
                long currentTimeMillis = System.currentTimeMillis() - ww.this.hj;
                if (currentTimeMillis < optLong) {
                    if (ww.this.u.hasCallbacks(ww.this.ko)) {
                        return;
                    }
                    ww.this.u.postDelayed(ww.this.ko, optLong - currentTimeMillis);
                    return;
                }
                ww.this.hj = System.currentTimeMillis();
                ww.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.mb) {
                poll = this.mb.poll();
            }
            this.u.removeCallbacks(this.ko);
            if (poll == null) {
                this.ox = false;
                return;
            }
            final Context appContext = DownloadComponentManager.getAppContext();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.u.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ww.this.ox(appContext, poll.intValue(), false);
                    }
                });
            } else {
                ox(appContext, poll.intValue(), false);
            }
            this.u.postDelayed(this.ko, 20000L);
        }
    }

    private boolean hj() {
        return System.currentTimeMillis() - this.b < 1000;
    }

    public static ww mb() {
        return mb.mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ox(Context context, int i, boolean z) {
        int ox = b.ox(context, i, z);
        if (ox == 1) {
            this.ox = true;
        }
        this.b = System.currentTimeMillis();
        return ox;
    }

    public int mb(final Context context, final int i, final boolean z) {
        if (z) {
            return ox(context, i, z);
        }
        if (hj()) {
            this.u.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.4
                @Override // java.lang.Runnable
                public void run() {
                    ww.this.mb(context, i, z);
                }
            }, 1000L);
            return 1;
        } else if (AppStatusManager.getInstance().isAppForeground()) {
            Logger.i("leaves", "on Foreground");
            return ox(context, i, z);
        } else if (ox.mb()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.mb.isEmpty() && !this.ox && z2) {
                return ox(context, i, z);
            }
            int optInt = DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
            synchronized (this.mb) {
                while (this.mb.size() > optInt) {
                    this.mb.poll();
                }
            }
            if (z2) {
                this.u.removeCallbacks(this.ko);
                this.u.postDelayed(this.ko, DownloadSetting.obtain(i).optLong("install_queue_timeout", 20000L));
            }
            synchronized (this.mb) {
                if (!this.mb.contains(Integer.valueOf(i))) {
                    this.mb.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    public void mb(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.h = new SoftReference<>(jumpUnknownSourceActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        b();
    }

    public JumpUnknownSourceActivity ox() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.h;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.h = null;
        return jumpUnknownSourceActivity;
    }
}
