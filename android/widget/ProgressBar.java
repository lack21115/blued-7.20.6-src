package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pools;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RemoteViews;
import com.android.internal.R;
import java.util.ArrayList;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar.class */
public class ProgressBar extends View {
    private static final int MAX_LEVEL = 10000;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private AccessibilityEventSender mAccessibilityEventSender;
    private AlphaAnimation mAnimation;
    private boolean mAttached;
    private int mBehavior;
    private Drawable mCurrentDrawable;
    private int mDuration;
    private boolean mHasAnimation;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private Interpolator mInterpolator;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    boolean mMirrorForRtl;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;
    private int mProgress;
    private Drawable mProgressDrawable;
    private ProgressTintInfo mProgressTintInfo;
    private final ArrayList<RefreshData> mRefreshData;
    private boolean mRefreshIsPosted;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar$AccessibilityEventSender.class */
    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar$ProgressTintInfo.class */
    public static class ProgressTintInfo {
        boolean mHasIndeterminateTint;
        boolean mHasIndeterminateTintMode;
        boolean mHasProgressBackgroundTint;
        boolean mHasProgressBackgroundTintMode;
        boolean mHasProgressTint;
        boolean mHasProgressTintMode;
        boolean mHasSecondaryProgressTint;
        boolean mHasSecondaryProgressTintMode;
        ColorStateList mIndeterminateTintList;
        PorterDuff.Mode mIndeterminateTintMode;
        ColorStateList mProgressBackgroundTintList;
        PorterDuff.Mode mProgressBackgroundTintMode;
        ColorStateList mProgressTintList;
        PorterDuff.Mode mProgressTintMode;
        ColorStateList mSecondaryProgressTintList;
        PorterDuff.Mode mSecondaryProgressTintMode;

        private ProgressTintInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar$RefreshData.class */
    public static class RefreshData {
        private static final int POOL_MAX = 24;
        private static final Pools.SynchronizedPool<RefreshData> sPool = new Pools.SynchronizedPool<>(24);
        public boolean fromUser;
        public int id;
        public int progress;

        private RefreshData() {
        }

        public static RefreshData obtain(int i, int i2, boolean z) {
            RefreshData acquire = sPool.acquire();
            RefreshData refreshData = acquire;
            if (acquire == null) {
                refreshData = new RefreshData();
            }
            refreshData.id = i;
            refreshData.progress = i2;
            refreshData.fromUser = z;
            return refreshData;
        }

