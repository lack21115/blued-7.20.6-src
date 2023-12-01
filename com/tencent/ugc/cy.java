package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cy.class */
public final /* synthetic */ class cy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26619a;
    private final int b;

    private cy(UGCMediaListSource uGCMediaListSource, int i) {
        this.f26619a = uGCMediaListSource;
        this.b = i;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, int i) {
        return new cy(uGCMediaListSource, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCMediaListSource.lambda$setPictureTransition$6(this.f26619a, this.b);
    }
}
