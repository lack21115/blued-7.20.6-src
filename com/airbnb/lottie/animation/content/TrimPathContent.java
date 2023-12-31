package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/TrimPathContent.class */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    private final String a;
    private final boolean b;
    private final List<BaseKeyframeAnimation.AnimationListener> c = new ArrayList();
    private final ShapeTrimPath.Type d;
    private final BaseKeyframeAnimation<?, Float> e;
    private final BaseKeyframeAnimation<?, Float> f;
    private final BaseKeyframeAnimation<?, Float> g;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.a();
        this.b = shapeTrimPath.e();
        this.d = shapeTrimPath.getType();
        this.e = shapeTrimPath.c().a();
        this.f = shapeTrimPath.b().a();
        this.g = shapeTrimPath.d().a();
        baseLayer.a(this.e);
        baseLayer.a(this.f);
        baseLayer.a(this.g);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return;
            }
            this.c.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.c.add(animationListener);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.a;
    }

    public BaseKeyframeAnimation<?, Float> c() {
        return this.e;
    }

    public BaseKeyframeAnimation<?, Float> d() {
        return this.f;
    }

    public BaseKeyframeAnimation<?, Float> e() {
        return this.g;
    }

    public boolean f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type getType() {
        return this.d;
    }
}
