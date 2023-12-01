package skin.support.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableManager.class */
public final class SkinCompatDrawableManager {
    private static SkinCompatDrawableManager c;
    private WeakHashMap<Context, SparseArray<ColorStateList>> k;
    private ArrayMap<String, InflateDelegate> l;
    private SparseArray<String> m;
    private final Object n = new Object();
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> o = new WeakHashMap<>(0);
    private TypedValue p;
    private boolean q;
    private static final String a = SkinCompatDrawableManager.class.getSimpleName();
    private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private static final ColorFilterLruCache d = new ColorFilterLruCache(6);
    private static final int[] e = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] g = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
    private static final int[] h = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] i = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    private static final int[] j = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableManager$AvdcInflateDelegate.class */
    public static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // skin.support.content.res.SkinCompatDrawableManager.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableManager$ColorFilterLruCache.class */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableManager$InflateDelegate.class */
    public interface InflateDelegate {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableManager$VdcInflateDelegate.class */
    public static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // skin.support.content.res.SkinCompatDrawableManager.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    SkinCompatDrawableManager() {
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private ColorStateList a(Context context) {
        return f(context, SkinCompatThemeUtils.a(context, R.attr.colorButtonNormal));
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2 = d.a(i2, mode);
        PorterDuffColorFilter porterDuffColorFilter = a2;
        if (a2 == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
            d.a(i2, mode, porterDuffColorFilter);
        }
        return porterDuffColorFilter;
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        Drawable drawable2;
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            Drawable drawable3 = drawable;
            if (SkinCompatDrawableUtils.b(drawable)) {
                drawable3 = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable3);
            DrawableCompat.setTintList(wrap, b2);
            PorterDuff.Mode a2 = a(i2);
            drawable2 = wrap;
            if (a2 != null) {
                DrawableCompat.setTintMode(wrap, a2);
                return wrap;
            }
        } else if (i2 == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(com.android.internal.R.id.background), SkinCompatThemeUtils.a(context, R.attr.colorControlNormal), b);
            a(layerDrawable.findDrawableByLayerId(com.android.internal.R.id.secondaryProgress), SkinCompatThemeUtils.a(context, R.attr.colorControlNormal), b);
            a(layerDrawable.findDrawableByLayerId(com.android.internal.R.id.progress), SkinCompatThemeUtils.a(context, R.attr.colorControlActivated), b);
            return drawable;
        } else if (i2 == R.drawable.abc_ratingbar_material || i2 == R.drawable.abc_ratingbar_indicator_material || i2 == R.drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(com.android.internal.R.id.background), SkinCompatThemeUtils.c(context, R.attr.colorControlNormal), b);
            a(layerDrawable2.findDrawableByLayerId(com.android.internal.R.id.secondaryProgress), SkinCompatThemeUtils.a(context, R.attr.colorControlActivated), b);
            a(layerDrawable2.findDrawableByLayerId(com.android.internal.R.id.progress), SkinCompatThemeUtils.a(context, R.attr.colorControlActivated), b);
            drawable2 = drawable;
        } else {
            drawable2 = drawable;
            if (!a(context, i2, drawable)) {
                drawable2 = drawable;
                if (z) {
                    return null;
                }
            }
        }
        return drawable2;
    }

    private Drawable a(Context context, long j2) {
        synchronized (this.n) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.o.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) longSparseArray.get(j2);
            if (weakReference != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.delete(j2);
            }
            return null;
        }
    }

    public static SkinCompatDrawableManager a() {
        if (c == null) {
            SkinCompatDrawableManager skinCompatDrawableManager = new SkinCompatDrawableManager();
            c = skinCompatDrawableManager;
            a(skinCompatDrawableManager);
        }
        return c;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.k == null) {
            this.k = new WeakHashMap<>();
        }
        SparseArray<ColorStateList> sparseArray = this.k.get(context);
        SparseArray<ColorStateList> sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>();
            this.k.put(context, sparseArray2);
        }
        sparseArray2.append(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        Drawable drawable2 = drawable;
        if (SkinCompatDrawableUtils.b(drawable)) {
            drawable2 = drawable.mutate();
        }
        PorterDuff.Mode mode2 = mode;
        if (mode == null) {
            mode2 = b;
        }
        drawable2.setColorFilter(a(i2, mode2));
    }

    private void a(String str, InflateDelegate inflateDelegate) {
        if (this.l == null) {
            this.l = new ArrayMap<>();
        }
        this.l.put(str, inflateDelegate);
    }

    private static void a(SkinCompatDrawableManager skinCompatDrawableManager) {
        if (Build.VERSION.SDK_INT < 24) {
            skinCompatDrawableManager.a("vector", new VdcInflateDelegate());
            skinCompatDrawableManager.a("animated-vector", new AvdcInflateDelegate());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(android.content.Context r4, int r5, android.graphics.drawable.Drawable r6) {
        /*
            android.graphics.PorterDuff$Mode r0 = skin.support.content.res.SkinCompatDrawableManager.b
            r10 = r0
            int[] r0 = skin.support.content.res.SkinCompatDrawableManager.e
            r1 = r5
            boolean r0 = a(r0, r1)
            r9 = r0
            r0 = 16842801(0x1010031, float:2.3693695E-38)
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L23
            int r0 = androidx.appcompat.R.attr.colorControlNormal
            r5 = r0
        L1b:
            r0 = -1
            r7 = r0
        L1d:
            r0 = 1
            r8 = r0
            goto L70
        L23:
            int[] r0 = skin.support.content.res.SkinCompatDrawableManager.g
            r1 = r5
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L34
            int r0 = androidx.appcompat.R.attr.colorControlActivated
            r5 = r0
            goto L1b
        L34:
            int[] r0 = skin.support.content.res.SkinCompatDrawableManager.h
            r1 = r5
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L48
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            r10 = r0
            r0 = r7
            r5 = r0
            goto L1b
        L48:
            r0 = r5
            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r0 != r1) goto L5d
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r5 = r0
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            r7 = r0
            goto L1d
        L5d:
            r0 = r5
            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r0 != r1) goto L69
            r0 = r7
            r5 = r0
            goto L1b
        L69:
            r0 = -1
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r5 = r0
        L70:
            r0 = r8
            if (r0 == 0) goto La1
            r0 = r6
            r11 = r0
            r0 = r6
            boolean r0 = skin.support.content.res.SkinCompatDrawableUtils.b(r0)
            if (r0 == 0) goto L85
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.mutate()
            r11 = r0
        L85:
            r0 = r11
            r1 = r4
            r2 = r5
            int r1 = skin.support.content.res.SkinCompatThemeUtils.a(r1, r2)
            r2 = r10
            android.graphics.PorterDuffColorFilter r1 = a(r1, r2)
            r0.setColorFilter(r1)
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L9f
            r0 = r11
            r1 = r7
            r0.setAlpha(r1)
        L9f:
            r0 = 1
            return r0
        La1:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.content.res.SkinCompatDrawableManager.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.n) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.o.get(context);
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray2 = longSparseArray;
                if (longSparseArray == null) {
                    longSparseArray2 = new LongSparseArray<>();
                    this.o.put(context, longSparseArray2);
                }
                longSparseArray2.put(j2, new WeakReference(constantState));
            }
            return true;
        }
        return false;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return false;
            }
            if (iArr[i4] == i2) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    private ColorStateList b(Context context) {
        return f(context, 0);
    }

    private ColorStateList c(Context context) {
        return f(context, SkinCompatThemeUtils.a(context, R.attr.colorAccent));
    }

    private Drawable c(Context context, int i2) {
        if (this.p == null) {
            this.p = new TypedValue();
        }
        TypedValue typedValue = this.p;
        SkinCompatResources.a(context, i2, typedValue, true);
        long a2 = a(typedValue);
        LayerDrawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == R.drawable.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, R.drawable.abc_cab_background_internal_bg), a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int[], int[][]] */
    private ColorStateList d(Context context) {
        ?? r0 = new int[3];
        int[] iArr = new int[3];
        ColorStateList b2 = SkinCompatThemeUtils.b(context, R.attr.colorSwitchThumbNormal);
        if (b2 == null || !b2.isStateful()) {
            r0[0] = SkinCompatThemeUtils.a;
            iArr[0] = SkinCompatThemeUtils.c(context, R.attr.colorSwitchThumbNormal);
            r0[1] = SkinCompatThemeUtils.k;
            iArr[1] = SkinCompatThemeUtils.a(context, R.attr.colorControlActivated);
            r0[2] = SkinCompatThemeUtils.n;
            iArr[2] = SkinCompatThemeUtils.a(context, R.attr.colorSwitchThumbNormal);
        } else {
            r0[0] = SkinCompatThemeUtils.a;
            iArr[0] = b2.getColorForState(r0[0], 0);
            r0[1] = SkinCompatThemeUtils.k;
            iArr[1] = SkinCompatThemeUtils.a(context, R.attr.colorControlActivated);
            r0[2] = SkinCompatThemeUtils.n;
            iArr[2] = b2.getDefaultColor();
        }
        return new ColorStateList(r0, iArr);
    }

    private Drawable d(Context context, int i2) {
        int next;
        ArrayMap<String, InflateDelegate> arrayMap = this.l;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArray<String> sparseArray = this.m;
        if (sparseArray != null) {
            String str = sparseArray.get(i2);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.l.get(str) == null) {
                return null;
            }
        } else {
            this.m = new SparseArray<>();
        }
        if (this.p == null) {
            this.p = new TypedValue();
        }
        TypedValue typedValue = this.p;
        SkinCompatResources.a(context, i2, typedValue, true);
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
                    XmlResourceParser f2 = SkinCompatResources.f(context, i2);
                    AttributeSet asAttributeSet = Xml.asAttributeSet(f2);
                    do {
                        next = f2.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    String name = f2.getName();
                    this.m.append(i2, name);
                    InflateDelegate inflateDelegate = (InflateDelegate) this.l.get(name);
                    Drawable drawable2 = a3;
                    if (inflateDelegate != null) {
                        drawable2 = inflateDelegate.a(context, f2, asAttributeSet, null);
                    }
                    drawable = drawable2;
                    if (drawable2 != null) {
                        drawable2.setChangingConfigurations(typedValue.changingConfigurations);
                        Drawable drawable3 = drawable2;
                        a(context, a2, drawable2);
                        drawable = drawable2;
                    }
                } catch (Exception e2) {
                    Log.e(a, "Exception while inflating drawable", e2);
                }
            }
        }
        if (drawable == null) {
            this.m.append(i2, "appcompat_skip_skip");
        }
        return drawable;
    }

    private ColorStateList e(Context context, int i2) {
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.k;
        ColorStateList colorStateList = null;
        if (weakHashMap != null) {
            SparseArray<ColorStateList> sparseArray = weakHashMap.get(context);
            colorStateList = null;
            if (sparseArray != null) {
                colorStateList = sparseArray.get(i2);
            }
        }
        return colorStateList;
    }

    private void e(Context context) {
        if (this.q) {
            return;
        }
        this.q = true;
        Drawable a2 = a(context, androidx.appcompat.resources.R.drawable.abc_vector_test);
        if (a2 == null || !a(a2)) {
            this.q = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    private ColorStateList f(Context context, int i2) {
        int a2 = SkinCompatThemeUtils.a(context, R.attr.colorControlHighlight);
        int c2 = SkinCompatThemeUtils.c(context, R.attr.colorButtonNormal);
        int[] iArr = SkinCompatThemeUtils.a;
        int[] iArr2 = SkinCompatThemeUtils.j;
        int compositeColors = ColorUtils.compositeColors(a2, i2);
        return new ColorStateList(new int[]{iArr, iArr2, SkinCompatThemeUtils.d, SkinCompatThemeUtils.n}, new int[]{c2, compositeColors, ColorUtils.compositeColors(a2, i2), i2});
    }

    public Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    Drawable a(Context context, int i2, boolean z) {
        e(context);
        Drawable d2 = d(context, i2);
        Drawable drawable = d2;
        if (d2 == null) {
            drawable = c(context, i2);
        }
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = SkinCompatResources.e(context, i2);
        }
        Drawable drawable3 = drawable2;
        if (drawable2 != null) {
            drawable3 = a(context, i2, z, drawable2);
        }
        if (drawable3 != null) {
            SkinCompatDrawableUtils.a(drawable3);
        }
        return drawable3;
    }

    ColorStateList b(Context context, int i2) {
        ColorStateList e2 = e(context, i2);
        ColorStateList colorStateList = e2;
        if (e2 == null) {
            if (i2 == R.drawable.abc_edit_text_material) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_edittext);
            } else if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_switch_track);
            } else if (i2 == R.drawable.abc_switch_thumb_material) {
                e2 = d(context);
            } else if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                e2 = a(context);
            } else if (i2 == R.drawable.abc_btn_borderless_material) {
                e2 = b(context);
            } else if (i2 == R.drawable.abc_btn_colored_material) {
                e2 = c(context);
            } else if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_spinner);
            } else if (a(f, i2)) {
                e2 = SkinCompatThemeUtils.b(context, R.attr.colorControlNormal);
            } else if (a(i, i2)) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_default);
            } else if (a(j, i2)) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_btn_checkable);
            } else if (i2 == R.drawable.abc_seekbar_thumb_material) {
                e2 = SkinCompatResources.d(context, R.color.abc_tint_seek_thumb);
            }
            colorStateList = e2;
            if (e2 != null) {
                a(context, i2, e2);
                colorStateList = e2;
            }
        }
        return colorStateList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.o.clear();
        SparseArray<String> sparseArray = this.m;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.k;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        d.evictAll();
    }
}
