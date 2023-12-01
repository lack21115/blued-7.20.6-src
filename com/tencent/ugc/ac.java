package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40217a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40218c;
    private final boolean d;
    private final int e;
    private final TXVideoEditer.TXThumbnailListener f;

    private ac(TXVideoEditer tXVideoEditer, int i, int i2, boolean z, int i3, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f40217a = tXVideoEditer;
        this.b = i;
        this.f40218c = i2;
        this.d = z;
        this.e = i3;
        this.f = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, int i2, boolean z, int i3, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ac(tXVideoEditer, i, i2, z, i3, tXThumbnailListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$getThumbnail$34(this.f40217a, this.b, this.f40218c, this.d, this.e, this.f);
    }
}
