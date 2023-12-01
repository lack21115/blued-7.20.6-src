package android.animation;

import android.content.res.ConstantState;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/animation/Animator.class */
public abstract class Animator implements Cloneable {
    private AnimatorConstantState mConstantState;
    ArrayList<AnimatorListener> mListeners = null;
    ArrayList<AnimatorPauseListener> mPauseListeners = null;
    boolean mPaused = false;
    int mChangingConfigurations = 0;

    /* loaded from: source-9557208-dex2jar.jar:android/animation/Animator$AnimatorConstantState.class */
    private static class AnimatorConstantState extends ConstantState<Animator> {
        final Animator mAnimator;
        int mChangingConf;

        public AnimatorConstantState(Animator animator) {
            this.mAnimator = animator;
            this.mAnimator.mConstantState = this;
            this.mChangingConf = this.mAnimator.getChangingConfigurations();
        }

        @Override // android.content.res.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConf;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.content.res.ConstantState
        public Animator newInstance() {
            Animator mo53clone = this.mAnimator.mo53clone();
            mo53clone.mConstantState = this;
            return mo53clone;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/Animator$AnimatorListener.class */
    public interface AnimatorListener {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/Animator$AnimatorPauseListener.class */
    public interface AnimatorPauseListener {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public void addListener(AnimatorListener animatorListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(animatorListener);
    }

    public void addPauseListener(AnimatorPauseListener animatorPauseListener) {
        if (this.mPauseListeners == null) {
            this.mPauseListeners = new ArrayList<>();
        }
        this.mPauseListeners.add(animatorPauseListener);
    }

    public void appendChangingConfigurations(int i) {
        this.mChangingConfigurations |= i;
    }

    public boolean canReverse() {
        return false;
    }

    public void cancel() {
    }

    @Override // 
    /* renamed from: clone */
    public Animator mo53clone() {
        try {
            Animator animator = (Animator) super.clone();
            if (this.mListeners != null) {
                animator.mListeners = new ArrayList<>(this.mListeners);
            }
            if (this.mPauseListeners != null) {
                animator.mPauseListeners = new ArrayList<>(this.mPauseListeners);
            }
            return animator;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public ConstantState<Animator> createConstantState() {
        return new AnimatorConstantState(this);
    }

    public void end() {
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public abstract long getDuration();

    public TimeInterpolator getInterpolator() {
        return null;
    }

    public ArrayList<AnimatorListener> getListeners() {
        return this.mListeners;
    }

    public abstract long getStartDelay();

    public boolean isPaused() {
        return this.mPaused;
    }

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void pause() {
        if (!isStarted() || this.mPaused) {
            return;
        }
        this.mPaused = true;
        if (this.mPauseListeners == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.mPauseListeners.clone();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ((AnimatorPauseListener) arrayList.get(i2)).onAnimationPause(this);
            i = i2 + 1;
        }
    }

    public void removeAllListeners() {
        if (this.mListeners != null) {
            this.mListeners.clear();
            this.mListeners = null;
        }
        if (this.mPauseListeners != null) {
            this.mPauseListeners.clear();
            this.mPauseListeners = null;
        }
    }

    public void removeListener(AnimatorListener animatorListener) {
        if (this.mListeners == null) {
            return;
        }
        this.mListeners.remove(animatorListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
    }

    public void removePauseListener(AnimatorPauseListener animatorPauseListener) {
        if (this.mPauseListeners == null) {
            return;
        }
        this.mPauseListeners.remove(animatorPauseListener);
        if (this.mPauseListeners.size() == 0) {
            this.mPauseListeners = null;
        }
    }

    public void resume() {
        if (!this.mPaused) {
            return;
        }
        this.mPaused = false;
        if (this.mPauseListeners == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.mPauseListeners.clone();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ((AnimatorPauseListener) arrayList.get(i2)).onAnimationResume(this);
            i = i2 + 1;
        }
    }

    public void reverse() {
        throw new IllegalStateException("Reverse is not supported");
    }

    public void setAllowRunningAsynchronously(boolean z) {
    }

    public void setChangingConfigurations(int i) {
        this.mChangingConfigurations = i;
    }

    public abstract Animator setDuration(long j);

    public abstract void setInterpolator(TimeInterpolator timeInterpolator);

    public abstract void setStartDelay(long j);

    public void setTarget(Object obj) {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }
}
