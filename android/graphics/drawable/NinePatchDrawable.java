package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.NinePatch;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.android.internal.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/NinePatchDrawable.class */
public class NinePatchDrawable extends Drawable {
    private static final boolean DEFAULT_DITHER = false;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private boolean mMutated;
    private NinePatch mNinePatch;
    private NinePatchState mNinePatchState;
    private Insets mOpticalInsets;
    private Rect mPadding;
    private Paint mPaint;
    private int mTargetDensity;
    private PorterDuffColorFilter mTintFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/NinePatchDrawable$NinePatchState.class */
    public static final class NinePatchState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        float mBaseAlpha;
        int mChangingConfigurations;
        boolean mDither;
        NinePatch mNinePatch;
        Insets mOpticalInsets;
        Rect mPadding;
        int mTargetDensity;
        int[] mThemeAttrs;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;

        NinePatchState() {
            this.mThemeAttrs = null;
            this.mNinePatch = null;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mPadding = null;
            this.mOpticalInsets = Insets.NONE;
            this.mBaseAlpha = 1.0f;
            this.mDither = false;
            this.mTargetDensity = 160;
            this.mAutoMirrored = false;
        }

        NinePatchState(NinePatch ninePatch, Rect rect) {
            this(ninePatch, rect, null, false, false);
        }

        NinePatchState(NinePatch ninePatch, Rect rect, Rect rect2) {
            this(ninePatch, rect, rect2, false, false);
        }

        NinePatchState(NinePatch ninePatch, Rect rect, Rect rect2, boolean z, boolean z2) {
            this.mThemeAttrs = null;
            this.mNinePatch = null;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mPadding = null;
            this.mOpticalInsets = Insets.NONE;
            this.mBaseAlpha = 1.0f;
            this.mDither = false;
            this.mTargetDensity = 160;
            this.mAutoMirrored = false;
            this.mNinePatch = ninePatch;
            this.mPadding = rect;
            this.mOpticalInsets = Insets.of(rect2);
            this.mDither = z;
            this.mAutoMirrored = z2;
        }

        NinePatchState(NinePatchState ninePatchState) {
            this.mThemeAttrs = null;
            this.mNinePatch = null;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mPadding = null;
            this.mOpticalInsets = Insets.NONE;
            this.mBaseAlpha = 1.0f;
            this.mDither = false;
            this.mTargetDensity = 160;
            this.mAutoMirrored = false;
            this.mNinePatch = ninePatchState.mNinePatch;
            this.mTint = ninePatchState.mTint;
            this.mTintMode = ninePatchState.mTintMode;
            this.mThemeAttrs = ninePatchState.mThemeAttrs;
            this.mPadding = ninePatchState.mPadding;
            this.mOpticalInsets = ninePatchState.mOpticalInsets;
            this.mBaseAlpha = ninePatchState.mBaseAlpha;
            this.mDither = ninePatchState.mDither;
            this.mChangingConfigurations = ninePatchState.mChangingConfigurations;
            this.mTargetDensity = ninePatchState.mTargetDensity;
            this.mAutoMirrored = ninePatchState.mAutoMirrored;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            Bitmap bitmap = this.mNinePatch.getBitmap();
            if (isAtlasable(bitmap) && collection.add(bitmap)) {
                return bitmap.getWidth() * bitmap.getHeight();
            }
            return 0;
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
            return new NinePatchDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new NinePatchDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NinePatchDrawable() {
        this.mOpticalInsets = Insets.NONE;
        this.mTargetDensity = 160;
        this.mBitmapWidth = -1;
        this.mBitmapHeight = -1;
        this.mNinePatchState = new NinePatchState();
    }

    public NinePatchDrawable(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, Rect rect2, String str) {
        this(new NinePatchState(new NinePatch(bitmap, bArr, str), rect, rect2), resources);
        this.mNinePatchState.mTargetDensity = this.mTargetDensity;
    }

    public NinePatchDrawable(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        this(new NinePatchState(new NinePatch(bitmap, bArr, str), rect), resources);
        this.mNinePatchState.mTargetDensity = this.mTargetDensity;
    }

    public NinePatchDrawable(Resources resources, NinePatch ninePatch) {
        this(new NinePatchState(ninePatch, new Rect()), resources);
        this.mNinePatchState.mTargetDensity = this.mTargetDensity;
    }

    @Deprecated
    public NinePatchDrawable(Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        this(new NinePatchState(new NinePatch(bitmap, bArr, str), rect), (Resources) null);
    }

    @Deprecated
    public NinePatchDrawable(NinePatch ninePatch) {
        this(new NinePatchState(ninePatch, new Rect()), (Resources) null);
    }

    private NinePatchDrawable(NinePatchState ninePatchState, Resources resources) {
        this.mOpticalInsets = Insets.NONE;
        this.mTargetDensity = 160;
        this.mBitmapWidth = -1;
        this.mBitmapHeight = -1;
        this.mNinePatchState = ninePatchState;
        initializeWithState(this.mNinePatchState, resources);
    }

    private void computeBitmapSize() {
        int density = this.mNinePatch.getDensity();
        int i = this.mTargetDensity;
        if (density == i) {
            this.mBitmapWidth = this.mNinePatch.getWidth();
            this.mBitmapHeight = this.mNinePatch.getHeight();
            this.mOpticalInsets = this.mNinePatchState.mOpticalInsets;
            return;
        }
        this.mBitmapWidth = Bitmap.scaleFromDensity(this.mNinePatch.getWidth(), density, i);
        this.mBitmapHeight = Bitmap.scaleFromDensity(this.mNinePatch.getHeight(), density, i);
        if (this.mNinePatchState.mPadding != null && this.mPadding != null) {
            Rect rect = this.mPadding;
            Rect rect2 = this.mNinePatchState.mPadding;
            Rect rect3 = rect;
            if (rect == rect2) {
                rect3 = new Rect(rect2);
                this.mPadding = rect3;
            }
            rect3.left = Bitmap.scaleFromDensity(rect2.left, density, i);
            rect3.top = Bitmap.scaleFromDensity(rect2.top, density, i);
            rect3.right = Bitmap.scaleFromDensity(rect2.right, density, i);
            rect3.bottom = Bitmap.scaleFromDensity(rect2.bottom, density, i);
        }
        this.mOpticalInsets = scaleFromDensity(this.mNinePatchState.mOpticalInsets, density, i);
    }

    private void initializeWithState(NinePatchState ninePatchState, Resources resources) {
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = ninePatchState.mTargetDensity;
        }
        if (ninePatchState.mDither) {
            setDither(ninePatchState.mDither);
        }
        if (ninePatchState.mPadding != null) {
            this.mPadding = new Rect(ninePatchState.mPadding);
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, ninePatchState.mTint, ninePatchState.mTintMode);
        setNinePatch(ninePatchState.mNinePatch);
    }

