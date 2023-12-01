package android.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.CanvasProperty;
import android.graphics.Paint;
import android.util.SparseIntArray;
import com.android.internal.util.VirtualRefBasePtr;
import com.android.internal.view.animation.FallbackLUTInterpolator;
import com.android.internal.view.animation.HasNativeInterpolator;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/view/RenderNodeAnimator.class */
public class RenderNodeAnimator extends Animator {
    public static final int ALPHA = 11;
    public static final int LAST_VALUE = 11;
    public static final int PAINT_ALPHA = 1;
    public static final int PAINT_STROKE_WIDTH = 0;
    public static final int ROTATION = 5;
    public static final int ROTATION_X = 6;
    public static final int ROTATION_Y = 7;
    public static final int SCALE_X = 3;
    public static final int SCALE_Y = 4;
    private static final int STATE_DELAYED = 1;
    private static final int STATE_FINISHED = 3;
    private static final int STATE_PREPARE = 0;
    private static final int STATE_RUNNING = 2;
    public static final int TRANSLATION_X = 0;
    public static final int TRANSLATION_Y = 1;
    public static final int TRANSLATION_Z = 2;
    public static final int X = 8;
    public static final int Y = 9;
    public static final int Z = 10;
    private float mFinalValue;
    private TimeInterpolator mInterpolator;
    private VirtualRefBasePtr mNativePtr;
    private int mRenderProperty;
    private long mStartDelay;
    private long mStartTime;
    private int mState;
    private RenderNode mTarget;
    private final boolean mUiThreadHandlesDelay;
    private long mUnscaledDuration;
    private long mUnscaledStartDelay;
    private View mViewTarget;
    private static final SparseIntArray sViewPropertyAnimatorMap = new SparseIntArray(15) { // from class: android.view.RenderNodeAnimator.1
        {
            put(1, 0);
            put(2, 1);
            put(4, 2);
            put(8, 3);
            put(16, 4);
            put(32, 5);
            put(64, 6);
            put(128, 7);
            put(256, 8);
            put(512, 9);
            put(1024, 10);
            put(2048, 11);
        }
    };
    private static ThreadLocal<DelayedAnimationHelper> sAnimationHelper = new ThreadLocal<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/RenderNodeAnimator$DelayedAnimationHelper.class */
    public static class DelayedAnimationHelper implements Runnable {
        private boolean mCallbackScheduled;
        private ArrayList<RenderNodeAnimator> mDelayedAnims = new ArrayList<>();
        private final Choreographer mChoreographer = Choreographer.getInstance();

        private void scheduleCallback() {
            if (this.mCallbackScheduled) {
                return;
            }
            this.mCallbackScheduled = true;
            this.mChoreographer.postCallback(1, this, null);
        }

        public void addDelayedAnimation(RenderNodeAnimator renderNodeAnimator) {
            this.mDelayedAnims.add(renderNodeAnimator);
            scheduleCallback();
        }

        public void removeDelayedAnimation(RenderNodeAnimator renderNodeAnimator) {
            this.mDelayedAnims.remove(renderNodeAnimator);
        }

