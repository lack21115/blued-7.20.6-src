package android.animation;

import android.animation.Animator;
import android.os.Looper;
import android.os.Trace;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/animation/ValueAnimator.class */
public class ValueAnimator extends Animator {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private long mDelayStartTime;
    private long mPauseTime;
    private boolean mReversing;
    long mStartTime;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;
    private static float sDurationScale = 1.0f;
    protected static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<>();
    private static final TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    float mSeekFraction = -1.0f;
    private boolean mResumed = false;
    private boolean mPlayingBackwards = false;
    private int mCurrentIteration = 0;
    private float mCurrentFraction = 0.0f;
    private boolean mStartedDelay = false;
    int mPlayingState = 0;
    private boolean mRunning = false;
    private boolean mStarted = false;
    private boolean mStartListenersCalled = false;
    boolean mInitialized = false;
    private long mDuration = 300.0f * sDurationScale;
    private long mUnscaledDuration = 300;
    private long mStartDelay = 0;
    private long mUnscaledStartDelay = 0;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    ArrayList<AnimatorUpdateListener> mUpdateListeners = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/ValueAnimator$AnimationHandler.class */
    public static class AnimationHandler implements Runnable {
        private boolean mAnimationScheduled;
        protected final ArrayList<ValueAnimator> mAnimations;
        private final Choreographer mChoreographer;
        protected final ArrayList<ValueAnimator> mDelayedAnims;
        private final ArrayList<ValueAnimator> mEndingAnims;
        protected final ArrayList<ValueAnimator> mPendingAnimations;
        private final ArrayList<ValueAnimator> mReadyAnims;
        private final ArrayList<ValueAnimator> mTmpAnimations;

        private AnimationHandler() {
            this.mAnimations = new ArrayList<>();
            this.mTmpAnimations = new ArrayList<>();
            this.mPendingAnimations = new ArrayList<>();
            this.mDelayedAnims = new ArrayList<>();
            this.mEndingAnims = new ArrayList<>();
            this.mReadyAnims = new ArrayList<>();
            this.mChoreographer = Choreographer.getInstance();
        }

