package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ae.class */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26529a;
    private final TXVideoEditer.TXThumbnailListener b;

    private ae(TXVideoEditer tXVideoEditer, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f26529a = tXVideoEditer;
        this.b = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ae(tXVideoEditer, tXThumbnailListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setThumbnailListener$36(this.f26529a, this.b);
    }
}
