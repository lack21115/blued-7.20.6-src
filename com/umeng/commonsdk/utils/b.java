package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, PackageInfo> f27271a = new HashMap<>();
    private static Object b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f27272a = new b();

        private a() {
        }
    }

    private b() {
    }

    public static b a() {
        return a.f27272a;
    }

    public PackageInfo a(Context context, String str, int i) {
        PackageInfo packageInfo;
        synchronized (b) {
            if (f27271a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f27271a.get(str);
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, i);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f27271a.put(str, packageInfo);
                } catch (PackageManager.NameNotFoundException e) {
                    f27271a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                    packageInfo = null;
                }
            }
        }
        return packageInfo;
    }
}
