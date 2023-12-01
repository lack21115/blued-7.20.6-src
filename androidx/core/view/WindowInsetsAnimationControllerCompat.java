package androidx.core.view;

import android.os.Build;
import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationControllerCompat.class */
public final class WindowInsetsAnimationControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f2652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationControllerCompat$Impl.class */
    public static class Impl {
        Impl() {
        }

        void a(boolean z) {
        }

        boolean a() {
            return false;
        }

        boolean b() {
            return true;
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        public float getCurrentFraction() {
            return 0.0f;
        }

        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        public boolean isReady() {
            return false;
        }

        public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationControllerCompat$Impl30.class */
    static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsAnimationController f2653a;

        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f2653a = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        void a(boolean z) {
            this.f2653a.finish(z);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean a() {
            return this.f2653a.isFinished();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean b() {
            return this.f2653a.isCancelled();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            return this.f2653a.getCurrentAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.f2653a.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.f2653a.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.f2653a.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.f2653a.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            return this.f2653a.getTypes();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isReady() {
            return this.f2653a.isReady();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(Insets insets, float f, float f2) {
            this.f2653a.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
        }
    }

    WindowInsetsAnimationControllerCompat() {
        if (Build.VERSION.SDK_INT < 30) {
            this.f2652a = new Impl();
            return;
        }
        throw new UnsupportedOperationException("On API 30+, the constructor taking a " + WindowInsetsAnimationController.class.getSimpleName() + " as parameter");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f2652a = new Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean z) {
        this.f2652a.a(z);
    }

    public float getCurrentAlpha() {
        return this.f2652a.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.f2652a.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.f2652a.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.f2652a.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.f2652a.getShownStateInsets();
    }

    public int getTypes() {
        return this.f2652a.getTypes();
    }

    public boolean isCancelled() {
        return this.f2652a.b();
    }

    public boolean isFinished() {
        return this.f2652a.a();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        this.f2652a.setInsetsAndAlpha(insets, f, f2);
    }
}
