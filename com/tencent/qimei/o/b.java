package com.tencent.qimei.o;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qimei.sdk.Qimei;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f38367a;

    public b(d dVar) {
        this.f38367a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.qimei.j.f fVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        fVar = this.f38367a.i;
        fVar.b();
        com.tencent.qimei.k.a.b(d.f38369a, "collectionRateTask is running", new Object[0]);
        str = this.f38367a.f38370c;
        if (TextUtils.isEmpty(com.tencent.qimei.i.f.a(str).c("is_first"))) {
            d dVar = this.f38367a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = 0;
            if (Build.VERSION.SDK_INT >= 24) {
                j = Process.getStartElapsedRealtime();
            } else {
                elapsedRealtime = -1;
            }
            dVar.h = String.valueOf(elapsedRealtime - j);
            int nextInt = com.tencent.qimei.s.e.f38413a.nextInt(3) + 1;
            this.f38367a.a(nextInt);
            str2 = this.f38367a.f38370c;
            Qimei d = com.tencent.qimei.a.a.d(str2);
            if (d != null) {
                this.f38367a.f = TextUtils.isEmpty(d.a()) ? "0" : "1";
                this.f38367a.g = TextUtils.isEmpty(d.b()) ? "0" : "1";
            }
            str3 = this.f38367a.f38370c;
            str4 = this.f38367a.f;
            str5 = this.f38367a.g;
            str6 = this.f38367a.h;
            com.tencent.qimei.n.c a2 = com.tencent.qimei.n.i.a().a(com.tencent.qimei.n.e.REPORT_COLLECT_RATE_Q16.K, str4).a(com.tencent.qimei.n.e.REPORT_COLLECT_RATE_Q36.K, str5).a(com.tencent.qimei.n.e.REPORT_COLLECT_RATE_DELAY.K, String.valueOf(nextInt)).a(com.tencent.qimei.n.e.REPORT_STARTUP_DURAtION.K, str6);
            a2.f38356a = str3;
            a2.f38357c = "/report";
            a2.a("v8");
        }
    }
}
