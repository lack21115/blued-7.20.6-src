package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/LayerDrawable.class */
public class LayerDrawable extends Drawable implements Drawable.Callback {
    public static final int PADDING_MODE_NEST = 0;
    public static final int PADDING_MODE_STACK = 1;
    private Rect mHotspotBounds;
    LayerState mLayerState;
    private boolean mMutated;
    private int mOpacityOverride;
    private int[] mPaddingB;
    private int[] mPaddingL;
    private int[] mPaddingR;
    private int[] mPaddingT;
    private final Rect mTmpRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/LayerDrawable$ChildDrawable.class */
    public static class ChildDrawable {
        public Drawable mDrawable;
        public int mId;
        public int mInsetB;
        public int mInsetL;
        public int mInsetR;
        public int mInsetT;
        public int[] mThemeAttrs;

        ChildDrawable() {
            this.mId = -1;
        }

        ChildDrawable(ChildDrawable childDrawable, LayerDrawable layerDrawable, Resources resources) {
            this.mId = -1;
            if (resources != null) {
                this.mDrawable = childDrawable.mDrawable.getConstantState().newDrawable(resources);
            } else {
                this.mDrawable = childDrawable.mDrawable.getConstantState().newDrawable();
            }
            this.mDrawable.setCallback(layerDrawable);
            this.mDrawable.setLayoutDirection(childDrawable.mDrawable.getLayoutDirection());
            this.mDrawable.setBounds(childDrawable.mDrawable.getBounds());
            this.mDrawable.setLevel(childDrawable.mDrawable.getLevel());
            this.mThemeAttrs = childDrawable.mThemeAttrs;
            this.mInsetL = childDrawable.mInsetL;
            this.mInsetT = childDrawable.mInsetT;
            this.mInsetR = childDrawable.mInsetR;
            this.mInsetB = childDrawable.mInsetB;
            this.mId = childDrawable.mId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/LayerDrawable$LayerState.class */
    public static class LayerState extends Drawable.ConstantState {
        private boolean mAutoMirrored;
        int mChangingConfigurations;
        ChildDrawable[] mChildren;
        int mChildrenChangingConfigurations;
        private boolean mHaveIsStateful;
        private boolean mHaveOpacity;
        private boolean mIsStateful;
        int mNum;
        private int mOpacity;
        private int mPaddingMode;
        int[] mThemeAttrs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LayerState(LayerState layerState, LayerDrawable layerDrawable, Resources resources) {
            this.mAutoMirrored = false;
            this.mPaddingMode = 0;
            if (layerState == null) {
                this.mNum = 0;
                this.mChildren = null;
                return;
            }
            ChildDrawable[] childDrawableArr = layerState.mChildren;
            int i = layerState.mNum;
            this.mNum = i;
            this.mChildren = new ChildDrawable[i];
            this.mChangingConfigurations = layerState.mChangingConfigurations;
            this.mChildrenChangingConfigurations = layerState.mChildrenChangingConfigurations;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mHaveOpacity = layerState.mHaveOpacity;
                    this.mOpacity = layerState.mOpacity;
                    this.mHaveIsStateful = layerState.mHaveIsStateful;
                    this.mIsStateful = layerState.mIsStateful;
                    this.mAutoMirrored = layerState.mAutoMirrored;
                    this.mPaddingMode = layerState.mPaddingMode;
                    this.mThemeAttrs = layerState.mThemeAttrs;
                    return;
                }
                this.mChildren[i3] = new ChildDrawable(childDrawableArr[i3], layerDrawable, resources);
                i2 = i3 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                Drawable.ConstantState constantState = childDrawableArr[i3].mDrawable.getConstantState();
                int i4 = i2;
                if (constantState != null) {
                    i4 = i2 + constantState.addAtlasableBitmaps(collection);
                }
                i3++;
                i2 = i4;
            }
            return i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            if (this.mThemeAttrs != null || super.canApplyTheme()) {
                return true;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                ChildDrawable childDrawable = childDrawableArr[i3];
                if (childDrawable.mThemeAttrs != null || childDrawable.mDrawable.canApplyTheme()) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }

        public final boolean canConstantState() {
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return true;
                }
                if (childDrawableArr[i3].mDrawable.getConstantState() == null) {
                    return false;
                }
                i2 = i3 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final int getOpacity() {
            if (this.mHaveOpacity) {
                return this.mOpacity;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int opacity = i > 0 ? childDrawableArr[0].mDrawable.getOpacity() : -2;
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mOpacity = opacity;
                    this.mHaveOpacity = true;
                    return opacity;
                }
                opacity = Drawable.resolveOpacity(opacity, childDrawableArr[i3].mDrawable.getOpacity());
                i2 = i3 + 1;
            }
        }

