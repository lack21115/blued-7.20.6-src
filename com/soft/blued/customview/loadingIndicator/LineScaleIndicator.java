package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/loadingIndicator/LineScaleIndicator.class */
public class LineScaleIndicator extends BaseIndicatorController {

    /* renamed from: a  reason: collision with root package name */
    float[] f28615a = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    @Override // com.soft.blued.customview.loadingIndicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= 5) {
                return arrayList;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(new long[]{100, 200, 300, 400, 500}[i2]);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.loadingIndicator.LineScaleIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScaleIndicator.this.f28615a[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScaleIndicator.this.e();
                }
            });
            ofFloat.start();
            arrayList.add(ofFloat);
            i = i2 + 1;
        }
    }

    @Override // com.soft.blued.customview.loadingIndicator.BaseIndicatorController
    public void a(Canvas canvas, Paint paint) {
        float c2 = c() / 11;
        float d = d() / 2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return;
            }
            canvas.save();
            float f = c2 / 2.0f;
            canvas.translate((((i2 * 2) + 2) * c2) - f, d);
            canvas.scale(1.0f, this.f28615a[i2]);
            canvas.drawRoundRect(new RectF((-c2) / 2.0f, (-d()) / 2.5f, f, d() / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
            i = i2 + 1;
        }
    }
}
