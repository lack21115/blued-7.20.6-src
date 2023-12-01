package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dq.class */
public final /* synthetic */ class dq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40331a;
    private final List b;

    private dq(UGCMediaListSource uGCMediaListSource, List list) {
        this.f40331a = uGCMediaListSource;
        this.b = list;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list) {
        return new dq(uGCMediaListSource, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setVideoSources$0(this.f40331a, this.b);
    }
}
