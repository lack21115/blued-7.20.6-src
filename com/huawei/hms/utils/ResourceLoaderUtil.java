package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/ResourceLoaderUtil.class */
public abstract class ResourceLoaderUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22927a;
    public static String b;

    public static int getAnimId(String str) {
        return f22927a.getResources().getIdentifier(str, i.f, b);
    }

    public static int getColorId(String str) {
        return f22927a.getResources().getIdentifier(str, "color", b);
    }

    public static Drawable getDrawable(String str) {
        return f22927a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return f22927a.getResources().getIdentifier(str, i.f7952c, b);
    }

    public static int getIdId(String str) {
        return f22927a.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        return f22927a.getResources().getIdentifier(str, "layout", b);
    }

    public static String getString(String str) {
        return f22927a.getResources().getString(getStringId(str));
    }

    public static String getString(String str, Object... objArr) {
        return f22927a.getResources().getString(getStringId(str), objArr);
    }

    public static int getStringId(String str) {
        return f22927a.getResources().getIdentifier(str, "string", b);
    }

    public static int getStyleId(String str) {
        return f22927a.getResources().getIdentifier(str, "style", b);
    }

    public static Context getmContext() {
        return f22927a;
    }

    public static void setmContext(Context context) {
        f22927a = context;
        b = context.getPackageName();
    }
}
