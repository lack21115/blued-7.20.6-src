package com.tencent.beacon.event;

import com.opos.acs.st.utils.ErrorContants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventBean f35032a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar, EventBean eventBean) {
        this.b = dVar;
        this.f35032a = eventBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.event.a.a aVar;
        com.tencent.beacon.event.a.a aVar2;
        aVar = this.b.b;
        if (!aVar.a(this.f35032a.getEventType())) {
            aVar2 = this.b.b;
            boolean a2 = aVar2.a(this.f35032a);
            com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB %s", this.f35032a.getEventCode(), Boolean.valueOf(a2));
            if (a2) {
                this.b.b();
                return;
            }
            return;
        }
        com.tencent.beacon.a.b.g e = com.tencent.beacon.a.b.g.e();
        e.a(ErrorContants.PERIODIC_REPORT_ERROR, "type: " + com.tencent.beacon.event.c.d.a(this.f35032a.getEventType()) + " max db count!");
        com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", this.f35032a.getEventCode());
    }
}
