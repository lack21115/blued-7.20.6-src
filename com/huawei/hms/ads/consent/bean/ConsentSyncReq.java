package com.huawei.hms.ads.consent.bean;

import com.huawei.openalliance.ad.annotations.a;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/ConsentSyncReq.class */
public class ConsentSyncReq {
    @a
    private String accessToken;
    private List<String> adProviderIds;
    private int consentStatus;
    @a
    private String deviceId;
    private int deviceIdType;
    private String pkgName;
    private String sdkversion;
    private Long timestamp;

    public ConsentSyncReq(List<String> list, int i, String str) {
        this.adProviderIds = list;
        this.consentStatus = i;
        this.pkgName = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<String> getAdProviderIds() {
        return this.adProviderIds;
    }

    public int getConsentStatus() {
        return this.consentStatus;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceIdType() {
        return this.deviceIdType;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSdkversion() {
        return this.sdkversion;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAdProviderIds(List<String> list) {
        this.adProviderIds = list;
    }

    public void setConsentStatus(int i) {
        this.consentStatus = i;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceIdType(int i) {
        this.deviceIdType = i;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setSdkversion(String str) {
        this.sdkversion = str;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }
}
