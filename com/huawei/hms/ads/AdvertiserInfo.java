package com.huawei.hms.ads;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AdvertiserInfo.class */
public class AdvertiserInfo implements Serializable, Comparable {
    private static final long serialVersionUID = -3124209648823884395L;
    private String key;
    private Integer seq;
    private String value;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof AdvertiserInfo) && ((AdvertiserInfo) obj).getSeq().intValue() <= getSeq().intValue()) ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AdvertiserInfo)) {
            Integer num = this.seq;
            Integer num2 = ((AdvertiserInfo) obj).seq;
            return num == null ? num2 == null : num.equals(num2);
        }
        return false;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        Integer num = this.seq;
        return (num != null ? num.hashCode() : -1) & super.hashCode();
    }
}
