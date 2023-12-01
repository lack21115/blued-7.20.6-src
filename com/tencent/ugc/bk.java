package com.tencent.ugc;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bk.class */
public final /* synthetic */ class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40259a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f40260c;
    private final float d;
    private final Bitmap e;
    private final Bitmap f;

    private bk(TXVideoEditer tXVideoEditer, float f, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        this.f40259a = tXVideoEditer;
        this.b = f;
        this.f40260c = f2;
        this.d = f3;
        this.e = bitmap;
        this.f = bitmap2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        return new bk(tXVideoEditer, f, f2, f3, bitmap, bitmap2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setFilter$7(this.f40259a, this.b, this.f40260c, this.d, this.e, this.f);
    }
}
