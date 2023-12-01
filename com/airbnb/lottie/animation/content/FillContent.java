package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/FillContent.class */
public class FillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final BaseLayer c;
    private final String d;
    private final boolean e;
    private final BaseKeyframeAnimation<Integer, Integer> g;
    private final BaseKeyframeAnimation<Integer, Integer> h;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> i;
    private final LottieDrawable j;
    private final Path a = new Path();
    private final Paint b = new LPaint(1);
    private final List<PathContent> f = new ArrayList();

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        this.c = baseLayer;
        this.d = shapeFill.a();
        this.e = shapeFill.e();
        this.j = lottieDrawable;
        if (shapeFill.b() == null || shapeFill.c() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        this.a.setFillType(shapeFill.d());
        BaseKeyframeAnimation<Integer, Integer> a = shapeFill.b().a();
        this.g = a;
        a.a(this);
        baseLayer.a(this.g);
        BaseKeyframeAnimation<Integer, Integer> a2 = shapeFill.c().a();
        this.h = a2;
        a2.a(this);
        baseLayer.a(this.h);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        L.a("FillContent#draw");
        this.b.setColor(((ColorKeyframeAnimation) this.g).i());
        int intValue = (int) ((((i / 255.0f) * this.h.g().intValue()) / 100.0f) * 255.0f);
        this.b.setAlpha(MiscUtils.a(intValue, 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
        if (baseKeyframeAnimation != null) {
            this.b.setColorFilter(baseKeyframeAnimation.g());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).e(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        L.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.size()) {
                this.a.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
            this.a.addPath(this.f.get(i2).e(), matrix);
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.a(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.a) {
            this.g.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.d) {
            this.h.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.c.a(this.i);
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
                this.f.add((PathContent) content);
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.d;
    }
}
