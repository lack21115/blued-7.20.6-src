package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ab.class */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26524a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26525c;
    private final int d;
    private final boolean e;
    private final TXVideoEditer.TXThumbnailListener f;

    private ab(TXVideoEditer tXVideoEditer, List list, int i, int i2, boolean z, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f26524a = tXVideoEditer;
        this.b = list;
        this.f26525c = i;
        this.d = i2;
        this.e = z;
        this.f = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list, int i, int i2, boolean z, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ab(tXVideoEditer, list, i, i2, z, tXThumbnailListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26524a.doGetThumbnail(this.b, this.f26525c, this.d, this.e, this.f);
    }
}
