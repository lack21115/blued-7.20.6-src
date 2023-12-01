package com.blued.android.framework.view.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/BadgeAnimator.class */
public class BadgeAnimator extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private BitmapFragment[][] f10200a;
    private WeakReference<QBadgeView> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/BadgeAnimator$BitmapFragment.class */
    public class BitmapFragment {

        /* renamed from: a  reason: collision with root package name */
        Random f10203a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        float f10204c;
        float d;
        int e;
        int f;
        Paint g;

        public BitmapFragment() {
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setStyle(Paint.Style.FILL);
            this.f10203a = new Random();
        }

        public void a(float f, Canvas canvas) {
            this.g.setColor(this.e);
            this.b += this.f10203a.nextInt(this.f) * 0.1f * (this.f10203a.nextFloat() - 0.5f);
            float nextInt = this.f10204c + (this.f10203a.nextInt(this.f) * 0.1f * (this.f10203a.nextFloat() - 0.5f));
            this.f10204c = nextInt;
            float f2 = this.b;
            float f3 = this.d;
            canvas.drawCircle(f2, nextInt, f3 - (f * f3), this.g);
        }
    }

    public BadgeAnimator(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView, final boolean z) {
        this.b = new WeakReference<>(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f10200a = a(bitmap, pointF);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.view.badgeview.BadgeAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QBadgeView qBadgeView2 = (QBadgeView) BadgeAnimator.this.b.get();
                if (qBadgeView2 == null || !qBadgeView2.isShown()) {
                    BadgeAnimator.this.cancel();
                } else {
                    qBadgeView2.invalidate();
                }
            }
        });
        addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.framework.view.badgeview.BadgeAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QBadgeView qBadgeView2 = (QBadgeView) BadgeAnimator.this.b.get();
                if (qBadgeView2 != null) {
                    qBadgeView2.b();
                    if (z) {
                        qBadgeView2.e(5);
                    }
                }
            }
        });
    }

    private BitmapFragment[][] a(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float f = pointF.x;
        float width2 = bitmap.getWidth() / 2.0f;
        float f2 = pointF.y;
        float height2 = bitmap.getHeight() / 2.0f;
        BitmapFragment[][] bitmapFragmentArr = (BitmapFragment[][]) Array.newInstance(BitmapFragment.class, (int) (height / min), (int) (width / min));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bitmapFragmentArr.length) {
                bitmap.recycle();
                return bitmapFragmentArr;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < bitmapFragmentArr[i2].length) {
                    BitmapFragment bitmapFragment = new BitmapFragment();
                    float f3 = i4 * min;
                    int i5 = (int) f3;
                    float f4 = i2 * min;
                    bitmapFragment.e = bitmap.getPixel(i5, (int) f4);
                    bitmapFragment.b = f3 + (f - width2);
                    bitmapFragment.f10204c = f4 + (f2 - height2);
                    bitmapFragment.d = min;
                    bitmapFragment.f = Math.max(width, height);
                    bitmapFragmentArr[i2][i4] = bitmapFragment;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void a(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f10200a.length) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                BitmapFragment[][] bitmapFragmentArr = this.f10200a;
                if (i4 < bitmapFragmentArr[i2].length) {
                    bitmapFragmentArr[i2][i4].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }
}
