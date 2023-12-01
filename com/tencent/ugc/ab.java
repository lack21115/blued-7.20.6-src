package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40215a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40216c;
    private final int d;
    private final boolean e;
    private final TXVideoEditer.TXThumbnailListener f;

    private ab(TXVideoEditer tXVideoEditer, List list, int i, int i2, boolean z, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f40215a = tXVideoEditer;
        this.b = list;
        this.f40216c = i;
        this.d = i2;
        this.e = z;
        this.f = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list, int i, int i2, boolean z, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ab(tXVideoEditer, list, i, i2, z, tXThumbnailListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40215a.doGetThumbnail(this.b, this.f40216c, this.d, this.e, this.f);
    }
}
