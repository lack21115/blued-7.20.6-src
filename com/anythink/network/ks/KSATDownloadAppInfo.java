package com.anythink.network.ks;

import com.anythink.core.api.ATAdAppInfo;
import com.kwad.sdk.api.KsNativeAd;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATDownloadAppInfo.class */
public class KSATDownloadAppInfo extends ATAdAppInfo {
    public String appDownloadCount;
    public String appName;
    public String appPackageName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String publisher;

    public KSATDownloadAppInfo(KsNativeAd ksNativeAd) {
        this.publisher = ksNativeAd.getCorporationName();
        this.appVersion = ksNativeAd.getAppVersion();
        this.appPrivacyLink = ksNativeAd.getAppPrivacyUrl();
        this.apppermissionLink = ksNativeAd.getPermissionInfoUrl();
        this.appName = ksNativeAd.getAppName();
        this.appSize = ksNativeAd.getAppPackageSize();
        this.appPackageName = ksNativeAd.getAppPackageName();
        this.appDownloadCount = ksNativeAd.getAppDownloadCountDes();
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppDownloadCount() {
        return this.appDownloadCount;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return this.appPackageName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getPublisher() {
        return this.publisher;
    }
}
