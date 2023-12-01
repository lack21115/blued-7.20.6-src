package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.anythink.expressad.foundation.h.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal.class */
public final class ResourceManagerInternal {
    private static ResourceManagerInternal b;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> d;
    private SimpleArrayMap<String, InflateDelegate> e;
    private SparseArrayCompat<String> f;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> g = new WeakHashMap<>(0);
    private TypedValue h;
    private boolean i;
    private ResourceManagerHooks j;

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f1800a = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static final ColorFilterLruCache f1801c = new ColorFilterLruCache(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$AsldcInflateDelegate.class */
    public static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$AvdcInflateDelegate.class */
    public static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$ColorFilterLruCache.class */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$DrawableDelegate.class */
    public static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        Compatibility.Api21Impl.inflate(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                        return drawable;
                    }
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    return drawable;
                } catch (Exception e) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$InflateDelegate.class */
    public interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$ResourceManagerHooks.class */
    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i);

        ColorStateList getTintListForDrawableRes(Context context, int i);

        PorterDuff.Mode getTintModeForDrawableRes(int i);

        boolean tintDrawable(Context context, int i, Drawable drawable);

        boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ResourceManagerInternal$VdcInflateDelegate.class */
    public static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        Drawable drawable2;
        ColorStateList a2 = a(context, i);
        if (a2 != null) {
            Drawable drawable3 = drawable;
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable3 = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable3);
            DrawableCompat.setTintList(wrap, a2);
            PorterDuff.Mode a3 = a(i);
            drawable2 = wrap;
            if (a3 != null) {
                DrawableCompat.setTintMode(wrap, a3);
                return wrap;
            }
        } else {
            ResourceManagerHooks resourceManagerHooks = this.j;
            if (resourceManagerHooks != null && resourceManagerHooks.tintDrawable(context, i, drawable)) {
                return drawable;
            }
            drawable2 = drawable;
            if (!a(context, i, drawable)) {
                drawable2 = drawable;
                if (z) {
                    drawable2 = null;
                }
            }
        }
        return drawable2;
    }

    private Drawable a(Context context, long j) {
        synchronized (this) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.g.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
            if (weakReference != null) {
                Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.remove(j);
            }
            return null;
        }
    }

    private void a(Context context) {
        if (this.i) {
            return;
        }
        this.i = true;
        Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
        if (drawable == null || !a(drawable)) {
            this.i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private void a(Context context, int i, ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.d.get(context);
        SparseArrayCompat<ColorStateList> sparseArrayCompat2 = sparseArrayCompat;
        if (sparseArrayCompat == null) {
            sparseArrayCompat2 = new SparseArrayCompat<>();
            this.d.put(context, sparseArrayCompat2);
        }
        sparseArrayCompat2.append(i, colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            drawable.setColorFilter(a(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : f1800a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static void a(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new VdcInflateDelegate());
            resourceManagerInternal.a("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.a("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.a(i.f5112c, new DrawableDelegate());
        }
    }

    private void a(String str, InflateDelegate inflateDelegate) {
        if (this.e == null) {
            this.e = new SimpleArrayMap<>();
        }
        this.e.put(str, inflateDelegate);
    }

    private boolean a(Context context, long j, Drawable drawable) {
        synchronized (this) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.g.get(context);
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray2 = longSparseArray;
                if (longSparseArray == null) {
                    longSparseArray2 = new LongSparseArray<>();
                    this.g.put(context, longSparseArray2);
                }
                longSparseArray2.put(j, new WeakReference<>(constantState));
                return true;
            }
            return false;
        }
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable b(Context context, int i) {
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue typedValue = this.h;
        context.getResources().getValue(i, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        ResourceManagerHooks resourceManagerHooks = this.j;
        Drawable createDrawableFor = resourceManagerHooks == null ? null : resourceManagerHooks.createDrawableFor(this, context, i);
        if (createDrawableFor != null) {
            createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, createDrawableFor);
        }
        return createDrawableFor;
    }

    private Drawable c(Context context, int i) {
        int next;
        SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.e;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.f;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(i);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.e.get(str) == null) {
                return null;
            }
        } else {
            this.f = new SparseArrayCompat<>();
        }
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue typedValue = this.h;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        Drawable drawable = a3;
        if (typedValue.string != null) {
            drawable = a3;
            if (typedValue.string.toString().endsWith(".xml")) {
                drawable = a3;
                try {
                    XmlResourceParser xml = resources.getXml(i);
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    String name = xml.getName();
                    this.f.append(i, name);
                    InflateDelegate inflateDelegate = this.e.get(name);
                    Drawable drawable2 = a3;
                    if (inflateDelegate != null) {
                        drawable2 = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                    }
                    drawable = drawable2;
                    if (drawable2 != null) {
                        drawable2.setChangingConfigurations(typedValue.changingConfigurations);
                        Drawable drawable3 = drawable2;
                        a(context, a2, drawable2);
                        drawable = drawable2;
                    }
                } catch (Exception e) {
                    Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
                }
            }
        }
        if (drawable == null) {
            this.f.append(i, "appcompat_skip_skip");
        }
        return drawable;
    }

    private ColorStateList d(Context context, int i) {
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.d;
        ColorStateList colorStateList = null;
        if (weakHashMap != null) {
            SparseArrayCompat<ColorStateList> sparseArrayCompat = weakHashMap.get(context);
            colorStateList = null;
            if (sparseArrayCompat != null) {
                colorStateList = sparseArrayCompat.get(i);
            }
        }
        return colorStateList;
    }

    public static ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (b == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    b = resourceManagerInternal2;
                    a(resourceManagerInternal2);
                }
                resourceManagerInternal = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            try {
                PorterDuffColorFilter a2 = f1801c.a(i, mode);
                porterDuffColorFilter = a2;
                if (a2 == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                    f1801c.a(i, mode, porterDuffColorFilter);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return porterDuffColorFilter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a(Context context, int i) {
        ColorStateList colorStateList;
        synchronized (this) {
            ColorStateList d = d(context, i);
            colorStateList = d;
            if (d == null) {
                ColorStateList tintListForDrawableRes = this.j == null ? null : this.j.getTintListForDrawableRes(context, i);
                colorStateList = tintListForDrawableRes;
                if (tintListForDrawableRes != null) {
                    a(context, i, tintListForDrawableRes);
                    colorStateList = tintListForDrawableRes;
                }
            }
        }
        return colorStateList;
    }

    PorterDuff.Mode a(int i) {
        ResourceManagerHooks resourceManagerHooks = this.j;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, int i, boolean z) {
        Drawable drawable;
        synchronized (this) {
            a(context);
            Drawable c2 = c(context, i);
            Drawable drawable2 = c2;
            if (c2 == null) {
                drawable2 = b(context, i);
            }
            Drawable drawable3 = drawable2;
            if (drawable2 == null) {
                drawable3 = ContextCompat.getDrawable(context, i);
            }
            drawable = drawable3;
            if (drawable3 != null) {
                drawable = a(context, i, z, drawable3);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        synchronized (this) {
            Drawable c2 = c(context, i);
            Drawable drawable = c2;
            if (c2 == null) {
                drawable = vectorEnabledTintResources.a(i);
            }
            if (drawable != null) {
                return a(context, i, false, drawable);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, int i, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.j;
        return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i, drawable);
    }

    public Drawable getDrawable(Context context, int i) {
        Drawable a2;
        synchronized (this) {
            a2 = a(context, i, false);
        }
        return a2;
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.g.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    public void setHooks(ResourceManagerHooks resourceManagerHooks) {
        synchronized (this) {
            this.j = resourceManagerHooks;
        }
    }
}
