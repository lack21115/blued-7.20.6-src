package com.anythink.network.toutiao;

import com.anythink.core.api.ATAdAppInfo;
import com.bytedance.sdk.openadsdk.ComplianceInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATDownloadAppInfo.class */
public class TTATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String publisher;

    public TTATDownloadAppInfo(ComplianceInfo complianceInfo, long j) {
        this.appPrivacyLink = complianceInfo.getPrivacyUrl();
        this.appName = complianceInfo.getAppName();
        this.publisher = complianceInfo.getDeveloperName();
        this.appVersion = complianceInfo.getAppVersion();
        this.appSize = j;
    }

    public String getAppDownloadCount() {
        return "";
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return "";
    }

    public String getAppPermissonUrl() {
        return "";
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
