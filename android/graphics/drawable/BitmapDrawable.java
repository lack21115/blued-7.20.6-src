package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import com.android.internal.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/BitmapDrawable.class */
public class BitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_DISABLED = -1;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;
    private static final int TILE_MODE_UNDEFINED = -2;
    private int mBitmapHeight;
    private BitmapState mBitmapState;
    private int mBitmapWidth;
    private final Rect mDstRect;
    private boolean mDstRectAndInsetsDirty;
    private Matrix mMirrorMatrix;
    private boolean mMutated;
    private Insets mOpticalInsets;
    private int mTargetDensity;
    private PorterDuffColorFilter mTintFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/BitmapDrawable$BitmapState.class */
    public static final class BitmapState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        float mBaseAlpha;
        Bitmap mBitmap;
        int mChangingConfigurations;
        int mGravity;
        final Paint mPaint;
        boolean mRebuildShader;
        int mTargetDensity;
        int[] mThemeAttrs;
        Shader.TileMode mTileModeX;
        Shader.TileMode mTileModeY;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;

        BitmapState(Bitmap bitmap) {
            this.mThemeAttrs = null;
            this.mBitmap = null;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mGravity = 119;
            this.mBaseAlpha = 1.0f;
            this.mTileModeX = null;
            this.mTileModeY = null;
            this.mTargetDensity = 160;
            this.mAutoMirrored = false;
            this.mBitmap = bitmap;
            this.mPaint = new Paint(6);
        }

        BitmapState(BitmapState bitmapState) {
            this.mThemeAttrs = null;
            this.mBitmap = null;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mGravity = 119;
            this.mBaseAlpha = 1.0f;
            this.mTileModeX = null;
            this.mTileModeY = null;
            this.mTargetDensity = 160;
            this.mAutoMirrored = false;
            this.mBitmap = bitmapState.mBitmap;
            this.mTint = bitmapState.mTint;
            this.mTintMode = bitmapState.mTintMode;
            this.mThemeAttrs = bitmapState.mThemeAttrs;
            this.mChangingConfigurations = bitmapState.mChangingConfigurations;
            this.mGravity = bitmapState.mGravity;
            this.mTileModeX = bitmapState.mTileModeX;
            this.mTileModeY = bitmapState.mTileModeY;
            this.mTargetDensity = bitmapState.mTargetDensity;
            this.mBaseAlpha = bitmapState.mBaseAlpha;
            this.mPaint = new Paint(bitmapState.mPaint);
            this.mRebuildShader = bitmapState.mRebuildShader;
            this.mAutoMirrored = bitmapState.mAutoMirrored;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            if (isAtlasable(this.mBitmap) && collection.add(this.mBitmap)) {
                return this.mBitmap.getWidth() * this.mBitmap.getHeight();
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
            return new BitmapDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new BitmapDrawable(this, resources);
        }
    }

    @Deprecated
    public BitmapDrawable() {
        this.mDstRect = new Rect();
        this.mTargetDensity = 160;
        this.mDstRectAndInsetsDirty = true;
        this.mOpticalInsets = Insets.NONE;
        this.mBitmapState = new BitmapState((Bitmap) null);
    }

    @Deprecated
    public BitmapDrawable(Resources resources) {
        this.mDstRect = new Rect();
        this.mTargetDensity = 160;
        this.mDstRectAndInsetsDirty = true;
        this.mOpticalInsets = Insets.NONE;
        this.mBitmapState = new BitmapState((Bitmap) null);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }

    public BitmapDrawable(Resources resources, Bitmap bitmap) {
        this(new BitmapState(bitmap), resources);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }

    public BitmapDrawable(Resources resources, InputStream inputStream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputStream)), (Resources) null);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
        if (this.mBitmapState.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + inputStream);
        }
    }

    public BitmapDrawable(Resources resources, String str) {
        this(new BitmapState(BitmapFactory.decodeFile(str)), (Resources) null);
        this.mBitmapState.mTargetDensity = this.mTargetDensity;
        if (this.mBitmapState.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + str);
        }
    }

    @Deprecated
    public BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), (Resources) null);
    }

    private BitmapDrawable(BitmapState bitmapState, Resources resources) {
        this.mDstRect = new Rect();
        this.mTargetDensity = 160;
        this.mDstRectAndInsetsDirty = true;
        this.mOpticalInsets = Insets.NONE;
        this.mBitmapState = bitmapState;
        initializeWithState(this.mBitmapState, resources);
    }

    @Deprecated
    public BitmapDrawable(InputStream inputStream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputStream)), (Resources) null);
        if (this.mBitmapState.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + inputStream);
        }
    }

    @Deprecated
    public BitmapDrawable(String str) {
        this(new BitmapState(BitmapFactory.decodeFile(str)), (Resources) null);
        if (this.mBitmapState.mBitmap == null) {
            Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + str);
        }
    }

    private void computeBitmapSize() {
        Bitmap bitmap = this.mBitmapState.mBitmap;
        if (bitmap != null) {
            this.mBitmapWidth = bitmap.getScaledWidth(this.mTargetDensity);
            this.mBitmapHeight = bitmap.getScaledHeight(this.mTargetDensity);
            return;
        }
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
    }

    private void initializeWithState(BitmapState bitmapState, Resources resources) {
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = bitmapState.mTargetDensity;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, bitmapState.mTint, bitmapState.mTintMode);
        computeBitmapSize();
    }

    private boolean needMirroring() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    private static Shader.TileMode parseTileMode(int i) {
        switch (i) {
            case 0:
                return Shader.TileMode.CLAMP;
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return null;
        }
    }

    private void setBitmap(Bitmap bitmap) {
        if (this.mBitmapState.mBitmap != bitmap) {
            this.mBitmapState.mBitmap = bitmap;
            computeBitmapSize();
            invalidateSelf();
        }
    }

    private void updateDstRectAndInsetsIfDirty() {
        if (this.mDstRectAndInsetsDirty) {
            if (this.mBitmapState.mTileModeX == null && this.mBitmapState.mTileModeY == null) {
                Rect bounds = getBounds();
                Gravity.apply(this.mBitmapState.mGravity, this.mBitmapWidth, this.mBitmapHeight, bounds, this.mDstRect, getLayoutDirection());
                this.mOpticalInsets = Insets.of(this.mDstRect.left - bounds.left, this.mDstRect.top - bounds.top, bounds.right - this.mDstRect.right, bounds.bottom - this.mDstRect.bottom);
            } else {
                copyBounds(this.mDstRect);
                this.mOpticalInsets = Insets.NONE;
            }
        }
        this.mDstRectAndInsetsDirty = false;
    }

    private void updateMirrorMatrix(float f) {
        if (this.mMirrorMatrix == null) {
            this.mMirrorMatrix = new Matrix();
        }
        this.mMirrorMatrix.setTranslate(f, 0.0f);
        this.mMirrorMatrix.preScale(-1.0f, 1.0f);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        Resources resources = typedArray.getResources();
        BitmapState bitmapState = this.mBitmapState;
        bitmapState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        bitmapState.mThemeAttrs = typedArray.extractThemeAttrs();
        int resourceId = typedArray.getResourceId(1, 0);
        if (resourceId != 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, resourceId);
            if (decodeResource == null) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <bitmap> requires a valid src attribute");
            }
            bitmapState.mBitmap = decodeResource;
        }
        bitmapState.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        setMipMap(typedArray.getBoolean(8, bitmapState.mBitmap != null ? bitmapState.mBitmap.hasMipMap() : false));
        bitmapState.mAutoMirrored = typedArray.getBoolean(9, bitmapState.mAutoMirrored);
        bitmapState.mBaseAlpha = typedArray.getFloat(7, bitmapState.mBaseAlpha);
        int i = typedArray.getInt(10, -1);
        if (i != -1) {
            bitmapState.mTintMode = Drawable.parseTintMode(i, PorterDuff.Mode.SRC_IN);
        }
        ColorStateList colorStateList = typedArray.getColorStateList(5);
        if (colorStateList != null) {
            bitmapState.mTint = colorStateList;
        }
        Paint paint = this.mBitmapState.mPaint;
        paint.setAntiAlias(typedArray.getBoolean(2, paint.isAntiAlias()));
        paint.setFilterBitmap(typedArray.getBoolean(3, paint.isFilterBitmap()));
        paint.setDither(typedArray.getBoolean(4, paint.isDither()));
        setGravity(typedArray.getInt(0, bitmapState.mGravity));
        int i2 = typedArray.getInt(6, -2);
        if (i2 != -2) {
            Shader.TileMode parseTileMode = parseTileMode(i2);
            setTileModeXY(parseTileMode, parseTileMode);
        }
        int i3 = typedArray.getInt(11, -2);
        if (i3 != -2) {
            setTileModeX(parseTileMode(i3));
        }
        int i4 = typedArray.getInt(12, -2);
        if (i4 != -2) {
            setTileModeY(parseTileMode(i4));
        }
        initializeWithState(bitmapState, resources);
    }

    private void verifyState(TypedArray typedArray) throws XmlPullParserException {
        if (this.mBitmapState.mBitmap == null) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + ": <bitmap> requires a valid src attribute");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        BitmapState bitmapState = this.mBitmapState;
        if (bitmapState == null || bitmapState.mThemeAttrs == null) {
            return;
        }
        TypedArray resolveAttributes = theme.resolveAttributes(bitmapState.mThemeAttrs, R.styleable.BitmapDrawable);
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
        return (this.mBitmapState == null || this.mBitmapState.mThemeAttrs == null) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        boolean z;
        Bitmap bitmap = this.mBitmapState.mBitmap;
        if (bitmap == null) {
            return;
        }
        BitmapState bitmapState = this.mBitmapState;
        Paint paint = bitmapState.mPaint;
        if (bitmapState.mRebuildShader) {
            Shader.TileMode tileMode = bitmapState.mTileModeX;
            Shader.TileMode tileMode2 = bitmapState.mTileModeY;
            if (tileMode == null && tileMode2 == null) {
                paint.setShader(null);
            } else {
                Shader.TileMode tileMode3 = tileMode;
                if (tileMode == null) {
                    tileMode3 = Shader.TileMode.CLAMP;
                }
                Shader.TileMode tileMode4 = tileMode2;
                if (tileMode2 == null) {
                    tileMode4 = Shader.TileMode.CLAMP;
                }
                paint.setShader(new BitmapShader(bitmap, tileMode3, tileMode4));
            }
            bitmapState.mRebuildShader = false;
        }
        if (bitmapState.mBaseAlpha != 1.0f) {
            Paint paint2 = getPaint();
            i = paint2.getAlpha();
            paint2.setAlpha((int) ((i * bitmapState.mBaseAlpha) + 0.5f));
        } else {
            i = -1;
        }
        if (this.mTintFilter == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.mTintFilter);
            z = true;
        }
        updateDstRectAndInsetsIfDirty();
        Shader shader = paint.getShader();
        boolean needMirroring = needMirroring();
        if (shader == null) {
            if (needMirroring) {
                canvas.save();
                canvas.translate(this.mDstRect.right - this.mDstRect.left, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, paint);
            if (needMirroring) {
                canvas.restore();
            }
        } else {
            if (needMirroring) {
                updateMirrorMatrix(this.mDstRect.right - this.mDstRect.left);
                shader.setLocalMatrix(this.mMirrorMatrix);
                paint.setShader(shader);
            } else if (this.mMirrorMatrix != null) {
                this.mMirrorMatrix = null;
                shader.setLocalMatrix(Matrix.IDENTITY_MATRIX);
                paint.setShader(shader);
            }
            canvas.drawRect(this.mDstRect, paint);
        }
        if (z) {
            paint.setColorFilter(null);
        }
        if (i >= 0) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mBitmapState.mPaint.getAlpha();
    }

    public final Bitmap getBitmap() {
        return this.mBitmapState.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mBitmapState.mPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return this.mBitmapState;
    }

    public int getGravity() {
        return this.mBitmapState.mGravity;
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
    public int getOpacity() {
        Bitmap bitmap;
        return (this.mBitmapState.mGravity == 119 && (bitmap = this.mBitmapState.mBitmap) != null && !bitmap.hasAlpha() && this.mBitmapState.mPaint.getAlpha() >= 255) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public Insets getOpticalInsets() {
        updateDstRectAndInsetsIfDirty();
        return this.mOpticalInsets;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        updateDstRectAndInsetsIfDirty();
        outline.setRect(this.mDstRect);
        outline.setAlpha(this.mBitmapState.mBitmap != null && !this.mBitmapState.mBitmap.hasAlpha() ? getAlpha() / 255.0f : 0.0f);
    }

    public final Paint getPaint() {
        return this.mBitmapState.mPaint;
    }

    public Shader.TileMode getTileModeX() {
        return this.mBitmapState.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        return this.mBitmapState.mTileModeY;
    }

    public ColorStateList getTint() {
        return this.mBitmapState.mTint;
    }

    public PorterDuff.Mode getTintMode() {
        return this.mBitmapState.mTintMode;
    }

    public boolean hasAntiAlias() {
        return this.mBitmapState.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        return this.mBitmapState.mBitmap != null && this.mBitmapState.mBitmap.hasMipMap();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.BitmapDrawable);
        updateStateFromTypedArray(obtainAttributes);
        verifyState(obtainAttributes);
        obtainAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.mBitmapState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        BitmapState bitmapState = this.mBitmapState;
        if (super.isStateful()) {
            return true;
        }
        return bitmapState.mTint != null && bitmapState.mTint.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mBitmapState = new BitmapState(this.mBitmapState);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mDstRectAndInsetsDirty = true;
        Shader shader = this.mBitmapState.mPaint.getShader();
        if (shader != null) {
            if (needMirroring()) {
                updateMirrorMatrix(rect.right - rect.left);
                shader.setLocalMatrix(this.mMirrorMatrix);
                this.mBitmapState.mPaint.setShader(shader);
            } else if (this.mMirrorMatrix != null) {
                this.mMirrorMatrix = null;
                shader.setLocalMatrix(Matrix.IDENTITY_MATRIX);
                this.mBitmapState.mPaint.setShader(shader);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        BitmapState bitmapState = this.mBitmapState;
        if (bitmapState.mTint == null || bitmapState.mTintMode == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, bitmapState.mTint, bitmapState.mTintMode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mBitmapState.mPaint.getAlpha()) {
            this.mBitmapState.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.mBitmapState.mPaint.setAntiAlias(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.mBitmapState.mAutoMirrored != z) {
            this.mBitmapState.mAutoMirrored = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapState.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mBitmapState.mPaint.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mBitmapState.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.mBitmapState.mGravity != i) {
            this.mBitmapState.mGravity = i;
            this.mDstRectAndInsetsDirty = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        if (this.mBitmapState.mBitmap != null) {
            this.mBitmapState.mBitmap.setHasMipMap(z);
            invalidateSelf();
        }
    }

    public void setTargetDensity(int i) {
        if (this.mTargetDensity != i) {
            int i2 = i;
            if (i == 0) {
                i2 = 160;
            }
            this.mTargetDensity = i2;
            if (this.mBitmapState.mBitmap != null) {
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

    public void setTileModeX(Shader.TileMode tileMode) {
        setTileModeXY(tileMode, this.mBitmapState.mTileModeY);
    }

    public void setTileModeXY(Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        BitmapState bitmapState = this.mBitmapState;
        if (bitmapState.mTileModeX == tileMode && bitmapState.mTileModeY == tileMode2) {
            return;
        }
        bitmapState.mTileModeX = tileMode;
        bitmapState.mTileModeY = tileMode2;
        bitmapState.mRebuildShader = true;
        this.mDstRectAndInsetsDirty = true;
        invalidateSelf();
    }

    public final void setTileModeY(Shader.TileMode tileMode) {
        setTileModeXY(this.mBitmapState.mTileModeX, tileMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mBitmapState.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, this.mBitmapState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mBitmapState.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTintFilter, this.mBitmapState.mTint, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setXfermode(Xfermode xfermode) {
        this.mBitmapState.mPaint.setXfermode(xfermode);
        invalidateSelf();
    }
}
