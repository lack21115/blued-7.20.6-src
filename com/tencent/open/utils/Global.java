package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/Global.class */
public final class Global {

    /* renamed from: a  reason: collision with root package name */
    private static Context f24583a;

    public static final Context getContext() {
        Context context = f24583a;
        Context context2 = context;
        if (context == null) {
            context2 = null;
        }
        return context2;
    }

    public static final File getFilesDir() {
        if (getContext() == null) {
            return null;
        }
        return getContext().getFilesDir();
    }

    public static final String getPackageName() {
        return getContext() == null ? "" : getContext().getPackageName();
    }

    public static final SharedPreferences getSharedPreferences(String str, int i) {
        if (getContext() == null) {
            return null;
        }
        return getContext().getSharedPreferences(str, i);
    }

    public static int getVersionCode() {
        return f24583a.getSharedPreferences("openSdk.pref", 0).getInt("app.vercode", 0);
    }

    public static void saveVersionCode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("openSdk.pref", 0).edit();
                edit.putInt("app.vercode", packageInfo.versionCode);
                edit.commit();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final void setContext(Context context) {
        f24583a = context;
    }
}