        public void recycle() {
            sPool.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar$RefreshProgressRunnable.class */
    public class RefreshProgressRunnable implements Runnable {
        private RefreshProgressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ProgressBar.this) {
                int size = ProgressBar.this.mRefreshData.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        RefreshData refreshData = (RefreshData) ProgressBar.this.mRefreshData.get(i2);
                        ProgressBar.this.doRefreshProgress(refreshData.id, refreshData.progress, refreshData.fromUser, true);
                        refreshData.recycle();
                        i = i2 + 1;
                    } else {
                        ProgressBar.this.mRefreshData.clear();
                        ProgressBar.this.mRefreshIsPosted = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ProgressBar$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.ProgressBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;
        int secondaryProgress;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.secondaryProgress = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.secondaryProgress);
        }
    }

    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        boolean z = false;
        this.mMirrorForRtl = false;
        this.mRefreshData = new ArrayList<>();
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBar, i, i2);
        this.mNoInvalidate = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(8);
        if (drawable != null) {
            setProgressDrawableTiled(drawable);
        }
        this.mDuration = obtainStyledAttributes.getInt(9, this.mDuration);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(11, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(0, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(12, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mMaxHeight);
        this.mBehavior = obtainStyledAttributes.getInt(10, this.mBehavior);
        int resourceId = obtainStyledAttributes.getResourceId(13, 17432587);
        if (resourceId > 0) {
            setInterpolator(context, resourceId);
        }
        setMax(obtainStyledAttributes.getInt(2, this.mMax));
        setProgress(obtainStyledAttributes.getInt(3, this.mProgress));
        setSecondaryProgress(obtainStyledAttributes.getInt(4, this.mSecondaryProgress));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
        if (drawable2 != null) {
            setIndeterminateDrawableTiled(drawable2);
        }
        this.mOnlyIndeterminate = obtainStyledAttributes.getBoolean(6, this.mOnlyIndeterminate);
        this.mNoInvalidate = false;
        setIndeterminate((this.mOnlyIndeterminate || obtainStyledAttributes.getBoolean(5, this.mIndeterminate)) ? true : z);
        this.mMirrorForRtl = obtainStyledAttributes.getBoolean(15, this.mMirrorForRtl);
        if (obtainStyledAttributes.hasValue(17)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mProgressTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(19, -1), null);
            this.mProgressTintInfo.mHasProgressTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(16)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mProgressTintList = obtainStyledAttributes.getColorStateList(16);
            this.mProgressTintInfo.mHasProgressTint = true;
        }
        if (obtainStyledAttributes.hasValue(19)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mProgressBackgroundTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(17, -1), null);
            this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(18)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mProgressBackgroundTintList = obtainStyledAttributes.getColorStateList(18);
            this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        }
        if (obtainStyledAttributes.hasValue(21)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mSecondaryProgressTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(21, -1), null);
            this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(20)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mSecondaryProgressTintList = obtainStyledAttributes.getColorStateList(20);
            this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        }
        if (obtainStyledAttributes.hasValue(22)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mIndeterminateTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(23, -1), null);
            this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(22)) {
            if (this.mProgressTintInfo == null) {
                this.mProgressTintInfo = new ProgressTintInfo();
            }
            this.mProgressTintInfo.mIndeterminateTintList = obtainStyledAttributes.getColorStateList(22);
            this.mProgressTintInfo.mHasIndeterminateTint = true;
        }
        obtainStyledAttributes.recycle();
        applyProgressTints();
        applyIndeterminateTint();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void applyIndeterminateTint() {
        if (this.mIndeterminateDrawable == null || this.mProgressTintInfo == null) {
            return;
        }
        ProgressTintInfo progressTintInfo = this.mProgressTintInfo;
        if (progressTintInfo.mHasIndeterminateTint || progressTintInfo.mHasIndeterminateTintMode) {
            this.mIndeterminateDrawable = this.mIndeterminateDrawable.mutate();
            if (progressTintInfo.mHasIndeterminateTint) {
                this.mIndeterminateDrawable.setTintList(progressTintInfo.mIndeterminateTintList);
            }
            if (progressTintInfo.mHasIndeterminateTintMode) {
                this.mIndeterminateDrawable.setTintMode(progressTintInfo.mIndeterminateTintMode);
            }
            if (this.mIndeterminateDrawable.isStateful()) {
                this.mIndeterminateDrawable.setState(getDrawableState());
            }
        }
    }

    private void applyPrimaryProgressTint() {
        Drawable tintTarget;
        if ((this.mProgressTintInfo.mHasProgressTint || this.mProgressTintInfo.mHasProgressTintMode) && (tintTarget = getTintTarget(16908301, true)) != null) {
            if (this.mProgressTintInfo.mHasProgressTint) {
                tintTarget.setTintList(this.mProgressTintInfo.mProgressTintList);
            }
            if (this.mProgressTintInfo.mHasProgressTintMode) {
                tintTarget.setTintMode(this.mProgressTintInfo.mProgressTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    private void applyProgressBackgroundTint() {
        Drawable tintTarget;
        if ((this.mProgressTintInfo.mHasProgressBackgroundTint || this.mProgressTintInfo.mHasProgressBackgroundTintMode) && (tintTarget = getTintTarget(16908288, false)) != null) {
            if (this.mProgressTintInfo.mHasProgressBackgroundTint) {
                tintTarget.setTintList(this.mProgressTintInfo.mProgressBackgroundTintList);
            }
            if (this.mProgressTintInfo.mHasProgressBackgroundTintMode) {
                tintTarget.setTintMode(this.mProgressTintInfo.mProgressBackgroundTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    private void applyProgressTints() {
        if (this.mProgressDrawable == null || this.mProgressTintInfo == null) {
            return;
        }
        applyPrimaryProgressTint();
        applyProgressBackgroundTint();
        applySecondaryProgressTint();
    }

    private void applySecondaryProgressTint() {
        Drawable tintTarget;
        if ((this.mProgressTintInfo.mHasSecondaryProgressTint || this.mProgressTintInfo.mHasSecondaryProgressTintMode) && (tintTarget = getTintTarget(16908303, false)) != null) {
            if (this.mProgressTintInfo.mHasSecondaryProgressTint) {
                tintTarget.setTintList(this.mProgressTintInfo.mSecondaryProgressTintList);
            }
            if (this.mProgressTintInfo.mHasSecondaryProgressTintMode) {
                tintTarget.setTintMode(this.mProgressTintInfo.mSecondaryProgressTintMode);
            }
            if (tintTarget.isStateful()) {
                tintTarget.setState(getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRefreshProgress(int i, int i2, boolean z, boolean z2) {
        synchronized (this) {
            float f = this.mMax > 0 ? i2 / this.mMax : 0.0f;
            Drawable drawable = this.mCurrentDrawable;
            if (drawable != null) {
                Drawable drawable2 = null;
                if (drawable instanceof LayerDrawable) {
                    Drawable findDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(i);
                    drawable2 = findDrawableByLayerId;
                    if (findDrawableByLayerId != null) {
                        drawable2 = findDrawableByLayerId;
                        if (canResolveLayoutDirection()) {
                            findDrawableByLayerId.setLayoutDirection(getLayoutDirection());
                            drawable2 = findDrawableByLayerId;
                        }
                    }
                }
                int i3 = (int) (10000.0f * f);
                if (drawable2 == null) {
                    drawable2 = drawable;
                }
                drawable2.setLevel(i3);
            } else {
                invalidate();
            }
            if (z2 && i == 16908301) {
                onProgressRefresh(f, z);
            }
        }
    }

    private Drawable getTintTarget(int i, boolean z) {
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = this.mProgressDrawable;
        if (drawable3 != null) {
            this.mProgressDrawable = drawable3.mutate();
            if (drawable3 instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable3).findDrawableByLayerId(i);
            }
            drawable = drawable2;
            if (z) {
                drawable = drawable2;
                if (drawable2 == null) {
                    drawable = drawable3;
                }
            }
        }
        return drawable;
    }

    private void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mIndeterminate = false;
        this.mOnlyIndeterminate = false;
        this.mDuration = 4000;
        this.mBehavior = 1;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    private void refreshProgress(int i, int i2, boolean z) {
        synchronized (this) {
            if (this.mUiThreadId == Thread.currentThread().getId()) {
                doRefreshProgress(i, i2, z, true);
            } else {
                if (this.mRefreshProgressRunnable == null) {
                    this.mRefreshProgressRunnable = new RefreshProgressRunnable();
                }
                this.mRefreshData.add(RefreshData.obtain(i, i2, z));
                if (this.mAttached && !this.mRefreshIsPosted) {
                    post(this.mRefreshProgressRunnable);
                    this.mRefreshIsPosted = true;
                }
            }
        }
    }

    private void scheduleAccessibilityEventSender() {
        if (this.mAccessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(this.mAccessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 200L);
    }

    private void setDrawableTint(int i, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        Drawable drawable = null;
        Drawable drawable2 = this.mCurrentDrawable;
        if (drawable2 instanceof LayerDrawable) {
            drawable = ((LayerDrawable) drawable2).findDrawableByLayerId(i);
        }
        Drawable drawable3 = drawable;
        if (z) {
            drawable3 = drawable;
            if (drawable == null) {
                drawable3 = drawable2;
            }
        }
        drawable3.mutate();
        drawable3.setTintList(colorStateList);
        drawable3.setTintMode(mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable tileify(Drawable drawable, boolean z) {
        StateListDrawable stateListDrawable;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numberOfLayers) {
                    break;
                }
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = tileify(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
                i = i2 + 1;
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                stateListDrawable = layerDrawable2;
                if (i4 >= numberOfLayers) {
                    break;
                }
                layerDrawable2.setId(i4, layerDrawable.getId(i4));
                i3 = i4 + 1;
            }
        } else if (!(drawable instanceof StateListDrawable)) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.mSampleTile == null) {
                    this.mSampleTile = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.setTintList(bitmapDrawable.getTint());
                shapeDrawable.setTintMode(bitmapDrawable.getTintMode());
                shapeDrawable.setColorFilter(bitmapDrawable.getColorFilter());
                Drawable drawable2 = shapeDrawable;
                if (z) {
                    drawable2 = new ClipDrawable(shapeDrawable, 3, 1);
                }
                return drawable2;
            }
            return drawable;
        } else {
            StateListDrawable stateListDrawable2 = (StateListDrawable) drawable;
            stateListDrawable = new StateListDrawable();
            int stateCount = stateListDrawable2.getStateCount();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= stateCount) {
                    break;
                }
                stateListDrawable.addState(stateListDrawable2.getStateSet(i6), tileify(stateListDrawable2.getStateDrawable(i6), z));
                i5 = i6 + 1;
            }
        }
        return stateListDrawable;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        AnimationDrawable animationDrawable = drawable;
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable2 = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable2.getNumberOfFrames();
            AnimationDrawable animationDrawable3 = new AnimationDrawable();
            animationDrawable3.setOneShot(animationDrawable2.isOneShot());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numberOfFrames) {
                    break;
                }
                Drawable tileify = tileify(animationDrawable2.getFrame(i2), true);
                tileify.setLevel(10000);
                animationDrawable3.addFrame(tileify, animationDrawable2.getDuration(i2));
                i = i2 + 1;
            }
            animationDrawable3.setLevel(10000);
            animationDrawable = animationDrawable3;
        }
        return animationDrawable;
    }

    private void updateDrawableBounds(int i, int i2) {
        int i3 = i - (this.mPaddingRight + this.mPaddingLeft);
        int i4 = i2 - (this.mPaddingTop + this.mPaddingBottom);
        int i5 = i4;
        int i6 = i3;
        if (this.mIndeterminateDrawable != null) {
            i5 = i4;
            int i7 = 0;
            int i8 = i3;
            int i9 = 0;
            if (this.mOnlyIndeterminate) {
                i5 = i4;
                i7 = 0;
                i8 = i3;
                i9 = 0;
                if (!(this.mIndeterminateDrawable instanceof AnimationDrawable)) {
                    float intrinsicWidth = this.mIndeterminateDrawable.getIntrinsicWidth() / this.mIndeterminateDrawable.getIntrinsicHeight();
                    float f = i3 / i4;
                    i5 = i4;
                    i7 = 0;
                    i8 = i3;
                    i9 = 0;
                    if (intrinsicWidth != f) {
                        if (f > intrinsicWidth) {
                            int i10 = (int) (i4 * intrinsicWidth);
                            i7 = (i3 - i10) / 2;
                            i8 = i7 + i10;
                            i9 = 0;
                            i5 = i4;
                        } else {
                            int i11 = (int) (i3 * (1.0f / intrinsicWidth));
                            i9 = (i4 - i11) / 2;
                            i5 = i9 + i11;
                            i7 = 0;
                            i8 = i3;
                        }
                    }
                }
            }
            int i12 = i7;
            int i13 = i8;
            if (isLayoutRtl()) {
                i12 = i7;
                i13 = i8;
                if (this.mMirrorForRtl) {
                    i12 = i3 - i8;
                    i13 = i3 - i7;
                }
            }
            this.mIndeterminateDrawable.setBounds(i12, i9, i13, i5);
            i6 = i13;
        }
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setBounds(0, 0, i6, i5);
        }
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        if (this.mProgressDrawable != null && this.mProgressDrawable.isStateful()) {
            this.mProgressDrawable.setState(drawableState);
        }
        if (this.mIndeterminateDrawable == null || !this.mIndeterminateDrawable.isStateful()) {
            return;
        }
        this.mIndeterminateDrawable.setState(drawableState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawTrack(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            int save = canvas.save();
            if (isLayoutRtl() && this.mMirrorForRtl) {
                canvas.translate(getWidth() - this.mPaddingRight, this.mPaddingTop);
                canvas.scale(-1.0f, 1.0f);
            } else {
                canvas.translate(this.mPaddingLeft, this.mPaddingTop);
            }
            long drawingTime = getDrawingTime();
            if (this.mHasAnimation) {
                this.mAnimation.getTransformation(drawingTime, this.mTransformation);
                float alpha = this.mTransformation.getAlpha();
                try {
                    this.mInDrawing = true;
                    drawable.setLevel((int) (10000.0f * alpha));
                    this.mInDrawing = false;
                    postInvalidateOnAnimation();
                } catch (Throwable th) {
                    this.mInDrawing = false;
                    throw th;
                }
            }
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            if (this.mShouldStartAnimationDrawable && (drawable instanceof Animatable)) {
                ((Animatable) drawable).start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setHotspot(f, f2);
        }
        if (this.mIndeterminateDrawable != null) {
            this.mIndeterminateDrawable.setHotspot(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }

    Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Drawable getIndeterminateDrawable() {
        return this.mIndeterminateDrawable;
    }

    public ColorStateList getIndeterminateTintList() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mIndeterminateTintList;
        }
        return null;
    }

    public PorterDuff.Mode getIndeterminateTintMode() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mIndeterminateTintMode;
        }
        return null;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public int getMax() {
        int i;
        synchronized (this) {
            i = this.mMax;
        }
        return i;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public int getProgress() {
        int i;
        synchronized (this) {
            i = this.mIndeterminate ? 0 : this.mProgress;
        }
        return i;
    }

    public ColorStateList getProgressBackgroundTintList() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mProgressBackgroundTintList;
        }
        return null;
    }

    public PorterDuff.Mode getProgressBackgroundTintMode() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mProgressBackgroundTintMode;
        }
        return null;
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    public ColorStateList getProgressTintList() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mProgressTintList;
        }
        return null;
    }

    public PorterDuff.Mode getProgressTintMode() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mProgressTintMode;
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public int getSecondaryProgress() {
        int i;
        synchronized (this) {
            i = this.mIndeterminate ? 0 : this.mSecondaryProgress;
        }
        return i;
    }

    public ColorStateList getSecondaryProgressTintList() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mSecondaryProgressTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSecondaryProgressTintMode() {
        if (this.mProgressTintInfo != null) {
            return this.mProgressTintInfo.mSecondaryProgressTintMode;
        }
        return null;
    }

    public final void incrementProgressBy(int i) {
        synchronized (this) {
            setProgress(this.mProgress + i);
        }
    }

    public final void incrementSecondaryProgressBy(int i) {
        synchronized (this) {
            setSecondaryProgress(this.mSecondaryProgress + i);
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.mInDrawing) {
            return;
        }
        if (!verifyDrawable(drawable)) {
            super.invalidateDrawable(drawable);
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = this.mScrollX + this.mPaddingLeft;
        int i2 = this.mScrollY + this.mPaddingTop;
        invalidate(bounds.left + i, bounds.top + i2, bounds.right + i, bounds.bottom + i2);
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public boolean isIndeterminate() {
        boolean z;
        synchronized (this) {
            z = this.mIndeterminate;
        }
        return z;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.jumpToCurrentState();
        }
        if (this.mIndeterminateDrawable != null) {
            this.mIndeterminateDrawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIndeterminate) {
            startAnimation();
        }
        if (this.mRefreshData != null) {
            synchronized (this) {
                int size = this.mRefreshData.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    RefreshData refreshData = this.mRefreshData.get(i2);
                    doRefreshProgress(refreshData.id, refreshData.progress, refreshData.fromUser, true);
                    refreshData.recycle();
                    i = i2 + 1;
                }
                this.mRefreshData.clear();
            }
        }
        this.mAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (this.mIndeterminate) {
            stopAnimation();
        }
        if (this.mRefreshProgressRunnable != null) {
            removeCallbacks(this.mRefreshProgressRunnable);
        }
        if (this.mRefreshProgressRunnable != null && this.mRefreshIsPosted) {
            removeCallbacks(this.mRefreshProgressRunnable);
        }
        if (this.mAccessibilityEventSender != null) {
            removeCallbacks(this.mAccessibilityEventSender);
        }
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            drawTrack(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ProgressBar.class.getName());
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressBar.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        synchronized (this) {
            Drawable drawable = this.mCurrentDrawable;
            int i3 = 0;
            int i4 = 0;
            if (drawable != null) {
                i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
                i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, drawable.getIntrinsicHeight()));
            }
            updateDrawableState();
            setMeasuredDimension(resolveSizeAndState(i3 + this.mPaddingLeft + this.mPaddingRight, i, 0), resolveSizeAndState(i4 + this.mPaddingTop + this.mPaddingBottom, i2, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProgressRefresh(float f, boolean z) {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            scheduleAccessibilityEventSender();
        }
    }

    @Override // android.view.View
    public void onResolveDrawables(int i) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.setLayoutDirection(i);
        }
        if (this.mIndeterminateDrawable != null) {
            this.mIndeterminateDrawable.setLayoutDirection(i);
        }
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setLayoutDirection(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
        setSecondaryProgress(savedState.secondaryProgress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        savedState.secondaryProgress = this.mSecondaryProgress;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateDrawableBounds(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mIndeterminate) {
            if (i == 8 || i == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (this.mNoInvalidate) {
            return;
        }
        super.postInvalidate();
    }

    @RemotableViewMethod
    public void setIndeterminate(boolean z) {
        synchronized (this) {
            if ((!this.mOnlyIndeterminate || !this.mIndeterminate) && z != this.mIndeterminate) {
                this.mIndeterminate = z;
                if (z) {
                    this.mCurrentDrawable = this.mIndeterminateDrawable;
                    startAnimation();
                } else {
                    this.mCurrentDrawable = this.mProgressDrawable;
                    stopAnimation();
                }
            }
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (this.mIndeterminateDrawable != drawable) {
            if (this.mIndeterminateDrawable != null) {
                this.mIndeterminateDrawable.setCallback(null);
                unscheduleDrawable(this.mIndeterminateDrawable);
            }
            this.mIndeterminateDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                drawable.setLayoutDirection(getLayoutDirection());
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                applyIndeterminateTint();
            }
            if (this.mIndeterminate) {
                this.mCurrentDrawable = drawable;
                postInvalidate();
            }
        }
    }

    public void setIndeterminateDrawableTiled(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (drawable != null) {
            drawable2 = tileifyIndeterminate(drawable);
        }
        setIndeterminateDrawable(drawable2);
    }

    @RemotableViewMethod
    public void setIndeterminateTintList(ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mIndeterminateTintList = colorStateList;
        this.mProgressTintInfo.mHasIndeterminateTint = true;
        applyIndeterminateTint();
    }

    public void setIndeterminateTintMode(PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mIndeterminateTintMode = mode;
        this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        applyIndeterminateTint();
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @RemotableViewMethod
    public void setMax(int i) {
        synchronized (this) {
            int i2 = i;
            if (i < 0) {
                i2 = 0;
            }
            if (i2 != this.mMax) {
                this.mMax = i2;
                postInvalidate();
                if (this.mProgress > i2) {
                    this.mProgress = i2;
                }
                refreshProgress(16908301, this.mProgress, false);
            }
        }
    }

    @RemotableViewMethod
    public void setProgress(int i) {
        synchronized (this) {
            setProgress(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RemotableViewMethod
    public void setProgress(int i, boolean z) {
        synchronized (this) {
            if (!this.mIndeterminate) {
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                int i3 = i2;
                if (i2 > this.mMax) {
                    i3 = this.mMax;
                }
                if (i3 != this.mProgress) {
                    this.mProgress = i3;
                    refreshProgress(16908301, this.mProgress, z);
                }
            }
        }
    }

    @RemotableViewMethod
    public void setProgressBackgroundTintList(ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mProgressBackgroundTintList = colorStateList;
        this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        if (this.mProgressDrawable != null) {
            applyProgressBackgroundTint();
        }
    }

    public void setProgressBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mProgressBackgroundTintMode = mode;
        this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        if (this.mProgressDrawable != null) {
            applyProgressBackgroundTint();
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (this.mProgressDrawable != drawable) {
            if (this.mProgressDrawable != null) {
                this.mProgressDrawable.setCallback(null);
                unscheduleDrawable(this.mProgressDrawable);
            }
            this.mProgressDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                drawable.setLayoutDirection(getLayoutDirection());
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (this.mMaxHeight < minimumHeight) {
                    this.mMaxHeight = minimumHeight;
                    requestLayout();
                }
                applyProgressTints();
            }
            if (!this.mIndeterminate) {
                this.mCurrentDrawable = drawable;
                postInvalidate();
            }
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(16908301, this.mProgress, false, false);
            doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
        }
    }

    public void setProgressDrawableTiled(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (drawable != null) {
            drawable2 = tileify(drawable, false);
        }
        setProgressDrawable(drawable2);
    }

    @RemotableViewMethod
    public void setProgressTintList(ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mProgressTintList = colorStateList;
        this.mProgressTintInfo.mHasProgressTint = true;
        if (this.mProgressDrawable != null) {
            applyPrimaryProgressTint();
        }
    }

    public void setProgressTintMode(PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mProgressTintMode = mode;
        this.mProgressTintInfo.mHasProgressTintMode = true;
        if (this.mProgressDrawable != null) {
            applyPrimaryProgressTint();
        }
    }

    @RemotableViewMethod
    public void setSecondaryProgress(int i) {
        synchronized (this) {
            if (!this.mIndeterminate) {
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                int i3 = i2;
                if (i2 > this.mMax) {
                    i3 = this.mMax;
                }
                if (i3 != this.mSecondaryProgress) {
                    this.mSecondaryProgress = i3;
                    refreshProgress(16908303, this.mSecondaryProgress, false);
                }
            }
        }
    }

    public void setSecondaryProgressTintList(ColorStateList colorStateList) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mSecondaryProgressTintList = colorStateList;
        this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        if (this.mProgressDrawable != null) {
            applySecondaryProgressTint();
        }
    }

    public void setSecondaryProgressTintMode(PorterDuff.Mode mode) {
        if (this.mProgressTintInfo == null) {
            this.mProgressTintInfo = new ProgressTintInfo();
        }
        this.mProgressTintInfo.mSecondaryProgressTintMode = mode;
        this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        if (this.mProgressDrawable != null) {
            applySecondaryProgressTint();
        }
    }

    @Override // android.view.View
    @RemotableViewMethod
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (this.mIndeterminate) {
                if (i == 8 || i == 4) {
                    stopAnimation();
                } else {
                    startAnimation();
                }
            }
        }
    }

    void startAnimation() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.mIndeterminateDrawable instanceof Animatable) {
            this.mShouldStartAnimationDrawable = true;
            this.mHasAnimation = false;
        } else {
            this.mHasAnimation = true;
            if (this.mInterpolator == null) {
                this.mInterpolator = new LinearInterpolator();
            }
            if (this.mTransformation == null) {
                this.mTransformation = new Transformation();
            } else {
                this.mTransformation.clear();
            }
            if (this.mAnimation == null) {
                this.mAnimation = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.mAnimation.reset();
            }
            this.mAnimation.setRepeatMode(this.mBehavior);
            this.mAnimation.setRepeatCount(-1);
            this.mAnimation.setDuration(this.mDuration);
            this.mAnimation.setInterpolator(this.mInterpolator);
            this.mAnimation.setStartTime(-1L);
        }
        postInvalidate();
    }

    void stopAnimation() {
        this.mHasAnimation = false;
        if (this.mIndeterminateDrawable instanceof Animatable) {
            ((Animatable) this.mIndeterminateDrawable).stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mProgressDrawable || drawable == this.mIndeterminateDrawable || super.verifyDrawable(drawable);
    }
}
