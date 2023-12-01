package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/view/LoadingBar.class */
public class LoadingBar extends TextView {
    private static final int MAX_PROGRESS = 100;
    private Handler mHander;
    private Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private Runnable mRunnable;

    public LoadingBar(Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.component.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.this.mProgress++;
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.component.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.this.mProgress++;
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.component.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.this.mProgress++;
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }

    private Rect getRect() {
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.mProgress) / 100)) - getLeft(), getBottom() - getTop());
    }

    private void init(Context context) {
        this.mHander = new Handler();
        this.mPaint = new Paint();
        initSkin();
    }

    public void drawProgress(int i) {
        if (i < 7) {
            this.mHander.postDelayed(this.mRunnable, 70L);
        } else {
            this.mHander.removeCallbacks(this.mRunnable);
            this.mProgress = i;
        }
        invalidate();
    }

    public void initSkin() {
        this.mProgressColor = -11693826;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawRect(getRect(), this.mPaint);
    }
}
