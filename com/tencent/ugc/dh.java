package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dh.class */
public final /* synthetic */ class dh implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40322a;

    private dh(UGCMediaListSource uGCMediaListSource) {
        this.f40322a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dh(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f40322a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
