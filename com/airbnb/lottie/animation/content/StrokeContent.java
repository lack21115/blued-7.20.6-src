package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/StrokeContent.class */
public class StrokeContent extends BaseStrokeContent {

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f4293c;
    private final String d;
    private final boolean e;
    private final BaseKeyframeAnimation<Integer, Integer> f;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> g;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.g().a(), shapeStroke.h().a(), shapeStroke.i(), shapeStroke.c(), shapeStroke.d(), shapeStroke.e(), shapeStroke.f());
        this.f4293c = baseLayer;
        this.d = shapeStroke.a();
        this.e = shapeStroke.j();
        BaseKeyframeAnimation<Integer, Integer> a2 = shapeStroke.b().a();
        this.f = a2;
        a2.a(this);
        baseLayer.a(this.f);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        this.b.setColor(((ColorKeyframeAnimation) this.f).i());
        if (this.g != null) {
            this.b.setColorFilter(this.g.g());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        super.a((StrokeContent) t, (LottieValueCallback<StrokeContent>) lottieValueCallback);
        if (t == LottieProperty.b) {
            this.f.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.g = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.g = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f4293c.a(this.f);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.d;
    }
}
