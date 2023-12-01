package com.tencent.beacon.pack;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/pack/ResponsePackageV2.class */
public final class ResponsePackageV2 extends AbstractResponseCommon implements Cloneable {
    public int result = 0;
    public String msg = "";

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            com.tencent.beacon.base.util.c.a(e);
            return null;
        }
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.result = aVar.a(this.result, 0, true);
        this.srcGatewayIp = aVar.a(1, true);
        this.serverTime = aVar.a(this.serverTime, 2, true);
        this.msg = aVar.a(3, true);
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.result, 0);
        bVar.a(this.srcGatewayIp, 1);
        bVar.a(this.serverTime, 2);
        bVar.a(this.msg, 3);
    }
}
