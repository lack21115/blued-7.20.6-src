package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.p;
import com.tencent.mapsdk.internal.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/sso/Header.class */
public final class Header extends MapJceStruct implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static CmdResult f37270c;
    public static final /* synthetic */ boolean d = !Header.class.desiredAssertionStatus();
    public long lCurrTime;
    public CmdResult stResult;
    public String strChannel;
    public String strFr;
    public String strImei;
    public String strImsi;
    public String strLC;
    public String strMachineModel;
    public String strMobver;
    public String strNettp;
    public String strOfflineVersion;
    public String strOsVersion;
    public String strPf;
    public String strSessionId;
    public String strSoftVersion;
    public String strToken;
    public String strUserNetType;
    public long uAccIp;

    public Header() {
        this.lCurrTime = 0L;
        this.stResult = null;
        this.uAccIp = 0L;
        this.strSessionId = "";
        this.strLC = "";
        this.strToken = "";
        this.strFr = "";
        this.strPf = "";
        this.strImei = "";
        this.strMobver = "";
        this.strNettp = "";
        this.strImsi = "";
        this.strOsVersion = "";
        this.strSoftVersion = "";
        this.strOfflineVersion = "";
        this.strChannel = "";
        this.strMachineModel = "";
        this.strUserNetType = "";
    }

    public Header(long j, CmdResult cmdResult, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.lCurrTime = 0L;
        this.stResult = null;
        this.uAccIp = 0L;
        this.strSessionId = "";
        this.strLC = "";
        this.strToken = "";
        this.strFr = "";
        this.strPf = "";
        this.strImei = "";
        this.strMobver = "";
        this.strNettp = "";
        this.strImsi = "";
        this.strOsVersion = "";
        this.strSoftVersion = "";
        this.strOfflineVersion = "";
        this.strChannel = "";
        this.strMachineModel = "";
        this.strUserNetType = "";
        this.lCurrTime = j;
        this.stResult = cmdResult;
        this.uAccIp = j2;
        this.strSessionId = str;
        this.strLC = str2;
        this.strToken = str3;
        this.strFr = str4;
        this.strPf = str5;
        this.strImei = str6;
        this.strMobver = str7;
        this.strNettp = str8;
        this.strImsi = str9;
        this.strOsVersion = str10;
        this.strSoftVersion = str11;
        this.strOfflineVersion = str12;
        this.strChannel = str13;
        this.strMachineModel = str14;
        this.strUserNetType = str15;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "sosomap.Header";
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
        kVar.a(this.lCurrTime, "lCurrTime");
        kVar.a((p) this.stResult, "stResult");
        kVar.a(this.uAccIp, "uAccIp");
        kVar.a(this.strSessionId, "strSessionId");
        kVar.a(this.strLC, "strLC");
        kVar.a(this.strToken, "strToken");
        kVar.a(this.strFr, "strFr");
        kVar.a(this.strPf, "strPf");
        kVar.a(this.strImei, "strImei");
        kVar.a(this.strMobver, "strMobver");
        kVar.a(this.strNettp, "strNettp");
        kVar.a(this.strImsi, "strImsi");
        kVar.a(this.strOsVersion, "strOsVersion");
        kVar.a(this.strSoftVersion, "strSoftVersion");
        kVar.a(this.strOfflineVersion, "strOfflineVersion");
        kVar.a(this.strChannel, "strChannel");
        kVar.a(this.strMachineModel, "strMachineModel");
        kVar.a(this.strUserNetType, "strUserNetType");
    }

    @Override // com.tencent.mapsdk.internal.p
    public void displaySimple(StringBuilder sb, int i) {
        k kVar = new k(sb, i);
        kVar.a(this.lCurrTime, true);
        kVar.a((p) this.stResult, true);
        kVar.a(this.uAccIp, true);
        kVar.a(this.strSessionId, true);
        kVar.a(this.strLC, true);
        kVar.a(this.strToken, true);
        kVar.a(this.strFr, true);
        kVar.a(this.strPf, true);
        kVar.a(this.strImei, true);
        kVar.a(this.strMobver, true);
        kVar.a(this.strNettp, true);
        kVar.a(this.strImsi, true);
        kVar.a(this.strOsVersion, true);
        kVar.a(this.strSoftVersion, true);
        kVar.a(this.strOfflineVersion, true);
        kVar.a(this.strChannel, true);
        kVar.a(this.strMachineModel, true);
        kVar.a(this.strUserNetType, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Header header = (Header) obj;
        boolean z = false;
        if (q.b(this.lCurrTime, header.lCurrTime)) {
            z = false;
            if (q.a(this.stResult, header.stResult)) {
                z = false;
                if (q.b(this.uAccIp, header.uAccIp)) {
                    z = false;
                    if (q.a((Object) this.strSessionId, (Object) header.strSessionId)) {
                        z = false;
                        if (q.a((Object) this.strLC, (Object) header.strLC)) {
                            z = false;
                            if (q.a((Object) this.strToken, (Object) header.strToken)) {
                                z = false;
                                if (q.a((Object) this.strFr, (Object) header.strFr)) {
                                    z = false;
                                    if (q.a((Object) this.strPf, (Object) header.strPf)) {
                                        z = false;
                                        if (q.a((Object) this.strImei, (Object) header.strImei)) {
                                            z = false;
                                            if (q.a((Object) this.strMobver, (Object) header.strMobver)) {
                                                z = false;
                                                if (q.a((Object) this.strNettp, (Object) header.strNettp)) {
                                                    z = false;
                                                    if (q.a((Object) this.strImsi, (Object) header.strImsi)) {
                                                        z = false;
                                                        if (q.a((Object) this.strOsVersion, (Object) header.strOsVersion)) {
                                                            z = false;
                                                            if (q.a((Object) this.strSoftVersion, (Object) header.strSoftVersion)) {
                                                                z = false;
                                                                if (q.a((Object) this.strOfflineVersion, (Object) header.strOfflineVersion)) {
                                                                    z = false;
                                                                    if (q.a((Object) this.strChannel, (Object) header.strChannel)) {
                                                                        z = false;
                                                                        if (q.a((Object) this.strMachineModel, (Object) header.strMachineModel)) {
                                                                            z = false;
                                                                            if (q.a((Object) this.strUserNetType, (Object) header.strUserNetType)) {
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
        this.lCurrTime = mVar.a(this.lCurrTime, 0, true);
        if (f37270c == null) {
            f37270c = new CmdResult();
        }
        this.stResult = (CmdResult) mVar.b((p) f37270c, 1, false);
        this.uAccIp = mVar.a(this.uAccIp, 2, false);
        this.strSessionId = mVar.b(3, false);
        this.strLC = mVar.b(4, false);
        this.strToken = mVar.b(5, false);
        this.strFr = mVar.b(6, false);
        this.strPf = mVar.b(7, false);
        this.strImei = mVar.b(8, false);
        this.strMobver = mVar.b(9, false);
        this.strNettp = mVar.b(10, false);
        this.strImsi = mVar.b(11, false);
        this.strOsVersion = mVar.b(12, false);
        this.strSoftVersion = mVar.b(13, false);
        this.strOfflineVersion = mVar.b(14, false);
        this.strChannel = mVar.b(15, false);
        this.strMachineModel = mVar.b(16, false);
        this.strUserNetType = mVar.b(17, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.lCurrTime, 0);
        CmdResult cmdResult = this.stResult;
        if (cmdResult != null) {
            nVar.a((p) cmdResult, 1);
        }
        nVar.a(this.uAccIp, 2);
        String str = this.strSessionId;
        if (str != null) {
            nVar.a(str, 3);
        }
        String str2 = this.strLC;
        if (str2 != null) {
            nVar.a(str2, 4);
        }
        String str3 = this.strToken;
        if (str3 != null) {
            nVar.a(str3, 5);
        }
        String str4 = this.strFr;
        if (str4 != null) {
            nVar.a(str4, 6);
        }
        String str5 = this.strPf;
        if (str5 != null) {
            nVar.a(str5, 7);
        }
        String str6 = this.strImei;
        if (str6 != null) {
            nVar.a(str6, 8);
        }
        String str7 = this.strMobver;
        if (str7 != null) {
            nVar.a(str7, 9);
        }
        String str8 = this.strNettp;
        if (str8 != null) {
            nVar.a(str8, 10);
        }
        String str9 = this.strImsi;
        if (str9 != null) {
            nVar.a(str9, 11);
        }
        String str10 = this.strOsVersion;
        if (str10 != null) {
            nVar.a(str10, 12);
        }
        String str11 = this.strSoftVersion;
        if (str11 != null) {
            nVar.a(str11, 13);
        }
        String str12 = this.strOfflineVersion;
        if (str12 != null) {
            nVar.a(str12, 14);
        }
        String str13 = this.strChannel;
        if (str13 != null) {
            nVar.a(str13, 15);
        }
        String str14 = this.strMachineModel;
        if (str14 != null) {
            nVar.a(str14, 16);
        }
        String str15 = this.strUserNetType;
        if (str15 != null) {
            nVar.a(str15, 17);
        }
    }
}
