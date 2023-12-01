package com.tencent.turingface.sdk.mfa;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/KKOXW.class */
public final class KKOXW extends ucT3w {
    public byte[] j;
    public Map<String, String> l;
    public Map<String, String> m;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f26198c = !KKOXW.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f26197a = null;
    public static Map<String, String> b = null;
    public short d = 0;
    public byte e = 0;
    public int f = 0;
    public int g = 0;
    public String h = null;
    public String i = null;
    public int k = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.d, 1);
        d5hoq.a(this.e, 2);
        d5hoq.a(this.f, 3);
        d5hoq.a(this.g, 4);
        d5hoq.a(this.h, 5);
        d5hoq.a(this.i, 6);
        d5hoq.a(this.j, 7);
        d5hoq.a(this.k, 8);
        d5hoq.a((Map) this.l, 9);
        d5hoq.a((Map) this.m, 10);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        String str;
        try {
            this.d = nyvkz.a(this.d, 1, true);
            this.e = nyvkz.a(this.e, 2, true);
            this.f = nyvkz.a(this.f, 3, true);
            this.g = nyvkz.a(this.g, 4, true);
            this.h = nyvkz.b(5, true);
            this.i = nyvkz.b(6, true);
            if (f26197a == null) {
                f26197a = new byte[]{0};
            }
            this.j = nyvkz.a(7, true);
            this.k = nyvkz.a(this.k, 8, true);
            if (b == null) {
                HashMap hashMap = new HashMap();
                b = hashMap;
                hashMap.put("", "");
            }
            this.l = (Map) nyvkz.a((nyvKz) b, 9, true);
            if (b == null) {
                HashMap hashMap2 = new HashMap();
                b = hashMap2;
                hashMap2.put("", "");
            }
            this.m = (Map) nyvkz.a((nyvKz) b, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder b2 = com.tencent.turingcam.oqKCa.b("RequestPacket decode error ");
            byte[] bArr = this.j;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    byte b3 = bArr[i2];
                    int i3 = i2 * 2;
                    char[] cArr2 = NbXuL.f26206a;
                    cArr[i3 + 1] = cArr2[b3 & 15];
                    cArr[i3 + 0] = cArr2[((byte) (b3 >>> 4)) & 15];
                    i = i2 + 1;
                }
                str = new String(cArr);
            }
            b2.append(str);
            printStream.println(b2.toString());
            throw new RuntimeException(e);
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f26198c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        KKOXW kkoxw = (KKOXW) obj;
        short s = kkoxw.d;
        Integer num = 1;
        return fi6GY.a(1, (int) s) && fi6GY.a(1, (int) kkoxw.e) && fi6GY.a(1, kkoxw.f) && fi6GY.a(1, kkoxw.g) && num.equals(kkoxw.h) && num.equals(kkoxw.i) && num.equals(kkoxw.j) && fi6GY.a(1, kkoxw.k) && num.equals(kkoxw.l) && num.equals(kkoxw.m);
    }
}
