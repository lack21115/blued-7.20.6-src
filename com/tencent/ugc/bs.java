package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bs.class */
final /* synthetic */ class bs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40271a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40272c;

    private bs(TXVideoJoiner tXVideoJoiner, String str, int i) {
        this.f40271a = tXVideoJoiner;
        this.b = str;
        this.f40272c = i;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, String str, int i) {
        return new bs(tXVideoJoiner, str, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$joinVideo$6(this.f40271a, this.b, this.f40272c);
    }
}
