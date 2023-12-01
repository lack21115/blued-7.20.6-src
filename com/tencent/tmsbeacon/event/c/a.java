package com.tencent.tmsbeacon.event.c;

import android.text.TextUtils;
import com.tencent.tmsbeacon.a.c.c;
import com.tencent.tmsbeacon.event.EventBean;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/a.class */
public final class a {
    public static EventBean a(BeaconEvent beaconEvent) {
        Map<String, String> a2 = d.a(beaconEvent.getCode(), beaconEvent.getParams());
        if (a2 == null) {
            return null;
        }
        EventBean eventBean = new EventBean();
        String code = beaconEvent.getCode();
        eventBean.setEventCode(code);
        eventBean.setAppKey(beaconEvent.getAppKey());
        eventBean.setApn(com.tencent.tmsbeacon.base.net.b.d.c());
        eventBean.setSrcIp(c.d().b());
        eventBean.setEventCode(code);
        eventBean.setValueType(0);
        eventBean.setEventValue(a2);
        String str = beaconEvent.getParams().get("A34");
        if (!TextUtils.isEmpty(str)) {
            eventBean.setEventTime(Long.parseLong(str));
        }
        eventBean.setEventResult(beaconEvent.isSucceed());
        eventBean.setEventType(d.a(beaconEvent.getType()));
        eventBean.setReserved("");
        return eventBean;
    }
}
