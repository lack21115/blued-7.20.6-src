package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bm.class */
final /* synthetic */ class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40263a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final List f40264c;

    private bm(TXVideoEditer tXVideoEditer, int i, List list) {
        this.f40263a = tXVideoEditer;
        this.b = i;
        this.f40264c = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, List list) {
        return new bm(tXVideoEditer, i, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setPictureList$9(this.f40263a, this.b, this.f40264c);
    }
}
