package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeGroup.class */
public class ShapeGroup implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4364a;
    private final List<ContentModel> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4365c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.f4364a = str;
        this.b = list;
        this.f4365c = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4364a;
    }

    public List<ContentModel> b() {
        return this.b;
    }

    public boolean c() {
        return this.f4365c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f4364a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
