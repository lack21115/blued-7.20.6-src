package com.huawei.openalliance.ad.beans.inner;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/inner/PlacementAdReqParam.class */
public class PlacementAdReqParam extends BaseAdReqParam {
    private boolean autoCache;
    private String extraInfo;

    public void Code(String str) {
        this.extraInfo = str;
    }

    public void Code(boolean z) {
        this.autoCache = z;
    }
}
