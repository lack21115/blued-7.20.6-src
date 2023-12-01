package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/de.class */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26628a;
    private final List b;

    private de(UGCMediaListSource uGCMediaListSource, List list) {
        this.f26628a = uGCMediaListSource;
        this.b = list;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list) {
        return new de(uGCMediaListSource, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setRepeatPlay$10(this.f26628a, this.b);
    }
}
