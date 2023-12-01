package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ch.class */
final /* synthetic */ class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner.AnonymousClass3 f40290a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40291c;

    private ch(TXVideoJoiner.AnonymousClass3 anonymousClass3, int i, String str) {
        this.f40290a = anonymousClass3;
        this.b = i;
        this.f40291c = str;
    }

    public static Runnable a(TXVideoJoiner.AnonymousClass3 anonymousClass3, int i, String str) {
        return new ch(anonymousClass3, i, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.AnonymousClass3.a(this.f40290a, this.b, this.f40291c);
    }
}
