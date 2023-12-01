package skin.support.load;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import skin.support.SkinCompatManager;
import skin.support.content.res.SkinCompatResources;
import skin.support.utils.SkinFileUtils;

/* loaded from: source-3503164-dex2jar.jar:skin/support/load/SkinSDCardLoader.class */
public abstract class SkinSDCardLoader implements SkinCompatManager.SkinLoaderStrategy {
    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b = b(context, str);
        if (SkinFileUtils.a(b)) {
            String a2 = SkinCompatManager.a().a(b);
            Resources b2 = SkinCompatManager.a().b(b);
            if (b2 == null || TextUtils.isEmpty(a2)) {
                return null;
            }
            SkinCompatResources.a().a(b2, a2, str, this);
            return str;
        }
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public ColorStateList b(Context context, String str, int i) {
        return null;
    }

    protected abstract String b(Context context, String str);

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public ColorStateList c(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public Drawable d(Context context, String str, int i) {
        return null;
    }
}
