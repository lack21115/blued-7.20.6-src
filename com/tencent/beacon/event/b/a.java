package com.tencent.beacon.event.b;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/b/a.class */
public class a extends c {
    @Override // com.tencent.beacon.event.b.c
    protected BeaconEvent a(BeaconEvent beaconEvent) {
        EventType type = beaconEvent.getType();
        if (type == EventType.DT_REALTIME || type == EventType.DT_NORMAL) {
            Map<String, String> params = beaconEvent.getParams();
            e l = e.l();
            f e = f.e();
            params.put("dt_imei2", "" + e.c());
            params.put("dt_meid", "" + e.g());
            params.put("dt_mf", "" + l.o());
            beaconEvent.setParams(params);
        }
        return beaconEvent;
    }
}
