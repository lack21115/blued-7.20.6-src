package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewUtils.class */
public class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f3453a;
    static final Property<View, Rect> b;

    /* renamed from: c  reason: collision with root package name */
    private static final ViewUtilsBase f3454c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f3454c = new ViewUtilsApi29();
        } else if (Build.VERSION.SDK_INT >= 23) {
            f3454c = new ViewUtilsApi23();
        } else if (Build.VERSION.SDK_INT >= 22) {
            f3454c = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f3454c = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f3454c = new ViewUtilsApi19();
        } else {
            f3454c = new ViewUtilsBase();
        }
        f3453a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.c(view));
            }

            @Override // android.util.Property
            public void set(View view, Float f) {
                ViewUtils.a(view, f.floatValue());
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    private ViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayImpl a(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewOverlayApi18(view) : ViewOverlayApi14.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f) {
        f3454c.setTransitionAlpha(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i) {
        f3454c.setTransitionVisibility(view, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i, int i2, int i3, int i4) {
        f3454c.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Matrix matrix) {
        f3454c.transformMatrixToGlobal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowIdImpl b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new WindowIdApi18(view) : new WindowIdApi14(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, Matrix matrix) {
        f3454c.transformMatrixToLocal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f3454c.getTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, Matrix matrix) {
        f3454c.setAnimationMatrix(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view) {
        f3454c.saveNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f3454c.clearNonTransitionAlpha(view);
    }
}
