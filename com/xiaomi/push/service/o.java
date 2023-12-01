package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.xiaomi.push.he;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile o f41686a;

    /* renamed from: a  reason: collision with other field name */
    private long f1058a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f1059a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f1060a;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f1065b;

    /* renamed from: c  reason: collision with other field name */
    private final boolean f1066c;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f1062a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private String f1061a = null;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f1063a = false;
    private String b = null;

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f1064b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f41687c = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private int f1057a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/o$a.class */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private o(Context context) {
        this.f1059a = context;
        this.f1066c = com.xiaomi.push.j.m12048a(context);
        this.f1065b = ba.a(this.f1059a).a(hl.IntelligentHeartbeatSwitchBoolean.a(), true);
        this.f1060a = this.f1059a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1060a.getLong(a.c(), -1L) == -1) {
            this.f1060a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f1060a.getLong(a.i(), -1L);
        this.f1058a = j;
        if (j == -1) {
            this.f1058a = currentTimeMillis;
            this.f1060a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        int i = -1;
        if (!TextUtils.isEmpty(this.f1061a)) {
            try {
                i = this.f1060a.getInt(a.a(this.f1061a), -1);
            } catch (Throwable th) {
                return -1;
            }
        }
        return i;
    }

    public static o a(Context context) {
        if (f41686a == null) {
            synchronized (o.class) {
                try {
                    if (f41686a == null) {
                        f41686a = new o(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41686a;
    }

    private void a(String str, String str2, Map<String, String> map) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c("hb_name");
        hkVar.a("hb_channel");
        hkVar.a(1L);
        hkVar.b(str2);
        hkVar.a(false);
        hkVar.b(System.currentTimeMillis());
        hkVar.g(this.f1059a.getPackageName());
        hkVar.e("com.xiaomi.xmsf");
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        t m12210a = u.m12210a(this.f1059a);
        String str3 = null;
        if (m12210a != null) {
            str3 = null;
            if (!TextUtils.isEmpty(m12210a.f1080a)) {
                String[] split = m12210a.f1080a.split("@");
                str3 = null;
                if (split.length > 0) {
                    str3 = split[0];
                }
            }
        }
        hashMap.put("uuid", str3);
        hashMap.put("model", Build.MODEL);
        Context context = this.f1059a;
        hashMap.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        hashMap.put("pvc", "50010");
        hashMap.put("cvc", com.huawei.openalliance.ad.beans.inner.a.Code);
        hkVar.a(hashMap);
        he a2 = he.a(this.f1059a);
        if (a2 != null) {
            a2.a(hkVar, this.f1059a.getPackageName());
        }
    }

    private void a(boolean z) {
        if (m12188c()) {
            int incrementAndGet = (z ? this.f1064b : this.f41687c).incrementAndGet();
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", z ? Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT : "long", Integer.valueOf(incrementAndGet)));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f1060a.getInt(d, 0) + incrementAndGet;
                this.f1060a.edit().putInt(d, i).apply();
                com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", z ? Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT : "long", Integer.valueOf(i)));
                if (z) {
                    this.f1064b.set(0);
                } else {
                    this.f41687c.set(0);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m12186a() {
        return this.f1062a.get() >= Math.max(ba.a(this.f1059a).a(hl.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f1060a.getLong(a.j(), -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.b(java.lang.String):void");
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m12187b() {
        return (TextUtils.isEmpty(this.f1061a) || !this.f1061a.startsWith("M-") || ba.a(this.f1059a).a(hl.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) ? false : true;
    }

    private long c() {
        return ba.a(this.f1059a).a(hl.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f1060a.edit().putInt(a.a(str), 235000).apply();
            this.f1060a.edit().putLong(a.b(this.f1061a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m12188c() {
        return d() && ba.a(this.f1059a).a(hl.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.m.China.name().equals(com.xiaomi.push.service.a.a(this.f1059a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m12188c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append("235000");
            sb.append(":::");
            sb.append(String.valueOf(currentTimeMillis));
            String string = this.f1060a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f1060a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        boolean z = b() >= System.currentTimeMillis();
        if (this.f1066c) {
            return this.f1065b || z;
        }
        return false;
    }

    private void e() {
        if (this.f1060a.getBoolean(a.a(), false)) {
            return;
        }
        this.f1060a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m12189e() {
        long j = this.f1060a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f1057a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(h)) {
            return;
        }
        if (this.f1060a.getLong(a.i(), -1L) == -1) {
            this.f1058a = System.currentTimeMillis();
            this.f1060a.edit().putLong(a.i(), this.f1058a).apply();
        }
        this.f1060a.edit().putInt(h, this.f1060a.getInt(h, 0) + 1).apply();
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m12190f() {
        if (this.f1058a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1058a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x03db -> B:33:0x023d). Please submit an issue!!! */
    private void g() {
        String[] split;
        String[] split2;
        if (m12188c()) {
            String string = this.f1060a.getString(a.f(), null);
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= split.length) {
                        break;
                    }
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[0];
                        String str2 = split2[1];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put(com.umeng.analytics.pro.bh.aX, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] report hb changed events.");
                    }
                    i = i2 + 1;
                }
                this.f1060a.edit().remove(a.f()).apply();
            }
            if (this.f1060a.getBoolean(a.a(), false) && !this.f1060a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] report support wifi digest events.");
                this.f1060a.edit().putBoolean(a.b(), true).apply();
            }
            if (m12189e()) {
                int i3 = this.f1060a.getInt(a.d(), 0);
                int i4 = this.f1060a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f1060a.getLong(a.c(), -1L);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.umeng.analytics.pro.bh.aX, "235000");
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", String.valueOf(j));
                        jSONObject.put("end_time", String.valueOf(currentTimeMillis));
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] report short/long hb count events.");
                    } catch (Throwable th) {
                    }
                }
                this.f1060a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m12190f()) {
                String valueOf = String.valueOf(this.f1058a);
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f1060a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf);
                        jSONObject3.put("end_time", valueOf2);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] report ping timeout count events of mobile network.");
                        this.f1060a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable th2) {
                        this.f1060a.edit().putInt(a.g(), 0).apply();
                    }
                }
                int i6 = this.f1060a.getInt(a.h(), 0);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf);
                        jSONObject5.put("end_time", valueOf2);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable th3) {
                    }
                    this.f1060a.edit().putInt(a.h(), 0).apply();
                }
                this.f1058a = System.currentTimeMillis();
                this.f1060a.edit().putLong(a.i(), this.f1058a).apply();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (b() >= java.lang.System.currentTimeMillis()) goto L9;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m12191a() {
        /*
            r5 = this;
            int r0 = com.xiaomi.push.ga.b()
            long r0 = (long) r0
            r9 = r0
            r0 = r5
            boolean r0 = r0.f1066c
            r12 = r0
            r0 = 1
            r11 = r0
            r0 = r9
            r7 = r0
            r0 = r12
            if (r0 == 0) goto L53
            r0 = r9
            r7 = r0
            r0 = r5
            boolean r0 = r0.m12187b()
            if (r0 != 0) goto L53
            r0 = r5
            android.content.Context r0 = r0.f1059a
            com.xiaomi.push.service.ba r0 = com.xiaomi.push.service.ba.a(r0)
            com.xiaomi.push.hl r1 = com.xiaomi.push.hl.IntelligentHeartbeatSwitchBoolean
            int r1 = r1.a()
            r2 = 1
            boolean r0 = r0.a(r1, r2)
            if (r0 != 0) goto L43
            r0 = r9
            r7 = r0
            r0 = r5
            long r0 = r0.b()
            long r1 = java.lang.System.currentTimeMillis()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L53
        L43:
            r0 = r5
            int r0 = r0.a()
            r6 = r0
            r0 = r9
            r7 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L53
            r0 = r6
            long r0 = (long) r0
            r7 = r0
        L53:
            r0 = r5
            java.lang.String r0 = r0.f1061a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L86
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            r1 = r5
            java.lang.String r1 = r1.f1061a
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L86
            r0 = r5
            int r0 = r0.f1057a
            r1 = 1
            if (r0 != r1) goto L86
            r0 = r7
            r1 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L7d
            goto L80
        L7d:
            r0 = 0
            r11 = r0
        L80:
            r0 = r5
            r1 = r11
            r0.a(r1)
        L86:
            java.lang.String r0 = "[HB] ping interval:"
            r1 = r7
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            com.xiaomi.channel.commonutils.logger.b.m11394a(r0)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.m12191a():long");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12192a() {
    }

    public void a(int i) {
        this.f1060a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    public void a(NetworkInfo networkInfo) {
        synchronized (this) {
            if (d()) {
                if (networkInfo != null) {
                    if (networkInfo.getType() != 0) {
                        if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                            b(null);
                            this.f1057a = -1;
                            return;
                        }
                        b("WIFI-ID-UNKNOWN");
                        this.f1057a = 1;
                        return;
                    }
                    String subtypeName = networkInfo.getSubtypeName();
                    String str = null;
                    if (!TextUtils.isEmpty(subtypeName)) {
                        str = null;
                        if (!"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                            str = "M-".concat(String.valueOf(subtypeName));
                        }
                    }
                    b(str);
                    this.f1057a = 0;
                    return;
                }
                b(null);
                this.f1057a = -1;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12193a(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                e();
            }
            if (d() && !TextUtils.isEmpty(str)) {
                b("W-".concat(String.valueOf(str)));
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m12194b() {
        if (d()) {
            f();
            if (this.f1063a && !TextUtils.isEmpty(this.f1061a) && this.f1061a.equals(this.b)) {
                this.f1062a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] ping timeout count:" + this.f1062a);
                if (m12186a()) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("[HB] change hb interval for net:" + this.f1061a);
                    c(this.f1061a);
                    this.f1063a = false;
                    this.f1062a.getAndSet(0);
                    d(this.f1061a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m12195c() {
        if (d()) {
            this.b = this.f1061a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m12196d() {
        if (d()) {
            g();
            if (this.f1063a) {
                this.f1062a.getAndSet(0);
            }
        }
    }
}
