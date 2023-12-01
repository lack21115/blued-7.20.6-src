package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import java.util.Collection;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/DrawableContainer.class */
public class DrawableContainer extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private Runnable mAnimationRunnable;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;
    private int mAlpha = 255;
    private int mCurIndex = -1;
    private int mLastIndex = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/DrawableContainer$DrawableContainerState.class */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        boolean mComputedConstantSize;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        boolean mDither;
        SparseArray<ConstantStateFuture> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainer mOwner;
        boolean mPaddingChecked;
        final Resources mRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/DrawableContainer$DrawableContainerState$ConstantStateFuture.class */
        public static class ConstantStateFuture {
            private final Drawable.ConstantState mConstantState;

            private ConstantStateFuture(Drawable drawable) {
                this.mConstantState = drawable.getConstantState();
            }

            public boolean canApplyTheme() {
                return this.mConstantState.canApplyTheme();
            }

            public Drawable get(DrawableContainerState drawableContainerState) {
                Drawable newDrawable = drawableContainerState.mRes == null ? this.mConstantState.newDrawable() : this.mConstantState.newDrawable(drawableContainerState.mRes);
                newDrawable.setLayoutDirection(drawableContainerState.mLayoutDirection);
                newDrawable.setCallback(drawableContainerState.mOwner);
                if (drawableContainerState.mMutated) {
                    newDrawable.mutate();
                }
                return newDrawable;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = drawableContainer;
            this.mRes = resources;
            if (drawableContainerState == null) {
                this.mDrawables = new Drawable[10];
                this.mNumChildren = 0;
                return;
            }
            this.mChangingConfigurations = drawableContainerState.mChangingConfigurations;
            this.mChildrenChangingConfigurations = drawableContainerState.mChildrenChangingConfigurations;
            this.mCheckedConstantState = true;
            this.mCanConstantState = true;
            this.mVariablePadding = drawableContainerState.mVariablePadding;
            this.mConstantSize = drawableContainerState.mConstantSize;
            this.mDither = drawableContainerState.mDither;
            this.mMutated = drawableContainerState.mMutated;
            this.mLayoutDirection = drawableContainerState.mLayoutDirection;
            this.mEnterFadeDuration = drawableContainerState.mEnterFadeDuration;
            this.mExitFadeDuration = drawableContainerState.mExitFadeDuration;
            this.mAutoMirrored = drawableContainerState.mAutoMirrored;
            this.mColorFilter = drawableContainerState.mColorFilter;
            this.mHasColorFilter = drawableContainerState.mHasColorFilter;
            this.mTintList = drawableContainerState.mTintList;
            this.mTintMode = drawableContainerState.mTintMode;
            this.mHasTintList = drawableContainerState.mHasTintList;
            this.mHasTintMode = drawableContainerState.mHasTintMode;
            this.mConstantPadding = drawableContainerState.getConstantPadding();
            this.mPaddingChecked = true;
            this.mConstantWidth = drawableContainerState.getConstantWidth();
            this.mConstantHeight = drawableContainerState.getConstantHeight();
            this.mConstantMinimumWidth = drawableContainerState.getConstantMinimumWidth();
            this.mConstantMinimumHeight = drawableContainerState.getConstantMinimumHeight();
            this.mComputedConstantSize = true;
            this.mOpacity = drawableContainerState.getOpacity();
            this.mCheckedOpacity = true;
            this.mStateful = drawableContainerState.isStateful();
            this.mCheckedStateful = true;
            Drawable[] drawableArr = drawableContainerState.mDrawables;
            this.mDrawables = new Drawable[drawableArr.length];
            this.mNumChildren = drawableContainerState.mNumChildren;
            SparseArray<ConstantStateFuture> sparseArray = drawableContainerState.mDrawableFutures;
            if (sparseArray != null) {
                this.mDrawableFutures = sparseArray.m1025clone();
            } else {
                this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
            }
            int i = this.mNumChildren;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                if (drawableArr[i3] != null) {
                    if (drawableArr[i3].getConstantState() != null) {
                        this.mDrawableFutures.put(i3, new ConstantStateFuture(drawableArr[i3]));
                    } else {
                        this.mDrawables[i3] = drawableArr[i3];
                    }
                }
                i2 = i3 + 1;
            }
        }

        private final void createAllFutures() {
            if (this.mDrawableFutures == null) {
                return;
            }
            int size = this.mDrawableFutures.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.mDrawableFutures = null;
                    return;
                }
                this.mDrawables[this.mDrawableFutures.keyAt(i2)] = this.mDrawableFutures.valueAt(i2).get(this);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mutate() {
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mMutated = true;
                    return;
                }
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
                i2 = i3 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            int i = this.mNumChildren;
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                Drawable.ConstantState constantState = getChild(i3).getConstantState();
                int i4 = i2;
                if (constantState != null) {
                    i4 = i2 + constantState.addAtlasableBitmaps(collection);
                }
                i3++;
                i2 = i4;
            }
            return i2;
        }

        public final int addChild(Drawable drawable) {
            int i = this.mNumChildren;
            if (i >= this.mDrawables.length) {
                growArray(i, i + 10);
            }
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations |= drawable.getChangingConfigurations();
            this.mCheckedStateful = false;
            this.mCheckedOpacity = false;
            this.mConstantPadding = null;
            this.mPaddingChecked = false;
            this.mComputedConstantSize = false;
            return i;
        }

        final void applyTheme(Resources.Theme theme) {
            if (theme == null) {
                return;
            }
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                }
                i2 = i3 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return false;
                }
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    ConstantStateFuture constantStateFuture = this.mDrawableFutures.get(i3);
                    if (constantStateFuture != null && constantStateFuture.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }

        public boolean canConstantState() {
            boolean z = false;
            synchronized (this) {
                if (!this.mCheckedConstantState) {
                    createAllFutures();
                    this.mCheckedConstantState = true;
                    int i = this.mNumChildren;
                    Drawable[] drawableArr = this.mDrawables;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= i) {
                            this.mCanConstantState = true;
                            z = true;
                            break;
                        } else if (drawableArr[i3].getConstantState() == null) {
                            this.mCanConstantState = false;
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                } else {
                    z = this.mCanConstantState;
                }
            }
            return z;
        }

        final void clearMutated() {
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mMutated = false;
                    return;
                }
                if (drawableArr[i3] != null) {
                    drawableArr[i3].clearMutated();
                }
                i2 = i3 + 1;
            }
        }

        protected void computeConstantSize() {
            this.mComputedConstantSize = true;
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
                i2 = i3 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int i) {
            int indexOfKey;
            Drawable drawable = this.mDrawables[i];
            if (drawable != null) {
                return drawable;
            }
            if (this.mDrawableFutures == null || (indexOfKey = this.mDrawableFutures.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawable2 = this.mDrawableFutures.valueAt(indexOfKey).get(this);
            this.mDrawables[i] = drawable2;
            this.mDrawableFutures.removeAt(indexOfKey);
            return drawable2;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final Drawable[] getChildren() {
            createAllFutures();
            return this.mDrawables;
        }

        public final int getConstantHeight() {
            if (!this.mComputedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mComputedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mComputedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            if (this.mVariablePadding) {
                return null;
            }
            if (this.mConstantPadding != null || this.mPaddingChecked) {
                return this.mConstantPadding;
            }
            createAllFutures();
            Rect rect = null;
            Rect rect2 = new Rect();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (i2 < i) {
                Rect rect3 = rect;
                if (drawableArr[i2].getPadding(rect2)) {
                    Rect rect4 = rect;
                    if (rect == null) {
                        rect4 = new Rect(0, 0, 0, 0);
                    }
                    if (rect2.left > rect4.left) {
                        rect4.left = rect2.left;
                    }
                    if (rect2.top > rect4.top) {
                        rect4.top = rect2.top;
                    }
                    if (rect2.right > rect4.right) {
                        rect4.right = rect2.right;
                    }
                    rect3 = rect4;
                    if (rect2.bottom > rect4.bottom) {
                        rect4.bottom = rect2.bottom;
                        rect3 = rect4;
                    }
                }
                i2++;
                rect = rect3;
            }
            this.mPaddingChecked = true;
            this.mConstantPadding = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.mComputedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            createAllFutures();
            this.mCheckedOpacity = true;
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mOpacity = opacity;
                    return opacity;
                }
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
                i2 = i3 + 1;
            }
        }

        public void growArray(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.mDrawables, 0, drawableArr, 0, i);
            this.mDrawables = drawableArr;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            createAllFutures();
            this.mCheckedStateful = true;
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    this.mStateful = false;
                    return false;
                } else if (drawableArr[i3].isStateful()) {
                    this.mStateful = true;
                    return true;
                } else {
                    i2 = i3 + 1;
                }
            }
        }

        public final void setConstantSize(boolean z) {
            this.mConstantSize = z;
        }

        public final void setEnterFadeDuration(int i) {
            this.mEnterFadeDuration = i;
        }

        public final void setExitFadeDuration(int i) {
            this.mExitFadeDuration = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setLayoutDirection(int i) {
            int i2 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    this.mLayoutDirection = i;
                    return;
                }
                if (drawableArr[i4] != null) {
                    drawableArr[i4].setLayoutDirection(i);
                }
                i3 = i4 + 1;
            }
        }

        public final void setVariablePadding(boolean z) {
            this.mVariablePadding = z;
        }
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        drawable.mutate();
        if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
            drawable.setAlpha(this.mAlpha);
        }
        if (this.mDrawableContainerState.mHasColorFilter) {
            drawable.setColorFilter(this.mDrawableContainerState.mColorFilter);
        } else {
            if (this.mDrawableContainerState.mHasTintList) {
                drawable.setTintList(this.mDrawableContainerState.mTintList);
            }
            if (this.mDrawableContainerState.mHasTintMode) {
                drawable.setTintMode(this.mDrawableContainerState.mTintMode);
            }
        }
        drawable.setVisible(isVisible(), true);
        drawable.setDither(this.mDrawableContainerState.mDither);
        drawable.setState(getState());
        drawable.setLevel(getLevel());
        drawable.setBounds(getBounds());
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
        Rect rect = this.mHotspotBounds;
        if (rect != null) {
            drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    private boolean needsMirroring() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    void animate(boolean z) {
        boolean z2;
        boolean z3;
        this.mHasAlpha = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mCurrDrawable != null) {
            z2 = false;
            if (this.mEnterAnimationEnd != 0) {
                if (this.mEnterAnimationEnd <= uptimeMillis) {
                    this.mCurrDrawable.mutate().setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                    z2 = false;
                } else {
                    this.mCurrDrawable.mutate().setAlpha(((255 - (((int) ((this.mEnterAnimationEnd - uptimeMillis) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
                    z2 = true;
                }
            }
        } else {
            this.mEnterAnimationEnd = 0L;
            z2 = false;
        }
        if (this.mLastDrawable != null) {
            z3 = z2;
            if (this.mExitAnimationEnd != 0) {
                if (this.mExitAnimationEnd <= uptimeMillis) {
                    this.mLastDrawable.setVisible(false, false);
                    this.mLastDrawable = null;
                    this.mLastIndex = -1;
                    this.mExitAnimationEnd = 0L;
                    z3 = z2;
                } else {
                    this.mLastDrawable.mutate().setAlpha((this.mAlpha * (((int) ((this.mExitAnimationEnd - uptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration)) / 255);
                    z3 = true;
                }
            }
        } else {
            this.mExitAnimationEnd = 0L;
            z3 = z2;
        }
        if (z && z3) {
            scheduleSelf(this.mAnimationRunnable, 16 + uptimeMillis);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.draw(canvas);
        }
        if (this.mLastDrawable != null) {
            this.mLastDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.mChangingConfigurations | this.mDrawableContainerState.mChildrenChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState()) {
            this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            return this.mDrawableContainerState;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.mHotspotBounds != null) {
            rect.set(this.mHotspotBounds);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mCurrDrawable == null || !this.mCurrDrawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Insets getOpticalInsets() {
        return this.mCurrDrawable != null ? this.mCurrDrawable.getOpticalInsets() : Insets.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (((constantPadding.left | constantPadding.top) | constantPadding.bottom) | constantPadding.right) != 0;
        } else {
            padding = this.mCurrDrawable != null ? this.mCurrDrawable.getPadding(rect) : super.getPadding(rect);
        }
        if (needsMirroring()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z = false;
        if (this.mLastDrawable != null) {
            this.mLastDrawable.jumpToCurrentState();
            this.mLastDrawable = null;
            this.mLastIndex = -1;
            z = true;
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.mutate().setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            z = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState cloneConstantState = cloneConstantState();
            cloneConstantState.mutate();
            setConstantState(cloneConstantState);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setBounds(rect);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setLevel(i);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setLevel(i);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setState(iArr);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public boolean selectDrawable(int i) {
        if (i == this.mCurIndex) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            if (this.mLastDrawable != null) {
                this.mLastDrawable.setVisible(false, false);
            }
            if (this.mCurrDrawable != null) {
                this.mLastDrawable = this.mCurrDrawable;
                this.mLastIndex = this.mCurIndex;
                this.mExitAnimationEnd = this.mDrawableContainerState.mExitFadeDuration + uptimeMillis;
            } else {
                this.mLastDrawable = null;
                this.mLastIndex = -1;
                this.mExitAnimationEnd = 0L;
            }
        } else if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(false, false);
        }
        if (i < 0 || i >= this.mDrawableContainerState.mNumChildren) {
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
        } else {
            Drawable child = this.mDrawableContainerState.getChild(i);
            this.mCurrDrawable = child;
            this.mCurIndex = i;
            if (child != null) {
                if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
                    this.mEnterAnimationEnd = this.mDrawableContainerState.mEnterFadeDuration + uptimeMillis;
                }
                initializeDrawableForDisplay(child);
            }
        }
        if (this.mEnterAnimationEnd != 0 || this.mExitAnimationEnd != 0) {
            if (this.mAnimationRunnable == null) {
                this.mAnimationRunnable = new Runnable() { // from class: android.graphics.drawable.DrawableContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainer.this.animate(true);
                        DrawableContainer.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.mAnimationRunnable);
            }
            animate(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mHasAlpha && this.mAlpha == i) {
            return;
        }
        this.mHasAlpha = true;
        this.mAlpha = i;
        if (this.mCurrDrawable != null) {
            if (this.mEnterAnimationEnd == 0) {
                this.mCurrDrawable.mutate().setAlpha(i);
            } else {
                animate(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.mDrawableContainerState.mAutoMirrored != z) {
            this.mDrawableContainerState.mAutoMirrored = z;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.mutate().setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableContainerState.mHasColorFilter = colorFilter != null;
        if (this.mDrawableContainerState.mColorFilter != colorFilter) {
            this.mDrawableContainerState.mColorFilter = colorFilter;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.mutate().setColorFilter(colorFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setConstantState(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        if (this.mCurIndex >= 0) {
            this.mCurrDrawable = drawableContainerState.getChild(this.mCurIndex);
            if (this.mCurrDrawable != null) {
                initializeDrawableForDisplay(this.mCurrDrawable);
            }
        }
        this.mLastIndex = -1;
        this.mLastDrawable = null;
    }

    public void setCurrentIndex(int i) {
        selectDrawable(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.mDrawableContainerState.mDither != z) {
            this.mDrawableContainerState.mDither = z;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.mutate().setDither(this.mDrawableContainerState.mDither);
            }
        }
    }

    public void setEnterFadeDuration(int i) {
        this.mDrawableContainerState.mEnterFadeDuration = i;
    }

    public void setExitFadeDuration(int i) {
        this.mDrawableContainerState.mExitFadeDuration = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.mHotspotBounds == null) {
            this.mHotspotBounds = new Rect(i, i2, i3, i4);
        } else {
            this.mHotspotBounds.set(i, i2, i3, i4);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mDrawableContainerState.mHasTintList = true;
        if (this.mDrawableContainerState.mTintList != colorStateList) {
            this.mDrawableContainerState.mTintList = colorStateList;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.mutate().setTintList(colorStateList);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mDrawableContainerState.mHasTintMode = true;
        if (this.mDrawableContainerState.mTintMode != mode) {
            this.mDrawableContainerState.mTintMode = mode;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.mutate().setTintMode(mode);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setVisible(z, z2);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
