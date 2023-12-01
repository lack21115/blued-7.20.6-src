package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/CanvasUtils.class */
class CanvasUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Method f3407a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3408c;

    private CanvasUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Canvas canvas, boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (Build.VERSION.SDK_INT == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        } else {
            if (!f3408c) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    f3407a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                f3408c = true;
            }
            if (z) {
                try {
                    if (f3407a != null) {
                        f3407a.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException e2) {
                    return;
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3.getCause());
                }
            }
            if (z || b == null) {
                return;
            }
            b.invoke(canvas, new Object[0]);
        }
    }
}
