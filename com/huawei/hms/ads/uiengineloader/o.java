package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.io.File;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/o.class */
public final class o implements q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22560a = "DecompressedLdStrategy";
    private static final String b = "loader";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22561c = "com.huawei.hms.kit.type";
    private static final String d = "armeabi_type";
    private static HashMap<String, Integer> e = new HashMap<>();

    private static t a(File file, String str) {
        int i;
        String[] list = file.list();
        t tVar = new t();
        if (list == null || list.length == 0) {
            aa.c(f22560a, "No version in module path.");
            return tVar;
        }
        int length = list.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= length) {
                break;
            }
            String str2 = list[i2];
            int i4 = i;
            if (Integer.parseInt(str2) > i) {
                i4 = Integer.parseInt(str2);
            }
            i2++;
            i3 = i4;
        }
        if (i == 0) {
            aa.c(f22560a, "Cannot get module version path.");
            return tVar;
        }
        r.a(i, file.getAbsolutePath(), list, f22560a);
        int i5 = 0;
        if (e.containsKey(str)) {
            Integer num = e.get(str);
            i5 = num == null ? 0 : num.intValue();
        }
        if (i5 > i) {
            aa.b(f22560a, "There is a higher version in assets, assetsModuleVersion:" + i5 + ", decompressed version:" + i);
            return tVar;
        }
        File file2 = new File(file.getAbsolutePath() + File.separator + i + File.separator + str + ".apk");
        if (!file2.exists()) {
            aa.c(f22560a, "Cannot find module apk int asset decompressed path.");
            return tVar;
        }
        tVar.f22571a = str;
        tVar.b = file2.getAbsolutePath();
        tVar.f22572c = i;
        aa.b(f22560a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i + ", ModulePath:" + file2.getAbsolutePath());
        return tVar;
    }

    private static String a(Context context, String str, Bundle bundle) {
        String str2;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 128);
        String str3 = null;
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            str2 = "The packageInfo is null.";
        } else {
            Bundle bundle2 = packageArchiveInfo.applicationInfo.metaData;
            if (bundle2 == null) {
                str2 = "Get meta-data failed.";
            } else {
                str3 = null;
                for (String str4 : bundle2.keySet()) {
                    String str5 = str3;
                    if (str4.startsWith(f22561c)) {
                        str5 = bundle2.getString(str4);
                    }
                    str3 = str5;
                    if (str4.startsWith(d)) {
                        int i = bundle2.getInt(str4);
                        aa.b(f22560a, "The module defined the armeabiType:".concat(String.valueOf(i)));
                        bundle.putInt("armeabiType", i);
                        str3 = str5;
                    }
                }
                str2 = "The moduleType is:".concat(String.valueOf(str3));
            }
        }
        aa.c(f22560a, str2);
        return str3;
    }

    private static Context b(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.d));
        if (asInterface == null) {
            aa.c(f22560a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", tVar.f22571a);
        bundle.putString("loader_path", tVar.d);
        bundle.putInt("module_version", tVar.f22572c);
        bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
        return r.a(context, tVar.f22571a, bundle, asInterface);
    }

    public static t b(Context context, String str) {
        File file = new File(y.a(context) + File.separator + com.huawei.hms.ads.dynamicloader.b.f22466a + File.separator + str);
        return file.exists() ? a(file, str) : new t();
    }

    private static t c(Context context, String str) {
        t tVar;
        t tVar2 = new t();
        if (context == null || TextUtils.isEmpty(str)) {
            aa.c(f22560a, "The context or moduleName is null.");
            return tVar2;
        }
        try {
            t b2 = b(context, str);
            tVar = b2;
            if (b2.f22572c > 0) {
                aa.b(f22560a, "Successfully get module info from decompressed asset path.");
                tVar2 = b2;
                p.a(context, str, b2.f22572c);
                return b2;
            }
        } catch (Exception e2) {
            aa.b(f22560a, "getDataModuleInfo failed." + e2.getClass().getSimpleName());
            tVar = tVar2;
        }
        return tVar;
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final Context a(Context context, t tVar) {
        String str;
        if (tVar == null) {
            str = "moduleInfo is null.";
        } else {
            String str2 = tVar.b;
            if (TextUtils.isEmpty(str2)) {
                str = "modulePath is invalid.";
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", str2);
                bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
                bundle.putString("module_name", tVar.f22571a);
                aa.b(f22560a, "modulePath is:" + str2 + " loaderVersionType is : " + tVar.e);
                try {
                    if (!TextUtils.equals(a(context, str2, bundle), b)) {
                        com.huawei.hms.ads.dynamicloader.h.a(context);
                        return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
                    }
                    aa.b(f22560a, "The module is a loader, use it to load first.");
                    tVar.d = str2;
                    IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.d));
                    if (asInterface == null) {
                        aa.c(f22560a, "Get iDynamicLoader failed: null.");
                        return null;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("module_name", tVar.f22571a);
                    bundle2.putString("loader_path", tVar.d);
                    bundle2.putInt("module_version", tVar.f22572c);
                    bundle2.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
                    return r.a(context, tVar.f22571a, bundle2, asInterface);
                } catch (Exception e2) {
                    str = "Get local assets module context failed, " + e2.getClass().getSimpleName();
                }
            }
        }
        aa.c(f22560a, str);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final t a(Context context, String str) {
        return c(context, str);
    }
}
