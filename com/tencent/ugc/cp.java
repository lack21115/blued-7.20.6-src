package com.tencent.ugc;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cp.class */
public final /* synthetic */ class cp implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40299a;
    private final int b;

    private cp(UGCImageProvider uGCImageProvider, int i) {
        this.f40299a = uGCImageProvider;
        this.b = i;
    }

    public static Callable a(UGCImageProvider uGCImageProvider, int i) {
        return new cp(uGCImageProvider, i);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return UGCImageProvider.lambda$setPictureTransition$5(this.f40299a, this.b);
    }
}
