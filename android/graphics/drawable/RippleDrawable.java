package android.graphics.drawable;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/RippleDrawable.class */
public class RippleDrawable extends LayerDrawable {
    private static final int MASK_CONTENT = 1;
    private static final int MASK_EXPLICIT = 2;
    private static final int MASK_NONE = 0;
    private static final int MASK_UNKNOWN = -1;
    private static final int MAX_RIPPLES = 10;
    public static final int RADIUS_AUTO = -1;
    private RippleBackground mBackground;
    private boolean mBackgroundActive;
    private float mDensity;
    private final Rect mDirtyBounds;
    private final Rect mDrawingBounds;
    private Ripple[] mExitingRipples;
    private int mExitingRipplesCount;
    private boolean mHasPending;
    private boolean mHasValidMask;
    private final Rect mHotspotBounds;
    private Drawable mMask;
    private Bitmap mMaskBuffer;
    private Canvas mMaskCanvas;
    private PorterDuffColorFilter mMaskColorFilter;
    private Matrix mMaskMatrix;
    private BitmapShader mMaskShader;
    private boolean mOverrideBounds;
    private float mPendingX;
    private float mPendingY;
    private Ripple mRipple;
    private boolean mRippleActive;
    private Paint mRipplePaint;
    private RippleState mState;
    private final Rect mTempRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/RippleDrawable$RippleState.class */
    public static class RippleState extends LayerDrawable.LayerState {
        ColorStateList mColor;
        int mMaxRadius;
        int[] mTouchThemeAttrs;

        public RippleState(LayerDrawable.LayerState layerState, RippleDrawable rippleDrawable, Resources resources) {
            super(layerState, rippleDrawable, resources);
            this.mColor = ColorStateList.valueOf(Color.MAGENTA);
            this.mMaxRadius = -1;
            if (layerState == null || !(layerState instanceof RippleState)) {
                return;
            }
            RippleState rippleState = (RippleState) layerState;
            this.mTouchThemeAttrs = rippleState.mTouchThemeAttrs;
            this.mColor = rippleState.mColor;
            this.mMaxRadius = rippleState.mMaxRadius;
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mTouchThemeAttrs != null || super.canApplyTheme();
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new RippleDrawable(this, (Resources) null);
        }

        @Override // android.graphics.drawable.LayerDrawable.LayerState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new RippleDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RippleDrawable() {
        this(new RippleState(null, null, null), null);
    }

    public RippleDrawable(ColorStateList colorStateList, Drawable drawable, Drawable drawable2) {
        this(new RippleState(null, null, null), null);
        if (colorStateList == null) {
            throw new IllegalArgumentException("RippleDrawable requires a non-null color");
        }
        if (drawable != null) {
            addLayer(drawable, null, 0, 0, 0, 0, 0);
        }
        if (drawable2 != null) {
            addLayer(drawable2, null, R.id.mask, 0, 0, 0, 0);
        }
        setColor(colorStateList);
        ensurePadding();
        initializeFromState();
    }

    private RippleDrawable(RippleState rippleState, Resources resources) {
        this.mTempRect = new Rect();
        this.mHotspotBounds = new Rect();
        this.mDrawingBounds = new Rect();
        this.mDirtyBounds = new Rect();
        this.mExitingRipplesCount = 0;
        this.mDensity = 1.0f;
        this.mState = new RippleState(rippleState, this, resources);
        this.mLayerState = this.mState;
        if (this.mState.mNum > 0) {
            ensurePadding();
        }
        if (resources != null) {
            this.mDensity = resources.getDisplayMetrics().density;
        }
        initializeFromState();
    }

