package com.blued.android.module.live_china.same.loadingIndicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.amap.api.maps.utils.SpatialRelationUtil;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConstants;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/loadingIndicator/BallSpinFadeLoaderIndicator.class */
public class BallSpinFadeLoaderIndicator extends BaseIndicatorController {
    float[] a = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    int[] b = {255, 255, 255, 255, 255, 255, 255, 255};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/loadingIndicator/BallSpinFadeLoaderIndicator$Point.class */
    public final class Point {
        public float a;
        public float b;

        public Point(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    Point a(int i, int i2, float f, double d) {
        double d2 = f;
        return new Point((float) ((i / 2) + (Math.cos(d) * d2)), (float) ((i2 / 2) + (d2 * Math.sin(d))));
    }

    @Override // com.blued.android.module.live_china.same.loadingIndicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {0, 120, 240, SpatialRelationUtil.A_CIRCLE_DEGREE, 480, 600, 720, 780, DatatypeConstants.MIN_TIMEZONE_OFFSET};
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= 8) {
                return arrayList;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i2]);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.same.loadingIndicator.BallSpinFadeLoaderIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.a[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallSpinFadeLoaderIndicator.this.e();
                }
            });
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 77, 255);
            ofInt.setDuration(1000L);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr[i2]);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.same.loadingIndicator.BallSpinFadeLoaderIndicator.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.b[i2] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallSpinFadeLoaderIndicator.this.e();
                }
            });
            ofInt.start();
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.live_china.same.loadingIndicator.BaseIndicatorController
    public void a(Canvas canvas, Paint paint) {
        float c = c() / 10;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return;
            }
            canvas.save();
            Point a = a(c(), d(), (c() / 2) - c, 0.7853981633974483d * i2);
            canvas.translate(a.a, a.b);
            float[] fArr = this.a;
            canvas.scale(fArr[i2], fArr[i2]);
            paint.setAlpha(this.b[i2]);
            canvas.drawCircle(0.0f, 0.0f, c, paint);
            canvas.restore();
            i = i2 + 1;
        }
    }
}
