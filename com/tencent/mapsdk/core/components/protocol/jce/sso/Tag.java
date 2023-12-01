package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/sso/Tag.class */
public final class Tag extends MapJceStruct implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f37272c;
    public static final /* synthetic */ boolean d = !Tag.class.desiredAssertionStatus();
    public String strId;
    public byte[] value;

    public Tag() {
        this.strId = "";
        this.value = null;
    }

    public Tag(String str, byte[] bArr) {
        this.strId = "";
        this.value = null;
        this.strId = str;
        this.value = bArr;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "sosomap.Tag";
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
        k kVar = new k(sb, i);
        kVar.a(this.strId, "strId");
        kVar.a(this.value, "value");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.strId, true);
        kVar.a(this.value, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Tag tag = (Tag) obj;
        boolean z = false;
        if (q.a((Object) this.strId, (Object) tag.strId)) {
            z = false;
            if (q.a((Object) this.value, (Object) tag.value)) {
                z = true;
            }
        }
        return z;
    }

    public byte[] getValue() {
        return this.value;
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
        this.strId = mVar.b(0, true);
        if (f37272c == null) {
            f37272c = r0;
            byte[] bArr = {0};
        }
        this.value = mVar.a(f37272c, 1, true);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.strId, 0);
        nVar.a(this.value, 1);
    }
}
