package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/RepeaterContent.class */
public class RepeaterContent implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f4289a = new Matrix();
    private final Path b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f4290c;
    private final BaseLayer d;
    private final String e;
    private final boolean f;
    private final BaseKeyframeAnimation<Float, Float> g;
    private final BaseKeyframeAnimation<Float, Float> h;
    private final TransformKeyframeAnimation i;
    private ContentGroup j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f4290c = lottieDrawable;
        this.d = baseLayer;
        this.e = repeater.a();
        this.f = repeater.e();
        BaseKeyframeAnimation<Float, Float> a2 = repeater.b().a();
        this.g = a2;
        baseLayer.a(a2);
        this.g.a(this);
        BaseKeyframeAnimation<Float, Float> a3 = repeater.c().a();
        this.h = a3;
        baseLayer.a(a3);
        this.h.a(this);
        TransformKeyframeAnimation j = repeater.d().j();
        this.i = j;
        j.a(baseLayer);
        this.i.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f4290c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.g.g().floatValue();
        float floatValue2 = this.h.g().floatValue();
        float floatValue3 = this.i.b().g().floatValue() / 100.0f;
        float floatValue4 = this.i.c().g().floatValue() / 100.0f;
        int i2 = (int) floatValue;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                return;
            }
            this.f4289a.set(matrix);
            float f = i3;
            this.f4289a.preConcat(this.i.b(f + floatValue2));
            this.j.a(canvas, this.f4289a, (int) (i * MiscUtils.a(floatValue3, floatValue4, f / floatValue)));
            i2 = i3;
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.a(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.i.a(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.q) {
            this.g.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t == LottieProperty.r) {
            this.h.a((LottieValueCallback<Float>) lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        this.j.a(list, list2);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void a(ListIterator<Content> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new ContentGroup(this.f4290c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        Path e = this.j.e();
        this.b.reset();
        float floatValue = this.g.g().floatValue();
        float floatValue2 = this.h.g().floatValue();
        int i = (int) floatValue;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return this.b;
            }
            this.f4289a.set(this.i.b(i2 + floatValue2));
            this.b.addPath(e, this.f4289a);
            i = i2;
        }
    }
}
