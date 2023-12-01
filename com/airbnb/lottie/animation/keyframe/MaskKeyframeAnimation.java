package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/MaskKeyframeAnimation.class */
public class MaskKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f4299a;
    private final List<BaseKeyframeAnimation<Integer, Integer>> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f4300c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f4300c = list;
        this.f4299a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            this.f4299a.add(list.get(i2).b().a());
            this.b.add(list.get(i2).c().a());
            i = i2 + 1;
        }
    }

    public List<Mask> a() {
        return this.f4300c;
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> b() {
        return this.f4299a;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> c() {
        return this.b;
    }
}
