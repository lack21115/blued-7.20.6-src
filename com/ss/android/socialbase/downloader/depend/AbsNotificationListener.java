package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/AbsNotificationListener.class */
public abstract class AbsNotificationListener extends AbsDownloadListener implements IDownloadExtListener {
    private void addNotificationItem(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
        if (notificationItem != null) {
            notificationItem.updateNotificationItem(downloadInfo);
            return;
        }
        DownloadNotificationManager.getInstance().addNotification(createNotificationItem());
    }

    private void updateNotification(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
        AbsNotificationItem absNotificationItem = notificationItem;
        if (notificationItem == null) {
            absNotificationItem = createNotificationItem();
        }
        absNotificationItem.setTotalBytes(downloadInfo.getTotalBytes());
        if (i == -3) {
            absNotificationItem.setCurBytes(downloadInfo.getTotalBytes());
        } else {
            absNotificationItem.setCurBytes(downloadInfo.getCurBytes());
        }
        absNotificationItem.refreshStatus(i, baseException, z);
    }

    private void updateNotificationProgress(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            AbsNotificationItem absNotificationItem = notificationItem;
            if (notificationItem == null) {
                absNotificationItem = createNotificationItem();
            }
            absNotificationItem.refreshProgress(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    protected abstract AbsNotificationItem createNotificationItem();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        updateNotification(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        updateNotification(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        addNotificationItem(downloadInfo);
        updateNotification(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        updateNotificationProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        updateNotification(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        updateNotification(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        updateNotification(11, downloadInfo, null, true);
    }
}
