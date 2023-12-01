package com.anythink.network.baidu;

import com.anythink.core.api.ATAdAppInfo;
import com.baidu.mobads.sdk.api.NativeResponse;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATDownloadAppInfo.class */
public class BaiduATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPackageName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String publisher;

    public BaiduATDownloadAppInfo(NativeResponse nativeResponse) {
        this.publisher = nativeResponse.getPublisher();
        this.appVersion = nativeResponse.getAppVersion();
        this.appPrivacyLink = nativeResponse.getAppPrivacyLink();
        this.apppermissionLink = nativeResponse.getAppPermissionLink();
        this.appSize = nativeResponse.getAppSize();
        this.appName = nativeResponse.getTitle();
        this.appPackageName = nativeResponse.getAppPackage();
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
