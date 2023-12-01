package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.pack.AbstractResponseCommon;
import com.tencent.beacon.pack.ResponsePackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/i.class */
public class i implements Callback<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callback f34990a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar, Callback callback) {
        this.b = jVar;
        this.f34990a = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) throws NetException {
        JceRequestEntity jceRequestEntity;
        AbstractResponseCommon a2;
        JceRequestEntity jceRequestEntity2;
        byte[] bArr2;
        long j;
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "raw response size: " + bArr.length, new Object[0]);
        jceRequestEntity = this.b.f34991a;
        if (jceRequestEntity.getType() == RequestType.EVENT) {
            a2 = com.tencent.beacon.base.net.c.c().e.b().a(bArr);
            if (a2 == null) {
                throw new NetException("ResponsePackageV2 == null");
            }
            bArr2 = null;
        } else {
            a2 = com.tencent.beacon.base.net.c.c().d.b().a(bArr);
            if (a2 == null) {
                throw new NetException("responsePackage == null");
            }
            ResponsePackage responsePackage = (ResponsePackage) a2;
            int i = responsePackage.cmd;
            jceRequestEntity2 = this.b.f34991a;
            if (i != jceRequestEntity2.getResponseCmd()) {
                throw new NetException("responsePackage.cmd != requestEntity.responseCmd");
            }
            if (responsePackage.result != 0) {
                throw new NetException("responsePackage.result != OK(0)");
            }
            bArr2 = responsePackage.sBuffer;
            if (bArr2 == null || bArr2.length <= 0) {
                throw new NetException("responsePackage.buffer == null");
            }
        }
        j = this.b.b;
        com.tencent.beacon.base.net.b.d.a(j, a2.serverTime, a2.srcGatewayIp);
        Callback callback = this.f34990a;
        if (callback != null) {
            callback.onResponse(bArr2);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        Callback callback = this.f34990a;
        if (callback != null) {
            callback.onFailure(dVar);
        }
    }
}
