package com.tencent.beacon.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.e.b;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/module/StatModule.class */
public class StatModule implements d, BeaconModule {

    /* renamed from: a  reason: collision with root package name */
    private Context f35084a;
    private b d;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35085c = true;
    private long e = 0;

    /* renamed from: com.tencent.beacon.module.StatModule$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/module/StatModule$4.class */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f35091a;

        @Override // java.lang.Runnable
        public void run() {
            BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_sensor").withParams(this.f35091a).build());
        }
    }

    private void c() {
        ((Application) this.f35084a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.d(this));
    }

    private void d() {
        if (this.d.l()) {
            a a2 = a.a();
            if (com.tencent.beacon.base.util.b.d().equals(a2.getString("rqd_model", ""))) {
                return;
            }
            com.tencent.beacon.a.b.a.a().a(50000L, new Runnable() { // from class: com.tencent.beacon.module.StatModule.1
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
            });
            a.SharedPreferences$EditorC0895a edit = a2.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("rqd_model", com.tencent.beacon.base.util.b.d());
            }
        }
    }

    private void e() {
        if (this.d.l()) {
            if (this.d.i()) {
                if (com.tencent.beacon.base.util.b.d().equals(a.a().getString("LAUEVE_DENGTA", ""))) {
                    c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new Object[0]);
                    return;
                }
            }
            e l = e.l();
            HashMap hashMap = new HashMap();
            hashMap.put("A19", l.q());
            hashMap.put("A63", "Y");
            hashMap.put("A21", com.tencent.beacon.a.c.b.g() ? "Y" : "N");
            hashMap.put("A45", com.tencent.beacon.a.c.b.e(this.f35084a) ? "Y" : "N");
            hashMap.put("A66", com.tencent.beacon.a.c.b.f(this.f35084a) ? "F" : "B");
            hashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.f35084a));
            hashMap.put("A85", com.tencent.beacon.a.c.b.d ? "Y" : "N");
            hashMap.put("A9", Build.BRAND);
            hashMap.put("A14", l.w());
            f e = f.e();
            hashMap.put("A20", e.j());
            hashMap.put("A69", e.k());
            if (b(hashMap)) {
                a.SharedPreferences$EditorC0895a edit = a.a().edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("LAUEVE_DENGTA", com.tencent.beacon.base.util.b.d());
                }
            }
        }
    }

    public void a() {
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        this.f35084a = context;
        if (!com.tencent.beacon.a.c.b.g(context)) {
            c.a("non-main process. do not report rqd event", new Object[0]);
            return;
        }
        b b = ((StrategyModule) BeaconModule.f35077a.get(ModuleName.STRATEGY)).b();
        this.d = b;
        this.f35085c = b.j();
        ((Application) this.f35084a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.c(this));
        com.tencent.beacon.a.a.b.a().a(2, this);
        com.tencent.beacon.a.a.b.a().a(10, this);
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        int i = cVar.f34920a;
        if (i == 2) {
            Map map = (Map) cVar.b.get("d_m");
            if (map != null) {
                this.b = com.tencent.beacon.base.util.b.a((String) map.get("modelEventUsable"), this.b);
                this.f35085c = com.tencent.beacon.base.util.b.a((String) map.get("isPagePath"), this.f35085c);
            }
        } else if (i != 10) {
        } else {
            e();
            if (com.tencent.beacon.a.c.b.g(this.f35084a)) {
                new com.tencent.beacon.d.c(this.f35084a).a(this.d);
            }
            if (this.b) {
                d();
            }
            if (this.f35085c) {
                c();
            }
        }
    }

    public void a(final String str, final long j, final long j2) {
        if (this.d.l()) {
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.StatModule.2
                @Override // java.lang.Runnable
                public void run() {
                    BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(j2)).withParams("A111", str).withParams("A112", String.valueOf(j)).withCode("rqd_page_fgt").withType(EventType.REALTIME).build());
                }
            });
        }
    }

    public void a(final Map<String, String> map) {
        if (this.d.l()) {
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.StatModule.5
                @Override // java.lang.Runnable
                public void run() {
                    BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_appresumed").withIsSucceed(true).withParams(map).withType(EventType.REALTIME).build());
                }
            });
        }
    }

    public void b() {
    }

    public void b(final String str, final long j, final long j2) {
        if (this.d.l()) {
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.StatModule.3
                @Override // java.lang.Runnable
                public void run() {
                    BeaconReport.getInstance().report(BeaconEvent.builder().withParams("A110", String.valueOf(j2)).withParams("A111", str).withParams("A112", String.valueOf(j)).withCode("rqd_page").withType(EventType.NORMAL).build());
                    StatModule.this.e += j;
                    if (StatModule.this.e >= 15000) {
                        StatModule.this.e = 0L;
                    }
                }
            });
        }
    }

    public boolean b(Map<String, String> map) {
        if (this.d.l()) {
            return BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_applaunched").withParams(map).withType(EventType.REALTIME).build()).isSuccess();
        }
        return true;
    }

    public boolean c(Map<String, String> map) {
        if (this.d.l()) {
            return BeaconReport.getInstance().report(BeaconEvent.builder().withParams(map).withCode("rqd_heartbeat").withType(EventType.REALTIME).build()).isSuccess();
        }
        return true;
    }
}
