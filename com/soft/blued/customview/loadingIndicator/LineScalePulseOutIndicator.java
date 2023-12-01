package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/loadingIndicator/LineScalePulseOutIndicator.class */
public class LineScalePulseOutIndicator extends LineScaleIndicator {
    @Override // com.soft.blued.customview.loadingIndicator.LineScaleIndicator, com.soft.blued.customview.loadingIndicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= 5) {
                return arrayList;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(900L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(new long[]{500, 250, 0, 250, 500}[i2]);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.loadingIndicator.LineScalePulseOutIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScalePulseOutIndicator.this.f28615a[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScalePulseOutIndicator.this.e();
                }
            });
            ofFloat.start();
            arrayList.add(ofFloat);
            i = i2 + 1;
        }
    }
}
