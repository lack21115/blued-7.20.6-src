package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.l;
import com.huawei.hms.ads.uiengineloader.v;
import java.io.File;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8865a = h.class.getSimpleName();
    private static final String[] b = {"b4ec5c5bc95f125d5d586b54a5a40abd38b44201fe8fe3cd295cb3c64f422c3c"};

    /* renamed from: c  reason: collision with root package name */
    private static volatile h f8866c;
    private final Context d;

    private h(Context context) {
        this.d = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    public static Context a(Context context, Bundle bundle) {
        if (bundle == null) {
            aa.d(f8865a, "Failed to read query result");
            return null;
        }
        String string = bundle.getString("module_path");
        if (TextUtils.isEmpty(string) || !new File(string).exists()) {
            aa.c(f8865a, "The module path is invalid.");
            return null;
        }
        aa.b(f8865a, "The loaded module path is:".concat(String.valueOf(string)));
        if (!v.a(Arrays.asList(b), v.a(context, string))) {
            aa.c(f8865a, "uiengine apk is invalid.");
            return null;
        }
        new l();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        String string2 = bundle.getString(b.e, b.f);
        aa.b(f8865a, "loaderType :  ".concat(String.valueOf(string2)));
        int i = bundle.getInt("armeabiType");
        i iVar = b.g.equals(string2) ? new i(context, string, i) : new e(context, string, i);
        try {
            iVar.getClassLoader().loadClass("com.huawei.hms.ads.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, iVar);
            return iVar;
        } catch (Exception e) {
            aa.b(l.f8948a, "failed to init Module ".concat(String.valueOf(e)));
            return iVar;
        }
    }

    public static h a(Context context) {
        h hVar;
        if (f8866c != null) {
            return f8866c;
        }
        synchronized (h.class) {
            try {
                if (f8866c == null) {
                    f8866c = new h(context);
                }
                hVar = f8866c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    private static boolean a(Context context, String str) {
        return v.a(Arrays.asList(b), v.a(context, str));
    }
}
