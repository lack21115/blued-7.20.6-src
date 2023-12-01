package com.tencent.tmsbeacon.event.b;

import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.EventType;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/b/a.class */
public class a extends c {
    @Override // com.tencent.tmsbeacon.event.b.c
    public BeaconEvent a(BeaconEvent beaconEvent) {
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
