package com.tencent.ugc;

import java.util.Collections;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/m.class */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40437a;
    private final String b;

    private m(TXVideoEditer tXVideoEditer, String str) {
        this.f40437a = tXVideoEditer;
        this.b = str;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, String str) {
        return new m(tXVideoEditer, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40437a.setMediaSourcePaths(Collections.singletonList(this.b));
    }
}
