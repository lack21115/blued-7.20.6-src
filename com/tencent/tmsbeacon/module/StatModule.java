package com.tencent.tmsbeacon.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.tmsbeacon.a.a.d;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import com.tencent.tmsbeacon.event.open.EventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StatModule.class */
public class StatModule implements d, BeaconModule {

    /* renamed from: a  reason: collision with root package name */
    private Context f25904a;
    private com.tencent.tmsbeacon.d.b d;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25905c = true;
    private long e = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StatModule$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e l = e.l();
            f e = f.e();
            BeaconEvent.Builder withParams = BeaconEvent.builder().withParams("A9", Build.BRAND).withParams("A10", e.h()).withParams("A11", l.g()).withParams("A12", l.n()).withParams("A13", l.z());
            BeaconEvent.Builder withParams2 = withParams.withParams("A14", l.w() + "m");
            BeaconEvent.Builder withParams3 = withParams2.withParams("A15", l.t() + "m").withParams("A16", l.h()).withParams("A17", l.u()).withParams("A18", "").withParams("A20", e.j());
            BeaconEvent.Builder withParams4 = withParams3.withParams("A30", l.x() + "m").withParams("A19", l.q());
            BeaconEvent.Builder withParams5 = withParams4.withParams("A52", "" + l.y());
            BeaconEvent.Builder withParams6 = withParams5.withParams("A53", "" + l.e() + "m");
            BeaconEvent.Builder withParams7 = withParams6.withParams("A54", "" + l.r()).withParams("A55", l.f()).withParams("A56", l.C() ? "Y" : "N").withParams("A57", l.A()).withParams("A58", l.m() ? "Y" : "N");
            BeaconReport.getInstance().report(withParams7.withParams("A59", l.k() + "m").withParams("A69", e.k()).withParams("A82", l.v()).withType(EventType.REALTIME).withCode("rqd_model").build());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StatModule$b.class */
    public class b implements Runnable {
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25906c;
        public final /* synthetic */ long d;

        public b(long j, String str, long j2) {
            this.b = j;
            this.f25906c = str;
            this.d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(this.b)).withParams("A111", this.f25906c).withParams("A112", String.valueOf(this.d)).withCode("rqd_page_fgt").withType(EventType.REALTIME).build());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StatModule$c.class */
    public class c implements Runnable {
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25907c;
        public final /* synthetic */ long d;

        public c(long j, String str, long j2) {
            this.b = j;
            this.f25907c = str;
            this.d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(this.b)).withParams("A111", this.f25907c).withParams("A112", String.valueOf(this.d)).withCode("rqd_page").withType(EventType.NORMAL).build());
            StatModule.this.e += this.d;
            if (StatModule.this.e >= 15000) {
                StatModule.this.e = 0L;
            }
        }
    }

    private void c() {
        ((Application) this.f25904a).registerActivityLifecycleCallbacks(new com.tencent.tmsbeacon.c.a.d(this));
    }

    private void d() {
        com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
        if (com.tencent.tmsbeacon.base.util.b.d().equals(a2.getString("rqd_model", ""))) {
            return;
        }
        com.tencent.tmsbeacon.a.b.a.a().a(50000L, new a());
        a.SharedPreferences$EditorC0861a edit = a2.edit();
        if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putString("rqd_model", com.tencent.tmsbeacon.base.util.b.d());
        }
    }

    private void e() {
        if (this.d.e()) {
            if (com.tencent.tmsbeacon.base.util.b.d().equals(com.tencent.tmsbeacon.a.d.a.a().getString("LAUEVE_DENGTA", ""))) {
                com.tencent.tmsbeacon.base.util.c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new Object[0]);
                return;
            }
        }
        e l = e.l();
        f e = f.e();
        HashMap hashMap = new HashMap();
        hashMap.put("A19", l.q());
        hashMap.put("A63", "Y");
        hashMap.put("A21", com.tencent.tmsbeacon.a.c.b.g() ? "Y" : "N");
        hashMap.put("A45", com.tencent.tmsbeacon.a.c.b.d(this.f25904a) ? "Y" : "N");
        hashMap.put("A66", com.tencent.tmsbeacon.a.c.b.e(this.f25904a) ? "F" : "B");
        hashMap.put("A68", "" + com.tencent.tmsbeacon.a.c.b.b(this.f25904a));
        hashMap.put("A85", com.tencent.tmsbeacon.a.c.b.d ? "Y" : "N");
        hashMap.put("A9", Build.BRAND);
        hashMap.put("A14", l.w());
        hashMap.put("A20", e.j());
        hashMap.put("A69", e.k());
        if (a(hashMap)) {
            a.SharedPreferences$EditorC0861a edit = com.tencent.tmsbeacon.a.d.a.a().edit();
            if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("LAUEVE_DENGTA", com.tencent.tmsbeacon.base.util.b.d());
            }
        }
    }

    public void a() {
    }

    @Override // com.tencent.tmsbeacon.module.BeaconModule
    public void a(Context context) {
        this.f25904a = context;
        if (!com.tencent.tmsbeacon.a.c.b.f(context)) {
            com.tencent.tmsbeacon.base.util.c.a("non-main process. do not report rqd event", new Object[0]);
            return;
        }
        com.tencent.tmsbeacon.d.b b2 = ((StrategyModule) BeaconModule.f25901a.get(ModuleName.STRATEGY)).b();
        this.d = b2;
        this.f25905c = b2.f();
        ((Application) this.f25904a).registerActivityLifecycleCallbacks(new com.tencent.tmsbeacon.c.a.c(this));
        com.tencent.tmsbeacon.a.a.b.a().a(2, this);
        com.tencent.tmsbeacon.a.a.b.a().a(10, this);
    }

    public void a(String str, long j, long j2) {
        com.tencent.tmsbeacon.a.b.a.a().a(new b(j2, str, j));
    }

    public boolean a(Map<String, String> map) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_applaunched").withParams(map).withType(EventType.REALTIME).build()).isSuccess();
    }

    public void b() {
    }

    public void b(String str, long j, long j2) {
        com.tencent.tmsbeacon.a.b.a.a().a(new c(j2, str, j));
    }

    public boolean b(Map<String, String> map) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withParams(map).withCode("rqd_heartbeat").withType(EventType.REALTIME).build()).isSuccess();
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        int i = cVar.f25769a;
        if (i == 2) {
            Map map = (Map) cVar.b.get("d_m");
            if (map != null) {
                this.b = com.tencent.tmsbeacon.base.util.b.a((String) map.get("modelEventUsable"), this.b);
                this.f25905c = com.tencent.tmsbeacon.base.util.b.a((String) map.get("isPagePath"), this.f25905c);
            }
        } else if (i != 10) {
        } else {
            e();
            if (com.tencent.tmsbeacon.a.c.b.f(this.f25904a)) {
                new com.tencent.tmsbeacon.c.c(this.f25904a).a(this.d);
            }
            if (this.b) {
                d();
            }
            if (this.f25905c) {
                c();
            }
        }
    }
}
