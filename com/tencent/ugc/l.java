package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/l.class */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40436a;
    private final List b;

    private l(TXVideoEditer tXVideoEditer, List list) {
        this.f40436a = tXVideoEditer;
        this.b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new l(tXVideoEditer, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setSubtitleList$19(this.f40436a, this.b);
    }
}
