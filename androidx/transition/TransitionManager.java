package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionManager.class */
public class TransitionManager {

    /* renamed from: c  reason: collision with root package name */
    private ArrayMap<Scene, Transition> f3428c = new ArrayMap<>();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> d = new ArrayMap<>();
    private static Transition b = new AutoTransition();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> e = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f3427a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionManager$MultiListener.class */
    public static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f3429a;
        ViewGroup b;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f3429a = transition;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<Transition> arrayList;
            a();
            if (TransitionManager.f3427a.remove(this.b)) {
                final ArrayMap<ViewGroup, ArrayList<Transition>> a2 = TransitionManager.a();
                ArrayList<Transition> arrayList2 = a2.get(this.b);
                ArrayList arrayList3 = null;
                if (arrayList2 == null) {
                    arrayList = new ArrayList<>();
                    a2.put(this.b, arrayList);
                } else {
                    arrayList = arrayList2;
                    if (arrayList2.size() > 0) {
                        arrayList3 = new ArrayList(arrayList2);
                        arrayList = arrayList2;
                    }
                }
                arrayList.add(this.f3429a);
                this.f3429a.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        ((ArrayList) a2.get(MultiListener.this.b)).remove(transition);
                        transition.removeListener(this);
                    }
                });
                this.f3429a.captureValues(this.b, false);
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).resume(this.b);
                    }
                }
                this.f3429a.playTransition(this.b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f3427a.remove(this.b);
            ArrayList<Transition> arrayList = TransitionManager.a().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.b);
                }
            }
            this.f3429a.clearValues(true);
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> a() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = e.get();
        if (weakReference == null || (arrayMap = weakReference.get()) == null) {
            ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
            e.set(new WeakReference<>(arrayMap2));
            return arrayMap2;
        }
        return arrayMap;
    }

    private Transition a(Scene scene) {
        Scene currentScene;
        ArrayMap<Scene, Transition> arrayMap;
        Transition transition;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot == null || (currentScene = Scene.getCurrentScene(sceneRoot)) == null || (arrayMap = this.d.get(scene)) == null || (transition = arrayMap.get(currentScene)) == null) {
            Transition transition2 = this.f3428c.get(scene);
            return transition2 != null ? transition2 : b;
        }
        return transition;
    }

    private static void a(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        MultiListener multiListener = new MultiListener(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    private static void a(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (f3427a.contains(sceneRoot)) {
            return;
        }
        Scene currentScene = Scene.getCurrentScene(sceneRoot);
        if (transition == null) {
            if (currentScene != null) {
                currentScene.exit();
            }
            scene.enter();
            return;
        }
        f3427a.add(sceneRoot);
        Transition mo1493clone = transition.mo1493clone();
        mo1493clone.setSceneRoot(sceneRoot);
        if (currentScene != null && currentScene.a()) {
            mo1493clone.setCanRemoveViews(true);
        }
        b(sceneRoot, mo1493clone);
        scene.enter();
        a(sceneRoot, mo1493clone);
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        Scene currentScene = Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        if (f3427a.contains(viewGroup) || !ViewCompat.isLaidOut(viewGroup)) {
            return;
        }
        f3427a.add(viewGroup);
        Transition transition2 = transition;
        if (transition == null) {
            transition2 = b;
        }
        Transition mo1493clone = transition2.mo1493clone();
        b(viewGroup, mo1493clone);
        Scene.a(viewGroup, null);
        a(viewGroup, mo1493clone);
    }

    public static void endTransitions(ViewGroup viewGroup) {
        f3427a.remove(viewGroup);
        ArrayList<Transition> arrayList = a().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        int size = arrayList2.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            ((Transition) arrayList2.get(i)).forceToEnd(viewGroup);
            size = i;
        }
    }

    public static void go(Scene scene) {
        a(scene, b);
    }

    public static void go(Scene scene, Transition transition) {
        a(scene, transition);
    }

    public void setTransition(Scene scene, Scene scene2, Transition transition) {
        ArrayMap<Scene, Transition> arrayMap = this.d.get(scene2);
        ArrayMap<Scene, Transition> arrayMap2 = arrayMap;
        if (arrayMap == null) {
            arrayMap2 = new ArrayMap<>();
            this.d.put(scene2, arrayMap2);
        }
        arrayMap2.put(scene, transition);
    }

    public void setTransition(Scene scene, Transition transition) {
        this.f3428c.put(scene, transition);
    }

    public void transitionTo(Scene scene) {
        a(scene, a(scene));
    }
}
