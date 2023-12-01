package skin.support.load;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import skin.support.SkinCompatManager;

/* loaded from: source-3503164-dex2jar.jar:skin/support/load/SkinNoneLoader.class */
public class SkinNoneLoader implements SkinCompatManager.SkinLoaderStrategy {
    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str) {
        return "";
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str, int i) {
        return "";
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public ColorStateList b(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public ColorStateList c(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public Drawable d(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public int getType() {
        return -1;
    }
}
