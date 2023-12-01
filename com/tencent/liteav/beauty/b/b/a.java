package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.a.j;
import com.tencent.liteav.videobase.a.k;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/b/a.class */
public final class a extends k implements com.tencent.liteav.beauty.b.b {
    private float f = 0.1f;
    private float g = 2.0f;
    private int h = 0;
    private int i = 0;
    private final b e = new b();
    private final d b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final e f22670c = new e();
    private final c d = new c();

    public a() {
        k.a aVar = this.f22892a;
        k.a a2 = a(this.b);
        a2.a(aVar);
        k.a a3 = a(this.f22670c);
        a3.a(a2);
        a3.a(j.SECOND_INPUT_SAMPLE2D_NAME, aVar);
        k.a a4 = a(this.d);
        a4.a(a3);
        k.a a5 = a(this.e);
        a5.a(a4);
        a5.a(j.SECOND_INPUT_SAMPLE2D_NAME, aVar);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f) {
        e eVar = this.f22670c;
        if (eVar != null) {
            LiteavLog.i("SmoothVertical", "setBeautyLevel ".concat(String.valueOf(f)));
            eVar.setFloatOnDraw(eVar.f22676a, f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f) {
        b bVar = this.e;
        if (bVar != null) {
            LiteavLog.i("BeautyBlend", "setBrightLevel ".concat(String.valueOf(f)));
            bVar.setFloatOnDraw(bVar.f22671a, f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f) {
        b bVar = this.e;
        if (bVar != null) {
            LiteavLog.i("BeautyBlend", "setRuddyLevel level ".concat(String.valueOf(f)));
            bVar.setFloatOnDraw(bVar.b, f / 2.0f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f) {
        this.f = f / 1.2f;
        LiteavLog.i("BeautySmoothFilter", "set mSharpenLevel ".concat(String.valueOf(f)));
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(this.f);
        }
    }

    @Override // com.tencent.liteav.videobase.a.k, com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.h = i;
        this.i = i2;
        if (Math.abs(this.g - 1.0f) > 1.0E-5d) {
            float f = this.h;
            float f2 = this.g;
            this.h = (int) (f / f2);
            this.i = (int) (this.i / f2);
        }
        LiteavLog.i("BeautySmoothFilter", "mResampleRatio: %f, mResampleWidth: %d, mResampleHeight: %d", Float.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i));
        this.b.onOutputSizeChanged(this.h, this.i);
        this.f22670c.onOutputSizeChanged(this.h, this.i);
    }
}
