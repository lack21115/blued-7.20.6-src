package skin.support.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.ArrayList;
import java.util.List;
import skin.support.SkinCompatManager;

/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatResources.class */
public class SkinCompatResources {
    private static volatile SkinCompatResources a;
    private Resources b;
    private SkinCompatManager.SkinLoaderStrategy e;
    private String c = "";
    private String d = "";
    private boolean f = true;
    private List<SkinResources> g = new ArrayList();

    private SkinCompatResources() {
    }

    public static SkinCompatResources a() {
        if (a == null) {
            synchronized (SkinCompatResources.class) {
                try {
                    if (a == null) {
                        a = new SkinCompatResources();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static void a(Context context, int i, TypedValue typedValue, boolean z) {
        a().b(context, i, typedValue, z);
    }

    private void b(Context context, int i, TypedValue typedValue, boolean z) {
        int a2;
        if (this.f || (a2 = a(context, i)) == 0) {
            context.getResources().getValue(i, typedValue, z);
        } else {
            this.b.getValue(a2, typedValue, z);
        }
    }

    public static int c(Context context, int i) {
        return a().g(context, i);
    }

    public static ColorStateList d(Context context, int i) {
        return a().h(context, i);
    }

    public static Drawable e(Context context, int i) {
        return a().i(context, i);
    }

    public static XmlResourceParser f(Context context, int i) {
        return a().j(context, i);
    }

    private int g(Context context, int i) {
        int a2;
        ColorStateList b;
        ColorStateList a3;
        if (SkinCompatUserThemeManager.b().e() || (a3 = SkinCompatUserThemeManager.b().a(i)) == null) {
            SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy = this.e;
            return (skinLoaderStrategy == null || (b = skinLoaderStrategy.b(context, this.d, i)) == null) ? (this.f || (a2 = a(context, i)) == 0) ? Build.VERSION.SDK_INT >= 23 ? context.getResources().getColor(i, context.getTheme()) : context.getResources().getColor(i) : this.b.getColor(a2) : b.getDefaultColor();
        }
        return a3.getDefaultColor();
    }

    private ColorStateList h(Context context, int i) {
        int a2;
        ColorStateList c;
        ColorStateList a3;
        if (SkinCompatUserThemeManager.b().e() || (a3 = SkinCompatUserThemeManager.b().a(i)) == null) {
            SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy = this.e;
            return (skinLoaderStrategy == null || (c = skinLoaderStrategy.c(context, this.d, i)) == null) ? (this.f || (a2 = a(context, i)) == 0) ? Build.VERSION.SDK_INT >= 23 ? context.getResources().getColorStateList(i, context.getTheme()) : context.getResources().getColorStateList(i) : this.b.getColorStateList(a2) : c;
        }
        return a3;
    }

    private Drawable i(Context context, int i) {
        int a2;
        Drawable d;
        Drawable b;
        ColorStateList a3;
        if (SkinCompatUserThemeManager.b().e() || (a3 = SkinCompatUserThemeManager.b().a(i)) == null) {
            if (SkinCompatUserThemeManager.b().f() || (b = SkinCompatUserThemeManager.b().b(i)) == null) {
                SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy = this.e;
                return (skinLoaderStrategy == null || (d = skinLoaderStrategy.d(context, this.d, i)) == null) ? (this.f || (a2 = a(context, i)) == 0) ? Build.VERSION.SDK_INT >= 21 ? context.getResources().getDrawable(i, context.getTheme()) : context.getResources().getDrawable(i) : this.b.getDrawable(a2) : d;
            }
            return b;
        }
        return new ColorDrawable(a3.getDefaultColor());
    }

    private XmlResourceParser j(Context context, int i) {
        int a2;
        return (this.f || (a2 = a(context, i)) == 0) ? context.getResources().getXml(i) : this.b.getXml(a2);
    }

    public int a(Context context, int i) {
        String str = null;
        try {
            if (this.e != null) {
                str = this.e.a(context, this.d, i);
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = context.getResources().getResourceEntryName(i);
            }
            return this.b.getIdentifier(str2, context.getResources().getResourceTypeName(i), this.c);
        } catch (Exception e) {
            return i;
        }
    }

    public void a(Resources resources, String str, String str2, SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy) {
        if (resources == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            a(skinLoaderStrategy);
            return;
        }
        this.b = resources;
        this.c = str;
        this.d = str2;
        this.e = skinLoaderStrategy;
        this.f = false;
        SkinCompatUserThemeManager.b().g();
        for (SkinResources skinResources : this.g) {
            skinResources.b();
        }
    }

    public void a(SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy) {
        this.b = SkinCompatManager.a().getContext().getResources();
        this.c = "";
        this.d = "";
        this.e = skinLoaderStrategy;
        this.f = true;
        SkinCompatUserThemeManager.b().g();
        for (SkinResources skinResources : this.g) {
            skinResources.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SkinResources skinResources) {
        this.g.add(skinResources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable b(Context context, int i) {
        SkinCompatManager.SkinLoaderStrategy skinLoaderStrategy = this.e;
        if (skinLoaderStrategy != null) {
            return skinLoaderStrategy.d(context, this.d, i);
        }
        return null;
    }

    public void b() {
        a(SkinCompatManager.a().b().get(-1));
    }

    public Resources c() {
        return this.b;
    }

    public boolean d() {
        return this.f;
    }
}
