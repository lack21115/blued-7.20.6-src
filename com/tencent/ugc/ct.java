package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ct.class */
public final /* synthetic */ class ct implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final ct f26612a = new ct();

    private ct() {
    }

    public static Runnable a() {
        return f26612a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCInitializer.nativeInitialize();
    }
}
