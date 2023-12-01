package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.InitConfig;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m0.class */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7650a;
    public final InitConfig b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f7651c;
    public final SharedPreferences d;
    public final SharedPreferences e;
    public volatile JSONObject f;
    public volatile String g;
    public volatile JSONObject h;
    public volatile HashSet<String> k;
    public int l = 0;
    public int m = 27;
    public long n = 0;
    public int o = 0;
    public long p = 0;
    public int q = 1;
    public final HashSet<String> i = new HashSet<>();
    public final HashSet<String> j = new HashSet<>();

    public m0(IAppLogInstance iAppLogInstance, Context context, InitConfig initConfig) {
        this.f7650a = context;
        this.b = initConfig;
        this.e = e2.a(context, initConfig.getSpName(), 0);
        this.f7651c = e2.a(this.f7650a, b.a(iAppLogInstance, "header_custom"), 0);
        this.d = e2.a(this.f7650a, b.a(iAppLogInstance, "last_sp_session"), 0);
    }

    public static /* synthetic */ String d(JSONObject jSONObject) {
        StringBuilder a2 = a.a("setConfig, ");
        a2.append(jSONObject.toString());
        return a2.toString();
    }

    public ArrayList<t1> a(ArrayList<t1> arrayList) {
        String str;
        Iterator<t1> it = arrayList.iterator();
        ArrayList<t1> arrayList2 = null;
        while (it.hasNext()) {
            t1 next = it.next();
            if (next instanceof x1) {
                x1 x1Var = (x1) next;
                StringBuilder sb = new StringBuilder();
                sb.append(x1Var.q);
                sb.append(!TextUtils.isEmpty(x1Var.r) ? x1Var.r : "");
                str = sb.toString();
            } else {
                str = next instanceof z1 ? ((z1) next).r : "!_NO_NAME_!";
            }
            HashSet<String> hashSet = this.k;
            HashSet<String> hashSet2 = hashSet;
            if (hashSet == null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.e.getString("real_time_events", "[]"));
                    int length = jSONArray.length();
                    hashSet2 = new HashSet<>();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String string = jSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet2.add(string);
                        }
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                    z2.c("U SHALL NOT PASS!", th);
                    hashSet2 = new HashSet<>();
                }
            }
            if (hashSet2.contains(str)) {
                it.remove();
                ArrayList<t1> arrayList3 = arrayList2;
                if (arrayList2 == null) {
                    arrayList3 = new ArrayList<>();
                }
                arrayList3.add(next);
                arrayList2 = arrayList3;
            }
        }
        return arrayList2;
    }

    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f;
        if (jSONObject2 == null) {
            synchronized (this) {
                try {
                    jSONObject2 = new JSONObject(this.f7651c.getString("ab_configure", ""));
                } catch (JSONException e) {
                }
                jSONObject = jSONObject2;
                if (jSONObject2 == null) {
                    jSONObject = new JSONObject();
                }
                this.f = jSONObject;
            }
            return jSONObject;
        }
        return jSONObject2;
    }

    public void a(String str) {
        z2.a("setExternalAbVersion: " + str);
        a.a(this.f7651c, "external_ab_version", str);
        this.g = null;
    }

    public void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        z2.a("setAbConfig, " + jSONObject2);
        a.a(this.f7651c, "ab_configure", jSONObject2);
        this.f = null;
    }

    public boolean a(List<t1> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        if (this.i.size() == 0 && this.j.size() == 0) {
            return true;
        }
        Iterator<t1> it = list.iterator();
        while (it.hasNext()) {
            t1 next = it.next();
            if (next instanceof x1) {
                x1 x1Var = (x1) next;
                StringBuilder sb = new StringBuilder();
                sb.append(x1Var.q);
                sb.append(!TextUtils.isEmpty(x1Var.r) ? x1Var.r : "");
                if (this.i.contains(sb.toString())) {
                    it.remove();
                }
            } else if (next instanceof z1) {
                if (this.j.contains(((z1) next).r)) {
                    it.remove();
                }
            }
        }
        return true;
    }

    public String b() {
        return this.f7651c.getString("ab_sdk_version", "");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void b(JSONObject jSONObject) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public String c() {
        String channel = this.b.getChannel();
        String str = channel;
        if (TextUtils.isEmpty(channel)) {
            str = this.b.getTweakedChannel();
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return this.f7650a.getPackageManager().getApplicationInfo(this.f7650a.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
            } catch (Throwable th) {
                z2.a("getChannel", th);
            }
        }
        return str;
    }

    public void c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("backoff_ratio", 0);
        this.l = optInt;
        if (optInt < 0 || optInt > 10000) {
            this.l = 0;
        }
        int i = this.l > 0 ? 1 : 27;
        int optInt2 = jSONObject.optInt("max_request_frequency", i);
        this.m = optInt2;
        if (optInt2 < 1 || optInt2 > 27) {
            this.m = i;
        }
        if (this.l > 0 && this.n == 0) {
            this.n = System.currentTimeMillis();
            this.o = 1;
        } else if (this.l == 0) {
            this.n = 0L;
            this.o = 0;
        }
        this.p = jSONObject.optLong("batch_event_interval", 0L) * 1000;
        StringBuilder a2 = a.a("updateLogRespConfig mBackoffRatio: ");
        a2.append(this.l);
        a2.append(", mMaxRequestFrequency: ");
        a2.append(this.m);
        a2.append(", mBackoffWindowStartTime: ");
        a2.append(this.n);
        a2.append(", mBackoffWindowSendCount: ");
        a2.append(this.o);
        a2.append(", mEventIntervalFromLogResp: ");
        a2.append(this.p);
        z2.a(a2.toString());
    }

    public long d() {
        long j = this.p;
        return (j > 10000L ? 1 : (j == 10000L ? 0 : -1)) >= 0 && (j > 300000L ? 1 : (j == 300000L ? 0 : -1)) <= 0 ? this.p : this.e.getLong("batch_event_interval", 60000L);
    }

    public String e() {
        String string;
        String str = this.g;
        if (TextUtils.isEmpty(str)) {
            synchronized (this) {
                string = this.f7651c.getString("external_ab_version", "");
                this.g = string;
            }
            return string;
        }
        return str;
    }

    public String f() {
        return this.e.getString("channel", "");
    }

    public long g() {
        return this.e.getLong("session_interval", 30000L);
    }

    public String h() {
        StringBuilder a2 = a.a("ssid_");
        a2.append(this.b.getAid());
        return a2.toString();
    }

    public boolean i() {
        BufferedReader bufferedReader;
        boolean z = false;
        if (this.b.getProcess() == 0) {
            String str = j1.f7631a;
            if (TextUtils.isEmpty(str)) {
                String str2 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = bufferedReader.read();
                            if (read <= 0) {
                                break;
                            }
                            sb.append((char) read);
                        }
                        str2 = sb.toString();
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    bufferedReader = null;
                }
                j1.a((Closeable) bufferedReader);
                j1.f7631a = str2;
                StringBuilder a2 = a.a("getProcessName: ");
                a2.append(j1.f7631a);
                z2.a(a2.toString());
                str = j1.f7631a;
            }
            if (TextUtils.isEmpty(str)) {
                this.b.setProcess(0);
            } else {
                this.b.setProcess(str.contains(":") ? 2 : 1);
            }
        }
        if (this.b.getProcess() == 1) {
            z = true;
        }
        return z;
    }
}
