package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/BaseStrokeContent.class */
public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    protected final BaseLayer f4268a;
    final Paint b;
    private final LottieDrawable g;
    private final float[] i;
    private final BaseKeyframeAnimation<?, Float> j;
    private final BaseKeyframeAnimation<?, Integer> k;
    private final List<BaseKeyframeAnimation<?, Float>> l;
    private final BaseKeyframeAnimation<?, Float> m;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> n;

    /* renamed from: c  reason: collision with root package name */
    private final PathMeasure f4269c = new PathMeasure();
    private final Path d = new Path();
    private final Path e = new Path();
    private final RectF f = new RectF();
    private final List<PathGroup> h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/BaseStrokeContent$PathGroup.class */
    public static final class PathGroup {

        /* renamed from: a  reason: collision with root package name */
        private final List<PathContent> f4270a;
        private final TrimPathContent b;

        private PathGroup(TrimPathContent trimPathContent) {
            this.f4270a = new ArrayList();
            this.b = trimPathContent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.b = lPaint;
        this.g = lottieDrawable;
        this.f4268a = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(cap);
        this.b.setStrokeJoin(join);
        this.b.setStrokeMiter(f);
        this.k = animatableIntegerValue.a();
        this.j = animatableFloatValue.a();
        if (animatableFloatValue2 == null) {
            this.m = null;
        } else {
            this.m = animatableFloatValue2.a();
        }
        this.l = new ArrayList(list.size());
        this.i = new float[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            this.l.add(list.get(i2).a());
            i = i2 + 1;
        }
        baseLayer.a(this.k);
        baseLayer.a(this.j);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.l.size()) {
                break;
            }
            baseLayer.a(this.l.get(i4));
            i3 = i4 + 1;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        if (baseKeyframeAnimation != null) {
            baseLayer.a(baseKeyframeAnimation);
        }
        this.k.a(this);
        this.j.a(this);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                break;
            }
            this.l.get(i6).a(this);
            i5 = i6 + 1;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
    }

    private void a(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f;
        L.a("StrokeContent#applyTrimPath");
        if (pathGroup.b == null) {
            L.b("StrokeContent#applyTrimPath");
            return;
        }
        this.d.reset();
        int size = pathGroup.f4270a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            this.d.addPath(((PathContent) pathGroup.f4270a.get(i)).e(), matrix);
            size = i;
        }
        this.f4269c.setPath(this.d, false);
        float length = this.f4269c.getLength();
        while (true) {
            f = length;
            if (!this.f4269c.nextContour()) {
                break;
            }
            length = f + this.f4269c.getLength();
        }
        float floatValue = (pathGroup.b.e().g().floatValue() * f) / 360.0f;
        float floatValue2 = ((pathGroup.b.c().g().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((pathGroup.b.d().g().floatValue() * f) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = pathGroup.f4270a.size() - 1; size2 >= 0; size2--) {
            this.e.set(((PathContent) pathGroup.f4270a.get(size2)).e());
            this.e.transform(matrix);
            this.f4269c.setPath(this.e, false);
            float length2 = this.f4269c.getLength();
            if (floatValue3 > f) {
                float f3 = floatValue3 - f;
                if (f3 < f2 + length2 && f2 < f3) {
                    Utils.a(this.e, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.e, this.b);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 > floatValue3 || floatValue2 >= f2) {
                    Utils.a(this.e, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.e, this.b);
                } else {
                    canvas.drawPath(this.e, this.b);
                }
            }
            f2 += length2;
        }
        L.b("StrokeContent#applyTrimPath");
    }

    private void a(Matrix matrix) {
        L.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            L.b("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = Utils.a(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.size()) {
                break;
            }
            this.i[i2] = this.l.get(i2).g().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.i;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.i;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.i;
            fArr3[i2] = fArr3[i2] * a2;
            i = i2 + 1;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
        this.b.setPathEffect(new DashPathEffect(this.i, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.g().floatValue()));
        L.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        L.a("StrokeContent#draw");
        if (Utils.b(matrix)) {
            L.b("StrokeContent#draw");
            return;
        }
        this.b.setAlpha(MiscUtils.a((int) ((((i / 255.0f) * ((IntegerKeyframeAnimation) this.k).i()) / 100.0f) * 255.0f), 0, 255));
        this.b.setStrokeWidth(((FloatKeyframeAnimation) this.j).i() * Utils.a(matrix));
        if (this.b.getStrokeWidth() <= 0.0f) {
            L.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
        int i2 = 0;
        if (baseKeyframeAnimation != null) {
            this.b.setColorFilter(baseKeyframeAnimation.g());
            i2 = 0;
        }
        while (i2 < this.h.size()) {
            PathGroup pathGroup = this.h.get(i2);
            if (pathGroup.b != null) {
                a(canvas, pathGroup, matrix);
            } else {
                L.a("StrokeContent#buildPath");
                this.d.reset();
                int size = pathGroup.f4270a.size();
                while (true) {
                    int i3 = size - 1;
                    if (i3 < 0) {
                        break;
                    }
                    this.d.addPath(((PathContent) pathGroup.f4270a.get(i3)).e(), matrix);
                    size = i3;
                }
                L.b("StrokeContent#buildPath");
                L.a("StrokeContent#drawPath");
                canvas.drawPath(this.d, this.b);
                L.b("StrokeContent#drawPath");
            }
            i2++;
        }
        L.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        L.a("StrokeContent#getBounds");
        this.d.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                this.d.computeBounds(this.f, false);
                float i3 = ((FloatKeyframeAnimation) this.j).i();
                RectF rectF2 = this.f;
                float f = rectF2.left;
                float f2 = i3 / 2.0f;
                rectF2.set(f - f2, this.f.top - f2, this.f.right + f2, this.f.bottom + f2);
                rectF.set(this.f);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                L.b("StrokeContent#getBounds");
                return;
            }
            PathGroup pathGroup = this.h.get(i2);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < pathGroup.f4270a.size()) {
                    this.d.addPath(((PathContent) pathGroup.f4270a.get(i5)).e(), matrix);
                    i4 = i5 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.a(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.d) {
            this.k.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.o) {
            this.j.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f4268a.a(this.n);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent;
        PathGroup pathGroup;
        PathGroup pathGroup2;
        int size = list.size() - 1;
        TrimPathContent trimPathContent2 = null;
        while (true) {
            trimPathContent = trimPathContent2;
            if (size < 0) {
                break;
            }
            Content content = list.get(size);
            TrimPathContent trimPathContent3 = trimPathContent;
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent4 = (TrimPathContent) content;
                trimPathContent3 = trimPathContent;
                if (trimPathContent4.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent3 = trimPathContent4;
                }
            }
            size--;
            trimPathContent2 = trimPathContent3;
        }
        if (trimPathContent != null) {
            trimPathContent.a(this);
        }
        int size2 = list2.size() - 1;
        PathGroup pathGroup3 = null;
        while (true) {
            pathGroup = pathGroup3;
            if (size2 < 0) {
                break;
            }
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent5 = (TrimPathContent) content2;
                if (trimPathContent5.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.h.add(pathGroup);
                    }
                    pathGroup2 = new PathGroup(trimPathContent5);
                    trimPathContent5.a(this);
                    size2--;
                    pathGroup3 = pathGroup2;
                }
            }
            pathGroup2 = pathGroup;
            if (content2 instanceof PathContent) {
                pathGroup2 = pathGroup;
                if (pathGroup == null) {
                    pathGroup2 = new PathGroup(trimPathContent);
                }
                pathGroup2.f4270a.add((PathContent) content2);
            }
            size2--;
            pathGroup3 = pathGroup2;
        }
        if (pathGroup != null) {
            this.h.add(pathGroup);
        }
    }
}
