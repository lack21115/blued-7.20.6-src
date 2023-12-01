package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/ShapeKeyframeAnimation.class */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: c  reason: collision with root package name */
    private final ShapeData f4304c;
    private final Path d;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.f4304c = new ShapeData();
        this.d = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: b */
    public Path a(Keyframe<ShapeData> keyframe, float f) {
        this.f4304c.a(keyframe.f4418a, keyframe.b, f);
        MiscUtils.a(this.f4304c, this.d);
        return this.d;
    }
}
