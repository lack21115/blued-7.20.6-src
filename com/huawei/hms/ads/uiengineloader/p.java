package com.huawei.hms.ads.uiengineloader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/p.class */
public final class p implements q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22562a = "ads_HMSLoadStrategy";
    private static final String b = "content://com.huawei.hms";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22563c = "huawei_module_dynamicloader";
    private static final String d = "errcode";
    private static final String e = "loader_version";
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 6;
    private static HashMap<String, Bundle> i = new HashMap<>();

    public static void a(final Context context, final String str, final int i2) {
        new Thread() { // from class: com.huawei.hms.ads.uiengineloader.p.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    int b2 = p.b(Context.this, str);
                    aa.b(p.f22562a, "remoteVersion:" + b2 + " localModuleVersion:" + i2);
                    if (b2 > i2) {
                        p.c(Context.this, str);
                    }
                } catch (Throwable th) {
                    aa.c(p.f22562a, "copy error: " + th.getLocalizedMessage());
                }
            }
        }.start();
    }

    public static int b(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle bundle;
        if (i.containsKey(str) && (bundle = i.get(str)) != null) {
            aa.b(f22562a, "cachedModuleInfo containsKey, version: " + bundle.getInt("module_version"));
            return bundle.getInt("module_version");
        }
        Bundle e2 = e(context, str);
        if (e2 == null) {
            aa.c(f22562a, "Query module bundle info failed: null.");
            return 0;
        } else if (e2.getInt("errcode") != 0) {
            return 0;
        } else {
            return e2.getInt("module_version");
        }
    }

    private static Context b(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.d));
        if (asInterface == null) {
            aa.c(f22562a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", tVar.f22571a);
        bundle.putString("loader_path", tVar.d);
        bundle.putInt("module_version", tVar.f22572c);
        bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
        return r.a(context, tVar.f22571a, bundle, asInterface);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01df A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #0 {all -> 0x028e, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0014, B:9:0x0021, B:13:0x0046, B:15:0x006d, B:20:0x0080, B:23:0x0170, B:29:0x01d9, B:31:0x01df, B:34:0x01fb, B:34:0x01fb, B:35:0x01fe, B:32:0x01e9, B:24:0x017d, B:27:0x019d, B:33:0x01f4), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e9 A[Catch: all -> 0x028e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x028e, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0014, B:9:0x0021, B:13:0x0046, B:15:0x006d, B:20:0x0080, B:23:0x0170, B:29:0x01d9, B:31:0x01df, B:34:0x01fb, B:34:0x01fb, B:35:0x01fe, B:32:0x01e9, B:24:0x017d, B:27:0x019d, B:33:0x01f4), top: B:40:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void c(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.p.c(android.content.Context, java.lang.String):void");
    }

    private static t d(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        t tVar = new t();
        try {
            Bundle e2 = e(context, str);
            if (e2 == null) {
                aa.c(f22562a, "Failed to get bundle info: null.");
                return tVar;
            }
            int i2 = e2.getInt("errcode");
            if (i2 == 1) {
                aa.c(f22562a, "The query module:" + str + " is not existed in HMS.");
                return tVar;
            } else if (i2 != 0) {
                aa.c(f22562a, "Failed to get bundle info for " + str + ", errcode:" + i2);
                throw new com.huawei.hms.ads.dynamicloader.j("Query module unavailable, maybe you need to download it.", e2);
            } else {
                tVar.f22571a = str;
                tVar.b = e2.getString("module_path");
                tVar.f22572c = e2.getInt("module_version");
                tVar.d = e2.getString("loader_path");
                tVar.f = e2.getInt("loader_version");
                tVar.g = e2.getInt("armeabiType");
                aa.b(f22562a, "bundle info: errorCode:" + i2 + ", moduleName:" + str + ", moduleVersion:" + tVar.f22572c + ", modulePath:" + tVar.b + ", loader_version:" + tVar.f + ", loaderPath:" + tVar.d);
                a(context, str, 0);
                StringBuilder sb = new StringBuilder("Query remote version by module name:");
                sb.append(str);
                sb.append(" success.");
                aa.b(f22562a, sb.toString());
                return tVar;
            }
        } catch (com.huawei.hms.ads.dynamicloader.j e3) {
            throw e3;
        } catch (Exception e4) {
            aa.c(f22562a, "Failed to Query remote module version.".concat(String.valueOf(e4)));
            return tVar;
        }
    }

    private static Bundle e(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                aa.c(f22562a, "Query remote version failed: null contentResolver.");
                return null;
            }
            Bundle call = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, null, null);
            if (call == null) {
                aa.c(f22562a, "query module:" + str + " failed: null.");
                return null;
            }
            int i2 = call.getInt("errcode");
            if (i2 == 0) {
                i.put(str, call);
            }
            aa.b(f22562a, "Query module info result code:".concat(String.valueOf(i2)));
            return call;
        } catch (Exception e2) {
            aa.c(f22562a, "Query module:" + str + " info failed:" + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01df A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #0 {all -> 0x028e, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0014, B:9:0x0021, B:13:0x0046, B:15:0x006d, B:20:0x0080, B:23:0x0170, B:29:0x01d9, B:31:0x01df, B:34:0x01fb, B:34:0x01fb, B:35:0x01fe, B:32:0x01e9, B:24:0x017d, B:27:0x019d, B:33:0x01f4), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e9 A[Catch: all -> 0x028e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x028e, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0014, B:9:0x0021, B:13:0x0046, B:15:0x006d, B:20:0x0080, B:23:0x0170, B:29:0x01d9, B:31:0x01df, B:34:0x01fb, B:34:0x01fb, B:35:0x01fe, B:32:0x01e9, B:24:0x017d, B:27:0x019d, B:33:0x01f4), top: B:40:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.p.f(android.content.Context, java.lang.String):void");
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final Context a(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        try {
            aa.a(f22562a, "loader_path: " + tVar.d + ", dynamic_loader_path: " + com.huawei.hms.ads.dynamicloader.g.b);
            if (tVar.d.contains(f22563c)) {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", tVar.b);
                bundle.putString("module_name", tVar.f22571a);
                bundle.putInt("armeabiType", tVar.g);
                bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
                com.huawei.hms.ads.dynamicloader.h.a(context);
                return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
            }
            aa.b(f22562a, "The loader is not dynamicLoader，use it to load.");
            IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.d));
            if (asInterface == null) {
                aa.c(f22562a, "Get iDynamicLoader failed: null.");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("module_name", tVar.f22571a);
            bundle2.putString("loader_path", tVar.d);
            bundle2.putInt("module_version", tVar.f22572c);
            bundle2.putString(com.huawei.hms.ads.dynamicloader.b.e, tVar.e);
            return r.a(context, tVar.f22571a, bundle2, asInterface);
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception e3) {
            aa.d(f22562a, "Load DynamicModule failed.");
            Bundle bundle3 = new Bundle();
            bundle3.putInt("errcode", 6);
            throw new com.huawei.hms.ads.dynamicloader.j("load HMS dynamic module failed.", bundle3);
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final t a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        return d(context, str);
    }
}
