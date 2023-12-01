package com.tencent.tmsbeacon.module;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.a.d;
import com.tencent.tmsbeacon.base.net.b.e;
import com.tencent.tmsbeacon.event.EventBean;
import com.tencent.tmsbeacon.event.b.a;
import com.tencent.tmsbeacon.event.b.b;
import com.tencent.tmsbeacon.event.b.c;
import com.tencent.tmsbeacon.event.h;
import com.tencent.tmsbeacon.event.immediate.IBeaconImmediateReport;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import com.tencent.tmsbeacon.event.open.EventResult;
import com.tencent.tmsbeacon.qimei.Qimei;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/EventModule.class */
public class EventModule implements d, e.a, BeaconModule {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Map<String, String>> f39593a = new ConcurrentHashMap(3);
    private static final Map<String, String> b = new ConcurrentHashMap(3);

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f39594c = new ArrayList(3);
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicBoolean e = new AtomicBoolean(false);
    private boolean f = true;
    private StrategyModule g;
    private h h;
    private volatile boolean i;

    private String c(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = com.tencent.tmsbeacon.a.c.c.d().f();
        }
        return str2;
    }

    private void e() {
        this.f39594c.add(new b());
        this.f39594c.add(new a());
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f39594c.size()) {
                return;
            }
            this.f39594c.get(i2 - 1).a(this.f39594c.get(i2));
            i = i2 + 1;
        }
    }

    private void f() {
        com.tencent.tmsbeacon.a.a.b.a().a(7, this);
        if (this.f) {
            com.tencent.tmsbeacon.event.d dVar = new com.tencent.tmsbeacon.event.d();
            this.h = dVar;
            dVar.a();
        }
    }

    private void g() {
        com.tencent.tmsbeacon.a.a.b.a().a(3, this);
        com.tencent.tmsbeacon.a.a.b.a().a(4, this);
        com.tencent.tmsbeacon.a.a.b.a().a(6, this);
        com.tencent.tmsbeacon.a.a.b.a().a(1, this);
    }

    public EventResult a(BeaconEvent beaconEvent) {
        StrategyModule strategyModule;
        com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 0, "event: %s. go in EventModule", beaconEvent.getCode());
        if (!this.f) {
            com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 1, "event: %s. EventModule is not enable", beaconEvent.getCode());
            return EventResult.a.a(102);
        }
        com.tencent.tmsbeacon.base.util.e.a(beaconEvent.getParams());
        StrategyModule strategyModule2 = this.g;
        if (strategyModule2 != null && strategyModule2.b().a(beaconEvent.getCode())) {
            com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 1, "event: %s.  is not allowed in strategy (false)", beaconEvent.getCode());
            return EventResult.a.a(100);
        } else if (beaconEvent.isSucceed() && (strategyModule = this.g) != null && !strategyModule.b().b(beaconEvent.getCode())) {
            com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 1, "event: %s. is sampled by svr rate (false)", beaconEvent.getCode());
            return EventResult.a.a(101);
        } else {
            beaconEvent.setAppKey(c(beaconEvent.getAppKey()));
            EventBean b2 = this.f39594c.get(0).b(beaconEvent);
            if (b2 == null) {
                return EventResult.a.a(105);
            }
            Qimei b3 = com.tencent.tmsbeacon.qimei.a.a().b();
            if (b3 == null || b3.isEmpty()) {
                if (this.d.addAndGet(1) > 64) {
                    String format = String.format("qimei empty cache count over max , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                    com.tencent.tmsbeacon.base.util.c.a(format, new Object[0]);
                    if (this.e.compareAndSet(false, true)) {
                        com.tencent.tmsbeacon.a.b.d.b().a("510", format);
                    }
                } else {
                    com.tencent.tmsbeacon.base.util.c.a("qimei empty and add to cache , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                    BeaconEvent build = BeaconEvent.newBuilder(beaconEvent).build();
                    HashMap hashMap = new HashMap();
                    hashMap.put("e_q_e_k", build);
                    com.tencent.tmsbeacon.a.a.b.a().a(new com.tencent.tmsbeacon.a.a.c(12, hashMap));
                }
            }
            int eventType = b2.getEventType();
            if (eventType == 2 || eventType == 3) {
                IBeaconImmediateReport immediateReport = BeaconReport.getInstance().getImmediateReport();
                com.tencent.tmsbeacon.base.util.e.a("immediateReport", immediateReport);
                if (immediateReport != null) {
                    return this.h.a(beaconEvent.getParams().get("A100"), b2);
                }
                com.tencent.tmsbeacon.base.util.c.a("immediateReport is null!", new Object[0]);
                com.tencent.tmsbeacon.a.b.d.b().a("515", "immediateReport is null!");
            }
            return this.h.b(beaconEvent.getParams().get("A100"), b2);
        }
    }

    public Map<String, String> a(String str) {
        return f39593a.get(c(str));
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void a() {
        this.h.b();
    }

    @Override // com.tencent.tmsbeacon.module.BeaconModule
    public void a(Context context) {
        this.g = (StrategyModule) BeaconModule.f39592a.get(ModuleName.STRATEGY);
        e();
        f();
        g();
        e.a(context, this);
        this.i = true;
    }

    public void a(String str, String str2) {
        b.put(c(str), com.tencent.tmsbeacon.event.c.d.d(str2));
    }

    public void a(String str, Map<String, String> map) {
        if (map == null || map.isEmpty() || map.size() >= 50) {
            com.tencent.tmsbeacon.base.util.c.a("setAdditionalParams error , params.size: %s", Integer.valueOf(map == null ? 0 : map.size()));
            return;
        }
        String c2 = c(str);
        Map<String, Map<String, String>> map2 = f39593a;
        Map<String, String> map3 = map2.get(c2);
        if (map3 == null) {
            map2.put(c2, new HashMap(map));
        } else if (map3.size() + map.size() >= 50) {
            com.tencent.tmsbeacon.base.util.c.a("setAdditionalParams error , params.size: can not more than 50", new Object[0]);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map3);
            hashMap.putAll(map);
            map2.put(c2, hashMap);
        }
    }

    public void a(boolean z) {
        h hVar = this.h;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    public String b(String str) {
        String str2;
        String c2 = c(str);
        return (TextUtils.isEmpty(c2) || (str2 = b.get(c2)) == null) ? "10000" : str2;
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void b() {
        this.h.c();
    }

    public void b(boolean z) {
        this.f = z;
    }

    public h c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        int i = cVar.f39460a;
        if (i == 1) {
            com.tencent.tmsbeacon.a.a.b.a().a(12, this);
        } else if (i == 12) {
            Object obj = cVar.b.get("e_q_e_k");
            if (obj instanceof BeaconEvent) {
                BeaconEvent beaconEvent = (BeaconEvent) obj;
                beaconEvent.getParams().put("A93", "Y");
                com.tencent.tmsbeacon.base.util.c.a("qimei empty cache report , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                a(beaconEvent);
            }
        } else if (i == 3) {
            a((String) cVar.b.get("i_c_ak"), (HashMap) cVar.b.get("i_c_ad"));
        } else if (i == 4) {
            a((String) cVar.b.get("i_c_ak"), (String) cVar.b.get("i_c_u_i"));
        } else if (i != 6) {
            if (i != 7) {
                return;
            }
            this.f = ((Boolean) cVar.b.get("s_e_e")).booleanValue();
        } else {
            Object obj2 = cVar.b.get("b_e");
            if (obj2 instanceof BeaconEvent) {
                a((BeaconEvent) obj2);
            }
        }
    }
}
