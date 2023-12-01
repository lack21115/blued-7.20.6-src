package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/o.class */
public final class o extends t {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f4533c;
    private boolean g;
    private ArrayList<Header> e = new ArrayList<>();
    private Map<String, String> f = new HashMap();
    private String d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put(str, str2);
    }

    public final void a(Header header) {
        this.e.add(header);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(byte[] bArr) {
        this.f4533c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f4533c;
    }

    public final String c() {
        return this.d;
    }

    public final ArrayList<Header> d() {
        return this.e;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            o oVar = (o) obj;
            byte[] bArr = this.f4533c;
            if (bArr == null) {
                if (oVar.f4533c != null) {
                    return false;
                }
            } else if (!bArr.equals(oVar.f4533c)) {
                return false;
            }
            String str = this.b;
            String str2 = oVar.b;
            return str == null ? str2 == null : str.equals(str2);
        }
        return false;
    }

    public final int hashCode() {
        Map<String, String> map = this.f;
        int hashCode = (map == null || !map.containsKey("id")) ? 1 : this.f.get("id").hashCode() + 31;
        String str = this.b;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.b, this.e);
    }
}
