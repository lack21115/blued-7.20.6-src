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

    public String getAppDownloadCount() {
        return "";
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
