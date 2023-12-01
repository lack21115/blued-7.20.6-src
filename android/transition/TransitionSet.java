package android.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.Transition;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionSet.class */
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    ArrayList<Transition> mTransitions;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionSet$TransitionSetListener.class */
    public static class TransitionSetListener extends Transition.TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.mTransitionSet.mCurrentListeners--;
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            if (this.mTransitionSet.mStarted) {
                return;
            }
            this.mTransitionSet.start();
            this.mTransitionSet.mStarted = true;
        }
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransitionSet);
        setOrdering(obtainStyledAttributes.getInt(0, 0));
        obtainStyledAttributes.recycle();
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // android.transition.Transition
    public TransitionSet addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // android.transition.Transition
    public TransitionSet addTarget(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(i);
            }
            this.mTransitions.get(i3).addTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet addTarget(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(view);
            }
            this.mTransitions.get(i2).addTarget(view);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet addTarget(Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(cls);
            }
            this.mTransitions.get(i2).addTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet addTarget(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.addTarget(str);
            }
            this.mTransitions.get(i2).addTarget(str);
            i = i2 + 1;
        }
    }

    public TransitionSet addTransition(Transition transition) {
        if (transition != null) {
            this.mTransitions.add(transition);
            transition.mParent = this;
            if (this.mDuration >= 0) {
                transition.setDuration(this.mDuration);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.transition.Transition
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).cancel();
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.targetedTransitions.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).capturePropagationValues(transitionValues);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.targetedTransitions.add(next);
                }
            }
        }
    }

    @Override // android.transition.Transition
    /* renamed from: clone */
    public TransitionSet mo996clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo996clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return transitionSet;
            }
            transitionSet.addTransition(this.mTransitions.get(i2).mo996clone());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.transition.Transition
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Transition transition = this.mTransitions.get(i2);
            if (startDelay > 0 && (this.mPlayTogether || i2 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay + startDelay2);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public Transition excludeTarget(int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return super.excludeTarget(i, z);
            }
            this.mTransitions.get(i3).excludeTarget(i, z);
            i2 = i3 + 1;
        }
    }

    @Override // android.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(view, z);
            }
            this.mTransitions.get(i2).excludeTarget(view, z);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public Transition excludeTarget(Class cls, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(cls, z);
            }
            this.mTransitions.get(i2).excludeTarget(cls, z);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return super.excludeTarget(str, z);
            }
            this.mTransitions.get(i2).excludeTarget(str, z);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public void forceVisibility(int i, boolean z) {
        int size = this.mTransitions.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            this.mTransitions.get(i3).forceVisibility(i, z);
            i2 = i3 + 1;
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ? 0 : 1;
    }

    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // android.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).pause(view);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // android.transition.Transition
    public TransitionSet removeTarget(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(i);
            }
            this.mTransitions.get(i3).removeTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet removeTarget(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(view);
            }
            this.mTransitions.get(i2).removeTarget(view);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet removeTarget(Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(cls);
            }
            this.mTransitions.get(i2).removeTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet removeTarget(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return (TransitionSet) super.removeTarget(str);
            }
            this.mTransitions.get(i2).removeTarget(str);
            i = i2 + 1;
        }
    }

    public TransitionSet removeTransition(Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // android.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).resume(view);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.transition.Transition
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        int size = this.mTransitions.size();
        if (!this.mPlayTogether) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                final Transition transition = this.mTransitions.get(i2);
                this.mTransitions.get(i2 - 1).addListener(new Transition.TransitionListenerAdapter() { // from class: android.transition.TransitionSet.1
                    @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition2) {
                        transition.runAnimators();
                        transition2.removeListener(this);
                    }
                });
                i = i2 + 1;
            }
            Transition transition2 = this.mTransitions.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            this.mTransitions.get(i4).runAnimators();
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).setCanRemoveViews(z);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0 && this.mTransitions != null) {
            int size = this.mTransitions.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.mTransitions.get(i2).setDuration(j);
                i = i2 + 1;
            }
        }
        return this;
    }

    @Override // android.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).setEpicenterCallback(epicenterCallback);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public TransitionSet setOrdering(int i) {
        switch (i) {
            case 0:
                this.mPlayTogether = true;
                return this;
            case 1:
                this.mPlayTogether = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    @Override // android.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return;
            }
            this.mTransitions.get(i2).setPathMotion(pathMotion);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mTransitions.get(i2).setPropagation(transitionPropagation);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return this;
            }
            this.mTransitions.get(i2).setSceneRoot(viewGroup);
            i = i2 + 1;
        }
    }

    @Override // android.transition.Transition
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTransitions.size()) {
                return transition;
            }
            transition = transition + "\n" + this.mTransitions.get(i2).toString(str + "  ");
            i = i2 + 1;
        }
    }
}
