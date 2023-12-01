package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/notification/AbsNotificationItem.class */
public abstract class AbsNotificationItem {
    private int clickInstallTimes;
    private long curBytes;
    private String description;
    private long firstShowTime;
    private int id;
    protected Notification notification;
    private boolean ongoing;
    private int status = 0;
    private String title;
    private long totalBytes;

    public AbsNotificationItem(int i, String str) {
        this.id = i;
        this.title = str;
    }

    public void cancel() {
        if (this.id == 0) {
            return;
        }
        DownloadNotificationManager.getInstance().cancel(this.id);
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public String getDescription() {
        return this.description;
    }

    public long getFirstShowTime() {
        if (this.firstShowTime == 0) {
            this.firstShowTime = System.currentTimeMillis();
        }
        return this.firstShowTime;
    }

    public int getId() {
        return this.id;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void notify(Notification notification) {
        if (this.id == 0 || notification == null) {
            return;
        }
        DownloadNotificationManager.getInstance().notifyByService(this.id, this.status, notification);
    }

    public void recordClickInstall() {
        synchronized (this) {
            this.clickInstallTimes++;
        }
    }

    public void refreshProgress(long j, long j2) {
        this.curBytes = j;
        this.totalBytes = j2;
        this.status = 4;
        updateNotification(null, false);
    }

    public void refreshStatus(int i, BaseException baseException, boolean z) {
        refreshStatus(i, baseException, z, false);
    }

    public void refreshStatus(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.status != i) {
            this.status = i;
            updateNotification(baseException, z);
        }
    }

    public void setCurBytes(long j) {
        this.curBytes = j;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOngoing(boolean z) {
        this.ongoing = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public abstract void updateNotification(BaseException baseException, boolean z);

    public void updateNotificationItem(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
    }
}
