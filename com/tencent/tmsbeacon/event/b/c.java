package com.tencent.tmsbeacon.event.b;

import com.tencent.tmsbeacon.event.EventBean;
import com.tencent.tmsbeacon.event.open.BeaconEvent;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/b/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private c f25870a;

    public abstract BeaconEvent a(BeaconEvent beaconEvent);

    public void a(c cVar) {
        this.f25870a = cVar;
    }

    public final EventBean b(BeaconEvent beaconEvent) {
        BeaconEvent a2 = a(beaconEvent);
        c cVar = this.f25870a;
        return cVar != null ? cVar.b(a2) : com.tencent.tmsbeacon.event.c.a.a(a2);
    }
}
