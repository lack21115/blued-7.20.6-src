package com.huawei.hms.ads.consent.bean;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/AdProvider.class */
public class AdProvider {
    private String id;
    private String name;
    private String serviceArea = "";
    private String privacyPolicyUrl = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdProvider adProvider = (AdProvider) obj;
        return this.id.equals(adProvider.id) && this.name.equals(adProvider.name) && this.serviceArea.equals(adProvider.serviceArea) && this.privacyPolicyUrl.equals(adProvider.privacyPolicyUrl);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public String getServiceArea() {
        return this.serviceArea;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.serviceArea.hashCode()) * 31) + this.privacyPolicyUrl.hashCode();
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public void setServiceArea(String str) {
        this.serviceArea = str;
    }

    public boolean valid() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.privacyPolicyUrl)) ? false : true;
    }

    public boolean validPart() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name)) ? false : true;
    }
}
