package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/sso/CmdResult.class */
public final class CmdResult extends MapJceStruct implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f23578c = !CmdResult.class.desiredAssertionStatus();
    public int iErrCode;
    public int iSubErrCode;
    public String strErrDesc;

    public CmdResult() {
        this.iErrCode = 0;
        this.strErrDesc = "";
        this.iSubErrCode = 0;
    }

    public CmdResult(int i, String str, int i2) {
        this.iErrCode = 0;
        this.strErrDesc = "";
        this.iSubErrCode = 0;
        this.iErrCode = i;
        this.strErrDesc = str;
        this.iSubErrCode = i2;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "sosomap.CmdResult";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f23578c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void display(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.iErrCode, "iErrCode");
        kVar.a(this.strErrDesc, "strErrDesc");
        kVar.a(this.iSubErrCode, "iSubErrCode");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.iErrCode, true);
        kVar.a(this.strErrDesc, true);
        kVar.a(this.iSubErrCode, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CmdResult cmdResult = (CmdResult) obj;
        boolean z = false;
        if (q.b(this.iErrCode, cmdResult.iErrCode)) {
            z = false;
            if (q.a((Object) this.strErrDesc, (Object) cmdResult.strErrDesc)) {
                z = false;
                if (q.b(this.iSubErrCode, cmdResult.iSubErrCode)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.iErrCode = mVar.a(this.iErrCode, 0, true);
        this.strErrDesc = mVar.b(1, true);
        this.iSubErrCode = mVar.a(this.iSubErrCode, 2, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.iErrCode, 0);
        nVar.a(this.strErrDesc, 1);
        nVar.a(this.iSubErrCode, 2);
    }
}
