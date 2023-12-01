package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cx.class */
public final /* synthetic */ class cx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f40308a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40309c;

    private cx(UGCMediaListSource uGCMediaListSource, List list, int i) {
        this.f40308a = uGCMediaListSource;
        this.b = list;
        this.f40309c = i;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, int i) {
        return new cx(uGCMediaListSource, list, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setPictureList$5(this.f40308a, this.b, this.f40309c);
    }
}
