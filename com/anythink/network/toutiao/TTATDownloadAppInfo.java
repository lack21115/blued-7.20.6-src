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

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppDownloadCount() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return "";
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
