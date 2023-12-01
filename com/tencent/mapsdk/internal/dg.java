package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/dg.class */
public class dg {

    /* renamed from: a  reason: collision with root package name */
    public final String f23708a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23709c;
    public final String[] d;

    public dg(String str, String str2, String[] strArr, int i) {
        this.f23708a = str;
        this.b = str2;
        this.d = a(strArr);
        this.f23709c = i;
    }

    private String[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }
}
