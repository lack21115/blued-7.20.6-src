package com.tencent.beacon.event.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.event.c.g;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/b/b.class */
public class b extends c implements d {
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f35039c;

    public b() {
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    private boolean c(BeaconEvent beaconEvent) {
        return beaconEvent.getType() == EventType.IMMEDIATE_WNS || beaconEvent.getType() == EventType.IMMEDIATE_MSF;
    }

    @Override // com.tencent.beacon.event.b.c
    BeaconEvent a(BeaconEvent beaconEvent) {
        if (!this.b || com.tencent.beacon.base.util.b.a(beaconEvent.getCode())) {
            com.tencent.beacon.a.c.c d = com.tencent.beacon.a.c.c.d();
            Context c2 = d.c();
            Map<String, String> params = beaconEvent.getParams();
            params.put("A3", j.c());
            params.put("A153", j.d());
            params.put("A157", j.f());
            params.put("A143", com.tencent.beacon.a.c.c.d().g());
            params.put("A144", f.e().i());
            params.put("A19", e.l().q());
            params.put("QQ", com.tencent.beacon.a.c.b.c());
            params.put("A95", "" + com.tencent.beacon.a.c.b.a());
            params.put("A141", j.g());
            params.put("A23", d.a());
            params.put("A48", com.tencent.beacon.a.c.c.d().e());
            String appKey = beaconEvent.getAppKey();
            EventModule eventModule = (EventModule) d.a(ModuleName.EVENT);
            params.put("A1", eventModule.c(appKey));
            params.put("A8", eventModule.b(appKey));
            params.put("A99", beaconEvent.getLogidPrefix());
            params.put("A72", d.j());
            params.put("A159", e.l().D());
            params.put("A34", String.valueOf(com.tencent.beacon.base.util.b.c()));
            params.put("A156", c(beaconEvent) ? "Y" : "N");
            if (!params.containsKey("A88")) {
                if (TextUtils.isEmpty(this.f35039c)) {
                    this.f35039c = com.tencent.beacon.a.c.b.a(c2);
                }
                params.put("A88", this.f35039c);
            }
            params.put("A100", g.a(c2, appKey).a(beaconEvent.getCode(), beaconEvent.getType()));
            Map<String, String> a2 = eventModule.a(appKey);
            if (a2 != null) {
                params.putAll(a2);
            }
            beaconEvent.setParams(params);
            return beaconEvent;
        }
        return beaconEvent;
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        HashMap hashMap;
        if (cVar.f34920a == 2 && (hashMap = (HashMap) cVar.b.get("d_m")) != null) {
            this.b = com.tencent.beacon.base.util.b.a((String) hashMap.get("tidyEF"), this.b);
        }
    }
}
