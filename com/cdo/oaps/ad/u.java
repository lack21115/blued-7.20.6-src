package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cdo.oaps.ad.Launcher;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21534a = 2000000;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f21535c = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home"};

    public static int a(Context context, String str) {
        int i = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
            return i;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    public static boolean a(Context context, String str, int i) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i;
    }
}
