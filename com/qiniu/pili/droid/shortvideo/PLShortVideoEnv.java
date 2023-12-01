package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.u;
import com.qiniu.pili.droid.shortvideo.f.e;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoEnv.class */
public class PLShortVideoEnv {
    public static void checkAuthentication(Context context, PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        u.a().a(context);
        u.a().a(pLAuthenticationResultCallback);
    }

    public static void init(Context context) {
        QosManager.a().b(context);
        u.a().a(context);
    }

    public static void setLogLevel(int i) {
        e.a(i);
    }
}
