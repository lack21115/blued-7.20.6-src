package com.blued.community.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/VideoLoadingView.class */
public class VideoLoadingView extends View {
    private int alpha;
    private ValueAnimator animator;
    private Paint mPaint;
    private int screenWith;
    private int width;

    public VideoLoadingView(Context context) {
        super(context);
        init(context);
    }

    public VideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.parseColor("#FFFFFF"));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(5.0f);
        int width = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        this.screenWith = width;
        if (width == 0) {
            this.screenWith = 2160;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.animator = valueAnimator;
        int i = this.screenWith;
        valueAnimator.setFloatValues(i / 15, i);
        this.animator.setDuration(500L);
        this.animator.setRepeatCount(-1);
        this.animator.setInterpolator(new LinearInterpolator());
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.VideoLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                VideoLoadingView videoLoadingView = VideoLoadingView.this;
                videoLoadingView.alpha = (int) ((1.0f - ((floatValue / videoLoadingView.screenWith) / 2.0f)) * 255.0f);
                VideoLoadingView.this.width = (int) floatValue;
                VideoLoadingView.this.invalidate();
            }
        });
        this.animator.start();
    }

    public void cancelAnim() {
        this.animator.cancel();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setAlpha(this.alpha);
        int i = this.screenWith;
        int i2 = i / 2;
        int i3 = this.width;
        canvas.drawLine(i2 - (i3 / 2), 0.0f, (i / 2) + (i3 / 2), 0.0f, this.mPaint);
    }

    public void startAnim() {
        this.animator.start();
    }
}
