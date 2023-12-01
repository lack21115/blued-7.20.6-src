package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/l.class */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37076a;
    private final float b;

    private l(h hVar, float f) {
        this.f37076a = hVar;
        this.b = f;
    }

    public static Runnable a(h hVar, float f) {
        return new l(hVar, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37076a;
        float f = this.b;
        if (f < 0.0f) {
            hVar.c(h.b.b);
            return;
        }
        com.tencent.liteav.beauty.b.f fVar = (com.tencent.liteav.beauty.b.f) hVar.a(h.b.b);
        if (fVar != null) {
            fVar.f36379a.a(f, 0.0f);
            fVar.b.a(0.0f, f);
        }
    }
}
