package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cs.class */
public final /* synthetic */ class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f26611a;

    private cs(UGCImageProvider uGCImageProvider) {
        this.f26611a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cs(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26611a.decodeBitmapFrame();
    }
}
