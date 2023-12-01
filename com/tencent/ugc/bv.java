package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bv.class */
final /* synthetic */ class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f40276a;
    private final float[] b;

    private bv(TXVideoJoiner tXVideoJoiner, float[] fArr) {
        this.f40276a = tXVideoJoiner;
        this.b = fArr;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, float[] fArr) {
        return new bv(tXVideoJoiner, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40276a.mTXVideoEditer.setVideoVolumes(this.b);
    }
}
