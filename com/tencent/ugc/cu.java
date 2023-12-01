package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cu.class */
public final /* synthetic */ class cu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final cu f40304a = new cu();

    private cu() {
    }

    public static Runnable a() {
        return f40304a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCInitializer.nativeUninitialize();
    }
}
