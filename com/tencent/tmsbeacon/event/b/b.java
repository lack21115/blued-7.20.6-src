package com.tencent.tmsbeacon.event.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.a.d;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.event.c.g;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.EventType;
import com.tencent.tmsbeacon.module.EventModule;
import com.tencent.tmsbeacon.module.ModuleName;
import com.tencent.tmsbeacon.qimei.Qimei;
import com.tencent.tmsbeacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/b/b.class */
public class b extends c implements d {
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f25869c;

    public b() {
        com.tencent.tmsbeacon.a.a.b.a().a(2, this);
    }

    private boolean c(BeaconEvent beaconEvent) {
        return beaconEvent.getType() == EventType.IMMEDIATE_WNS || beaconEvent.getType() == EventType.IMMEDIATE_MSF;
    }

    @Override // com.tencent.tmsbeacon.event.b.c
    public BeaconEvent a(BeaconEvent beaconEvent) {
        if (!this.b || com.tencent.tmsbeacon.base.util.b.a(beaconEvent.getCode())) {
            com.tencent.tmsbeacon.a.c.c d = com.tencent.tmsbeacon.a.c.c.d();
            Context c2 = d.c();
            Map<String, String> params = beaconEvent.getParams();
            Qimei b = com.tencent.tmsbeacon.qimei.a.a().b();
            if (b != null && !b.isEmpty()) {
                params.putAll(b.getQimeiMap());
            }
            params.put("A143", QimeiSDK.getInstance().getOmgID());
            params.put("A144", f.e().i());
            params.put("A19", e.l().q());
            params.put("QQ", com.tencent.tmsbeacon.a.c.b.c());
            params.put("A95", "" + com.tencent.tmsbeacon.a.c.b.a());
            params.put("A141", QimeiSDK.getInstance().getBeaconIdInfo());
            params.put("A23", d.a());
            params.put("A48", com.tencent.tmsbeacon.a.c.c.d().e());
            String appKey = beaconEvent.getAppKey();
            EventModule eventModule = (EventModule) d.a(ModuleName.EVENT);
            params.put("A1", eventModule.b(appKey));
            params.put("A99", beaconEvent.getLogidPrefix());
            params.put("A72", d.i());
            params.put("A159", e.l().D());
            params.put("A34", String.valueOf(com.tencent.tmsbeacon.base.util.b.c()));
            params.put("A156", c(beaconEvent) ? "Y" : "N");
            if (!params.containsKey("A88")) {
                if (TextUtils.isEmpty(this.f25869c)) {
                    this.f25869c = com.tencent.tmsbeacon.a.c.b.a(c2);
                }
                params.put("A88", this.f25869c);
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

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        HashMap hashMap;
        if (cVar.f25769a == 2 && (hashMap = (HashMap) cVar.b.get("d_m")) != null) {
            this.b = com.tencent.tmsbeacon.base.util.b.a((String) hashMap.get("tidyEF"), this.b);
        }
    }
}
