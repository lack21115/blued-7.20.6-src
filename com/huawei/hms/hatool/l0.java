package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/l0.class */
public class l0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f22765a = b.i();
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22766c;
    public String d;

    public l0(String str, String str2, String str3) {
        this.b = str;
        this.f22766c = str2;
        this.d = str3;
    }

    public final void a(String str, List<q> list) {
        Pair<String, String> a2 = v0.a(str);
        new t(list, a2.first, a2.second, this.d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<q>> a2;
        z.c("hmsSdk", "eventReportTask is running");
        boolean a3 = r0.a(this.f22765a);
        if (a3) {
            z.c("hmsSdk", "workKey is refresh,begin report all data");
            this.f22766c = "alltype";
        }
        try {
            try {
                a2 = w.a(this.f22765a, this.b, this.f22766c);
            } catch (IllegalArgumentException e) {
                z.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
                if ("alltype".equals(this.f22766c)) {
                    h0.a(this.f22765a, "stat_v2_1", new String[0]);
                    h0.a(this.f22765a, "cached_v2_1", new String[0]);
                } else {
                    String a4 = v0.a(this.b, this.f22766c);
                    h0.a(this.f22765a, "stat_v2_1", a4);
                    h0.a(this.f22765a, "cached_v2_1", a4);
                }
            } catch (Exception e2) {
                z.e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
                if ("alltype".equals(this.f22766c)) {
                    h0.a(this.f22765a, "stat_v2_1", new String[0]);
                    h0.a(this.f22765a, "cached_v2_1", new String[0]);
                } else {
                    String a5 = v0.a(this.b, this.f22766c);
                    h0.a(this.f22765a, "stat_v2_1", a5);
                    h0.a(this.f22765a, "cached_v2_1", a5);
                }
            }
            if (a2.size() == 0) {
                z.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.b, this.f22766c);
                if ("alltype".equals(this.f22766c)) {
                    h0.a(this.f22765a, "stat_v2_1", new String[0]);
                    h0.a(this.f22765a, "cached_v2_1", new String[0]);
                    return;
                }
                String a6 = v0.a(this.b, this.f22766c);
                h0.a(this.f22765a, "stat_v2_1", a6);
                h0.a(this.f22765a, "cached_v2_1", a6);
                return;
            }
            for (Map.Entry<String, List<q>> entry : a2.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f22766c)) {
                h0.a(this.f22765a, "stat_v2_1", new String[0]);
                h0.a(this.f22765a, "cached_v2_1", new String[0]);
            } else {
                String a7 = v0.a(this.b, this.f22766c);
                h0.a(this.f22765a, "stat_v2_1", a7);
                h0.a(this.f22765a, "cached_v2_1", a7);
            }
            if (a3) {
                z.c("hmsSdk", "refresh local key");
                e0.f().b();
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f22766c)) {
                h0.a(this.f22765a, "stat_v2_1", new String[0]);
                h0.a(this.f22765a, "cached_v2_1", new String[0]);
            } else {
                String a8 = v0.a(this.b, this.f22766c);
                h0.a(this.f22765a, "stat_v2_1", a8);
                h0.a(this.f22765a, "cached_v2_1", a8);
            }
            throw th;
        }
    }
}
