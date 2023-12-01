package skin.support.utils;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/SkinCompatVersionUtils.class */
public final class SkinCompatVersionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f44248a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f44249c;
    private static Class<?> d;
    private static Method e;
    private static Method f;
    private static Class<?> g;
    private static Method h;

    static {
        try {
            d = Class.forName("androidx.core.graphics.drawable.WrappedDrawable");
        } catch (ClassNotFoundException e2) {
            if (Slog.f44252a) {
                Slog.a("SkinCompatUtils", "hasV4WrappedDrawable = false");
            }
        }
        try {
            f44248a = Class.forName("androidx.core.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException e3) {
            if (Slog.f44252a) {
                Slog.a("SkinCompatUtils", "hasV4DrawableWrapper = false");
            }
        }
        try {
            g = Class.forName("androidx.appcompat.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException e4) {
            if (Slog.f44252a) {
                Slog.a("SkinCompatUtils", "hasV7DrawableWrapper = false");
            }
        }
    }

    public static void a(Drawable drawable, Drawable drawable2) {
        Class<?> cls = d;
        if (cls != null) {
            if (f == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e2) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e3) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable invoke error: " + e3);
                    }
                }
            }
        }
    }

    public static boolean a(Drawable drawable) {
        Class<?> cls = d;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static Drawable b(Drawable drawable) {
        Class<?> cls = d;
        if (cls != null) {
            if (e == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    e = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e2) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = e;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e3) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable invoke error: " + e3);
                    }
                }
            }
        }
        return drawable;
    }

    public static void b(Drawable drawable, Drawable drawable2) {
        Class<?> cls = f44248a;
        if (cls != null) {
            if (f44249c == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f44249c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e2) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f44249c;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e3) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable invoke error: " + e3);
                    }
                }
            }
        }
    }

    public static boolean c(Drawable drawable) {
        Class<?> cls = f44248a;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static Drawable d(Drawable drawable) {
        Class<?> cls = f44248a;
        if (cls != null) {
            if (b == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e2) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = b;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e3) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable invoke error: " + e3);
                    }
                }
            }
        }
        return drawable;
    }

    public static boolean e(Drawable drawable) {
        Class<?> cls = g;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static Drawable f(Drawable drawable) {
        Class<?> cls = g;
        if (cls != null) {
            if (h == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    h = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e2) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV7DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = h;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e3) {
                    if (Slog.f44252a) {
                        Slog.a("SkinCompatUtils", "getV7DrawableWrapperWrappedDrawable invoke error: " + e3);
                    }
                }
            }
        }
        return drawable;
    }
}
