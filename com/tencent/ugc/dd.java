package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dd.class */
public final /* synthetic */ class dd implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40318a;

    private dd(UGCMediaListSource uGCMediaListSource) {
        this.f40318a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dd(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f40318a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
