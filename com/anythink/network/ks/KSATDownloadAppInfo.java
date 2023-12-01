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

    public String getAppDownloadCount() {
        return this.appDownloadCount;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
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
