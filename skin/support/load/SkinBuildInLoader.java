package skin.support.load;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import skin.support.SkinCompatManager;
import skin.support.content.res.SkinCompatResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/load/SkinBuildInLoader.class */
public class SkinBuildInLoader implements SkinCompatManager.SkinLoaderStrategy {
    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str) {
        SkinCompatResources.a().a(context.getResources(), context.getPackageName(), str, this);
        return str;
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str, int i) {
        return context.getResources().getResourceEntryName(i) + BridgeUtil.UNDERLINE_STR + str;
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
        return 1;
    }
}
