package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fr.class */
public final /* synthetic */ class fr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40393a;
    private final List b;

    private fr(UGCVideoProcessor uGCVideoProcessor, List list) {
        this.f40393a = uGCVideoProcessor;
        this.b = list;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, List list) {
        return new fr(uGCVideoProcessor, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.lambda$setSpeedList$9(this.f40393a, this.b);
    }
}
