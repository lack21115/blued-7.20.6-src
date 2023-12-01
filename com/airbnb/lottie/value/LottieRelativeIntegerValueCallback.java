package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieRelativeIntegerValueCallback.class */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* renamed from: b */
    public Integer a(LottieFrameInfo<Integer> lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.a(lottieFrameInfo.a().intValue(), lottieFrameInfo.b().intValue(), lottieFrameInfo.c()) + c(lottieFrameInfo).intValue());
    }

    public Integer c(LottieFrameInfo<Integer> lottieFrameInfo) {
        if (this.b != 0) {
            return (Integer) this.b;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
