package com.tencent.map.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/l.class */
public final class l {
    private static l b;

    /* renamed from: a  reason: collision with root package name */
    private Context f23552a;

    private l() {
    }

    public static l a() {
        if (b == null) {
            b = new l();
        }
        return b;
    }

    public static Context b() {
        return a().f23552a;
    }

    public static boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a().f23552a.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a().f23552a.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public final void a(Context context) {
        if (this.f23552a == null) {
            this.f23552a = context.getApplicationContext();
        }
    }
}
