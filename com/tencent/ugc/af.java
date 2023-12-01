package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/af.class */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26530a;

    private af(TXVideoEditer tXVideoEditer) {
        this.f26530a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new af(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26530a.processVideoInternal();
    }
}