        public void invalidateCache() {
            this.mHaveOpacity = false;
            this.mHaveIsStateful = false;
        }

        public final boolean isStateful() {
            boolean z;
            if (this.mHaveIsStateful) {
                return this.mIsStateful;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= i) {
                    break;
                } else if (childDrawableArr[i3].mDrawable.isStateful()) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            this.mIsStateful = z;
            this.mHaveIsStateful = true;
            return z;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new LayerDrawable(this, (Resources) null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new LayerDrawable(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayerDrawable() {
        this((LayerState) null, (Resources) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayerDrawable(LayerState layerState, Resources resources) {
        this.mOpacityOverride = 0;
        this.mTmpRect = new Rect();
        this.mLayerState = createConstantState(layerState, resources);
        if (this.mLayerState.mNum > 0) {
            ensurePadding();
        }
    }

    public LayerDrawable(Drawable[] drawableArr) {
        this(drawableArr, (LayerState) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayerDrawable(Drawable[] drawableArr, LayerState layerState) {
        this(layerState, (Resources) null);
        int length = drawableArr.length;
        ChildDrawable[] childDrawableArr = new ChildDrawable[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mLayerState.mNum = length;
                this.mLayerState.mChildren = childDrawableArr;
                ensurePadding();
                return;
            }
            childDrawableArr[i2] = new ChildDrawable();
            childDrawableArr[i2].mDrawable = drawableArr[i2];
            drawableArr[i2].setCallback(this);
            this.mLayerState.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
            i = i2 + 1;
        }
    }

    private void computeNestedPadding(Rect rect) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            refreshChildPadding(i3, childDrawableArr[i3]);
            rect.left += this.mPaddingL[i3];
            rect.top += this.mPaddingT[i3];
            rect.right += this.mPaddingR[i3];
            rect.bottom += this.mPaddingB[i3];
            i2 = i3 + 1;
        }
    }

    private void computeStackedPadding(Rect rect) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            refreshChildPadding(i3, childDrawableArr[i3]);
            rect.left = Math.max(rect.left, this.mPaddingL[i3]);
            rect.top = Math.max(rect.top, this.mPaddingT[i3]);
            rect.right = Math.max(rect.right, this.mPaddingR[i3]);
            rect.bottom = Math.max(rect.bottom, this.mPaddingB[i3]);
            i2 = i3 + 1;
        }
    }

    private void inflateLayers(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        LayerState layerState = this.mLayerState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                ChildDrawable childDrawable = new ChildDrawable();
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.LayerDrawableItem);
                updateLayerFromTypedArray(childDrawable, obtainAttributes);
                obtainAttributes.recycle();
                if (childDrawable.mDrawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    childDrawable.mDrawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                }
                if (childDrawable.mDrawable != null) {
                    layerState.mChildrenChangingConfigurations |= childDrawable.mDrawable.getChangingConfigurations();
                    childDrawable.mDrawable.setCallback(this);
                }
                addLayer(childDrawable);
            }
        }
    }

    private boolean refreshChildPadding(int i, ChildDrawable childDrawable) {
        Rect rect = this.mTmpRect;
        childDrawable.mDrawable.getPadding(rect);
        if (rect.left == this.mPaddingL[i] && rect.top == this.mPaddingT[i] && rect.right == this.mPaddingR[i] && rect.bottom == this.mPaddingB[i]) {
            return false;
        }
        this.mPaddingL[i] = rect.left;
        this.mPaddingT[i] = rect.top;
        this.mPaddingR[i] = rect.right;
        this.mPaddingB[i] = rect.bottom;
        return true;
    }

