package com.tencent.beacon.event;

import com.tencent.beacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.pack.RequestPackageV2;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/b.class */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventBean f21346a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f21347c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, EventBean eventBean, String str) {
        this.f21347c = dVar;
        this.f21346a = eventBean;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeaconTransferArgs a2;
        try {
            RequestPackageV2 a3 = com.tencent.beacon.event.c.d.a(this.f21346a);
            IBeaconImmediateReport immediateReport = BeaconReport.getInstance().getImmediateReport();
            a2 = this.f21347c.a(a3.toByteArray(), this.f21346a);
            immediateReport.reportImmediate(a2, new BeaconImmediateReportCallback(this.f21347c, this.f21346a, this.b));
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.b("[immediate] report error!", new Object[0]);
            com.tencent.beacon.base.util.c.a(th);
            this.f21347c.a(this.f21346a, this.b);
            com.tencent.beacon.a.b.g.e().a("515", "immediate report error!", th);
        }
    }
}
