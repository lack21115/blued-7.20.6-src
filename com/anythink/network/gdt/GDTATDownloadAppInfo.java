package com.anythink.network.gdt;

import com.anythink.core.api.ATAdAppInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATDownloadAppInfo.class */
public class GDTATDownloadAppInfo extends ATAdAppInfo {
    public String appDownloadCount;
    public String appName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String publisher;

    public GDTATDownloadAppInfo(NativeUnifiedADAppMiitInfo nativeUnifiedADAppMiitInfo, String str) {
        this.publisher = nativeUnifiedADAppMiitInfo.getAuthorName();
        this.appVersion = nativeUnifiedADAppMiitInfo.getVersionName();
        this.appPrivacyLink = nativeUnifiedADAppMiitInfo.getPrivacyAgreement();
        this.apppermissionLink = nativeUnifiedADAppMiitInfo.getPermissionsUrl();
        this.appName = nativeUnifiedADAppMiitInfo.getAppName();
        this.appSize = nativeUnifiedADAppMiitInfo.getPackageSizeBytes();
        this.appDownloadCount = str;
    }

    public String getAppDownloadCount() {
        return this.appDownloadCount;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return "";
    }

    public String getAppPermissonUrl() {
        return this.apppermissionLink;
    }

    public String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    public long getAppSize() {
        return this.appSize;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getPublisher() {
        return this.publisher;
    }
}
