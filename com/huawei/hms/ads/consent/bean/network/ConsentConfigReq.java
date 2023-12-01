package com.huawei.hms.ads.consent.bean.network;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/network/ConsentConfigReq.class */
public class ConsentConfigReq {
    private String consentVersion;
    private String countryCode;
    private Integer debugFlag;
    private String langCode;
    private String pkgName;

    public String getConsentVersion() {
        return this.consentVersion;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Integer getDebugFlag() {
        return this.debugFlag;
    }

    public String getLangCode() {
        return this.langCode;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setConsentVersion(String str) {
        this.consentVersion = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setDebugFlag(Integer num) {
        this.debugFlag = num;
    }

    public void setLangCode(String str) {
        this.langCode = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }
}
