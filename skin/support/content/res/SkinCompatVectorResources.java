package skin.support.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatVectorResources.class */
public class SkinCompatVectorResources implements SkinResources {
    private static SkinCompatVectorResources a;

    private SkinCompatVectorResources() {
        SkinCompatResources.a().a(this);
    }

    public static Drawable a(Context context, int i) {
        return a().b(context, i);
    }

    public static SkinCompatVectorResources a() {
        if (a == null) {
            synchronized (SkinCompatVectorResources.class) {
                try {
                    if (a == null) {
                        a = new SkinCompatVectorResources();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    private Drawable b(Context context, int i) {
        int a2;
        Drawable b;
        ColorStateList a3;
        Drawable b2;
        ColorStateList a4;
        if (!AppCompatDelegate.isCompatVectorFromResourcesEnabled()) {
            if (SkinCompatUserThemeManager.b().e() || (a3 = SkinCompatUserThemeManager.b().a(i)) == null) {
                if (SkinCompatUserThemeManager.b().f() || (b = SkinCompatUserThemeManager.b().b(i)) == null) {
                    Drawable b3 = SkinCompatResources.a().b(context, i);
                    return b3 != null ? b3 : (SkinCompatResources.a().d() || (a2 = SkinCompatResources.a().a(context, i)) == 0) ? AppCompatResources.getDrawable(context, i) : SkinCompatResources.a().c().getDrawable(a2);
                }
                return b;
            }
            return new ColorDrawable(a3.getDefaultColor());
        }
        if (!SkinCompatResources.a().d()) {
            try {
                return SkinCompatDrawableManager.a().a(context, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (SkinCompatUserThemeManager.b().e() || (a4 = SkinCompatUserThemeManager.b().a(i)) == null) {
            if (SkinCompatUserThemeManager.b().f() || (b2 = SkinCompatUserThemeManager.b().b(i)) == null) {
                Drawable b4 = SkinCompatResources.a().b(context, i);
                return b4 != null ? b4 : AppCompatResources.getDrawable(context, i);
            }
            return b2;
        }
        return new ColorDrawable(a4.getDefaultColor());
    }

    @Override // skin.support.content.res.SkinResources
    public void b() {
        SkinCompatDrawableManager.a().b();
    }
}
