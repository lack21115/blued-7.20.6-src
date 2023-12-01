package com.alipay.sdk.protocol;

import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/protocol/a.class */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    
    private String g;

    a(String str) {
        this.g = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        a[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return aVar;
            }
            a aVar2 = values[i2];
            if (str.startsWith(aVar2.g)) {
                return aVar2;
            }
            i = i2 + 1;
        }
    }
}
