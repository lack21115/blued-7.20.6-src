package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ji.class */
public class ji extends iy {
    private static int b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static int f27861c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ji$a.class */
    public static class a extends iy.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.iy.a, com.xiaomi.push.je
        public jc a(jm jmVar) {
            ji jiVar = new ji(jmVar, this.f838a, this.b);
            if (this.f27851a != 0) {
                jiVar.b(this.f27851a);
            }
            return jiVar;
        }
    }

    public ji(jm jmVar, boolean z, boolean z2) {
        super(jmVar, z, z2);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    /* renamed from: a */
    public ja mo8983a() {
        byte a2 = mo8983a();
        int a3 = mo8983a();
        if (a3 <= f27861c) {
            return new ja(a2, a3);
        }
        throw new jd(3, "Thrift list size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    /* renamed from: a */
    public jb mo8984a() {
        byte a2 = mo8983a();
        byte a3 = mo8983a();
        int a4 = mo8983a();
        if (a4 <= b) {
            return new jb(a2, a3, a4);
        }
        throw new jd(3, "Thrift map size " + a4 + " out of range!");
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    /* renamed from: a */
    public jg mo8985a() {
        byte a2 = mo8983a();
        int a3 = mo8983a();
        if (a3 <= d) {
            return new jg(a2, a3);
        }
        throw new jd(3, "Thrift set size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    /* renamed from: a */
    public String mo8987a() {
        int a2 = mo8983a();
        if (a2 > e) {
            throw new jd(3, "Thrift string size " + a2 + " out of range!");
        } else if (this.f27856a.b() >= a2) {
            try {
                String str = new String(this.f27856a.mo9008a(), this.f27856a.a(), a2, "UTF-8");
                this.f27856a.a(a2);
                return str;
            } catch (UnsupportedEncodingException e2) {
                throw new iw("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return a(a2);
        }
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    /* renamed from: a */
    public ByteBuffer mo8988a() {
        int a2 = mo8983a();
        if (a2 > f) {
            throw new jd(3, "Thrift binary size " + a2 + " out of range!");
        }
        c(a2);
        if (this.f27856a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f27856a.mo9008a(), this.f27856a.a(), a2);
            this.f27856a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.f27856a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }
}
