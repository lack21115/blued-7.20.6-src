package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieRelativeFloatValueCallback.class */
public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* renamed from: b */
    public Float a(LottieFrameInfo<Float> lottieFrameInfo) {
        return Float.valueOf(MiscUtils.a(lottieFrameInfo.a().floatValue(), lottieFrameInfo.b().floatValue(), lottieFrameInfo.c()) + c(lottieFrameInfo).floatValue());
    }

    public Float c(LottieFrameInfo<Float> lottieFrameInfo) {
        if (this.b != 0) {
            return (Float) this.b;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
