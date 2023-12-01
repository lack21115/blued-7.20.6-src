package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cv.class */
public final /* synthetic */ class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f26614a;

    private cv(UGCMediaListSource uGCMediaListSource) {
        this.f26614a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new cv(uGCMediaListSource);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26614a.uninitializeInternal();
    }
}
