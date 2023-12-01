package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/PolystarContent.class */
public class PolystarContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f4285c;
    private final PolystarShape.Type d;
    private final boolean e;
    private final BaseKeyframeAnimation<?, Float> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    private final BaseKeyframeAnimation<?, Float> i;
    private final BaseKeyframeAnimation<?, Float> j;
    private final BaseKeyframeAnimation<?, Float> k;
    private final BaseKeyframeAnimation<?, Float> l;
    private boolean n;

    /* renamed from: a  reason: collision with root package name */
    private final Path f4284a = new Path();
    private CompoundTrimPathContent m = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/PolystarContent$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4286a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f4286a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4286a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f4285c = lottieDrawable;
        this.b = polystarShape.a();
        this.d = polystarShape.getType();
        this.e = polystarShape.i();
        this.f = polystarShape.b().a();
        this.g = polystarShape.c().a();
        this.h = polystarShape.d().a();
        this.j = polystarShape.f().a();
        this.l = polystarShape.h().a();
        if (this.d == PolystarShape.Type.STAR) {
            this.i = polystarShape.e().a();
            this.k = polystarShape.g().a();
        } else {
            this.i = null;
            this.k = null;
        }
        baseLayer.a(this.f);
        baseLayer.a(this.g);
        baseLayer.a(this.h);
        baseLayer.a(this.j);
        baseLayer.a(this.l);
        if (this.d == PolystarShape.Type.STAR) {
            baseLayer.a(this.i);
            baseLayer.a(this.k);
        }
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
        this.j.a(this);
        this.l.a(this);
        if (this.d == PolystarShape.Type.STAR) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void c() {
        this.n = false;
        this.f4285c.invalidateSelf();
    }

    private void d() {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        float cos;
        float sin;
        double d;
        float f;
        float floatValue = this.f.g().floatValue();
        double radians = Math.toRadians((this.h == null ? 0.0d : baseKeyframeAnimation.g().floatValue()) - 90.0d);
        double d2 = floatValue;
        float f2 = (float) (6.283185307179586d / d2);
        float f3 = f2 / 2.0f;
        float f4 = floatValue - ((int) floatValue);
        int i = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        double d3 = radians;
        if (i != 0) {
            d3 = radians + ((1.0f - f4) * f3);
        }
        float floatValue2 = this.j.g().floatValue();
        float floatValue3 = this.i.g().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.k;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.g().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.l;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.g().floatValue() / 100.0f : 0.0f;
        if (i != 0) {
            f = ((floatValue2 - floatValue3) * f4) + floatValue3;
            double d4 = f;
            cos = (float) (d4 * Math.cos(d3));
            sin = (float) (d4 * Math.sin(d3));
            this.f4284a.moveTo(cos, sin);
            d = d3 + ((f2 * f4) / 2.0f);
        } else {
            double d5 = floatValue2;
            cos = (float) (Math.cos(d3) * d5);
            sin = (float) (d5 * Math.sin(d3));
            this.f4284a.moveTo(cos, sin);
            d = d3 + f3;
            f = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i2 = 0;
        boolean z = false;
        float f5 = sin;
        float f6 = cos;
        while (true) {
            double d6 = i2;
            if (d6 >= ceil) {
                PointF g = this.g.g();
                this.f4284a.offset(g.x, g.y);
                this.f4284a.close();
                return;
            }
            float f7 = z ? floatValue2 : floatValue3;
            int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            float f8 = (i3 == 0 || d6 != ceil - 2.0d) ? f3 : (f2 * f4) / 2.0f;
            if (i3 != 0 && d6 == ceil - 1.0d) {
                f7 = f;
            }
            double d7 = f7;
            float cos2 = (float) (d7 * Math.cos(d));
            float sin2 = (float) (d7 * Math.sin(d));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f4284a.lineTo(cos2, sin2);
            } else {
                float f9 = floatValue4;
                double atan2 = (float) (Math.atan2(f5, f6) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f10 = z ? f9 : floatValue5;
                if (z) {
                    f9 = floatValue5;
                }
                float f11 = z ? floatValue3 : floatValue2;
                float f12 = z ? floatValue2 : floatValue3;
                float f13 = f11 * f10 * 0.47829f;
                float f14 = cos3 * f13;
                float f15 = f13 * sin3;
                float f16 = f12 * f9 * 0.47829f;
                float f17 = cos4 * f16;
                float f18 = f16 * sin4;
                float f19 = f17;
                float f20 = f15;
                float f21 = f18;
                float f22 = f14;
                if (i != 0) {
                    if (i2 == 0) {
                        f22 = f14 * f4;
                        f20 = f15 * f4;
                        f19 = f17;
                        f21 = f18;
                    } else {
                        f19 = f17;
                        f20 = f15;
                        f21 = f18;
                        f22 = f14;
                        if (d6 == ceil - 1.0d) {
                            f19 = f17 * f4;
                            f21 = f18 * f4;
                            f22 = f14;
                            f20 = f15;
                        }
                    }
                }
                this.f4284a.cubicTo(f6 - f22, f5 - f20, cos2 + f19, sin2 + f21, cos2, sin2);
            }
            d += f8;
            z = !z;
            i2++;
            f6 = cos2;
            f5 = sin2;
        }
    }

    private void f() {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        int floor = (int) Math.floor(this.f.g().floatValue());
        double radians = Math.toRadians((this.h == null ? 0.0d : baseKeyframeAnimation.g().floatValue()) - 90.0d);
        double d = floor;
        float f = (float) (6.283185307179586d / d);
        float floatValue = this.l.g().floatValue() / 100.0f;
        float floatValue2 = this.j.g().floatValue();
        double d2 = floatValue2;
        float cos = (float) (Math.cos(radians) * d2);
        float sin = (float) (Math.sin(radians) * d2);
        this.f4284a.moveTo(cos, sin);
        double d3 = f;
        double d4 = radians + d3;
        double ceil = Math.ceil(d);
        int i = 0;
        while (i < ceil) {
            float cos2 = (float) (Math.cos(d4) * d2);
            float sin2 = (float) (d2 * Math.sin(d4));
            if (floatValue != 0.0f) {
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f2 = floatValue2 * floatValue * 0.25f;
                this.f4284a.cubicTo(cos - (cos3 * f2), sin - (sin3 * f2), cos2 + (cos4 * f2), sin2 + (f2 * sin4), cos2, sin2);
            } else {
                this.f4284a.lineTo(cos2, sin2);
            }
            d4 += d3;
            i++;
            sin = sin2;
            cos = cos2;
        }
        PointF g = this.g.g();
        this.f4284a.offset(g.x, g.y);
        this.f4284a.close();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        c();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.a(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.s) {
            this.f.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.t) {
            this.h.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.j) {
            this.g.a((LottieValueCallback<PointF>) lottieValueCallback);
        } else if (t == LottieProperty.u && (baseKeyframeAnimation2 = this.i) != null) {
            baseKeyframeAnimation2.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.v) {
            this.j.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.w && (baseKeyframeAnimation = this.k) != null) {
            baseKeyframeAnimation.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.x) {
            this.l.a((LottieValueCallback<Float>) lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            Content content = list.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.m.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        if (this.n) {
            return this.f4284a;
        }
        this.f4284a.reset();
        if (this.e) {
            this.n = true;
            return this.f4284a;
        }
        int i = AnonymousClass1.f4286a[this.d.ordinal()];
        if (i == 1) {
            d();
        } else if (i == 2) {
            f();
        }
        this.f4284a.close();
        this.m.a(this.f4284a);
        this.n = true;
        return this.f4284a;
    }
}
