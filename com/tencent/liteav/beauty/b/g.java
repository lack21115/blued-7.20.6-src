package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.f;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f22691a;

    private g(f.a aVar) {
        this.f22691a = aVar;
    }

    public static Runnable a(f.a aVar) {
        return new g(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a aVar = this.f22691a;
        GLES20.glUniform1f(aVar.f22689a, aVar.f22690c / aVar.mOutputSize.f22649a);
        GLES20.glUniform1f(aVar.b, aVar.d / aVar.mOutputSize.b);
    }
}
