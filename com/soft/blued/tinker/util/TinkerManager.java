package com.soft.blued.tinker.util;

import com.soft.blued.tinker.crash.BluedUncaughtExceptionHandler;
import com.soft.blued.tinker.reporter.BluedLoadReporter;
import com.soft.blued.tinker.reporter.BluedPatchListener;
import com.soft.blued.tinker.reporter.BluedPatchReporter;
import com.soft.blued.tinker.service.PatchLoadResultService;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/util/TinkerManager.class */
public class TinkerManager {

    /* renamed from: a  reason: collision with root package name */
    private static ApplicationLike f16095a;
    private static BluedUncaughtExceptionHandler b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16096c = false;

    public static ApplicationLike a() {
        return f16095a;
    }

    public static void a(ApplicationLike applicationLike) {
        f16095a = applicationLike;
    }

    public static void a(boolean z) {
        UpgradePatchRetry.getInstance(f16095a.getApplication()).setRetryEnable(z);
    }

    public static void b() {
        if (b == null) {
            BluedUncaughtExceptionHandler bluedUncaughtExceptionHandler = new BluedUncaughtExceptionHandler();
            b = bluedUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(bluedUncaughtExceptionHandler);
        }
    }

    public static void b(ApplicationLike applicationLike) {
        if (f16096c) {
            TinkerLog.w("Tinker.TinkerManager", "install tinker, but has installed, ignore", new Object[0]);
            return;
        }
        TinkerInstaller.install(applicationLike, new BluedLoadReporter(applicationLike.getApplication()), new BluedPatchReporter(applicationLike.getApplication()), new BluedPatchListener(applicationLike.getApplication()), PatchLoadResultService.class, new UpgradePatch());
        f16096c = true;
    }
}
