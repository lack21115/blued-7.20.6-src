package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Mask.class */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f4344a;
    private final AnimatableShapeValue b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableIntegerValue f4345c;
    private final boolean d;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/Mask$MaskMode.class */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.f4344a = maskMode;
        this.b = animatableShapeValue;
        this.f4345c = animatableIntegerValue;
        this.d = z;
    }

    public MaskMode a() {
        return this.f4344a;
    }

    public AnimatableShapeValue b() {
        return this.b;
    }

    public AnimatableIntegerValue c() {
        return this.f4345c;
    }

    public boolean d() {
        return this.d;
    }
}
