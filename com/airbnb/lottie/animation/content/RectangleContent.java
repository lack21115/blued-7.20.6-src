package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/RectangleContent.class */
public class RectangleContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String c;
    private final boolean d;
    private final LottieDrawable e;
    private final BaseKeyframeAnimation<?, PointF> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    private boolean j;
    private final Path a = new Path();
    private final RectF b = new RectF();
    private CompoundTrimPathContent i = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.c = rectangleShape.a();
        this.d = rectangleShape.e();
        this.e = lottieDrawable;
        this.f = rectangleShape.d().a();
        this.g = rectangleShape.c().a();
        this.h = rectangleShape.b().a();
        baseLayer.a(this.f);
        baseLayer.a(this.g);
        baseLayer.a(this.h);
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
    }

    private void c() {
        this.j = false;
        this.e.invalidateSelf();
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
        if (t == LottieProperty.h) {
            this.g.a((LottieValueCallback<PointF>) lottieValueCallback);
        } else if (t == LottieProperty.j) {
            this.f.a((LottieValueCallback<PointF>) lottieValueCallback);
        } else if (t == LottieProperty.i) {
            this.h.a((LottieValueCallback<Float>) lottieValueCallback);
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
                    this.i.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF g = this.g.g();
        float f = g.x / 2.0f;
        float f2 = g.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        float i = baseKeyframeAnimation == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation).i();
        float min = Math.min(f, f2);
        float f3 = i;
        if (i > min) {
            f3 = min;
        }
        PointF g2 = this.f.g();
        this.a.moveTo(g2.x + f, (g2.y - f2) + f3);
        this.a.lineTo(g2.x + f, (g2.y + f2) - f3);
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 > 0) {
            RectF rectF = this.b;
            float f4 = g2.x;
            float f5 = f3 * 2.0f;
            rectF.set((f4 + f) - f5, (g2.y + f2) - f5, g2.x + f, g2.y + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((g2.x - f) + f3, g2.y + f2);
        if (i2 > 0) {
            RectF rectF2 = this.b;
            float f6 = g2.x;
            float f7 = g2.y;
            float f8 = f3 * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (g2.x - f) + f8, g2.y + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(g2.x - f, (g2.y - f2) + f3);
        if (i2 > 0) {
            RectF rectF3 = this.b;
            float f9 = g2.x;
            float f10 = g2.y;
            float f11 = g2.x;
            float f12 = f3 * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f11 - f) + f12, (g2.y - f2) + f12);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((g2.x + f) - f3, g2.y - f2);
        if (i2 > 0) {
            RectF rectF4 = this.b;
            float f13 = g2.x;
            float f14 = f3 * 2.0f;
            rectF4.set((f13 + f) - f14, g2.y - f2, g2.x + f, (g2.y - f2) + f14);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.a(this.a);
        this.j = true;
        return this.a;
    }
}
