package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ee.class */
public final /* synthetic */ class ee implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRecorderJni f26656a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f26657c;

    private ee(UGCRecorderJni uGCRecorderJni, float f, float f2) {
        this.f26656a = uGCRecorderJni;
        this.b = f;
        this.f26657c = f2;
    }

    public static Runnable a(UGCRecorderJni uGCRecorderJni, float f, float f2) {
        return new ee(uGCRecorderJni, f, f2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCRecorderJni.lambda$setFocusPosition$0(this.f26656a, this.b, this.f26657c);
    }
}
