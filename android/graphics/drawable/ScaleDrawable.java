package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import com.android.internal.R;
import java.io.IOException;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ScaleDrawable.class */
public class ScaleDrawable extends Drawable implements Drawable.Callback {
    private boolean mMutated;
    private ScaleState mState;
    private final Rect mTmpRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ScaleDrawable$ScaleState.class */
    public static final class ScaleState extends Drawable.ConstantState {
        private static final float DO_NOT_SCALE = -1.0f;
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mGravity;
        float mScaleHeight;
        float mScaleWidth;
        int[] mThemeAttrs;
        boolean mUseIntrinsicSizeAsMin;

        ScaleState(ScaleState scaleState, ScaleDrawable scaleDrawable, Resources resources) {
            this.mScaleWidth = -1.0f;
            this.mScaleHeight = -1.0f;
            this.mGravity = 3;
            this.mUseIntrinsicSizeAsMin = false;
            if (scaleState != null) {
                this.mThemeAttrs = scaleState.mThemeAttrs;
                this.mChangingConfigurations = scaleState.mChangingConfigurations;
                if (resources != null) {
                    this.mDrawable = scaleState.mDrawable.getConstantState().newDrawable(resources);
                } else {
                    this.mDrawable = scaleState.mDrawable.getConstantState().newDrawable();
                }
                this.mDrawable.setCallback(scaleDrawable);
                this.mDrawable.setLayoutDirection(scaleState.mDrawable.getLayoutDirection());
                this.mDrawable.setBounds(scaleState.mDrawable.getBounds());
                this.mDrawable.setLevel(scaleState.mDrawable.getLevel());
                this.mScaleWidth = scaleState.mScaleWidth;
                this.mScaleHeight = scaleState.mScaleHeight;
                this.mGravity = scaleState.mGravity;
                this.mUseIntrinsicSizeAsMin = scaleState.mUseIntrinsicSizeAsMin;
                this.mCanConstantState = true;
                this.mCheckedConstantState = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            Drawable.ConstantState constantState = this.mDrawable.getConstantState();
            if (constantState != null) {
                return constantState.addAtlasableBitmaps(collection);
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) {
                return (this.mDrawable != null && this.mDrawable.canApplyTheme()) || super.canApplyTheme();
            }
            return true;
        }

        boolean canConstantState() {
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
            return new ScaleDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ScaleDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScaleDrawable() {
        this(null, null);
    }

    public ScaleDrawable(Drawable drawable, int i, float f, float f2) {
        this(null, null);
        this.mState.mDrawable = drawable;
        this.mState.mGravity = i;
        this.mState.mScaleWidth = f;
        this.mState.mScaleHeight = f2;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    private ScaleDrawable(ScaleState scaleState, Resources resources) {
        this.mTmpRect = new Rect();
        this.mState = new ScaleState(scaleState, this, resources);
    }

    private static float getPercent(TypedArray typedArray, int i, float f) {
        String string = typedArray.getString(i);
        float f2 = f;
        if (string != null) {
            f2 = f;
            if (string.endsWith("%")) {
                f2 = Float.parseFloat(string.substring(0, string.length() - 1)) / 100.0f;
            }
        }
        return f2;
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
        ScaleState scaleState = this.mState;
        scaleState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        scaleState.mThemeAttrs = typedArray.extractThemeAttrs();
        scaleState.mScaleWidth = getPercent(typedArray, 1, scaleState.mScaleWidth);
        scaleState.mScaleHeight = getPercent(typedArray, 2, scaleState.mScaleHeight);
        scaleState.mGravity = typedArray.getInt(3, scaleState.mGravity);
        scaleState.mUseIntrinsicSizeAsMin = typedArray.getBoolean(4, scaleState.mUseIntrinsicSizeAsMin);
        Drawable drawable = typedArray.getDrawable(0);
        if (drawable != null) {
            scaleState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mDrawable == null) {
            if (this.mState.mThemeAttrs == null || this.mState.mThemeAttrs[0] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <scale> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        ScaleState scaleState = this.mState;
        if (scaleState == null) {
            return;
        }
        if (scaleState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(scaleState.mThemeAttrs, R.styleable.ScaleDrawable);
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
        if (scaleState.mDrawable == null || !scaleState.mDrawable.canApplyTheme()) {
            return;
        }
        scaleState.mDrawable.applyTheme(theme);
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
        if (this.mState.mDrawable.getLevel() != 0) {
            this.mState.mDrawable.draw(canvas);
        }
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
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.ScaleDrawable);
        this.mState.mDrawable = null;
        updateStateFromTypedArray(obtainAttributes);
        inflateChildElements(resources, xmlPullParser, attributeSet, theme);
        verifyRequiredAttributes(obtainAttributes);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
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
        Rect rect2 = this.mTmpRect;
        boolean z = this.mState.mUseIntrinsicSizeAsMin;
        int level = getLevel();
        int width = rect.width();
        int i = width;
        if (this.mState.mScaleWidth > 0.0f) {
            i = width - ((int) ((((width - (z ? this.mState.mDrawable.getIntrinsicWidth() : 0)) * (10000 - level)) * this.mState.mScaleWidth) / 10000.0f));
        }
        int height = rect.height();
        int i2 = height;
        if (this.mState.mScaleHeight > 0.0f) {
            i2 = height - ((int) ((((height - (z ? this.mState.mDrawable.getIntrinsicHeight() : 0)) * (10000 - level)) * this.mState.mScaleHeight) / 10000.0f));
        }
        Gravity.apply(this.mState.mGravity, i, i2, rect, rect2, getLayoutDirection());
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mState.mDrawable.setBounds(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        this.mState.mDrawable.setLevel(i);
        onBoundsChange(getBounds());
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
        if (getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
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
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
