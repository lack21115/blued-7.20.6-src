package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/rtt/RttResponse.class */
public final class RttResponse extends MapJceStruct implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f37268c;
    public static final /* synthetic */ boolean d = !RttResponse.class.desiredAssertionStatus();
    public byte[] result;

    static {
        f37268c = r0;
        byte[] bArr = {0};
    }

    public RttResponse() {
        this.result = null;
    }

    public RttResponse(byte[] bArr) {
        this.result = null;
        this.result = bArr;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "navsns.RttResponse";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void display(StringBuilder sb, int i) {
        new k(sb, i).a(this.result, "result");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        new k(sb, i).a(this.result, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return q.a((Object) this.result, (Object) ((RttResponse) obj).result);
    }

    public byte[] getResult() {
        return this.result;
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
        this.result = mVar.a(f37268c, 0, true);
    }

    public void setResult(byte[] bArr) {
        this.result = bArr;
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.result, 0);
    }
}
