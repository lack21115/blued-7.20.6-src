package com.amap.api.col.p0003sl;

import android.text.TextUtils;

/* renamed from: com.amap.api.col.3sl.cu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cu.class */
public final class cu {

    /* renamed from: a  reason: collision with root package name */
    int f4824a;
    int[] b;

    /* renamed from: c  reason: collision with root package name */
    int f4825c;
    int d;
    String e;
    String f;
    String g;

    public cu(int i, int[] iArr, String str, String str2, String str3) {
        this.f4824a = i;
        this.b = iArr;
        this.e = str;
        this.f = str2;
        this.g = str3;
        String str4 = TextUtils.isEmpty(str) ? str2 : str;
        this.f4825c = -1000;
        if ("regions".equals(str4)) {
            this.f4825c = 1001;
        } else if ("water".equals(str4)) {
            this.f4825c = 1002;
        } else if ("buildings".equals(str4)) {
            this.f4825c = 1003;
        } else if ("roads".equals(str4)) {
            this.f4825c = 1004;
        } else if ("labels".equals(str4)) {
            this.f4825c = 1005;
        } else if ("borders".equals(str4)) {
            this.f4825c = 1006;
        }
        this.d = (i * 1000) + iArr.hashCode();
    }
}
