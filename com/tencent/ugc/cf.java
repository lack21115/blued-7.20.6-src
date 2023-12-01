package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cf.class */
final /* synthetic */ class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26597a;
    private final int b;

    private cf(TXVideoJoiner tXVideoJoiner, int i) {
        this.f26597a = tXVideoJoiner;
        this.b = i;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, int i) {
        return new cf(tXVideoJoiner, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26597a.mTXVideoEditer.setProfile(this.b);
    }
}
