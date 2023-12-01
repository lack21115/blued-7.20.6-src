package com.airbnb.lottie.value;

import android.view.animation.Interpolator;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieInterpolatedValue.class */
abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f4423a;

    /* renamed from: c  reason: collision with root package name */
    private final T f4424c;
    private final Interpolator d;

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return a(this.f4423a, this.f4424c, this.d.getInterpolation(lottieFrameInfo.d()));
    }

    abstract T a(T t, T t2, float f);
}
