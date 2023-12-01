package com.huawei.hms.ads.consent.bean.network;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/network/ConfirmResultReq.class */
public class ConfirmResultReq {
    private List<ApiStatisticsReq> caches = new ArrayList();

    public List<ApiStatisticsReq> getCaches() {
        return this.caches;
    }

    public void setCaches(List<ApiStatisticsReq> list) {
        this.caches = list;
    }
}
