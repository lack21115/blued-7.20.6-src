package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cj.class */
public final /* synthetic */ class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40293a;

    private cj(UGCImageProvider uGCImageProvider) {
        this.f40293a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cj(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40293a.decodeBitmapFrame();
    }
}
