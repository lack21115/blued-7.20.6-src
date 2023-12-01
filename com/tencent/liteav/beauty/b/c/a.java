package com.tencent.liteav.beauty.b.c;

import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.videobase.a.h;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/c/a.class */
public final class a extends h implements com.tencent.liteav.beauty.b.b {

    /* renamed from: c  reason: collision with root package name */
    private float f36371c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    private final b f36370a = new b();
    private final m b = new m();

    public a() {
        addFilter(this.f36370a);
        addFilter(this.b);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f) {
        this.f36371c = f;
        b bVar = this.f36370a;
        if (bVar != null) {
            bVar.a(f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f) {
        this.d = f;
        b bVar = this.f36370a;
        if (bVar != null) {
            bVar.b(f);
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f) {
        this.e = f;
        b bVar = this.f36370a;
        if (bVar != null) {
            bVar.c(f);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return this.b.canBeSkipped() && this.f36370a.canBeSkipped();
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f) {
        float f2 = f / 2.0f;
        this.f = f2;
        m mVar = this.b;
        if (mVar != null) {
            mVar.a(f2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.h, com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.f36370a.a(this.f36371c);
        this.f36370a.b(this.d);
        this.f36370a.c(this.e);
        this.b.a(this.f);
    }
}
