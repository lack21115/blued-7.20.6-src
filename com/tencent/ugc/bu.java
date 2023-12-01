package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bu.class */
final /* synthetic */ class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40274a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40275c;
    private final int d;

    private bu(TXVideoJoiner tXVideoJoiner, List list, int i, int i2) {
        this.f40274a = tXVideoJoiner;
        this.b = list;
        this.f40275c = i;
        this.d = i2;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, List list, int i, int i2) {
        return new bu(tXVideoJoiner, list, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$setSplitScreenList$8(this.f40274a, this.b, this.f40275c, this.d);
    }
}
