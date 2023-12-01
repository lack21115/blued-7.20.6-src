package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieInterpolatedPointValue.class */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public PointF a(PointF pointF, PointF pointF2, float f) {
        this.a.set(MiscUtils.a(pointF.x, pointF2.x, f), MiscUtils.a(pointF.y, pointF2.y, f));
        return this.a;
    }
}
