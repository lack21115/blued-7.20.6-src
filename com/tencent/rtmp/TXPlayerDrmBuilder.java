package com.tencent.rtmp;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXPlayerDrmBuilder.class */
public class TXPlayerDrmBuilder {
    private static final String DEFAULT_PROVISION_URL = "https://www.googleapis.com/certificateprovisioning/v1/devicecertificates/create?key=AIzaSyB-5OLKTx2iU5mko18DfdwK5611JIjbUhE";
    String mKeyLicenseUrl;
    String mPlayUrl;
    String mProvisionUrl;

    public TXPlayerDrmBuilder() {
        this.mProvisionUrl = DEFAULT_PROVISION_URL;
    }

    public TXPlayerDrmBuilder(String str, String str2, String str3) {
        this.mProvisionUrl = DEFAULT_PROVISION_URL;
        this.mProvisionUrl = str;
        this.mKeyLicenseUrl = str2;
        this.mPlayUrl = str3;
    }

    public String getKeyLicenseUrl() {
        return this.mKeyLicenseUrl;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public String getProvisionUrl() {
        return this.mProvisionUrl;
    }

    public TXPlayerDrmBuilder setKeyLicenseUrl(String str) {
        this.mKeyLicenseUrl = str;
        return this;
    }

    public TXPlayerDrmBuilder setPlayUrl(String str) {
        this.mPlayUrl = str;
        return this;
    }

    public TXPlayerDrmBuilder setProvisionUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mProvisionUrl = DEFAULT_PROVISION_URL;
            return this;
        }
        this.mProvisionUrl = str;
        return this;
    }

    public String toString() {
        return "TXPlayerDrmBuilder{provisionUrl='" + this.mProvisionUrl + "', licenseUrl='" + this.mKeyLicenseUrl + "', playUrl='" + this.mPlayUrl + "'}";
    }
}
