package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/data/AppDownloadInfo.class */
public class AppDownloadInfo {
    private String appName;
    private String packageName;
    private int progress;
    private int reserveStatus;
    private String reservedPkgName;
    private String status;

    public AppDownloadInfo(AppInfo appInfo, int i) {
        if (appInfo != null) {
            this.packageName = appInfo.Code();
            this.appName = appInfo.L();
        }
        this.progress = i;
    }

    public AppDownloadInfo(AppInfo appInfo, k kVar) {
        if (appInfo != null) {
            this.packageName = appInfo.Code();
            this.appName = appInfo.L();
        }
        if (kVar != null) {
            this.status = kVar.toString();
        }
    }

    public AppDownloadInfo(String str) {
        this.packageName = str;
    }

    public AppDownloadInfo(String str, int i) {
        this.reservedPkgName = str;
        this.reserveStatus = i;
    }
}