    private boolean needsMirroring() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    private static Insets scaleFromDensity(Insets insets, int i, int i2) {
        return Insets.of(Bitmap.scaleFromDensity(insets.left, i, i2), Bitmap.scaleFromDensity(insets.top, i, i2), Bitmap.scaleFromDensity(insets.right, i, i2), Bitmap.scaleFromDensity(insets.bottom, i, i2));
    }

    private void setNinePatch(NinePatch ninePatch) {
        if (this.mNinePatch != ninePatch) {
            this.mNinePatch = ninePatch;
            if (ninePatch != null) {
                computeBitmapSize();
            } else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
                this.mOpticalInsets = Insets.NONE;
            }
            invalidateSelf();
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        Resources resources = typedArray.getResources();
        NinePatchState ninePatchState = this.mNinePatchState;
        ninePatchState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        ninePatchState.mThemeAttrs = typedArray.extractThemeAttrs();
        ninePatchState.mDither = typedArray.getBoolean(1, ninePatchState.mDither);
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = !ninePatchState.mDither;
            options.inScreenDensity = resources.getDisplayMetrics().noncompatDensityDpi;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Bitmap bitmap = null;
            try {
                TypedValue typedValue = new TypedValue();
                InputStream openRawResource = resources.openRawResource(resourceId, typedValue);
                Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, openRawResource, rect, options);
                bitmap = decodeResourceStream;
                openRawResource.close();
                bitmap = decodeResourceStream;
            } catch (IOException e) {
            }
            if (bitmap == null) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <nine-patch> requires a valid src attribute");
            }
            if (bitmap.getNinePatchChunk() == null) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <nine-patch> requires a valid 9-patch source image");
            }
            bitmap.getOpticalInsets(rect2);
            ninePatchState.mNinePatch = new NinePatch(bitmap, bitmap.getNinePatchChunk());
            ninePatchState.mPadding = rect;
            ninePatchState.mOpticalInsets = Insets.of(rect2);
        }
        ninePatchState.mAutoMirrored = typedArray.getBoolean(4, ninePatchState.mAutoMirrored);
        ninePatchState.mBaseAlpha = typedArray.getFloat(3, ninePatchState.mBaseAlpha);
        int i = typedArray.getInt(5, -1);
        if (i != -1) {
            ninePatchState.mTintMode = Drawable.parseTintMode(i, PorterDuff.Mode.SRC_IN);
        }
        ColorStateList colorStateList = typedArray.getColorStateList(2);
        if (colorStateList != null) {
            ninePatchState.mTint = colorStateList;
        }
        initializeWithState(ninePatchState, resources);
        ninePatchState.mTargetDensity = this.mTargetDensity;
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        NinePatchState ninePatchState = this.mNinePatchState;
        if (ninePatchState == null || ninePatchState.mThemeAttrs == null) {
            return;
        }
        TypedArray resolveAttributes = theme.resolveAttributes(ninePatchState.mThemeAttrs, R.styleable.NinePatchDrawable);
        try {
            try {
                updateStateFromTypedArray(resolveAttributes);
            } catch (XmlPullParserException e) {
                throw new RuntimeException(e);
            }
        } finally {
            resolveAttributes.recycle();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mNinePatchState == null || this.mNinePatchState.mThemeAttrs == null) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        int i;
        Rect bounds = getBounds();
        if (this.mTintFilter == null || getPaint().getColorFilter() != null) {
            z = false;
        } else {
            this.mPaint.setColorFilter(this.mTintFilter);
            z = true;
        }
        if (needsMirroring()) {
            canvas.translate(bounds.right - bounds.left, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        if (this.mNinePatchState.mBaseAlpha != 1.0f) {
            i = this.mPaint.getAlpha();
            this.mPaint.setAlpha((int) ((i * this.mNinePatchState.mBaseAlpha) + 0.5f));
        } else {
            i = -1;
        }
        this.mNinePatch.draw(canvas, bounds, this.mPaint);
        if (z) {
            this.mPaint.setColorFilter(null);
        }
        if (i >= 0) {
            this.mPaint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.mPaint == null) {
            return 255;
        }
        return getPaint().getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mNinePatchState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        return this.mNinePatchState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mNinePatch.hasAlpha()) {
            return -3;
        }
        return (this.mPaint == null || this.mPaint.getAlpha() >= 255) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public Insets getOpticalInsets() {
        return needsMirroring() ? Insets.of(this.mOpticalInsets.right, this.mOpticalInsets.top, this.mOpticalInsets.left, this.mOpticalInsets.bottom) : this.mOpticalInsets;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        NinePatch.InsetStruct ninePatchInsets;
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            return;
        }
        if (this.mNinePatchState == null || (ninePatchInsets = this.mNinePatchState.mNinePatch.getBitmap().getNinePatchInsets()) == null) {
            super.getOutline(outline);
            return;
        }
        Rect rect = ninePatchInsets.outlineRect;
        outline.setRoundRect(rect.left + bounds.left, rect.top + bounds.top, bounds.right - rect.right, bounds.bottom - rect.bottom, ninePatchInsets.outlineRadius);
        outline.setAlpha(ninePatchInsets.outlineAlpha * (getAlpha() / 255.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.mPadding;
        boolean z = false;
        if (rect2 != null) {
            if (needsMirroring()) {
                rect.set(rect2.right, rect2.top, rect2.left, rect2.bottom);
            } else {
                rect.set(rect2);
            }
            z = false;
            if ((rect.left | rect.top | rect.right | rect.bottom) != 0) {
                z = true;
            }
        }
        return z;
    }

    public Paint getPaint() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setDither(false);
        }
        return this.mPaint;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mNinePatch.getTransparentRegion(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.NinePatchDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mNinePatchState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        NinePatchState ninePatchState = this.mNinePatchState;
        if (super.isStateful()) {
            return true;
        }
        return ninePatchState.mTint != null && ninePatchState.mTint.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mNinePatchState = new NinePatchState(this.mNinePatchState);
            this.mNinePatch = this.mNinePatchState.mNinePatch;
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        NinePatchState ninePatchState = this.mNinePatchState;
        if (ninePatchState.mTint == null || ninePatchState.mTintMode == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, ninePatchState.mTint, ninePatchState.mTintMode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mPaint == null && i == 255) {
            return;
        }
        getPaint().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.mNinePatchState.mAutoMirrored = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mPaint == null && colorFilter == null) {
            return;
        }
        getPaint().setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.mPaint != null || z) {
            getPaint().setDither(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        getPaint().setFilterBitmap(z);
        invalidateSelf();
    }

    public void setTargetDensity(int i) {
        if (i != this.mTargetDensity) {
            int i2 = i;
            if (i == 0) {
                i2 = 160;
            }
            this.mTargetDensity = i2;
            if (this.mNinePatch != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mNinePatchState.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, this.mNinePatchState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mNinePatchState.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTintFilter, this.mNinePatchState.mTint, mode);
        invalidateSelf();
    }
}
