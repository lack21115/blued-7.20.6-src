package com.huawei.openalliance.ad.utils;

import java.math.BigDecimal;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ag.class */
public class ag {
    public static Double Code(Double d, int i, int i2) {
        if (d == null || Double.isInfinite(d.doubleValue()) || Double.isNaN(d.doubleValue())) {
            return null;
        }
        return Double.valueOf(new BigDecimal(d.doubleValue()).setScale(i, i2).doubleValue());
    }
}
