package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Response.class */
public final class Response extends MapJceStruct {

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<Detail> f37274c = new ArrayList<>();
    public ArrayList<Detail> detail;
    public short error;
    public String msg;

    static {
        f37274c.add(new Detail());
    }

    public Response() {
        this.error = (short) 0;
        this.msg = "";
        this.detail = null;
    }

    public Response(short s, String str, ArrayList<Detail> arrayList) {
        this.error = (short) 0;
        this.msg = "";
        this.detail = null;
        this.error = s;
        this.msg = str;
        this.detail = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.error = mVar.a(this.error, 0, true);
        this.msg = mVar.b(1, false);
        this.detail = (ArrayList) mVar.a((m) f37274c, 2, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.error, 0);
        String str = this.msg;
        if (str != null) {
            nVar.a(str, 1);
        }
        ArrayList<Detail> arrayList = this.detail;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 2);
        }
    }
}
