package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewDebug;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ColorDrawable.class */
public class ColorDrawable extends Drawable {
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "state_")
    private ColorState mColorState;
    private boolean mMutated;
    private final Paint mPaint;
    private PorterDuffColorFilter mTintFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ColorDrawable$ColorState.class */
    public static final class ColorState extends Drawable.ConstantState {
        int mBaseColor;
        int mChangingConfigurations;
        int[] mThemeAttrs;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        @ViewDebug.ExportedProperty
        int mUseColor;

        ColorState() {
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
        }

        ColorState(ColorState colorState) {
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mThemeAttrs = colorState.mThemeAttrs;
            this.mBaseColor = colorState.mBaseColor;
            this.mUseColor = colorState.mUseColor;
            this.mChangingConfigurations = colorState.mChangingConfigurations;
            this.mTint = colorState.mTint;
            this.mTintMode = colorState.mTintMode;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ColorDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ColorDrawable(this);
        }
    }

    public ColorDrawable() {
        this.mPaint = new Paint();
        this.mColorState = new ColorState();
    }

    public ColorDrawable(int i) {
        this.mPaint = new Paint();
        this.mColorState = new ColorState();
        setColor(i);
    }

    private ColorDrawable(ColorState colorState) {
        this.mPaint = new Paint();
        this.mColorState = colorState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorState.mTint, colorState.mTintMode);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        ColorState colorState = this.mColorState;
        colorState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        colorState.mThemeAttrs = typedArray.extractThemeAttrs();
        colorState.mBaseColor = typedArray.getColor(0, colorState.mBaseColor);
        colorState.mUseColor = colorState.mBaseColor;
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        ColorState colorState = this.mColorState;
        if (colorState == null || colorState.mThemeAttrs == null) {
            return;
        }
        TypedArray resolveAttributes = theme.resolveAttributes(colorState.mThemeAttrs, R.styleable.ColorDrawable);
        updateStateFromTypedArray(resolveAttributes);
        resolveAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.mColorState.canApplyTheme() || super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ColorFilter colorFilter = this.mPaint.getColorFilter();
        if ((this.mColorState.mUseColor >>> 24) == 0 && colorFilter == null && this.mTintFilter == null) {
            return;
        }
        if (colorFilter == null) {
            this.mPaint.setColorFilter(this.mTintFilter);
        }
        this.mPaint.setColor(this.mColorState.mUseColor);
        canvas.drawRect(getBounds(), this.mPaint);
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mColorState.mUseColor >>> 24;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mColorState.mChangingConfigurations;
    }

    public int getColor() {
        return this.mColorState.mUseColor;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mColorState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mTintFilter == null && this.mPaint.getColorFilter() == null) {
            switch (this.mColorState.mUseColor >>> 24) {
                case 0:
                    return -2;
                case 255:
                    return -1;
                default:
                    return -3;
            }
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.ColorDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mColorState.mTint != null && this.mColorState.mTint.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mColorState = new ColorState(this.mColorState);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorState colorState = this.mColorState;
        if (colorState.mTint == null || colorState.mTintMode == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorState.mTint, colorState.mTintMode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        int i2 = ((this.mColorState.mBaseColor << 8) >>> 8) | ((((this.mColorState.mBaseColor >>> 24) * (i + (i >> 7))) >> 8) << 24);
        if (this.mColorState.mUseColor != i2) {
            this.mColorState.mUseColor = i2;
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (this.mColorState.mBaseColor == i && this.mColorState.mUseColor == i) {
            return;
        }
        ColorState colorState = this.mColorState;
        this.mColorState.mUseColor = i;
        colorState.mBaseColor = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mColorState.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, this.mColorState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mColorState.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTintFilter, this.mColorState.mTint, mode);
        invalidateSelf();
    }
}
