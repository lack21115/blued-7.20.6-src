package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/launch/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f21810a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f21811c;
    private static long d;
    private static long e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static long i;
    private static long j;
    private static int k;
    private static List<EfsJSONLog> l = new ArrayList();
    private static Map<String, Long[]> m = new HashMap();

    public static void a(Activity activity, String str, boolean z) {
        long currentTimeMillis;
        int i2;
        long j2;
        Context applicationContext;
        String name;
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_CREATE)) {
            if (z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onCreate");
                }
                d = System.currentTimeMillis();
            }
        } else if (TextUtils.equals(str, LaunchManager.PAGE_ON_RE_START)) {
            if (z && k == 0) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onRestart");
                }
                e = System.currentTimeMillis();
                g = true;
            }
        } else if (TextUtils.equals(str, LaunchManager.PAGE_ON_START)) {
            if (z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onStart");
                }
                k++;
                h = true;
            }
        } else if (!TextUtils.equals(str, LaunchManager.PAGE_ON_RESUME)) {
            if (TextUtils.equals(str, LaunchManager.PAGE_ON_STOP) && z) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "onStop");
                }
                k--;
            }
        } else if (z) {
        } else {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "onResume");
            }
            if (f) {
                f = false;
                long currentTimeMillis2 = System.currentTimeMillis();
                long j3 = currentTimeMillis2 - f21811c;
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "loadTime is ".concat(String.valueOf(j3)));
                }
                long j4 = currentTimeMillis2 - f21810a;
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "======>>>>>> coldTime is ".concat(String.valueOf(j4)));
                }
                int i3 = !c.d(activity.getApplicationContext()) ? 1 : 0;
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "type is ".concat(String.valueOf(i3)));
                }
                a(activity.getApplicationContext(), i3, activity.getClass().getName(), j4, f21810a, b, i, f21811c, j, currentTimeMillis2, j3, 0L, 0L, m);
            } else if (k == 1) {
                if (g) {
                    g = false;
                    j2 = System.currentTimeMillis() - e;
                    if (LaunchManager.isDebug) {
                        Log.i("LaunchTrace", "======>>>>>> hotTime is ".concat(String.valueOf(j2)));
                    }
                    Context applicationContext2 = activity.getApplicationContext();
                    name = activity.getClass().getName();
                    i2 = 2;
                    currentTimeMillis = 0;
                    applicationContext = applicationContext2;
                } else if (h) {
                    currentTimeMillis = System.currentTimeMillis() - d;
                    if (LaunchManager.isDebug) {
                        Log.i("LaunchTrace", "======>>>>>> warmTime is ".concat(String.valueOf(currentTimeMillis)));
                    }
                    i2 = 3;
                    j2 = 0;
                    applicationContext = activity.getApplicationContext();
                    name = activity.getClass().getName();
                }
                a(applicationContext, i2, name, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j2, currentTimeMillis, m);
            }
            h = false;
        }
    }

    private static void a(Context context, int i2, String str, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Map<String, Long[]> map) {
        StringBuilder sb;
        String generateString;
        Long valueOf;
        if (LaunchManager.isInit()) {
            LaunchConfigManager launchConfigManager = LaunchManager.getLaunchConfigManager();
            if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "launch --->>> config no init or enable is false");
                    return;
                }
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", Integer.valueOf(i2));
            efsJSONLog.put("w_url", str);
            efsJSONLog.put("l_version", "0.0.4.umeng");
            if (i2 == 0 || i2 == 1) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j2));
                efsJSONLog.put("wd_init", Long.valueOf(j3));
                efsJSONLog.put("wd_inittm", Long.valueOf(j4));
                efsJSONLog.put("wl_init", Long.valueOf(j5));
                efsJSONLog.put("wd_build", Long.valueOf(j4));
                efsJSONLog.put("wd_buildtm", Long.valueOf(j6));
                efsJSONLog.put("wl_build", Long.valueOf(j7));
                efsJSONLog.put("wd_page", Long.valueOf(j6));
                efsJSONLog.put("wd_pagetm", Long.valueOf(j8));
                efsJSONLog.put("wl_page", Long.valueOf(j9));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Long[]> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Long[] value = entry.getValue();
                        if (key != null && value != null) {
                            try {
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(value[0]);
                                jSONArray.put(value[1]);
                                jSONObject.put(key, jSONArray);
                            } catch (Throwable th) {
                            }
                        }
                    }
                    efsJSONLog.put("userExtra", jSONObject);
                }
            } else {
                if (i2 == 2) {
                    valueOf = Long.valueOf(j10);
                } else if (i2 == 3) {
                    valueOf = Long.valueOf(j11);
                }
                efsJSONLog.put("wl_avgv", valueOf);
            }
            String a2 = c.a(context);
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "umid is ".concat(String.valueOf(a2)));
            }
            if (a2 != null && !TextUtils.isEmpty(a2)) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "send current launch report --->>> " + efsJSONLog.generateString());
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                    return;
                }
                return;
            }
            List<EfsJSONLog> list = l;
            if (list == null || list.size() >= 3) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "cache launch size over!");
                    return;
                }
                return;
            }
            l.add(efsJSONLog);
            if (!LaunchManager.isDebug) {
                return;
            }
            sb = new StringBuilder("cache launch report --->>> ");
            generateString = efsJSONLog.generateString();
        } else if (i2 == 0) {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "no init, local cache cold launch, type is 0 !");
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("w_type", i2);
                jSONObject2.put("w_url", str);
                jSONObject2.put("l_version", "0.0.4.umeng");
                jSONObject2.put("wl_avgv", j2);
                jSONObject2.put("wd_init", j3);
                jSONObject2.put("wd_inittm", j4);
                jSONObject2.put("wl_init", j5);
                jSONObject2.put("wd_build", j4);
                jSONObject2.put("wd_buildtm", j6);
                jSONObject2.put("wl_build", j7);
                jSONObject2.put("wd_page", j6);
                jSONObject2.put("wd_pagetm", j8);
                jSONObject2.put("wl_page", j9);
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry2 : map.entrySet()) {
                        String key2 = entry2.getKey();
                        Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(value2[0]);
                                jSONArray2.put(value2[1]);
                                jSONObject3.put(key2, jSONArray2);
                            } catch (Throwable th2) {
                            }
                        }
                    }
                    jSONObject2.put("userExtra", jSONObject3);
                }
                c.a(context, jSONObject2.toString());
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "no init, cache first launch, content is " + jSONObject2.toString());
                    return;
                }
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                return;
            }
        } else {
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "no init, cache launch, type is ".concat(String.valueOf(i2)));
            }
            EfsJSONLog efsJSONLog2 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog2.put("w_type", Integer.valueOf(i2));
            efsJSONLog2.put("w_url", str);
            efsJSONLog2.put("l_version", "0.0.4.umeng");
            if (i2 == 1) {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j2));
                efsJSONLog2.put("wd_init", Long.valueOf(j3));
                efsJSONLog2.put("wd_inittm", Long.valueOf(j4));
                efsJSONLog2.put("wl_init", Long.valueOf(j5));
                efsJSONLog2.put("wd_build", Long.valueOf(j4));
                efsJSONLog2.put("wd_buildtm", Long.valueOf(j6));
                efsJSONLog2.put("wl_build", Long.valueOf(j7));
                efsJSONLog2.put("wd_page", Long.valueOf(j6));
                efsJSONLog2.put("wd_pagetm", Long.valueOf(j8));
                efsJSONLog2.put("wl_page", Long.valueOf(j9));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry3 : map.entrySet()) {
                        String key3 = entry3.getKey();
                        Long[] value3 = entry3.getValue();
                        if (key3 != null && value3 != null) {
                            try {
                                JSONArray jSONArray3 = new JSONArray();
                                try {
                                    jSONArray3.put(value3[0]);
                                    try {
                                        jSONArray3.put(value3[1]);
                                        jSONObject4.put(key3, jSONArray3);
                                    } catch (Throwable th4) {
                                    }
                                } catch (Throwable th5) {
                                }
                            } catch (Throwable th6) {
                            }
                        }
                    }
                    efsJSONLog2.put("userExtra", jSONObject4);
                }
            } else if (i2 == 2) {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j10));
            } else if (i2 == 3) {
                efsJSONLog2.put("wl_avgv", Long.valueOf(j11));
            }
            List<EfsJSONLog> list2 = l;
            if (list2 == null || list2.size() >= 3) {
                if (LaunchManager.isDebug) {
                    Log.i("LaunchTrace", "cache launch size over!");
                    return;
                }
                return;
            }
            l.add(efsJSONLog2);
            if (!LaunchManager.isDebug) {
                return;
            }
            sb = new StringBuilder("cache launch report --->>> ");
            generateString = efsJSONLog2.generateString();
        }
        sb.append(generateString);
        Log.i("LaunchTrace", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.launch.b.a(android.content.Context, java.lang.String):void");
    }

    public static void a(String str, long j2) {
        Map<String, Long[]> map = m;
        if (map == null || map.containsKey(str) || m.size() >= 10) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name already exists or over quantity !");
                return;
            }
            return;
        }
        Long[] lArr = new Long[2];
        lArr[0] = Long.valueOf(j2);
        m.put(str, lArr);
    }

    public static void a(String str, boolean z) {
        if (TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (!TextUtils.equals(str, LaunchManager.APP_ON_CREATE) || z) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            f21811c = currentTimeMillis;
            j = currentTimeMillis - b;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "buildTime is " + j);
            }
        } else if (z) {
            f21810a = System.currentTimeMillis();
            f = true;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            b = currentTimeMillis2;
            i = currentTimeMillis2 - f21810a;
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "initTime is " + i);
            }
        }
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (LaunchManager.isDebug) {
                Log.i("LaunchTrace", "send cache cold launch report --->>> " + efsJSONLog.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(String str, long j2) {
        Map<String, Long[]> map = m;
        if (map == null || !map.containsKey(str)) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name non-existent or over quantity !");
                return;
            }
            return;
        }
        Long[] lArr = m.get(str);
        lArr[1] = Long.valueOf(j2);
        m.put(str, lArr);
    }
}
