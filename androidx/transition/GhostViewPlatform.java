package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/GhostViewPlatform.class */
class GhostViewPlatform implements GhostView {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f3449a;
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3450c;
    private static boolean d;
    private static Method e;
    private static boolean f;
    private final View g;

    private GhostViewPlatform(View view) {
        this.g = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostView a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        Method method = f3450c;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException e2) {
                return null;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        return null;
    }

    private static void a() {
        if (b) {
            return;
        }
        try {
            f3449a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        c();
        Method method = e;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    private static void b() {
        if (d) {
            return;
        }
        try {
            a();
            Method declaredMethod = f3449a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f3450c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        d = true;
    }

    private static void c() {
        if (f) {
            return;
        }
        try {
            a();
            Method declaredMethod = f3449a.getDeclaredMethod("removeGhost", View.class);
            e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f = true;
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }
}
