package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.alipay.sdk.util.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat.class */
public final class WindowInsetsAnimationCompat {

    /* renamed from: a  reason: collision with root package name */
    private Impl f2685a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$BoundsCompat.class */
    public static final class BoundsCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Insets f2686a;
        private final Insets b;

        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.f2686a = Impl30.getLowerBounds(bounds);
            this.b = Impl30.getHigherBounds(bounds);
        }

        public BoundsCompat(Insets insets, Insets insets2) {
            this.f2686a = insets;
            this.b = insets2;
        }

        public static BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public Insets getLowerBound() {
            return this.f2686a;
        }

        public Insets getUpperBound() {
            return this.b;
        }

        public BoundsCompat inset(Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.a(this.f2686a, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.a(this.b, insets.left, insets.top, insets.right, insets.bottom));
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f2686a + " upper=" + this.b + i.d;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Callback.class */
    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;

        /* renamed from: a  reason: collision with root package name */
        WindowInsets f2687a;
        private final int b;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Callback$DispatchMode.class */
        public @interface DispatchMode {
        }

        public Callback(int i) {
            this.b = i;
        }

        public final int getDispatchMode() {
            return this.b;
        }

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list);

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Impl.class */
    public static class Impl {

        /* renamed from: a  reason: collision with root package name */
        private final int f2688a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private final Interpolator f2689c;
        private final long d;
        private float e;

        Impl(int i, Interpolator interpolator, long j) {
            this.f2688a = i;
            this.f2689c = interpolator;
            this.d = j;
        }

        public float getAlpha() {
            return this.e;
        }

        public long getDurationMillis() {
            return this.d;
        }

        public float getFraction() {
            return this.b;
        }

        public float getInterpolatedFraction() {
            Interpolator interpolator = this.f2689c;
            return interpolator != null ? interpolator.getInterpolation(this.b) : this.b;
        }

        public Interpolator getInterpolator() {
            return this.f2689c;
        }

        public int getTypeMask() {
            return this.f2688a;
        }

        public void setAlpha(float f) {
            this.e = f;
        }

        public void setFraction(float f) {
            this.b = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Impl21.class */
    public static class Impl21 extends Impl {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.class */
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            final Callback f2690a;
            private WindowInsetsCompat b;

            Impl21OnApplyWindowInsetsListener(View view, Callback callback) {
                this.f2690a = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                this.b = rootWindowInsets != null ? new WindowInsetsCompat.Builder(rootWindowInsets).build() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                final int a2;
                if (!view.isLaidOut()) {
                    this.b = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return Impl21.a(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                if (this.b == null) {
                    this.b = ViewCompat.getRootWindowInsets(view);
                }
                if (this.b == null) {
                    this.b = windowInsetsCompat;
                    return Impl21.a(view, windowInsets);
                }
                Callback a3 = Impl21.a(view);
                if ((a3 == null || !Objects.equals(a3.f2687a, windowInsets)) && (a2 = Impl21.a(windowInsetsCompat, this.b)) != 0) {
                    final WindowInsetsCompat windowInsetsCompat2 = this.b;
                    final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(a2, new DecelerateInterpolator(), 160L);
                    windowInsetsAnimationCompat.setFraction(0.0f);
                    final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                    final BoundsCompat a4 = Impl21.a(windowInsetsCompat, windowInsetsCompat2, a2);
                    Impl21.a(view, windowInsetsAnimationCompat, windowInsets, false);
                    duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            windowInsetsAnimationCompat.setFraction(valueAnimator.getAnimatedFraction());
                            Impl21.a(view, Impl21.a(windowInsetsCompat, windowInsetsCompat2, windowInsetsAnimationCompat.getInterpolatedFraction(), a2), Collections.singletonList(windowInsetsAnimationCompat));
                        }
                    });
                    duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            windowInsetsAnimationCompat.setFraction(1.0f);
                            Impl21.a(view, windowInsetsAnimationCompat);
                        }
                    });
                    OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Impl21.a(view, windowInsetsAnimationCompat, a4);
                            duration.start();
                        }
                    });
                    this.b = windowInsetsCompat;
                    return Impl21.a(view, windowInsets);
                }
                return Impl21.a(view, windowInsets);
            }
        }

        Impl21(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        static int a(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int i = 1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i > 256) {
                    return i3;
                }
                int i4 = i3;
                if (!windowInsetsCompat.getInsets(i).equals(windowInsetsCompat2.getInsets(i))) {
                    i4 = i3 | i;
                }
                i <<= 1;
                i2 = i4;
            }
        }

        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static BoundsCompat a(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i) {
            Insets insets = windowInsetsCompat.getInsets(i);
            Insets insets2 = windowInsetsCompat2.getInsets(i);
            return new BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
        }

        static Callback a(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f2690a;
            }
            return null;
        }

        static WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int i) {
            Insets insets;
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 > 256) {
                    return builder.build();
                }
                if ((i & i3) == 0) {
                    builder.setInsets(i3, windowInsetsCompat.getInsets(i3));
                } else {
                    Insets insets2 = windowInsetsCompat.getInsets(i3);
                    float f2 = insets2.left - windowInsetsCompat2.getInsets(i3).left;
                    float f3 = 1.0f - f;
                    builder.setInsets(i3, WindowInsetsCompat.a(insets2, (int) ((f2 * f3) + 0.5d), (int) (((insets2.top - insets.top) * f3) + 0.5d), (int) (((insets2.right - insets.right) * f3) + 0.5d), (int) (((insets2.bottom - insets.bottom) * f3) + 0.5d)));
                }
                i2 = i3 << 1;
            }
        }

        static void a(View view, Callback callback) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener b = b(view, callback);
            view.setTag(R.id.tag_window_insets_animation_callback, b);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(b);
            }
        }

        static void a(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback a2 = a(view);
            if (a2 != null) {
                a2.onEnd(windowInsetsAnimationCompat);
                if (a2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (!(view instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    return;
                }
                a(viewGroup.getChildAt(i2), windowInsetsAnimationCompat);
                i = i2 + 1;
            }
        }

        static void a(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Callback a2 = a(view);
            boolean z2 = z;
            if (a2 != null) {
                a2.f2687a = windowInsets;
                z2 = z;
                if (!z) {
                    a2.onPrepare(windowInsetsAnimationCompat);
                    z2 = a2.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    a(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z2);
                }
            }
        }

        static void a(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback a2 = a(view);
            if (a2 != null) {
                a2.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (a2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (!(view instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    return;
                }
                a(viewGroup.getChildAt(i2), windowInsetsAnimationCompat, boundsCompat);
                i = i2 + 1;
            }
        }

        static void a(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            Callback a2 = a(view);
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            if (a2 != null) {
                windowInsetsCompat2 = a2.onProgress(windowInsetsCompat, list);
                if (a2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (!(view instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    return;
                }
                a(viewGroup.getChildAt(i2), windowInsetsCompat2, list);
                i = i2 + 1;
            }
        }

        private static View.OnApplyWindowInsetsListener b(View view, Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Impl30.class */
    public static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsAnimation f2697a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/WindowInsetsAnimationCompat$Impl30$ProxyCallback.class */
        public static class ProxyCallback extends WindowInsetsAnimation.Callback {

            /* renamed from: a  reason: collision with root package name */
            private final Callback f2698a;
            private List<WindowInsetsAnimationCompat> b;

            /* renamed from: c  reason: collision with root package name */
            private ArrayList<WindowInsetsAnimationCompat> f2699c;
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> d;

            ProxyCallback(Callback callback) {
                super(callback.getDispatchMode());
                this.d = new HashMap<>();
                this.f2698a = callback;
            }

            private WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.d.get(windowInsetsAnimation);
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                if (windowInsetsAnimationCompat == null) {
                    windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.a(windowInsetsAnimation);
                    this.d.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                }
                return windowInsetsAnimationCompat2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f2698a.onEnd(a(windowInsetsAnimation));
                this.d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f2698a.onPrepare(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.f2699c;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.f2699c = arrayList2;
                    this.b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                int size = list.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        return this.f2698a.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.b).toWindowInsets();
                    }
                    WindowInsetsAnimation windowInsetsAnimation = list.get(i);
                    WindowInsetsAnimationCompat a2 = a(windowInsetsAnimation);
                    a2.setFraction(windowInsetsAnimation.getFraction());
                    this.f2699c.add(a2);
                    size = i;
                }
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f2698a.onStart(a(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        Impl30(int i, Interpolator interpolator, long j) {
            this(new WindowInsetsAnimation(i, interpolator, j));
        }

        Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f2697a = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds createPlatformBounds(BoundsCompat boundsCompat) {
            return new WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new ProxyCallback(callback) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            return this.f2697a.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            return this.f2697a.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            return this.f2697a.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public Interpolator getInterpolator() {
            return this.f2697a.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            return this.f2697a.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float f) {
            this.f2697a.setFraction(f);
        }
    }

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2685a = new Impl30(i, interpolator, j);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f2685a = new Impl21(i, interpolator, j);
        } else {
            this.f2685a = new Impl(0, interpolator, j);
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2685a = new Impl30(windowInsetsAnimation);
        }
    }

    static WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setCallback(view, callback);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Impl21.a(view, callback);
        }
    }

    public float getAlpha() {
        return this.f2685a.getAlpha();
    }

    public long getDurationMillis() {
        return this.f2685a.getDurationMillis();
    }

    public float getFraction() {
        return this.f2685a.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.f2685a.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.f2685a.getInterpolator();
    }

    public int getTypeMask() {
        return this.f2685a.getTypeMask();
    }

    public void setAlpha(float f) {
        this.f2685a.setAlpha(f);
    }

    public void setFraction(float f) {
        this.f2685a.setFraction(f);
    }
}
