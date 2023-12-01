package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/DownloadParams.class */
public class DownloadParams extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -4966891183505507851L;
    public boolean downloadEnablePause = false;
    public int downloadPlace = 1;
    public String filePath;
    public String mAppIcon;
    public String mAppName;
    public long mAppSize;
    public String mDownloadid;
    public String mFileMd5;
    public String mFileUrl;
    public String mPkgname;
    public String mShortDesc;
    public int mTaskId;
    public String mVersion;
    public String mVersionCode;
    public boolean requestInstallPermission;

    public static DownloadParams transform(AdInfo adInfo) {
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.mDownloadid = adInfo.downloadId;
        downloadParams.mAppName = adInfo.adBaseInfo.appName;
        downloadParams.mPkgname = adInfo.adBaseInfo.appPackageName;
        downloadParams.mFileUrl = adInfo.adConversionInfo.appDownloadUrl;
        downloadParams.mAppIcon = adInfo.adBaseInfo.appIconUrl;
        downloadParams.mShortDesc = adInfo.adBaseInfo.adDescription;
        downloadParams.downloadEnablePause = adInfo.downloadSafeInfo != null && adInfo.downloadSafeInfo.downloadPauseEnable;
        return downloadParams;
    }
}
