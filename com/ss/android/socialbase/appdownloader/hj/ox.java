package com.ss.android.socialbase.appdownloader.hj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.b.ko;
import com.ss.android.socialbase.appdownloader.hj;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/hj/ox.class */
public class ox implements IDownloadLaunchHandler {
    private List<Integer> mb;
    private BroadcastReceiver ox;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mb(android.content.Context r10, com.ss.android.socialbase.downloader.model.DownloadInfo r11, boolean r12, int r13) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.hj.ox.mb(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void mb(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.appdownloader.h.mb mbVar;
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        int optInt = obtain.optInt("paused_resume_max_count", 0);
        double optDouble = obtain.optDouble("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < optInt && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < optDouble * 3600000.0d) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                mbVar = new com.ss.android.socialbase.appdownloader.h.mb(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                DownloadNotificationManager.getInstance().addNotification(mbVar);
            } else {
                notificationItem.updateNotificationItem(downloadInfo);
                mbVar = notificationItem;
            }
            mbVar.setTotalBytes(downloadInfo.getTotalBytes());
            mbVar.setCurBytes(downloadInfo.getCurBytes());
            mbVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ko je = hj.x().je();
        if (je != null) {
            je.mb(list);
        }
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean isWifi = DownloadUtils.isWifi(appContext);
        for (DownloadInfo downloadInfo : list) {
            mb(appContext, downloadInfo, isWifi, i);
        }
        List<Integer> list2 = this.mb;
        if (list2 == null || list2.isEmpty() || this.ox != null) {
            return;
        }
        this.ox = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (DownloadUtils.isWifi(applicationContext)) {
                    Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                    DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ox.this.mb == null || ox.this.mb.isEmpty()) {
                                    return;
                                }
                                int size = ox.this.mb.size();
                                Integer[] numArr = new Integer[size];
                                ox.this.mb.toArray(numArr);
                                ox.this.mb.clear();
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= size) {
                                        return;
                                    }
                                    DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i3].intValue());
                                    if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                        ox.this.mb(applicationContext, downloadInfo2, true, 2);
                                    }
                                    i2 = i3 + 1;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(ox.this.ox);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    ox.this.ox = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(this.ox, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.ox = null;
        }
    }

    private boolean mb(DownloadInfo downloadInfo) {
        return DownloadSetting.obtain(downloadInfo.getId()).optBugFix("uninstall_can_not_resume_for_force_task", false) ? DownloadUtils.isFileDownloaded(downloadInfo, false, downloadInfo.getMd5()) : downloadInfo.isDownloaded();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public List<String> getResumeMimeTypes() {
        return b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(final List<DownloadInfo> list, final int i) {
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ox.this.mb(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            mb(list, i);
        }
    }
}
