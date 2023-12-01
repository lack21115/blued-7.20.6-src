package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/ShapeContent.class */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4292c;
    private final LottieDrawable d;
    private final BaseKeyframeAnimation<?, Path> e;
    private boolean f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f4291a = new Path();
    private CompoundTrimPathContent g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.b = shapePath.a();
        this.f4292c = shapePath.c();
        this.d = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> a2 = shapePath.b().a();
        this.e = a2;
        baseLayer.a(a2);
        this.e.a(this);
    }

    private void c() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        c();
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
                    this.g.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        if (this.f) {
            return this.f4291a;
        }
        this.f4291a.reset();
        if (this.f4292c) {
            this.f = true;
            return this.f4291a;
        }
        this.f4291a.set(this.e.g());
        this.f4291a.setFillType(Path.FillType.EVEN_ODD);
        this.g.a(this.f4291a);
        this.f = true;
        return this.f4291a;
    }
}
