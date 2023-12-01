package com.tencent.liteav.videoproducer.producer;

import android.graphics.Point;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/aq.class */
public final /* synthetic */ class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37131a;
    private final Point b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37132c;
    private final int d;
    private final int e;
    private final int f;

    private aq(f fVar, Point point, int i, int i2, int i3, int i4) {
        this.f37131a = fVar;
        this.b = point;
        this.f37132c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public static Runnable a(f fVar, Point point, int i, int i2, int i3, int i4) {
        return new aq(fVar, point, i, i2, i3, i4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37131a, this.b, this.f37132c, this.d, this.e, this.f);
    }
}
