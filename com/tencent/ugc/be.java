package com.tencent.ugc;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/be.class */
final /* synthetic */ class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40252a;
    private final Bitmap b;

    private be(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        this.f40252a = tXVideoEditer;
        this.b = bitmap;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        return new be(tXVideoEditer, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setFilter$6(this.f40252a, this.b);
    }
}
