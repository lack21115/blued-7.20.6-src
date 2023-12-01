package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/ImmLeaksCleaner.class */
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    private static int f1444a;
    private static Field b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f1445c;
    private static Field d;
    private Activity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.e = activity;
    }

    private static void a() {
        try {
            f1444a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f1445c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            d = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            b = declaredField3;
            declaredField3.setAccessible(true);
            f1444a = 1;
        } catch (NoSuchFieldException e) {
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f1444a == 0) {
            a();
        }
        if (f1444a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.e.getSystemService(Context.INPUT_METHOD_SERVICE);
            try {
                Object obj = b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) f1445c.get(inputMethodManager);
                        if (view == null) {
                            return;
                        }
                        if (view.isAttachedToWindow()) {
                            return;
                        }
                        try {
                            d.set(inputMethodManager, null);
                            inputMethodManager.isActive();
                        } catch (IllegalAccessException e) {
                        }
                    } catch (ClassCastException e2) {
                    } catch (IllegalAccessException e3) {
                    }
                }
            } catch (IllegalAccessException e4) {
            }
        }
    }
}
