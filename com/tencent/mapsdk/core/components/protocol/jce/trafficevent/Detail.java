package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.p;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Detail.class */
public final class Detail extends MapJceStruct {

    /* renamed from: c  reason: collision with root package name */
    public static Basic f37273c = new Basic();
    public static ArrayList<Float> d = new ArrayList<>();
    public Basic basic;
    public ArrayList<Float> coord;

    static {
        d.add(Float.valueOf(0.0f));
    }

    public Detail() {
        this.basic = null;
        this.coord = null;
    }

    public Detail(Basic basic, ArrayList<Float> arrayList) {
        this.basic = null;
        this.coord = null;
        this.basic = basic;
        this.coord = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.basic = (Basic) mVar.b((p) f37273c, 0, true);
        this.coord = (ArrayList) mVar.a((m) d, 1, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a((p) this.basic, 0);
        ArrayList<Float> arrayList = this.coord;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 1);
        }
    }
}
