package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dt.class */
public final /* synthetic */ class dt implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26643a;

    private dt(UGCMediaListSource uGCMediaListSource) {
        this.f26643a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new dt(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f26643a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