    private void updateLayerFromTypedArray(ChildDrawable childDrawable, TypedArray typedArray) {
        this.mLayerState.mChildrenChangingConfigurations |= typedArray.getChangingConfigurations();
        childDrawable.mThemeAttrs = typedArray.extractThemeAttrs();
        childDrawable.mInsetL = typedArray.getDimensionPixelOffset(2, childDrawable.mInsetL);
        childDrawable.mInsetT = typedArray.getDimensionPixelOffset(3, childDrawable.mInsetT);
        childDrawable.mInsetR = typedArray.getDimensionPixelOffset(4, childDrawable.mInsetR);
        childDrawable.mInsetB = typedArray.getDimensionPixelOffset(5, childDrawable.mInsetB);
        childDrawable.mId = typedArray.getResourceId(0, childDrawable.mId);
        Drawable drawable = typedArray.getDrawable(1);
        if (drawable != null) {
            childDrawable.mDrawable = drawable;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        LayerState layerState = this.mLayerState;
        layerState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        layerState.mThemeAttrs = typedArray.extractThemeAttrs();
        this.mOpacityOverride = typedArray.getInt(0, this.mOpacityOverride);
        layerState.mAutoMirrored = typedArray.getBoolean(1, layerState.mAutoMirrored);
        layerState.mPaddingMode = typedArray.getInteger(2, layerState.mPaddingMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildDrawable addLayer(Drawable drawable, int[] iArr, int i, int i2, int i3, int i4, int i5) {
        ChildDrawable childDrawable = new ChildDrawable();
        childDrawable.mId = i;
        childDrawable.mThemeAttrs = iArr;
        childDrawable.mDrawable = drawable;
        childDrawable.mDrawable.setAutoMirrored(isAutoMirrored());
        childDrawable.mInsetL = i2;
        childDrawable.mInsetT = i3;
        childDrawable.mInsetR = i4;
        childDrawable.mInsetB = i5;
        addLayer(childDrawable);
        this.mLayerState.mChildrenChangingConfigurations |= drawable.getChangingConfigurations();
        drawable.setCallback(this);
        return childDrawable;
    }

    void addLayer(ChildDrawable childDrawable) {
        LayerState layerState = this.mLayerState;
        int length = layerState.mChildren != null ? layerState.mChildren.length : 0;
        int i = layerState.mNum;
        if (i >= length) {
            ChildDrawable[] childDrawableArr = new ChildDrawable[length + 10];
            if (i > 0) {
                System.arraycopy(layerState.mChildren, 0, childDrawableArr, 0, i);
            }
            layerState.mChildren = childDrawableArr;
        }
        layerState.mChildren[i] = childDrawable;
        layerState.mNum++;
        layerState.invalidateCache();
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        LayerState layerState = this.mLayerState;
        if (layerState == null) {
            return;
        }
        if (layerState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(layerState.mThemeAttrs, R.styleable.LayerDrawable);
            updateStateFromTypedArray(resolveAttributes);
            resolveAttributes.recycle();
        }
        ChildDrawable[] childDrawableArr = layerState.mChildren;
        int i = layerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                ensurePadding();
                onStateChange(getState());
                return;
            }
            ChildDrawable childDrawable = childDrawableArr[i3];
            if (childDrawable.mThemeAttrs != null) {
                TypedArray resolveAttributes2 = theme.resolveAttributes(childDrawable.mThemeAttrs, R.styleable.LayerDrawableItem);
                updateLayerFromTypedArray(childDrawable, resolveAttributes2);
                resolveAttributes2.recycle();
            }
            Drawable drawable = childDrawable.mDrawable;
            if (drawable.canApplyTheme()) {
                drawable.applyTheme(theme);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mLayerState != null && this.mLayerState.canApplyTheme()) || super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.mMutated = false;
                return;
            } else {
                childDrawableArr[i3].mDrawable.clearMutated();
                i2 = i3 + 1;
            }
        }
    }

