package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ce.class */
final /* synthetic */ class ce implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40287a;
    private final TXVideoJoiner.TXVideoJoinerListener b;

    private ce(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoJoinerListener tXVideoJoinerListener) {
        this.f40287a = tXVideoJoiner;
        this.b = tXVideoJoinerListener;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoJoinerListener tXVideoJoinerListener) {
        return new ce(tXVideoJoiner, tXVideoJoinerListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$setVideoJoinerListener$4(this.f40287a, this.b);
    }
}
