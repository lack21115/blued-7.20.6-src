package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/PopupWindowCompat.class */
public final class PopupWindowCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2706a;
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2707c;
    private static boolean d;
    private static Field e;
    private static boolean f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/PopupWindowCompat$Api19Impl.class */
    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/PopupWindowCompat$Api23Impl.class */
    static class Api23Impl {
        private Api23Impl() {
        }

        static void a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        static void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(popupWindow);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!f) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    return ((Boolean) field.get(popupWindow)).booleanValue();
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e3);
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(popupWindow);
        }
        if (!d) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                f2707c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e2) {
            }
            d = true;
        }
        Method method = f2707c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception e3) {
                return 0;
            }
        }
        return 0;
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(popupWindow, z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!f) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(popupWindow, i);
            return;
        }
        if (!b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f2706a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e2) {
            }
            b = true;
        }
        Method method = f2706a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception e3) {
            }
        }
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.a(popupWindow, view, i, i2, i3);
            return;
        }
        int i4 = i;
        if ((GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
            i4 = i - (popupWindow.getWidth() - view.getWidth());
        }
        popupWindow.showAsDropDown(view, i4, i2);
    }
}
