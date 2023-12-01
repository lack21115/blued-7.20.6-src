package com.tencent.mapsdk.internal;

import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import com.tencent.tmsbeacon.event.open.EventType;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nj.class */
public class nj implements Runnable {
    public final /* synthetic */ Map b;

    @Override // java.lang.Runnable
    public void run() {
        BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_appresumed").withIsSucceed(true).withParams(this.b).withType(EventType.REALTIME).build());
    }
}
