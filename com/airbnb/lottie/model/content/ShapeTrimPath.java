package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.alipay.sdk.util.i;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeTrimPath.class */
public class ShapeTrimPath implements ContentModel {
    private final String a;
    private final Type b;
    private final AnimatableFloatValue c;
    private final AnimatableFloatValue d;
    private final AnimatableFloatValue e;
    private final boolean f;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeTrimPath$Type.class */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type a(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.a = str;
        this.b = type;
        this.c = animatableFloatValue;
        this.d = animatableFloatValue2;
        this.e = animatableFloatValue3;
        this.f = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String a() {
        return this.a;
    }

    public AnimatableFloatValue b() {
        return this.d;
    }

    public AnimatableFloatValue c() {
        return this.c;
    }

    public AnimatableFloatValue d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public Type getType() {
        return this.b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + i.d;
    }
}
