package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dv.class */
public final /* synthetic */ class dv implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40336a;

    private dv(UGCMediaListSource uGCMediaListSource) {
        this.f40336a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dv(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f40336a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
