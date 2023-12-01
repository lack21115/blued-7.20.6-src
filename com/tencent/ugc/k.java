package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26743a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f26744c;
    private final TXVideoEditConstants.TXRect d;

    private k(TXVideoEditer tXVideoEditer, int i, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.f26743a = tXVideoEditer;
        this.b = i;
        this.f26744c = bitmap;
        this.d = tXRect;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        return new k(tXVideoEditer, i, bitmap, tXRect);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setTailWaterMark$18(this.f26743a, this.b, this.f26744c, this.d);
    }
}
