package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37078a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f37079c;
    private final float d;
    private final float e;
    private final float f;

    private n(h hVar, Bitmap bitmap, Bitmap bitmap2, float f, float f2, float f3) {
        this.f37078a = hVar;
        this.b = bitmap;
        this.f37079c = bitmap2;
        this.d = f;
        this.e = f2;
        this.f = f3;
    }

    public static Runnable a(h hVar, Bitmap bitmap, Bitmap bitmap2, float f, float f2, float f3) {
        return new n(hVar, bitmap, bitmap2, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37078a;
        Bitmap bitmap = this.b;
        Bitmap bitmap2 = this.f37079c;
        float f = this.d;
        float f2 = this.e;
        float f3 = this.f;
        if (bitmap == null && bitmap2 == null) {
            hVar.c(h.b.f37069c);
            return;
        }
        ((com.tencent.liteav.beauty.b.i) hVar.a(h.b.f37069c)).a(f, bitmap, f2, bitmap2, f3);
        com.tencent.liteav.beauty.a.f(hVar.f37065a);
    }
}
