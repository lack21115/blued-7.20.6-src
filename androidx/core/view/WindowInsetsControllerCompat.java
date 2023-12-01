package androidx.core.view;

import android.content.Context;
import android.opengl.GLES30;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.SimpleArrayMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat.class */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Impl f2710a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$Impl.class */
    static class Impl {
        Impl() {
        }

        int a() {
            return 0;
        }

        void a(int i) {
        }

        void a(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void b(int i) {
        }

        void b(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void c(int i) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        public void setAppearanceLightNavigationBars(boolean z) {
        }

        public void setAppearanceLightStatusBars(boolean z) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$Impl20.class */
    static class Impl20 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f2711a;
        private final View b;

        Impl20(Window window, View view) {
            this.f2711a = window;
            this.b = view;
        }

        private void h(int i) {
            if (i == 1) {
                e(4);
                g(1024);
            } else if (i == 2) {
                e(2);
            } else if (i != 8) {
            } else {
                View view = this.b;
                if (view == null || !(view.isInEditMode() || view.onCheckIsTextEditor())) {
                    view = this.f2711a.getCurrentFocus();
                } else {
                    view.requestFocus();
                }
                View view2 = view;
                if (view == null) {
                    view2 = this.f2711a.findViewById(16908290);
                }
                if (view2 == null || !view2.hasWindowFocus()) {
                    return;
                }
                final View view3 = view2;
                view2.post(new Runnable() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((InputMethodManager) view3.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view3, 0);
                    }
                });
            }
        }

        private void i(int i) {
            if (i == 1) {
                d(4);
            } else if (i == 2) {
                d(2);
            } else if (i != 8) {
            } else {
                ((InputMethodManager) this.f2711a.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(this.f2711a.getDecorView().getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int a() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 > 256) {
                    return;
                }
                if ((i & i3) != 0) {
                    h(i3);
                }
                i2 = i3 << 1;
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void b(int i) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 > 256) {
                    return;
                }
                if ((i & i3) != 0) {
                    i(i3);
                }
                i2 = i3 << 1;
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void b(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void c(int i) {
            if (i == 0) {
                e(GLES30.GL_COLOR);
            } else if (i == 1) {
                e(4096);
                d(2048);
            } else if (i != 2) {
            } else {
                e(2048);
                d(4096);
            }
        }

        protected void d(int i) {
            View decorView = this.f2711a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        protected void e(int i) {
            View decorView = this.f2711a.getDecorView();
            decorView.setSystemUiVisibility(i & decorView.getSystemUiVisibility());
        }

        protected void f(int i) {
            this.f2711a.addFlags(i);
        }

        protected void g(int i) {
            this.f2711a.clearFlags(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$Impl23.class */
    static class Impl23 extends Impl20 {
        Impl23(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.f2711a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (!z) {
                e(8192);
                return;
            }
            g(67108864);
            f(Integer.MIN_VALUE);
            d(8192);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$Impl26.class */
    static class Impl26 extends Impl23 {
        Impl26(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.f2711a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (!z) {
                e(16);
                return;
            }
            g(134217728);
            f(Integer.MIN_VALUE);
            d(16);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$Impl30.class */
    static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsControllerCompat f2713a;
        final WindowInsetsController b;

        /* renamed from: c  reason: collision with root package name */
        protected Window f2714c;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> d;

        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat);
            this.f2714c = window;
        }

        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.d = new SimpleArrayMap<>();
            this.b = windowInsetsController;
            this.f2713a = windowInsetsControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int a() {
            return this.b.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i) {
            this.b.show(i);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.b.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.1

                /* renamed from: c  reason: collision with root package name */
                private WindowInsetsAnimationControllerCompat f2716c = null;

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationController == null ? null : this.f2716c);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.f2716c);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i2) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.f2716c = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i2);
                }
            });
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.d.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.2
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
                    if (Impl30.this.b == windowInsetsController) {
                        onControllableInsetsChangedListener.onControllableInsetsChanged(Impl30.this.f2713a, i);
                    }
                }
            };
            this.d.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void b(int i) {
            this.b.hide(i);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void b(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener remove = this.d.remove(onControllableInsetsChangedListener);
            if (remove != null) {
                this.b.removeOnControllableInsetsChangedListener(remove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void c(int i) {
            this.b.setSystemBarsBehavior(i);
        }

        protected void d(int i) {
            View decorView = this.f2714c.getDecorView();
            decorView.setSystemUiVisibility(i & decorView.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                this.b.setSystemBarsAppearance(16, 16);
            } else {
                this.b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (!z) {
                this.b.setSystemBarsAppearance(0, 8);
                return;
            }
            if (this.f2714c != null) {
                d(8192);
            }
            this.b.setSystemBarsAppearance(8, 8);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsControllerCompat$OnControllableInsetsChangedListener.class */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat windowInsetsControllerCompat, int i);
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2710a = new Impl30(window, this);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.f2710a = new Impl26(window, view);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.f2710a = new Impl23(window, view);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f2710a = new Impl20(window, view);
        } else {
            this.f2710a = new Impl();
        }
    }

    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2710a = new Impl30(windowInsetsController, this);
        } else {
            this.f2710a = new Impl();
        }
    }

    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f2710a.a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.f2710a.a(i, j, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.f2710a.a();
    }

    public void hide(int i) {
        this.f2710a.b(i);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.f2710a.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.f2710a.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f2710a.b(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z) {
        this.f2710a.setAppearanceLightNavigationBars(z);
    }

    public void setAppearanceLightStatusBars(boolean z) {
        this.f2710a.setAppearanceLightStatusBars(z);
    }

    public void setSystemBarsBehavior(int i) {
        this.f2710a.c(i);
    }

    public void show(int i) {
        this.f2710a.a(i);
    }
}
