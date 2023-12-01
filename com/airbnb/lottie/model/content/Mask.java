package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Mask.class */
public class Mask {
    private final MaskMode a;
    private final AnimatableShapeValue b;
    private final AnimatableIntegerValue c;
    private final boolean d;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Mask$MaskMode.class */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.a = maskMode;
        this.b = animatableShapeValue;
        this.c = animatableIntegerValue;
        this.d = z;
    }

    public MaskMode a() {
        return this.a;
    }

    public AnimatableShapeValue b() {
        return this.b;
    }

    public AnimatableIntegerValue c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
