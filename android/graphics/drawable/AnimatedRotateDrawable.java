package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/AnimatedRotateDrawable.class */
public class AnimatedRotateDrawable extends Drawable implements Drawable.Callback, Runnable, Animatable {
    private static final String TAG = "AnimatedRotateDrawable";
    private float mCurrentDegrees;
    private float mIncrement;
    private boolean mMutated;
    private boolean mRunning;
    private AnimatedRotateState mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/AnimatedRotateDrawable$AnimatedRotateState.class */
    public static final class AnimatedRotateState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mFrameDuration;
        int mFramesCount;
        float mPivotX;
        boolean mPivotXRel;
        float mPivotY;
        boolean mPivotYRel;
        int[] mThemeAttrs;

        public AnimatedRotateState(AnimatedRotateState animatedRotateState, AnimatedRotateDrawable animatedRotateDrawable, Resources resources) {
            this.mPivotXRel = false;
            this.mPivotX = 0.0f;
            this.mPivotYRel = false;
            this.mPivotY = 0.0f;
            this.mFrameDuration = 150;
            this.mFramesCount = 12;
            if (animatedRotateState != null) {
                if (resources != null) {
                    this.mDrawable = animatedRotateState.mDrawable.getConstantState().newDrawable(resources);
                } else {
                    this.mDrawable = animatedRotateState.mDrawable.getConstantState().newDrawable();
                }
                this.mDrawable.setCallback(animatedRotateDrawable);
                this.mDrawable.setLayoutDirection(animatedRotateState.mDrawable.getLayoutDirection());
                this.mDrawable.setBounds(animatedRotateState.mDrawable.getBounds());
                this.mDrawable.setLevel(animatedRotateState.mDrawable.getLevel());
                this.mThemeAttrs = animatedRotateState.mThemeAttrs;
                this.mPivotXRel = animatedRotateState.mPivotXRel;
                this.mPivotX = animatedRotateState.mPivotX;
                this.mPivotYRel = animatedRotateState.mPivotYRel;
                this.mPivotY = animatedRotateState.mPivotY;
                this.mFramesCount = animatedRotateState.mFramesCount;
                this.mFrameDuration = animatedRotateState.mFrameDuration;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) {
                return (this.mDrawable != null && this.mDrawable.canApplyTheme()) || super.canApplyTheme();
            }
            return true;
        }

        public boolean canConstantState() {
            if (!this.mCheckedConstantState) {
                this.mCanConstantState = this.mDrawable.getConstantState() != null;
                this.mCheckedConstantState = true;
            }
            return this.mCanConstantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedRotateDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedRotateDrawable(this, resources);
        }
    }

    public AnimatedRotateDrawable() {
        this(null, null);
    }

    private AnimatedRotateDrawable(AnimatedRotateState animatedRotateState, Resources resources) {
        this.mState = new AnimatedRotateState(animatedRotateState, this, resources);
        init();
    }

    private void inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedRotateState animatedRotateState = this.mState;
        Drawable drawable = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next == 2) {
                Drawable createFromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                drawable = createFromXmlInner;
                if (createFromXmlInner == null) {
                    Log.w(TAG, "Bad element under <animated-rotate>: " + xmlPullParser.getName());
                    drawable = createFromXmlInner;
                }
            }
        }
        if (drawable != null) {
            animatedRotateState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void init() {
        AnimatedRotateState animatedRotateState = this.mState;
        this.mIncrement = 360.0f / animatedRotateState.mFramesCount;
        Drawable drawable = animatedRotateState.mDrawable;
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
        }
    }

    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + this.mState.mFrameDuration);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        AnimatedRotateState animatedRotateState = this.mState;
        animatedRotateState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        animatedRotateState.mThemeAttrs = typedArray.extractThemeAttrs();
        if (typedArray.hasValue(2)) {
            TypedValue peekValue = typedArray.peekValue(2);
            animatedRotateState.mPivotXRel = peekValue.type == 6;
            animatedRotateState.mPivotX = animatedRotateState.mPivotXRel ? peekValue.getFraction(1.0f, 1.0f) : peekValue.getFloat();
        }
        if (typedArray.hasValue(3)) {
            TypedValue peekValue2 = typedArray.peekValue(3);
            boolean z = false;
            if (peekValue2.type == 6) {
                z = true;
            }
            animatedRotateState.mPivotYRel = z;
            animatedRotateState.mPivotY = animatedRotateState.mPivotYRel ? peekValue2.getFraction(1.0f, 1.0f) : peekValue2.getFloat();
        }
        setFramesCount(typedArray.getInt(5, animatedRotateState.mFramesCount));
        setFramesDuration(typedArray.getInt(4, animatedRotateState.mFrameDuration));
        Drawable drawable = typedArray.getDrawable(1);
        if (drawable != null) {
            animatedRotateState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mDrawable == null) {
            if (this.mState.mThemeAttrs == null || this.mState.mThemeAttrs[1] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <animated-rotate> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        AnimatedRotateState animatedRotateState = this.mState;
        if (animatedRotateState == null) {
            return;
        }
        if (animatedRotateState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(animatedRotateState.mThemeAttrs, R.styleable.AnimatedRotateDrawable);
            try {
                try {
                    updateStateFromTypedArray(resolveAttributes);
                    verifyRequiredAttributes(resolveAttributes);
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                resolveAttributes.recycle();
            }
        }
        if (animatedRotateState.mDrawable != null && animatedRotateState.mDrawable.canApplyTheme()) {
            animatedRotateState.mDrawable.applyTheme(theme);
        }
        init();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mState != null && this.mState.canApplyTheme()) || super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mState.mDrawable.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        AnimatedRotateState animatedRotateState = this.mState;
        Drawable drawable = animatedRotateState.mDrawable;
        Rect bounds = drawable.getBounds();
        canvas.rotate(this.mCurrentDegrees, bounds.left + (animatedRotateState.mPivotXRel ? (bounds.right - bounds.left) * animatedRotateState.mPivotX : animatedRotateState.mPivotX), bounds.top + (animatedRotateState.mPivotYRel ? (bounds.bottom - bounds.top) * animatedRotateState.mPivotY : animatedRotateState.mPivotY));
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mState.mDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mState.mChangingConfigurations | this.mState.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mState.canConstantState()) {
            this.mState.mChangingConfigurations = getChangingConfigurations();
            return this.mState;
        }
        return null;
    }

    public Drawable getDrawable() {
        return this.mState.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mState.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mState.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mState.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.mState.mDrawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedRotateDrawable);
        super.inflateWithAttributes(resources, xmlPullParser, obtainAttributes, 0);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        inflateChildElements(resources, xmlPullParser, attributeSet, theme);
        init();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mState.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState.mDrawable.mutate();
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mState.mDrawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.mState.mDrawable.setLevel(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return this.mState.mDrawable.setState(iArr);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCurrentDegrees += this.mIncrement;
        if (this.mCurrentDegrees > 360.0f - this.mIncrement) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidateSelf();
        nextFrame();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mState.mDrawable.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mState.mDrawable.setColorFilter(colorFilter);
    }

    public void setFramesCount(int i) {
        this.mState.mFramesCount = i;
        this.mIncrement = 360.0f / this.mState.mFramesCount;
    }

    public void setFramesDuration(int i) {
        this.mState.mFrameDuration = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mState.mDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mState.mDrawable.setTintMode(mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.mState.mDrawable.setVisible(z, z2);
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            unscheduleSelf(this);
            return visible;
        }
        if (visible || z2) {
            this.mCurrentDegrees = 0.0f;
            nextFrame();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        nextFrame();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mRunning = false;
        unscheduleSelf(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
