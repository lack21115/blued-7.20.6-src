package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.ugc.do  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/do.class */
public final /* synthetic */ class Cdo implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40329a;

    private Cdo(UGCMediaListSource uGCMediaListSource) {
        this.f40329a = uGCMediaListSource;
    }

    public static Callable a(UGCMediaListSource uGCMediaListSource) {
        return new Cdo(uGCMediaListSource);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long calculateTotalDurationOfClips;
        calculateTotalDurationOfClips = this.f40329a.calculateTotalDurationOfClips();
        return Long.valueOf(calculateTotalDurationOfClips);
    }
}
