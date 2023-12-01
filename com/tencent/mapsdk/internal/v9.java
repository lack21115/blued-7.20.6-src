package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.tencent.mapsdk.internal.ra;
import com.tencent.mapsdk.internal.za;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v9.class */
public class v9 extends n9 {
    public static final int f = 10;
    private static final za.e g;
    private static final za.k<za.m<Bitmap>> h;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f38065a = new AtomicInteger();
    public Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f38066c;
    private int d;
    private String e;

    static {
        za.e eVar = new za.e(256, 256, Bitmap.Config.ARGB_8888);
        g = eVar;
        h = za.a(10, eVar);
    }

    public v9() {
    }

    public v9(Bitmap bitmap) {
        this.b = bitmap;
        j();
        i();
    }

    public v9(byte[] bArr) {
        this.f38066c = bArr;
        if (bArr != null) {
            a(bArr);
        }
    }

    private void i() {
        byte[] bArr;
        Bitmap bitmap = this.b;
        if (bitmap == null && (bArr = this.f38066c) != null) {
            this.d = bArr.length;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.d = this.b.getAllocationByteCount();
        } else {
            this.d = this.b.getByteCount();
        }
    }

    private void j() {
        Bitmap bitmap = this.b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.e = b7.e(this.b);
    }

    @Override // com.tencent.mapsdk.internal.n9
    public int a() {
        return this.d;
    }

    public void a(za.e eVar) {
        g.a(eVar);
    }

    @Override // com.tencent.mapsdk.internal.n9
    public void a(byte[] bArr) {
        int i;
        h();
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.f38066c = bArr;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Exception e) {
            na.a("BD", "BitmapData testOpts decodingByteArray exception: ", e.fillInStackTrace());
        }
        int i2 = options.outWidth;
        if (i2 <= 0 || (i = options.outHeight) <= 0) {
            return;
        }
        za.e eVar = g;
        eVar.f38150a = i2;
        eVar.b = i;
        Bitmap bitmap = null;
        boolean z = false;
        int i3 = 0;
        while (!z && i3 < 20) {
            za.m<Bitmap> a2 = h.a();
            boolean z2 = z;
            if (a2 != null) {
                Bitmap b = a2.b();
                z2 = z;
                bitmap = b;
                if (!b.isRecycled()) {
                    z2 = z;
                    bitmap = b;
                    if (b.getWidth() == options.outWidth) {
                        z2 = z;
                        bitmap = b;
                        if (b.getHeight() == options.outHeight) {
                            z2 = true;
                            bitmap = b;
                        }
                    }
                }
            }
            i3++;
            z = z2;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (z) {
            options2.inBitmap = bitmap;
        }
        options2.inSampleSize = 1;
        options2.inMutable = true;
        try {
            this.b = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
        } catch (Exception e2) {
            na.a("BD", "BitmapData opts decodingByteArray exception: ", e2.fillInStackTrace());
        }
        this.f38066c = null;
        j();
        i();
    }

    @Override // com.tencent.mapsdk.internal.n9
    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = this.f38066c;
        if (bArr != null) {
            return bArr;
        }
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                if (this.b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ha.a(byteArrayOutputStream);
                    return byteArray;
                }
                ha.a(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
                ha.a(byteArrayOutputStream);
                throw th;
            }
        }
        return new byte[0];
    }

    public void c() {
        Bitmap bitmap = this.b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        int decrementAndGet = this.f38065a.decrementAndGet();
        ra.b g2 = ra.g("BD");
        g2.a("decrement refCount:" + decrementAndGet + " id = " + e());
    }

    public Bitmap d() {
        synchronized (this) {
            if (this.b == null) {
                a(this.f38066c);
            }
            Bitmap bitmap = this.b;
            if (bitmap == null || !bitmap.isRecycled()) {
                return this.b;
            }
            return null;
        }
    }

    public String e() {
        return this.e;
    }

    public void f() {
        Bitmap bitmap = this.b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        int incrementAndGet = this.f38065a.incrementAndGet();
        ra.b g2 = ra.g("BD");
        g2.a("increment refCount:" + incrementAndGet + " id = " + e());
    }

    public boolean g() {
        Bitmap bitmap = this.b;
        if (bitmap != null) {
            return bitmap.isRecycled();
        }
        byte[] bArr = this.f38066c;
        return bArr == null || bArr.length == 0;
    }

    public boolean h() {
        Bitmap bitmap = this.b;
        boolean z = false;
        if (bitmap != null && !bitmap.isRecycled() && this.f38065a.decrementAndGet() <= 0) {
            this.b.recycle();
            ra.g("BD").a("recycle out");
        }
        this.f38066c = null;
        Bitmap bitmap2 = this.b;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            z = true;
        }
        return z;
    }

    public String toString() {
        return "BitmapData{id='" + this.e + "'}";
    }
}
