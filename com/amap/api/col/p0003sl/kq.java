package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* renamed from: com.amap.api.col.3sl.kq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kq.class */
public final class kq extends ks {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public kq(Context context, ks ksVar) {
        super(ksVar);
        this.e = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            ib.a(byteArrayOutputStream, "1.2." + a + "." + b);
            ib.a(byteArrayOutputStream, "Android");
            ib.a(byteArrayOutputStream, hs.v(context));
            ib.a(byteArrayOutputStream, hs.k(context));
            ib.a(byteArrayOutputStream, hs.h(context));
            ib.a(byteArrayOutputStream, Build.MANUFACTURER);
            ib.a(byteArrayOutputStream, Build.MODEL);
            ib.a(byteArrayOutputStream, Build.DEVICE);
            ib.a(byteArrayOutputStream, hs.y(context));
            ib.a(byteArrayOutputStream, ho.c(context));
            ib.a(byteArrayOutputStream, ho.d(context));
            ib.a(byteArrayOutputStream, ho.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            context = byteArray;
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.printStackTrace();
            return context;
        }
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[a2.length + bArr.length];
        System.arraycopy((Object) a2, 0, (Object) bArr2, 0, a2.length);
        System.arraycopy((Object) bArr, 0, (Object) bArr2, a2.length, bArr.length);
        return bArr2;
    }
}
