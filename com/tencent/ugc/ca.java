package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ca.class */
final /* synthetic */ class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26592a;

    private ca(TXVideoJoiner tXVideoJoiner) {
        this.f26592a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new ca(tXVideoJoiner);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$startPlay$3(this.f26592a);
    }
}
