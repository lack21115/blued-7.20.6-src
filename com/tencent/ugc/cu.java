package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cu.class */
public final /* synthetic */ class cu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final cu f26613a = new cu();

    private cu() {
    }

    public static Runnable a() {
        return f26613a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCInitializer.nativeUninitialize();
    }
}
