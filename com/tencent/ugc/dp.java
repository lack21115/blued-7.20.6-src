package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dp.class */
public final /* synthetic */ class dp implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40330a;

    private dp(UGCMediaListSource uGCMediaListSource) {
        this.f40330a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dp(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f40330a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
