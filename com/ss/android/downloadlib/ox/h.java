package com.ss.android.downloadlib.ox;

import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/h.class */
public class h implements AppStatusManager.AppStatusChangeListener {
    private long mb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/h$mb.class */
    public static class mb {
        private static h mb = new h();
    }

    private h() {
        this.mb = 0L;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static h mb() {
        return mb.mb;
    }

    public void mb(hj hjVar) {
        mb(hjVar, 5000L);
    }

    public void mb(final hj hjVar, final long j) {
        if (hjVar == null) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - h.this.mb <= j) {
                    hjVar.mb(true);
                } else {
                    hjVar.mb(false);
                }
            }
        }, j);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.mb = System.currentTimeMillis();
    }

    public void ox(hj hjVar) {
        if (hjVar == null) {
            return;
        }
        int i = 1200;
        int optInt = com.ss.android.downloadlib.addownload.x.lz().optInt("check_an_result_delay", 1200);
        if (optInt > 0) {
            i = optInt;
        }
        mb(hjVar, i);
    }
}
