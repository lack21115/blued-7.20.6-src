package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cr.class */
public final /* synthetic */ class cr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f26610a;

    private cr(UGCImageProvider uGCImageProvider) {
        this.f26610a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cr(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26610a.decodeBitmapFrame();
    }
}
