package android.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/TransitionDrawable.class */
public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    private static final int TRANSITION_NONE = 2;
    private static final int TRANSITION_RUNNING = 1;
    private static final int TRANSITION_STARTING = 0;
    private int mAlpha;
    private boolean mCrossFade;
    private int mDuration;
    private int mFrom;
    private int mOriginalDuration;
    private boolean mReverse;
    private long mStartTimeMillis;
    private int mTo;
    private int mTransitionState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/TransitionDrawable$TransitionState.class */
    public static class TransitionState extends LayerDrawable.LayerState {
        TransitionState(TransitionState transitionState, TransitionDrawable transitionDrawable, Resources resources) {
            super(transitionState, transitionDrawable, resources);
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new TransitionDrawable(this, null);
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new TransitionDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources) null);
    }

    private TransitionDrawable(TransitionState transitionState, Resources resources) {
        super(transitionState, resources);
        this.mTransitionState = 2;
        this.mAlpha = 0;
    }

    private TransitionDrawable(TransitionState transitionState, Drawable[] drawableArr) {
        super(drawableArr, transitionState);
        this.mTransitionState = 2;
        this.mAlpha = 0;
    }

    public TransitionDrawable(Drawable[] drawableArr) {
        this(new TransitionState(null, null, null), drawableArr);
    }

    @Override // android.graphics.drawable.LayerDrawable
    LayerDrawable.LayerState createConstantState(LayerDrawable.LayerState layerState, Resources resources) {
        return new TransitionState((TransitionState) layerState, this, resources);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mTransitionState) {
            case 0:
                this.mStartTimeMillis = SystemClock.uptimeMillis();
                z = false;
                this.mTransitionState = 1;
                break;
            case 1:
                if (this.mStartTimeMillis >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTimeMillis)) / this.mDuration;
                    z = uptimeMillis >= 1.0f;
                    this.mAlpha = (int) (this.mFrom + ((this.mTo - this.mFrom) * Math.min(uptimeMillis, 1.0f)));
                    break;
                }
                break;
        }
        int i = this.mAlpha;
        boolean z2 = this.mCrossFade;
        LayerDrawable.ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        if (z) {
            if (!z2 || i == 0) {
                childDrawableArr[0].mDrawable.draw(canvas);
            }
            if (i == 255) {
                childDrawableArr[1].mDrawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable = childDrawableArr[0].mDrawable;
        if (z2) {
            drawable.setAlpha(255 - i);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(255);
        }
        if (i > 0) {
            Drawable drawable2 = childDrawableArr[1].mDrawable;
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(255);
        }
        if (z) {
            return;
        }
        invalidateSelf();
    }

    public boolean isCrossFadeEnabled() {
        return this.mCrossFade;
    }

    public void resetTransition() {
        this.mAlpha = 0;
        this.mTransitionState = 2;
        invalidateSelf();
    }

    public void reverseTransition(int i) {
        boolean z = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.mStartTimeMillis <= this.mDuration) {
            if (this.mReverse) {
                z = false;
            }
            this.mReverse = z;
            this.mFrom = this.mAlpha;
            this.mTo = this.mReverse ? 0 : 255;
            this.mDuration = (int) (this.mReverse ? uptimeMillis - this.mStartTimeMillis : this.mOriginalDuration - (uptimeMillis - this.mStartTimeMillis));
            this.mTransitionState = 0;
            return;
        }
        if (this.mTo == 0) {
            this.mFrom = 0;
            this.mTo = 255;
            this.mAlpha = 0;
            this.mReverse = false;
        } else {
            this.mFrom = 255;
            this.mTo = 0;
            this.mAlpha = 255;
            this.mReverse = true;
        }
        this.mOriginalDuration = i;
        this.mDuration = i;
        this.mTransitionState = 0;
        invalidateSelf();
    }

    public void setCrossFadeEnabled(boolean z) {
        this.mCrossFade = z;
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.mTo = 255;
        this.mAlpha = 0;
        this.mOriginalDuration = i;
        this.mDuration = i;
        this.mReverse = false;
        this.mTransitionState = 0;
        invalidateSelf();
    }
}
