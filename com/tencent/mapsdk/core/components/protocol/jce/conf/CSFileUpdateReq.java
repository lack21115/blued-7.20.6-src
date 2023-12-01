package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/conf/CSFileUpdateReq.class */
public final class CSFileUpdateReq extends MapJceStruct {

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<FileUpdateReq> f23574c = new ArrayList<>();
    public String sAppId;
    public String sCity;
    public String sEngineVersion;
    public String sId;
    public String sSDKVersion;
    public ArrayList<FileUpdateReq> vItems;

    static {
        f23574c.add(new FileUpdateReq());
    }

    public CSFileUpdateReq() {
        this.vItems = null;
        this.sAppId = "";
        this.sSDKVersion = "";
        this.sCity = "";
        this.sEngineVersion = "";
        this.sId = "";
    }

    public CSFileUpdateReq(ArrayList<FileUpdateReq> arrayList, String str, String str2, String str3, String str4, String str5) {
        this.vItems = null;
        this.sAppId = "";
        this.sSDKVersion = "";
        this.sCity = "";
        this.sEngineVersion = "";
        this.sId = "";
        this.vItems = arrayList;
        this.sAppId = str;
        this.sSDKVersion = str2;
        this.sCity = str3;
        this.sEngineVersion = str4;
        this.sId = str5;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "MapConfProtocol.CSFileUpdateReq";
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.vItems = (ArrayList) mVar.a((m) f23574c, 0, true);
        this.sAppId = mVar.b(1, false);
        this.sSDKVersion = mVar.b(2, false);
        this.sCity = mVar.b(3, false);
        this.sEngineVersion = mVar.b(4, false);
        this.sId = mVar.b(5, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CSFileUpdateReq{");
        stringBuffer.append("vItems=");
        stringBuffer.append(this.vItems);
        stringBuffer.append(", sAppId='");
        stringBuffer.append(this.sAppId);
        stringBuffer.append('\'');
        stringBuffer.append(", sSDKVersion='");
        stringBuffer.append(this.sSDKVersion);
        stringBuffer.append('\'');
        stringBuffer.append(", sCity='");
        stringBuffer.append(this.sCity);
        stringBuffer.append('\'');
        stringBuffer.append(", sEngineVersion='");
        stringBuffer.append(this.sEngineVersion);
        stringBuffer.append('\'');
        stringBuffer.append(", sId='");
        stringBuffer.append(this.sId);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a((Collection) this.vItems, 0);
        String str = this.sAppId;
        if (str != null) {
            nVar.a(str, 1);
        }
        String str2 = this.sSDKVersion;
        if (str2 != null) {
            nVar.a(str2, 2);
        }
        String str3 = this.sCity;
        if (str3 != null) {
            nVar.a(str3, 3);
        }
        String str4 = this.sEngineVersion;
        if (str4 != null) {
            nVar.a(str4, 4);
        }
        String str5 = this.sId;
        if (str5 != null) {
            nVar.a(str5, 5);
        }
    }
}
