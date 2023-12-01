package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/GradientFillContent.class */
public class GradientFillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f4278a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f4279c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final Matrix f = new Matrix();
    private final Path g = new Path();
    private final Paint h = new LPaint(1);
    private final RectF i = new RectF();
    private final List<PathContent> j = new ArrayList();
    private final GradientType k;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> l;
    private final BaseKeyframeAnimation<Integer, Integer> m;
    private final BaseKeyframeAnimation<PointF, PointF> n;
    private final BaseKeyframeAnimation<PointF, PointF> o;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> p;
    private ValueCallbackKeyframeAnimation q;
    private final LottieDrawable r;
    private final int s;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        this.f4279c = baseLayer;
        this.f4278a = gradientFill.a();
        this.b = gradientFill.h();
        this.r = lottieDrawable;
        this.k = gradientFill.b();
        this.g.setFillType(gradientFill.c());
        this.s = (int) (lottieDrawable.r().e() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a2 = gradientFill.d().a();
        this.l = a2;
        a2.a(this);
        baseLayer.a(this.l);
        BaseKeyframeAnimation<Integer, Integer> a3 = gradientFill.e().a();
        this.m = a3;
        a3.a(this);
        baseLayer.a(this.m);
        BaseKeyframeAnimation<PointF, PointF> a4 = gradientFill.f().a();
        this.n = a4;
        a4.a(this);
        baseLayer.a(this.n);
        BaseKeyframeAnimation<PointF, PointF> a5 = gradientFill.g().a();
        this.o = a5;
        a5.a(this);
        baseLayer.a(this.o);
    }

    private int[] a(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.q;
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
        LinearGradient linearGradient = this.d.get(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g = this.n.g();
        PointF g2 = this.o.g();
        GradientColor g3 = this.l.g();
        LinearGradient linearGradient2 = new LinearGradient(g.x, g.y, g2.x, g2.y, a(g3.b()), g3.a(), Shader.TileMode.CLAMP);
        this.d.put(e, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e = e();
        RadialGradient radialGradient = this.e.get(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g = this.n.g();
        PointF g2 = this.o.g();
        GradientColor g3 = this.l.g();
        int[] a2 = a(g3.b());
        float[] a3 = g3.a();
        float f = g.x;
        float f2 = g.y;
        float hypot = (float) Math.hypot(g2.x - f, g2.y - f2);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot, a2, a3, Shader.TileMode.CLAMP);
        this.e.put(e, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.n.h() * this.s);
        int round2 = Math.round(this.o.h() * this.s);
        int round3 = Math.round(this.l.h() * this.s);
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

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.r.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.b) {
            return;
        }
        L.a("GradientFillContent#draw");
        this.g.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.j.size()) {
                break;
            }
            this.g.addPath(this.j.get(i3).e(), matrix);
            i2 = i3 + 1;
        }
        this.g.computeBounds(this.i, false);
        LinearGradient c2 = this.k == GradientType.LINEAR ? c() : d();
        this.f.set(matrix);
        c2.setLocalMatrix(this.f);
        this.h.setShader(c2);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.p;
        if (baseKeyframeAnimation != null) {
            this.h.setColorFilter(baseKeyframeAnimation.g());
        }
        this.h.setAlpha(MiscUtils.a((int) ((((i / 255.0f) * this.m.g().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.g, this.h);
        L.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.g.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                this.g.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
            this.g.addPath(this.j.get(i2).e(), matrix);
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.a(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.d) {
            this.m.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.p = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f4279c.a(this.p);
        } else if (t == LottieProperty.C) {
            if (lottieValueCallback == null) {
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.q;
                if (valueCallbackKeyframeAnimation2 != null) {
                    this.f4279c.b(valueCallbackKeyframeAnimation2);
                }
                this.q = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.q = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            this.f4279c.a(this.q);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list2.size()) {
                return;
            }
            Content content = list2.get(i2);
            if (content instanceof PathContent) {
                this.j.add((PathContent) content);
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.f4278a;
    }
}
