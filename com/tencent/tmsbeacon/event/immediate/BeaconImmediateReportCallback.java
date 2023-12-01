package com.tencent.tmsbeacon.event.immediate;

import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.call.f;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.event.EventBean;
import com.tencent.tmsbeacon.event.d;
import com.tencent.tmsbeacon.pack.ResponsePackageV2;
import com.tencent.tmsbeacon.pack.a;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/immediate/BeaconImmediateReportCallback.class */
public class BeaconImmediateReportCallback implements f<BeaconTransferResult> {

    /* renamed from: a  reason: collision with root package name */
    private d f25884a;
    private EventBean b;

    /* renamed from: c  reason: collision with root package name */
    private String f25885c;
    private long d = new Date().getTime();

    public BeaconImmediateReportCallback(d dVar, EventBean eventBean, String str) {
        this.f25884a = dVar;
        this.b = eventBean;
        this.f25885c = str;
    }

    private void a(com.tencent.tmsbeacon.base.net.d dVar) {
        c.a("[BeaconImmediateReportCallback]", dVar.toString(), new Object[0]);
        com.tencent.tmsbeacon.a.b.d.b().a(dVar.b, dVar.d, dVar.e);
        this.f25884a.a(this.b, this.f25885c);
    }

    public void onResponse(BeaconTransferResult beaconTransferResult) {
        if (beaconTransferResult == null) {
            a(new com.tencent.tmsbeacon.base.net.d(RequestType.LONG_CONNECTION.name(), "462", -1, "response fail! result is null"));
            return;
        }
        boolean z = beaconTransferResult.getCode() == 0 && beaconTransferResult.getBizCode() == 0;
        c.a("[BeaconImmediateReportCallback]", "result=%s, eventName=%s , logID=%s", beaconTransferResult.toString(), this.b.getEventCode(), this.f25885c);
        if (!z) {
            a(new com.tencent.tmsbeacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), c.c("response fail! result = %s", beaconTransferResult.toString())));
            return;
        }
        byte[] bizBuffer = beaconTransferResult.getBizBuffer();
        ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
        try {
            responsePackageV2.readFrom(new a(bizBuffer));
            com.tencent.tmsbeacon.base.net.b.d.a(this.d, responsePackageV2.serverTime, responsePackageV2.srcGatewayIp);
        } catch (Throwable th) {
            c.a(th);
            a(new com.tencent.tmsbeacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), th.getMessage(), th));
        }
    }
}
