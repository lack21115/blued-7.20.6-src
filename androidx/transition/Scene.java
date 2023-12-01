package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/Scene.class */
public class Scene {

    /* renamed from: a  reason: collision with root package name */
    private Context f3462a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f3463c;
    private View d;
    private Runnable e;
    private Runnable f;

    public Scene(ViewGroup viewGroup) {
        this.b = -1;
        this.f3463c = viewGroup;
    }

    private Scene(ViewGroup viewGroup, int i, Context context) {
        this.b = -1;
        this.f3462a = context;
        this.f3463c = viewGroup;
        this.b = i;
    }

    public Scene(ViewGroup viewGroup, View view) {
        this.b = -1;
        this.f3463c = viewGroup;
        this.d = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(R.id.transition_current_scene, scene);
    }

    public static Scene getCurrentScene(ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.transition_current_scene);
    }

    public static Scene getSceneForLayout(ViewGroup viewGroup, int i, Context context) {
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(R.id.transition_scene_layoutid_cache);
        SparseArray sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray();
            viewGroup.setTag(R.id.transition_scene_layoutid_cache, sparseArray2);
        }
        Scene scene = (Scene) sparseArray2.get(i);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i, context);
        sparseArray2.put(i, scene2);
        return scene2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b > 0;
    }

    public void enter() {
        if (this.b > 0 || this.d != null) {
            getSceneRoot().removeAllViews();
            if (this.b > 0) {
                LayoutInflater.from(this.f3462a).inflate(this.b, this.f3463c);
            } else {
                this.f3463c.addView(this.d);
            }
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            runnable.run();
        }
        a(this.f3463c, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.f3463c) != this || (runnable = this.f) == null) {
            return;
        }
        runnable.run();
    }

    public ViewGroup getSceneRoot() {
        return this.f3463c;
    }

    public void setEnterAction(Runnable runnable) {
        this.e = runnable;
    }

    public void setExitAction(Runnable runnable) {
        this.f = runnable;
    }
}
