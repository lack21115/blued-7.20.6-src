package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/p.class */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f23391a;
    private final GLConstants.GLScaleType b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23392c;

    private p(h hVar, GLConstants.GLScaleType gLScaleType, boolean z) {
        this.f23391a = hVar;
        this.b = gLScaleType;
        this.f23392c = z;
    }

    public static Runnable a(h hVar, GLConstants.GLScaleType gLScaleType, boolean z) {
        return new p(hVar, gLScaleType, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f23391a;
        GLConstants.GLScaleType gLScaleType = this.b;
        boolean z = this.f23392c;
        com.tencent.liteav.beauty.b.h hVar2 = (com.tencent.liteav.beauty.b.h) hVar.b(h.b.d);
        if (hVar2 != null) {
            hVar2.f22692a = gLScaleType;
            hVar2.b = z;
        }
    }
}
