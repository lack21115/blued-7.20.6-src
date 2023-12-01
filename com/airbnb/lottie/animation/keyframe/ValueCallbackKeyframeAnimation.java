package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/ValueCallbackKeyframeAnimation.class */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final LottieFrameInfo<A> f4308c;
    private final A d;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a2) {
        super(Collections.emptyList());
        this.f4308c = new LottieFrameInfo<>();
        a(lottieValueCallback);
        this.d = a2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    A a(Keyframe<K> keyframe, float f) {
        return g();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void b() {
        if (this.b != null) {
            super.b();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float f() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A g() {
        LottieValueCallback<A> lottieValueCallback = this.b;
        A a2 = this.d;
        return lottieValueCallback.a(0.0f, 0.0f, a2, a2, h(), h(), h());
    }
}
