package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/PolystarShape.class */
public class PolystarShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4352a;
    private final Type b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f4353c;
    private final AnimatableValue<PointF, PointF> d;
    private final AnimatableFloatValue e;
    private final AnimatableFloatValue f;
    private final AnimatableFloatValue g;
    private final AnimatableFloatValue h;
    private final AnimatableFloatValue i;
    private final boolean j;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/PolystarShape$Type.class */
    public enum Type {
        STAR(1),
        POLYGON(2);
        

        /* renamed from: c  reason: collision with root package name */
        private final int f4355c;

        Type(int i) {
            this.f4355c = i;
        }

        public static Type a(int i) {
            Type[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                Type type = values[i3];
                if (type.f4355c == i) {
                    return type;
                }
                i2 = i3 + 1;
            }
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z) {
        this.f4352a = str;
        this.b = type;
        this.f4353c = animatableFloatValue;
        this.d = animatableValue;
        this.e = animatableFloatValue2;
        this.f = animatableFloatValue3;
        this.g = animatableFloatValue4;
        this.h = animatableFloatValue5;
        this.i = animatableFloatValue6;
        this.j = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4352a;
    }

    public AnimatableFloatValue b() {
        return this.f4353c;
    }

    public AnimatableValue<PointF, PointF> c() {
        return this.d;
    }

    public AnimatableFloatValue d() {
        return this.e;
    }

    public AnimatableFloatValue e() {
        return this.f;
    }

    public AnimatableFloatValue f() {
        return this.g;
    }

    public AnimatableFloatValue g() {
        return this.h;
    }

    public Type getType() {
        return this.b;
    }

    public AnimatableFloatValue h() {
        return this.i;
    }

    public boolean i() {
        return this.j;
    }
}
