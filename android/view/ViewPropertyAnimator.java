package android.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewPropertyAnimator.class */
public class ViewPropertyAnimator {
    static final int ALPHA = 2048;
    static final int NONE = 0;
    static final int ROTATION = 32;
    static final int ROTATION_X = 64;
    static final int ROTATION_Y = 128;
    static final int SCALE_X = 8;
    static final int SCALE_Y = 16;
    private static final int TRANSFORM_MASK = 2047;
    static final int TRANSLATION_X = 1;
    static final int TRANSLATION_Y = 2;
    static final int TRANSLATION_Z = 4;
    static final int X = 256;
    static final int Y = 512;
    static final int Z = 1024;
    private HashMap<Animator, Runnable> mAnimatorCleanupMap;
    private HashMap<Animator, Runnable> mAnimatorOnEndMap;
    private HashMap<Animator, Runnable> mAnimatorOnStartMap;
    private HashMap<Animator, Runnable> mAnimatorSetupMap;
    private long mDuration;
    private TimeInterpolator mInterpolator;
    private Runnable mPendingCleanupAction;
    private Runnable mPendingOnEndAction;
    private Runnable mPendingOnStartAction;
    private Runnable mPendingSetupAction;
    private ViewPropertyAnimatorRT mRTBackend;
    private ValueAnimator mTempValueAnimator;
    final View mView;
    private boolean mDurationSet = false;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    private boolean mInterpolatorSet = false;
    private Animator.AnimatorListener mListener = null;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener = null;
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<>();
    private Runnable mAnimationStarter = new Runnable() { // from class: android.view.ViewPropertyAnimator.1
        @Override // java.lang.Runnable
        public void run() {
            ViewPropertyAnimator.this.startAnimation();
        }
    };
    private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewPropertyAnimator$AnimatorEventListener.class */
    public class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimator.this.mListener != null) {
                ViewPropertyAnimator.this.mListener.onAnimationCancel(animator);
            }
            if (ViewPropertyAnimator.this.mAnimatorOnEndMap != null) {
                ViewPropertyAnimator.this.mAnimatorOnEndMap.remove(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator.this.mView.setHasTransientState(false);
            if (ViewPropertyAnimator.this.mListener != null) {
                ViewPropertyAnimator.this.mListener.onAnimationEnd(animator);
            }
            if (ViewPropertyAnimator.this.mAnimatorOnEndMap != null) {
                Runnable runnable = (Runnable) ViewPropertyAnimator.this.mAnimatorOnEndMap.get(animator);
                if (runnable != null) {
                    runnable.run();
                }
                ViewPropertyAnimator.this.mAnimatorOnEndMap.remove(animator);
            }
            if (ViewPropertyAnimator.this.mAnimatorCleanupMap != null) {
                Runnable runnable2 = (Runnable) ViewPropertyAnimator.this.mAnimatorCleanupMap.get(animator);
                if (runnable2 != null) {
                    runnable2.run();
                }
                ViewPropertyAnimator.this.mAnimatorCleanupMap.remove(animator);
            }
            ViewPropertyAnimator.this.mAnimatorMap.remove(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimator.this.mListener != null) {
                ViewPropertyAnimator.this.mListener.onAnimationRepeat(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimator.this.mAnimatorSetupMap != null) {
                Runnable runnable = (Runnable) ViewPropertyAnimator.this.mAnimatorSetupMap.get(animator);
                if (runnable != null) {
                    runnable.run();
                }
                ViewPropertyAnimator.this.mAnimatorSetupMap.remove(animator);
            }
            if (ViewPropertyAnimator.this.mAnimatorOnStartMap != null) {
                Runnable runnable2 = (Runnable) ViewPropertyAnimator.this.mAnimatorOnStartMap.get(animator);
                if (runnable2 != null) {
                    runnable2.run();
                }
                ViewPropertyAnimator.this.mAnimatorOnStartMap.remove(animator);
            }
            if (ViewPropertyAnimator.this.mListener != null) {
                ViewPropertyAnimator.this.mListener.onAnimationStart(animator);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimator.this.mAnimatorMap.get(valueAnimator);
            if (propertyBundle == null) {
                return;
            }
            boolean isHardwareAccelerated = ViewPropertyAnimator.this.mView.isHardwareAccelerated();
            boolean z = false;
            boolean z2 = false;
            if (!isHardwareAccelerated) {
                ViewPropertyAnimator.this.mView.invalidateParentCaches();
            }
            float animatedFraction = valueAnimator.getAnimatedFraction();
            int i = propertyBundle.mPropertyMask;
            if ((i & 2047) != 0) {
                ViewPropertyAnimator.this.mView.invalidateViewProperty(isHardwareAccelerated, false);
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    z = z2;
                    if (i3 >= size) {
                        break;
                    }
                    NameValuesHolder nameValuesHolder = arrayList.get(i3);
                    float f = nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction);
                    if (nameValuesHolder.mNameConstant == 2048) {
                        z2 = ViewPropertyAnimator.this.mView.setAlphaNoInvalidation(f);
                    } else {
                        ViewPropertyAnimator.this.setValue(nameValuesHolder.mNameConstant, f);
                    }
                    i2 = i3 + 1;
                }
            }
            if ((i & 2047) != 0 && !isHardwareAccelerated) {
                ViewPropertyAnimator.this.mView.mPrivateFlags |= 32;
            }
            if (z) {
                ViewPropertyAnimator.this.mView.invalidate(true);
            } else {
                ViewPropertyAnimator.this.mView.invalidateViewProperty(false, false);
            }
            if (ViewPropertyAnimator.this.mUpdateListener != null) {
                ViewPropertyAnimator.this.mUpdateListener.onAnimationUpdate(valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewPropertyAnimator$NameValuesHolder.class */
    public static class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f2) {
            this.mNameConstant = i;
            this.mFromValue = f;
            this.mDeltaValue = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewPropertyAnimator$PropertyBundle.class */
    public static class PropertyBundle {
        ArrayList<NameValuesHolder> mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, ArrayList<NameValuesHolder> arrayList) {
            this.mPropertyMask = i;
            this.mNameValuesHolder = arrayList;
        }

        boolean cancel(int i) {
            if ((this.mPropertyMask & i) == 0 || this.mNameValuesHolder == null) {
                return false;
            }
            int size = this.mNameValuesHolder.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return false;
                }
                if (this.mNameValuesHolder.get(i3).mNameConstant == i) {
                    this.mNameValuesHolder.remove(i3);
                    this.mPropertyMask &= i ^ (-1);
                    return true;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimator(View view) {
        this.mView = view;
        view.ensureTransformationInfo();
    }

    private void animateProperty(int i, float f) {
        float value = getValue(i);
        animatePropertyBy(i, value, f - value);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f2) {
        Animator animator;
        if (this.mAnimatorMap.size() > 0) {
            Iterator<Animator> it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                animator = null;
                if (!it.hasNext()) {
                    break;
                }
                animator = it.next();
                PropertyBundle propertyBundle = this.mAnimatorMap.get(animator);
                if (propertyBundle.cancel(i) && propertyBundle.mPropertyMask == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.add(new NameValuesHolder(i, f, f2));
        this.mView.removeCallbacks(this.mAnimationStarter);
        this.mView.postOnAnimation(this.mAnimationStarter);
    }

    private float getValue(int i) {
        RenderNode renderNode = this.mView.mRenderNode;
        switch (i) {
            case 1:
                return renderNode.getTranslationX();
            case 2:
                return renderNode.getTranslationY();
            case 4:
                return renderNode.getTranslationZ();
            case 8:
                return renderNode.getScaleX();
            case 16:
                return renderNode.getScaleY();
            case 32:
                return renderNode.getRotation();
            case 64:
                return renderNode.getRotationX();
            case 128:
                return renderNode.getRotationY();
            case 256:
                return this.mView.mLeft + renderNode.getTranslationX();
            case 512:
                return this.mView.mTop + renderNode.getTranslationY();
            case 1024:
                return renderNode.getElevation() + renderNode.getTranslationZ();
            case 2048:
                return this.mView.mTransformationInfo.mAlpha;
            default:
                return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, float f) {
        View.TransformationInfo transformationInfo = this.mView.mTransformationInfo;
        RenderNode renderNode = this.mView.mRenderNode;
        switch (i) {
            case 1:
                renderNode.setTranslationX(f);
                return;
            case 2:
                renderNode.setTranslationY(f);
                return;
            case 4:
                renderNode.setTranslationZ(f);
                return;
            case 8:
                renderNode.setScaleX(f);
                return;
            case 16:
                renderNode.setScaleY(f);
                return;
            case 32:
                renderNode.setRotation(f);
                return;
            case 64:
                renderNode.setRotationX(f);
                return;
            case 128:
                renderNode.setRotationY(f);
                return;
            case 256:
                renderNode.setTranslationX(f - this.mView.mLeft);
                return;
            case 512:
                renderNode.setTranslationY(f - this.mView.mTop);
                return;
            case 1024:
                renderNode.setTranslationZ(f - renderNode.getElevation());
                return;
            case 2048:
                transformationInfo.mAlpha = f;
                renderNode.setAlpha(f);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        if (this.mRTBackend == null || !this.mRTBackend.startAnimation(this)) {
            this.mView.setHasTransientState(true);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
            ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
            this.mPendingAnimations.clear();
            int i = 0;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                i |= ((NameValuesHolder) arrayList.get(i3)).mNameConstant;
                i2 = i3 + 1;
            }
            this.mAnimatorMap.put(ofFloat, new PropertyBundle(i, arrayList));
            if (this.mPendingSetupAction != null) {
                this.mAnimatorSetupMap.put(ofFloat, this.mPendingSetupAction);
                this.mPendingSetupAction = null;
            }
            if (this.mPendingCleanupAction != null) {
                this.mAnimatorCleanupMap.put(ofFloat, this.mPendingCleanupAction);
                this.mPendingCleanupAction = null;
            }
            if (this.mPendingOnStartAction != null) {
                this.mAnimatorOnStartMap.put(ofFloat, this.mPendingOnStartAction);
                this.mPendingOnStartAction = null;
            }
            if (this.mPendingOnEndAction != null) {
                this.mAnimatorOnEndMap.put(ofFloat, this.mPendingOnEndAction);
                this.mPendingOnEndAction = null;
            }
            ofFloat.addUpdateListener(this.mAnimatorEventListener);
            ofFloat.addListener(this.mAnimatorEventListener);
            if (this.mStartDelaySet) {
                ofFloat.setStartDelay(this.mStartDelay);
            }
            if (this.mDurationSet) {
                ofFloat.setDuration(this.mDuration);
            }
            if (this.mInterpolatorSet) {
                ofFloat.setInterpolator(this.mInterpolator);
            }
            ofFloat.start();
        }
    }

    public ViewPropertyAnimator alpha(float f) {
        animateProperty(2048, f);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(2048, f);
        return this;
    }

    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            for (Animator animator : ((HashMap) this.mAnimatorMap.clone()).keySet()) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.clear();
        this.mPendingSetupAction = null;
        this.mPendingCleanupAction = null;
        this.mPendingOnStartAction = null;
        this.mPendingOnEndAction = null;
        this.mView.removeCallbacks(this.mAnimationStarter);
        if (this.mRTBackend != null) {
            this.mRTBackend.cancelAll();
        }
    }

    public long getDuration() {
        if (this.mDurationSet) {
            return this.mDuration;
        }
        if (this.mTempValueAnimator == null) {
            this.mTempValueAnimator = new ValueAnimator();
        }
        return this.mTempValueAnimator.getDuration();
    }

    public TimeInterpolator getInterpolator() {
        if (this.mInterpolatorSet) {
            return this.mInterpolator;
        }
        if (this.mTempValueAnimator == null) {
            this.mTempValueAnimator = new ValueAnimator();
        }
        return this.mTempValueAnimator.getInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator.AnimatorListener getListener() {
        return this.mListener;
    }

    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ValueAnimator.AnimatorUpdateListener getUpdateListener() {
        return this.mUpdateListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasActions() {
        return (this.mPendingSetupAction == null && this.mPendingCleanupAction == null && this.mPendingOnStartAction == null && this.mPendingOnEndAction == null) ? false : true;
    }

    public ViewPropertyAnimator rotation(float f) {
        animateProperty(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        animateProperty(64, f);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(64, f);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        animateProperty(128, f);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(128, f);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        animateProperty(8, f);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(8, f);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        animateProperty(16, f);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(16, f);
        return this;
    }

    public ViewPropertyAnimator setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDurationSet = true;
        this.mDuration = j;
        return this;
    }

    public ViewPropertyAnimator setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative start delay: " + j);
        }
        this.mStartDelaySet = true;
        this.mStartDelay = j;
        return this;
    }

    public ViewPropertyAnimator setUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListener = animatorUpdateListener;
        return this;
    }

    public void start() {
        this.mView.removeCallbacks(this.mAnimationStarter);
        startAnimation();
    }

    public ViewPropertyAnimator translationX(float f) {
        animateProperty(1, f);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(1, f);
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        animateProperty(2, f);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(2, f);
        return this;
    }

    public ViewPropertyAnimator translationZ(float f) {
        animateProperty(4, f);
        return this;
    }

    public ViewPropertyAnimator translationZBy(float f) {
        animatePropertyBy(4, f);
        return this;
    }

    public ViewPropertyAnimator withEndAction(Runnable runnable) {
        this.mPendingOnEndAction = runnable;
        if (runnable != null && this.mAnimatorOnEndMap == null) {
            this.mAnimatorOnEndMap = new HashMap<>();
        }
        return this;
    }

    public ViewPropertyAnimator withLayer() {
        this.mPendingSetupAction = new Runnable() { // from class: android.view.ViewPropertyAnimator.2
            @Override // java.lang.Runnable
            public void run() {
                ViewPropertyAnimator.this.mView.setLayerType(2, null);
                if (ViewPropertyAnimator.this.mView.isAttachedToWindow()) {
                    ViewPropertyAnimator.this.mView.buildLayer();
                }
            }
        };
        final int layerType = this.mView.getLayerType();
        this.mPendingCleanupAction = new Runnable() { // from class: android.view.ViewPropertyAnimator.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPropertyAnimator.this.mView.setLayerType(layerType, null);
            }
        };
        if (this.mAnimatorSetupMap == null) {
            this.mAnimatorSetupMap = new HashMap<>();
        }
        if (this.mAnimatorCleanupMap == null) {
            this.mAnimatorCleanupMap = new HashMap<>();
        }
        return this;
    }

    public ViewPropertyAnimator withStartAction(Runnable runnable) {
        this.mPendingOnStartAction = runnable;
        if (runnable != null && this.mAnimatorOnStartMap == null) {
            this.mAnimatorOnStartMap = new HashMap<>();
        }
        return this;
    }

    public ViewPropertyAnimator x(float f) {
        animateProperty(256, f);
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(256, f);
        return this;
    }

    public ViewPropertyAnimator y(float f) {
        animateProperty(512, f);
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(512, f);
        return this;
    }

    public ViewPropertyAnimator z(float f) {
        animateProperty(1024, f);
        return this;
    }

    public ViewPropertyAnimator zBy(float f) {
        animatePropertyBy(1024, f);
        return this;
    }
}
