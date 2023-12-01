package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieInterpolatedPointValue.class */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f4422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public PointF a(PointF pointF, PointF pointF2, float f) {
        this.f4422a.set(MiscUtils.a(pointF.x, pointF2.x, f), MiscUtils.a(pointF.y, pointF2.y, f));
        return this.f4422a;
    }
}
