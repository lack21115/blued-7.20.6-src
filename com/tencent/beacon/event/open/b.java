package com.tencent.beacon.event.open;

import com.opos.acs.st.utils.ErrorContants;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.base.util.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BeaconConfig f21383a;
    final /* synthetic */ BeaconReport b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeaconReport beaconReport, BeaconConfig beaconConfig) {
        this.b = beaconReport;
        this.f21383a = beaconConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            j.a();
            j.h();
            this.b.a(this.f21383a);
            this.b.a();
            c.a("BeaconReport", "App: %s start success!", com.tencent.beacon.a.c.c.d().f());
        } catch (Throwable th) {
            g e = g.e();
            e.a(ErrorContants.REALTIME_LOADAD_ERROR, "sdk init error! package name: " + com.tencent.beacon.a.c.b.b() + " , msg:" + th.getMessage(), th);
            StringBuilder sb = new StringBuilder();
            sb.append("BeaconReport init error: ");
            sb.append(th.getMessage());
            c.b(sb.toString(), new Object[0]);
            c.a(th);
        }
    }
}