    private boolean cancelExitingRipples() {
        boolean z = false;
        int i = this.mExitingRipplesCount;
        Ripple[] rippleArr = this.mExitingRipples;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            z |= rippleArr[i3].isHardwareAnimating();
            rippleArr[i3].cancel();
            i2 = i3 + 1;
        }
        if (rippleArr != null) {
            Arrays.fill(rippleArr, 0, i, (Object) null);
        }
        this.mExitingRipplesCount = 0;
        return z;
    }

    private void clearHotspots() {
        if (this.mRipple != null) {
            this.mRipple.cancel();
            this.mRipple = null;
            this.mRippleActive = false;
        }
        if (this.mBackground != null) {
            this.mBackground.cancel();
            this.mBackground = null;
            this.mBackgroundActive = false;
        }
        cancelExitingRipples();
        invalidateSelf();
    }

    private void drawBackgroundAndRipples(Canvas canvas) {
        Ripple ripple = this.mRipple;
        RippleBackground rippleBackground = this.mBackground;
        int i = this.mExitingRipplesCount;
        if (ripple != null || i > 0 || (rippleBackground != null && rippleBackground.shouldDraw())) {
            float exactCenterX = this.mHotspotBounds.exactCenterX();
            float exactCenterY = this.mHotspotBounds.exactCenterY();
            canvas.translate(exactCenterX, exactCenterY);
            updateMaskShaderIfNeeded();
            if (this.mMaskShader != null) {
                this.mMaskMatrix.setTranslate(-exactCenterX, -exactCenterY);
                this.mMaskShader.setLocalMatrix(this.mMaskMatrix);
            }
            int colorForState = this.mState.mColor.getColorForState(getState(), -16777216);
            int alpha = (Color.alpha(colorForState) / 2) << 24;
            Paint ripplePaint = getRipplePaint();
            if (this.mMaskColorFilter != null) {
                this.mMaskColorFilter.setColor(colorForState | (-16777216));
                ripplePaint.setColor(alpha);
                ripplePaint.setColorFilter(this.mMaskColorFilter);
                ripplePaint.setShader(this.mMaskShader);
            } else {
                ripplePaint.setColor((16777215 & colorForState) | alpha);
                ripplePaint.setColorFilter(null);
                ripplePaint.setShader(null);
            }
            if (rippleBackground != null && rippleBackground.shouldDraw()) {
                rippleBackground.draw(canvas, ripplePaint);
            }
            if (i > 0) {
                Ripple[] rippleArr = this.mExitingRipples;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        break;
                    }
                    rippleArr[i3].draw(canvas, ripplePaint);
                    i2 = i3 + 1;
                }
            }
            if (ripple != null) {
                ripple.draw(canvas, ripplePaint);
            }
            canvas.translate(-exactCenterX, -exactCenterY);
        }
    }

    private void drawContent(Canvas canvas) {
        LayerDrawable.ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            if (childDrawableArr[i3].mId != 16908334) {
                childDrawableArr[i3].mDrawable.draw(canvas);
            }
            i2 = i3 + 1;
        }
    }

    private void drawMask(Canvas canvas) {
        this.mMask.draw(canvas);
    }

    private int getMaskType() {
        if (this.mRipple == null && this.mExitingRipplesCount <= 0 && (this.mBackground == null || !this.mBackground.shouldDraw())) {
            return -1;
        }
        if (this.mMask != null) {
            return this.mMask.getOpacity() == -1 ? 0 : 2;
        }
        LayerDrawable.ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return 0;
            }
            if (childDrawableArr[i3].mDrawable.getOpacity() != -1) {
                return 1;
            }
            i2 = i3 + 1;
        }
    }

    private int getRippleIndex(Ripple ripple) {
        Ripple[] rippleArr = this.mExitingRipples;
        int i = this.mExitingRipplesCount;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return -1;
            }
            if (rippleArr[i3] == ripple) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    private Paint getRipplePaint() {
        if (this.mRipplePaint == null) {
            this.mRipplePaint = new Paint();
            this.mRipplePaint.setAntiAlias(true);
            this.mRipplePaint.setStyle(Paint.Style.FILL);
        }
        return this.mRipplePaint;
    }

    private void initializeFromState() {
        this.mMask = findDrawableByLayerId(R.id.mask);
    }

    private void onHotspotBoundsChanged() {
        int i = this.mExitingRipplesCount;
        Ripple[] rippleArr = this.mExitingRipples;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            rippleArr[i3].onHotspotBoundsChanged();
            i2 = i3 + 1;
        }
        if (this.mRipple != null) {
            this.mRipple.onHotspotBoundsChanged();
        }
        if (this.mBackground != null) {
            this.mBackground.onHotspotBoundsChanged();
        }
    }

    private void setBackgroundActive(boolean z, boolean z2) {
        if (this.mBackgroundActive != z) {
            this.mBackgroundActive = z;
            if (z) {
                tryBackgroundEnter(z2);
            } else {
                tryBackgroundExit();
            }
        }
    }

    private void setRippleActive(boolean z) {
        if (this.mRippleActive != z) {
            this.mRippleActive = z;
            if (z) {
                tryRippleEnter();
            } else {
                tryRippleExit();
            }
        }
    }

    private void setTargetDensity(DisplayMetrics displayMetrics) {
        if (this.mDensity != displayMetrics.density) {
            this.mDensity = displayMetrics.density;
            invalidateSelf();
        }
    }

    private void tryBackgroundEnter(boolean z) {
        if (this.mBackground == null) {
            this.mBackground = new RippleBackground(this, this.mHotspotBounds);
        }
        this.mBackground.setup(this.mState.mMaxRadius, this.mDensity);
        this.mBackground.enter(z);
    }

    private void tryBackgroundExit() {
        if (this.mBackground != null) {
            this.mBackground.exit();
        }
    }

    private void tryRippleEnter() {
        float exactCenterX;
        float exactCenterY;
        if (this.mExitingRipplesCount >= 10) {
            return;
        }
        if (this.mRipple == null) {
            if (this.mHasPending) {
                this.mHasPending = false;
                exactCenterX = this.mPendingX;
                exactCenterY = this.mPendingY;
            } else {
                exactCenterX = this.mHotspotBounds.exactCenterX();
                exactCenterY = this.mHotspotBounds.exactCenterY();
            }
            this.mRipple = new Ripple(this, this.mHotspotBounds, exactCenterX, exactCenterY);
        }
        this.mRipple.setup(this.mState.mMaxRadius, this.mDensity);
        this.mRipple.enter();
    }

    private void tryRippleExit() {
        if (this.mRipple != null) {
            if (this.mExitingRipples == null) {
                this.mExitingRipples = new Ripple[10];
            }
            Ripple[] rippleArr = this.mExitingRipples;
            int i = this.mExitingRipplesCount;
            this.mExitingRipplesCount = i + 1;
            rippleArr[i] = this.mRipple;
            this.mRipple.exit();
            this.mRipple = null;
        }
    }

    private void updateMaskShaderIfNeeded() {
        int maskType;
        if (this.mHasValidMask || (maskType = getMaskType()) == -1) {
            return;
        }
        this.mHasValidMask = true;
        Rect bounds = getBounds();
        if (maskType == 0 || bounds.isEmpty()) {
            if (this.mMaskBuffer != null) {
                this.mMaskBuffer.recycle();
                this.mMaskBuffer = null;
                this.mMaskShader = null;
                this.mMaskCanvas = null;
            }
            this.mMaskMatrix = null;
            this.mMaskColorFilter = null;
            return;
        }
        if (this.mMaskBuffer != null && this.mMaskBuffer.getWidth() == bounds.width() && this.mMaskBuffer.getHeight() == bounds.height()) {
            this.mMaskBuffer.eraseColor(0);
        } else {
            if (this.mMaskBuffer != null) {
                this.mMaskBuffer.recycle();
            }
            this.mMaskBuffer = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ALPHA_8);
            this.mMaskShader = new BitmapShader(this.mMaskBuffer, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mMaskCanvas = new Canvas(this.mMaskBuffer);
        }
        if (this.mMaskMatrix == null) {
            this.mMaskMatrix = new Matrix();
        } else {
            this.mMaskMatrix.reset();
        }
        if (this.mMaskColorFilter == null) {
            this.mMaskColorFilter = new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_IN);
        }
        if (maskType == 2) {
            drawMask(this.mMaskCanvas);
        } else if (maskType == 1) {
            drawContent(this.mMaskCanvas);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        RippleState rippleState = this.mState;
        rippleState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        rippleState.mTouchThemeAttrs = typedArray.extractThemeAttrs();
        ColorStateList colorStateList = typedArray.getColorStateList(0);
        if (colorStateList != null) {
            this.mState.mColor = colorStateList;
        }
        verifyRequiredAttributes(typedArray);
    }

    private void verifyRequiredAttributes(TypedArray typedArray) throws XmlPullParserException {
        if (this.mState.mColor == null) {
            if (this.mState.mTouchThemeAttrs == null || this.mState.mTouchThemeAttrs[0] == 0) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + ": <ripple> requires a valid color attribute");
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        RippleState rippleState = this.mState;
        if (rippleState == null || rippleState.mTouchThemeAttrs == null) {
            return;
        }
        TypedArray resolveAttributes = theme.resolveAttributes(rippleState.mTouchThemeAttrs, com.android.internal.R.styleable.RippleDrawable);
        try {
            try {
                updateStateFromTypedArray(resolveAttributes);
                resolveAttributes.recycle();
                initializeFromState();
            } catch (XmlPullParserException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            resolveAttributes.recycle();
            throw th;
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mState != null && this.mState.canApplyTheme()) || super.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.graphics.drawable.LayerDrawable
    public RippleState createConstantState(LayerDrawable.LayerState layerState, Resources resources) {
        return new RippleState(layerState, this, resources);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect dirtyBounds = getDirtyBounds();
        int save = canvas.save(2);
        canvas.clipRect(dirtyBounds);
        drawContent(canvas);
        drawBackgroundAndRipples(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (isProjected()) {
            Rect rect = this.mDrawingBounds;
            Rect rect2 = this.mDirtyBounds;
            rect2.set(rect);
            rect.setEmpty();
            int exactCenterX = (int) this.mHotspotBounds.exactCenterX();
            int exactCenterY = (int) this.mHotspotBounds.exactCenterY();
            Rect rect3 = this.mTempRect;
            Ripple[] rippleArr = this.mExitingRipples;
            int i = this.mExitingRipplesCount;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                rippleArr[i3].getBounds(rect3);
                rect3.offset(exactCenterX, exactCenterY);
                rect.union(rect3);
                i2 = i3 + 1;
            }
            RippleBackground rippleBackground = this.mBackground;
            if (rippleBackground != null) {
                rippleBackground.getBounds(rect3);
                rect3.offset(exactCenterX, exactCenterY);
                rect.union(rect3);
            }
            rect2.union(rect);
            rect2.union(super.getDirtyBounds());
            return rect2;
        }
        return getBounds();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        rect.set(this.mHotspotBounds);
    }

    public int getMaxRadius() {
        return this.mState.mMaxRadius;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        LayerDrawable.LayerState layerState = this.mLayerState;
        LayerDrawable.ChildDrawable[] childDrawableArr = layerState.mChildren;
        int i = layerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            if (childDrawableArr[i3].mId != 16908334) {
                childDrawableArr[i3].mDrawable.getOutline(outline);
                if (!outline.isEmpty()) {
                    return;
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, com.android.internal.R.styleable.RippleDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        setPaddingMode(1);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        setTargetDensity(resources.getDisplayMetrics());
        initializeFromState();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.mHasValidMask = false;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return getNumberOfLayers() == 0;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.mRipple != null) {
            this.mRipple.jump();
        }
        if (this.mBackground != null) {
            this.mBackground.jump();
        }
        cancelExitingRipples();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        super.mutate();
        this.mState = (RippleState) this.mLayerState;
        this.mMask = findDrawableByLayerId(R.id.mask);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!this.mOverrideBounds) {
            this.mHotspotBounds.set(rect);
            onHotspotBoundsChanged();
        }
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        if (r7 != false) goto L31;
     */
    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onStateChange(int[] r5) {
        /*
            r4 = this;
            r0 = 0
            r13 = r0
            r0 = r4
            r1 = r5
            boolean r0 = super.onStateChange(r1)
            r14 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = 0
            r11 = r0
            r0 = r5
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r6 = r0
        L18:
            r0 = r6
            r1 = r9
            if (r0 >= r1) goto L4a
            r0 = r5
            r1 = r6
            r0 = r0[r1]
            r10 = r0
            r0 = r10
            r1 = 16842910(0x101009e, float:2.3694E-38)
            if (r0 != r1) goto L2e
            r0 = 1
            r8 = r0
        L2e:
            r0 = r10
            r1 = 16842908(0x101009c, float:2.3693995E-38)
            if (r0 != r1) goto L39
            r0 = 1
            r11 = r0
        L39:
            r0 = r10
            r1 = 16842919(0x10100a7, float:2.3694026E-38)
            if (r0 != r1) goto L43
            r0 = 1
            r7 = r0
        L43:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L18
        L4a:
            r0 = r8
            if (r0 == 0) goto L80
            r0 = r7
            if (r0 == 0) goto L80
            r0 = 1
            r12 = r0
        L56:
            r0 = r4
            r1 = r12
            r0.setRippleActive(r1)
            r0 = r11
            if (r0 != 0) goto L72
            r0 = r13
            r12 = r0
            r0 = r8
            if (r0 == 0) goto L75
            r0 = r13
            r12 = r0
            r0 = r7
            if (r0 == 0) goto L75
        L72:
            r0 = 1
            r12 = r0
        L75:
            r0 = r4
            r1 = r12
            r2 = r11
            r0.setBackgroundActive(r1, r2)
            r0 = r14
            return r0
        L80:
            r0 = 0
            r12 = r0
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.drawable.RippleDrawable.onStateChange(int[]):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeRipple(Ripple ripple) {
        Ripple[] rippleArr = this.mExitingRipples;
        int i = this.mExitingRipplesCount;
        int rippleIndex = getRippleIndex(ripple);
        if (rippleIndex >= 0) {
            System.arraycopy(rippleArr, rippleIndex + 1, rippleArr, rippleIndex, i - (rippleIndex + 1));
            rippleArr[i - 1] = null;
            this.mExitingRipplesCount--;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
    }

    public void setColor(ColorStateList colorStateList) {
        this.mState.mColor = colorStateList;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.LayerDrawable
    public boolean setDrawableByLayerId(int i, Drawable drawable) {
        if (super.setDrawableByLayerId(i, drawable)) {
            if (i == 16908334) {
                this.mMask = drawable;
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.mRipple == null || this.mBackground == null) {
            this.mPendingX = f;
            this.mPendingY = f2;
            this.mHasPending = true;
        }
        if (this.mRipple != null) {
            this.mRipple.move(f, f2);
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mOverrideBounds = true;
        this.mHotspotBounds.set(i, i2, i3, i4);
        onHotspotBoundsChanged();
    }

    public void setMaxRadius(int i) {
        if (i != -1 && i < 0) {
            throw new IllegalArgumentException("maxRadius must be RADIUS_AUTO or >= 0");
        }
        this.mState.mMaxRadius = i;
    }

    @Override // android.graphics.drawable.LayerDrawable
    public void setPaddingMode(int i) {
        super.setPaddingMode(i);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            clearHotspots();
        } else if (visible) {
            if (this.mRippleActive) {
                tryRippleEnter();
            }
            if (this.mBackgroundActive) {
                tryBackgroundEnter(false);
            }
            jumpToCurrentState();
            return visible;
        }
        return visible;
    }
}
