package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cm.class */
public final /* synthetic */ class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f26605a;

    private cm(UGCImageProvider uGCImageProvider) {
        this.f26605a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cm(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCImageProvider.lambda$start$2(this.f26605a);
    }
}
