package com.tencent.mapsdk.internal;

import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mj.class */
public class mj implements Runnable {
    public final /* synthetic */ Map b;

    @Override // java.lang.Runnable
    public void run() {
        BeaconReport.getInstance().report(BeaconEvent.builder().withCode("rqd_sensor").withParams(this.b).build());
    }
}
