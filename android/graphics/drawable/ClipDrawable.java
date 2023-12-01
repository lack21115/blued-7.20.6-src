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
import android.view.Gravity;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ClipDrawable.class */
public class ClipDrawable extends Drawable implements Drawable.Callback {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private boolean mMutated;
    private ClipState mState;
    private final Rect mTmpRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/ClipDrawable$ClipState.class */
    public static final class ClipState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mGravity;
        int mOrientation;
        int[] mThemeAttrs;

        ClipState(ClipState clipState, ClipDrawable clipDrawable, Resources resources) {
            this.mOrientation = 1;
            this.mGravity = 3;
            if (clipState != null) {
                this.mThemeAttrs = clipState.mThemeAttrs;
                this.mChangingConfigurations = clipState.mChangingConfigurations;
                if (resources != null) {
                    this.mDrawable = clipState.mDrawable.getConstantState().newDrawable(resources);
                } else {
                    this.mDrawable = clipState.mDrawable.getConstantState().newDrawable();
                }
                this.mDrawable.setCallback(clipDrawable);
                this.mDrawable.setLayoutDirection(clipState.mDrawable.getLayoutDirection());
                this.mDrawable.setBounds(clipState.mDrawable.getBounds());
                this.mDrawable.setLevel(clipState.mDrawable.getLevel());
                this.mOrientation = clipState.mOrientation;
                this.mGravity = clipState.mGravity;
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
            return new ClipDrawable(this, (Resources) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ClipDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClipDrawable() {
        this(null, null);
    }

    private ClipDrawable(ClipState clipState, Resources resources) {
        this.mTmpRect = new Rect();
        this.mState = new ClipState(clipState, this, resources);
    }

    public ClipDrawable(Drawable drawable, int i, int i2) {
        this(null, null);
        this.mState.mDrawable = drawable;
        this.mState.mGravity = i;
        this.mState.mOrientation = i2;
        if (drawable != null) {
            drawable.setCallback(this);
        }
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
        ClipState clipState = this.mState;
        clipState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        clipState.mThemeAttrs = typedArray.extractThemeAttrs();
        clipState.mOrientation = typedArray.getInt(2, clipState.mOrientation);
        clipState.mGravity = typedArray.getInt(0, clipState.mGravity);
        Drawable drawable = typedArray.getDrawable(1);
        if (drawable != null) {
            clipState.mDrawable = drawable;
            drawable.setCallback(this);
        }
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mDrawable == null) {
            if (this.mState.mThemeAttrs == null || this.mState.mThemeAttrs[1] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <clip> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        ClipState clipState = this.mState;
        if (clipState == null || clipState.mThemeAttrs == null) {
            return;
        }
        TypedArray resolveAttributes = theme.resolveAttributes(clipState.mThemeAttrs, R.styleable.ClipDrawable);
        try {
            try {
                updateStateFromTypedArray(resolveAttributes);
                verifyRequiredAttributes(resolveAttributes);
                resolveAttributes.recycle();
                if (clipState.mDrawable == null || !clipState.mDrawable.canApplyTheme()) {
                    return;
                }
                clipState.mDrawable.applyTheme(theme);
            } catch (XmlPullParserException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            resolveAttributes.recycle();
            throw th;
        }
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
        if (this.mState.mDrawable.getLevel() == 0) {
            return;
        }
        Rect rect = this.mTmpRect;
        Rect bounds = getBounds();
        int level = getLevel();
        int width = bounds.width();
        int i = width;
        if ((this.mState.mOrientation & 1) != 0) {
            i = width - (((width + 0) * (10000 - level)) / 10000);
        }
        int height = bounds.height();
        int i2 = height;
        if ((this.mState.mOrientation & 2) != 0) {
            i2 = height - (((height + 0) * (10000 - level)) / 10000);
        }
        Gravity.apply(this.mState.mGravity, i, i2, bounds, rect, getLayoutDirection());
        if (i <= 0 || i2 <= 0) {
            return;
        }
        canvas.save();
        canvas.clipRect(rect);
        this.mState.mDrawable.draw(canvas);
        canvas.restore();
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
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.ClipDrawable);
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
        this.mState.mDrawable.setBounds(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        this.mState.mDrawable.setLevel(i);
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return this.mState.mDrawable.setState(iArr);
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

    @Override // android.graphics.drawable.Drawable
    public void setLayoutDirection(int i) {
        this.mState.mDrawable.setLayoutDirection(i);
        super.setLayoutDirection(i);
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
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
