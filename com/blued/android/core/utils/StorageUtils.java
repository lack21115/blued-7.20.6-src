package com.blued.android.core.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/StorageUtils.class */
public class StorageUtils {

    /* renamed from: com.blued.android.core.utils.StorageUtils$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/StorageUtils$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OnDiskFullListener a;

        @Override // java.lang.Runnable
        public void run() {
            if (AppInfo.d() != null) {
                long a = StorageUtils.a();
                long j = a;
                if (a <= 0) {
                    j = StorageUtils.c();
                }
                if (j > 0 && 52428800 >= j) {
                    GlideApp.a(AppInfo.d()).f();
                    if (this.a != null) {
                        AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.utils.StorageUtils.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass1.this.a != null) {
                                    AnonymousClass1.this.a.a();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/StorageUtils$OnDiskFullListener.class */
    public interface OnDiskFullListener {
        void a();
    }

    public static long a() {
        if (b()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return a(statFs) * b(statFs);
        }
        return -1L;
    }

    private static long a(StatFs statFs) {
        return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() : statFs.getBlockSizeLong();
    }

    private static long b(StatFs statFs) {
        return Build.VERSION.SDK_INT < 18 ? statFs.getAvailableBlocks() : statFs.getAvailableBlocksLong();
    }

    public static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return a(statFs) * b(statFs);
    }
}
