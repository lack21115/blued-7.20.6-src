package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.components.offline.api.IOfflineCompo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tendinsv.a.b;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloader.class */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* renamed from: a  reason: collision with root package name */
    static boolean f25073a = false;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f25074c;
    private static Handler d;
    private static String e;
    private static Object f = new byte[0];
    private static l g;
    private static HandlerThread h;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsDownloader$TbsDownloaderCallback.class */
    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File a(int i2) {
        String str;
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return file;
            }
            String str2 = coreProviderAppList[i4];
            if (!str2.equals(f25074c.getApplicationInfo().packageName)) {
                File file2 = new File(FileUtil.a(f25074c, str2, 4, false), getOverSea(f25074c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
                if (!file2.exists()) {
                    str = "can not find local backup core file";
                } else if (com.tencent.smtt.utils.a.a(f25074c, file2) == i2) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                    return file2;
                } else {
                    str = "version is not match";
                }
                TbsLog.i(LOGTAG, str);
                file = file2;
            }
            i3 = i4 + 1;
        }
    }

    private static String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    private static JSONArray a(boolean z) {
        File file;
        boolean z2;
        JSONArray jSONArray = new JSONArray();
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return jSONArray;
            }
            String a2 = FileUtil.a(f25074c, coreProviderAppList[i3], 4, false);
            if (z) {
                file = new File(a2, getOverSea(f25074c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            } else {
                file = new File(a2, "x5.tbs.decouple");
            }
            if (file.exists()) {
                long a3 = com.tencent.smtt.utils.a.a(f25074c, file);
                if (a3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i5) == a3) {
                            z2 = true;
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(a3);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0490 -> B:116:0x0466). Please submit an issue!!! */
    private static JSONObject a(boolean z, boolean z2, boolean z3) {
        String str;
        int i2;
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f25074c);
        String b2 = b(f25074c);
        String g2 = com.tencent.smtt.utils.b.g(f25074c);
        String f2 = com.tencent.smtt.utils.b.f(f25074c);
        String i3 = com.tencent.smtt.utils.b.i(f25074c);
        String id = TimeZone.getDefault().getID();
        String str2 = id != null ? id : "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f25074c.getSystemService("phone");
            str = id;
            if (telephonyManager != null) {
                str = telephonyManager.getSimCountryIso();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str = id;
        }
        String str3 = str != null ? str : "";
        JSONObject jSONObject = new JSONObject();
        try {
            if (m.a(f25074c).c("tpatch_num") < 5) {
                jSONObject.put("REQUEST_TPATCH", 1);
            } else {
                jSONObject.put("REQUEST_TPATCH", 0);
            }
            jSONObject.put("TIMEZONEID", str2);
            jSONObject.put("COUNTRYISO", str3);
            if (com.tencent.smtt.utils.b.d()) {
                jSONObject.put("REQUEST_64", 1);
            }
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f25074c)) {
                i2 = QbSdk.f25024c ? TbsShareManager.a(f25074c, false) : TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            } else {
                int i4 = z3 ? o.a().i(f25074c) : o.a().m(f25074c);
                int i5 = i4;
                if (i4 == 0) {
                    i5 = i4;
                    if (o.a().l(f25074c)) {
                        i5 = -1;
                        if ("com.tencent.mobileqq".equals(f25074c.getApplicationInfo().packageName)) {
                            TbsDownloadUpload.clear();
                            TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(f25074c);
                            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, -1);
                            tbsDownloadUpload.commit();
                            TbsPVConfig.releaseInstance();
                            i5 = -1;
                            if (TbsPVConfig.getInstance(f25074c).getLocalCoreVersionMoreTimes() == 1) {
                                i5 = o.a().i(f25074c);
                            }
                        }
                    }
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + i5 + " isDownloadForeground=" + z2);
                i2 = i5;
                if (z2) {
                    i2 = o.a().l(f25074c) ? i5 : 0;
                }
            }
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", i2 == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(f25074c)) {
                JSONArray g3 = g();
                jSONObject.put("TBSVLARR", g3);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, g3.toString());
                tbsDownloadConfig.commit();
                if (QbSdk.f25024c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            } else {
                JSONArray a2 = a(z3);
                if (Apn.getApnType(f25074c) != 3 && a2.length() != 0 && i2 == 0 && z) {
                    jSONObject.put("TBSBACKUPARR", a2);
                }
            }
            jSONObject.put("APPN", f25074c.getPackageName());
            jSONObject.put("APPVN", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43967);
            jSONObject.put("TBSV", i2);
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            tbsDownloadConfig.commit();
            if (i2 != 0) {
                jSONObject.put("TBSBACKUPV", g.c(z3));
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", b2);
            jSONObject.put(b.a.d, a(g2));
            jSONObject.put(b.a.f25299c, a(f2));
            jSONObject.put("ANDROID_ID", a(i3));
            jSONObject.put("GUID", com.tencent.smtt.utils.b.e(f25074c));
            if (!TbsShareManager.isThirdPartyApp(f25074c)) {
                if (i2 != 0) {
                    jSONObject.put("STATUS", QbSdk.a(f25074c, i2) ? 0 : 1);
                } else {
                    jSONObject.put("STATUS", 0);
                }
                jSONObject.put("TBSDV", o.a().h(f25074c));
            }
            boolean z4 = TbsDownloadConfig.getInstance(f25074c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
            Object a3 = QbSdk.a(f25074c, "can_unlzma", (Bundle) null);
            if ((a3 == null || !(a3 instanceof Boolean)) ? false : ((Boolean) a3).booleanValue() ? !z4 : false) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(f25074c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e3) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    private static void a(JSONArray jSONArray) {
        boolean z;
        boolean z2;
        String[] f2 = f();
        int length = f2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            String str = f2[i3];
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(f25074c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f25074c, str, true);
                if (packageContext != null && !o.a().f(packageContext)) {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                } else if (a(f25074c, sharedTbsCoreVersion)) {
                    TbsLog.i(LOGTAG, "add CoreVersionToJsonData,version+" + sharedTbsCoreVersion + " is in black list");
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i5) == sharedTbsCoreVersion) {
                            z2 = true;
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                }
            }
            i2 = i3 + 1;
        }
        String[] f3 = f();
        int length2 = f3.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length2) {
                return;
            }
            String str2 = f3[i7];
            int coreShareDecoupleCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(f25074c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f25074c, str2, true);
                if (packageContext2 == null || o.a().f(packageContext2)) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i9) == coreShareDecoupleCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i8 = i9 + 1;
                        }
                    }
                    if (!z) {
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
            i6 = i7 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        boolean z = false;
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i2) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i2 > 0 && i2 < 45114;
    }

    private static boolean a(Context context, boolean z) {
        int i2;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (Build.VERSION.SDK_INT < 8) {
            i2 = -102;
        } else if (!QbSdk.f25024c && TbsShareManager.isThirdPartyApp(f25074c) && !c()) {
            return false;
        } else {
            if (!tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                boolean z2 = z;
                if (z) {
                    z2 = z;
                    if (!"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                        TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                        z2 = false;
                    }
                }
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z2));
                tbsDownloadConfig.commit();
                j = z2;
                TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z2);
            }
            if (!getOverSea(context) || Build.VERSION.SDK_INT == 16 || Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) {
                Matcher matcher = null;
                String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                e = string;
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (Exception e2) {
                }
                if (matcher == null || !matcher.find()) {
                    return true;
                }
                TbsLog.e(LOGTAG, "can not support x86 devices!!");
                i2 = -104;
            } else {
                TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
                i2 = -103;
            }
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x028c, code lost:
        if (r0.equals(r0) != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0358  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r6, boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(android.content.Context, boolean, boolean):boolean");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:18|(2:19|20)|21|(6:27|28|29|(1:31)(1:37)|32|33)|40|(14:332|333|334|(1:336)(1:354)|337|338|(1:340)(1:353)|341|342|(1:344)(1:352)|345|346|(1:348)(1:351)|349)|42|(3:43|44|45)|(10:46|47|48|49|50|51|52|53|(3:313|314|(1:316)(1:317))(1:55)|56)|(7:57|58|(3:60|61|62)|63|64|65|(4:67|68|69|(1:71)(1:307))(1:309))|(2:72|73)|(2:75|(11:77|78|79|80|82|83|84|43b|95|96|(6:98|(1:100)(1:107)|101|(1:103)(1:106)|104|105)(24:108|(1:110)|111|(1:113)|114|(1:116)|117|(1:119)|120|(4:122|(1:124)|125|(1:127))|128|(1:130)|131|132|(1:134)(1:287)|135|137|138|139|(2:141|(2:143|(1:145)))|146|(2:148|(2:155|(2:157|158))(1:154))|161|(2:170|(6:172|(1:174)(1:180)|175|(1:177)|178|179)(6:181|(1:183)|184|(3:186|(1:188)(1:282)|189)(1:283)|190|(4:257|(3:259|(1:261)(2:265|(1:267)(2:268|(1:270)(1:271)))|262)(3:272|(1:274)(2:276|(1:278)(2:279|(1:281)))|275)|263|264)(13:196|(1:198)|199|(3:201|(1:203)|204)|205|(1:207)|208|(4:225|(4:229|(1:241)(1:233)|234|(3:236|(1:238)(1:240)|239))|242|(7:251|(1:253)|254|219|(1:221)|222|223)(3:246|(1:248)(1:250)|249))(3:214|(1:216)(1:224)|217)|218|219|(0)|222|223)))(4:165|(1:167)|168|169))))|304|78|79|80|82|83|84|43b) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:18|(2:19|20)|21|(6:27|28|29|(1:31)(1:37)|32|33)|40|(14:332|333|334|(1:336)(1:354)|337|338|(1:340)(1:353)|341|342|(1:344)(1:352)|345|346|(1:348)(1:351)|349)|42|43|44|45|(10:46|47|48|49|50|51|52|53|(3:313|314|(1:316)(1:317))(1:55)|56)|(7:57|58|(3:60|61|62)|63|64|65|(4:67|68|69|(1:71)(1:307))(1:309))|(2:72|73)|(2:75|(11:77|78|79|80|82|83|84|43b|95|96|(6:98|(1:100)(1:107)|101|(1:103)(1:106)|104|105)(24:108|(1:110)|111|(1:113)|114|(1:116)|117|(1:119)|120|(4:122|(1:124)|125|(1:127))|128|(1:130)|131|132|(1:134)(1:287)|135|137|138|139|(2:141|(2:143|(1:145)))|146|(2:148|(2:155|(2:157|158))(1:154))|161|(2:170|(6:172|(1:174)(1:180)|175|(1:177)|178|179)(6:181|(1:183)|184|(3:186|(1:188)(1:282)|189)(1:283)|190|(4:257|(3:259|(1:261)(2:265|(1:267)(2:268|(1:270)(1:271)))|262)(3:272|(1:274)(2:276|(1:278)(2:279|(1:281)))|275)|263|264)(13:196|(1:198)|199|(3:201|(1:203)|204)|205|(1:207)|208|(4:225|(4:229|(1:241)(1:233)|234|(3:236|(1:238)(1:240)|239))|242|(7:251|(1:253)|254|219|(1:221)|222|223)(3:246|(1:248)(1:250)|249))(3:214|(1:216)(1:224)|217)|218|219|(0)|222|223)))(4:165|(1:167)|168|169))))|304|78|79|80|82|83|84|43b) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0421, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0431, code lost:
        r13 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0c4f  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0338 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03b7 A[Catch: Exception -> 0x0c8f, TRY_LEAVE, TryCatch #1 {Exception -> 0x0c8f, blocks: (B:91:0x03ac, B:93:0x03b7), top: B:349:0x03ac }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r5, int r6, boolean r7, boolean r8, boolean r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static File b(int i2) {
        StringBuilder sb;
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return file;
            }
            String str = coreProviderAppList[i4];
            file = new File(FileUtil.a(f25074c, str, 4, false), getOverSea(f25074c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (!file.exists() || com.tencent.smtt.utils.a.a(f25074c, file) != i2) {
                file = new File(FileUtil.a(f25074c, str, 4, false), "x5.tbs.decouple");
                if (file.exists() && com.tencent.smtt.utils.a.a(f25074c, file) == i2) {
                    sb = new StringBuilder();
                    break;
                }
                i3 = i4 + 1;
            } else {
                sb = new StringBuilder();
                break;
            }
        }
        sb.append("local tbs version fond,path = ");
        sb.append(file.getAbsolutePath());
        TbsLog.i(LOGTAG, sb.toString());
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.b(android.content.Context):java.lang.String");
    }

    private static void b(JSONArray jSONArray) {
        boolean z;
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a2 = o.a().a(TbsShareManager.getHostCorePathAppDefined());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= jSONArray.length()) {
                    break;
                } else if (jSONArray.optInt(i3) == a2) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z) {
                return;
            }
            jSONArray.put(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(32:32|(1:34)(1:151)|35|(1:37)(1:150)|38|(1:40)(1:149)|41|(1:43)(1:148)|44|(2:46|(1:48)(2:49|(1:51)(2:52|(1:54))))|55|(1:57)|58|(4:(6:60|61|62|63|64|(10:68|(3:70|(1:72)(1:140)|73)(2:141|(1:143)(1:144))|74|75|76|77|78|(4:120|(3:122|(1:124)|125)|126|(4:128|(1:130)(2:133|(1:135)(1:136))|131|132))|82|(9:95|96|(2:98|99)(7:115|(2:117|118)|101|102|103|104|105)|100|101|102|103|104|105)(4:86|(1:88)(2:91|(1:93)(1:94))|89|90)))|103|104|105)|147|75|76|77|78|(1:80)|120|(0)|126|(0)|82|(1:84)|95|96|(0)(0)|100|101|102) */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x05e6, code lost:
        r24 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0382, code lost:
        r12 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0532 A[Catch: all -> 0x05e6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x05e6, blocks: (B:128:0x04ff, B:130:0x0532, B:132:0x056a, B:137:0x05b3, B:135:0x0578), top: B:159:0x04ff }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(final boolean r7, boolean r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.b(boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        l.c(context);
        (Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    private static void c(JSONArray jSONArray) {
        boolean z;
        StringBuilder sb;
        boolean z2;
        if (TbsPVConfig.getInstance(f25074c).isDisableHostBackupCore()) {
            return;
        }
        String[] f2 = f();
        int length = f2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            String str = f2[i3];
            int backupCoreVersion = TbsShareManager.getBackupCoreVersion(f25074c, str);
            if (backupCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f25074c, str, false);
                if (packageContext != null && !o.a().f(packageContext)) {
                    sb = new StringBuilder();
                    sb.append("host check failed,packageName = ");
                    sb.append(str);
                    TbsLog.e(LOGTAG, sb.toString());
                    i2 = i3 + 1;
                } else if (a(f25074c, backupCoreVersion)) {
                    TbsLog.i(LOGTAG, "add addBackupVersionToJsonData,version+" + backupCoreVersion + " is in black list");
                    i2 = i3 + 1;
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i5) == backupCoreVersion) {
                            z2 = true;
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(backupCoreVersion);
                    }
                }
            }
            int backupDecoupleCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(f25074c, str);
            if (backupDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f25074c, str, false);
                if (packageContext2 == null || o.a().f(packageContext2)) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i7) == backupDecoupleCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i6 = i7 + 1;
                        }
                    }
                    if (!z) {
                        jSONArray.put(backupDecoupleCoreVersion);
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("host check failed,packageName = ");
                    sb.append(str);
                    TbsLog.e(LOGTAG, sb.toString());
                }
            }
            i2 = i3 + 1;
        }
    }

    private static boolean c() {
        try {
            String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
            int length = coreProviderAppList.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (TbsShareManager.getSharedTbsCoreVersion(f25074c, coreProviderAppList[i3]) > 0) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void d() {
        synchronized (TbsDownloader.class) {
            try {
                if (h == null) {
                    h = n.a();
                    g = new l(f25074c);
                    d = new Handler(h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            String str;
                            int i2 = message.what;
                            if (i2 != 108) {
                                if (i2 == 109) {
                                    if (TbsDownloader.g != null) {
                                        TbsDownloader.g.f();
                                        return;
                                    }
                                    return;
                                }
                                switch (i2) {
                                    case 100:
                                        boolean z = message.arg1 == 1;
                                        boolean b2 = TbsDownloader.b(true, false, false, message.arg2 == 1);
                                        if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                                            TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + b2);
                                            String str2 = (TbsDownloader.f25074c == null || TbsDownloader.f25074c.getApplicationContext() == null || TbsDownloader.f25074c.getApplicationContext().getApplicationInfo() == null) ? "" : TbsDownloader.f25074c.getApplicationContext().getApplicationInfo().packageName;
                                            if (b2 && !z) {
                                                if ("com.tencent.mm".equals(str2) || "com.tencent.mobileqq".equals(str2)) {
                                                    TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + b2);
                                                }
                                            }
                                            ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(b2, TbsDownloadConfig.getInstance(TbsDownloader.f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        }
                                        if (TbsShareManager.isThirdPartyApp(TbsDownloader.f25074c) && b2) {
                                            TbsDownloader.startDownload(TbsDownloader.f25074c);
                                            return;
                                        }
                                        return;
                                    case 101:
                                        break;
                                    case 102:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                        int a2 = TbsShareManager.isThirdPartyApp(TbsDownloader.f25074c) ? TbsShareManager.a(TbsDownloader.f25074c, false) : o.a().m(TbsDownloader.f25074c);
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + a2);
                                        TbsDownloader.g.a(a2);
                                        TbsLogReport.getInstance(TbsDownloader.f25074c).dailyReport();
                                        return;
                                    case 103:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                        if (message.arg1 == 0) {
                                            o.a().a((Context) message.obj, true);
                                            return;
                                        } else {
                                            o.a().a((Context) message.obj, false);
                                            return;
                                        }
                                    case 104:
                                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                        TbsLogReport.getInstance(TbsDownloader.f25074c).reportTbsLog();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            if (Apn.getApnType(TbsDownloader.f25074c) == 3 || QbSdk.getDownloadWithoutWifi()) {
                                FileOutputStream fileOutputStream = null;
                                FileLock fileLock = null;
                                if (TbsShareManager.isThirdPartyApp(TbsDownloader.f25074c)) {
                                    fileLock = null;
                                } else {
                                    fileOutputStream = FileUtil.b(TbsDownloader.f25074c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                                    if (fileOutputStream != null) {
                                        FileLock a3 = FileUtil.a(TbsDownloader.f25074c, fileOutputStream);
                                        fileLock = a3;
                                        if (a3 == null) {
                                            QbSdk.m.onDownloadFinish(177);
                                            TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                            TbsDownloadConfig.getInstance(TbsDownloader.f25074c).setDownloadInterruptCode(-203);
                                            str = "MSG_START_DOWNLOAD_DECOUPLECORE return #1";
                                        }
                                    } else if (FileUtil.a(TbsDownloader.f25074c)) {
                                        TbsDownloadConfig.getInstance(TbsDownloader.f25074c).setDownloadInterruptCode(-204);
                                        str = "MSG_START_DOWNLOAD_DECOUPLECORE return #2";
                                    }
                                }
                                boolean z2 = message.arg1 == 1;
                                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f25074c);
                                if (TbsDownloader.b(false, z2, 108 == message.what, true)) {
                                    if (z2 && o.a().b(TbsDownloader.f25074c, TbsDownloadConfig.getInstance(TbsDownloader.f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                        QbSdk.m.onDownloadFinish(122);
                                        tbsDownloadConfig.setDownloadInterruptCode(-213);
                                    } else if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                        TbsDownloadConfig.getInstance(TbsDownloader.f25074c).setDownloadInterruptCode(-215);
                                        TbsDownloader.g.b(z2, 108 == message.what);
                                    }
                                    TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                                    FileUtil.a(fileLock, fileOutputStream);
                                    return;
                                }
                                QbSdk.m.onDownloadFinish(110);
                                TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                                FileUtil.a(fileLock, fileOutputStream);
                                return;
                            }
                            str = "not wifi,no need send request";
                            TbsLog.i(TbsDownloader.LOGTAG, str);
                        }
                    };
                }
            } catch (Exception e2) {
                i = true;
                TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
            } finally {
            }
        }
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(f25074c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(g().toString());
        } catch (Exception e2) {
            return false;
        }
    }

    private static String[] f() {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{f25074c.getApplicationContext().getPackageName()};
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = f25074c.getApplicationContext().getPackageName();
        String[] strArr = coreProviderAppList;
        if (packageName.equals(TbsShareManager.f(f25074c))) {
            int length = coreProviderAppList.length;
            strArr = new String[length + 1];
            System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
            strArr[length] = packageName;
        }
        return strArr;
    }

    private static JSONArray g() {
        if (TbsShareManager.isThirdPartyApp(f25074c)) {
            JSONArray jSONArray = new JSONArray();
            a(jSONArray);
            c(jSONArray);
            b(jSONArray);
            return jSONArray;
        }
        return null;
    }

    public static String getBackupFileName(boolean z) {
        return z ? com.tencent.smtt.utils.b.d() ? "x5.tbs.decouple.64" : "x5.tbs.decouple" : com.tencent.smtt.utils.b.d() ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return o.a().h(f25074c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return o.a().h(context);
    }

    public static boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            try {
                if (!k) {
                    k = true;
                    TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                    if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                        j = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                        TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
                }
                z = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static boolean h() {
        int i2;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f25074c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i2 = -115;
        } else if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i2 = -116;
        } else if (!FileUtil.b(f25074c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i2 = -117;
        } else if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) > 86400000) {
            return true;
        } else {
            long j2 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j2);
            if (j2 < tbsDownloadConfig.getDownloadMaxflow()) {
                return true;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
            i2 = -120;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i2);
        return false;
    }

    public static boolean isDownloadForeground() {
        l lVar = g;
        return lVar != null && lVar.d();
    }

    public static boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            try {
                TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + f25073a);
                z = f25073a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        boolean contains;
        boolean z4;
        int i2;
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        TbsDownloadUpload.clear();
        TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
        tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 140);
        tbsDownloadUpload.commit();
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (o.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 171);
            tbsDownloadUpload.commit();
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        f25074c = applicationContext;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(applicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        if (!a(f25074c, z)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 141);
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 172);
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                return false;
            }
            return false;
        }
        d();
        if (i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            tbsDownloadConfig.setDownloadInterruptCode(PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 142);
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 173);
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                return false;
            }
            return false;
        }
        boolean a2 = a(f25074c, z2, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + a2);
        if (a2) {
            a(z2, tbsDownloaderCallback, z3);
            tbsDownloadConfig.setDownloadInterruptCode(PackageManager.NO_NATIVE_LIBRARIES);
        } else {
            tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 143);
            tbsDownloadUpload.commit();
        }
        d.removeMessages(102);
        Message.obtain(d, 102).sendToTarget();
        if (QbSdk.f25024c || !TbsShareManager.isThirdPartyApp(context)) {
            contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
            z4 = (contains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        } else {
            z4 = false;
            contains = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z4 + ",hasNeedDownloadKey=" + contains);
        if (!z4) {
            int m = o.a().m(f25074c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + a2);
            if (a2 || m <= 0) {
                d.removeMessages(103);
                ((m > 0 || a2) ? Message.obtain(d, 103, 1, 0, f25074c) : Message.obtain(d, 103, 0, 0, f25074c)).sendToTarget();
                i2 = -121;
            } else {
                i2 = -119;
            }
            tbsDownloadConfig.setDownloadInterruptCode(i2);
        } else if (h()) {
            tbsDownloadConfig.setDownloadInterruptCode(-118);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z4 = false;
        }
        if (!a2 && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z4);
        tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? 170 : 174));
        tbsDownloadUpload.commit();
        return z4;
    }

    public static boolean needDownloadDecoupleCore() {
        int i2;
        if (TbsShareManager.isThirdPartyApp(f25074c) || a(f25074c)) {
            return false;
        }
        return System.currentTimeMillis() - TbsDownloadConfig.getInstance(f25074c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= TbsDownloadConfig.getInstance(f25074c).getRetryInterval() * 1000 && (i2 = TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i2 != o.a().h(f25074c) && TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2;
    }

    public static boolean needSendRequest(Context context, boolean z) {
        f25074c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (a(f25074c, z)) {
            int m = o.a().m(context);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
            if (m > 0) {
                return false;
            }
            if (a(f25074c, false, true)) {
                return true;
            }
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f25074c);
            boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
            boolean z2 = !contains ? true : tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z2);
            boolean z3 = false;
            if (z2) {
                z3 = false;
                if (h()) {
                    z3 = true;
                }
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z3);
            return z3;
        }
        return false;
    }

    public static void pauseDownload() {
        TbsLog.i(LOGTAG, "called pauseDownload,downloader=" + g);
        l lVar = g;
        if (lVar != null) {
            lVar.e();
        }
    }

    public static void resumeDownload() {
        TbsLog.i(LOGTAG, "called resumeDownload,downloader=" + g);
        Handler handler = d;
        if (handler != null) {
            handler.removeMessages(109);
            d.sendEmptyMessage(109);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        f25074c = context.getApplicationContext();
    }

    public static void setRetryIntervalInSeconds(Context context, long j2) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            l = j2;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
    }

    public static boolean startDecoupleCoreIfNeeded() {
        StringBuilder sb;
        int h2;
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f25074c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (a(f25074c) || d == null) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f25074c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) < TbsDownloadConfig.getInstance(f25074c).getRetryInterval() * 1000) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i2 = TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i2 <= 0 || i2 == o.a().h(f25074c)) {
            sb = new StringBuilder();
            sb.append("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ");
            sb.append(i2);
            sb.append(" getTbsCoreShareDecoupleCoreVersion is ");
            h2 = o.a().h(f25074c);
        } else if (TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2 || TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
            f25073a = true;
            d.removeMessages(108);
            Message obtain = Message.obtain(d, 108, QbSdk.m);
            obtain.arg1 = 0;
            obtain.sendToTarget();
            TbsDownloadConfig.getInstance(f25074c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
            return true;
        } else {
            sb = new StringBuilder();
            sb.append("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
            sb.append(TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            sb.append(" deCoupleCoreVersion is ");
            sb.append(i2);
            sb.append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
            h2 = TbsDownloadConfig.getInstance(f25074c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
        }
        sb.append(h2);
        TbsLog.i(LOGTAG, sb.toString());
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static void startDownload(Context context, boolean z) {
        synchronized (TbsDownloader.class) {
            try {
                TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
                tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 160);
                tbsDownloadUpload.commit();
                TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f25074c);
                if (o.b) {
                    tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 161);
                    tbsDownloadUpload.commit();
                    return;
                }
                int i2 = 1;
                f25073a = true;
                Context applicationContext = context.getApplicationContext();
                f25074c = applicationContext;
                TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(IOfflineCompo.Priority.HIGHEST);
                if (Build.VERSION.SDK_INT < 8) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(f25074c).setDownloadInterruptCode(-201);
                    tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 162);
                    tbsDownloadUpload.commit();
                    return;
                }
                d();
                if (i) {
                    QbSdk.m.onDownloadFinish(121);
                    TbsDownloadConfig.getInstance(f25074c).setDownloadInterruptCode(-202);
                    tbsDownloadUpload.f25071a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 163);
                    tbsDownloadUpload.commit();
                    return;
                }
                if (z) {
                    stopDownload();
                }
                d.removeMessages(101);
                d.removeMessages(100);
                Message obtain = Message.obtain(d, 101, QbSdk.m);
                if (!z) {
                    i2 = 0;
                }
                obtain.arg1 = i2;
                obtain.sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void stopDownload() {
        if (i) {
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        l lVar = g;
        if (lVar != null) {
            lVar.b();
        }
        Handler handler = d;
        if (handler != null) {
            handler.removeMessages(100);
            d.removeMessages(101);
            d.removeMessages(108);
        }
    }
}
