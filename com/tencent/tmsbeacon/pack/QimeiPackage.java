package com.tencent.tmsbeacon.pack;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/QimeiPackage.class */
public final class QimeiPackage extends AbstractJceStruct implements Cloneable {
    public String qimei = "";
    public String imei = "";
    public String mac = "";
    public String imsi = "";
    public String androidId = "";
    public String model = "";
    public String brand = "";
    public String osVersion = "";
    public boolean broot = false;
    public String qq = "";
    public String cid = "";

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.qimei = aVar.a(0, false);
        this.imei = aVar.a(1, false);
        this.mac = aVar.a(2, false);
        this.imsi = aVar.a(3, false);
        this.androidId = aVar.a(4, false);
        this.model = aVar.a(5, false);
        this.brand = aVar.a(6, false);
        this.osVersion = aVar.a(7, false);
        this.broot = aVar.a(this.broot, 8, false);
        this.qq = aVar.a(9, false);
        this.cid = aVar.a(10, false);
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        String str = this.qimei;
        if (str != null) {
            bVar.a(str, 0);
        }
        String str2 = this.imei;
        if (str2 != null) {
            bVar.a(str2, 1);
        }
        String str3 = this.mac;
        if (str3 != null) {
            bVar.a(str3, 2);
        }
        String str4 = this.imsi;
        if (str4 != null) {
            bVar.a(str4, 3);
        }
        String str5 = this.androidId;
        if (str5 != null) {
            bVar.a(str5, 4);
        }
        String str6 = this.model;
        if (str6 != null) {
            bVar.a(str6, 5);
        }
        String str7 = this.brand;
        if (str7 != null) {
            bVar.a(str7, 6);
        }
        String str8 = this.osVersion;
        if (str8 != null) {
            bVar.a(str8, 7);
        }
        bVar.a(this.broot, 8);
        String str9 = this.qq;
        if (str9 != null) {
            bVar.a(str9, 9);
        }
        String str10 = this.cid;
        if (str10 != null) {
            bVar.a(str10, 10);
        }
    }
}
