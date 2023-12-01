package com.android.internal.widget.multiwaveview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/TargetDrawable.class */
public class TargetDrawable {
    private static final boolean DEBUG = false;
    private static final String TAG = "TargetDrawable";
    private Drawable mDrawable;
    private final int mResourceId;
    public static final int[] STATE_ACTIVE = {R.attr.state_enabled, R.attr.state_active};
    public static final int[] STATE_INACTIVE = {R.attr.state_enabled, -16842914};
    public static final int[] STATE_FOCUSED = {R.attr.state_enabled, -16842914, R.attr.state_focused};
    private float mTranslationX = 0.0f;
    private float mTranslationY = 0.0f;
    private float mPositionX = 0.0f;
    private float mPositionY = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mAlpha = 1.0f;
    private boolean mEnabled = true;

    public TargetDrawable(Resources resources, int i) {
        this.mResourceId = i;
        setDrawable(resources, i);
    }

    public TargetDrawable(TargetDrawable targetDrawable) {
        this.mResourceId = targetDrawable.mResourceId;
        this.mDrawable = targetDrawable.mDrawable != null ? targetDrawable.mDrawable.mutate() : null;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    private void resizeDrawables() {
        if (!(this.mDrawable instanceof StateListDrawable)) {
            if (this.mDrawable != null) {
                this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
                return;
            }
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) this.mDrawable;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= stateListDrawable.getStateCount()) {
                break;
            }
            Drawable stateDrawable = stateListDrawable.getStateDrawable(i4);
            i = Math.max(i, stateDrawable.getIntrinsicWidth());
            i2 = Math.max(i2, stateDrawable.getIntrinsicHeight());
            i3 = i4 + 1;
        }
        stateListDrawable.setBounds(0, 0, i, i2);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= stateListDrawable.getStateCount()) {
                return;
            }
            stateListDrawable.getStateDrawable(i6).setBounds(0, 0, i, i2);
            i5 = i6 + 1;
        }
    }

    public void draw(Canvas canvas) {
        if (this.mDrawable == null || !this.mEnabled) {
            return;
        }
        canvas.save(1);
        canvas.scale(this.mScaleX, this.mScaleY, this.mPositionX, this.mPositionY);
        canvas.translate(this.mTranslationX + this.mPositionX, this.mTranslationY + this.mPositionY);
        canvas.translate(getWidth() * (-0.5f), getHeight() * (-0.5f));
        this.mDrawable.setAlpha(Math.round(this.mAlpha * 255.0f));
        this.mDrawable.draw(canvas);
        canvas.restore();
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getHeight() {
        if (this.mDrawable != null) {
            return this.mDrawable.getIntrinsicHeight();
        }
        return 0;
    }

    public float getPositionX() {
        return this.mPositionX;
    }

    public float getPositionY() {
        return this.mPositionY;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getWidth() {
        if (this.mDrawable != null) {
            return this.mDrawable.getIntrinsicWidth();
        }
        return 0;
    }

    public float getX() {
        return this.mTranslationX;
    }

    public float getY() {
        return this.mTranslationY;
    }

    public boolean hasState(int[] iArr) {
        boolean z = false;
        if (this.mDrawable instanceof StateListDrawable) {
            z = false;
            if (((StateListDrawable) this.mDrawable).getStateDrawableIndex(iArr) != -1) {
                z = true;
            }
        }
        return z;
    }

    public boolean isActive() {
        if (!(this.mDrawable instanceof StateListDrawable)) {
            return false;
        }
        int[] state = ((StateListDrawable) this.mDrawable).getState();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= state.length) {
                return false;
            }
            if (state[i2] == 16842908) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isEnabled() {
        return this.mDrawable != null && this.mEnabled;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setDrawable(Resources resources, int i) {
        Drawable drawable = null;
        Drawable drawable2 = i == 0 ? null : resources.getDrawable(i);
        if (drawable2 != null) {
            drawable = drawable2.mutate();
        }
        this.mDrawable = drawable;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setPositionX(float f) {
        this.mPositionX = f;
    }

    public void setPositionY(float f) {
        this.mPositionY = f;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public void setState(int[] iArr) {
        if (this.mDrawable instanceof StateListDrawable) {
            ((StateListDrawable) this.mDrawable).setState(iArr);
        }
    }

    public void setX(float f) {
        this.mTranslationX = f;
    }

    public void setY(float f) {
        this.mTranslationY = f;
    }
}
