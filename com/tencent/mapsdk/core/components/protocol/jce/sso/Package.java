package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/sso/Package.class */
public final class Package extends MapJceStruct implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static int f23580c;
    public static byte[] d;
    public static byte[] e;
    public static ArrayList<Tag> f;
    public static final /* synthetic */ boolean g = !Package.class.desiredAssertionStatus();
    public byte[] busiBuff;
    public byte cEncodeType;
    public int eCmd;
    public byte[] head;
    public int iSeqNo;
    public String sAppId;
    public short shVer;
    public String strSubCmd;
    public String uin;
    public ArrayList<Tag> vTag;

    public Package() {
        this.shVer = (short) 0;
        this.eCmd = 0;
        this.strSubCmd = "";
        this.iSeqNo = 0;
        this.cEncodeType = (byte) 0;
        this.sAppId = "";
        this.uin = "";
        this.head = null;
        this.busiBuff = null;
        this.vTag = null;
    }

    public Package(short s, int i, String str, int i2, byte b, String str2, String str3, byte[] bArr, byte[] bArr2, ArrayList<Tag> arrayList) {
        this.shVer = (short) 0;
        this.eCmd = 0;
        this.strSubCmd = "";
        this.iSeqNo = 0;
        this.cEncodeType = (byte) 0;
        this.sAppId = "";
        this.uin = "";
        this.head = null;
        this.busiBuff = null;
        this.vTag = null;
        this.shVer = s;
        this.eCmd = i;
        this.strSubCmd = str;
        this.iSeqNo = i2;
        this.cEncodeType = b;
        this.sAppId = str2;
        this.uin = str3;
        this.head = bArr;
        this.busiBuff = bArr2;
        this.vTag = arrayList;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "sosomap.Package";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            if (g) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void display(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.shVer, "shVer");
        kVar.a(this.eCmd, "eCmd");
        kVar.a(this.strSubCmd, "strSubCmd");
        kVar.a(this.iSeqNo, "iSeqNo");
        kVar.a(this.cEncodeType, "cEncodeType");
        kVar.a(this.sAppId, "sAppId");
        kVar.a(this.uin, "uin");
        kVar.a(this.head, "head");
        kVar.a(this.busiBuff, "busiBuff");
        kVar.a((Collection) this.vTag, "vTag");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.shVer, true);
        kVar.a(this.eCmd, true);
        kVar.a(this.strSubCmd, true);
        kVar.a(this.iSeqNo, true);
        kVar.a(this.cEncodeType, true);
        kVar.a(this.sAppId, true);
        kVar.a(this.uin, true);
        kVar.a(this.head, true);
        kVar.a(this.busiBuff, true);
        kVar.a((Collection) this.vTag, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Package r0 = (Package) obj;
        boolean z = false;
        if (q.b(this.shVer, r0.shVer)) {
            z = false;
            if (q.b(this.eCmd, r0.eCmd)) {
                z = false;
                if (q.a((Object) this.strSubCmd, (Object) r0.strSubCmd)) {
                    z = false;
                    if (q.b(this.iSeqNo, r0.iSeqNo)) {
                        z = false;
                        if (q.b(this.cEncodeType, r0.cEncodeType)) {
                            z = false;
                            if (q.a((Object) this.sAppId, (Object) r0.sAppId)) {
                                z = false;
                                if (q.a((Object) this.uin, (Object) r0.uin)) {
                                    z = false;
                                    if (q.a((Object) this.head, (Object) r0.head)) {
                                        z = false;
                                        if (q.a((Object) this.busiBuff, (Object) r0.busiBuff)) {
                                            z = false;
                                            if (q.a((Object) this.vTag, (Object) r0.vTag)) {
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public byte[] getBusiBuff() {
        return this.busiBuff;
    }

    public byte[] getHead() {
        return this.head;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.shVer = mVar.a(this.shVer, 0, true);
        this.eCmd = mVar.a(this.eCmd, 1, true);
        this.strSubCmd = mVar.b(2, true);
        this.iSeqNo = mVar.a(this.iSeqNo, 3, false);
        this.cEncodeType = mVar.a(this.cEncodeType, 4, false);
        this.sAppId = mVar.b(5, false);
        this.uin = mVar.b(6, false);
        if (d == null) {
            d = r0;
            byte[] bArr = {0};
        }
        this.head = mVar.a(d, 7, false);
        if (e == null) {
            e = r0;
            byte[] bArr2 = {0};
        }
        this.busiBuff = mVar.a(e, 8, false);
        if (f == null) {
            f = new ArrayList<>();
            f.add(new Tag());
        }
        this.vTag = (ArrayList) mVar.a((m) f, 9, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.shVer, 0);
        nVar.a(this.eCmd, 1);
        nVar.a(this.strSubCmd, 2);
        nVar.a(this.iSeqNo, 3);
        nVar.a(this.cEncodeType, 4);
        String str = this.sAppId;
        if (str != null) {
            nVar.a(str, 5);
        }
        String str2 = this.uin;
        if (str2 != null) {
            nVar.a(str2, 6);
        }
        byte[] bArr = this.head;
        if (bArr != null) {
            nVar.a(bArr, 7);
        }
        byte[] bArr2 = this.busiBuff;
        if (bArr2 != null) {
            nVar.a(bArr2, 8);
        }
        ArrayList<Tag> arrayList = this.vTag;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 9);
        }
    }
}
