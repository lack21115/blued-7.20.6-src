package com.sobot.chat.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StPlayPauseDrawable.class */
public class StPlayPauseDrawable extends Drawable {
    private static final long PLAY_PAUSE_ANIMATION_DURATION = 250;
    private static final Property<StPlayPauseDrawable, Float> PROGRESS = new Property<StPlayPauseDrawable, Float>(Float.class, "progress") { // from class: com.sobot.chat.camera.StPlayPauseDrawable.1
        @Override // android.util.Property
        public Float get(StPlayPauseDrawable stPlayPauseDrawable) {
            return Float.valueOf(stPlayPauseDrawable.getProgress());
        }

        @Override // android.util.Property
        public void set(StPlayPauseDrawable stPlayPauseDrawable, Float f) {
            stPlayPauseDrawable.setProgress(f.floatValue());
        }
    };
    private Animator animator;
    private float height;
    private boolean isPlay;
    private boolean isPlaySet;
    private final float pauseBarDistance;
    private final float pauseBarHeight;
    private final float pauseBarWidth;
    private float progress;
    private float width;
    private final Path leftPauseBar = new Path();
    private final Path rightPauseBar = new Path();
    private final Paint paint = new Paint();

    public StPlayPauseDrawable(Context context) {
        Resources resources = context.getResources();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(-1);
        this.pauseBarWidth = TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
        this.pauseBarHeight = TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        this.pauseBarDistance = TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics());
    }

    private Animator getPausePlayAnimator() {
        this.isPlaySet = !this.isPlaySet;
        Property<StPlayPauseDrawable, Float> property = PROGRESS;
        float f = 1.0f;
        float f2 = this.isPlay ? 1.0f : 0.0f;
        if (this.isPlay) {
            f = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, property, f2, f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.sobot.chat.camera.StPlayPauseDrawable.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StPlayPauseDrawable stPlayPauseDrawable = StPlayPauseDrawable.this;
                stPlayPauseDrawable.isPlay = !stPlayPauseDrawable.isPlay;
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getProgress() {
        return this.progress;
    }

    private static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        this.progress = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.leftPauseBar.rewind();
        this.rightPauseBar.rewind();
        float f = 0.0f;
        float lerp = lerp(this.pauseBarDistance, 0.0f, this.progress);
        float lerp2 = lerp(this.pauseBarWidth, this.pauseBarHeight / 1.75f, this.progress);
        float f2 = lerp2;
        if (this.progress == 1.0f) {
            f2 = Math.round(lerp2);
        }
        float lerp3 = lerp(0.0f, f2, this.progress);
        float f3 = (f2 * 2.0f) + lerp;
        float f4 = lerp + f2;
        float lerp4 = lerp(f3, f4, this.progress);
        this.leftPauseBar.moveTo(0.0f, 0.0f);
        this.leftPauseBar.lineTo(lerp3, -this.pauseBarHeight);
        this.leftPauseBar.lineTo(f2, -this.pauseBarHeight);
        if (this.isPlay) {
            this.leftPauseBar.lineTo(f2 + 2.0f, 0.0f);
        } else {
            this.leftPauseBar.lineTo(f2, 0.0f);
        }
        this.leftPauseBar.close();
        if (this.isPlay) {
            this.rightPauseBar.moveTo(f4 - 1.0f, 0.0f);
        } else {
            this.rightPauseBar.moveTo(f4, 0.0f);
        }
        this.rightPauseBar.lineTo(f4, -this.pauseBarHeight);
        this.rightPauseBar.lineTo(lerp4, -this.pauseBarHeight);
        this.rightPauseBar.lineTo(f3, 0.0f);
        this.rightPauseBar.close();
        int save = canvas.save();
        canvas.translate(lerp(0.0f, this.pauseBarHeight / 8.0f, this.progress), 0.0f);
        float f5 = this.isPlay ? 1.0f - this.progress : this.progress;
        if (this.isPlay) {
            f = 90.0f;
        }
        canvas.rotate(lerp(f, 90.0f + f, f5), this.width / 2.0f, this.height / 2.0f);
        canvas.translate(Math.round((this.width / 2.0f) - (f3 / 2.0f)), Math.round((this.height / 2.0f) + (this.pauseBarHeight / 2.0f)));
        canvas.drawPath(this.leftPauseBar, this.paint);
        canvas.drawPath(this.rightPauseBar, this.paint);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isPlay() {
        return this.isPlay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        this.width = rect.width();
        this.height = rect.height();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setPause(boolean z) {
        if (z) {
            if (this.isPlaySet) {
                togglePlayPause();
                return;
            }
            return;
        }
        this.isPlaySet = false;
        this.isPlay = false;
        setProgress(0.0f);
    }

    public void setPlay(boolean z) {
        if (z) {
            if (this.isPlaySet) {
                return;
            }
            togglePlayPause();
            return;
        }
        this.isPlaySet = true;
        this.isPlay = true;
        setProgress(1.0f);
    }

    public void togglePlayPause() {
        Animator animator = this.animator;
        if (animator != null) {
            animator.cancel();
        }
        Animator pausePlayAnimator = getPausePlayAnimator();
        this.animator = pausePlayAnimator;
        pausePlayAnimator.setInterpolator(new DecelerateInterpolator());
        this.animator.setDuration(PLAY_PAUSE_ANIMATION_DURATION);
        this.animator.start();
    }
}
