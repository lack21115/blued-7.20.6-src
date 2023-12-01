package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bw.class */
final /* synthetic */ class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26586a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26587c;

    private bw(TXVideoJoiner tXVideoJoiner, int i, String str) {
        this.f26586a = tXVideoJoiner;
        this.b = i;
        this.f26587c = str;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, int i, String str) {
        return new bw(tXVideoJoiner, i, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$splitJoinVideo$10(this.f26586a, this.b, this.f26587c);
    }
}
