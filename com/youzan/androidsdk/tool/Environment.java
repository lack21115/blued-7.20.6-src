package com.youzan.androidsdk.tool;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/Environment.class */
public final class Environment {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final AtomicInteger f1117 = new AtomicInteger(255);

    public static boolean appInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            synchronized (PackageManager.class) {
                context.getPackageManager().getPackageInfo(str, 1);
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void copyText(Context context, String str) {
        ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("textMessage", str));
    }

    public static int generateRequestId() {
        int i;
        int i2;
        do {
            i = f1117.get();
            int i3 = i + 1;
            i2 = i3;
            if (i3 >= 65535) {
                i2 = 255;
            }
        } while (!f1117.compareAndSet(i, i2));
        return i;
    }

    public static boolean isNetworkConnect(Context context) {
        return NetWorkUtil.isConnected(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m12240(Context context) {
        try {
            String packageName = context.getPackageName();
            String str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            return "App/" + packageName + "_v" + str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
