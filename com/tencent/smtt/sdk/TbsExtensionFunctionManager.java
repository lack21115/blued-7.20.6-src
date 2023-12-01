package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsExtensionFunctionManager.class */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";
    private static TbsExtensionFunctionManager b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f25077a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                try {
                    if (b == null) {
                        b = new TbsExtensionFunctionManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public boolean canUseFunction(Context context, String str) {
        boolean z;
        synchronized (this) {
            File file = new File(context.getFilesDir(), str);
            if (file.exists()) {
                if (file.isFile()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public int getRomCookieDBVersion(Context context) {
        synchronized (this) {
            SharedPreferences sharedPreferences = Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
            if (sharedPreferences == null) {
                return -1;
            }
            return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
        }
    }

    public void initTbsBuglyIfNeed(Context context) {
        String absolutePath;
        synchronized (this) {
            if (this.f25077a) {
                return;
            }
            if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
                TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
                return;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                File q = o.a().q(context);
                if (q == null) {
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                }
                if (q.listFiles() != null && q.listFiles().length > 0) {
                    absolutePath = q.getAbsolutePath();
                }
                TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                return;
            }
            absolutePath = TbsShareManager.c(context);
            if (TextUtils.isEmpty(absolutePath)) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                return;
            }
            File q2 = o.a().q(context);
            if (q2 == null) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                return;
            }
            File file = new File(absolutePath, "tbs_bugly_dex.jar");
            com.tencent.smtt.utils.i.a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, q2.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
            this.f25077a = true;
            TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
        }
    }

    public boolean setFunctionEnable(Context context, String str, boolean z) {
        synchronized (this) {
            if (context == null) {
                return false;
            }
            File file = new File(context.getFilesDir(), str);
            if (z) {
                if (!file.exists()) {
                    try {
                        if (file.createNewFile()) {
                            return true;
                        }
                    } catch (IOException e) {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                        e.printStackTrace();
                        return false;
                    }
                }
            } else if (file.exists()) {
                if (file.delete()) {
                    return true;
                }
                TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
                return false;
            }
            return true;
        }
    }
}
