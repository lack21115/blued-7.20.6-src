package com.tencent.tmsqmsp.oaid2;

import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/d.class */
public enum d {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, AssistUtils.BRAND_VIVO),
    OPPO(3, AssistUtils.BRAND_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, AssistUtils.BRAND_MZ),
    ALPS(9, "alps"),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(14, "freemeos"),
    SSUIOS(15, "ssui");
    

    /* renamed from: a  reason: collision with root package name */
    public String f25931a;

    d(int i, String str) {
        this.f25931a = str;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        d[] values = values();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 17) {
                return UNSUPPORT;
            }
            d dVar = values[i2];
            if (dVar.f25931a.equalsIgnoreCase(str)) {
                return dVar;
            }
            i = i2 + 1;
        }
    }
}
