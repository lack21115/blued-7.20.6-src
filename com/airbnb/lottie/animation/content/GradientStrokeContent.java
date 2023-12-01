package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import com.blued.das.live.LiveProtos;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/GradientStrokeContent.class */
public class GradientStrokeContent extends BaseStrokeContent {

    /* renamed from: c  reason: collision with root package name */
    private final String f4280c;
    private final boolean d;
    private final LongSparseArray<LinearGradient> e;
    private final LongSparseArray<RadialGradient> f;
    private final RectF g;
    private final GradientType h;
    private final int i;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> j;
    private final BaseKeyframeAnimation<PointF, PointF> k;
    private final BaseKeyframeAnimation<PointF, PointF> l;
    private ValueCallbackKeyframeAnimation m;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.h().a(), gradientStroke.i().a(), gradientStroke.l(), gradientStroke.d(), gradientStroke.g(), gradientStroke.j(), gradientStroke.k());
        this.e = new LongSparseArray<>();
        this.f = new LongSparseArray<>();
        this.g = new RectF();
        this.f4280c = gradientStroke.a();
        this.h = gradientStroke.b();
        this.d = gradientStroke.m();
        this.i = (int) (lottieDrawable.r().e() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a2 = gradientStroke.c().a();
        this.j = a2;
        a2.a(this);
        baseLayer.a(this.j);
        BaseKeyframeAnimation<PointF, PointF> a3 = gradientStroke.e().a();
        this.k = a3;
        a3.a(this);
        baseLayer.a(this.k);
        BaseKeyframeAnimation<PointF, PointF> a4 = gradientStroke.f().a();
        this.l = a4;
        a4.a(this);
        baseLayer.a(this.l);
    }

    private int[] a(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.m;
        int[] iArr2 = iArr;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.g();
            int i = 0;
            if (iArr.length != numArr.length) {
                int[] iArr3 = new int[numArr.length];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    iArr2 = iArr3;
                    if (i3 >= numArr.length) {
                        break;
                    }
                    iArr3[i3] = numArr[i3].intValue();
                    i2 = i3 + 1;
                }
            } else {
                while (true) {
                    iArr2 = iArr;
                    if (i >= iArr.length) {
                        break;
                    }
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr2;
    }

    private LinearGradient c() {
        long e = e();
        LinearGradient linearGradient = this.e.get(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g = this.k.g();
        PointF g2 = this.l.g();
        GradientColor g3 = this.j.g();
        LinearGradient linearGradient2 = new LinearGradient((int) (this.g.left + (this.g.width() / 2.0f) + g.x), (int) (this.g.top + (this.g.height() / 2.0f) + g.y), (int) (this.g.left + (this.g.width() / 2.0f) + g2.x), (int) (this.g.top + (this.g.height() / 2.0f) + g2.y), a(g3.b()), g3.a(), Shader.TileMode.CLAMP);
        this.e.put(e, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        int height;
        long e = e();
        RadialGradient radialGradient = this.f.get(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g = this.k.g();
        PointF g2 = this.l.g();
        GradientColor g3 = this.j.g();
        int[] a2 = a(g3.b());
        float[] a3 = g3.a();
        int width = (int) (this.g.left + (this.g.width() / 2.0f) + g.x);
        RadialGradient radialGradient2 = new RadialGradient(width, (int) (this.g.top + (this.g.height() / 2.0f) + g.y), (float) Math.hypot(((int) ((this.g.left + (this.g.width() / 2.0f)) + g2.x)) - width, ((int) ((this.g.top + (this.g.height() / 2.0f)) + g2.y)) - height), a2, a3, Shader.TileMode.CLAMP);
        this.f.put(e, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.k.h() * this.i);
        int round2 = Math.round(this.l.h() * this.i);
        int round3 = Math.round(this.j.h() * this.i);
        int i = round != 0 ? LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE * round : 17;
        int i2 = i;
        if (round2 != 0) {
            i2 = i * 31 * round2;
        }
        int i3 = i2;
        if (round3 != 0) {
            i3 = i2 * 31 * round3;
        }
        return i3;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.d) {
            return;
        }
        a(this.g, matrix, false);
        this.b.setShader(this.h == GradientType.LINEAR ? c() : d());
        super.a(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        super.a((GradientStrokeContent) t, (LottieValueCallback<GradientStrokeContent>) lottieValueCallback);
        if (t == LottieProperty.C) {
            if (lottieValueCallback == null) {
                if (this.m != null) {
                    this.f4268a.b(this.m);
                }
                this.m = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.m = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f4268a.a(this.m);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.f4280c;
    }
}
