package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cn.class */
final /* synthetic */ class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f40297a;

    private cn(UGCImageProvider uGCImageProvider) {
        this.f40297a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new cn(uGCImageProvider);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCImageProvider.lambda$stop$3(this.f40297a);
    }
}
