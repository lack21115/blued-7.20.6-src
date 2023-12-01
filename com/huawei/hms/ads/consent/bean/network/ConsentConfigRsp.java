package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.consent.bean.AdProvider;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/network/ConsentConfigRsp.class */
public class ConsentConfigRsp {
    private List<AdProvider> companies;
    private int isNeedConsent;
    private int retcode = -1;

    public List<AdProvider> getCompanies() {
        return this.companies;
    }

    public int getIsNeedConsent() {
        return this.isNeedConsent;
    }

    public int getRetcode() {
        return this.retcode;
    }

    public void setCompanies(List<AdProvider> list) {
        this.companies = list;
    }

    public void setIsNeedConsent(int i) {
        this.isNeedConsent = i;
    }

    public void setRetcode(int i) {
        this.retcode = i;
    }
}
