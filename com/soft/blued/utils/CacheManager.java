package com.soft.blued.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.utils.FileUtil;
import com.soft.blued.R;
import java.io.File;
import java.text.DecimalFormat;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CacheManager.class */
public class CacheManager {
    private static String[] e;

    /* renamed from: a  reason: collision with root package name */
    private File f34724a;
    private File b;

    /* renamed from: c  reason: collision with root package name */
    private File f34725c;
    private File d;

    public CacheManager() {
        e = AppInfo.d().getResources().getStringArray(R.array.cache_whitelist);
        this.b = AppInfo.d().getExternalCacheDir();
        this.f34724a = AppInfo.d().getCacheDir();
        this.f34725c = AppInfo.d().getFilesDir();
        this.d = AppInfo.d().getExternalFilesDir(null);
    }

    private static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str.trim());
        long j = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                return b(file);
            }
            j = 0;
            if (file.isFile()) {
                j = file.length();
            }
        }
        return j;
    }

    private static String a(long j) {
        if (j == 0) {
            return "0M";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        DecimalFormat decimalFormat2 = new DecimalFormat("#0");
        if (j < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
            return "0M";
        }
        double d = j / 1048576.0d;
        if (d < 100.0d) {
            return decimalFormat.format(d) + "M";
        }
        return decimalFormat2.format(d) + "M";
    }

    private static long b(File file) {
        File[] listFiles;
        long j;
        long j2;
        long length;
        long j3 = 0;
        if (file != null) {
            j2 = 0;
            try {
                if (b(file.getAbsolutePath())) {
                    return 0L;
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                j = j2;
            }
        }
        if (file == null || (listFiles = file.listFiles()) == null) {
            return 0L;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            j = j3;
            j2 = j3;
            if (i2 >= listFiles.length) {
                break;
            }
            long j4 = j3;
            if (listFiles[i2].isDirectory()) {
                long j5 = j3;
                length = b(listFiles[i2]);
            } else {
                length = listFiles[i2].length();
            }
            j3 += length;
            i = i2 + 1;
        }
        return j;
    }

    private static boolean b(String str) {
        if (StringUtils.d(str) || !str.contains(BridgeUtil.SPLIT_MARK)) {
            return false;
        }
        String str2 = str.split(BridgeUtil.SPLIT_MARK)[str.split(BridgeUtil.SPLIT_MARK).length - 1];
        if (e == null || StringUtils.d(str2)) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = e;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str2.equals(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean c() {
        boolean z;
        boolean z2;
        String externalStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(externalStorageState)) {
            z = true;
            z2 = true;
        } else {
            z = Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState);
            z2 = false;
        }
        boolean z3 = false;
        if (z) {
            z3 = false;
            if (z2) {
                z3 = true;
            }
        }
        return z3;
    }

    public String a() {
        long j;
        long j2;
        if (c() && this.f34724a != null && this.b != null) {
            j = a(this.f34724a.getAbsolutePath() + BridgeUtil.SPLIT_MARK) + a(this.b.getAbsolutePath() + BridgeUtil.SPLIT_MARK);
        } else if (this.f34724a != null) {
            j = a(this.f34724a.getAbsolutePath() + BridgeUtil.SPLIT_MARK);
        } else {
            j = 0;
        }
        if (!c() || this.f34725c == null || this.d == null) {
            j2 = j;
            if (this.f34725c != null) {
                j2 = j + a(this.f34725c.getAbsolutePath() + BridgeUtil.SPLIT_MARK);
            }
        } else {
            j2 = j + a(this.f34725c.getAbsolutePath() + BridgeUtil.SPLIT_MARK) + a(this.d.getAbsolutePath() + BridgeUtil.SPLIT_MARK);
        }
        return a(j2);
    }

    public boolean a(File file) {
        File[] listFiles;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                file.delete();
                return false;
            } else if (!file.isDirectory() || b(file.getAbsolutePath()) || (listFiles = file.listFiles()) == null) {
                return false;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        return false;
                    }
                    a(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void b() {
        a(this.f34724a);
        a(this.b);
        a(this.f34725c);
        a(this.d);
        if (AppInfo.n() != null) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.utils.CacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    RecyclingImageLoader.d();
                    ImageLoader.b();
                }
            });
        }
    }
}
