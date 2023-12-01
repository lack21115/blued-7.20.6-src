package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/di.class */
public final /* synthetic */ class di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40323a;
    private final List b;

    private di(UGCMediaListSource uGCMediaListSource, List list) {
        this.f40323a = uGCMediaListSource;
        this.b = list;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list) {
        return new di(uGCMediaListSource, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setSpeedList$12(this.f40323a, this.b);
    }
}
