package com.bytedance.bdtracker;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.network.RangersHttpException;
import com.bytedance.applog.scheme.BuildConfig;
import com.bytedance.applog.util.SimulateLaunchActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bh;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/q1.class */
public class q1 {
    public static final String[] d = {"GET", "POST"};
    public static JSONObject e;

    /* renamed from: a  reason: collision with root package name */
    public String f7684a = "https://databyterangers.com.cn";
    public final c b;

    /* renamed from: c  reason: collision with root package name */
    public final p2 f7685c;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/q1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7686a;
        public byte[] b;

        public a(int i) {
        }
    }

    public q1(c cVar) {
        this.b = cVar;
        this.f7685c = new p2(cVar);
    }

    public static String a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String str2 = strArr[i2];
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
            i = i2 + 1;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", str);
        jSONObject.put(bh.x, "Android");
        jSONObject.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
        jSONObject.put("app_version", str2);
        return jSONObject;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(sb.toString().indexOf(63) < 0 ? "?" : ContainerUtils.FIELD_DELIMITER);
        sb.append(str);
        sb.append("=");
        sb.append(Uri.encode(str2));
    }

    public static void a(JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong("server_time");
            if (optLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", optLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                e = jSONObject2;
            }
        } catch (Exception e2) {
        }
    }

    public static boolean a(int i) {
        return i >= 500 && i < 600;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String[] r6, byte[] r7, com.bytedance.bdtracker.m0 r8) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.q1.a(java.lang.String[], byte[], com.bytedance.bdtracker.m0):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03e2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0410 A[Catch: all -> 0x0415, TRY_ENTER, TryCatch #2 {all -> 0x0415, blocks: (B:135:0x03d1, B:140:0x0410, B:141:0x0414), top: B:151:0x03d1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.bytedance.bdtracker.q1.a a(int r9, java.lang.String r10, java.util.HashMap<java.lang.String, java.lang.String> r11, byte[] r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 1085
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.q1.a(int, java.lang.String, java.util.HashMap, byte[], int, int):com.bytedance.bdtracker.q1$a");
    }

    public String a(int i, String str, HashMap<String, String> hashMap, byte[] bArr) {
        return a(i, str, hashMap, bArr, 0, -1).f7686a;
    }

    public final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("Content-Type", this.b.A ? "application/octet-stream;tt-data=a" : "application/json; charset=utf-8");
        return hashMap;
    }

    public JSONObject a(AsyncTask<?, ?, ?> asyncTask, String str, String str2, int i, int i2, String str3) {
        String str4;
        String str5;
        String a2;
        JSONObject jSONObject;
        int i3;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject a3 = a(str, str2);
            j1.a(a3, this.b.getHeader());
            a3.put("width", i);
            a3.put("height", i2);
            a3.put("device_id", str3);
            a3.put("device_model", Build.MODEL);
            jSONObject2.put("header", a3);
            HashMap<String, String> a4 = a();
            String str6 = "";
            String str7 = null;
            while (true) {
                str4 = str7;
                if (asyncTask.isCancelled()) {
                    break;
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str8 = str7;
                try {
                    jSONObject2.put("sync_id", str6);
                    String str9 = str7;
                    StringBuilder sb = new StringBuilder();
                    String str10 = str7;
                    sb.append(this.f7684a);
                    String str11 = str7;
                    sb.append("/simulator/limited_mobile/try_link");
                    String str12 = str7;
                    a2 = a(1, sb.toString(), a4, this.f7685c.b(jSONObject2.toString()));
                    jSONObject = new JSONObject(a2);
                    i3 = jSONObject.getJSONObject("data").getInt("retry");
                } catch (Exception e2) {
                    z2.a(e2);
                    str5 = str6;
                }
                if (i3 == 0) {
                    return null;
                }
                if (i3 == 2) {
                    str4 = a2;
                    break;
                }
                str5 = jSONObject.getJSONObject("data").getString("sync_id");
                str8 = a2;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                str6 = str5;
                str7 = str8;
                if (currentTimeMillis2 < 1000) {
                    try {
                        Thread.sleep(1000 - currentTimeMillis2);
                        str6 = str5;
                        str7 = str8;
                    } catch (InterruptedException e3) {
                        z2.a(e3);
                        str6 = str5;
                        str7 = str8;
                    }
                }
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            try {
                return new JSONObject(str4);
            } catch (JSONException e4) {
                z2.c("U SHALL NOT PASS!", e4);
                return null;
            }
        } catch (JSONException e5) {
            z2.c("U SHALL NOT PASS!", e5);
            return null;
        }
    }

    public JSONObject a(String str, String str2, int i, int i2, String str3, String str4) {
        String str5;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject a2 = a(str, str2);
            a2.put("width", i);
            a2.put("height", i2);
            a2.put("device_id", str3);
            jSONObject.put("header", a2);
            jSONObject.put(SimulateLaunchActivity.KEY_QR_PARAM, str4);
            try {
                str5 = a(1, this.f7684a + "/simulator/mobile/login", a(), this.f7685c.b(jSONObject.toString()));
            } catch (RangersHttpException e2) {
                str5 = null;
            }
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            try {
                return new JSONObject(str5);
            } catch (JSONException e3) {
                z2.c("U SHALL NOT PASS!", e3);
                return null;
            }
        } catch (JSONException e4) {
            z2.c("U SHALL NOT PASS!", e4);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            r0 = r5
            com.bytedance.bdtracker.c r0 = r0.b     // Catch: java.lang.Exception -> L1f
            com.bytedance.applog.network.INetworkClient r0 = r0.getNetClient()     // Catch: java.lang.Exception -> L1f
            r1 = r6
            r2 = r5
            com.bytedance.bdtracker.p2 r2 = r2.f7685c     // Catch: java.lang.Exception -> L1f
            r3 = r7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L1f
            byte[] r2 = r2.b(r3)     // Catch: java.lang.Exception -> L1f
            java.lang.String r3 = "application/json; charset=utf-8"
            java.lang.String r0 = r0.post(r1, r2, r3)     // Catch: java.lang.Exception -> L1f
            r6 = r0
            goto L26
        L1f:
            r6 = move-exception
            r0 = r6
            com.bytedance.bdtracker.z2.a(r0)
            r0 = 0
            r6 = r0
        L26:
            r0 = r6
            if (r0 == 0) goto L48
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3e
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: org.json.JSONException -> L3e
            r6 = r0
            r0 = r6
            a(r0)     // Catch: org.json.JSONException -> L3a
            goto L4a
        L3a:
            r7 = move-exception
            goto L41
        L3e:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L41:
            r0 = r7
            com.bytedance.bdtracker.z2.a(r0)
            goto L4a
        L48:
            r0 = 0
            r6 = r0
        L4a:
            r0 = r6
            if (r0 == 0) goto L64
            java.lang.String r0 = "success"
            r1 = r6
            java.lang.String r2 = "message"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.optString(r2, r3)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L64
            r0 = 1
            r8 = r0
            goto L66
        L64:
            r0 = 0
            r8 = r0
        L66:
            r0 = r8
            if (r0 == 0) goto L72
            r0 = r6
            java.lang.String r1 = "data"
            org.json.JSONObject r0 = r0.optJSONObject(r1)
            return r0
        L72:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.q1.a(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    public boolean a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", this.b.getHeader());
            JSONArray jSONArray = new JSONArray();
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
            jSONObject2.put("event_v3", jSONArray);
        } catch (JSONException e2) {
        }
        HashMap<String, String> a2 = a();
        a2.put("Cookie", str);
        try {
            if (new JSONObject(a(1, this.f7684a + "/simulator/mobile/log", a2, this.f7685c.b(jSONObject2.toString()))).getJSONObject("data").getBoolean("keep")) {
                return true;
            }
            this.b.setRangersEventVerifyEnable(false, str);
            return true;
        } catch (Exception e3) {
            return false;
        }
    }
}
