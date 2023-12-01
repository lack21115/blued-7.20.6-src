package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieValueCallback.class */
public class LottieValueCallback<T> {
    private final LottieFrameInfo<T> a;
    protected T b;
    private BaseKeyframeAnimation<?, ?> c;

    public LottieValueCallback() {
        this.a = new LottieFrameInfo<>();
        this.b = null;
    }

    public LottieValueCallback(T t) {
        this.a = new LottieFrameInfo<>();
        this.b = null;
        this.b = t;
    }

    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.a.a(f, f2, t, t2, f3, f4, f5));
    }

    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return this.b;
    }

    public final void a(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.c = baseKeyframeAnimation;
    }
}
