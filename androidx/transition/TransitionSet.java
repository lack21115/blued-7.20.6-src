package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionSet.class */
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;

    /* renamed from: a  reason: collision with root package name */
    int f3479a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Transition> f3480c;
    private boolean d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionSet$TransitionSetListener.class */
    public static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f3482a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f3482a = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f3482a.f3479a--;
            if (this.f3482a.f3479a == 0) {
                this.f3482a.b = false;
                this.f3482a.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            if (this.f3482a.b) {
                return;
            }
            this.f3482a.start();
            this.f3482a.b = true;
        }
    }

    public TransitionSet() {
        this.f3480c = new ArrayList<>();
        this.d = true;
        this.b = false;
        this.e = 0;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3480c = new ArrayList<>();
        this.d = true;
        this.b = false;
        this.e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.i);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void a() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.f3480c.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.f3479a = this.f3480c.size();
    }

    private void a(Transition transition) {
        this.f3480c.add(transition);
        transition.mParent = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    /* renamed from: a */
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return this;
            }
            this.f3480c.get(i2).setSceneRoot(viewGroup);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(Class cls) {
        return addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f3480c.size()) {
                return (TransitionSet) super.addTarget(i);
            }
            this.f3480c.get(i3).addTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.addTarget(view);
            }
            this.f3480c.get(i2).addTarget(view);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(Class<?> cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.addTarget(cls);
            }
            this.f3480c.get(i2).addTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.addTarget(str);
            }
            this.f3480c.get(i2).addTarget(str);
            i = i2 + 1;
        }
    }

    public TransitionSet addTransition(Transition transition) {
        a(transition);
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        if ((this.e & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.e & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.e & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.e & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    protected void cancel() {
        super.cancel();
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).cancel();
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.f3480c.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.f3487a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).capturePropagationValues(transitionValues);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.f3480c.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.f3487a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo1622clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo1622clone();
        transitionSet.f3480c = new ArrayList<>();
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return transitionSet;
            }
            transitionSet.a(this.f3480c.get(i2).mo1622clone());
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Transition transition = this.f3480c.get(i2);
            if (startDelay > 0 && (this.d || i2 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f3480c.size()) {
                return super.excludeTarget(i, z);
            }
            this.f3480c.get(i3).excludeTarget(i, z);
            i2 = i3 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return super.excludeTarget(view, z);
            }
            this.f3480c.get(i2).excludeTarget(view, z);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return super.excludeTarget(cls, z);
            }
            this.f3480c.get(i2).excludeTarget(cls, z);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return super.excludeTarget(str, z);
            }
            this.f3480c.get(i2).excludeTarget(str, z);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).forceToEnd(viewGroup);
            i = i2 + 1;
        }
    }

    public int getOrdering() {
        return !this.d ? 1 : 0;
    }

    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.f3480c.size()) {
            return null;
        }
        return this.f3480c.get(i);
    }

    public int getTransitionCount() {
        return this.f3480c.size();
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).pause(view);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(Class cls) {
        return removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f3480c.size()) {
                return (TransitionSet) super.removeTarget(i);
            }
            this.f3480c.get(i3).removeTarget(i);
            i2 = i3 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.removeTarget(view);
            }
            this.f3480c.get(i2).removeTarget(view);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(Class<?> cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.removeTarget(cls);
            }
            this.f3480c.get(i2).removeTarget(cls);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return (TransitionSet) super.removeTarget(str);
            }
            this.f3480c.get(i2).removeTarget(str);
            i = i2 + 1;
        }
    }

    public TransitionSet removeTransition(Transition transition) {
        this.f3480c.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).resume(view);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    protected void runAnimators() {
        if (this.f3480c.isEmpty()) {
            start();
            end();
            return;
        }
        a();
        if (this.d) {
            Iterator<Transition> it = this.f3480c.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                break;
            }
            final Transition transition = this.f3480c.get(i2);
            this.f3480c.get(i2 - 1).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    transition.runAnimators();
                    transition2.removeListener(this);
                }
            });
            i = i2 + 1;
        }
        Transition transition2 = this.f3480c.get(0);
        if (transition2 != null) {
            transition2.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).setCanRemoveViews(z);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet setDuration(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f3480c) != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.f3480c.get(i2).setDuration(j);
                i = i2 + 1;
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.e |= 8;
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).setEpicenterCallback(epicenterCallback);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.e |= 1;
        ArrayList<Transition> arrayList = this.f3480c;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.f3480c.get(i2).setInterpolator(timeInterpolator);
                i = i2 + 1;
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public TransitionSet setOrdering(int i) {
        if (i == 0) {
            this.d = true;
            return this;
        } else if (i == 1) {
            this.d = false;
            return this;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.e |= 4;
        if (this.f3480c == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return;
            }
            this.f3480c.get(i2).setPathMotion(pathMotion);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.e |= 2;
        int size = this.f3480c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.f3480c.get(i2).setPropagation(transitionPropagation);
            i = i2 + 1;
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    @Override // androidx.transition.Transition
    String toString(String str) {
        String transition = super.toString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3480c.size()) {
                return transition;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            Transition transition2 = this.f3480c.get(i2);
            sb.append(transition2.toString(str + "  "));
            transition = sb.toString();
            i = i2 + 1;
        }
    }
}
