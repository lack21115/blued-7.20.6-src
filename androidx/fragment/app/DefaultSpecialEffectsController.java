package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/DefaultSpecialEffectsController.class */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/DefaultSpecialEffectsController$10.class */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2858a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f2858a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2858a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2858a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2858a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo.class */
    public static class AnimationInfo extends SpecialEffectsInfo {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2873a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private FragmentAnim.AnimationOrAnimator f2874c;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.b = false;
            this.f2873a = z;
        }

        FragmentAnim.AnimationOrAnimator a(Context context) {
            if (this.b) {
                return this.f2874c;
            }
            FragmentAnim.AnimationOrAnimator a2 = FragmentAnim.a(context, a().getFragment(), a().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.f2873a);
            this.f2874c = a2;
            this.b = true;
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo.class */
    public static class SpecialEffectsInfo {

        /* renamed from: a  reason: collision with root package name */
        private final SpecialEffectsController.Operation f2875a;
        private final CancellationSignal b;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.f2875a = operation;
            this.b = cancellationSignal;
        }

        SpecialEffectsController.Operation a() {
            return this.f2875a;
        }

        CancellationSignal b() {
            return this.b;
        }

        boolean c() {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(this.f2875a.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.f2875a.getFinalState();
            if (a2 != finalState) {
                return (a2 == SpecialEffectsController.Operation.State.VISIBLE || finalState == SpecialEffectsController.Operation.State.VISIBLE) ? false : true;
            }
            return true;
        }

        void d() {
            this.f2875a.completeSpecialEffect(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo.class */
    public static class TransitionInfo extends SpecialEffectsInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2876a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f2877c;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f2876a = z ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.b = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.f2876a = z ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.b = true;
            }
            if (!z2) {
                this.f2877c = null;
            } else if (z) {
                this.f2877c = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.f2877c = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        private FragmentTransitionImpl a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (FragmentTransition.f2966a == null || !FragmentTransition.f2966a.canHandle(obj)) {
                if (FragmentTransition.b == null || !FragmentTransition.b.canHandle(obj)) {
                    throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().getFragment() + " is not a valid framework Transition or AndroidX Transition");
                }
                return FragmentTransition.b;
            }
            return FragmentTransition.f2966a;
        }

        Object e() {
            return this.f2876a;
        }

        boolean f() {
            return this.b;
        }

        FragmentTransitionImpl g() {
            FragmentTransitionImpl a2 = a(this.f2876a);
            FragmentTransitionImpl a3 = a(this.f2877c);
            if (a2 == null || a3 == null || a2 == a3) {
                return a2 != null ? a2 : a3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().getFragment() + " returned Transition " + this.f2876a + " which uses a different Transition  type than its shared element transition " + this.f2877c);
        }

        public Object getSharedElementTransition() {
            return this.f2877c;
        }

        public boolean hasSharedElementTransition() {
            return this.f2877c != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private Map<SpecialEffectsController.Operation, Boolean> a(List<TransitionInfo> list, List<SpecialEffectsController.Operation> list2, final boolean z, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        View view;
        View view2;
        DefaultSpecialEffectsController defaultSpecialEffectsController;
        SpecialEffectsController.Operation operation3;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        final View view3;
        String a2;
        DefaultSpecialEffectsController defaultSpecialEffectsController2 = this;
        SpecialEffectsController.Operation operation4 = operation;
        SpecialEffectsController.Operation operation5 = operation2;
        HashMap hashMap = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.c()) {
                FragmentTransitionImpl g = transitionInfo.g();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = g;
                } else if (g != null && fragmentTransitionImpl != g) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.a().getFragment() + " returned Transition " + transitionInfo.e() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap.put(transitionInfo2.a(), false);
                transitionInfo2.d();
            }
            return hashMap;
        }
        View view4 = new View(getContainer().getContext());
        final Rect rect = new Rect();
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        ArrayMap arrayMap = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj = null;
        View view5 = null;
        boolean z2 = false;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        while (true) {
            view = view4;
            if (!it.hasNext()) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                SpecialEffectsController.Operation operation6 = operation5;
                view2 = view;
                defaultSpecialEffectsController = defaultSpecialEffectsController2;
                operation3 = operation6;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= sharedElementTargetNames.size()) {
                        break;
                    }
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                    }
                    i = i2 + 1;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        break;
                    }
                    arrayMap.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i3 = i4 + 1;
                }
                ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
                defaultSpecialEffectsController2.a(arrayMap2, operation.getFragment().mView);
                arrayMap2.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                    int size2 = sharedElementSourceNames.size();
                    while (true) {
                        int i5 = size2 - 1;
                        if (i5 < 0) {
                            break;
                        }
                        String str = sharedElementSourceNames.get(i5);
                        View view6 = arrayMap2.get(str);
                        if (view6 == null) {
                            arrayMap.remove(str);
                        } else if (!str.equals(ViewCompat.getTransitionName(view6))) {
                            arrayMap.put(ViewCompat.getTransitionName(view6), (String) arrayMap.remove(str));
                        }
                        size2 = i5;
                    }
                } else {
                    arrayMap.retainAll(arrayMap2.keySet());
                }
                final ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                defaultSpecialEffectsController2.a(arrayMap3, operation2.getFragment().mView);
                arrayMap3.retainAll(sharedElementTargetNames2);
                arrayMap3.retainAll(arrayMap.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap3);
                    int size3 = sharedElementTargetNames2.size();
                    while (true) {
                        int i6 = size3 - 1;
                        if (i6 < 0) {
                            break;
                        }
                        String str2 = sharedElementTargetNames2.get(i6);
                        View view7 = arrayMap3.get(str2);
                        if (view7 == null) {
                            String a3 = FragmentTransition.a(arrayMap, str2);
                            if (a3 != null) {
                                arrayMap.remove(a3);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view7)) && (a2 = FragmentTransition.a(arrayMap, str2)) != null) {
                            arrayMap.put(a2, ViewCompat.getTransitionName(view7));
                        }
                        size3 = i6;
                    }
                } else {
                    FragmentTransition.a(arrayMap, arrayMap3);
                }
                defaultSpecialEffectsController2.a(arrayMap2, arrayMap.keySet());
                defaultSpecialEffectsController2.a(arrayMap3, arrayMap.values());
                if (arrayMap.isEmpty()) {
                    arrayList.clear();
                    arrayList2.clear();
                    view2 = view;
                    obj = null;
                    operation4 = operation;
                    DefaultSpecialEffectsController defaultSpecialEffectsController3 = defaultSpecialEffectsController2;
                    operation3 = operation2;
                    defaultSpecialEffectsController = defaultSpecialEffectsController3;
                } else {
                    FragmentTransition.a(operation2.getFragment(), operation.getFragment(), z, arrayMap2, true);
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.a(operation2.getFragment(), operation.getFragment(), z, (ArrayMap<String, View>) arrayMap3, false);
                        }
                    });
                    arrayList.addAll(arrayMap2.values());
                    if (!sharedElementSourceNames.isEmpty()) {
                        view5 = arrayMap2.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view5);
                    }
                    arrayList2.addAll(arrayMap3.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view3 = arrayMap3.get(sharedElementTargetNames2.get(0))) != null) {
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.a(view3, rect);
                            }
                        });
                        z2 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view, arrayList);
                    view2 = view;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList2);
                    hashMap.put(operation, true);
                    operation3 = operation2;
                    hashMap.put(operation3, true);
                    obj = wrapTransitionInSet;
                    defaultSpecialEffectsController = this;
                    operation4 = operation;
                }
            }
            view4 = view2;
            operation5 = operation3;
            defaultSpecialEffectsController2 = defaultSpecialEffectsController;
        }
        View view8 = view5;
        boolean z3 = false;
        ArrayList arrayList3 = new ArrayList();
        Object obj2 = null;
        Object obj3 = null;
        for (TransitionInfo transitionInfo3 : list) {
            if (transitionInfo3.c()) {
                hashMap.put(transitionInfo3.a(), Boolean.valueOf(z3));
                transitionInfo3.d();
            } else {
                Object cloneTransition = fragmentTransitionImpl2.cloneTransition(transitionInfo3.e());
                SpecialEffectsController.Operation a4 = transitionInfo3.a();
                boolean z4 = obj != null && (a4 == operation4 || a4 == operation5);
                if (cloneTransition != null) {
                    final ArrayList<View> arrayList4 = new ArrayList<>();
                    defaultSpecialEffectsController2.a(arrayList4, a4.getFragment().mView);
                    if (z4) {
                        if (a4 == operation4) {
                            arrayList4.removeAll(arrayList);
                        } else {
                            arrayList4.removeAll(arrayList2);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        fragmentTransitionImpl2.addTarget(cloneTransition, view);
                    } else {
                        fragmentTransitionImpl2.addTargets(cloneTransition, arrayList4);
                        fragmentTransitionImpl2.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList4, null, null, null, null);
                        if (a4.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(a4);
                            ArrayList<View> arrayList5 = new ArrayList<>(arrayList4);
                            arrayList5.remove(a4.getFragment().mView);
                            fragmentTransitionImpl2.scheduleHideFragmentView(cloneTransition, a4.getFragment().mView, arrayList5);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.a(arrayList4, 4);
                                }
                            });
                        }
                    }
                    if (a4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList3.addAll(arrayList4);
                        if (z2) {
                            fragmentTransitionImpl2.setEpicenter(cloneTransition, rect);
                        }
                    } else {
                        fragmentTransitionImpl2.setEpicenter(cloneTransition, view8);
                    }
                    hashMap.put(a4, true);
                    if (transitionInfo3.f()) {
                        obj2 = fragmentTransitionImpl2.mergeTransitionsTogether(obj2, cloneTransition, null);
                    } else {
                        obj3 = fragmentTransitionImpl2.mergeTransitionsTogether(obj3, cloneTransition, null);
                    }
                } else if (!z4) {
                    hashMap.put(a4, Boolean.valueOf(z3));
                    transitionInfo3.d();
                }
                z3 = false;
            }
        }
        Object mergeTransitionsInSequence = fragmentTransitionImpl2.mergeTransitionsInSequence(obj2, obj3, obj);
        for (final TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.c()) {
                Object e = transitionInfo4.e();
                SpecialEffectsController.Operation a5 = transitionInfo4.a();
                boolean z5 = obj != null && (a5 == operation4 || a5 == operation5);
                if (e != null || z5) {
                    if (ViewCompat.isLaidOut(getContainer())) {
                        fragmentTransitionImpl2.setListenerForTransitionEnd(transitionInfo4.a().getFragment(), mergeTransitionsInSequence, transitionInfo4.b(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                            @Override // java.lang.Runnable
                            public void run() {
                                transitionInfo4.d();
                            }
                        });
                    } else {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + a5);
                        }
                        transitionInfo4.d();
                    }
                }
            }
        }
        if (ViewCompat.isLaidOut(getContainer())) {
            FragmentTransition.a(arrayList3, 4);
            ArrayList<String> a6 = fragmentTransitionImpl2.a(arrayList2);
            fragmentTransitionImpl2.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
            fragmentTransitionImpl2.a(getContainer(), arrayList, arrayList2, a6, arrayMap);
            FragmentTransition.a(arrayList3, 0);
            fragmentTransitionImpl2.swapSharedElementTargets(obj, arrayList, arrayList2);
            return hashMap;
        }
        return hashMap;
    }

    private void a(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z, Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.c()) {
                animationInfo.d();
            } else {
                FragmentAnim.AnimationOrAnimator a2 = animationInfo.a(context);
                if (a2 == null) {
                    animationInfo.d();
                } else {
                    final Animator animator = a2.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation a3 = animationInfo.a();
                        Fragment fragment = a3.getFragment();
                        if (Boolean.TRUE.equals(map.get(a3))) {
                            if (FragmentManager.a(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.d();
                        } else {
                            boolean z3 = a3.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(a3);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            final boolean z4 = z3;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z4) {
                                        a3.getFinalState().b(view);
                                    }
                                    animationInfo.d();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.b().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation a4 = animationInfo2.a();
            Fragment fragment2 = a4.getFragment();
            if (z) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.d();
            } else if (z2) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.d();
            } else {
                final View view2 = fragment2.mView;
                Animation animation = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.a(context))).animation);
                if (a4.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    animationInfo2.d();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    container.endViewTransition(view2);
                                    animationInfo2.d();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.b().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.d();
                    }
                });
            }
        }
    }

    void a(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    void a(SpecialEffectsController.Operation operation) {
        operation.getFinalState().b(operation.getFragment().mView);
    }

    void a(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                a(arrayList, childAt);
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void a(List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(operation3.getFragment().mView);
            int i = AnonymousClass10.f2858a[operation3.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (a2 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && a2 != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.a(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.a(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.a(operation4);
                            }
                        }
                    });
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.a(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> a3 = a(arrayList2, arrayList3, z, operation, operation2);
        a(arrayList, arrayList3, a3.containsValue(true), a3);
        for (SpecialEffectsController.Operation operation5 : arrayList3) {
            a(operation5);
        }
        arrayList3.clear();
    }

    void a(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                a(map, childAt);
            }
            i = i2 + 1;
        }
    }
}
