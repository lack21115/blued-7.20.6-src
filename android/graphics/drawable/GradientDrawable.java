package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.R;
import com.anythink.expressad.foundation.h.i;
import com.cdo.oaps.ad.OapsKey;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/GradientDrawable.class */
public class GradientDrawable extends Drawable {
    private static final float DEFAULT_INNER_RADIUS_RATIO = 3.0f;
    private static final float DEFAULT_THICKNESS_RATIO = 9.0f;
    public static final int LINE = 2;
    public static final int LINEAR_GRADIENT = 0;
    public static final int OVAL = 1;
    public static final int RADIAL_GRADIENT = 1;
    private static final int RADIUS_TYPE_FRACTION = 1;
    private static final int RADIUS_TYPE_FRACTION_PARENT = 2;
    private static final int RADIUS_TYPE_PIXELS = 0;
    public static final int RECTANGLE = 0;
    public static final int RING = 3;
    public static final int SWEEP_GRADIENT = 2;
    private int mAlpha;
    private ColorFilter mColorFilter;
    private final Paint mFillPaint;
    private boolean mGradientIsDirty;
    private float mGradientRadius;
    private GradientState mGradientState;
    private Paint mLayerPaint;
    private boolean mMutated;
    private Rect mPadding;
    private final Path mPath;
    private boolean mPathIsDirty;
    private final RectF mRect;
    private Path mRingPath;
    private Paint mStrokePaint;
    private PorterDuffColorFilter mTintFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.graphics.drawable.GradientDrawable$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/GradientDrawable$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation = new int[Orientation.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005f -> B:37:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0063 -> B:31:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0067 -> B:43:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006b -> B:41:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006f -> B:39:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/GradientDrawable$GradientState.class */
    public static final class GradientState extends Drawable.ConstantState {
        public int mAngle;
        int[] mAttrCorners;
        int[] mAttrGradient;
        int[] mAttrPadding;
        int[] mAttrSize;
        int[] mAttrSolid;
        int[] mAttrStroke;
        float mCenterX;
        float mCenterY;
        public int mChangingConfigurations;
        public ColorStateList mColorStateList;
        public int[] mColors;
        public boolean mDither;
        public int mGradient;
        float mGradientRadius;
        int mGradientRadiusType;
        public int mHeight;
        public int mInnerRadius;
        public float mInnerRadiusRatio;
        boolean mOpaqueOverBounds;
        boolean mOpaqueOverShape;
        public Orientation mOrientation;
        public Rect mPadding;
        public float[] mPositions;
        public float mRadius;
        public float[] mRadiusArray;
        public int mShape;
        public ColorStateList mStrokeColorStateList;
        public float mStrokeDashGap;
        public float mStrokeDashWidth;
        public int mStrokeWidth;
        public int[] mTempColors;
        public float[] mTempPositions;
        int[] mThemeAttrs;
        public int mThickness;
        public float mThicknessRatio;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        boolean mUseLevel;
        boolean mUseLevelForShape;
        public int mWidth;

        public GradientState(GradientState gradientState) {
            this.mShape = 0;
            this.mGradient = 0;
            this.mAngle = 0;
            this.mStrokeWidth = -1;
            this.mStrokeDashWidth = 0.0f;
            this.mStrokeDashGap = 0.0f;
            this.mRadius = 0.0f;
            this.mRadiusArray = null;
            this.mPadding = null;
            this.mWidth = -1;
            this.mHeight = -1;
            this.mInnerRadiusRatio = 3.0f;
            this.mThicknessRatio = GradientDrawable.DEFAULT_THICKNESS_RATIO;
            this.mInnerRadius = -1;
            this.mThickness = -1;
            this.mDither = false;
            this.mCenterX = 0.5f;
            this.mCenterY = 0.5f;
            this.mGradientRadius = 0.5f;
            this.mGradientRadiusType = 0;
            this.mUseLevel = false;
            this.mUseLevelForShape = true;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mChangingConfigurations = gradientState.mChangingConfigurations;
            this.mShape = gradientState.mShape;
            this.mGradient = gradientState.mGradient;
            this.mAngle = gradientState.mAngle;
            this.mOrientation = gradientState.mOrientation;
            this.mColorStateList = gradientState.mColorStateList;
            if (gradientState.mColors != null) {
                this.mColors = (int[]) gradientState.mColors.clone();
            }
            if (gradientState.mPositions != null) {
                this.mPositions = (float[]) gradientState.mPositions.clone();
            }
            this.mStrokeColorStateList = gradientState.mStrokeColorStateList;
            this.mStrokeWidth = gradientState.mStrokeWidth;
            this.mStrokeDashWidth = gradientState.mStrokeDashWidth;
            this.mStrokeDashGap = gradientState.mStrokeDashGap;
            this.mRadius = gradientState.mRadius;
            if (gradientState.mRadiusArray != null) {
                this.mRadiusArray = (float[]) gradientState.mRadiusArray.clone();
            }
            if (gradientState.mPadding != null) {
                this.mPadding = new Rect(gradientState.mPadding);
            }
            this.mWidth = gradientState.mWidth;
            this.mHeight = gradientState.mHeight;
            this.mInnerRadiusRatio = gradientState.mInnerRadiusRatio;
            this.mThicknessRatio = gradientState.mThicknessRatio;
            this.mInnerRadius = gradientState.mInnerRadius;
            this.mThickness = gradientState.mThickness;
            this.mDither = gradientState.mDither;
            this.mCenterX = gradientState.mCenterX;
            this.mCenterY = gradientState.mCenterY;
            this.mGradientRadius = gradientState.mGradientRadius;
            this.mGradientRadiusType = gradientState.mGradientRadiusType;
            this.mUseLevel = gradientState.mUseLevel;
            this.mUseLevelForShape = gradientState.mUseLevelForShape;
            this.mOpaqueOverBounds = gradientState.mOpaqueOverBounds;
            this.mOpaqueOverShape = gradientState.mOpaqueOverShape;
            this.mTint = gradientState.mTint;
            this.mTintMode = gradientState.mTintMode;
            this.mThemeAttrs = gradientState.mThemeAttrs;
            this.mAttrSize = gradientState.mAttrSize;
            this.mAttrGradient = gradientState.mAttrGradient;
            this.mAttrSolid = gradientState.mAttrSolid;
            this.mAttrStroke = gradientState.mAttrStroke;
            this.mAttrCorners = gradientState.mAttrCorners;
            this.mAttrPadding = gradientState.mAttrPadding;
        }

        GradientState(Orientation orientation, int[] iArr) {
            this.mShape = 0;
            this.mGradient = 0;
            this.mAngle = 0;
            this.mStrokeWidth = -1;
            this.mStrokeDashWidth = 0.0f;
            this.mStrokeDashGap = 0.0f;
            this.mRadius = 0.0f;
            this.mRadiusArray = null;
            this.mPadding = null;
            this.mWidth = -1;
            this.mHeight = -1;
            this.mInnerRadiusRatio = 3.0f;
            this.mThicknessRatio = GradientDrawable.DEFAULT_THICKNESS_RATIO;
            this.mInnerRadius = -1;
            this.mThickness = -1;
            this.mDither = false;
            this.mCenterX = 0.5f;
            this.mCenterY = 0.5f;
            this.mGradientRadius = 0.5f;
            this.mGradientRadiusType = 0;
            this.mUseLevel = false;
            this.mUseLevelForShape = true;
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mOrientation = orientation;
            setColors(iArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void computeOpacity() {
            boolean z = true;
            this.mOpaqueOverBounds = false;
            this.mOpaqueOverShape = false;
            if (this.mColors != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mColors.length) {
                        break;
                    } else if (!GradientDrawable.isOpaque(this.mColors[i2])) {
                        return;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
            if (this.mColors == null && this.mColorStateList == null) {
                return;
            }
            this.mOpaqueOverShape = true;
            if (this.mShape != 0 || this.mRadius > 0.0f || this.mRadiusArray != null) {
                z = false;
            }
            this.mOpaqueOverBounds = z;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return (this.mThemeAttrs == null && this.mAttrSize == null && this.mAttrGradient == null && this.mAttrSolid == null && this.mAttrStroke == null && this.mAttrCorners == null && this.mAttrPadding == null && !super.canApplyTheme()) ? false : true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GradientDrawable(this, (AnonymousClass1) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new GradientDrawable(this, (AnonymousClass1) null);
        }

        public void setColorStateList(ColorStateList colorStateList) {
            this.mColors = null;
            this.mColorStateList = colorStateList;
            computeOpacity();
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            this.mColorStateList = null;
            computeOpacity();
        }

        public void setCornerRadii(float[] fArr) {
            this.mRadiusArray = fArr;
            if (fArr == null) {
                this.mRadius = 0.0f;
            }
        }

        public void setCornerRadius(float f) {
            float f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
            this.mRadius = f2;
            this.mRadiusArray = null;
        }

        public void setGradientCenter(float f, float f2) {
            this.mCenterX = f;
            this.mCenterY = f2;
        }

        public void setGradientRadius(float f, int i) {
            this.mGradientRadius = f;
            this.mGradientRadiusType = i;
        }

        public void setGradientType(int i) {
            this.mGradient = i;
        }

        public void setShape(int i) {
            this.mShape = i;
            computeOpacity();
        }

        public void setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public void setStroke(int i, ColorStateList colorStateList, float f, float f2) {
            this.mStrokeWidth = i;
            this.mStrokeColorStateList = colorStateList;
            this.mStrokeDashWidth = f;
            this.mStrokeDashGap = f2;
            computeOpacity();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/GradientDrawable$Orientation.class */
    public enum Orientation {
        TOP_BOTTOM,
        TR_BL,
        RIGHT_LEFT,
        BR_TL,
        BOTTOM_TOP,
        BL_TR,
        LEFT_RIGHT,
        TL_BR
    }

    public GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
    }

    private GradientDrawable(GradientState gradientState) {
        this.mFillPaint = new Paint(1);
        this.mAlpha = 255;
        this.mPath = new Path();
        this.mRect = new RectF();
        this.mPathIsDirty = true;
        this.mGradientState = gradientState;
        initializeWithState(this.mGradientState);
        this.mGradientIsDirty = true;
        this.mMutated = false;
    }

    /* synthetic */ GradientDrawable(GradientState gradientState, AnonymousClass1 anonymousClass1) {
        this(gradientState);
    }

    public GradientDrawable(Orientation orientation, int[] iArr) {
        this(new GradientState(orientation, iArr));
    }

    private void applyThemeChildElements(Resources.Theme theme) {
        TypedArray resolveAttributes;
        GradientState gradientState = this.mGradientState;
        if (gradientState.mAttrSize != null) {
            TypedArray resolveAttributes2 = theme.resolveAttributes(gradientState.mAttrSize, R.styleable.GradientDrawableSize);
            updateGradientDrawableSize(resolveAttributes2);
            resolveAttributes2.recycle();
        }
        if (gradientState.mAttrGradient != null) {
            resolveAttributes = theme.resolveAttributes(gradientState.mAttrGradient, R.styleable.GradientDrawableGradient);
            try {
                try {
                    updateGradientDrawableGradient(theme.getResources(), resolveAttributes);
                    resolveAttributes.recycle();
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                resolveAttributes.recycle();
            }
        }
        if (gradientState.mAttrSolid != null) {
            TypedArray resolveAttributes3 = theme.resolveAttributes(gradientState.mAttrSolid, R.styleable.GradientDrawableSolid);
            updateGradientDrawableSolid(resolveAttributes3);
            resolveAttributes3.recycle();
        }
        if (gradientState.mAttrStroke != null) {
            TypedArray resolveAttributes4 = theme.resolveAttributes(gradientState.mAttrStroke, R.styleable.GradientDrawableStroke);
            updateGradientDrawableStroke(resolveAttributes4);
            resolveAttributes4.recycle();
        }
        if (gradientState.mAttrCorners != null) {
            updateDrawableCorners(theme.resolveAttributes(gradientState.mAttrCorners, R.styleable.DrawableCorners));
        }
        if (gradientState.mAttrPadding != null) {
            updateGradientDrawablePadding(theme.resolveAttributes(gradientState.mAttrPadding, R.styleable.GradientDrawablePadding));
        }
    }

    private void buildPathIfDirty() {
        GradientState gradientState = this.mGradientState;
        if (this.mPathIsDirty) {
            ensureValidRect();
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, gradientState.mRadiusArray, Path.Direction.CW);
            this.mPathIsDirty = false;
        }
    }

    private Path buildRing(GradientState gradientState) {
        if (this.mRingPath == null || (gradientState.mUseLevelForShape && this.mPathIsDirty)) {
            this.mPathIsDirty = false;
            float level = gradientState.mUseLevelForShape ? (getLevel() * 360.0f) / 10000.0f : 360.0f;
            RectF rectF = new RectF(this.mRect);
            float width = rectF.width() / 2.0f;
            float height = rectF.height() / 2.0f;
            float width2 = gradientState.mThickness != -1 ? gradientState.mThickness : rectF.width() / gradientState.mThicknessRatio;
            float width3 = gradientState.mInnerRadius != -1 ? gradientState.mInnerRadius : rectF.width() / gradientState.mInnerRadiusRatio;
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(width - width3, height - width3);
            RectF rectF3 = new RectF(rectF2);
            rectF3.inset(-width2, -width2);
            if (this.mRingPath == null) {
                this.mRingPath = new Path();
            } else {
                this.mRingPath.reset();
            }
            Path path = this.mRingPath;
            if (level >= 360.0f || level <= -360.0f) {
                path.addOval(rectF3, Path.Direction.CW);
                path.addOval(rectF2, Path.Direction.CCW);
                return path;
            }
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(width + width3, height);
            path.lineTo(width + width3 + width2, height);
            path.arcTo(rectF3, 0.0f, level, false);
            path.arcTo(rectF2, level, -level, false);
            path.close();
            return path;
        }
        return this.mRingPath;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0362, code lost:
        if (r0.length != (r0 + 1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x03ab, code lost:
        if (r0.length != (r0 + 1)) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ensureValidRect() {
        /*
            Method dump skipped, instructions count: 1049
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.drawable.GradientDrawable.ensureValidRect():boolean");
    }

    private static float getFloatOrFraction(TypedArray typedArray, int i, float f) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null) {
            if (!(peekValue.type == 6)) {
                return peekValue.getFloat();
            }
            f = peekValue.getFraction(1.0f, 1.0f);
        }
        return f;
    }

    private void inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                String name = xmlPullParser.getName();
                if (name.equals(OapsKey.KEY_SIZE)) {
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawableSize);
                    updateGradientDrawableSize(obtainAttributes);
                    obtainAttributes.recycle();
                } else if (name.equals("gradient")) {
                    TypedArray obtainAttributes2 = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawableGradient);
                    updateGradientDrawableGradient(resources, obtainAttributes2);
                    obtainAttributes2.recycle();
                } else if (name.equals("solid")) {
                    TypedArray obtainAttributes3 = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawableSolid);
                    updateGradientDrawableSolid(obtainAttributes3);
                    obtainAttributes3.recycle();
                } else if (name.equals("stroke")) {
                    TypedArray obtainAttributes4 = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawableStroke);
                    updateGradientDrawableStroke(obtainAttributes4);
                    obtainAttributes4.recycle();
                } else if (name.equals("corners")) {
                    TypedArray obtainAttributes5 = obtainAttributes(resources, theme, attributeSet, R.styleable.DrawableCorners);
                    updateDrawableCorners(obtainAttributes5);
                    obtainAttributes5.recycle();
                } else if (name.equals("padding")) {
                    TypedArray obtainAttributes6 = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawablePadding);
                    updateGradientDrawablePadding(obtainAttributes6);
                    obtainAttributes6.recycle();
                } else {
                    Log.w(i.f5112c, "Bad element under <shape>: " + name);
                }
            }
        }
    }

    private void initializeWithState(GradientState gradientState) {
        if (gradientState.mColorStateList != null) {
            this.mFillPaint.setColor(gradientState.mColorStateList.getColorForState(getState(), 0));
        } else if (gradientState.mColors == null) {
            this.mFillPaint.setColor(0);
        } else {
            this.mFillPaint.setColor(-16777216);
        }
        this.mPadding = gradientState.mPadding;
        if (gradientState.mStrokeWidth >= 0) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeWidth(gradientState.mStrokeWidth);
            if (gradientState.mStrokeColorStateList != null) {
                this.mStrokePaint.setColor(gradientState.mStrokeColorStateList.getColorForState(getState(), 0));
            }
            if (gradientState.mStrokeDashWidth != 0.0f) {
                this.mStrokePaint.setPathEffect(new DashPathEffect(new float[]{gradientState.mStrokeDashWidth, gradientState.mStrokeDashGap}, 0.0f));
            }
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, gradientState.mTint, gradientState.mTintMode);
    }

    static boolean isOpaque(int i) {
        return ((i >> 24) & 255) == 255;
    }

    private boolean isOpaqueForState() {
        return (this.mGradientState.mStrokeWidth < 0 || this.mStrokePaint == null || isOpaque(this.mStrokePaint.getColor())) && isOpaque(this.mFillPaint.getColor());
    }

    private int modulateAlpha(int i) {
        return (i * (this.mAlpha + (this.mAlpha >> 7))) >> 8;
    }

    private void setStrokeInternal(int i, int i2, float f, float f2) {
        if (this.mStrokePaint == null) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        this.mStrokePaint.setStrokeWidth(i);
        this.mStrokePaint.setColor(i2);
        DashPathEffect dashPathEffect = null;
        if (f > 0.0f) {
            dashPathEffect = new DashPathEffect(new float[]{f, f2}, 0.0f);
        }
        this.mStrokePaint.setPathEffect(dashPathEffect);
        invalidateSelf();
    }

    private void updateDrawableCorners(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrCorners = typedArray.extractThemeAttrs();
        int dimensionPixelSize = typedArray.getDimensionPixelSize(0, (int) gradientState.mRadius);
        setCornerRadius(dimensionPixelSize);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(1, dimensionPixelSize);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(2, dimensionPixelSize);
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(3, dimensionPixelSize);
        int dimensionPixelSize5 = typedArray.getDimensionPixelSize(4, dimensionPixelSize);
        if (dimensionPixelSize2 == dimensionPixelSize && dimensionPixelSize3 == dimensionPixelSize && dimensionPixelSize4 == dimensionPixelSize && dimensionPixelSize5 == dimensionPixelSize) {
            return;
        }
        setCornerRadii(new float[]{dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize5, dimensionPixelSize5, dimensionPixelSize4, dimensionPixelSize4});
    }

    private void updateGradientDrawableGradient(Resources resources, TypedArray typedArray) throws XmlPullParserException {
        float f;
        int i;
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrGradient = typedArray.extractThemeAttrs();
        gradientState.mCenterX = getFloatOrFraction(typedArray, 5, gradientState.mCenterX);
        gradientState.mCenterY = getFloatOrFraction(typedArray, 6, gradientState.mCenterY);
        gradientState.mUseLevel = typedArray.getBoolean(2, gradientState.mUseLevel);
        gradientState.mGradient = typedArray.getInt(4, gradientState.mGradient);
        int color = typedArray.getColor(0, 0);
        boolean hasValue = typedArray.hasValue(8);
        int color2 = typedArray.getColor(8, 0);
        int color3 = typedArray.getColor(1, 0);
        if (hasValue) {
            gradientState.mColors = new int[3];
            gradientState.mColors[0] = color;
            gradientState.mColors[1] = color2;
            gradientState.mColors[2] = color3;
            gradientState.mPositions = new float[3];
            gradientState.mPositions[0] = 0.0f;
            gradientState.mPositions[1] = gradientState.mCenterX != 0.5f ? gradientState.mCenterX : gradientState.mCenterY;
            gradientState.mPositions[2] = 1.0f;
        } else {
            gradientState.mColors = new int[2];
            gradientState.mColors[0] = color;
            gradientState.mColors[1] = color3;
        }
        if (gradientState.mGradient != 0) {
            TypedValue peekValue = typedArray.peekValue(7);
            if (peekValue == null) {
                if (gradientState.mGradient == 1) {
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return;
            }
            if (peekValue.type == 6) {
                f = peekValue.getFraction(1.0f, 1.0f);
                i = ((peekValue.data >> 0) & 15) == 1 ? 2 : 1;
            } else if (peekValue.type == 5) {
                f = peekValue.getDimension(resources.getDisplayMetrics());
                i = 0;
            } else {
                f = peekValue.getFloat();
                i = 0;
            }
            gradientState.mGradientRadius = f;
            gradientState.mGradientRadiusType = i;
            return;
        }
        int i2 = ((int) typedArray.getFloat(3, gradientState.mAngle)) % 360;
        if (i2 % 45 != 0) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<gradient> tag requires 'angle' attribute to be a multiple of 45");
        }
        gradientState.mAngle = i2;
        switch (i2) {
            case 0:
                gradientState.mOrientation = Orientation.LEFT_RIGHT;
                return;
            case 45:
                gradientState.mOrientation = Orientation.BL_TR;
                return;
            case 90:
                gradientState.mOrientation = Orientation.BOTTOM_TOP;
                return;
            case 135:
                gradientState.mOrientation = Orientation.BR_TL;
                return;
            case 180:
                gradientState.mOrientation = Orientation.RIGHT_LEFT;
                return;
            case 225:
                gradientState.mOrientation = Orientation.TR_BL;
                return;
            case 270:
                gradientState.mOrientation = Orientation.TOP_BOTTOM;
                return;
            case 315:
                gradientState.mOrientation = Orientation.TL_BR;
                return;
            default:
                return;
        }
    }

    private void updateGradientDrawablePadding(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrPadding = typedArray.extractThemeAttrs();
        if (gradientState.mPadding == null) {
            gradientState.mPadding = new Rect();
        }
        Rect rect = gradientState.mPadding;
        rect.set(typedArray.getDimensionPixelOffset(0, rect.left), typedArray.getDimensionPixelOffset(1, rect.top), typedArray.getDimensionPixelOffset(2, rect.right), typedArray.getDimensionPixelOffset(3, rect.bottom));
        this.mPadding = rect;
    }

    private void updateGradientDrawableSize(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrSize = typedArray.extractThemeAttrs();
        gradientState.mWidth = typedArray.getDimensionPixelSize(1, gradientState.mWidth);
        gradientState.mHeight = typedArray.getDimensionPixelSize(0, gradientState.mHeight);
    }

    private void updateGradientDrawableSolid(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrSolid = typedArray.extractThemeAttrs();
        ColorStateList colorStateList = typedArray.getColorStateList(0);
        if (colorStateList != null) {
            setColor(colorStateList);
        }
    }

    private void updateGradientDrawableStroke(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mAttrStroke = typedArray.extractThemeAttrs();
        int dimensionPixelSize = typedArray.getDimensionPixelSize(0, Math.max(0, gradientState.mStrokeWidth));
        float dimension = typedArray.getDimension(2, gradientState.mStrokeDashWidth);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList == null) {
            colorStateList2 = gradientState.mStrokeColorStateList;
        }
        if (dimension != 0.0f) {
            setStroke(dimensionPixelSize, colorStateList2, dimension, typedArray.getDimension(3, gradientState.mStrokeDashGap));
        } else {
            setStroke(dimensionPixelSize, colorStateList2);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        GradientState gradientState = this.mGradientState;
        gradientState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        gradientState.mThemeAttrs = typedArray.extractThemeAttrs();
        gradientState.mShape = typedArray.getInt(3, gradientState.mShape);
        gradientState.mDither = typedArray.getBoolean(0, gradientState.mDither);
        if (gradientState.mShape == 3) {
            gradientState.mInnerRadius = typedArray.getDimensionPixelSize(7, gradientState.mInnerRadius);
            if (gradientState.mInnerRadius == -1) {
                gradientState.mInnerRadiusRatio = typedArray.getFloat(4, gradientState.mInnerRadiusRatio);
            }
            gradientState.mThickness = typedArray.getDimensionPixelSize(8, gradientState.mThickness);
            if (gradientState.mThickness == -1) {
                gradientState.mThicknessRatio = typedArray.getFloat(5, gradientState.mThicknessRatio);
            }
            gradientState.mUseLevelForShape = typedArray.getBoolean(6, gradientState.mUseLevelForShape);
        }
        int i = typedArray.getInt(9, -1);
        if (i != -1) {
            gradientState.mTintMode = Drawable.parseTintMode(i, PorterDuff.Mode.SRC_IN);
        }
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gradientState.mTint = colorStateList;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, gradientState.mTint, gradientState.mTintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        GradientState gradientState = this.mGradientState;
        if (gradientState == null) {
            return;
        }
        if (gradientState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(gradientState.mThemeAttrs, R.styleable.GradientDrawable);
            updateStateFromTypedArray(resolveAttributes);
            resolveAttributes.recycle();
        }
        applyThemeChildElements(theme);
        gradientState.computeOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mGradientState != null && this.mGradientState.canApplyTheme()) || super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v123, types: [android.graphics.ColorFilter] */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (ensureValidRect()) {
            int alpha = this.mFillPaint.getAlpha();
            int alpha2 = this.mStrokePaint != null ? this.mStrokePaint.getAlpha() : 0;
            int modulateAlpha = modulateAlpha(alpha);
            int modulateAlpha2 = modulateAlpha(alpha2);
            boolean z = modulateAlpha2 > 0 && this.mStrokePaint != null && this.mStrokePaint.getStrokeWidth() > 0.0f;
            boolean z2 = modulateAlpha > 0;
            GradientState gradientState = this.mGradientState;
            PorterDuffColorFilter porterDuffColorFilter = this.mColorFilter != null ? this.mColorFilter : this.mTintFilter;
            boolean z3 = z && z2 && gradientState.mShape != 2 && modulateAlpha2 < 255 && (this.mAlpha < 255 || porterDuffColorFilter != null);
            if (z3) {
                if (this.mLayerPaint == null) {
                    this.mLayerPaint = new Paint();
                }
                this.mLayerPaint.setDither(gradientState.mDither);
                this.mLayerPaint.setAlpha(this.mAlpha);
                this.mLayerPaint.setColorFilter(porterDuffColorFilter);
                float strokeWidth = this.mStrokePaint.getStrokeWidth();
                canvas.saveLayer(this.mRect.left - strokeWidth, this.mRect.top - strokeWidth, this.mRect.right + strokeWidth, this.mRect.bottom + strokeWidth, this.mLayerPaint, 4);
                this.mFillPaint.setColorFilter(null);
                this.mStrokePaint.setColorFilter(null);
            } else {
                this.mFillPaint.setAlpha(modulateAlpha);
                this.mFillPaint.setDither(gradientState.mDither);
                this.mFillPaint.setColorFilter(porterDuffColorFilter);
                if (porterDuffColorFilter != null && gradientState.mColorStateList == null) {
                    this.mFillPaint.setColor(this.mAlpha << 24);
                }
                if (z) {
                    this.mStrokePaint.setAlpha(modulateAlpha2);
                    this.mStrokePaint.setDither(gradientState.mDither);
                    this.mStrokePaint.setColorFilter(porterDuffColorFilter);
                }
            }
            switch (gradientState.mShape) {
                case 0:
                    if (gradientState.mRadiusArray == null) {
                        if (gradientState.mRadius <= 0.0f) {
                            if (this.mFillPaint.getColor() != 0 || porterDuffColorFilter != null || this.mFillPaint.getShader() != null) {
                                canvas.drawRect(this.mRect, this.mFillPaint);
                            }
                            if (z) {
                                canvas.drawRect(this.mRect, this.mStrokePaint);
                                break;
                            }
                        } else {
                            float min = Math.min(gradientState.mRadius, Math.min(this.mRect.width(), this.mRect.height()) * 0.5f);
                            canvas.drawRoundRect(this.mRect, min, min, this.mFillPaint);
                            if (z) {
                                canvas.drawRoundRect(this.mRect, min, min, this.mStrokePaint);
                                break;
                            }
                        }
                    } else {
                        buildPathIfDirty();
                        canvas.drawPath(this.mPath, this.mFillPaint);
                        if (z) {
                            canvas.drawPath(this.mPath, this.mStrokePaint);
                            break;
                        }
                    }
                    break;
                case 1:
                    canvas.drawOval(this.mRect, this.mFillPaint);
                    if (z) {
                        canvas.drawOval(this.mRect, this.mStrokePaint);
                        break;
                    }
                    break;
                case 2:
                    RectF rectF = this.mRect;
                    float centerY = rectF.centerY();
                    if (z) {
                        canvas.drawLine(rectF.left, centerY, rectF.right, centerY, this.mStrokePaint);
                        break;
                    }
                    break;
                case 3:
                    Path buildRing = buildRing(gradientState);
                    canvas.drawPath(buildRing, this.mFillPaint);
                    if (z) {
                        canvas.drawPath(buildRing, this.mStrokePaint);
                        break;
                    }
                    break;
            }
            if (z3) {
                canvas.restore();
                return;
            }
            this.mFillPaint.setAlpha(alpha);
            if (z) {
                this.mStrokePaint.setAlpha(alpha2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mGradientState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mGradientState.mChangingConfigurations = getChangingConfigurations();
        return this.mGradientState;
    }

    public float getGradientRadius() {
        if (this.mGradientState.mGradient != 1) {
            return 0.0f;
        }
        ensureValidRect();
        return this.mGradientRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mGradientState.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mGradientState.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (this.mAlpha == 255 && this.mGradientState.mOpaqueOverBounds && isOpaqueForState()) ? -1 : -3;
    }

    public Orientation getOrientation() {
        return this.mGradientState.mOrientation;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        GradientState gradientState = this.mGradientState;
        Rect bounds = getBounds();
        outline.setAlpha((gradientState.mOpaqueOverShape && isOpaqueForState()) ? this.mAlpha / 255.0f : 0.0f);
        switch (gradientState.mShape) {
            case 0:
                if (gradientState.mRadiusArray != null) {
                    buildPathIfDirty();
                    outline.setConvexPath(this.mPath);
                    return;
                }
                float f = 0.0f;
                if (gradientState.mRadius > 0.0f) {
                    f = Math.min(gradientState.mRadius, Math.min(bounds.width(), bounds.height()) * 0.5f);
                }
                outline.setRoundRect(bounds, f);
                return;
            case 1:
                outline.setOval(bounds);
                return;
            case 2:
                float strokeWidth = this.mStrokePaint == null ? 1.0E-4f : this.mStrokePaint.getStrokeWidth() * 0.5f;
                float centerY = bounds.centerY();
                outline.setRect(bounds.left, (int) Math.floor(centerY - strokeWidth), bounds.right, (int) Math.ceil(centerY + strokeWidth));
                return;
            default:
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.mPadding != null) {
            rect.set(this.mPadding);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.GradientDrawable);
        super.inflateWithAttributes(resources, xmlPullParser, obtainAttributes, 2);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        inflateChildElements(resources, xmlPullParser, attributeSet, theme);
        this.mGradientState.computeOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        GradientState gradientState = this.mGradientState;
        if (super.isStateful()) {
            return true;
        }
        if (gradientState.mColorStateList == null || !gradientState.mColorStateList.isStateful()) {
            if (gradientState.mStrokeColorStateList == null || !gradientState.mStrokeColorStateList.isStateful()) {
                return gradientState.mTint != null && gradientState.mTint.isStateful();
            }
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mGradientState = new GradientState(this.mGradientState);
            initializeWithState(this.mGradientState);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mRingPath = null;
        this.mPathIsDirty = true;
        this.mGradientIsDirty = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        super.onLevelChange(i);
        this.mGradientIsDirty = true;
        this.mPathIsDirty = true;
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        GradientState gradientState = this.mGradientState;
        ColorStateList colorStateList = gradientState.mColorStateList;
        boolean z2 = false;
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(iArr, 0);
            z2 = false;
            if (this.mFillPaint.getColor() != colorForState) {
                this.mFillPaint.setColor(colorForState);
                z2 = true;
            }
        }
        Paint paint = this.mStrokePaint;
        boolean z3 = z2;
        if (paint != null) {
            ColorStateList colorStateList2 = gradientState.mStrokeColorStateList;
            z3 = z2;
            if (colorStateList2 != null) {
                int colorForState2 = colorStateList2.getColorForState(iArr, 0);
                z3 = z2;
                if (paint.getColor() != colorForState2) {
                    paint.setColor(colorForState2);
                    z3 = true;
                }
            }
        }
        boolean z4 = z3;
        if (gradientState.mTint != null) {
            z4 = z3;
            if (gradientState.mTintMode != null) {
                this.mTintFilter = updateTintFilter(this.mTintFilter, gradientState.mTint, gradientState.mTintMode);
                z4 = true;
            }
        }
        if (z4) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        this.mGradientState.setColorStateList(ColorStateList.valueOf(i));
        this.mFillPaint.setColor(i);
        invalidateSelf();
    }

    public void setColor(ColorStateList colorStateList) {
        this.mGradientState.setColorStateList(colorStateList);
        this.mFillPaint.setColor(colorStateList == null ? 0 : colorStateList.getColorForState(getState(), 0));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mColorFilter) {
            this.mColorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public void setColors(int[] iArr) {
        this.mGradientState.setColors(iArr);
        this.mGradientIsDirty = true;
        invalidateSelf();
    }

    public void setCornerRadii(float[] fArr) {
        this.mGradientState.setCornerRadii(fArr);
        this.mPathIsDirty = true;
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        this.mGradientState.setCornerRadius(f);
        this.mPathIsDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (z != this.mGradientState.mDither) {
            this.mGradientState.mDither = z;
            invalidateSelf();
        }
    }

    public void setGradientCenter(float f, float f2) {
        this.mGradientState.setGradientCenter(f, f2);
        this.mGradientIsDirty = true;
        invalidateSelf();
    }

    public void setGradientRadius(float f) {
        this.mGradientState.setGradientRadius(f, 0);
        this.mGradientIsDirty = true;
        invalidateSelf();
    }

    public void setGradientType(int i) {
        this.mGradientState.setGradientType(i);
        this.mGradientIsDirty = true;
        invalidateSelf();
    }

    public void setOrientation(Orientation orientation) {
        this.mGradientState.mOrientation = orientation;
        this.mGradientIsDirty = true;
        invalidateSelf();
    }

    public void setShape(int i) {
        this.mRingPath = null;
        this.mPathIsDirty = true;
        this.mGradientState.setShape(i);
        invalidateSelf();
    }

    public void setSize(int i, int i2) {
        this.mGradientState.setSize(i, i2);
        this.mPathIsDirty = true;
        invalidateSelf();
    }

    public void setStroke(int i, int i2) {
        setStroke(i, i2, 0.0f, 0.0f);
    }

    public void setStroke(int i, int i2, float f, float f2) {
        this.mGradientState.setStroke(i, ColorStateList.valueOf(i2), f, f2);
        setStrokeInternal(i, i2, f, f2);
    }

    public void setStroke(int i, ColorStateList colorStateList) {
        setStroke(i, colorStateList, 0.0f, 0.0f);
    }

    public void setStroke(int i, ColorStateList colorStateList, float f, float f2) {
        this.mGradientState.setStroke(i, colorStateList, f, f2);
        setStrokeInternal(i, colorStateList == null ? 0 : colorStateList.getColorForState(getState(), 0), f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mGradientState.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, this.mGradientState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mGradientState.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTintFilter, this.mGradientState.mTint, mode);
        invalidateSelf();
    }

    public void setUseLevel(boolean z) {
        this.mGradientState.mUseLevel = z;
        this.mGradientIsDirty = true;
        invalidateSelf();
    }
}
