package com.tencent.liteav.videoproducer.encoder;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/aq.class */
public final /* synthetic */ class aq implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23299a;

    private aq(ai aiVar) {
        this.f23299a = aiVar;
    }

    public static Callable a(ai aiVar) {
        return new aq(aiVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return ai.b(this.f23299a);
    }
}
