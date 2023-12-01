package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bw.class */
final /* synthetic */ class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40277a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40278c;

    private bw(TXVideoJoiner tXVideoJoiner, int i, String str) {
        this.f40277a = tXVideoJoiner;
        this.b = i;
        this.f40278c = str;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, int i, String str) {
        return new bw(tXVideoJoiner, i, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoJoiner.lambda$splitJoinVideo$10(this.f40277a, this.b, this.f40278c);
    }
}
