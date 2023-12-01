package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.android.internal.R;
import java.io.IOException;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/InsetDrawable.class */
public class InsetDrawable extends Drawable implements Drawable.Callback {
    private boolean mMutated;
    private final InsetState mState;
    private final Rect mTmpRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/InsetDrawable$InsetState.class */
    public static final class InsetState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mInsetBottom;
        int mInsetLeft;
        int mInsetRight;
        int mInsetTop;
        int[] mThemeAttrs;

        InsetState(InsetState insetState, InsetDrawable insetDrawable, Resources resources) {
            this.mInsetLeft = 0;
            this.mInsetTop = 0;
            this.mInsetRight = 0;
            this.mInsetBottom = 0;
            if (insetState != null) {
                this.mThemeAttrs = insetState.mThemeAttrs;
                this.mChangingConfigurations = insetState.mChangingConfigurations;
                if (resources != null) {
                    this.mDrawable = insetState.mDrawable.getConstantState().newDrawable(resources);
                } else {
                    this.mDrawable = insetState.mDrawable.getConstantState().newDrawable();
                }
                this.mDrawable.setCallback(insetDrawable);
                this.mDrawable.setLayoutDirection(insetState.mDrawable.getLayoutDirection());
                this.mDrawable.setBounds(insetState.mDrawable.getBounds());
                this.mDrawable.setLevel(insetState.mDrawable.getLevel());
                this.mInsetLeft = insetState.mInsetLeft;
                this.mInsetTop = insetState.mInsetTop;
                this.mInsetRight = insetState.mInsetRight;
                this.mInsetBottom = insetState.mInsetBottom;
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
            return new InsetDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new InsetDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InsetDrawable() {
        this((InsetState) null, (Resources) null);
    }

    public InsetDrawable(Drawable drawable, int i) {
        this(drawable, i, i, i, i);
    }

    public InsetDrawable(Drawable drawable, int i, int i2, int i3, int i4) {
        this((InsetState) null, (Resources) null);
        this.mState.mDrawable = drawable;
        this.mState.mInsetLeft = i;
        this.mState.mInsetTop = i2;
        this.mState.mInsetRight = i3;
        this.mState.mInsetBottom = i4;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    private InsetDrawable(InsetState insetState, Resources resources) {
        this.mTmpRect = new Rect();
        this.mState = new InsetState(insetState, this, resources);
    }

    private void inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        if (this.mState.mDrawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <inset> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            Drawable createFromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            this.mState.mDrawable = createFromXmlInner;
            createFromXmlInner.setCallback(this);
        }
    }

    private boolean needMirroring() {
        return this.mState.mDrawable.isAutoMirrored() && this.mState.mDrawable.getLayoutDirection() == 1;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        InsetState insetState = this.mState;
        insetState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        insetState.mThemeAttrs = typedArray.extractThemeAttrs();
        int indexCount = typedArray.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                return;
            }
            int index = typedArray.getIndex(i2);
            switch (index) {
                case 1:
                    Drawable drawable = typedArray.getDrawable(index);
                    if (drawable == null) {
                        break;
                    } else {
                        insetState.mDrawable = drawable;
                        drawable.setCallback(this);
                        break;
                    }
                case 2:
                    insetState.mInsetLeft = typedArray.getDimensionPixelOffset(index, insetState.mInsetLeft);
                    break;
                case 3:
                    insetState.mInsetRight = typedArray.getDimensionPixelOffset(index, insetState.mInsetRight);
                    break;
                case 4:
                    insetState.mInsetTop = typedArray.getDimensionPixelOffset(index, insetState.mInsetTop);
                    break;
                case 5:
                    insetState.mInsetBottom = typedArray.getDimensionPixelOffset(index, insetState.mInsetBottom);
                    break;
                case 6:
                    int dimensionPixelOffset = typedArray.getDimensionPixelOffset(index, Integer.MIN_VALUE);
                    if (dimensionPixelOffset == Integer.MIN_VALUE) {
                        break;
                    } else {
                        insetState.mInsetLeft = dimensionPixelOffset;
                        insetState.mInsetTop = dimensionPixelOffset;
                        insetState.mInsetRight = dimensionPixelOffset;
                        insetState.mInsetBottom = dimensionPixelOffset;
                        break;
                    }
            }
            i = i2 + 1;
        }
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mDrawable == null) {
            if (this.mState.mThemeAttrs == null || this.mState.mThemeAttrs[1] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <inset> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        InsetState insetState = this.mState;
        if (insetState == null) {
            return;
        }
        if (insetState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(insetState.mThemeAttrs, R.styleable.InsetDrawable);
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
        if (insetState.mDrawable == null || !insetState.mDrawable.canApplyTheme()) {
            return;
        }
        insetState.mDrawable.applyTheme(theme);
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
        this.mState.mDrawable.draw(canvas);
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
    public void getHotspotBounds(Rect rect) {
        this.mState.mDrawable.getHotspotBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mState.mDrawable.getIntrinsicHeight() + this.mState.mInsetTop + this.mState.mInsetBottom;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mState.mDrawable.getIntrinsicWidth() + this.mState.mInsetLeft + this.mState.mInsetRight;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (r0.mInsetBottom > 0) goto L11;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOpacity() {
        /*
            r3 = this;
            r0 = r3
            android.graphics.drawable.InsetDrawable$InsetState r0 = r0.mState
            r6 = r0
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.mDrawable
            int r0 = r0.getOpacity()
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r5
            r1 = -1
            if (r0 != r1) goto L35
            r0 = r6
            int r0 = r0.mInsetLeft
            if (r0 > 0) goto L32
            r0 = r6
            int r0 = r0.mInsetTop
            if (r0 > 0) goto L32
            r0 = r6
            int r0 = r0.mInsetRight
            if (r0 > 0) goto L32
            r0 = r5
            r4 = r0
            r0 = r6
            int r0 = r0.mInsetBottom
            if (r0 <= 0) goto L35
        L32:
            r0 = -3
            r4 = r0
        L35:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.drawable.InsetDrawable.getOpacity():int");
    }

    @Override // android.graphics.drawable.Drawable
    public Insets getOpticalInsets() {
        Insets opticalInsets = super.getOpticalInsets();
        return Insets.of(opticalInsets.left + this.mState.mInsetLeft, opticalInsets.top + this.mState.mInsetTop, opticalInsets.right + this.mState.mInsetRight, opticalInsets.bottom + this.mState.mInsetBottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.mState.mDrawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding = this.mState.mDrawable.getPadding(rect);
        if (needMirroring()) {
            rect.left += this.mState.mInsetRight;
            rect.right += this.mState.mInsetLeft;
        } else {
            rect.left += this.mState.mInsetLeft;
            rect.right += this.mState.mInsetRight;
        }
        rect.top += this.mState.mInsetTop;
        rect.bottom += this.mState.mInsetBottom;
        return padding || (((this.mState.mInsetLeft | this.mState.mInsetRight) | this.mState.mInsetTop) | this.mState.mInsetBottom) != 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.InsetDrawable);
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
        rect2.set(rect);
        rect2.left = (needMirroring() ? this.mState.mInsetRight : this.mState.mInsetLeft) + rect2.left;
        rect2.top += this.mState.mInsetTop;
        rect2.right -= needMirroring() ? this.mState.mInsetLeft : this.mState.mInsetRight;
        rect2.bottom -= this.mState.mInsetBottom;
        this.mState.mDrawable.setBounds(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.mState.mDrawable.setLevel(i);
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

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.mState.mDrawable.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mState.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setLayoutDirection(int i) {
        this.mState.mDrawable.setLayoutDirection(i);
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
