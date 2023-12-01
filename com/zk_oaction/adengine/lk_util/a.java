package com.zk_oaction.adengine.lk_util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.cdo.oaps.ad.OapsKey;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f42003a = {"clear", OapsKey.KEY_SRC, "dst", "src_over", "dst_over", "src_in", "dst_in", "src_out", "dst_out", "src_atop", "dst_atop", "xor"};

    public static PorterDuffXfermode a(String str) {
        return new PorterDuffXfermode(new PorterDuff.Mode[]{PorterDuff.Mode.CLEAR, PorterDuff.Mode.SRC, PorterDuff.Mode.DST, PorterDuff.Mode.SRC_OVER, PorterDuff.Mode.DST_OVER, PorterDuff.Mode.SRC_IN, PorterDuff.Mode.DST_IN, PorterDuff.Mode.SRC_OUT, PorterDuff.Mode.DST_OUT, PorterDuff.Mode.SRC_ATOP, PorterDuff.Mode.DST_ATOP, PorterDuff.Mode.XOR}[b(str)]);
    }

    private static int b(String str) {
        int i;
        if (str == null) {
            return 6;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (Exception e) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                String[] strArr = f42003a;
                i = 6;
                if (i3 < strArr.length) {
                    if (strArr[i3].equals(str)) {
                        i = i3;
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    break;
                }
            }
            return i;
        }
    }
}
