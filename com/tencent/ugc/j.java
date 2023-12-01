package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/j.class */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40432a;
    private final TXVideoEditConstants.TXRect b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f40433c;

    private j(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        this.f40432a = tXVideoEditer;
        this.b = tXRect;
        this.f40433c = bitmap;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        return new j(tXVideoEditer, tXRect, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setWaterMark$17(this.f40432a, this.b, this.f40433c);
    }
}
