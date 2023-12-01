package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/BaseKeyframeAnimation.class */
public abstract class BaseKeyframeAnimation<K, A> {
    protected LottieValueCallback<A> b;
    private final List<? extends Keyframe<K>> d;
    private Keyframe<K> f;
    private Keyframe<K> g;
    final List<AnimationListener> a = new ArrayList(1);
    private boolean c = false;
    private float e = 0.0f;
    private float h = -1.0f;
    private A i = null;
    private float j = -1.0f;
    private float k = -1.0f;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/BaseKeyframeAnimation$AnimationListener.class */
    public interface AnimationListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.d = list;
    }

    private float i() {
        if (this.j == -1.0f) {
            this.j = this.d.isEmpty() ? 0.0f : this.d.get(0).c();
        }
        return this.j;
    }

    abstract A a(Keyframe<K> keyframe, float f);

    public void a() {
        this.c = true;
    }

    public void a(float f) {
        float f2;
        if (this.d.isEmpty()) {
            return;
        }
        Keyframe<K> c = c();
        if (f < i()) {
            f2 = i();
        } else {
            f2 = f;
            if (f > f()) {
                f2 = f();
            }
        }
        if (f2 == this.e) {
            return;
        }
        this.e = f2;
        Keyframe<K> c2 = c();
        if (c == c2 && c2.e()) {
            return;
        }
        b();
    }

    public void a(AnimationListener animationListener) {
        this.a.add(animationListener);
    }

    public void a(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.b;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.a((BaseKeyframeAnimation<?, ?>) null);
        }
        this.b = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.a((BaseKeyframeAnimation<?, ?>) this);
        }
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            this.a.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe<K> c() {
        Keyframe<K> keyframe = this.f;
        if (keyframe == null || !keyframe.a(this.e)) {
            List<? extends Keyframe<K>> list = this.d;
            Keyframe<K> keyframe2 = list.get(list.size() - 1);
            Keyframe<K> keyframe3 = keyframe2;
            if (this.e < keyframe2.c()) {
                keyframe3 = keyframe2;
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    keyframe3 = this.d.get(size);
                    if (keyframe3.a(this.e)) {
                        break;
                    }
                }
            }
            this.f = keyframe3;
            return keyframe3;
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        if (this.c) {
            return 0.0f;
        }
        Keyframe<K> c = c();
        if (c.e()) {
            return 0.0f;
        }
        return (this.e - c.c()) / (c.d() - c.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float e() {
        Keyframe<K> c = c();
        if (c.e()) {
            return 0.0f;
        }
        return c.c.getInterpolation(d());
    }

    float f() {
        float d;
        if (this.k == -1.0f) {
            if (this.d.isEmpty()) {
                d = 1.0f;
            } else {
                List<? extends Keyframe<K>> list = this.d;
                d = list.get(list.size() - 1).d();
            }
            this.k = d;
        }
        return this.k;
    }

    public A g() {
        Keyframe<K> c = c();
        float e = e();
        if (this.b == null && c == this.g && this.h == e) {
            return this.i;
        }
        this.g = c;
        this.h = e;
        A a = a(c, e);
        this.i = a;
        return a;
    }

    public float h() {
        return this.e;
    }
}
