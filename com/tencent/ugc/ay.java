package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ay.class */
public final /* synthetic */ class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26553a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f26554c;

    private ay(TXVideoEditer tXVideoEditer, int i, long j) {
        this.f26553a = tXVideoEditer;
        this.b = i;
        this.f26554c = j;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j) {
        return new ay(tXVideoEditer, i, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$handleWriteMP4Completed$53(this.f26553a, this.b, this.f26554c);
    }
}
