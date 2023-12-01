package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.al;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/d.class */
public class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40818a = "iucc";
    private static final String b = at.b().b(at.C);

    /* renamed from: c  reason: collision with root package name */
    private static JSONObject f40819c = null;
    private static final String[] d = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h};
    private static ArrayList<aa> e = null;
    private static ArrayList<aa> f = null;
    private static ArrayList<aa> g = null;
    private static c j = new c();
    private volatile String h = "";
    private Map<String, a> i = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/d$a.class */
    public class a {
        private JSONArray b;

        /* renamed from: c  reason: collision with root package name */
        private String f40822c;

        public a(JSONArray jSONArray, String str) {
            this.b = jSONArray;
            this.f40822c = str;
        }

        public JSONArray a() {
            return this.b;
        }

        public String b() {
            return this.f40822c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/d$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final d f40823a = new d();

        private b() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/d$c.class */
    public static class c extends BroadcastReceiver {
        public long a(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return 0L;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return 0L;
                }
                aa aaVar = arrayList.get(i2);
                if (aaVar instanceof ac) {
                    return ((ac) aaVar).c();
                }
                i = i2 + 1;
            }
        }

        public boolean b(ArrayList<aa> arrayList) {
            boolean z = false;
            if (arrayList != null) {
                z = false;
                if (arrayList.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            z = true;
                            break;
                        } else if (arrayList.get(i2).b()) {
                            return false;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
            }
            return z;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals(Intent.ACTION_SCREEN_ON)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.e)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.e) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals(Intent.ACTION_SCREEN_OFF)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.g) * 1000);
                }
            } catch (Throwable th) {
            }
        }
    }

    private z a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || !(jSONObject instanceof JSONObject)) {
            return null;
        }
        try {
            if (!jSONObject.has(com.umeng.ccg.a.i) || (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.i)) == null || optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            boolean has = jSONObject2.has(com.umeng.ccg.a.j);
            boolean has2 = jSONObject2.has(com.umeng.ccg.a.m);
            boolean has3 = jSONObject2.has(com.umeng.ccg.a.n);
            if (has && has2 && has3) {
                try {
                    int optInt = jSONObject2.optInt(com.umeng.ccg.a.j);
                    long optLong = jSONObject2.optLong(com.umeng.ccg.a.m);
                    long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.n);
                    String optString = jSONObject2.optString(com.umeng.ccg.a.o);
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has(com.umeng.ccg.a.k)) {
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray(com.umeng.ccg.a.k);
                        HashSet hashSet = new HashSet();
                        if (optJSONArray2 != null) {
                            int length = optJSONArray2.length();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    break;
                                }
                                hashSet.add(Integer.valueOf(optJSONArray2.getInt(i2)));
                                i = i2 + 1;
                            }
                        }
                        if (hashSet.size() > 0) {
                            aj ajVar = new aj(hashSet);
                            if (Arrays.asList(d).contains(str)) {
                                a(str, ajVar);
                            } else {
                                arrayList.add(ajVar);
                            }
                        }
                    }
                    if (jSONObject2.has(com.umeng.ccg.a.l)) {
                        String optString2 = jSONObject2.optString(com.umeng.ccg.a.l);
                        if (!TextUtils.isEmpty(optString2)) {
                            ah ahVar = new ah(optString2);
                            HashSet hashSet2 = new HashSet();
                            int i3 = 1;
                            while (true) {
                                int i4 = i3;
                                if (i4 > 24) {
                                    break;
                                }
                                if (ahVar.a(i4)) {
                                    hashSet2.add(Integer.valueOf(i4));
                                }
                                i3 = i4 + 1;
                            }
                            if (hashSet2.size() > 0) {
                                ad adVar = new ad(hashSet2);
                                if (Arrays.asList(d).contains(str)) {
                                    a(str, adVar);
                                } else {
                                    arrayList.add(adVar);
                                }
                            }
                        }
                    }
                    arrayList.add(new af(optInt));
                    ae aeVar = new ae(str, optLong);
                    if (Arrays.asList(d).contains(str)) {
                        a(str, aeVar);
                    } else {
                        arrayList.add(aeVar);
                    }
                    ac acVar = new ac(optLong2);
                    if (Arrays.asList(d).contains(str)) {
                        a(str, acVar);
                        arrayList.add(acVar);
                    } else {
                        arrayList.add(acVar);
                    }
                    ab abVar = com.umeng.ccg.a.e.equals(str) ? new ab(str, arrayList) : new z(str, arrayList);
                    try {
                        abVar.a(optString);
                        String str2 = "";
                        if (jSONObject.has("sdk")) {
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("sdk");
                            str2 = "";
                            if (optJSONArray3 != null) {
                                str2 = "";
                                if (optJSONArray3 instanceof JSONArray) {
                                    if (this.i != null && !this.i.containsKey(str)) {
                                        this.i.put(str, new a(new JSONArray(optJSONArray3.toString()), optString));
                                    }
                                    int length2 = optJSONArray3.length();
                                    int i5 = 0;
                                    String str3 = "";
                                    while (true) {
                                        str2 = str3;
                                        if (i5 >= optJSONArray3.length()) {
                                            break;
                                        }
                                        String str4 = str3 + optJSONArray3.getString(i5);
                                        str3 = str4;
                                        if (i5 < length2 - 1) {
                                            str3 = str4 + ",";
                                        }
                                        i5++;
                                    }
                                }
                            }
                        }
                        abVar.b(str2);
                        if (com.umeng.ccg.a.e.equals(str) && (abVar instanceof ab)) {
                            if (jSONObject2.has("action")) {
                                ((ab) abVar).d(jSONObject2.optString("action"));
                            }
                            if (jSONObject2.has(com.umeng.ccg.a.s)) {
                                ((ab) abVar).c(jSONObject2.optString(com.umeng.ccg.a.s));
                            }
                        }
                    } catch (Throwable th) {
                    }
                    return abVar;
                } catch (Throwable th2) {
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            return null;
        }
    }

    public static d a() {
        return b.f40823a;
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(j, intentFilter);
    }

    private void a(Context context, String str, long j2) {
        SharedPreferences a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a2 = aq.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a2.edit();
            edit.putLong(aq.f40629c, j2);
            edit.putLong(aq.d, parseLong);
            edit.putString(aq.e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable th) {
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long b2 = b(jSONObject);
            byte[] a2 = as.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (a2 == null || a2.length <= 1) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), b));
            fileOutputStream.write(a2);
            fileOutputStream.flush();
            ap.a(fileOutputStream);
            a(context, str, b2);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
        } catch (Throwable th) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.h)) {
                String[] split2 = this.h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                if (a2.getLong(aq.f40629c, 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.h = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.h = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable th) {
        }
    }

    private void a(String str, aa aaVar) {
        if (com.umeng.ccg.a.f.equalsIgnoreCase(str)) {
            if (e == null) {
                e = new ArrayList<>();
            }
            e.add(aaVar);
        }
        if (com.umeng.ccg.a.g.equalsIgnoreCase(str)) {
            if (f == null) {
                f = new ArrayList<>();
            }
            f.add(aaVar);
        }
        if (com.umeng.ccg.a.h.equalsIgnoreCase(str)) {
            if (g == null) {
                g = new ArrayList<>();
            }
            g.add(aaVar);
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                SharedPreferences.Editor edit = a2.edit();
                if (z) {
                    edit.putString(aq.g, "1").commit();
                } else {
                    edit.putString(aq.g, "").commit();
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has("cc")) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("ts")) {
            return 0L;
        }
        try {
            return jSONObject.optLong("ts");
        } catch (Throwable th) {
            return 0L;
        }
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStream;
        try {
            if (new File(context.getFilesDir(), b).exists()) {
                try {
                    fileInputStream = context.openFileInput(b);
                } catch (Throwable th) {
                    fileInputStream = null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(as.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStream);
                    } catch (Throwable th2) {
                    }
                    return jSONObject;
                } catch (Throwable th3) {
                    ap.a(fileInputStream);
                    return null;
                }
            }
            return null;
        } catch (Throwable th4) {
            return null;
        }
    }

    private void b(String str) {
        String str2 = aq.b + str;
        SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            a2.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f40818a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && (jSONObject instanceof JSONObject) && jSONObject.has("cc")) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("cc");
                z zVar = null;
                z a2 = optJSONObject.has(com.umeng.ccg.a.b) ? a(com.umeng.ccg.a.b, optJSONObject.optJSONObject(com.umeng.ccg.a.b)) : null;
                z a3 = optJSONObject.has(com.umeng.ccg.a.f40813c) ? a(com.umeng.ccg.a.f40813c, optJSONObject.optJSONObject(com.umeng.ccg.a.f40813c)) : null;
                z a4 = optJSONObject.has(com.umeng.ccg.a.d) ? a(com.umeng.ccg.a.d, optJSONObject.optJSONObject(com.umeng.ccg.a.d)) : null;
                z a5 = optJSONObject.has(com.umeng.ccg.a.e) ? a(com.umeng.ccg.a.e, optJSONObject.optJSONObject(com.umeng.ccg.a.e)) : null;
                z a6 = optJSONObject.has(com.umeng.ccg.a.f) ? a(com.umeng.ccg.a.f, optJSONObject.optJSONObject(com.umeng.ccg.a.f)) : null;
                z a7 = optJSONObject.has(com.umeng.ccg.a.g) ? a(com.umeng.ccg.a.g, optJSONObject.optJSONObject(com.umeng.ccg.a.g)) : null;
                if (optJSONObject.has(com.umeng.ccg.a.h)) {
                    zVar = a(com.umeng.ccg.a.h, optJSONObject.optJSONObject(com.umeng.ccg.a.h));
                }
                ArrayList arrayList = new ArrayList();
                if (a2 != null) {
                    arrayList.add(a2);
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                if (a4 != null) {
                    arrayList.add(a4);
                }
                if (a5 != null) {
                    arrayList.add(a5);
                }
                if (a6 != null) {
                    arrayList.add(a6);
                }
                if (a7 != null) {
                    arrayList.add(a7);
                }
                if (zVar != null) {
                    arrayList.add(zVar);
                }
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable th) {
            }
        }
    }

    private Long d(Context context) {
        try {
            SharedPreferences a2 = aq.a(context);
            Long l = 0L;
            if (a2 != null) {
                l = Long.valueOf(a2.getLong(aq.d, 0L));
            }
            return l;
        } catch (Throwable th) {
            return 0L;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences a2 = aq.a(context);
            return a2 != null ? a2.getString(aq.e, "") : "";
        } catch (Throwable th) {
            return "";
        }
    }

    private boolean e() {
        SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            String string = a2.getString(aq.f, "");
            if (TextUtils.isEmpty(string)) {
                f();
                return false;
            }
            try {
                return !ap.a().keySet().equals(ap.a(new JSONObject(string)).keySet());
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private void f() {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                a2.edit().putString(aq.f, new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable th) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            boolean z = false;
            if (a2 != null) {
                z = false;
                if (!TextUtils.isEmpty(a2.getString(aq.g, ""))) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v88, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v11, types: [org.json.JSONObject] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x0848 -> B:173:0x06ba). Please submit an issue!!! */
    @Override // com.umeng.ccg.c.a
    public void a(Object obj, int i) {
        String[] strArr;
        ArrayList arrayList;
        int size;
        a aVar;
        a aVar2;
        a aVar3;
        try {
            switch (i) {
                case 101:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    String str = (String) obj;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                    JSONObject a2 = al.a(UMGlobalContext.getAppContext(), str);
                    if (a2 != null) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + a2.toString());
                        ar.a(new ao(ao.f40626a, a2, str), 0L, TimeUnit.SECONDS);
                    }
                    if (g()) {
                        c(UMGlobalContext.getAppContext());
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f40818a, "");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty);
                        a(imprintProperty);
                        return;
                    }
                    return;
                case 102:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.h = "";
                    if (obj == null || !(obj instanceof JSONObject)) {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    if (a(jSONObject.optJSONObject(com.igexin.push.core.b.U))) {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject);
                        return;
                    } else {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        return;
                    }
                case 103:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj;
                    JSONObject optJSONObject = jSONObject2.optJSONObject(com.igexin.push.core.b.U);
                    String optString = jSONObject2.optString("sourceIucc");
                    if (optJSONObject != null) {
                        if (g()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                            f();
                            a(false);
                        }
                        a(appContext, optJSONObject, optString);
                        return;
                    }
                    return;
                case 104:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    return;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                            Integer num = 0;
                            try {
                                JSONObject b2 = b(UMGlobalContext.getAppContext());
                                Integer valueOf = (b2 == null || !(b2 instanceof JSONObject)) ? Integer.valueOf(num.intValue() | 0) : a(b2) ? Integer.valueOf(num.intValue() | 1) : Integer.valueOf(num.intValue() | 0);
                                ?? jSONObject3 = new JSONObject();
                                collectItemList = jSONObject3;
                                jSONObject3.put("result", valueOf);
                                strArr = jSONObject3;
                                if (b2 != null) {
                                    collectItemList = jSONObject3;
                                    strArr = jSONObject3;
                                    if (b2 instanceof JSONObject) {
                                        ?? r16 = jSONObject3;
                                        collectItemList = r16;
                                        r16.put(com.igexin.push.core.b.U, b2);
                                        strArr = r16;
                                    }
                                }
                            } catch (Throwable th) {
                                strArr = collectItemList;
                            }
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), strArr);
                            return;
                        }
                        String str2 = collectItemList[i3];
                        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(str2);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + forbidSdkArray.toString());
                        i2 = i3 + 1;
                    }
                    break;
                case 106:
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject4 = (JSONObject) obj;
                    if (jSONObject4 != null && jSONObject4.has("result")) {
                        boolean z = false;
                        if ((jSONObject4.optInt("result") & 1) != 0) {
                            z = false;
                            if (jSONObject4.has(com.igexin.push.core.b.U)) {
                                JSONObject optJSONObject2 = jSONObject4.optJSONObject(com.igexin.push.core.b.U);
                                f40819c = optJSONObject2;
                                z = false;
                                if (optJSONObject2 != null) {
                                    CcgAgent.notifyConfigReady(optJSONObject2);
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            CcgAgent.notifyConfigReady(null);
                        }
                    }
                    if (e()) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f40818a, "");
                        a(true);
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), imprintProperty2);
                        return;
                    }
                    c(UMGlobalContext.getAppContext());
                    String imprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f40818a, "");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty3);
                    a(imprintProperty3);
                    return;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th2.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    switch (i) {
                        case 201:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            c((JSONObject) obj);
                            return;
                        case 202:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj == null || !(obj instanceof ArrayList) || (size = (arrayList = (ArrayList) obj).size()) <= 0) {
                                return;
                            }
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 >= size) {
                                    return;
                                }
                                z zVar = (z) arrayList.get(i5);
                                JSONObject a3 = zVar.a(zVar.a(), null);
                                if (a3 != null) {
                                    long optLong = !Arrays.asList(d).contains(zVar.a()) ? a3.optLong("delay") * 1000 : 0L;
                                    a3.remove("delay");
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + optLong);
                                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 203, a(), a3, optLong);
                                }
                                i4 = i5 + 1;
                            }
                            break;
                        case 203:
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            JSONObject jSONObject5 = (JSONObject) obj;
                            String optString2 = jSONObject5.optString("actionName");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + optString2);
                            if (!com.umeng.ccg.b.a(optString2)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + optString2 + "] is off, ignore this command.");
                                return;
                            }
                            String jSONObject6 = jSONObject5.toString();
                            if (Arrays.asList(d).contains(optString2)) {
                                if (com.umeng.ccg.a.f.equalsIgnoreCase(optString2)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                    a(UMGlobalContext.getAppContext(), Intent.ACTION_SCREEN_ON);
                                }
                                if (com.umeng.ccg.a.g.equalsIgnoreCase(optString2)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                    a(UMGlobalContext.getAppContext(), Intent.ACTION_SCREEN_OFF);
                                }
                                if (com.umeng.ccg.a.h.equalsIgnoreCase(optString2)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                    a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT");
                                    return;
                                }
                                return;
                            }
                            b(optString2);
                            if (!CcgAgent.hasRegistedActionInfo()) {
                                ap.a(UMGlobalContext.getAppContext(), jSONObject6);
                                return;
                            }
                            boolean z2 = CcgAgent.getActionInfo("anti") != null;
                            String optString3 = jSONObject5.optString(com.umeng.ccg.a.p);
                            if (TextUtils.isEmpty(optString3)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + optString2 + "]采集请求.");
                            } else {
                                ActionInfo actionInfo = CcgAgent.getActionInfo(optString3);
                                if (actionInfo != null) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "调用[" + optString3 + "] onCommand接口方法, 参数: " + jSONObject5.toString());
                                    actionInfo.onCommand(UMGlobalContext.getAppContext(), optString2, jSONObject5);
                                }
                            }
                            if (z2) {
                                return;
                            }
                            ap.a(UMGlobalContext.getAppContext(), jSONObject6);
                            return;
                        default:
                            switch (i) {
                                case 301:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    b(com.umeng.ccg.a.f);
                                    if (!this.i.containsKey(com.umeng.ccg.a.f) || (aVar = this.i.get(com.umeng.ccg.a.f)) == null) {
                                        return;
                                    }
                                    JSONObject a4 = al.a(UMGlobalContext.getAppContext(), 1, aVar.a(), aVar.b());
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_on event param: " + a4.toString());
                                    ar.a(new an(an.f40624a, a4), 0L, TimeUnit.SECONDS);
                                    return;
                                case 302:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    b(com.umeng.ccg.a.g);
                                    if (!this.i.containsKey(com.umeng.ccg.a.g) || (aVar2 = this.i.get(com.umeng.ccg.a.g)) == null) {
                                        return;
                                    }
                                    JSONObject a5 = al.a(UMGlobalContext.getAppContext(), 3, aVar2.a(), aVar2.b());
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_off event param: " + a5.toString());
                                    ar.a(new an(an.f40624a, a5), 0L, TimeUnit.SECONDS);
                                    return;
                                case 303:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    b(com.umeng.ccg.a.h);
                                    if (!this.i.containsKey(com.umeng.ccg.a.h) || (aVar3 = this.i.get(com.umeng.ccg.a.h)) == null) {
                                        return;
                                    }
                                    JSONObject a6 = al.a(UMGlobalContext.getAppContext(), 2, aVar3.a(), aVar3.b());
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + a6.toString());
                                    ar.a(new an(an.f40624a, a6), 0L, TimeUnit.SECONDS);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } catch (Throwable th3) {
        }
    }
}
