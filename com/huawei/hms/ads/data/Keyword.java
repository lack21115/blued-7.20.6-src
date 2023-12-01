package com.huawei.hms.ads.data;

import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.annotations.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/data/Keyword.class */
public class Keyword {
    @c(Code = OapsKey.KEY_KEYWORD)
    private String keyword;
    private Integer type;

    public Keyword() {
    }

    public Keyword(Integer num, String str) {
        this.type = num;
        this.keyword = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public Integer getType() {
        return this.type;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
