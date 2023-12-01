package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bt.class */
final /* synthetic */ class bt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40273a;

    private bt(TXVideoJoiner tXVideoJoiner) {
        this.f40273a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new bt(tXVideoJoiner);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$cancel$7(this.f40273a);
    }
}
