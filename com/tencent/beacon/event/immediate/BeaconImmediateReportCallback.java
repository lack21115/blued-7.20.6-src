package com.tencent.beacon.event.immediate;

import com.tencent.beacon.a.b.g;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.f;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.d;
import com.tencent.beacon.pack.ResponsePackageV2;
import com.tencent.beacon.pack.a;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/BeaconImmediateReportCallback.class */
public class BeaconImmediateReportCallback implements f<BeaconTransferResult> {

    /* renamed from: a  reason: collision with root package name */
    private d f35057a;
    private EventBean b;

    /* renamed from: c  reason: collision with root package name */
    private String f35058c;
    private long d = new Date().getTime();

    public BeaconImmediateReportCallback(d dVar, EventBean eventBean, String str) {
        this.f35057a = dVar;
        this.b = eventBean;
        this.f35058c = str;
    }

    private void a(com.tencent.beacon.base.net.d dVar) {
        c.a("[BeaconImmediateReportCallback]", dVar.toString(), new Object[0]);
        g.e().a(dVar.b, dVar.d, dVar.e);
        this.f35057a.a(this.b, this.f35058c);
    }

    public void onResponse(BeaconTransferResult beaconTransferResult) {
        if (beaconTransferResult == null) {
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "462", -1, "response fail! result is null"));
            return;
        }
        boolean z = beaconTransferResult.getCode() == 0 && beaconTransferResult.getBizCode() == 0;
        c.a("[BeaconImmediateReportCallback]", "result=%s, eventName=%s , logID=%s", beaconTransferResult.toString(), this.b.getEventCode(), this.f35058c);
        if (!z) {
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), c.c("response fail! result = %s", beaconTransferResult.toString())));
            return;
        }
        byte[] bizBuffer = beaconTransferResult.getBizBuffer();
        ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
        try {
            responsePackageV2.readFrom(new a(bizBuffer));
            com.tencent.beacon.base.net.b.d.a(this.d, responsePackageV2.serverTime, responsePackageV2.srcGatewayIp);
        } catch (Throwable th) {
            c.a(th);
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), th.getMessage(), th));
        }
    }
}
