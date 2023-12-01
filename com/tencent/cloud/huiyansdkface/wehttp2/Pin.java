package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/Pin.class */
public class Pin {

    /* renamed from: a  reason: collision with root package name */
    private String f36098a;
    private String b;

    public Pin(String str, String str2) {
        this.f36098a = str;
        this.b = str2;
    }

    public static Collection<? extends Pin> create(String str, String[] strArr) {
        if (str == null) {
            throw new IllegalArgumentException("host pattern must not be null");
        }
        if (strArr == null || strArr.length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            String str2 = strArr[i2];
            if (str2 != null) {
                arrayList.add(new Pin(str, str2));
            }
            i = i2 + 1;
        }
    }

    public String getPattern() {
        return this.f36098a;
    }

    public String getPin() {
        return this.b;
    }

    public boolean match(String str) {
        return this.f36098a.startsWith("**.") ? str.endsWith(this.f36098a.substring(2)) : this.f36098a.startsWith("*.") ? this.f36098a.substring(1).equals(str.substring(str.indexOf("."))) : this.f36098a.equals(str);
    }
}
