package com.huawei.hms.ads;

import com.huawei.hms.ads.AppDownloadButton;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/IAppDownloadButton.class */
public interface IAppDownloadButton {
    void cancel();

    void continueDownload();

    AppDownloadStatus refreshAppStatus();

    void setAllowedNonWifiNetwork(boolean z);

    void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle);

    void setOnDownloadStatusChangedListener(AppDownloadButton.OnDownloadStatusChangedListener onDownloadStatusChangedListener);

    void setOnNonWifiDownloadListener(AppDownloadButton.OnNonWifiDownloadListener onNonWifiDownloadListener);

    void setShowPermissionDialog(boolean z);
}
