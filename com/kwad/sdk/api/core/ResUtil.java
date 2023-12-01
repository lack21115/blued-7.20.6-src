package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.anythink.expressad.foundation.h.i;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/ResUtil.class */
class ResUtil {
    ResUtil() {
    }

    static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, "attr");
    }

    static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, "color"));
    }

    static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, "dimen");
    }

    static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, i.f7952c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, i.f7952c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, "layout");
    }

    private static String getPackageName(Context context) {
        return context.getPackageName();
    }

    static int getRawId(Context context, String str) {
        return getIdentifier(context, str, ShareConstants.DEXMODE_RAW);
    }

    private static Resources getResources(Context context) {
        return context.getResources();
    }

    static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, "string"));
    }

    static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, "style");
    }
}