        @Override // java.lang.Runnable
        public void run() {
            long frameTime = this.mChoreographer.getFrameTime();
            this.mCallbackScheduled = false;
            int i = 0;
            int i2 = 0;
            while (i2 < this.mDelayedAnims.size()) {
                RenderNodeAnimator renderNodeAnimator = this.mDelayedAnims.get(i2);
                int i3 = i;
                if (!renderNodeAnimator.processDelayed(frameTime)) {
                    if (i != i2) {
                        this.mDelayedAnims.set(i, renderNodeAnimator);
                    }
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
            while (this.mDelayedAnims.size() > i) {
                this.mDelayedAnims.remove(this.mDelayedAnims.size() - 1);
            }
            if (this.mDelayedAnims.size() > 0) {
                scheduleCallback();
            }
        }
    }

    public RenderNodeAnimator(int i, float f) {
        this.mRenderProperty = -1;
        this.mState = 0;
        this.mUnscaledDuration = 300L;
        this.mUnscaledStartDelay = 0L;
        this.mStartDelay = 0L;
        this.mRenderProperty = i;
        this.mFinalValue = f;
        this.mUiThreadHandlesDelay = true;
        init(nCreateAnimator(i, f));
    }

    public RenderNodeAnimator(int i, int i2, float f, float f2) {
        this.mRenderProperty = -1;
        this.mState = 0;
        this.mUnscaledDuration = 300L;
        this.mUnscaledStartDelay = 0L;
        this.mStartDelay = 0L;
        init(nCreateRevealAnimator(i, i2, f, f2));
        this.mUiThreadHandlesDelay = true;
    }

    public RenderNodeAnimator(CanvasProperty<Float> canvasProperty, float f) {
        this.mRenderProperty = -1;
        this.mState = 0;
        this.mUnscaledDuration = 300L;
        this.mUnscaledStartDelay = 0L;
        this.mStartDelay = 0L;
        init(nCreateCanvasPropertyFloatAnimator(canvasProperty.getNativeContainer(), f));
        this.mUiThreadHandlesDelay = false;
    }

    public RenderNodeAnimator(CanvasProperty<Paint> canvasProperty, int i, float f) {
        this.mRenderProperty = -1;
        this.mState = 0;
        this.mUnscaledDuration = 300L;
        this.mUnscaledStartDelay = 0L;
        this.mStartDelay = 0L;
        init(nCreateCanvasPropertyPaintAnimator(canvasProperty.getNativeContainer(), i, f));
        this.mUiThreadHandlesDelay = false;
    }

    private void applyInterpolator() {
        long createNativeInterpolator;
        if (this.mInterpolator == null) {
            return;
        }
        if (isNativeInterpolator(this.mInterpolator)) {
            createNativeInterpolator = this.mInterpolator.createNativeInterpolator();
        } else {
            createNativeInterpolator = FallbackLUTInterpolator.createNativeInterpolator(this.mInterpolator, nGetDuration(this.mNativePtr.get()));
        }
        nSetInterpolator(this.mNativePtr.get(), createNativeInterpolator);
    }

    private static void callOnFinished(RenderNodeAnimator renderNodeAnimator) {
        renderNodeAnimator.onFinished();
    }

    private void checkMutable() {
        if (this.mState != 0) {
            throw new IllegalStateException("Animator has already started, cannot change it now!");
        }
        if (this.mNativePtr == null) {
            throw new IllegalStateException("Animator's target has been destroyed (trying to modify an animation after activity destroy?)");
        }
    }

    private ArrayList<Animator.AnimatorListener> cloneListeners() {
        ArrayList<Animator.AnimatorListener> listeners = getListeners();
        ArrayList<Animator.AnimatorListener> arrayList = listeners;
        if (listeners != null) {
            arrayList = (ArrayList) listeners.clone();
        }
        return arrayList;
    }

    private void doStart() {
        if (this.mRenderProperty == 11) {
            this.mViewTarget.mTransformationInfo.mAlpha = this.mFinalValue;
        }
        moveToRunningState();
        if (this.mViewTarget != null) {
            this.mViewTarget.invalidateViewProperty(true, false);
        }
    }

    private static DelayedAnimationHelper getHelper() {
        DelayedAnimationHelper delayedAnimationHelper = sAnimationHelper.get();
        DelayedAnimationHelper delayedAnimationHelper2 = delayedAnimationHelper;
        if (delayedAnimationHelper == null) {
            delayedAnimationHelper2 = new DelayedAnimationHelper();
            sAnimationHelper.set(delayedAnimationHelper2);
        }
        return delayedAnimationHelper2;
    }

    private void init(long j) {
        this.mNativePtr = new VirtualRefBasePtr(j);
    }

    static boolean isNativeInterpolator(TimeInterpolator timeInterpolator) {
        return timeInterpolator.getClass().isAnnotationPresent(HasNativeInterpolator.class);
    }

    public static int mapViewPropertyToRenderProperty(int i) {
        return sViewPropertyAnimatorMap.get(i);
    }

    private void moveToRunningState() {
        this.mState = 2;
        if (this.mNativePtr != null) {
            nStart(this.mNativePtr.get());
        }
        notifyStartListeners();
    }

    private static native long nCreateAnimator(int i, float f);

    private static native long nCreateCanvasPropertyFloatAnimator(long j, float f);

    private static native long nCreateCanvasPropertyPaintAnimator(long j, int i, float f);

    private static native long nCreateRevealAnimator(int i, int i2, float f, float f2);

    private static native void nEnd(long j);

    private static native long nGetDuration(long j);

    private static native void nSetAllowRunningAsync(long j, boolean z);

    private static native void nSetDuration(long j, long j2);

    private static native void nSetInterpolator(long j, long j2);

    private static native void nSetListener(long j, RenderNodeAnimator renderNodeAnimator);

    private static native void nSetStartDelay(long j, long j2);

    private static native void nSetStartValue(long j, float f);

    private static native void nStart(long j);

    private void notifyStartListeners() {
        ArrayList<Animator.AnimatorListener> cloneListeners = cloneListeners();
        int size = cloneListeners == null ? 0 : cloneListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            cloneListeners.get(i2).onAnimationStart(this);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processDelayed(long j) {
        if (this.mStartTime == 0) {
            this.mStartTime = j;
            return false;
        } else if (j - this.mStartTime >= this.mStartDelay) {
            doStart();
            return true;
        } else {
            return false;
        }
    }

    private void releaseNativePtr() {
        if (this.mNativePtr != null) {
            this.mNativePtr.release();
            this.mNativePtr = null;
        }
    }

    private void setTarget(RenderNode renderNode) {
        checkMutable();
        if (this.mTarget != null) {
            throw new IllegalStateException("Target already set!");
        }
        nSetListener(this.mNativePtr.get(), this);
        this.mTarget = renderNode;
        this.mTarget.addAnimator(this);
    }

    @Override // android.animation.Animator
    public void cancel() {
        if (this.mState == 0 || this.mState == 3) {
            return;
        }
        if (this.mState == 1) {
            getHelper().removeDelayedAnimation(this);
            moveToRunningState();
        }
        ArrayList<Animator.AnimatorListener> cloneListeners = cloneListeners();
        int size = cloneListeners == null ? 0 : cloneListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                end();
                return;
            } else {
                cloneListeners.get(i2).onAnimationCancel(this);
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.Animator
    /* renamed from: clone */
    public Animator mo53clone() {
        throw new IllegalStateException("Cannot clone this animator");
    }

    @Override // android.animation.Animator
    public void end() {
        if (this.mState != 3) {
            if (this.mState < 2) {
                getHelper().removeDelayedAnimation(this);
                doStart();
            }
            if (this.mNativePtr == null) {
                onFinished();
                return;
            }
            nEnd(this.mNativePtr.get());
            if (this.mViewTarget != null) {
                this.mViewTarget.invalidateViewProperty(true, false);
            }
        }
    }

    @Override // android.animation.Animator
    public long getDuration() {
        return this.mUnscaledDuration;
    }

    @Override // android.animation.Animator
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeAnimator() {
        return this.mNativePtr.get();
    }

    @Override // android.animation.Animator
    public long getStartDelay() {
        return this.mUnscaledStartDelay;
    }

    @Override // android.animation.Animator
    public boolean isRunning() {
        return this.mState == 1 || this.mState == 2;
    }

    @Override // android.animation.Animator
    public boolean isStarted() {
        return this.mState != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFinished() {
        if (this.mState == 0) {
            releaseNativePtr();
            return;
        }
        if (this.mState == 1) {
            getHelper().removeDelayedAnimation(this);
            notifyStartListeners();
        }
        this.mState = 3;
        ArrayList<Animator.AnimatorListener> cloneListeners = cloneListeners();
        int size = cloneListeners == null ? 0 : cloneListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                releaseNativePtr();
                return;
            } else {
                cloneListeners.get(i2).onAnimationEnd(this);
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.Animator
    public void pause() {
        throw new UnsupportedOperationException();
    }

    @Override // android.animation.Animator
    public void resume() {
        throw new UnsupportedOperationException();
    }

    @Override // android.animation.Animator
    public void setAllowRunningAsynchronously(boolean z) {
        checkMutable();
        nSetAllowRunningAsync(this.mNativePtr.get(), z);
    }

    @Override // android.animation.Animator
    public RenderNodeAnimator setDuration(long j) {
        checkMutable();
        if (j < 0) {
            throw new IllegalArgumentException("duration must be positive; " + j);
        }
        this.mUnscaledDuration = j;
        nSetDuration(this.mNativePtr.get(), ((float) j) * ValueAnimator.getDurationScale());
        return this;
    }

    @Override // android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        checkMutable();
        this.mInterpolator = timeInterpolator;
    }

    @Override // android.animation.Animator
    public void setStartDelay(long j) {
        checkMutable();
        if (j < 0) {
            throw new IllegalArgumentException("startDelay must be positive; " + j);
        }
        this.mUnscaledStartDelay = j;
        this.mStartDelay = ValueAnimator.getDurationScale() * ((float) j);
    }

    public void setStartValue(float f) {
        checkMutable();
        nSetStartValue(this.mNativePtr.get(), f);
    }

    public void setTarget(Canvas canvas) {
        if (!(canvas instanceof GLES20RecordingCanvas)) {
            throw new IllegalArgumentException("Not a GLES20RecordingCanvas");
        }
        setTarget(((GLES20RecordingCanvas) canvas).mNode);
    }

    public void setTarget(View view) {
        this.mViewTarget = view;
        setTarget(this.mViewTarget.mRenderNode);
    }

    @Override // android.animation.Animator
    public void start() {
        if (this.mTarget == null) {
            throw new IllegalStateException("Missing target!");
        }
        if (this.mState != 0) {
            throw new IllegalStateException("Already started!");
        }
        this.mState = 1;
        applyInterpolator();
        if (this.mNativePtr == null) {
            cancel();
        } else if (this.mStartDelay > 0 && this.mUiThreadHandlesDelay) {
            getHelper().addDelayedAnimation(this);
        } else {
            nSetStartDelay(this.mNativePtr.get(), this.mStartDelay);
            doStart();
        }
    }
}
