package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat.class */
public final class ResourcesCompat {
    public static final int ID_NULL = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2387a = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2388c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$Api23Impl.class */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static ColorStateList a(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ColorStateListCacheEntry.class */
    public static class ColorStateListCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f2389a;
        final Configuration b;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
            this.f2389a = colorStateList;
            this.b = configuration;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ColorStateListCacheKey.class */
    public static final class ColorStateListCacheKey {

        /* renamed from: a  reason: collision with root package name */
        final Resources f2390a;
        final Resources.Theme b;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.f2390a = resources;
            this.b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.f2390a.equals(colorStateListCacheKey.f2390a) && ObjectsCompat.equals(this.b, colorStateListCacheKey.b);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f2390a, this.b);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$FontCallback.class */
    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            Handler handler2 = handler;
            if (handler == null) {
                handler2 = new Handler(Looper.getMainLooper());
            }
            return handler2;
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ImplApi29.class */
    static class ImplApi29 {
        private ImplApi29() {
        }

        static float a(Resources resources, int i) {
            return resources.getFloat(i);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ThemeCompat.class */
    public static final class ThemeCompat {

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ThemeCompat$ImplApi23.class */
        static class ImplApi23 {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f2393a = new Object();
            private static Method b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f2394c;

            private ImplApi23() {
            }

            static void a(Resources.Theme theme) {
                synchronized (f2393a) {
                    if (!f2394c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        f2394c = true;
                    }
                    if (b != null) {
                        try {
                            b.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            b = null;
                        }
                    }
                }
            }
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ResourcesCompat$ThemeCompat$ImplApi29.class */
        static class ImplApi29 {
            private ImplApi29() {
            }

            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                ImplApi29.a(theme);
            } else if (Build.VERSION.SDK_INT >= 23) {
                ImplApi23.a(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static ColorStateList a(Resources resources, int i, Resources.Theme theme) {
        if (a(resources, i)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList a(ColorStateListCacheKey colorStateListCacheKey, int i) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (f2388c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = b.get(colorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.b.equals(colorStateListCacheKey.f2390a.getConfiguration())) {
                    return colorStateListCacheEntry.f2389a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, fontCallback, handler, z, z2);
        if (a2 == null && fontCallback == null) {
            if (z2) {
                return a2;
            }
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface a(android.content.Context r9, android.content.res.Resources r10, android.util.TypedValue r11, int r12, int r13, androidx.core.content.res.ResourcesCompat.FontCallback r14, android.os.Handler r15, boolean r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    private static TypedValue a() {
        TypedValue typedValue = f2387a.get();
        TypedValue typedValue2 = typedValue;
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            f2387a.set(typedValue2);
        }
        return typedValue2;
    }

    private static void a(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList) {
        synchronized (f2388c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = b.get(colorStateListCacheKey);
            SparseArray<ColorStateListCacheEntry> sparseArray2 = sparseArray;
            if (sparseArray == null) {
                sparseArray2 = new SparseArray<>();
                b.put(colorStateListCacheKey, sparseArray2);
            }
            sparseArray2.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f2390a.getConfiguration()));
        }
    }

    private static boolean a(Resources resources, int i) {
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    public static Typeface getCachedFont(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, new TypedValue(), 0, null, null, false, true);
    }

    public static int getColor(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList a2 = a(colorStateListCacheKey, i);
        if (a2 != null) {
            return a2;
        }
        ColorStateList a3 = a(resources, i, theme);
        if (a3 == null) {
            return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(resources, i, theme) : resources.getColorStateList(i);
        }
        a(colorStateListCacheKey, i, a3);
        return a3;
    }

    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawableForDensity(i, i2, theme) : Build.VERSION.SDK_INT >= 15 ? resources.getDrawableForDensity(i, i2) : resources.getDrawable(i);
    }

    public static float getFloat(Resources resources, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImplApi29.a(resources, i);
        }
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        if (a2.type == 4) {
            return a2.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(a2.type) + " is not valid");
    }

    public static Typeface getFont(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface getFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, fontCallback, null, true, false);
    }

    public static void getFont(Context context, int i, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            a(context, i, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }
}