    LayerState createConstantState(LayerState layerState, Resources resources) {
        return new LayerState(layerState, this, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.draw(canvas);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensurePadding() {
        int i = this.mLayerState.mNum;
        if (this.mPaddingL == null || this.mPaddingL.length < i) {
            this.mPaddingL = new int[i];
            this.mPaddingT = new int[i];
            this.mPaddingR = new int[i];
            this.mPaddingB = new int[i];
        }
    }

    public Drawable findDrawableByLayerId(int i) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                return null;
            }
            if (childDrawableArr[i3].mId == i) {
                return childDrawableArr[i3].mDrawable;
            }
            i2 = i3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mLayerState.mNum > 0 ? this.mLayerState.mChildren[0].mDrawable.getAlpha() : super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mLayerState.mChangingConfigurations | this.mLayerState.mChildrenChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mLayerState.canConstantState()) {
            this.mLayerState.mChangingConfigurations = getChangingConfigurations();
            return this.mLayerState;
        }
        return null;
    }

    public Drawable getDrawable(int i) {
        return this.mLayerState.mChildren[i].mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.mHotspotBounds != null) {
            rect.set(this.mHotspotBounds);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getId(int i) {
        return this.mLayerState.mChildren[i].mId;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        boolean z = this.mLayerState.mPaddingMode == 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i4 = this.mLayerState.mNum;
        int i5 = 0;
        while (i5 < i4) {
            ChildDrawable childDrawable = childDrawableArr[i5];
            int intrinsicHeight = childDrawable.mDrawable.getIntrinsicHeight() + childDrawable.mInsetT + childDrawable.mInsetB + i2 + i3;
            int i6 = i;
            if (intrinsicHeight > i) {
                i6 = intrinsicHeight;
            }
            int i7 = i3;
            int i8 = i2;
            if (z) {
                i8 = i2 + this.mPaddingT[i5];
                i7 = i3 + this.mPaddingB[i5];
            }
            i5++;
            i = i6;
            i3 = i7;
            i2 = i8;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        boolean z = this.mLayerState.mPaddingMode == 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i4 = this.mLayerState.mNum;
        int i5 = 0;
        while (i5 < i4) {
            ChildDrawable childDrawable = childDrawableArr[i5];
            int intrinsicWidth = childDrawable.mDrawable.getIntrinsicWidth() + childDrawable.mInsetL + childDrawable.mInsetR + i2 + i3;
            int i6 = i;
            if (intrinsicWidth > i) {
                i6 = intrinsicWidth;
            }
            int i7 = i2;
            int i8 = i3;
            if (z) {
                i7 = i2 + this.mPaddingL[i5];
                i8 = i3 + this.mPaddingR[i5];
            }
            i5++;
            i2 = i7;
            i3 = i8;
            i = i6;
        }
        return i;
    }

    public int getNumberOfLayers() {
        return this.mLayerState.mNum;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mOpacityOverride != 0 ? this.mOpacityOverride : this.mLayerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        LayerState layerState = this.mLayerState;
        ChildDrawable[] childDrawableArr = layerState.mChildren;
        int i = layerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.getOutline(outline);
            if (!outline.isEmpty()) {
                return;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.mLayerState.mPaddingMode == 0) {
            computeNestedPadding(rect);
        } else {
            computeStackedPadding(rect);
        }
        return (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) ? false : true;
    }

    public int getPaddingMode() {
        return this.mLayerState.mPaddingMode;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.LayerDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        inflateLayers(resources, xmlPullParser, attributeSet, theme);
        ensurePadding();
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mLayerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        if (super.isProjected()) {
            return true;
        }
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return false;
            }
            if (childDrawableArr[i3].mDrawable.isProjected()) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mLayerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mLayerState = createConstantState(this.mLayerState, null);
            ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
            int i = this.mLayerState.mNum;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                childDrawableArr[i3].mDrawable.mutate();
                i2 = i3 + 1;
            }
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = this.mLayerState.mPaddingMode == 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i5 = this.mLayerState.mNum;
        int i6 = 0;
        while (i6 < i5) {
            ChildDrawable childDrawable = childDrawableArr[i6];
            childDrawable.mDrawable.setBounds(rect.left + childDrawable.mInsetL + i, rect.top + childDrawable.mInsetT + i2, (rect.right - childDrawable.mInsetR) - i3, (rect.bottom - childDrawable.mInsetB) - i4);
            int i7 = i4;
            int i8 = i;
            int i9 = i3;
            int i10 = i2;
            if (z) {
                i8 = i + this.mPaddingL[i6];
                i9 = i3 + this.mPaddingR[i6];
                i10 = i2 + this.mPaddingT[i6];
                i7 = i4 + this.mPaddingB[i6];
            }
            i6++;
            i4 = i7;
            i = i8;
            i3 = i9;
            i2 = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean z = false;
        boolean z2 = false;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            ChildDrawable childDrawable = childDrawableArr[i4];
            if (childDrawable.mDrawable.setLevel(i)) {
                z2 = true;
            }
            if (refreshChildPadding(i4, childDrawable)) {
                z = true;
            }
            i3 = i4 + 1;
        }
        if (z) {
            onBoundsChange(getBounds());
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (i2 < i) {
            ChildDrawable childDrawable = childDrawableArr[i2];
            boolean z3 = z2;
            if (childDrawable.mDrawable.isStateful()) {
                z3 = z2;
                if (childDrawable.mDrawable.setState(iArr)) {
                    z3 = true;
                }
            }
            if (refreshChildPadding(i2, childDrawable)) {
                z = true;
            }
            i2++;
            z2 = z3;
        }
        if (z) {
            onBoundsChange(getBounds());
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            childDrawableArr[i4].mDrawable.setAlpha(i);
            i3 = i4 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.mLayerState.mAutoMirrored = z;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setAutoMirrored(z);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setColorFilter(colorFilter);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setDither(z);
            i2 = i3 + 1;
        }
    }

    public boolean setDrawableByLayerId(int i, Drawable drawable) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return false;
            }
            ChildDrawable childDrawable = childDrawableArr[i4];
            if (childDrawable.mId == i) {
                if (childDrawable.mDrawable != null) {
                    if (drawable != null) {
                        drawable.setBounds(childDrawable.mDrawable.getBounds());
                    }
                    childDrawable.mDrawable.setCallback(null);
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                childDrawable.mDrawable = drawable;
                this.mLayerState.invalidateCache();
                return true;
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setHotspot(f, f2);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i5 = this.mLayerState.mNum;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i5) {
                break;
            }
            childDrawableArr[i7].mDrawable.setHotspotBounds(i, i2, i3, i4);
            i6 = i7 + 1;
        }
        if (this.mHotspotBounds == null) {
            this.mHotspotBounds = new Rect(i, i2, i3, i4);
        } else {
            this.mHotspotBounds.set(i, i2, i3, i4);
        }
    }

    public void setId(int i, int i2) {
        this.mLayerState.mChildren[i].mId = i2;
    }

    public void setLayerInset(int i, int i2, int i3, int i4, int i5) {
        ChildDrawable childDrawable = this.mLayerState.mChildren[i];
        childDrawable.mInsetL = i2;
        childDrawable.mInsetT = i3;
        childDrawable.mInsetR = i4;
        childDrawable.mInsetB = i5;
    }

    @Override // android.graphics.drawable.Drawable
    public void setLayoutDirection(int i) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                super.setLayoutDirection(i);
                return;
            } else {
                childDrawableArr[i4].mDrawable.setLayoutDirection(i);
                i3 = i4 + 1;
            }
        }
    }

    public void setOpacity(int i) {
        this.mOpacityOverride = i;
    }

    public void setPaddingMode(int i) {
        if (this.mLayerState.mPaddingMode != i) {
            this.mLayerState.mPaddingMode = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setTintList(colorStateList);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            childDrawableArr[i3].mDrawable.setTintMode(mode);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return visible;
            }
            childDrawableArr[i3].mDrawable.setVisible(z, z2);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
