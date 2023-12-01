package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.f;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f36382a;

    private g(f.a aVar) {
        this.f36382a = aVar;
    }

    public static Runnable a(f.a aVar) {
        return new g(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a aVar = this.f36382a;
        GLES20.glUniform1f(aVar.f36380a, aVar.f36381c / aVar.mOutputSize.f36340a);
        GLES20.glUniform1f(aVar.b, aVar.d / aVar.mOutputSize.b);
    }
}
