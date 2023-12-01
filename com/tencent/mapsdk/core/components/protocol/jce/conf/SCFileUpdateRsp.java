package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/conf/SCFileUpdateRsp.class */
public final class SCFileUpdateRsp extends MapJceStruct {

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<FileUpdateRsp> f23575c = new ArrayList<>();
    public int iRet;
    public ArrayList<FileUpdateRsp> vItems;

    static {
        f23575c.add(new FileUpdateRsp());
    }

    public SCFileUpdateRsp() {
        this.iRet = 0;
        this.vItems = null;
    }

    public SCFileUpdateRsp(int i, ArrayList<FileUpdateRsp> arrayList) {
        this.iRet = 0;
        this.vItems = null;
        this.iRet = i;
        this.vItems = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "MapConfProtocol.SCFileUpdateRsp";
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.iRet = mVar.a(this.iRet, 0, true);
        this.vItems = (ArrayList) mVar.a((m) f23575c, 1, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SCFileUpdateRsp{");
        stringBuffer.append("iRet=");
        stringBuffer.append(this.iRet);
        stringBuffer.append(", vItems=");
        stringBuffer.append(this.vItems);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.iRet, 0);
        ArrayList<FileUpdateRsp> arrayList = this.vItems;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 1);
        }
    }
}
