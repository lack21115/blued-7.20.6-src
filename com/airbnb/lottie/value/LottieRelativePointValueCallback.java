package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieRelativePointValueCallback.class */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f4425a = new PointF();

    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* renamed from: b */
    public final PointF a(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.f4425a.set(MiscUtils.a(lottieFrameInfo.a().x, lottieFrameInfo.b().x, lottieFrameInfo.c()), MiscUtils.a(lottieFrameInfo.a().y, lottieFrameInfo.b().y, lottieFrameInfo.c()));
        PointF c2 = c(lottieFrameInfo);
        this.f4425a.offset(c2.x, c2.y);
        return this.f4425a;
    }

    public PointF c(LottieFrameInfo<PointF> lottieFrameInfo) {
        if (this.b != 0) {
            return (PointF) this.b;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
