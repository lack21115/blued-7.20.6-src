package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/w.class */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f23401a;

    private w(h hVar) {
        this.f23401a = hVar;
    }

    public static Runnable a(h hVar) {
        return new w(hVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23401a.a();
        LiteavLog.i("GPUPreprocessor", "destroy gpu preprocessor");
    }
}
