package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/RotateDrawable.class */
public class RotateDrawable extends Drawable implements Drawable.Callback {
    private static final float MAX_LEVEL = 10000.0f;
    private boolean mMutated;
    private final RotateState mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/RotateDrawable$RotateState.class */
    public static final class RotateState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        float mCurrentDegrees;
        Drawable mDrawable;
        float mFromDegrees;
        float mPivotX;
        boolean mPivotXRel;
        float mPivotY;
        boolean mPivotYRel;
        int[] mThemeAttrs;
        float mToDegrees;

        RotateState(RotateState rotateState, RotateDrawable rotateDrawable, Resources resources) {
            this.mPivotXRel = true;
            this.mPivotX = 0.5f;
            this.mPivotYRel = true;
            this.mPivotY = 0.5f;
            this.mFromDegrees = 0.0f;
            this.mToDegrees = 360.0f;
            this.mCurrentDegrees = 0.0f;
            if (rotateState != null) {
                this.mThemeAttrs = rotateState.mThemeAttrs;
                this.mChangingConfigurations = rotateState.mChangingConfigurations;
                if (resources != null) {
                    this.mDrawable = rotateState.mDrawable.getConstantState().newDrawable(resources);
                } else {
                    this.mDrawable = rotateState.mDrawable.getConstantState().newDrawable();
                }
                this.mDrawable.setCallback(rotateDrawable);
                this.mDrawable.setLayoutDirection(rotateState.mDrawable.getLayoutDirection());
                this.mDrawable.setBounds(rotateState.mDrawable.getBounds());
                this.mDrawable.setLevel(rotateState.mDrawable.getLevel());
                this.mPivotXRel = rotateState.mPivotXRel;
                this.mPivotX = rotateState.mPivotX;
                this.mPivotYRel = rotateState.mPivotYRel;
                this.mPivotY = rotateState.mPivotY;
                this.mFromDegrees = rotateState.mFromDegrees;
                this.mToDegrees = rotateState.mToDegrees;
                this.mCurrentDegrees = rotateState.mCurrentDegrees;
                this.mCanConstantState = true;
                this.mCheckedConstantState = true;
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
            return new RotateDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new RotateDrawable(this, resources);
        }
    }

    public RotateDrawable() {
        this(null, null);
    }

    private RotateDrawable(RotateState rotateState, Resources resources) {
        this.mState = new RotateState(rotateState, this, resources);
    }

    private void inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next == 2) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            this.mState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        RotateState rotateState = this.mState;
        rotateState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        rotateState.mThemeAttrs = typedArray.extractThemeAttrs();
        if (typedArray.hasValue(4)) {
            TypedValue peekValue = typedArray.peekValue(4);
            rotateState.mPivotXRel = peekValue.type == 6;
            rotateState.mPivotX = rotateState.mPivotXRel ? peekValue.getFraction(1.0f, 1.0f) : peekValue.getFloat();
        }
        if (typedArray.hasValue(5)) {
            TypedValue peekValue2 = typedArray.peekValue(5);
            boolean z = false;
            if (peekValue2.type == 6) {
                z = true;
            }
            rotateState.mPivotYRel = z;
            rotateState.mPivotY = rotateState.mPivotYRel ? peekValue2.getFraction(1.0f, 1.0f) : peekValue2.getFloat();
        }
        rotateState.mFromDegrees = typedArray.getFloat(2, rotateState.mFromDegrees);
        rotateState.mToDegrees = typedArray.getFloat(3, rotateState.mToDegrees);
        rotateState.mCurrentDegrees = rotateState.mFromDegrees;
        Drawable drawable = typedArray.getDrawable(1);
        if (drawable != null) {
            rotateState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mDrawable == null) {
            if (this.mState.mThemeAttrs == null || this.mState.mThemeAttrs[0] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <rotate> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        RotateState rotateState = this.mState;
        if (rotateState == null) {
            return;
        }
        if (rotateState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(rotateState.mThemeAttrs, R.styleable.RotateDrawable);
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
        if (rotateState.mDrawable == null || !rotateState.mDrawable.canApplyTheme()) {
            return;
        }
        rotateState.mDrawable.applyTheme(theme);
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
        RotateState rotateState = this.mState;
        Drawable drawable = rotateState.mDrawable;
        Rect bounds = drawable.getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = bounds.bottom;
        int i4 = bounds.top;
        float f = rotateState.mPivotXRel ? (i - i2) * rotateState.mPivotX : rotateState.mPivotX;
        float f2 = rotateState.mPivotYRel ? (i3 - i4) * rotateState.mPivotY : rotateState.mPivotY;
        int save = canvas.save();
        canvas.rotate(rotateState.mCurrentDegrees, bounds.left + f, bounds.top + f2);
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

    public float getFromDegrees() {
        return this.mState.mFromDegrees;
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

    public float getPivotX() {
        return this.mState.mPivotX;
    }

    public float getPivotY() {
        return this.mState.mPivotY;
    }

    public float getToDegrees() {
        return this.mState.mToDegrees;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.RotateDrawable);
        super.inflateWithAttributes(resources, xmlPullParser, obtainAttributes, 0);
        this.mState.mDrawable = null;
        updateStateFromTypedArray(obtainAttributes);
        inflateChildElements(resources, xmlPullParser, attributeSet, theme);
        verifyRequiredAttributes(obtainAttributes);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isPivotXRelative() {
        return this.mState.mPivotXRel;
    }

    public boolean isPivotYRelative() {
        return this.mState.mPivotYRel;
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
        this.mState.mDrawable.setLevel(i);
        onBoundsChange(getBounds());
        this.mState.mCurrentDegrees = this.mState.mFromDegrees + ((this.mState.mToDegrees - this.mState.mFromDegrees) * (i / 10000.0f));
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean state = this.mState.mDrawable.setState(iArr);
        onBoundsChange(getBounds());
        return state;
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

    public void setDrawable(Drawable drawable) {
        Drawable drawable2 = this.mState.mDrawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mState.mDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }
    }

    public void setFromDegrees(float f) {
        if (this.mState.mFromDegrees != f) {
            this.mState.mFromDegrees = f;
            invalidateSelf();
        }
    }

    public void setPivotX(float f) {
        if (this.mState.mPivotX != f) {
            this.mState.mPivotX = f;
            invalidateSelf();
        }
    }

    public void setPivotXRelative(boolean z) {
        if (this.mState.mPivotXRel != z) {
            this.mState.mPivotXRel = z;
            invalidateSelf();
        }
    }

    public void setPivotY(float f) {
        if (this.mState.mPivotY != f) {
            this.mState.mPivotY = f;
            invalidateSelf();
        }
    }

    public void setPivotYRelative(boolean z) {
        if (this.mState.mPivotYRel != z) {
            this.mState.mPivotYRel = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mState.mDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mState.mDrawable.setTintMode(mode);
    }

    public void setToDegrees(float f) {
        if (this.mState.mToDegrees != f) {
            this.mState.mToDegrees = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.mState.mDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
