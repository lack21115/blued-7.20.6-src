package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/j.class */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37073a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final float f37074c;
    private final float d;
    private final float e;

    private j(h hVar, Bitmap bitmap, float f, float f2, float f3) {
        this.f37073a = hVar;
        this.b = bitmap;
        this.f37074c = f;
        this.d = f2;
        this.e = f3;
    }

    public static Runnable a(h hVar, Bitmap bitmap, float f, float f2, float f3) {
        return new j(hVar, bitmap, f, f2, f3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37073a;
        Bitmap bitmap = this.b;
        float f = this.f37074c;
        float f2 = this.d;
        float f3 = this.e;
        if (bitmap == null) {
            hVar.c(h.b.e);
            return;
        }
        com.tencent.liteav.beauty.b.n nVar = (com.tencent.liteav.beauty.b.n) hVar.a(h.b.e);
        nVar.enableWatermark(true);
        nVar.setWatermark(bitmap, f, f2, f3);
        com.tencent.liteav.beauty.a.h(hVar.f37065a);
    }
}
