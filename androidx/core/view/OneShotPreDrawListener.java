package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/OneShotPreDrawListener.class */
public final class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f2604a;
    private ViewTreeObserver b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f2605c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f2604a = view;
        this.b = view.getViewTreeObserver();
        this.f2605c = runnable;
    }

    public static OneShotPreDrawListener add(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
                view.addOnAttachStateChangeListener(oneShotPreDrawListener);
                return oneShotPreDrawListener;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.f2605c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        removeListener();
    }

    public void removeListener() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.f2604a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2604a.removeOnAttachStateChangeListener(this);
    }
}
