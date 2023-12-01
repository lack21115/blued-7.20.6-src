package com.huawei.openalliance.ad.download.app;

import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/RemoteAppDownloadTask.class */
public class RemoteAppDownloadTask {
    private int apiVer;
    private String contentId;
    private long downloadedSize;
    private long fileTotalSize;
    private int pauseReason;
    private int progress;
    private String sha256;
    private String slotId;
    private int status;
    private String templateId;
    private String url;

    public long B() {
        return this.fileTotalSize;
    }

    public String C() {
        return this.sha256;
    }

    public AppDownloadTask Code(AppInfo appInfo) {
        AppDownloadTask appDownloadTask = new AppDownloadTask();
        appDownloadTask.Code(appInfo);
        appDownloadTask.C(this.contentId);
        appDownloadTask.I(this.progress);
        appDownloadTask.Code(this.status);
        appDownloadTask.V(this.downloadedSize);
        appDownloadTask.Code(this.fileTotalSize);
        appDownloadTask.Code(this.url);
        appDownloadTask.V(this.sha256);
        appDownloadTask.Z(this.slotId);
        appDownloadTask.Z(this.pauseReason);
        appDownloadTask.a(this.templateId);
        appDownloadTask.C(this.apiVer);
        return appDownloadTask;
    }

    public String Code() {
        return this.slotId;
    }

    public void Code(int i) {
        this.status = i;
    }

    public void Code(long j) {
        this.fileTotalSize = j;
    }

    public void Code(String str) {
        this.slotId = str;
    }

    public int D() {
        return this.pauseReason;
    }

    public long F() {
        return this.downloadedSize;
    }

    public int I() {
        return this.status;
    }

    public void I(int i) {
        this.pauseReason = i;
    }

    public void I(String str) {
        this.sha256 = str;
    }

    public String S() {
        return this.url;
    }

    public String V() {
        return this.contentId;
    }

    public void V(int i) {
        this.progress = i;
    }

    public void V(long j) {
        this.downloadedSize = j;
    }

    public void V(String str) {
        this.contentId = str;
    }

    public int Z() {
        return this.progress;
    }

    public void Z(String str) {
        this.url = str;
    }
}
