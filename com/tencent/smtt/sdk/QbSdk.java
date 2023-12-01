package com.tencent.smtt.sdk;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.at;
import com.huawei.hms.ads.fw;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.youzan.spiderman.utils.Stone;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/QbSdk.class */
public class QbSdk {
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String FILERADER_MENUDATA = "menuData";
    public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f25024c = true;
    static String d;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    private static int o = 0;
    private static String p = "";
    private static Class<?> q;
    private static Object r;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static String[] t;
    private static String u = "NULL";
    private static String v = "UNKNOWN";
    static Object h = new Object();
    public static boolean isDefaultDialog = false;
    private static boolean w = false;
    static boolean i = true;
    static boolean j = true;
    static boolean k = false;
    private static int x = 0;
    private static int y = 170;
    private static String z = null;
    private static String A = null;

    /* renamed from: a  reason: collision with root package name */
    static boolean f25023a = false;
    static volatile boolean l = f25023a;
    public static boolean mDisableUseHostBackupCore = false;
    private static boolean B = false;
    private static boolean C = true;
    private static TbsListener D = null;
    private static TbsListener E = null;
    private static boolean F = false;
    private static boolean G = false;
    static TbsListener m = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.7
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i2) {
            if (TbsDownloader.needDownloadDecoupleCore()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                TbsDownloader.f25073a = true;
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            TbsDownloader.f25073a = false;
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadFinish(i2);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadFinish(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i2) {
            if (QbSdk.E != null) {
                QbSdk.E.onDownloadProgress(i2);
            }
            if (QbSdk.D != null) {
                QbSdk.D.onDownloadProgress(i2);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i2) {
            if (i2 != 200) {
            }
            boolean z2 = false;
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.f25073a = false;
            if (TbsDownloader.startDecoupleCoreIfNeeded()) {
                z2 = true;
            }
            TbsDownloader.f25073a = z2;
            if (QbSdk.D != null) {
                QbSdk.D.onInstallFinish(i2);
            }
            if (QbSdk.E != null) {
                QbSdk.E.onInstallFinish(i2);
            }
        }
    };
    static Map<String, Object> n = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/QbSdk$PreInitCallback.class */
    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(Context context, Bundle bundle) throws Exception {
        TbsLogReport tbsLogReport;
        String str;
        if (a(context)) {
            Object a2 = com.tencent.smtt.utils.i.a(r, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a2 != null) {
                return (Bundle) a2;
            }
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "incrUpdate return null!";
        } else {
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "initForPatch return false!";
        }
        tbsLogReport.setInstallErrorCode(216, str);
        return null;
    }

    private static Bundle a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor(map.get("topBarBgColor")));
            } catch (Exception e2) {
            }
            if (map != null && map.containsKey(FILERADER_MENUDATA)) {
                JSONObject jSONObject = new JSONObject(map.get(FILERADER_MENUDATA));
                JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= jSONArray.length() || i3 >= 5) {
                            break;
                        }
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                            arrayList.add(i3, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt(SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID)));
                            jSONObject2.put(SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID, i3);
                        } catch (Exception e3) {
                        }
                        i2 = i3 + 1;
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Context context, String str, Bundle bundle) {
        if (a(context)) {
            Object a2 = com.tencent.smtt.utils.i.a(r, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
            if (a2 != null) {
                return a2;
            }
            return null;
        }
        return Integer.valueOf((int) EXTENSION_INIT_FAILURE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Integer num, Map<Integer, String> map) {
        if (a(context)) {
            com.tencent.smtt.utils.i.a(r, "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        synchronized (QbSdk.class) {
            try {
                if (f25023a) {
                    return;
                }
                f25023a = true;
                v = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
                TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(v));
            } finally {
            }
        }
    }

    static boolean a(Context context) {
        try {
            if (q != null) {
                return true;
            }
            File q2 = o.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(q2, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            w.a().b(context);
            com.tencent.smtt.utils.l.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, q2.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i2) {
        return a(context, i2, 20000);
    }

    static boolean a(Context context, int i2, int i3) {
        Map<String, Object> map = n;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        }
        o.a().b(context, f.f25153a == 0);
        if (c(context)) {
            Object a2 = com.tencent.smtt.utils.i.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), 43967, Integer.valueOf(i3));
            if (a2 == null) {
                a2 = com.tencent.smtt.utils.i.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), 43967);
                if (a2 == null) {
                    return true;
                }
            }
            return ((Boolean) a2).booleanValue();
        }
        return true;
    }

    private static boolean a(Context context, String str, String str2) {
        return isSuportOpenFile(str2, 2);
    }

    private static boolean a(Context context, boolean z2) {
        int i2;
        File file;
        TbsCoreLoadStat tbsCoreLoadStat;
        int i3;
        Exception exc;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43967; SDK_VERSION_NAME: 4.3.0.67");
            sIsVersionPrinted = true;
        }
        if (f25023a && !z2) {
            TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            TbsCoreLoadStat.getInstance().a(context, 414, new Throwable(v));
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(u));
            return false;
        } else {
            if (!C) {
                d(context);
            }
            try {
                File q2 = o.a().q(context);
                if (q2 == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    if (o != 0 && o != TbsShareManager.d(context)) {
                        q = null;
                        r = null;
                        TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                        TbsCoreLoadStat.getInstance().a(context, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                        return false;
                    }
                    i2 = TbsShareManager.d(context);
                } else if (o != 0) {
                    int a2 = o.a().a(true, context);
                    i2 = a2;
                    if (o != a2) {
                        q = null;
                        r = null;
                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + a2, true);
                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                        TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + a2));
                        return false;
                    }
                } else {
                    i2 = 0;
                }
                o = i2;
                if (TbsDownloader.a(context, o)) {
                    TbsLog.i("QbSdk", "version " + o + " is in blacklist,can not load! return");
                    return false;
                } else if (q == null || r == null) {
                    if (!TbsShareManager.isThirdPartyApp(context)) {
                        file = new File(o.a().q(context), "tbs_sdk_extension_dex.jar");
                    } else if (!TbsShareManager.j(context)) {
                        TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    } else {
                        file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                    }
                    if (file.exists()) {
                        String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q2.getAbsolutePath();
                        TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + hostCorePathAppDefined);
                        TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                        w.a().b(context);
                        com.tencent.smtt.utils.l.a(context);
                        q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                        loadTBSSDKExtension(context, file.getParent());
                        com.tencent.smtt.utils.i.a(r, "setClientVersion", new Class[]{Integer.TYPE}, 1);
                        return true;
                    }
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    int i4 = o.a().i(context);
                    if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i4 > 0) {
                            tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                            i3 = 4131;
                            exc = new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4);
                        } else {
                            tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                            i3 = 4132;
                            exc = new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i4);
                        }
                    } else if (i4 > 0) {
                        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                        i3 = 4121;
                        exc = new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4);
                    } else {
                        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                        i3 = 4122;
                        exc = new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i4);
                    }
                    tbsCoreLoadStat.a(context, i3, exc);
                    return false;
                } else {
                    return true;
                }
            } catch (Throwable th) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th));
                TbsCoreLoadStat.getInstance().a(context, 306, th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x024c, code lost:
        if (r0 > 25442) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.a(android.content.Context, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        Object invokeStaticMethod;
        w a2 = w.a();
        if (a2 == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0])) == null || !(invokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    static boolean b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                TbsLog.i("QbSdk", "clearPluginConfigFile #1");
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
                String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
                TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
                if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                    return true;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();
                TbsLog.i("QbSdk", "clearPluginConfigFile done");
                return true;
            }
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    private static boolean c(Context context) {
        File file;
        try {
            if (q != null) {
                return true;
            }
            File q2 = o.a().q(context);
            if (q2 == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(o.a().q(context), "tbs_sdk_extension_dex.jar");
            } else if (!TbsShareManager.j(context)) {
                TbsCoreLoadStat.getInstance().a(context, 304);
                return false;
            } else {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            }
            if (!file.exists()) {
                TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q2.getAbsolutePath();
            TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + hostCorePathAppDefined);
            TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            w.a().b(context);
            com.tencent.smtt.utils.l.a(context);
            q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            com.tencent.smtt.utils.i.a(r, "setClientVersion", new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean canLoadVideo(android.content.Context r8) {
        /*
            java.lang.Object r0 = com.tencent.smtt.sdk.QbSdk.r
            java.lang.String r1 = "canLoadVideo"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]
            r3 = r2
            r4 = 0
            java.lang.Class r5 = java.lang.Integer.TYPE
            r3[r4] = r5
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r3
            r5 = 0
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r5] = r6
            java.lang.Object r0 = com.tencent.smtt.utils.i.a(r0, r1, r2, r3)
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L38
            r0 = r11
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L46
            com.tencent.smtt.sdk.TbsCoreLoadStat r0 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance()
            r10 = r0
            r0 = 313(0x139, float:4.39E-43)
            r9 = r0
            goto L40
        L38:
            com.tencent.smtt.sdk.TbsCoreLoadStat r0 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance()
            r10 = r0
            r0 = 314(0x13a, float:4.4E-43)
            r9 = r0
        L40:
            r0 = r10
            r1 = r8
            r2 = r9
            r0.a(r1, r2)
        L46:
            r0 = r11
            if (r0 != 0) goto L4c
            r0 = 0
            return r0
        L4c:
            r0 = r11
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.canLoadVideo(android.content.Context):boolean");
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && Build.VERSION.SDK_INT == 19) {
                return true;
            }
            if (q == null) {
                File q2 = o.a().q(context);
                if (q2 == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (!file.exists()) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
                String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q2.getAbsolutePath();
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + hostCorePathAppDefined);
                TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                w.a().b(context);
                com.tencent.smtt.utils.l.a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (r == null) {
                    if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                        return false;
                    }
                    loadTBSSDKExtension(context, file.getParent());
                }
            }
            Object a2 = com.tencent.smtt.utils.i.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            if (a2 == null || !(a2 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.smtt.sdk.QbSdk$1] */
    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                w a2 = w.a();
                a2.a(Context.this);
                final boolean a3 = a2.b() ? a2.c().a(Context.this, str) : false;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(a3));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        a(context, false);
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x01f9 -> B:131:0x00ce). Please submit an issue!!! */
    public static boolean canOpenWebPlus(Context context) {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream2;
        boolean z2;
        FileInputStream fileInputStream2;
        if (x == 0) {
            x = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + x);
        if (Build.VERSION.SDK_INT < 7 || x < y || context == null) {
            return false;
        }
        try {
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(o.a().q(context), "tbs.conf")));
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("android_sdk_max_supported");
            String property2 = properties.getProperty("android_sdk_min_supported");
            int parseInt = Integer.parseInt(property);
            int parseInt2 = Integer.parseInt(property2);
            int parseInt3 = Integer.parseInt(Build.VERSION.SDK);
            if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                try {
                    bufferedInputStream2.close();
                    return false;
                } catch (Exception e2) {
                    return false;
                }
            }
            int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
            try {
                bufferedInputStream2.close();
            } catch (Exception e3) {
            }
            try {
                fileInputStream2 = new FileInputStream(new File(o.s(context), "tbs_extension.conf"));
            } catch (Throwable th2) {
                fileInputStream = null;
            }
            try {
                Properties properties2 = new Properties();
                properties2.load(fileInputStream2);
                int parseInt5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                int parseInt6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                z2 = false;
                if (parseInt4 != 88888888) {
                    if (parseInt5 == 88888888) {
                        z2 = false;
                    } else if (parseInt4 > parseInt5) {
                        z2 = false;
                    } else {
                        z2 = false;
                        if (parseInt4 == parseInt5) {
                            if (parseInt6 <= 0 || parseInt6 == com.tencent.smtt.utils.b.d(context)) {
                                z2 = false;
                                if (Boolean.parseBoolean(properties2.getProperty("x5_disabled"))) {
                                    z2 = false;
                                    if (!TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false)) {
                                        z2 = true;
                                    }
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    }
                }
                try {
                    fileInputStream2.close();
                } catch (Exception e4) {
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                try {
                    TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    z2 = true;
                    return !z2;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                }
            }
            return !z2;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = bufferedInputStream2;
            try {
                th.printStackTrace();
                TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Exception e7) {
                        return false;
                    }
                }
                return false;
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e8) {
                    }
                }
            }
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i2) {
        Object a2 = com.tencent.smtt.utils.i.a(r, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        boolean z2 = false;
        if (a2 != null) {
            z2 = false;
            if (a2 instanceof Boolean) {
                z2 = ((Boolean) a2).booleanValue();
            }
        }
        return z2;
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        boolean z2 = true;
        if (context != null) {
            z2 = true;
            if (context.getApplicationInfo().targetSdkVersion >= 24) {
                z2 = true;
                if (Build.VERSION.SDK_INT >= 24) {
                    z2 = true;
                    if (!"com.tencent.mobileqq".equals(context.getApplicationInfo().packageName)) {
                        try {
                            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority)) {
                                return true;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
                        if (resolveContentProvider == null) {
                            Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
                        }
                        if (resolveContentProvider != null) {
                            return true;
                        }
                        z2 = false;
                    }
                }
            }
        }
        return z2;
    }

    public static void checkTbsValidity(Context context) {
        if (context == null || com.tencent.smtt.utils.l.b(context)) {
            return;
        }
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
        TbsCoreLoadStat.getInstance().a(context, 419);
        forceSysWebView();
    }

    public static void clear(Context context) {
    }

    public static void clearAllDefaultBrowser(Context context) {
        context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0).edit().clear().commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void clearAllWebViewCache(android.content.Context r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.clearAllWebViewCache(android.content.Context, boolean):void");
    }

    public static void clearDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String e2 = com.tencent.smtt.sdk.ui.dialog.e.e(str);
        String str2 = e2;
        if (TextUtils.isEmpty(e2)) {
            str2 = "*/*";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("key_tbs_picked_default_browser_" + str2).commit();
    }

    public static void closeFileReader(Context context) {
        w a2 = w.a();
        a2.a(context);
        if (a2.b()) {
            a2.c().p();
        }
    }

    public static String closeNetLogAndSavaToLocal() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return "";
        }
        try {
            Object invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
            return (invokeStaticMethod == null || !(invokeStaticMethod instanceof String)) ? "" : (String) invokeStaticMethod;
        } catch (Exception e2) {
            return "";
        }
    }

    public static void continueLoadSo(Context context) {
        if ("com.tencent.mm".equals(getCurrentProcessName(context)) && WebView.mWebViewCreated) {
            com.tencent.smtt.utils.i.a(r, "continueLoadSo", new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        w a2;
        if (context == null || TbsDownloader.getOverSea(context) || isMiniQBShortCutExist(context, str, str2) || (a2 = w.a()) == null || !a2.b()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader b2 = a2.c().b();
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.d(android.content.Context):void");
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        w a2;
        return (context == null || TbsDownloader.getOverSea(context) || (a2 = w.a()) == null || !a2.b() || a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) == null) ? false : true;
    }

    public static void disAllowThirdAppDownload() {
        f25024c = false;
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static void fileInfoDetect(Context context, String str, android.webkit.ValueCallback<String> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void forceSysWebView() {
        b = true;
        u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        long j2 = 0;
        if (context != null) {
            j2 = TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
        }
        return j2;
    }

    public static String getCurrentProcessName(Context context) {
        FileInputStream fileInputStream;
        int i2;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[256];
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    int read = fileInputStream.read();
                    if (read <= 0 || i2 >= 256) {
                        break;
                    }
                    bArr[i2] = (byte) read;
                    i3 = i2 + 1;
                }
                if (i2 <= 0) {
                    fileInputStream.close();
                    return null;
                }
                String str = new String(bArr, 0, i2, "UTF-8");
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = t;
        if (!(strArr instanceof String[])) {
            String[] a2 = com.tencent.smtt.utils.i.a(r, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
            if (!(a2 instanceof String[])) {
                a2 = new String[]{""};
            }
            return (String[]) a2;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = str + t[i2];
        }
        return strArr2;
    }

    public static boolean getDownloadWithoutWifi() {
        return F;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        String str;
        Object obj = r;
        if (obj == null) {
            str = "getJarFilesAndLibraryPath sExtensionObj is null";
        } else {
            Bundle bundle = (Bundle) com.tencent.smtt.utils.i.a(obj, "canLoadX5CoreAndNotLoadSo", new Class[]{Integer.TYPE}, 43967);
            if (bundle != null) {
                t = bundle.getStringArray("tbs_jarfiles");
                d = bundle.getString("tbs_librarypath");
                return true;
            }
            str = "getJarFilesAndLibraryPath bundle is null and coreverison is " + o.a().a(true, context);
        }
        TbsLog.i("QbSdk", str);
        return false;
    }

    public static String getMiniQBVersion(Context context) {
        w a2 = w.a();
        a2.a(context);
        if (a2 == null || !a2.b()) {
            return null;
        }
        return a2.c().f();
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    public static String getQQBuildNumber() {
        return A;
    }

    public static Map<String, Object> getSettings() {
        return n;
    }

    public static boolean getTBSInstalling() {
        return G;
    }

    public static String getTID() {
        return z;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (com.tencent.smtt.utils.b.d()) {
                return context.getDir("tbs_64", 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return context.getDir("tbs", 0);
    }

    public static String getTbsResourcesPath(Context context) {
        return TbsShareManager.g(context);
    }

    public static int getTbsSdkVersion() {
        return 43967;
    }

    public static int getTbsVersion(Context context) {
        return TbsShareManager.isThirdPartyApp(context) ? TbsShareManager.a(context, false) : o.a().i(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int j2 = o.a().j(context);
        if (j2 == 0 && m.a(context).c() == 3) {
            reset(context);
        }
        return j2;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (m.a(context).c() == 2) {
            return o.a().e(context, 0);
        }
        if (m.a(context).b("copy_status") == 1) {
            return o.a().e(context, 1);
        }
        return 0;
    }

    public static void initBuglyAsync(boolean z2) {
        i = z2;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        String str;
        if (q == null) {
            File q2 = o.a().q(context);
            if (q2 == null) {
                str = "QbSdk initForinitAndNotLoadSo optDir == null";
            } else {
                File file = new File(q2, "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String absolutePath = q2.getAbsolutePath();
                    w.a().b(context);
                    com.tencent.smtt.utils.l.a(context);
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    return;
                }
                str = "QbSdk initForinitAndNotLoadSo dexFile.exists()=false";
            }
            Log.e("QbSdk", str);
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = n;
        if (map2 == null) {
            n = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        TbsLog.initIfNeed(context);
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        b(context);
        E = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i2) {
                QbSdk.preInit(Context.this, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            o.a().b(context, f.f25153a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.6
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z2, int i2) {
                if (TbsShareManager.findCoreForThirdPartyApp(Context.this) == 0 && !TbsShareManager.getCoreDisabled()) {
                    TbsShareManager.forceToLoadX5ForThirdApp(Context.this, false);
                }
                if (QbSdk.i && TbsShareManager.isThirdPartyApp(Context.this)) {
                    TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(Context.this);
                }
                QbSdk.preInit(Context.this, preInitCallback);
            }
        });
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        f a2 = f.a(true);
        a2.a(context, false, false);
        if (a2 == null || !a2.b()) {
            return false;
        }
        return a2.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        if (webView == null) {
            return false;
        }
        String str4 = str;
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = "unknown";
            }
            hashMap.put("ChannelID", str3);
            hashMap.put("PosID", "14004");
            if (MttLoader.loadUrl(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
                return false;
            }
            w a2 = w.a();
            str4 = substring;
            if (a2 != null) {
                str4 = substring;
                if (a2.b()) {
                    str4 = substring;
                    if (a2.c().a(context, substring, null, str2, null) == 0) {
                        return true;
                    }
                }
            }
        }
        webView.loadUrl(str4);
        return false;
    }

    public static boolean isInDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String e2 = com.tencent.smtt.sdk.ui.dialog.e.e(str);
        String str2 = e2;
        if (TextUtils.isEmpty(e2)) {
            str2 = "*/*";
        }
        return sharedPreferences.contains("key_tbs_picked_default_browser_" + str2);
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        w a2;
        Object invokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (a2 = w.a()) == null || !a2.b() || (invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = false;
        if (invokeStaticMethod instanceof Boolean) {
            bool = (Boolean) invokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return w;
    }

    public static boolean isSuportOpenFile(String str, int i2) {
        List asList;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 == 1) {
            asList = Arrays.asList("doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub");
        } else if (i2 != 2) {
            return false;
        } else {
            asList = Arrays.asList("rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", com.baidu.mobads.sdk.internal.a.f, "htm", "xml", "mht", "url", "ini", "log", "bat", "php", Stone.JS_SUFFIX, "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", com.kuaishou.weapon.p0.t.w, "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx");
        }
        return asList.contains(str.toLowerCase());
    }

    public static boolean isTbsCoreInited() {
        f a2 = f.a(false);
        boolean z2 = false;
        if (a2 != null) {
            z2 = false;
            if (a2.g()) {
                z2 = true;
            }
        }
        return z2;
    }

    public static boolean isX5DisabledSync(Context context) {
        if (m.a(context).c() == 2) {
            return false;
        }
        if (c(context)) {
            Object a2 = com.tencent.smtt.utils.i.a(r, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(o.a().i(context)), 43967);
            if (a2 != null) {
                return ((Boolean) a2).booleanValue();
            }
            return true;
        }
        return true;
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z2;
        Object newInstance;
        if (r != null) {
            return;
        }
        synchronized (QbSdk.class) {
            try {
                if (r != null) {
                    return;
                }
                if (q == null) {
                    TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
                }
                try {
                    constructor = q.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                    z2 = true;
                } catch (Throwable th) {
                    constructor = null;
                    z2 = false;
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    Context e2 = TbsShareManager.e(context);
                    if (e2 == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                        return;
                    }
                    Context context2 = context;
                    if (context.getApplicationContext() != null) {
                        context2 = context.getApplicationContext();
                    }
                    newInstance = !z2 ? e2 == null ? q.getConstructor(Context.class, Context.class, String.class).newInstance(context2, e2, TbsShareManager.getHostCorePathAppDefined(), str, null) : q.getConstructor(Context.class, Context.class).newInstance(context2, e2) : constructor.newInstance(context2, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                } else if (z2) {
                    String str2 = (!"com.tencent.mm".equals(getCurrentProcessName(context)) || WebView.mWebViewCreated) ? null : "notLoadSo";
                    Context context3 = context;
                    if (context.getApplicationContext() != null) {
                        context3 = context.getApplicationContext();
                    }
                    newInstance = constructor.newInstance(context3, context3, null, str, str2);
                } else {
                    Constructor<?> constructor2 = q.getConstructor(Context.class, Context.class);
                    Context context4 = context;
                    if (context.getApplicationContext() != null) {
                        context4 = context.getApplicationContext();
                    }
                    newInstance = constructor2.newInstance(context4, context4);
                }
                r = newInstance;
            } finally {
            }
        }
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        String str2;
        if (context == null) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse(str));
        String e2 = com.tencent.smtt.sdk.ui.dialog.e.e(str);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.ui.dialog.d dVar = new com.tencent.smtt.sdk.ui.dialog.d(context, "选择其它应用打开", intent, bundle, valueCallback, e2, string);
        String a2 = dVar.a();
        if (a2 != null && !TextUtils.isEmpty(a2)) {
            if (TbsConfig.APP_QB.equals(a2)) {
                intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                intent.putExtra("PosID", "4");
            }
            intent.setPackage(a2);
            intent.putExtra("big_brother_source_key", string);
            context.startActivity(intent);
            if (valueCallback == null) {
                return;
            }
            str2 = "default browser:" + a2;
        } else if (!isDefaultDialog) {
            dVar.show();
            dVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ValueCallback valueCallback2 = ValueCallback.this;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                    }
                }
            });
            return;
        } else {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
            if (valueCallback == null) {
                return;
            }
            str2 = "can not open";
        }
        valueCallback.onReceiveValue(str2);
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        String str2;
        TbsCoreLoadStat.getInstance().a(context, 505);
        if (checkContentProviderPrivilage(context)) {
            if (str == null) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("filepath error");
                }
                TbsCoreLoadStat.getInstance().a(context, 509);
                Log.e("QbSdk", "open openFileReader filepath error ret -1");
                return -1;
            }
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            String str3 = substring;
            if (substring != null) {
                str3 = substring.toLowerCase();
            }
            if ("apk".equalsIgnoreCase(str3)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                Uri a2 = FileProvider.a(context, str);
                if (a2 == null) {
                    valueCallback.onReceiveValue("uri failed");
                    return -6;
                }
                intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                TbsCoreLoadStat.getInstance().a(context, 506);
                Log.e("QbSdk", "open openFileReader ret = 4");
                return 4;
            }
            if (!MttLoader.isBrowserInstalled(context)) {
                str2 = "openFileReader QQ browser not installed";
            } else if (!a(context, str, str3)) {
                Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsCoreLoadStat.getInstance().a(context, 507);
                return 3;
            } else if (startQBForDoc(context, str, 4, 0, str3, a(context, hashMap))) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("open QB");
                }
                TbsCoreLoadStat.getInstance().a(context, 507);
                Log.e("QbSdk", "open openFileReader open QB ret = 1");
                return 1;
            } else {
                str2 = "openFileReader startQBForDoc return false";
            }
            Log.d("QbSdk", str2);
            HashMap<String, String> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
            }
            hashMap2.put(at.f6479a, fw.Code);
            TbsLog.setWriteLogJIT(true);
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap2, valueCallback);
            if (startMiniQBToLoadUrl == 0) {
                TbsCoreLoadStat.getInstance().a(context, 510);
                return 2;
            }
            openFileReaderListWithQBDownload(context, str, valueCallback);
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setLoadErrorCode(511, "" + startMiniQBToLoadUrl);
            return 3;
        }
        return -5;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        String str2;
        if (context == null || context.getApplicationInfo().packageName.equals("com.tencent.qim") || context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        String e2 = com.tencent.smtt.sdk.ui.dialog.e.e(str);
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        Uri a2 = FileProvider.a(context, str);
        if (a2 == null) {
            TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,uri failed");
            valueCallback.onReceiveValue("uri failed");
            return;
        }
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,fileUri:" + str + ",mimeType:" + e2);
        intent.setDataAndType(a2, e2);
        isDefaultDialog = false;
        com.tencent.smtt.sdk.ui.dialog.d dVar = new com.tencent.smtt.sdk.ui.dialog.d(context, "选择其它应用打开", intent, bundle, valueCallback, e2, string);
        String a3 = dVar.a();
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,defaultBrowser:" + a3);
        if (a3 != null && !TextUtils.isEmpty(a3) && a3.startsWith("extraMenuEvent:")) {
            TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default extra menu action");
            valueCallback.onReceiveValue(a3);
        } else if (a3 != null && !TextUtils.isEmpty(a3) && checkApkExist(context, a3)) {
            TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default normal menu action");
            if (TbsConfig.APP_QB.equals(a3)) {
                intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                intent.putExtra("PosID", "4");
            }
            if (!TextUtils.isEmpty(string)) {
                intent.putExtra("big_brother_source_key", string);
            }
            intent.setPackage(a3);
            context.startActivity(intent);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("default browser:" + a3);
            }
        } else if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && isDefaultDialog) {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
        } else {
            if (isDefaultDialog) {
                TbsLog.i("QbSdk", "isDefaultDialog=true");
                if (valueCallback != null) {
                    TbsLog.i("QbSdk", "isDefaultDialog=true, can not open");
                    str2 = "can not open";
                    valueCallback.onReceiveValue(str2);
                }
            } else {
                try {
                    TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog");
                    dVar.show();
                    dVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.9
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            ValueCallback valueCallback2 = ValueCallback.this;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                            }
                        }
                    });
                } catch (Exception e3) {
                    e3.printStackTrace();
                    TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog, but failed");
                    str2 = "TbsReaderDialogClosed";
                }
            }
            TbsLog.i("QbSdk", "unexpected return, dialogBuilder not show!");
        }
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static int openFileWithQB(Context context, String str, String str2) {
        TbsLog.i("QbSdk", "open openFileReader startMiniQBToLoadUrl filepath = " + str);
        if (checkContentProviderPrivilage(context)) {
            if (str == null) {
                TbsLog.i("QbSdk", "open openFileReader filepath error");
                return -5;
            }
            String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
            if (!MttLoader.isBrowserInstalled(context)) {
                TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
                return -4;
            } else if (!a(context, str, lowerCase)) {
                TbsLog.i("QbSdk", "openFileReader open in QB isQBSupport: false");
                return -2;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("ChannelID", context.getApplicationContext().getApplicationInfo().processName);
                hashMap.put("PosID", Integer.toString(4));
                if (MttLoader.openDocWithQb(context, str, 0, lowerCase, str2, hashMap, null)) {
                    return 0;
                }
                TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
                return -3;
            }
        }
        return -1;
    }

    public static void openNetLog(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "openNetLog", new Class[]{String.class}, str);
        } catch (Exception e2) {
        }
    }

    public static void preInit(Context context) {
        synchronized (QbSdk.class) {
            try {
                preInit(context, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            try {
                TbsLog.initIfNeed(context);
                TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
                TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
                l = f25023a;
                if (!s) {
                    final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.3
                        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
                            if (r5 != null) goto L17;
                         */
                        @Override // android.os.Handler
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void handleMessage(android.os.Message r5) {
                            /*
                                r4 = this;
                                r0 = r5
                                int r0 = r0.what
                                r6 = r0
                                r0 = 1
                                r7 = r0
                                r0 = r6
                                r1 = 1
                                if (r0 == r1) goto L3d
                                r0 = r6
                                r1 = 2
                                if (r0 == r1) goto L27
                                r0 = r6
                                r1 = 3
                                if (r0 == r1) goto L17
                                return
                            L17:
                                r0 = r4
                                com.tencent.smtt.sdk.QbSdk$PreInitCallback r0 = r5
                                r5 = r0
                                r0 = r5
                                if (r0 == 0) goto L73
                                r0 = r5
                                r0.onCoreInitFinished()
                                return
                            L27:
                                r0 = r4
                                com.tencent.smtt.sdk.QbSdk$PreInitCallback r0 = r5
                                r5 = r0
                                r0 = r5
                                if (r0 == 0) goto L39
                                r0 = 0
                                r7 = r0
                            L32:
                                r0 = r5
                                r1 = r7
                                r0.onViewInitFinished(r1)
                            L39:
                                com.tencent.smtt.utils.TbsLog.writeLogToDisk()
                                return
                            L3d:
                                com.tencent.smtt.sdk.TbsExtensionFunctionManager r0 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance()
                                r1 = r4
                                android.content.Context r1 = r6
                                java.lang.String r2 = "disable_unpreinit.txt"
                                boolean r0 = r0.canUseFunction(r1, r2)
                                boolean r0 = com.tencent.smtt.sdk.QbSdk.a(r0)
                                boolean r0 = com.tencent.smtt.sdk.QbSdk.j
                                if (r0 == 0) goto L67
                                com.tencent.smtt.sdk.w r0 = com.tencent.smtt.sdk.w.a()
                                com.tencent.smtt.sdk.x r0 = r0.c()
                                r5 = r0
                                r0 = r5
                                if (r0 == 0) goto L67
                                r0 = r5
                                r1 = r4
                                android.content.Context r1 = r6
                                com.tencent.smtt.export.external.interfaces.IX5WebViewBase r0 = r0.a(r1)
                            L67:
                                r0 = r4
                                com.tencent.smtt.sdk.QbSdk$PreInitCallback r0 = r5
                                r5 = r0
                                r0 = r5
                                if (r0 == 0) goto L39
                                goto L32
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.AnonymousClass3.handleMessage(android.os.Message):void");
                        }
                    };
                    Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.4
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            int a2 = o.a().a(true, Context.this);
                            TbsDownloader.setAppContext(Context.this);
                            TbsLog.i("QbSdk", "QbSdk preinit ver is " + a2);
                            if (a2 == 0) {
                                o.a().b(Context.this, true);
                            }
                            TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
                            f.a(true).a(Context.this, false, false);
                            w a3 = w.a();
                            a3.a(Context.this);
                            boolean b2 = a3.b();
                            handler.sendEmptyMessage(3);
                            if (b2) {
                                handler.sendEmptyMessage(1);
                            } else {
                                handler.sendEmptyMessage(2);
                            }
                        }
                    };
                    thread.setName("tbs_preinit");
                    thread.setPriority(10);
                    thread.start();
                    s = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:3:0x000a, B:5:0x0011, B:7:0x0018, B:13:0x0039, B:15:0x0074, B:18:0x007e), top: B:24:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: all -> 0x0099, TRY_ENTER, TryCatch #0 {all -> 0x0099, blocks: (B:3:0x000a, B:5:0x0011, B:7:0x0018, B:13:0x0039, B:15:0x0074, B:18:0x007e), top: B:24:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void reset(android.content.Context r5, boolean r6) {
        /*
            java.lang.String r0 = "QbSdk"
            java.lang.String r1 = "QbSdk reset!"
            r2 = 1
            com.tencent.smtt.utils.TbsLog.e(r0, r1, r2)
            com.tencent.smtt.sdk.TbsDownloader.stopDownload()     // Catch: java.lang.Throwable -> L99
            r0 = r6
            if (r0 == 0) goto Lc2
            r0 = r5
            boolean r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto Lc2
            com.tencent.smtt.sdk.o r0 = com.tencent.smtt.sdk.o.a()     // Catch: java.lang.Throwable -> L99
            r1 = r5
            int r0 = r0.h(r1)     // Catch: java.lang.Throwable -> L99
            r7 = r0
            com.tencent.smtt.sdk.o r0 = com.tencent.smtt.sdk.o.a()     // Catch: java.lang.Throwable -> L99
            r1 = r5
            int r0 = r0.i(r1)     // Catch: java.lang.Throwable -> L99
            r8 = r0
            r0 = r7
            r1 = 43300(0xa924, float:6.0676E-41)
            if (r0 <= r1) goto Lc2
            r0 = r7
            r1 = r8
            if (r0 == r1) goto Lc2
            r0 = 1
            r7 = r0
            goto L39
        L39:
            r0 = r5
            com.tencent.smtt.sdk.TbsDownloader.c(r0)     // Catch: java.lang.Throwable -> L99
            r0 = r5
            java.io.File r0 = getTbsFolderDir(r0)     // Catch: java.lang.Throwable -> L99
            r1 = 0
            java.lang.String r2 = "core_share_decouple"
            com.tencent.smtt.utils.FileUtil.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = "QbSdk"
            java.lang.String r1 = "delete downloaded apk success"
            r2 = 1
            com.tencent.smtt.utils.TbsLog.i(r0, r1, r2)     // Catch: java.lang.Throwable -> L99
            java.lang.ThreadLocal<java.lang.Integer> r0 = com.tencent.smtt.sdk.o.f25173a     // Catch: java.lang.Throwable -> L99
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L99
            r0.set(r1)     // Catch: java.lang.Throwable -> L99
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L99
            r1 = r0
            r2 = r5
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "bugly_switch.txt"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L99
            r9 = r0
            r0 = r9
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L7a
            r0 = r9
            boolean r0 = r0.delete()     // Catch: java.lang.Throwable -> L99
        L7a:
            r0 = r7
            if (r0 == 0) goto Lc1
            com.tencent.smtt.sdk.o r0 = com.tencent.smtt.sdk.o.a()     // Catch: java.lang.Throwable -> L99
            r1 = r5
            java.io.File r0 = r0.p(r1)     // Catch: java.lang.Throwable -> L99
            com.tencent.smtt.sdk.o r1 = com.tencent.smtt.sdk.o.a()     // Catch: java.lang.Throwable -> L99
            r2 = r5
            r3 = 0
            java.io.File r1 = r1.f(r2, r3)     // Catch: java.lang.Throwable -> L99
            boolean r0 = com.tencent.smtt.utils.FileUtil.b(r0, r1)     // Catch: java.lang.Throwable -> L99
            com.tencent.smtt.sdk.o r0 = com.tencent.smtt.sdk.o.a()     // Catch: java.lang.Throwable -> L99
            r1 = r5
            r0.b(r1)     // Catch: java.lang.Throwable -> L99
            return
        L99:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            java.lang.String r1 = "QbSdk reset exception:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r1 = r5
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "QbSdk"
            r1 = r9
            java.lang.String r1 = r1.toString()
            com.tencent.smtt.utils.TbsLog.e(r0, r1)
        Lc1:
            return
        Lc2:
            r0 = 0
            r7 = r0
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            FileUtil.b(o.a().p(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            z = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDisableUnpreinitBySwitch(boolean z2) {
        B = z2;
        TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z2) {
        mDisableUseHostBackupCore = z2;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDownloadWithoutWifi(boolean z2) {
        F = z2;
    }

    public static void setNeedInitX5FirstTime(boolean z2) {
        w = z2;
    }

    public static void setNetLogEncryptionKey(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[]{String.class}, str);
        } catch (Exception e2) {
        }
    }

    public static void setNewDnsHostList(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[0], str);
        } catch (Exception e2) {
        }
    }

    public static void setOnlyDownload(boolean z2) {
        k = z2;
    }

    public static void setQQBuildNumber(String str) {
        A = str;
    }

    public static void setTBSInstallingStatus(boolean z2) {
        G = z2;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        D = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUploadCode(Context context, int i2) {
        TbsDownloadUpload tbsDownloadUpload;
        Map<String, Object> map;
        Integer valueOf;
        String str;
        if (i2 >= 130 && i2 <= 139) {
            tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f25071a;
            valueOf = Integer.valueOf(i2);
            str = TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
        } else if (i2 < 150 || i2 > 159) {
            return;
        } else {
            tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f25071a;
            valueOf = Integer.valueOf(i2);
            str = TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
        }
        map.put(str, valueOf);
        tbsDownloadUpload.commit();
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, android.webkit.ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        w a2 = w.a();
        a2.a(context);
        if (!a2.b()) {
            TbsCoreLoadStat.getInstance().a(context, 502);
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
            return PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
        } else if (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) {
            int a3 = a2.c().a(context, str, hashMap, null, valueCallback);
            if (a3 == 0) {
                TbsCoreLoadStat.getInstance().a(context, 503);
            } else {
                TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
                tbsLogReport.setLoadErrorCode(504, "" + a3);
            }
            Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + a3);
            return a3;
        } else {
            return PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i2, int i3, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i2));
        return MttLoader.openDocWithQb(context, str, i3, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i2));
        return MttLoader.openVideoWithQb(context, str, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r0 == "com.tencent.mobileqq") goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean startQBToLoadurl(android.content.Context r6, java.lang.String r7, int r8, com.tencent.smtt.sdk.WebView r9) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "ChannelID"
            r2 = r6
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            java.lang.String r2 = r2.processName
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r12
            java.lang.String r1 = "PosID"
            r2 = r8
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = 0
            r10 = r0
            r0 = r9
            r11 = r0
            r0 = r9
            if (r0 != 0) goto Lae
            r0 = r6
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> Lc3
            r1 = r6
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Exception -> Lc3
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Exception -> Lc3
            r13 = r0
            r0 = r13
            java.lang.String r1 = "com.tencent.mm"
            if (r0 == r1) goto L52
            r0 = r9
            r11 = r0
            r0 = r13
            java.lang.String r1 = "com.tencent.mobileqq"
            if (r0 != r1) goto Lae
        L52:
            com.tencent.smtt.sdk.w r0 = com.tencent.smtt.sdk.w.a()     // Catch: java.lang.Exception -> Lc3
            r13 = r0
            r0 = r9
            r11 = r0
            r0 = r13
            if (r0 == 0) goto Lae
            r0 = r9
            r11 = r0
            r0 = r13
            boolean r0 = r0.b()     // Catch: java.lang.Exception -> Lc3
            if (r0 == 0) goto Lae
            r0 = r13
            com.tencent.smtt.sdk.x r0 = r0.c()     // Catch: java.lang.Exception -> Lc3
            com.tencent.smtt.export.external.DexLoader r0 = r0.b()     // Catch: java.lang.Exception -> Lc3
            java.lang.String r1 = "com.tencent.smtt.webkit.WebViewList"
            java.lang.String r2 = "getCurrentMainWebviewJustForQQandWechat"
            r3 = 0
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> Lc3
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> Lc3
            java.lang.Object r0 = r0.invokeStaticMethod(r1, r2, r3, r4)     // Catch: java.lang.Exception -> Lc3
            r13 = r0
            r0 = r9
            r11 = r0
            r0 = r13
            if (r0 == 0) goto Lae
            r0 = r13
            com.tencent.smtt.export.external.interfaces.IX5WebViewBase r0 = (com.tencent.smtt.export.external.interfaces.IX5WebViewBase) r0     // Catch: java.lang.Exception -> Lc3
            r13 = r0
            r0 = r9
            r11 = r0
            r0 = r13
            if (r0 == 0) goto Lae
            r0 = r13
            android.view.View r0 = r0.getView()     // Catch: java.lang.Exception -> Lc3
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Exception -> Lc3
            com.tencent.smtt.sdk.WebView r0 = (com.tencent.smtt.sdk.WebView) r0     // Catch: java.lang.Exception -> Lc3
            r11 = r0
            goto Lae
        Lae:
            r0 = r6
            r1 = r7
            r2 = r12
            java.lang.String r3 = "QbSdk.startQBToLoadurl"
            r4 = r11
            int r0 = com.tencent.smtt.sdk.stat.MttLoader.loadUrl(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lc0
            r0 = 1
            r10 = r0
        Lc0:
            r0 = r10
            return r0
        Lc3:
            r11 = move-exception
            r0 = r9
            r11 = r0
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.startQBToLoadurl(android.content.Context, java.lang.String, int, com.tencent.smtt.sdk.WebView):boolean");
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i2) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i2, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        w a2 = w.a();
        a2.a(context);
        if (hashMap != null && "5".equals(hashMap.get("PosID")) && a2.b()) {
            Bundle bundle = (Bundle) a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (MttLoader.loadUrl(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
            if (a2.b()) {
                return (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && a2.c().a(context, str, hashMap, null, valueCallback) == 0;
            }
            return false;
        }
        return true;
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static void uploadNetLog(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        try {
            a2.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[]{String.class}, str);
        } catch (Exception e2) {
        }
    }

    public static boolean useSoftWare() {
        Object obj = r;
        if (obj == null) {
            return false;
        }
        Object a2 = com.tencent.smtt.utils.i.a(obj, "useSoftWare", new Class[0], new Object[0]);
        Object obj2 = a2;
        if (a2 == null) {
            obj2 = com.tencent.smtt.utils.i.a(r, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (obj2 == null) {
            return false;
        }
        return ((Boolean) obj2).booleanValue();
    }
}
