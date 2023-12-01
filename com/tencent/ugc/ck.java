package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ck.class */
public final /* synthetic */ class ck implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f26603a;

    private ck(UGCImageProvider uGCImageProvider) {
        this.f26603a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new ck(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26603a.decodeBitmapFrame();
    }
}
