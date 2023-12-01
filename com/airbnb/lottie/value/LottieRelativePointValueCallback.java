package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieRelativePointValueCallback.class */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {
    private final PointF a = new PointF();

    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* renamed from: b */
    public final PointF a(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.a.set(MiscUtils.a(lottieFrameInfo.a().x, lottieFrameInfo.b().x, lottieFrameInfo.c()), MiscUtils.a(lottieFrameInfo.a().y, lottieFrameInfo.b().y, lottieFrameInfo.c()));
        PointF c = c(lottieFrameInfo);
        this.a.offset(c.x, c.y);
        return this.a;
    }

    public PointF c(LottieFrameInfo<PointF> lottieFrameInfo) {
        if (this.b != 0) {
            return (PointF) this.b;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
