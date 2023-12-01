package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ia;
import com.amap.api.col.p0003sl.jv;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/d.class */
public final class d extends jv {
    Map<String, String> h;
    String i;
    String j;
    byte[] k;
    byte[] l;
    boolean m;
    String n;
    Map<String, String> o;
    boolean p;
    private String q;

    public d(Context context, ia iaVar) {
        super(context, iaVar);
        this.h = null;
        this.q = "";
        this.i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = false;
    }

    public final void a(String str) {
        this.n = str;
    }

    public final void a(Map<String, String> map) {
        this.o = map;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final void b(Map<String, String> map) {
        this.h = map;
    }

    public final void b(boolean z) {
        this.p = z;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.l = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public final void c(String str) {
        this.j = str;
    }

    public final void c(byte[] bArr) {
        this.k = bArr;
    }

    @Override // com.amap.api.col.p0003sl.jv
    public final byte[] c() {
        return this.k;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.q = "";
        } else {
            this.q = str;
        }
    }

    @Override // com.amap.api.col.p0003sl.jv
    public final byte[] d() {
        return this.l;
    }

    @Override // com.amap.api.col.p0003sl.jv
    public final boolean f() {
        return this.m;
    }

    @Override // com.amap.api.col.p0003sl.jv
    public final String g() {
        return this.n;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getIPDNSName() {
        return this.q;
    }

    @Override // com.amap.api.col.p0003sl.hv, com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return this.j;
    }

    @Override // com.amap.api.col.p0003sl.jv, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return this.o;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return this.i;
    }

    @Override // com.amap.api.col.p0003sl.jv
    public final boolean h() {
        return this.p;
    }
}