        private void doAnimationFrame(long j) {
            while (this.mPendingAnimations.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
                this.mPendingAnimations.clear();
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList.get(i2);
                        if (valueAnimator.mStartDelay == 0) {
                            valueAnimator.startAnimation(this);
                        } else {
                            this.mDelayedAnims.add(valueAnimator);
                        }
                        i = i2 + 1;
                    }
                }
            }
            int size2 = this.mDelayedAnims.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                ValueAnimator valueAnimator2 = this.mDelayedAnims.get(i4);
                if (valueAnimator2.delayedAnimationFrame(j)) {
                    this.mReadyAnims.add(valueAnimator2);
                }
                i3 = i4 + 1;
            }
            int size3 = this.mReadyAnims.size();
            if (size3 > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size3) {
                        break;
                    }
                    ValueAnimator valueAnimator3 = this.mReadyAnims.get(i6);
                    valueAnimator3.startAnimation(this);
                    valueAnimator3.mRunning = true;
                    this.mDelayedAnims.remove(valueAnimator3);
                    i5 = i6 + 1;
                }
                this.mReadyAnims.clear();
            }
            int size4 = this.mAnimations.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size4) {
                    break;
                }
                this.mTmpAnimations.add(this.mAnimations.get(i8));
                i7 = i8 + 1;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= size4) {
                    break;
                }
                ValueAnimator valueAnimator4 = this.mTmpAnimations.get(i10);
                if (this.mAnimations.contains(valueAnimator4) && valueAnimator4.doAnimationFrame(j)) {
                    this.mEndingAnims.add(valueAnimator4);
                }
                i9 = i10 + 1;
            }
            this.mTmpAnimations.clear();
            if (this.mEndingAnims.size() > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 >= this.mEndingAnims.size()) {
                        break;
                    }
                    this.mEndingAnims.get(i12).endAnimation(this);
                    i11 = i12 + 1;
                }
                this.mEndingAnims.clear();
            }
            if (this.mAnimations.isEmpty() && this.mDelayedAnims.isEmpty()) {
                return;
            }
            scheduleAnimation();
        }

        private void scheduleAnimation() {
            if (this.mAnimationScheduled) {
                return;
            }
            this.mChoreographer.postCallback(1, this, null);
            this.mAnimationScheduled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mAnimationScheduled = false;
            doAnimationFrame(this.mChoreographer.getFrameTime());
        }

        public void start() {
            scheduleAnimation();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/ValueAnimator$AnimatorUpdateListener.class */
    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static void clearAllAnimations() {
        AnimationHandler animationHandler = sAnimationHandler.get();
        if (animationHandler != null) {
            animationHandler.mAnimations.clear();
            animationHandler.mPendingAnimations.clear();
            animationHandler.mDelayedAnims.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delayedAnimationFrame(long j) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j;
        }
        if (this.mPaused) {
            if (this.mPauseTime < 0) {
                this.mPauseTime = j;
                return false;
            }
            return false;
        }
        if (this.mResumed) {
            this.mResumed = false;
            if (this.mPauseTime > 0) {
                this.mDelayStartTime += j - this.mPauseTime;
            }
        }
        long j2 = j - this.mDelayStartTime;
        if (j2 > this.mStartDelay) {
            this.mStartTime = j - (j2 - this.mStartDelay);
            this.mPlayingState = 1;
            return true;
        }
        return false;
    }

    public static int getCurrentAnimationsCount() {
        AnimationHandler animationHandler = sAnimationHandler.get();
        if (animationHandler != null) {
            return animationHandler.mAnimations.size();
        }
        return 0;
    }

    public static float getDurationScale() {
        return sDurationScale;
    }

    public static long getFrameDelay() {
        return Choreographer.getFrameDelay();
    }

    private static AnimationHandler getOrCreateAnimationHandler() {
        AnimationHandler animationHandler = sAnimationHandler.get();
        AnimationHandler animationHandler2 = animationHandler;
        if (animationHandler == null) {
            animationHandler2 = new AnimationHandler();
            sAnimationHandler.set(animationHandler2);
        }
        return animationHandler2;
    }

    private void notifyStartListeners() {
        if (this.mListeners != null && !this.mStartListenersCalled) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ((Animator.AnimatorListener) arrayList.get(i2)).onAnimationStart(this);
                i = i2 + 1;
            }
        }
        this.mStartListenersCalled = true;
    }

    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(ArgbEvaluator.getInstance());
        return valueAnimator;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setDurationScale(float f) {
        sDurationScale = f;
    }

    public static void setFrameDelay(long j) {
        Choreographer.setFrameDelay(j);
    }

    private void start(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mReversing = z;
        this.mPlayingBackwards = z;
        if (z && this.mSeekFraction != -1.0f) {
            if (this.mSeekFraction == 0.0f && this.mCurrentIteration == 0) {
                this.mSeekFraction = 0.0f;
            } else if (this.mRepeatCount == -1) {
                this.mSeekFraction = 1.0f - (this.mSeekFraction % 1.0f);
            } else {
                this.mSeekFraction = (this.mRepeatCount + 1) - (this.mCurrentIteration + this.mSeekFraction);
            }
            this.mCurrentIteration = (int) this.mSeekFraction;
            this.mSeekFraction %= 1.0f;
        }
        if (this.mCurrentIteration > 0 && this.mRepeatMode == 2 && (this.mCurrentIteration < this.mRepeatCount + 1 || this.mRepeatCount == -1)) {
            if (z) {
                this.mPlayingBackwards = this.mCurrentIteration % 2 == 0;
            } else {
                this.mPlayingBackwards = this.mCurrentIteration % 2 != 0;
            }
        }
        int i = this.mPlayingState;
        this.mPlayingState = 0;
        this.mStarted = true;
        this.mStartedDelay = false;
        this.mPaused = false;
        updateScaledDuration();
        AnimationHandler orCreateAnimationHandler = getOrCreateAnimationHandler();
        orCreateAnimationHandler.mPendingAnimations.add(this);
        if (this.mStartDelay == 0) {
            if (i != 2) {
                setCurrentPlayTime(0L);
            }
            this.mPlayingState = 0;
            this.mRunning = true;
            notifyStartListeners();
        }
        orCreateAnimationHandler.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation(AnimationHandler animationHandler) {
        if (Trace.isTagEnabled(8L)) {
            Trace.asyncTraceBegin(8L, getNameForTrace(), System.identityHashCode(this));
        }
        initAnimation();
        animationHandler.mAnimations.add(this);
        if (this.mStartDelay <= 0 || this.mListeners == null) {
            return;
        }
        notifyStartListeners();
    }

    private void updateScaledDuration() {
        this.mDuration = ((float) this.mUnscaledDuration) * sDurationScale;
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void animateValue(float f) {
        float interpolation = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = interpolation;
        int length = this.mValues.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.mValues[i2].calculateValue(interpolation);
            i = i2 + 1;
        }
        if (this.mUpdateListeners == null) {
            return;
        }
        int size = this.mUpdateListeners.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            this.mUpdateListeners.get(i4).onAnimationUpdate(this);
            i3 = i4 + 1;
        }
    }

    boolean animationFrame(long j) {
        switch (this.mPlayingState) {
            case 1:
            case 2:
                float f = this.mDuration > 0 ? ((float) (j - this.mStartTime)) / ((float) this.mDuration) : 1.0f;
                if (this.mDuration == 0 && this.mRepeatCount != -1) {
                    this.mCurrentIteration = this.mRepeatCount;
                    if (!this.mReversing) {
                        this.mPlayingBackwards = false;
                    }
                }
                boolean z = false;
                float f2 = f;
                if (f >= 1.0f) {
                    if (this.mCurrentIteration < this.mRepeatCount || this.mRepeatCount == -1) {
                        if (this.mListeners != null) {
                            int size = this.mListeners.size();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < size) {
                                    this.mListeners.get(i2).onAnimationRepeat(this);
                                    i = i2 + 1;
                                }
                            }
                        }
                        if (this.mRepeatMode == 2) {
                            this.mPlayingBackwards = !this.mPlayingBackwards;
                        }
                        this.mCurrentIteration += (int) f;
                        f2 = f % 1.0f;
                        this.mStartTime += this.mDuration;
                        z = false;
                    } else {
                        z = true;
                        f2 = Math.min(f, 1.0f);
                    }
                }
                float f3 = f2;
                if (this.mPlayingBackwards) {
                    f3 = 1.0f - f2;
                }
                animateValue(f3);
                return z;
            default:
                return false;
        }
    }

    @Override // android.animation.Animator
    public boolean canReverse() {
        return true;
    }

    @Override // android.animation.Animator
    public void cancel() {
        AnimationHandler orCreateAnimationHandler = getOrCreateAnimationHandler();
        if (this.mPlayingState != 0 || orCreateAnimationHandler.mPendingAnimations.contains(this) || orCreateAnimationHandler.mDelayedAnims.contains(this)) {
            if ((this.mStarted || this.mRunning) && this.mListeners != null) {
                if (!this.mRunning) {
                    notifyStartListeners();
                }
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation(orCreateAnimationHandler);
        }
    }

    @Override // android.animation.Animator
    /* renamed from: clone */
    public ValueAnimator mo53clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.mo53clone();
        if (this.mUpdateListeners != null) {
            valueAnimator.mUpdateListeners = new ArrayList<>(this.mUpdateListeners);
        }
        valueAnimator.mSeekFraction = -1.0f;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mReversing = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap<>(length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                PropertyValuesHolder mo64clone = propertyValuesHolderArr[i2].mo64clone();
                valueAnimator.mValues[i2] = mo64clone;
                valueAnimator.mValuesMap.put(mo64clone.getPropertyName(), mo64clone);
                i = i2 + 1;
            }
        }
        return valueAnimator;
    }

    final boolean doAnimationFrame(long j) {
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            if (this.mSeekFraction < 0.0f) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - (((float) this.mDuration) * this.mSeekFraction);
                this.mSeekFraction = -1.0f;
            }
        }
        if (this.mPaused) {
            if (this.mPauseTime < 0) {
                this.mPauseTime = j;
                return false;
            }
            return false;
        }
        if (this.mResumed) {
            this.mResumed = false;
            if (this.mPauseTime > 0) {
                this.mStartTime += j - this.mPauseTime;
            }
        }
        return animationFrame(Math.max(j, this.mStartTime));
    }

    @Override // android.animation.Animator
    public void end() {
        AnimationHandler orCreateAnimationHandler = getOrCreateAnimationHandler();
        if (!orCreateAnimationHandler.mAnimations.contains(this) && !orCreateAnimationHandler.mPendingAnimations.contains(this)) {
            this.mStartedDelay = false;
            startAnimation(orCreateAnimationHandler);
            this.mStarted = true;
        } else if (!this.mInitialized) {
            initAnimation();
        }
        animateValue(this.mPlayingBackwards ? 0.0f : 1.0f);
        endAnimation(orCreateAnimationHandler);
    }

    protected void endAnimation(AnimationHandler animationHandler) {
        animationHandler.mAnimations.remove(this);
        animationHandler.mPendingAnimations.remove(this);
        animationHandler.mDelayedAnims.remove(this);
        this.mPlayingState = 0;
        this.mPaused = false;
        if ((this.mStarted || this.mRunning) && this.mListeners != null) {
            if (!this.mRunning) {
                notifyStartListeners();
            }
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ((Animator.AnimatorListener) arrayList.get(i2)).onAnimationEnd(this);
                i = i2 + 1;
            }
        }
        this.mRunning = false;
        this.mStarted = false;
        this.mStartListenersCalled = false;
        this.mPlayingBackwards = false;
        this.mReversing = false;
        this.mCurrentIteration = 0;
        if (Trace.isTagEnabled(8L)) {
            Trace.asyncTraceEnd(8L, getNameForTrace(), System.identityHashCode(this));
        }
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        if (this.mValues == null || this.mValues.length <= 0) {
            return null;
        }
        return this.mValues[0].getAnimatedValue();
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }

    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    @Override // android.animation.Animator
    public long getDuration() {
        return this.mUnscaledDuration;
    }

    @Override // android.animation.Animator
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    String getNameForTrace() {
        return "animator";
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    @Override // android.animation.Animator
    public long getStartDelay() {
        return this.mUnscaledStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initAnimation() {
        if (this.mInitialized) {
            return;
        }
        int length = this.mValues.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mInitialized = true;
                return;
            } else {
                this.mValues[i2].init();
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.Animator
    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }

    @Override // android.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // android.animation.Animator
    public void pause() {
        boolean z = this.mPaused;
        super.pause();
        if (z || !this.mPaused) {
            return;
        }
        this.mPauseTime = -1L;
        this.mResumed = false;
    }

    public void removeAllUpdateListeners() {
        if (this.mUpdateListeners == null) {
            return;
        }
        this.mUpdateListeners.clear();
        this.mUpdateListeners = null;
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            return;
        }
        this.mUpdateListeners.remove(animatorUpdateListener);
        if (this.mUpdateListeners.size() == 0) {
            this.mUpdateListeners = null;
        }
    }

    @Override // android.animation.Animator
    public void resume() {
        if (this.mPaused) {
            this.mResumed = true;
        }
        super.resume();
    }

    @Override // android.animation.Animator
    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            this.mReversing = !this.mReversing;
        } else if (this.mStarted) {
            end();
        } else {
            start(true);
        }
    }

    @Override // android.animation.Animator
    public void setAllowRunningAsynchronously(boolean z) {
    }

    public void setCurrentFraction(float f) {
        float f2;
        initAnimation();
        float f3 = f;
        if (f < 0.0f) {
            f3 = 0.0f;
        }
        int i = (int) f3;
        if (f3 == 1.0f) {
            i--;
            f2 = f3;
        } else if (f3 <= 1.0f) {
            this.mPlayingBackwards = this.mReversing;
            f2 = f3;
        } else if (i < this.mRepeatCount + 1 || this.mRepeatCount == -1) {
            if (this.mRepeatMode == 2) {
                this.mPlayingBackwards = i % 2 != 0;
            }
            f2 = f3 % 1.0f;
        } else {
            f2 = 1.0f;
            i--;
        }
        this.mCurrentIteration = i;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis() - (((float) this.mDuration) * f2);
        if (this.mPlayingState != 1) {
            this.mSeekFraction = f2;
            this.mPlayingState = 2;
        }
        float f4 = f2;
        if (this.mPlayingBackwards) {
            f4 = 1.0f - f2;
        }
        animateValue(f4);
    }

    public void setCurrentPlayTime(long j) {
        setCurrentFraction(this.mUnscaledDuration > 0 ? ((float) j) / ((float) this.mUnscaledDuration) : 1.0f);
    }

    @Override // android.animation.Animator
    public ValueAnimator setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mUnscaledDuration = j;
        updateScaledDuration();
        return this;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        if (typeEvaluator == null || this.mValues == null || this.mValues.length <= 0) {
            return;
        }
        this.mValues[0].setEvaluator(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofFloat("", fArr));
        } else {
            this.mValues[0].setFloatValues(fArr);
        }
        this.mInitialized = false;
    }

    public void setIntValues(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofInt("", iArr));
        } else {
            this.mValues[0].setIntValues(iArr);
        }
        this.mInitialized = false;
    }

    @Override // android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            this.mInterpolator = timeInterpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
        } else {
            this.mValues[0].setObjectValues(objArr);
        }
        this.mInitialized = false;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    @Override // android.animation.Animator
    public void setStartDelay(long j) {
        this.mStartDelay = ((float) j) * sDurationScale;
        this.mUnscaledStartDelay = j;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        int length = propertyValuesHolderArr.length;
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap<>(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mInitialized = false;
                return;
            }
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[i2];
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
            i = i2 + 1;
        }
    }

    @Override // android.animation.Animator
    public void start() {
        start(false);
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        String str2 = str;
        if (this.mValues != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                str2 = str;
                if (i2 >= this.mValues.length) {
                    break;
                }
                str = str + "\n    " + this.mValues[i2].toString();
                i = i2 + 1;
            }
        }
        return str2;
    }
}
