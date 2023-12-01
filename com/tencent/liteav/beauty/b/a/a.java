package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.videobase.a.j;
import com.tencent.liteav.videobase.a.k;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/a/a.class */
public final class a extends k implements com.tencent.liteav.beauty.b.b {
    private d b;

    /* renamed from: c  reason: collision with root package name */
    private d f22663c;
    private b d;
    private c e;
    private d f;
    private d g;
    private float h = 0.2f;
    private float i = 0.2f;
    private float j = 0.2f;

    public a() {
        this.b = null;
        this.f22663c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.b = new d(true);
        this.f22663c = new d(false);
        this.d = new b();
        this.e = new c();
        this.f = new d(true);
        this.g = new d(false);
        k.a aVar = this.f22892a;
        k.a a2 = a(this.b);
        a2.a(aVar);
        k.a a3 = a(this.f22663c);
        a3.a(a2);
        k.a a4 = a(this.d);
        a4.a(aVar);
        a4.a(j.SECOND_INPUT_SAMPLE2D_NAME, a3);
        k.a a5 = a(this.f);
        a5.a(a4);
        k.a a6 = a(this.g);
        a6.a(a5);
        k.a a7 = a(this.e);
        a7.a(aVar);
        a7.a(j.SECOND_INPUT_SAMPLE2D_NAME, a3);
        a7.a(j.THIRD_INPUT_SAMPLE2D_NAME, a6);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f) {
        this.h = f;
        c cVar = this.e;
        if (cVar != null) {
            cVar.a(f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f) {
        this.i = f;
        c cVar = this.e;
        if (cVar != null) {
            cVar.b(f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f) {
        this.j = f;
        c cVar = this.e;
        if (cVar != null) {
            cVar.c(f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f) {
        c cVar = this.e;
        cVar.setFloatOnDraw(cVar.f22666a, f / 1.0f);
    }

    @Override // com.tencent.liteav.videobase.a.k, com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.e.a(this.h);
        this.e.b(this.i);
        this.e.c(this.j);
    }
}
