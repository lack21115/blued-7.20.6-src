package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/r.class */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22566a = "dl_LoadHelper";
    private static final String b = "DynamicLoader";

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) {
        try {
            IObjectWrapper load = iDynamicLoader.load(ac.a(context), str, bundle.getInt("module_version"), ac.a(bundle));
            if (ac.a(load) == null) {
                aa.c(f22566a, "Get remote context is null.");
                return null;
            } else if (!(ac.a(load) instanceof Context)) {
                aa.c(f22566a, "Incorrect context type.");
                return null;
            } else {
                aa.b(f22566a, "Get context for the module:" + str + " success.");
                return (Context) ac.a(load);
            }
        } catch (Exception e) {
            aa.c(f22566a, "Failed to get remote module context." + e.getClass().getSimpleName());
            return null;
        }
    }

    public static IBinder a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        BaseDexClassLoader dVar;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT < 21) {
                        aa.b(f22566a, "The android version is android 4.x.");
                        dVar = new com.huawei.hms.ads.dynamicloader.c(str, context.getFilesDir().getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
                    } else {
                        dVar = new com.huawei.hms.ads.dynamicloader.d(str, ClassLoader.getSystemClassLoader());
                    }
                    return (IBinder) dVar.loadClass("DynamicLoader").getConstructor(new Class[0]).newInstance(new Object[0]);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            }
        }
        throw new com.huawei.hms.ads.dynamicloader.j("Failed to get dynamicLoader path.");
    }

    public static void a(final int i, final String str, final String[] strArr, String str2) {
        com.huawei.hms.ads.dynamic.b.a(str2).execute(new com.huawei.hms.ads.dynamicloader.k(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.r.1
            @Override // java.lang.Runnable
            public final void run() {
                String[] strArr2 = strArr;
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        return;
                    }
                    String str3 = strArr2[i3];
                    if (Integer.parseInt(str3) < i) {
                        aa.b(r.f22566a, "Delete low version:" + i + " in modulePath.");
                        y.b(str + File.separator + str3);
                    }
                    i2 = i3 + 1;
                }
            }
        }));
    }
}
