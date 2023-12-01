package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/q2.class */
public class q2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f21293a;

    public static String a(Context context, m0 m0Var) {
        String str;
        if (TextUtils.isEmpty(f21293a)) {
            synchronized (q2.class) {
                try {
                    if (!TextUtils.isEmpty(f21293a)) {
                        return f21293a;
                    }
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                    String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                    if (TextUtils.isEmpty(id)) {
                        str = m0Var.e.getString("google_aid", null);
                    } else {
                        str = id;
                        if (!TextUtils.equals(m0Var.e.getString("google_aid", null), id)) {
                            str = id;
                            if (!TextUtils.isEmpty(id)) {
                                m0Var.e.edit().putString("google_aid", id).apply();
                                str = id;
                            }
                        }
                    }
                    f21293a = str;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21293a;
    }
}
