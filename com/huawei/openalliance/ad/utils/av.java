package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/av.class */
public abstract class av {
    private static final String Code = "SwUt";

    public static Integer Code(String str, int i) {
        return Code(str, i, 0);
    }

    public static Integer Code(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i2 < 0) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length < i2 + 1) {
            return null;
        }
        return V(split[i2], i);
    }

    private static Integer V(String str, int i) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str) || str.length() <= i) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str.substring(i, i + 1)));
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getSwh ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getSwh ");
            sb.append(e.getClass().getSimpleName());
            ge.I(Code, sb.toString());
            return null;
        }
    }
}
