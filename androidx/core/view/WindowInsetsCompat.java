package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat.class */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;

    /* renamed from: a  reason: collision with root package name */
    private final Impl f2654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Api21ReflectionHolder.class */
    public static class Api21ReflectionHolder {

        /* renamed from: a  reason: collision with root package name */
        private static Field f2655a;
        private static Field b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f2656c;
        private static boolean d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2655a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2656c = declaredField3;
                declaredField3.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        private Api21ReflectionHolder() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            if (d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2655a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) b.get(obj);
                        Rect rect2 = (Rect) f2656c.get(obj);
                        if (rect == null || rect2 == null) {
                            return null;
                        }
                        WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                        build.a(build);
                        build.a(view.getRootView());
                        return build;
                    }
                    return null;
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderImpl f2657a;

        public Builder() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2657a = new BuilderImpl30();
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.f2657a = new BuilderImpl29();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f2657a = new BuilderImpl20();
            } else {
                this.f2657a = new BuilderImpl();
            }
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2657a = new BuilderImpl30(windowInsetsCompat);
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.f2657a = new BuilderImpl29(windowInsetsCompat);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f2657a = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.f2657a = new BuilderImpl(windowInsetsCompat);
            }
        }

        public WindowInsetsCompat build() {
            return this.f2657a.b();
        }

        public Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
            this.f2657a.a(displayCutoutCompat);
            return this;
        }

        public Builder setInsets(int i, Insets insets) {
            this.f2657a.a(i, insets);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int i, Insets insets) {
            this.f2657a.b(i, insets);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(Insets insets) {
            this.f2657a.c(insets);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(Insets insets) {
            this.f2657a.e(insets);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(Insets insets) {
            this.f2657a.b(insets);
            return this;
        }

        @Deprecated
        public Builder setSystemWindowInsets(Insets insets) {
            this.f2657a.a(insets);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(Insets insets) {
            this.f2657a.d(insets);
            return this;
        }

        public Builder setVisible(int i, boolean z) {
            this.f2657a.a(i, z);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$BuilderImpl.class */
    public static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        Insets[] f2658a;
        private final WindowInsetsCompat b;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.b = windowInsetsCompat;
        }

        protected final void a() {
            Insets[] insetsArr = this.f2658a;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.a(1)];
                Insets insets2 = this.f2658a[Type.a(2)];
                Insets insets3 = insets2;
                if (insets2 == null) {
                    insets3 = this.b.getInsets(2);
                }
                Insets insets4 = insets;
                if (insets == null) {
                    insets4 = this.b.getInsets(1);
                }
                a(Insets.max(insets4, insets3));
                Insets insets5 = this.f2658a[Type.a(16)];
                if (insets5 != null) {
                    b(insets5);
                }
                Insets insets6 = this.f2658a[Type.a(32)];
                if (insets6 != null) {
                    c(insets6);
                }
                Insets insets7 = this.f2658a[Type.a(64)];
                if (insets7 != null) {
                    d(insets7);
                }
            }
        }

        void a(int i, Insets insets) {
            if (this.f2658a == null) {
                this.f2658a = new Insets[9];
            }
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 > 256) {
                    return;
                }
                if ((i & i3) != 0) {
                    this.f2658a[Type.a(i3)] = insets;
                }
                i2 = i3 << 1;
            }
        }

        void a(int i, boolean z) {
        }

        void a(Insets insets) {
        }

        void a(DisplayCutoutCompat displayCutoutCompat) {
        }

        WindowInsetsCompat b() {
            a();
            return this.b;
        }

        void b(int i, Insets insets) {
            if (i == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        void b(Insets insets) {
        }

        void c(Insets insets) {
        }

        void d(Insets insets) {
        }

        void e(Insets insets) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$BuilderImpl20.class */
    static class BuilderImpl20 extends BuilderImpl {
        private static Field b;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f2659c = false;
        private static Constructor<WindowInsets> d;
        private static boolean e = false;
        private WindowInsets f;
        private Insets g;

        BuilderImpl20() {
            this.f = c();
        }

        BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f = windowInsetsCompat.toWindowInsets();
        }

        private static WindowInsets c() {
            if (!f2659c) {
                try {
                    b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f2659c = true;
            }
            Field field = b;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!e) {
                try {
                    d = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                e = true;
            }
            Constructor<WindowInsets> constructor = d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                    return null;
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void a(Insets insets) {
            WindowInsets windowInsets = this.f;
            if (windowInsets != null) {
                this.f = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f);
            windowInsetsCompat.a(this.f2658a);
            windowInsetsCompat.a(this.g);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(Insets insets) {
            this.g = insets;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$BuilderImpl29.class */
    static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder b;

        BuilderImpl29() {
            this.b = new WindowInsets.Builder();
        }

        BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            this.b = windowInsets != null ? new WindowInsets.Builder(windowInsets) : new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void a(Insets insets) {
            this.b.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void a(DisplayCutoutCompat displayCutoutCompat) {
            this.b.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.a() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.b.build());
            windowInsetsCompat.a(this.f2658a);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void b(Insets insets) {
            this.b.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void c(Insets insets) {
            this.b.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void d(Insets insets) {
            this.b.setTappableElementInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(Insets insets) {
            this.b.setStableInsets(insets.toPlatformInsets());
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$BuilderImpl30.class */
    static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void a(int i, Insets insets) {
            this.b.setInsets(TypeImpl30.a(i), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void a(int i, boolean z) {
            this.b.setVisible(TypeImpl30.a(i), z);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void b(int i, Insets insets) {
            this.b.setInsetsIgnoringVisibility(TypeImpl30.a(i), insets.toPlatformInsets());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl.class */
    public static class Impl {

        /* renamed from: a  reason: collision with root package name */
        static final WindowInsetsCompat f2660a = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final WindowInsetsCompat b;

        Impl(WindowInsetsCompat windowInsetsCompat) {
            this.b = windowInsetsCompat;
        }

        WindowInsetsCompat a(int i, int i2, int i3, int i4) {
            return f2660a;
        }

        void a(View view) {
        }

        void a(Insets insets) {
        }

        void a(WindowInsetsCompat windowInsetsCompat) {
        }

        boolean a() {
            return false;
        }

        void b(WindowInsetsCompat windowInsetsCompat) {
        }

        boolean b() {
            return false;
        }

        WindowInsetsCompat c() {
            return this.b;
        }

        WindowInsetsCompat d() {
            return this.b;
        }

        DisplayCutoutCompat e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl) {
                Impl impl = (Impl) obj;
                return a() == impl.a() && b() == impl.b() && ObjectsCompat.equals(g(), impl.g()) && ObjectsCompat.equals(h(), impl.h()) && ObjectsCompat.equals(e(), impl.e());
            }
            return false;
        }

        WindowInsetsCompat f() {
            return this.b;
        }

        Insets g() {
            return Insets.NONE;
        }

        Insets getInsets(int i) {
            return Insets.NONE;
        }

        Insets getInsetsIgnoringVisibility(int i) {
            if ((i & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        Insets h() {
            return Insets.NONE;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }

        Insets i() {
            return g();
        }

        boolean isVisible(int i) {
            return true;
        }

        Insets j() {
            return g();
        }

        Insets k() {
            return g();
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl20.class */
    public static class Impl20 extends Impl {
        private static boolean e = false;
        private static Method f;
        private static Class<?> g;
        private static Field h;
        private static Field i;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f2661c;
        Insets d;
        private Insets[] j;
        private Insets k;
        private WindowInsetsCompat l;

        Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.k = null;
            this.f2661c = windowInsets;
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f2661c));
        }

        private Insets b(int i2, boolean z) {
            Insets insets = Insets.NONE;
            int i3 = 1;
            while (true) {
                int i4 = i3;
                if (i4 > 256) {
                    return insets;
                }
                if ((i2 & i4) != 0) {
                    insets = Insets.max(insets, a(i4, z));
                }
                i3 = i4 << 1;
            }
        }

        private Insets b(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!e) {
                    m();
                }
                Method method = f;
                if (method == null || g == null || h == null) {
                    return null;
                }
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) h.get(i.get(invoke));
                    Insets insets = null;
                    if (rect != null) {
                        insets = Insets.of(rect);
                    }
                    return insets;
                } catch (ReflectiveOperationException e2) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    return null;
                }
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private Insets l() {
            WindowInsetsCompat windowInsetsCompat = this.l;
            return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : Insets.NONE;
        }

        private static void m() {
            try {
                f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                g = cls;
                h = cls.getDeclaredField("mVisibleInsets");
                i = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                h.setAccessible(true);
                i.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            e = true;
        }

        protected Insets a(int i2, boolean z) {
            if (i2 == 1) {
                return z ? Insets.of(0, Math.max(l().top, g().top), 0, 0) : Insets.of(0, g().top, 0, 0);
            }
            Insets insets = null;
            if (i2 == 2) {
                if (z) {
                    Insets l = l();
                    Insets h2 = h();
                    return Insets.of(Math.max(l.left, h2.left), 0, Math.max(l.right, h2.right), Math.max(l.bottom, h2.bottom));
                }
                Insets g2 = g();
                WindowInsetsCompat windowInsetsCompat = this.l;
                if (windowInsetsCompat != null) {
                    insets = windowInsetsCompat.getStableInsets();
                }
                int i3 = g2.bottom;
                int i4 = i3;
                if (insets != null) {
                    i4 = Math.min(i3, insets.bottom);
                }
                return Insets.of(g2.left, 0, g2.right, i4);
            } else if (i2 != 8) {
                if (i2 != 16) {
                    if (i2 != 32) {
                        if (i2 != 64) {
                            if (i2 != 128) {
                                return Insets.NONE;
                            }
                            WindowInsetsCompat windowInsetsCompat2 = this.l;
                            DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : e();
                            return displayCutout != null ? Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : Insets.NONE;
                        }
                        return k();
                    }
                    return j();
                }
                return i();
            } else {
                Insets[] insetsArr = this.j;
                Insets insets2 = null;
                if (insetsArr != null) {
                    insets2 = insetsArr[Type.a(8)];
                }
                if (insets2 != null) {
                    return insets2;
                }
                Insets g3 = g();
                Insets l2 = l();
                if (g3.bottom > l2.bottom) {
                    return Insets.of(0, 0, 0, g3.bottom);
                }
                Insets insets3 = this.d;
                return (insets3 == null || insets3.equals(Insets.NONE) || this.d.bottom <= l2.bottom) ? Insets.NONE : Insets.of(0, 0, 0, this.d.bottom);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat a(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f2661c));
            builder.setSystemWindowInsets(WindowInsetsCompat.a(g(), i2, i3, i4, i5));
            builder.setStableInsets(WindowInsetsCompat.a(h(), i2, i3, i4, i5));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void a(View view) {
            Insets b = b(view);
            Insets insets = b;
            if (b == null) {
                insets = Insets.NONE;
            }
            a(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void a(Insets insets) {
            this.d = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void a(WindowInsetsCompat windowInsetsCompat) {
            this.l = windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean a() {
            return this.f2661c.isRound();
        }

        protected boolean a(int i2) {
            if (i2 != 1 && i2 != 2) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 != 8 && i2 != 128) {
                    return true;
                }
            }
            return !a(i2, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void b(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.a(this.l);
            windowInsetsCompat.b(this.d);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.d, ((Impl20) obj).d);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets g() {
            if (this.k == null) {
                this.k = Insets.of(this.f2661c.getSystemWindowInsetLeft(), this.f2661c.getSystemWindowInsetTop(), this.f2661c.getSystemWindowInsetRight(), this.f2661c.getSystemWindowInsetBottom());
            }
            return this.k;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int i2) {
            return b(i2, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int i2) {
            return b(i2, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isVisible(int i2) {
            int i3 = 1;
            while (true) {
                int i4 = i3;
                if (i4 > 256) {
                    return true;
                }
                if ((i2 & i4) != 0 && !a(i4)) {
                    return false;
                }
                i3 = i4 << 1;
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
            this.j = insetsArr;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl21.class */
    static class Impl21 extends Impl20 {
        private Insets e;

        Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.e = null;
        }

        Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.e = null;
            this.e = impl21.e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean b() {
            return this.f2661c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2661c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat d() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2661c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets h() {
            if (this.e == null) {
                this.e = Insets.of(this.f2661c.getStableInsetLeft(), this.f2661c.getStableInsetTop(), this.f2661c.getStableInsetRight(), this.f2661c.getStableInsetBottom());
            }
            return this.e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
            this.e = insets;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl28.class */
    static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        DisplayCutoutCompat e() {
            return DisplayCutoutCompat.a(this.f2661c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl28) {
                Impl28 impl28 = (Impl28) obj;
                return Objects.equals(this.f2661c, impl28.f2661c) && Objects.equals(this.d, impl28.d);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat f() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2661c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.f2661c.hashCode();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl29.class */
    static class Impl29 extends Impl28 {
        private Insets e;
        private Insets f;
        private Insets g;

        Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat a(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2661c.inset(i, i2, i3, i4));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets i() {
            if (this.e == null) {
                this.e = Insets.toCompatInsets(this.f2661c.getSystemGestureInsets());
            }
            return this.e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets j() {
            if (this.f == null) {
                this.f = Insets.toCompatInsets(this.f2661c.getMandatorySystemGestureInsets());
            }
            return this.f;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets k() {
            if (this.g == null) {
                this.g = Insets.toCompatInsets(this.f2661c.getTappableElementInsets());
            }
            return this.g;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Impl30.class */
    static class Impl30 extends Impl29 {
        static final WindowInsetsCompat e = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void a(View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int i) {
            return Insets.toCompatInsets(this.f2661c.getInsets(TypeImpl30.a(i)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int i) {
            return Insets.toCompatInsets(this.f2661c.getInsetsIgnoringVisibility(TypeImpl30.a(i)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int i) {
            return this.f2661c.isVisible(TypeImpl30.a(i));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Type.class */
    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$Type$InsetsType.class */
        public @interface InsetsType {
        }

        private Type() {
        }

        static int a() {
            return -1;
        }

        static int a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsCompat$TypeImpl30.class */
    static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int a(int i) {
            int statusBars;
            int i2 = 0;
            int i3 = 1;
            while (i3 <= 256) {
                int i4 = i2;
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 != 128) {
                        i4 = i2;
                    } else {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i4 = i2 | statusBars;
                }
                i3 <<= 1;
                i2 = i4;
            }
            return i2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.e;
        } else {
            CONSUMED = Impl.f2660a;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2654a = new Impl30(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2654a = new Impl29(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.f2654a = new Impl28(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f2654a = new Impl21(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f2654a = new Impl20(this, windowInsets);
        } else {
            this.f2654a = new Impl(this);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            this.f2654a = new Impl(this);
            return;
        }
        Impl impl = windowInsetsCompat.f2654a;
        if (Build.VERSION.SDK_INT >= 30 && (impl instanceof Impl30)) {
            this.f2654a = new Impl30(this, (Impl30) impl);
        } else if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
            this.f2654a = new Impl29(this, (Impl29) impl);
        } else if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
            this.f2654a = new Impl28(this, (Impl28) impl);
        } else if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
            this.f2654a = new Impl21(this, (Impl21) impl);
        } else if (Build.VERSION.SDK_INT < 20 || !(impl instanceof Impl20)) {
            this.f2654a = new Impl(this);
        } else {
            this.f2654a = new Impl20(this, (Impl20) impl);
        }
        impl.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Insets a(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.left - i);
        int max2 = Math.max(0, insets.top - i2);
        int max3 = Math.max(0, insets.right - i3);
        int max4 = Math.max(0, insets.bottom - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? insets : Insets.of(max, max2, max3, max4);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            windowInsetsCompat.a(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.a(view.getRootView());
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        this.f2654a.a(view);
    }

    void a(Insets insets) {
        this.f2654a.setStableInsets(insets);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(WindowInsetsCompat windowInsetsCompat) {
        this.f2654a.a(windowInsetsCompat);
    }

    void a(Insets[] insetsArr) {
        this.f2654a.setOverriddenInsets(insetsArr);
    }

    void b(Insets insets) {
        this.f2654a.a(insets);
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.f2654a.f();
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.f2654a.d();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.f2654a.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.equals(this.f2654a, ((WindowInsetsCompat) obj).f2654a);
        }
        return false;
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.f2654a.e();
    }

    public Insets getInsets(int i) {
        return this.f2654a.getInsets(i);
    }

    public Insets getInsetsIgnoringVisibility(int i) {
        return this.f2654a.getInsetsIgnoringVisibility(i);
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.f2654a.j();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.f2654a.h().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.f2654a.h().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.f2654a.h().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.f2654a.h().top;
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.f2654a.h();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.f2654a.i();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.f2654a.g().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.f2654a.g().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.f2654a.g().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.f2654a.g().top;
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.f2654a.g();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.f2654a.k();
    }

    public boolean hasInsets() {
        return (getInsets(Type.a()).equals(Insets.NONE) && getInsetsIgnoringVisibility(Type.a() ^ Type.ime()).equals(Insets.NONE) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.f2654a.h().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.f2654a.g().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.f2654a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        return this.f2654a.a(i, i2, i3, i4);
    }

    public WindowInsetsCompat inset(Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.f2654a.b();
    }

    public boolean isRound() {
        return this.f2654a.a();
    }

    public boolean isVisible(int i) {
        return this.f2654a.isVisible(i);
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i, i2, i3, i4)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public WindowInsets toWindowInsets() {
        Impl impl = this.f2654a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f2661c;
        }
        return null;
    }
}
