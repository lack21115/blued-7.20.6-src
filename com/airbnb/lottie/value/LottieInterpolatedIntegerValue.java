package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieInterpolatedIntegerValue.class */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public Integer a(Integer num, Integer num2, float f) {
        return Integer.valueOf(MiscUtils.a(num.intValue(), num2.intValue(), f));
    }
}
