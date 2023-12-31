package com.qiniu.pili.droid.beauty;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.f.j;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/beauty/a.class */
public final class a implements PLVideoFilterListener {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f13775a = h.a().b();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private b f13776c;
    private PLFaceBeautySetting d;
    private int e;

    public a(Context context, PLFaceBeautySetting pLFaceBeautySetting) {
        if (h.a(true)) {
            e.g.c("FaceBeautyProcessor", "using the built-in fb");
            this.f13776c = new b();
        }
        this.b = context;
        this.d = pLFaceBeautySetting;
    }

    private void c() {
        b bVar;
        if (f13775a && (bVar = this.f13776c) != null) {
            bVar.a();
            this.f13776c.a(this.b.getApplicationContext(), j.d(this.b), 0);
            this.f13776c.a(!j.e(this.b));
            a(this.d);
        }
    }

    public void a(PLFaceBeautySetting pLFaceBeautySetting) {
        if (!f13775a || this.f13776c == null) {
            return;
        }
        if (pLFaceBeautySetting == null) {
            e.g.d("FaceBeautyProcessor", "Invalid FB setting");
            return;
        }
        float whiten = pLFaceBeautySetting.getWhiten();
        float f = whiten;
        if (whiten > 1.0f) {
            f = 1.0f;
        }
        this.f13776c.b(f / 2.0f);
        this.f13776c.c(pLFaceBeautySetting.getRedden());
        this.f13776c.a(pLFaceBeautySetting.getBeautyLevel());
        this.d = pLFaceBeautySetting;
    }

    public boolean a() {
        if (f13775a) {
            PLFaceBeautySetting pLFaceBeautySetting = this.d;
            boolean z = false;
            if (pLFaceBeautySetting != null) {
                z = false;
                if (pLFaceBeautySetting.isEnabled()) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public void b() {
        b bVar;
        if (f13775a && (bVar = this.f13776c) != null) {
            bVar.a();
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
        if (f13775a) {
            int i4 = i;
            if (this.f13776c != null) {
                i4 = i;
                if (i2 != 0) {
                    i4 = i;
                    if (i3 != 0) {
                        if (this.e == 0) {
                            this.e = d.a((ByteBuffer) null, i2, i3, 6408);
                        }
                        this.f13776c.a(i, i2, i3, this.e);
                        i4 = this.e;
                    }
                }
            }
            return i4;
        }
        return i;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceChanged(int i, int i2) {
        b bVar;
        if (f13775a && (bVar = this.f13776c) != null) {
            bVar.b(this.b.getApplicationContext(), i, i2);
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceCreated() {
        if (f13775a) {
            this.e = 0;
            c();
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceDestroy() {
        if (!f13775a) {
        }
    }
}
