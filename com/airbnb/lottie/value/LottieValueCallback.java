package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieValueCallback.class */
public class LottieValueCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LottieFrameInfo<T> f4426a;
    protected T b;

    /* renamed from: c  reason: collision with root package name */
    private BaseKeyframeAnimation<?, ?> f4427c;

    public LottieValueCallback() {
        this.f4426a = new LottieFrameInfo<>();
        this.b = null;
    }

    public LottieValueCallback(T t) {
        this.f4426a = new LottieFrameInfo<>();
        this.b = null;
        this.b = t;
    }

    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.f4426a.a(f, f2, t, t2, f3, f4, f5));
    }

    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return this.b;
    }

    public final void a(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f4427c = baseKeyframeAnimation;
    }
}
