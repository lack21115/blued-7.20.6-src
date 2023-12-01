package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f27209a;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f27210c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static Map<String, String> j;
    private static boolean l;
    private int k = 0;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put("header", "#h");
        j.put("sdk_type", "#sdt");
        j.put(bh.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(bh.g, "#umid");
        j.put(bh.x, bh.x);
        j.put("language", "#lang");
        j.put(bh.ai, "#dt");
        j.put("resolution", "#rl");
        j.put(bh.H, "#dmf");
        j.put("device_name", "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put("os_version", "#ov");
        j.put(bh.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(bh.F, "#db");
        j.put("appkey", "#ak");
        j.put(bh.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(bh.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put("package_name", "#pkg");
        j.put(bh.p, "#sig");
        j.put(bh.q, "#sis1");
        j.put(bh.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(bh.v, "#imd");
        j.put(bh.B, "#mnc");
        j.put(bh.E, "#boa");
        j.put(bh.G, "#mant");
        j.put("timezone", "#tz");
        j.put("country", "#ct");
        j.put(bh.P, "#car");
        j.put("display_name", "#disn");
        j.put("network_type", "#nt");
        j.put(bh.b, "#cv");
        j.put(bh.d, "#mv");
        j.put(bh.f26965c, "#cot");
        j.put(bh.e, "#mod");
        j.put(bh.aj, "#al");
        j.put("session_id", "#sid");
        j.put(bh.S, "#ip");
        j.put(bh.U, "#sre");
        j.put(bh.V, "#fre");
        j.put(bh.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(bh.aY, "#tsv");
        j.put(bh.aZ, "#rps");
        j.put(bh.bc, "#mov");
        j.put(d.i, "#vt");
        j.put("secret", "#sec");
        j.put(d.ah, "#prv");
        j.put(d.l, "#$prv");
        j.put(d.m, "#uda");
        j.put(bh.f26963a, "#tok");
        j.put(bh.aQ, "#iv");
        j.put(bh.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(bh.ap, "#mt");
        j.put(bh.am, "#zsv");
        j.put("others_OS", "#oos");
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = DeviceConfig.getAppVersionName(context);
        }
        String b2 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str4);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b2);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        } else if (str.startsWith("h")) {
            return 122;
        } else {
            return (str.startsWith(bh.aG) || str.startsWith("i") || str.startsWith("a") || str.startsWith("t")) ? UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary) : com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f27210c, "free size is " + j2);
        }
        return j2;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i2 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i2 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
            i2 = -1;
        }
        if (i2 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i2 != 1 && !l) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    public static String a(String str) {
        String str2 = str;
        if (j.containsKey(str)) {
            str2 = j.get(str);
        }
        return str2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
                return jSONObject;
            } catch (Exception e2) {
                return jSONObject;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
            return jSONObject2;
        } catch (Exception e3) {
            return jSONObject2;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:212:0x084a -> B:246:0x03b8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x0863 -> B:238:0x058a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:226:0x086d -> B:248:0x0609). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:228:0x0871 -> B:254:0x0672). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:230:0x0875 -> B:260:0x068a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:232:0x0879 -> B:266:0x07d8). Please submit an issue!!! */
    private static JSONObject a(Context context, String str, boolean z) {
        JSONObject jSONObject;
        int[] resolutionArray;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (TextUtils.isEmpty(i)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(a(bh.p), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a(bh.q), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a(bh.r), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a(bh.v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a("cpu"), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a(bh.B), "");
                } else {
                    jSONObject2.put(a(bh.B), mccmnc);
                    b = mccmnc;
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a(bh.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a(bh.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a(bh.ai), deviceType);
                }
                jSONObject2.put(a("package_name"), DeviceConfig.getPackageName(context));
                jSONObject2.put(a("sdk_type"), "Android");
                jSONObject2.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), Build.MODEL);
                jSONObject2.put(a(bh.E), Build.BOARD);
                jSONObject2.put(a(bh.F), Build.BRAND);
                jSONObject2.put(a(bh.G), Build.TIME);
                jSONObject2.put(a(bh.H), Build.MANUFACTURER);
                jSONObject2.put(a(bh.I), Build.ID);
                jSONObject2.put(a("device_name"), Build.DEVICE);
                jSONObject2.put(a("os_version"), Build.VERSION.RELEASE);
                jSONObject2.put(a(bh.x), "Android");
                if (DeviceConfig.getResolutionArray(context) != null) {
                    jSONObject2.put(a("resolution"), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(a("mc"), DeviceConfig.getMac(context));
                jSONObject2.put(a("timezone"), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a("country"), localeInfo[0]);
                jSONObject2.put(a("language"), localeInfo[1]);
                jSONObject2.put(a(bh.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a("display_name"), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bh.Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bh.Q), "2G/3G");
                } else {
                    jSONObject2.put(a(bh.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a(bh.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a("others_OS"), "harmony");
                } else {
                    jSONObject2.put(a("others_OS"), "Android");
                }
                jSONObject2.put(a("network_type"), DeviceConfig.getNetworkType(context));
                jSONObject2.put(a(bh.b), "9.6.3");
                jSONObject2.put(a(bh.f26965c), SdkVersion.SDK_TYPE);
                jSONObject2.put(a(bh.d), "1");
                if (!TextUtils.isEmpty(f27209a)) {
                    jSONObject2.put(a(bh.e), f27209a);
                }
                jSONObject2.put(a(bh.aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a(bh.af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    String str2 = uUIDForZid;
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        str2 = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), str2);
                } catch (Throwable th) {
                }
                try {
                    if (DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put(bh.f26964ar, "1");
                        if (DeviceConfig.hasOpsPermission(context.getApplicationContext())) {
                            jSONObject2.put(bh.as, "1");
                        }
                    }
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(bh.aq, "1");
                    }
                } catch (Throwable th2) {
                }
                i = jSONObject2.toString();
                jSONObject = jSONObject2;
            } else {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception e2) {
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(bh.ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception e3) {
            }
            try {
                jSONObject.put(a(bh.U), sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(a(bh.V), sharedPreferences.getInt(bh.V, 0));
                jSONObject.put(a(bh.W), sharedPreferences.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(bh.al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(bh.am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception e4) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(bh.f26963a), deviceToken);
                }
            } catch (Exception e5) {
                UMCrashManager.reportCrash(context, e5);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bh.g, null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(a(bh.g), imprintProperty);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(context, e6);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.f27207a);
                jSONObject.put(a("wrapper_version"), a.b);
            } catch (Exception e7) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                jSONObject.put(a(bh.aY), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(a(bh.aZ), "yes");
                } else {
                    jSONObject.put(a(bh.aZ), "no");
                }
            } catch (Throwable th3) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable th4) {
            }
            if (("t".equals(str) || "a".equals(str)) && z) {
                try {
                    int[] b2 = b(context);
                    jSONObject.put(a(bh.bt), String.valueOf(b2[0]) + String.valueOf(b2[1]) + String.valueOf(b2[2]));
                } catch (Throwable th5) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(bh.ap), jSONObject3);
                }
            } catch (Throwable th6) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(bh.bs), realTimeDebugKey);
                }
            } catch (Throwable th7) {
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(a(bh.bd), com.umeng.commonsdk.internal.a.e);
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                    jSONObject4.put(a(bh.be), UMUtils.VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                    jSONObject4.put(a(bh.bf), UMUtils.VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                    jSONObject4.put(a(bh.bg), UMUtils.VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                    jSONObject4.put(a(bh.bh), UMUtils.VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                    jSONObject4.put(a(bh.bi), UMUtils.VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                    jSONObject4.put(a(bh.bj), UMUtils.VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                    jSONObject4.put(a(bh.bk), UMUtils.VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject4.put(a(bh.bl), UMUtils.VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                    jSONObject4.put(a(bh.bm), UMUtils.VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject4.put(a(bh.bn), UMUtils.VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                    jSONObject4.put(a(bh.bo), UMUtils.VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                    jSONObject4.put(a(bh.bp), UMUtils.VALUE_ABTEST_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
                    jSONObject4.put(a(bh.bq), UMUtils.VALUE_ANTI_VERSION);
                }
                jSONObject.put(a(bh.bc), jSONObject4);
            } catch (Throwable th8) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(bh.br), apmFlag);
                }
            } catch (Throwable th9) {
            }
            byte[] a2 = ImprintHandler.getImprintService(context).a();
            if (a2 != null && a2.length > 0) {
                try {
                    jSONObject.put(a(bh.X), Base64.encodeToString(a2, 0));
                } catch (JSONException e8) {
                    UMCrashManager.reportCrash(context, e8);
                }
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return null;
            }
            return new JSONObject().put(a("header"), jSONObject);
        } catch (Throwable th10) {
            UMCrashManager.reportCrash(context, th10);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(d.i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
        }
    }

    public static void a(boolean z) {
        l = z;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f27171a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f27172c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
            return iArr;
        } catch (Throwable th) {
            return iArr;
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            JSONObject jSONObject4 = jSONObject3;
            if (jSONObject != null) {
                jSONObject4 = a(jSONObject3, jSONObject);
            }
            if (jSONObject4 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject4.put(str2, jSONObject2.opt(str2));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(Context.SERIAL_SERVICE, sharedPreferences.getInt(Context.SERIAL_SERVICE, 1) + 1).commit();
                }
                return a(113, jSONObject4);
            }
            Envelope envelope = null;
            if (jSONObject4 != null) {
                Envelope a2 = a(context, jSONObject4.toString().getBytes());
                envelope = a2;
                if (a2 == null) {
                    return a(111, jSONObject4);
                }
            }
            if (envelope == null || !DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                int a3 = a(context, envelope, "h==1.2.0", "", str);
                if (a3 != 0) {
                    return a(a3, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f27210c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                return jSONObject4;
            }
            return a(114, jSONObject4);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str4;
        Envelope envelope;
        String str5;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f27210c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f27210c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            String str6 = str2;
            JSONObject a2 = a(context, str6, jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(d.n));
            JSONObject jSONObject5 = a2;
            if (a2 != null) {
                jSONObject5 = a2;
                if (jSONObject != null) {
                    jSONObject5 = a(a2, jSONObject);
                }
            }
            if (jSONObject5 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str5 = next) != null && jSONObject2.opt(str5) != null) {
                        try {
                            jSONObject5.put(a(str5), jSONObject2.opt(str5));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str6 = "u";
            }
            String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
            if (jSONObject5 != null) {
                String str8 = str6 + "==" + str7 + "&=";
                if (TextUtils.isEmpty(str8)) {
                    return a(101, jSONObject5);
                }
                str4 = str8;
                if (str8.endsWith("&=")) {
                    str4 = str8.substring(0, str8.length() - 2);
                }
            } else {
                str4 = null;
            }
            if (jSONObject5 != null) {
                try {
                    e a3 = e.a(context);
                    if (a3 != null) {
                        a3.b();
                        String encodeToString = Base64.encodeToString(new bz().a(a3.c()), 0);
                        if (!TextUtils.isEmpty(encodeToString)) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject(a("header"));
                            jSONObject6.put(a(bh.Y), encodeToString);
                            jSONObject5.put(a("header"), jSONObject6);
                        }
                    }
                } catch (Exception e3) {
                }
            }
            if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(Context.SERIAL_SERVICE, sharedPreferences.getInt(Context.SERIAL_SERVICE, 1) + 1).commit();
                }
                return a(113, jSONObject5);
            }
            if (jSONObject5 != null) {
                envelope = a(context, jSONObject5.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject5);
                }
            } else {
                envelope = null;
            }
            if (envelope == null || !DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                int a4 = a(context, envelope, str4, jSONObject5 != null ? jSONObject5.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a4 != 0) {
                    return a(a4, jSONObject5);
                }
                if (ULog.DEBUG) {
                    Log.i(f27210c, "constructHeader size is " + jSONObject5.toString().getBytes().length);
                }
                if (!str4.startsWith(bh.aG) && !str4.startsWith("i") && !str4.startsWith("t")) {
                    if (str4.startsWith("a")) {
                        return jSONObject5;
                    }
                    if (!com.umeng.commonsdk.stateless.b.a()) {
                        new com.umeng.commonsdk.stateless.b(context);
                        com.umeng.commonsdk.stateless.b.b();
                    }
                }
                return jSONObject5;
            }
            return a(114, jSONObject5);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject7 = new JSONObject();
                    try {
                        jSONObject7.put("header", jSONObject);
                    } catch (JSONException e4) {
                    } catch (Exception e5) {
                        e = e5;
                        jSONObject3 = jSONObject7;
                        UMCrashManager.reportCrash(context, e);
                        jSONObject4 = jSONObject3;
                        return a(110, jSONObject4);
                    }
                    jSONObject3 = jSONObject7;
                } catch (Exception e6) {
                    e = e6;
                    jSONObject3 = null;
                }
            } else {
                jSONObject3 = null;
            }
            jSONObject4 = jSONObject3;
            if (jSONObject2 != null) {
                JSONObject jSONObject8 = jSONObject3;
                if (jSONObject3 == null) {
                    try {
                        jSONObject8 = new JSONObject();
                    } catch (Exception e7) {
                        e = e7;
                        UMCrashManager.reportCrash(context, e);
                        jSONObject4 = jSONObject3;
                        return a(110, jSONObject4);
                    }
                }
                jSONObject4 = jSONObject8;
                if (jSONObject2 != null) {
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (true) {
                        jSONObject4 = jSONObject8;
                        jSONObject3 = jSONObject8;
                        if (!keys2.hasNext()) {
                            break;
                        }
                        JSONObject jSONObject9 = jSONObject8;
                        String next2 = keys2.next();
                        if (next2 != null && (next2 instanceof String)) {
                            JSONObject jSONObject10 = jSONObject8;
                            String str9 = next2;
                            if (str9 != null && jSONObject2.opt(str9) != null) {
                                try {
                                    jSONObject8.put(str9, jSONObject2.opt(str9));
                                } catch (Exception e8) {
                                }
                            }
                        }
                    }
                }
            }
            return a(110, jSONObject4);
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable th) {
            }
            JSONObject jSONObject4 = jSONObject3;
            if (jSONObject != null) {
                jSONObject4 = a(jSONObject3, jSONObject);
            }
            if (jSONObject4 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject4.put(str2, jSONObject2.opt(str2));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(Context.SERIAL_SERVICE, sharedPreferences.getInt(Context.SERIAL_SERVICE, 1) + 1).commit();
                }
                return a(113, jSONObject4);
            }
            Envelope envelope = null;
            if (jSONObject4 != null) {
                Envelope a2 = a(context, jSONObject4.toString().getBytes());
                envelope = a2;
                if (a2 == null) {
                    return a(111, jSONObject4);
                }
            }
            if (envelope == null || !DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                int a3 = a(context, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
                if (a3 != 0) {
                    return a(a3, jSONObject4);
                }
                if (ULog.DEBUG) {
                    Log.i(f27210c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
                }
                return jSONObject4;
            }
            return a(114, jSONObject4);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return a(110, new JSONObject());
        }
    }
}
