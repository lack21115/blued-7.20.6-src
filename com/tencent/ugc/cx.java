package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cx.class */
public final /* synthetic */ class cx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26617a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26618c;

    private cx(UGCMediaListSource uGCMediaListSource, List list, int i) {
        this.f26617a = uGCMediaListSource;
        this.b = list;
        this.f26618c = i;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, int i) {
        return new cx(uGCMediaListSource, list, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setPictureList$5(this.f26617a, this.b, this.f26618c);
    }
}
