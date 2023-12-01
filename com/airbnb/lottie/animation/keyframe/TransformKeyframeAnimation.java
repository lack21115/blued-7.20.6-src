package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/TransformKeyframeAnimation.class */
public class TransformKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f4306a = new Matrix();
    private final Matrix b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f4307c;
    private final Matrix d;
    private final float[] e;
    private BaseKeyframeAnimation<PointF, PointF> f;
    private BaseKeyframeAnimation<?, PointF> g;
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> h;
    private BaseKeyframeAnimation<Float, Float> i;
    private BaseKeyframeAnimation<Integer, Integer> j;
    private FloatKeyframeAnimation k;
    private FloatKeyframeAnimation l;
    private BaseKeyframeAnimation<?, Float> m;
    private BaseKeyframeAnimation<?, Float> n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.f = animatableTransform.a() == null ? null : animatableTransform.a().a();
        this.g = animatableTransform.b() == null ? null : animatableTransform.b().a();
        this.h = animatableTransform.c() == null ? null : animatableTransform.c().a();
        this.i = animatableTransform.d() == null ? null : animatableTransform.d().a();
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.h() == null ? null : (FloatKeyframeAnimation) animatableTransform.h().a();
        this.k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.b = new Matrix();
            this.f4307c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.f4307c = null;
            this.d = null;
            this.e = null;
        }
        this.l = animatableTransform.i() == null ? null : (FloatKeyframeAnimation) animatableTransform.i().a();
        if (animatableTransform.e() != null) {
            this.j = animatableTransform.e().a();
        }
        if (animatableTransform.f() != null) {
            this.m = animatableTransform.f().a();
        } else {
            this.m = null;
        }
        if (animatableTransform.g() != null) {
            this.n = animatableTransform.g().a();
        } else {
            this.n = null;
        }
    }

    private void e() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 9) {
                return;
            }
            this.e[i2] = 0.0f;
            i = i2 + 1;
        }
    }

    public BaseKeyframeAnimation<?, Integer> a() {
        return this.j;
    }

    public void a(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(f);
        }
    }

    public void a(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(animationListener);
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.a(this.j);
        baseLayer.a(this.m);
        baseLayer.a(this.n);
        baseLayer.a(this.f);
        baseLayer.a(this.g);
        baseLayer.a(this.h);
        baseLayer.a(this.i);
        baseLayer.a(this.k);
        baseLayer.a(this.l);
    }

    public <T> boolean a(T t, LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.e) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
            if (baseKeyframeAnimation3 == null) {
                this.f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation3.a((LottieValueCallback<PointF>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.f) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.g;
            if (baseKeyframeAnimation4 == null) {
                this.g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation4.a((LottieValueCallback<PointF>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.k) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.h;
            if (baseKeyframeAnimation5 == null) {
                this.h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.a((LottieValueCallback<ScaleXY>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.l) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.i;
            if (baseKeyframeAnimation6 == null) {
                this.i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.a((LottieValueCallback<Float>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.f4255c) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.j;
            if (baseKeyframeAnimation7 == null) {
                this.j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.a((LottieValueCallback<Integer>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.y && (baseKeyframeAnimation2 = this.m) != null) {
            if (baseKeyframeAnimation2 == null) {
                this.m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation2.a((LottieValueCallback<Float>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.z && (baseKeyframeAnimation = this.n) != null) {
            if (baseKeyframeAnimation == null) {
                this.n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation.a((LottieValueCallback<Float>) lottieValueCallback);
            return true;
        } else if (t == LottieProperty.m && (floatKeyframeAnimation2 = this.k) != null) {
            if (floatKeyframeAnimation2 == null) {
                this.k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.k.a(lottieValueCallback);
            return true;
        } else if (t != LottieProperty.n || (floatKeyframeAnimation = this.l) == null) {
            return false;
        } else {
            if (floatKeyframeAnimation == null) {
                this.l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.l.a(lottieValueCallback);
            return true;
        }
    }

    public Matrix b(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        PointF g = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.g();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.h;
        ScaleXY g2 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.g();
        this.f4306a.reset();
        if (g != null) {
            this.f4306a.preTranslate(g.x * f, g.y * f);
        }
        if (g2 != null) {
            double d = f;
            this.f4306a.preScale((float) Math.pow(g2.a(), d), (float) Math.pow(g2.b(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.g().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
            PointF g3 = baseKeyframeAnimation4 == null ? null : baseKeyframeAnimation4.g();
            Matrix matrix = this.f4306a;
            float f2 = 0.0f;
            float f3 = g3 == null ? 0.0f : g3.x;
            if (g3 != null) {
                f2 = g3.y;
            }
            matrix.preRotate(floatValue * f, f3, f2);
        }
        return this.f4306a;
    }

    public BaseKeyframeAnimation<?, Float> b() {
        return this.m;
    }

    public BaseKeyframeAnimation<?, Float> c() {
        return this.n;
    }

    public Matrix d() {
        this.f4306a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            PointF g = baseKeyframeAnimation.g();
            if (g.x != 0.0f || g.y != 0.0f) {
                this.f4306a.preTranslate(g.x, g.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.i;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? baseKeyframeAnimation2.g().floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).i();
            if (floatValue != 0.0f) {
                this.f4306a.preRotate(floatValue);
            }
        }
        if (this.k != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.l;
            float cos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((-floatKeyframeAnimation.i()) + 90.0f));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
            float sin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-floatKeyframeAnimation2.i()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(this.k.i()));
            e();
            float[] fArr = this.e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f = -sin;
            fArr[3] = f;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            e();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f4307c.setValues(fArr2);
            e();
            float[] fArr3 = this.e;
            fArr3[0] = cos;
            fArr3[1] = f;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.f4307c.preConcat(this.b);
            this.d.preConcat(this.f4307c);
            this.f4306a.preConcat(this.d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY g2 = baseKeyframeAnimation3.g();
            if (g2.a() != 1.0f || g2.b() != 1.0f) {
                this.f4306a.preScale(g2.a(), g2.b());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            PointF g3 = baseKeyframeAnimation4.g();
            if (g3.x != 0.0f || g3.y != 0.0f) {
                this.f4306a.preTranslate(-g3.x, -g3.y);
            }
        }
        return this.f4306a;
    }
}
