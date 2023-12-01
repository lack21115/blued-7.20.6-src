package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/keyframe/PathKeyframe.class */
public class PathKeyframe extends Keyframe<PointF> {
    private Path h;
    private final Keyframe<PointF> i;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.a, keyframe.b, keyframe.c, keyframe.d, keyframe.e);
        this.i = keyframe;
        a();
    }

    public void a() {
        boolean z = (this.b == 0 || this.a == 0 || !((PointF) this.a).equals(((PointF) this.b).x, ((PointF) this.b).y)) ? false : true;
        if (this.b == 0 || z) {
            return;
        }
        this.h = Utils.a((PointF) this.a, (PointF) this.b, this.i.f, this.i.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path b() {
        return this.h;
    }
}
