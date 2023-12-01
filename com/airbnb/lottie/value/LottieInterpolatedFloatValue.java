package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieInterpolatedFloatValue.class */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public Float a(Float f, Float f2, float f3) {
        return Float.valueOf(MiscUtils.a(f.floatValue(), f2.floatValue(), f3));
    }
}
