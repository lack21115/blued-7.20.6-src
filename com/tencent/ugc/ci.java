package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ci.class */
public final /* synthetic */ class ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40292a;

    private ci(UGCImageProvider uGCImageProvider) {
        this.f40292a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new ci(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCImageProvider.lambda$initialize$0(this.f40292a);
    }
}
