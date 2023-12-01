package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dg.class */
public final /* synthetic */ class dg implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26630a;

    private dg(UGCMediaListSource uGCMediaListSource) {
        this.f26630a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dg(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean hasAudioDataInternal;
        hasAudioDataInternal = this.f26630a.hasAudioDataInternal();
        return Boolean.valueOf(hasAudioDataInternal);
    }
}
