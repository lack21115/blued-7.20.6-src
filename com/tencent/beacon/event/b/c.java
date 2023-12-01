package com.tencent.beacon.event.b;

import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.BeaconEvent;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/b/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private c f35040a;

    abstract BeaconEvent a(BeaconEvent beaconEvent);

    public void a(c cVar) {
        this.f35040a = cVar;
    }

    public final EventBean b(BeaconEvent beaconEvent) {
        BeaconEvent a2 = a(beaconEvent);
        c cVar = this.f35040a;
        return cVar != null ? cVar.b(a2) : com.tencent.beacon.event.c.a.a(a2);
    }
}
