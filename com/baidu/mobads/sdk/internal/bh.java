package com.baidu.mobads.sdk.internal;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bh.class */
final class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f9339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(Runnable runnable) {
        this.f9339a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9339a.run();
    }
}
