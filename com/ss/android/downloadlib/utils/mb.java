package com.ss.android.downloadlib.utils;

import android.app.IActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.BrowserContract;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/mb.class */
public class mb {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.downloadlib.utils.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/mb$mb.class */
    public static class C0710mb implements InvocationHandler {
        private Object mb;

        private C0710mb(Object obj) {
            this.mb = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    mb.mb(objArr);
                }
            } catch (Throwable th) {
            }
            return method.invoke(this.mb, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        Class<?> cls;
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null || (cls = Class.forName(IActivityManager.descriptor)) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0710mb(obj2)));
        } catch (Throwable th) {
        }
    }

    public static int mb(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return TTMd5.checkMd5(str, new File(str2));
    }

    public static String mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TTMd5.ttmd5(new File(str));
    }

    public static void mb() {
        if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.mb.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.u.hj.ko();
                mb.b();
            }
        }, 10000L);
    }

    public static void mb(Object[] objArr) {
        boolean z = false;
        if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && DownloadConstants.MIME_APK.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.u.hj.b()) {
                    String optString = com.ss.android.downloadlib.addownload.x.lz().optString("hook_vivo_arg", "com.android.settings");
                    if (com.igexin.push.core.b.l.equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                } else if (!com.ss.android.socialbase.appdownloader.u.hj.hj()) {
                    if (com.ss.android.socialbase.appdownloader.u.hj.mb()) {
                        String optString2 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_huawei_arg1", t.W);
                        if (!com.igexin.push.core.b.l.equals(optString2)) {
                            objArr[1] = optString2;
                        }
                        intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.x.lz().optString("hook_huawei_arg2", t.W));
                    }
                } else {
                    String optString3 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg1", "com." + DownloadConstants.LOWER_OPPO + ".market");
                    if (!com.igexin.push.core.b.l.equals(optString3)) {
                        objArr[1] = optString3;
                    }
                    String optString4 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg2", BrowserContract.AUTHORITY);
                    String optString5 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg3", "m.store." + DownloadConstants.LOWER_OPPO + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DownloadConstants.LOWER_OPPO);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString4);
                    intent.putExtra("refererHost", optString5);
                    if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook_kllk_arg4", 0) == 1) {
                        z = true;
                    }
                    if (z) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(DownloadConstants.LOWER_OPPO + "_extra_pkg_name", optString4);
                        intent2.putExtra("refererHost", optString5);
                        intent.putExtra(Intent.EXTRA_INTENT, intent2);
                    }
                }
            }
        }
    }

    public static String ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.x.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
