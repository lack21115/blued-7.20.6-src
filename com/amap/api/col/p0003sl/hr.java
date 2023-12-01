package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mapsdk.internal.ma;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3sl.hr  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hr.class */
public final class hr {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hr$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hr$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f5097a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f5098c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static String a() {
        String str = null;
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str2 = ho.a() ? "1" : "0";
            int length = valueOf.length();
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf.substring(0, length - 2));
            sb.append(str2);
            sb.append(valueOf.substring(length - 1));
            str = valueOf;
            return sb.toString();
        } catch (Throwable th) {
            it.a(th, "CI", ma.g);
            return str;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.d = ho.c(context);
            aVar.i = ho.d(context);
            return a(aVar);
        } catch (Throwable th) {
            it.a(th, "CI", "IX");
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = ho.e(context);
            return hw.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            it.a(th, "CI", "Sco");
            return null;
        }
    }

    private static String a(a aVar) {
        return ht.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            ib.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            ib.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, ib.a(str));
        }
    }

    public static byte[] a(Context context, boolean z, boolean z2) {
        try {
            return b(b(context, z, z2));
        } catch (Throwable th) {
            it.a(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return ht.a(bArr);
    }

    private static a b(Context context, boolean z, boolean z2) {
        a aVar = new a((byte) 0);
        aVar.f5097a = hs.v(context);
        aVar.b = hs.k(context);
        String h = hs.h(context);
        String str = h;
        if (h == null) {
            str = "";
        }
        aVar.f5098c = str;
        aVar.d = ho.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = ho.b(context);
        aVar.i = ho.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = hs.y(context);
        aVar.l = hs.r(context);
        StringBuilder sb = new StringBuilder();
        sb.append(hs.o(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hs.n(context));
        aVar.n = sb2.toString();
        aVar.o = hs.A(context);
        aVar.p = hs.m(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] d = hs.d();
            aVar.s = d[0];
            aVar.t = d[1];
        }
        aVar.w = hs.a();
        String a2 = hs.a(context);
        if (TextUtils.isEmpty(a2)) {
            aVar.x = "";
        } else {
            aVar.x = a2;
        }
        aVar.y = "aid=" + hs.j(context);
        if ((z2 && ip.d) || ip.e) {
            String g = hs.g(context);
            if (!TextUtils.isEmpty(g)) {
                aVar.y += "|oaid=" + g;
            }
        }
        String a3 = hs.a(context, ",");
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String x = hs.x(context);
        if (!TextUtils.isEmpty(x)) {
            aVar.y += "|meid=" + x;
        }
        aVar.y += "|serial=" + hs.i(context);
        String b = hs.b();
        if (!TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + hs.f() + "|ram=" + hs.z(context) + "|arch=" + hs.g();
        String b2 = ir.a().b();
        if (TextUtils.isEmpty(b2)) {
            aVar.z = "";
            return aVar;
        }
        aVar.z = b2;
        return aVar;
    }

    public static String b(Context context) {
        return c(context);
    }

    private static byte[] b(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream2, aVar.f5097a);
            a(byteArrayOutputStream2, aVar.b);
            a(byteArrayOutputStream2, aVar.f5098c);
            a(byteArrayOutputStream2, aVar.d);
            a(byteArrayOutputStream2, aVar.e);
            a(byteArrayOutputStream2, aVar.f);
            a(byteArrayOutputStream2, aVar.g);
            a(byteArrayOutputStream2, aVar.h);
            a(byteArrayOutputStream2, aVar.i);
            a(byteArrayOutputStream2, aVar.j);
            a(byteArrayOutputStream2, aVar.k);
            a(byteArrayOutputStream2, aVar.l);
            a(byteArrayOutputStream2, aVar.m);
            a(byteArrayOutputStream2, aVar.n);
            a(byteArrayOutputStream2, aVar.o);
            a(byteArrayOutputStream2, aVar.p);
            a(byteArrayOutputStream2, aVar.q);
            a(byteArrayOutputStream2, aVar.r);
            a(byteArrayOutputStream2, aVar.s);
            a(byteArrayOutputStream2, aVar.t);
            a(byteArrayOutputStream2, aVar.u);
            a(byteArrayOutputStream2, aVar.v);
            a(byteArrayOutputStream2, aVar.w);
            a(byteArrayOutputStream2, aVar.x);
            a(byteArrayOutputStream2, aVar.y);
            a(byteArrayOutputStream2, aVar.z);
            byte[] b = b(ib.b(byteArrayOutputStream2.toByteArray()));
            try {
                byteArrayOutputStream2.close();
                return b;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return b;
            }
        } catch (Throwable th3) {
            byteArrayOutputStream = byteArrayOutputStream2;
            th = th3;
            try {
                it.a(th, "CI", "gzx");
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                        return null;
                    }
                }
                return null;
            } catch (Throwable th5) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    private static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d = ib.d();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 117);
            byte[] a2 = ht.a(bArr2, d);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy((Object) a2, 0, (Object) bArr3, 0, 128);
            System.arraycopy((Object) bArr, 117, (Object) bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return ht.a(bArr, d);
    }

    private static String c(Context context) {
        try {
            return a(b(context, false, false));
        } catch (Throwable th) {
            it.a(th, "CI", "gCXi");
            return null;
        }
    }
}
