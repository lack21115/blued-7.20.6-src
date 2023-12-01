package android.animation;

import android.content.res.ConstantState;
import android.util.StateSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/animation/StateListAnimator.class */
public class StateListAnimator implements Cloneable {
    private AnimatorListenerAdapter mAnimatorListener;
    private int mChangingConfigurations;
    private StateListAnimatorConstantState mConstantState;
    private WeakReference<View> mViewRef;
    private ArrayList<Tuple> mTuples = new ArrayList<>();
    private Tuple mLastMatch = null;
    private Animator mRunningAnimator = null;

    /* loaded from: source-9557208-dex2jar.jar:android/animation/StateListAnimator$StateListAnimatorConstantState.class */
    private static class StateListAnimatorConstantState extends ConstantState<StateListAnimator> {
        final StateListAnimator mAnimator;
        int mChangingConf;

        public StateListAnimatorConstantState(StateListAnimator stateListAnimator) {
            this.mAnimator = stateListAnimator;
            this.mAnimator.mConstantState = this;
            this.mChangingConf = this.mAnimator.getChangingConfigurations();
        }

        @Override // android.content.res.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConf;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.content.res.ConstantState
        public StateListAnimator newInstance() {
            StateListAnimator m69clone = this.mAnimator.m69clone();
            m69clone.mConstantState = this;
            return m69clone;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/StateListAnimator$Tuple.class */
    public static class Tuple {
        final Animator mAnimator;
        final int[] mSpecs;

        private Tuple(int[] iArr, Animator animator) {
            this.mSpecs = iArr;
            this.mAnimator = animator;
        }

        public Animator getAnimator() {
            return this.mAnimator;
        }

        public int[] getSpecs() {
            return this.mSpecs;
        }
    }

    public StateListAnimator() {
        initAnimatorListener();
    }

    private void cancel() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.cancel();
            this.mRunningAnimator = null;
        }
    }

    private void clearTarget() {
        int size = this.mTuples.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.mViewRef = null;
                this.mLastMatch = null;
                this.mRunningAnimator = null;
                return;
            }
            this.mTuples.get(i2).mAnimator.setTarget(null);
            i = i2 + 1;
        }
    }

    private void initAnimatorListener() {
        this.mAnimatorListener = new AnimatorListenerAdapter() { // from class: android.animation.StateListAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.setTarget(null);
                if (StateListAnimator.this.mRunningAnimator == animator) {
                    StateListAnimator.this.mRunningAnimator = null;
                }
            }
        };
    }

    private void start(Tuple tuple) {
        tuple.mAnimator.setTarget(getTarget());
        this.mRunningAnimator = tuple.mAnimator;
        this.mRunningAnimator.start();
    }

    public void addState(int[] iArr, Animator animator) {
        Tuple tuple = new Tuple(iArr, animator);
        tuple.mAnimator.addListener(this.mAnimatorListener);
        this.mTuples.add(tuple);
        this.mChangingConfigurations |= animator.getChangingConfigurations();
    }

    public void appendChangingConfigurations(int i) {
        this.mChangingConfigurations |= i;
    }

    /* renamed from: clone */
    public StateListAnimator m69clone() {
        try {
            StateListAnimator stateListAnimator = (StateListAnimator) super.clone();
            stateListAnimator.mTuples = new ArrayList<>(this.mTuples.size());
            stateListAnimator.mLastMatch = null;
            stateListAnimator.mRunningAnimator = null;
            stateListAnimator.mViewRef = null;
            stateListAnimator.mAnimatorListener = null;
            stateListAnimator.initAnimatorListener();
            int size = this.mTuples.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    stateListAnimator.setChangingConfigurations(getChangingConfigurations());
                    return stateListAnimator;
                }
                Tuple tuple = this.mTuples.get(i2);
                Animator mo53clone = tuple.mAnimator.mo53clone();
                mo53clone.removeListener(this.mAnimatorListener);
                stateListAnimator.addState(tuple.mSpecs, mo53clone);
                i = i2 + 1;
            }
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cannot clone state list animator", e);
        }
    }

    public ConstantState<StateListAnimator> createConstantState() {
        return new StateListAnimatorConstantState(this);
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Animator getRunningAnimator() {
        return this.mRunningAnimator;
    }

    public View getTarget() {
        if (this.mViewRef == null) {
            return null;
        }
        return this.mViewRef.get();
    }

    public ArrayList<Tuple> getTuples() {
        return this.mTuples;
    }

    public void jumpToCurrentState() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.end();
        }
    }

    public void setChangingConfigurations(int i) {
        this.mChangingConfigurations = i;
    }

    public void setState(int[] iArr) {
        Tuple tuple;
        int size = this.mTuples.size();
        int i = 0;
        while (true) {
            int i2 = i;
            tuple = null;
            if (i2 >= size) {
                break;
            }
            tuple = this.mTuples.get(i2);
            if (StateSet.stateSetMatches(tuple.mSpecs, iArr)) {
                break;
            }
            i = i2 + 1;
        }
        if (tuple == this.mLastMatch) {
            return;
        }
        if (this.mLastMatch != null) {
            cancel();
        }
        this.mLastMatch = tuple;
        if (tuple != null) {
            start(tuple);
        }
    }

    public void setTarget(View view) {
        View target = getTarget();
        if (target == view) {
            return;
        }
        if (target != null) {
            clearTarget();
        }
        if (view != null) {
            this.mViewRef = new WeakReference<>(view);
        }
    }
}
