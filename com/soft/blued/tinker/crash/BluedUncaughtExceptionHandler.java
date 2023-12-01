package com.soft.blued.tinker.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.igexin.push.core.b;
import com.soft.blued.tinker.reporter.BluedTinkerReport;
import com.soft.blued.tinker.util.TinkerManager;
import com.soft.blued.tinker.util.Utils;
import com.soft.blued.utils.BluedPreferences;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/crash/BluedUncaughtExceptionHandler.class */
public class BluedUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f16087a = new HashMap();
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    private void a(Throwable th) {
        ApplicationLike a2 = TinkerManager.a();
        if (a2 == null || a2.getApplication() == null) {
            TinkerLog.w("UncaughtExHandler", "applicationlike is null", new Object[0]);
        } else if (!TinkerApplicationHelper.isTinkerLoadSuccess(a2)) {
            TinkerLog.w("UncaughtExHandler", "tinker is not loaded", new Object[0]);
        } else {
            boolean z = false;
            while (true) {
                boolean z2 = z;
                if (th == null) {
                    return;
                }
                boolean z3 = z2;
                if (!z2) {
                    z3 = Utils.a(th);
                }
                if (z3) {
                    if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        BluedTinkerReport.f();
                        TinkerLog.e("UncaughtExHandler", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.killAllOtherProcess(a2.getApplication());
                        TinkerApplicationHelper.cleanPatch(a2);
                        ShareTinkerInternals.setTinkerDisableWithSharedPreferences(a2.getApplication());
                        return;
                    }
                }
                th = th.getCause();
                z = z3;
            }
        }
    }

    private boolean a() {
        ApplicationLike a2 = TinkerManager.a();
        if (a2 == null || a2.getApplication() == null || !TinkerApplicationHelper.isTinkerLoadSuccess(a2) || SystemClock.elapsedRealtime() - a2.getApplicationStartElapsedTime() >= 10000) {
            return false;
        }
        String currentVersion = TinkerApplicationHelper.getCurrentVersion(a2);
        if (ShareTinkerInternals.isNullOrNil(currentVersion)) {
            return false;
        }
        SharedPreferences sharedPreferences = a2.getApplication().getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4);
        int i = sharedPreferences.getInt(currentVersion, 0) + 1;
        if (i < 3) {
            sharedPreferences.edit().putInt(currentVersion, i).commit();
            TinkerLog.e("UncaughtExHandler", "tinker has fast crash %d times", Integer.valueOf(i));
            return false;
        }
        BluedTinkerReport.e();
        TinkerApplicationHelper.cleanPatch(a2);
        TinkerLog.e("UncaughtExHandler", "tinker has fast crash more than %d, we just clean patch!", Integer.valueOf(i));
        return true;
    }

    private void b(Throwable th) {
        a(AppInfo.d());
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.f16087a.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append(key + "=" + value + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        Throwable cause = th.getCause();
        while (true) {
            Throwable th2 = cause;
            if (th2 == null) {
                printWriter.close();
                stringBuffer.append(stringWriter.toString());
                BluedPreferences.ap(stringBuffer.toString());
                return;
            }
            th2.printStackTrace(printWriter);
            cause = th2.getCause();
        }
    }

    public void a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? b.l : packageInfo.versionName;
                this.f16087a.put("versionName", str);
                this.f16087a.put("versionCode", packageInfo.versionCode + "");
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("UncaughtExHandler", "an error occured when collect package info", e);
        }
        Field[] declaredFields = Build.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Field field = declaredFields[i2];
            try {
                field.setAccessible(true);
                this.f16087a.put(field.getName(), field.get(null).toString());
                Log.d("UncaughtExHandler", field.getName() + " : " + field.get(null));
            } catch (Exception e2) {
                Log.e("UncaughtExHandler", "an error occured when collect crash info", e2);
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        TinkerLog.e("UncaughtExHandler", "uncaughtException:", new Object[0]);
        if (th != null) {
            TinkerLog.e("UncaughtExHandler", th.getMessage(), new Object[0]);
        }
        b(th);
        a();
        a(th);
        if (this.b == null || thread == null || th == null) {
            return;
        }
        TinkerLog.e("UncaughtExHandler", "uncaughtException report", new Object[0]);
        this.b.uncaughtException(thread, th);
    }
}
