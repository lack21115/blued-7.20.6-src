package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bx.class */
final /* synthetic */ class bx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26588a;
    private final boolean b;

    private bx(TXVideoJoiner tXVideoJoiner, boolean z) {
        this.f26588a = tXVideoJoiner;
        this.b = z;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, boolean z) {
        return new bx(tXVideoJoiner, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26588a.mIsNeedEdit = this.b;
    }
}
