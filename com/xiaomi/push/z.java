package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/z.class */
public class z {
    public static long a() {
        File externalStorageDirectory;
        if (b() || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null || TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        } catch (Throwable th) {
            return 0L;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9173a() {
        try {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return !Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            Log.e("XMPush-", "check SDCard is busy: ".concat(String.valueOf(e)));
            return true;
        }
    }

    public static boolean c() {
        return a() <= 102400;
    }

    public static boolean d() {
        return (b() || c() || m9173a()) ? false : true;
    }
}
