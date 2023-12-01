package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.android.internal.R;
import dalvik.system.CloseGuard;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/Animation.class */
public abstract class Animation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    private static final boolean USE_CLOSEGUARD = SystemProperties.getBoolean("log.closeguard.Animation", false);
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    long mDuration;
    Interpolator mInterpolator;
    AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnRepeat;
    private Runnable mOnStart;
    long mStartOffset;
    private int mZAdjustment;
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    Transformation mTransformation = new Transformation();
    Transformation mPreviousTransformation = new Transformation();
    private final CloseGuard guard = CloseGuard.get();

    /* loaded from: source-4181928-dex2jar.jar:android/view/animation/Animation$AnimationListener.class */
    public interface AnimationListener {
        void onAnimationEnd(Animation animation);

        void onAnimationRepeat(Animation animation);

        void onAnimationStart(Animation animation);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/animation/Animation$Description.class */
    protected static class Description {
        public int type;
        public float value;

        protected Description() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Description parseValue(TypedValue typedValue) {
            int i = 1;
            Description description = new Description();
            if (typedValue == null) {
                description.type = 0;
                description.value = 0.0f;
            } else if (typedValue.type == 6) {
                if ((typedValue.data & 15) == 1) {
                    i = 2;
                }
                description.type = i;
                description.value = TypedValue.complexToFloat(typedValue.data);
                return description;
            } else if (typedValue.type == 4) {
                description.type = 0;
                description.value = typedValue.getFloat();
                return description;
            } else if (typedValue.type >= 16 && typedValue.type <= 31) {
                description.type = 0;
                description.value = typedValue.data;
                return description;
            }
            description.type = 0;
            description.value = 0.0f;
            return description;
        }
    }

    public Animation() {
        ensureInterpolator();
    }

    public Animation(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Animation);
        setDuration(obtainStyledAttributes.getInt(2, 0));
        setStartOffset(obtainStyledAttributes.getInt(5, 0));
        setFillEnabled(obtainStyledAttributes.getBoolean(9, this.mFillEnabled));
        setFillBefore(obtainStyledAttributes.getBoolean(3, this.mFillBefore));
        setFillAfter(obtainStyledAttributes.getBoolean(4, this.mFillAfter));
        setRepeatCount(obtainStyledAttributes.getInt(6, this.mRepeatCount));
        setRepeatMode(obtainStyledAttributes.getInt(7, 1));
        setZAdjustment(obtainStyledAttributes.getInt(8, 0));
        setBackgroundColor(obtainStyledAttributes.getInt(0, 0));
        setDetachWallpaper(obtainStyledAttributes.getBoolean(10, false));
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId > 0) {
            setInterpolator(context, resourceId);
        }
        ensureInterpolator();
    }

    private void fireAnimationEnd() {
        if (this.mListener != null) {
            if (this.mListenerHandler == null) {
                this.mListener.onAnimationEnd(this);
            } else {
                this.mListenerHandler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
        if (this.mListener != null) {
            if (this.mListenerHandler == null) {
                this.mListener.onAnimationRepeat(this);
            } else {
                this.mListenerHandler.postAtFrontOfQueue(this.mOnRepeat);
            }
        }
    }

    private void fireAnimationStart() {
        if (this.mListener != null) {
            if (this.mListenerHandler == null) {
                this.mListener.onAnimationStart(this);
            } else {
                this.mListenerHandler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
            this.guard.close();
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // 
    /* renamed from: clone */
    public Animation mo39clone() throws CloneNotSupportedException {
        Animation animation = (Animation) super.clone();
        animation.mPreviousRegion = new RectF();
        animation.mRegion = new RectF();
        animation.mTransformation = new Transformation();
        animation.mPreviousTransformation = new Transformation();
        return animation;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        this.guard.close();
        fireAnimationEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
        } finally {
            super.finalize();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void getInvalidateRegion(int i, int i2, int i3, int i4, RectF rectF, Transformation transformation) {
        RectF rectF2 = this.mRegion;
        RectF rectF3 = this.mPreviousRegion;
        rectF.set(i, i2, i3, i4);
        transformation.getMatrix().mapRect(rectF);
        rectF.inset(-1.0f, -1.0f);
        rectF2.set(rectF);
        rectF.union(rectF3);
        rectF3.set(rectF2);
        Transformation transformation2 = this.mTransformation;
        Transformation transformation3 = this.mPreviousTransformation;
        transformation2.set(transformation);
        transformation.set(transformation3);
        transformation3.set(transformation2);
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j, Transformation transformation) {
        if (this.mStartTime == -1) {
            this.mStartTime = j;
        }
        long startOffset = getStartOffset();
        long j2 = this.mDuration;
        float f = j2 != 0 ? ((float) (j - (this.mStartTime + startOffset))) / ((float) j2) : j < this.mStartTime ? 0.0f : 1.0f;
        boolean z = f >= 1.0f;
        this.mMore = !z;
        float f2 = f;
        if (!this.mFillEnabled) {
            f2 = Math.max(Math.min(f, 1.0f), 0.0f);
        }
        if ((f2 >= 0.0f || this.mFillBefore) && (f2 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                fireAnimationStart();
                this.mStarted = true;
                if (USE_CLOSEGUARD) {
                    this.guard.open("cancel or detach or getTransformation");
                }
            }
            float f3 = f2;
            if (this.mFillEnabled) {
                f3 = Math.max(Math.min(f2, 1.0f), 0.0f);
            }
            float f4 = f3;
            if (this.mCycleFlip) {
                f4 = 1.0f - f3;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f4), transformation);
        }
        if (z) {
            if (this.mRepeatCount != this.mRepeated) {
                if (this.mRepeatCount > 0) {
                    this.mRepeated++;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                this.guard.close();
                fireAnimationEnd();
            }
        }
        if (this.mMore || !this.mOneMoreTime) {
            return this.mMore;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.mScaleFactor = f;
        return getTransformation(j, transformation);
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize(int i, int i2, int i3, int i4) {
        reset();
        this.mInitialized = true;
    }

    public void initializeInvalidateRegion(int i, int i2, int i3, int i4) {
        RectF rectF = this.mPreviousRegion;
        rectF.set(i, i2, i3, i4);
        rectF.inset(-1.0f, -1.0f);
        if (this.mFillBefore) {
            applyTransformation(this.mInterpolator.getInterpolation(0.0f), this.mPreviousTransformation);
        }
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float resolveSize(int i, float f, int i2, int i3) {
        switch (i) {
            case 0:
            default:
                return f;
            case 1:
                return f * i2;
            case 2:
                return f * i3;
        }
    }

    public void restrictDuration(long j) {
        if (this.mStartOffset > j) {
            this.mStartOffset = j;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j2 = this.mDuration + this.mStartOffset;
        long j3 = j2;
        if (j2 > j) {
            this.mDuration = j - this.mStartOffset;
            j3 = j;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
        } else if (this.mRepeatCount < 0 || this.mRepeatCount > j || this.mRepeatCount * j3 > j) {
            this.mRepeatCount = ((int) (j / j3)) - 1;
            if (this.mRepeatCount < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f) {
        this.mDuration = ((float) this.mDuration) * f;
        this.mStartOffset = ((float) this.mStartOffset) * f;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setDetachWallpaper(boolean z) {
        this.mDetachWallpaper = z;
    }

    public void setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
        this.mDuration = j;
    }

    public void setFillAfter(boolean z) {
        this.mFillAfter = z;
    }

    public void setFillBefore(boolean z) {
        this.mFillBefore = z;
    }

    public void setFillEnabled(boolean z) {
        this.mFillEnabled = z;
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setListenerHandler(Handler handler) {
        if (this.mListenerHandler == null) {
            this.mOnStart = new Runnable() { // from class: android.view.animation.Animation.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Animation.this.mListener != null) {
                        Animation.this.mListener.onAnimationStart(Animation.this);
                    }
                }
            };
            this.mOnRepeat = new Runnable() { // from class: android.view.animation.Animation.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Animation.this.mListener != null) {
                        Animation.this.mListener.onAnimationRepeat(Animation.this);
                    }
                }
            };
            this.mOnEnd = new Runnable() { // from class: android.view.animation.Animation.3
                @Override // java.lang.Runnable
                public void run() {
                    if (Animation.this.mListener != null) {
                        Animation.this.mListener.onAnimationEnd(Animation.this);
                    }
                }
            };
        }
        this.mListenerHandler = handler;
    }

    public void setRepeatCount(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = -1;
        }
        this.mRepeatCount = i2;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public void setStartOffset(long j) {
        this.mStartOffset = j;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i) {
        this.mZAdjustment = i;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }
}
