package com.tencent.beacon.event.c;

import android.text.TextUtils;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.BeaconEvent;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c/a.class */
public final class a {
    public static EventBean a(BeaconEvent beaconEvent) {
        Map<String, String> a2 = com.tencent.beacon.base.net.b.d.a(beaconEvent.getCode(), beaconEvent.getParams());
        if (a2 == null) {
            return null;
        }
        EventBean eventBean = new EventBean();
        String code = beaconEvent.getCode();
        eventBean.setEventCode(code);
        eventBean.setAppKey(beaconEvent.getAppKey());
        eventBean.setApn(com.tencent.beacon.base.net.b.d.c());
        eventBean.setSrcIp(com.tencent.beacon.a.c.c.d().b());
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
