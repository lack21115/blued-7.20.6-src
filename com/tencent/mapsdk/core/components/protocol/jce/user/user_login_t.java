package com.tencent.mapsdk.core.components.protocol.jce.user;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/components/protocol/jce/user/user_login_t.class */
public final class user_login_t extends MapJceStruct {
    public String channel;
    public String fr;
    public String imei;
    public boolean is_login;
    public String nettp;
    public String pf;
    public String session_id;
    public long uin;
    public int uip;
    public long user_id;
    public String version;
    public double x;
    public double y;

    public user_login_t() {
        this.user_id = 0L;
        this.session_id = "";
        this.uin = 0L;
        this.uip = 0;
        this.imei = "";
        this.x = 0.0d;
        this.y = 0.0d;
        this.pf = "";
        this.version = "";
        this.is_login = true;
        this.fr = "";
        this.nettp = "";
        this.channel = "";
    }

    public user_login_t(long j, String str, long j2, int i, String str2, double d, double d2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        this.user_id = 0L;
        this.session_id = "";
        this.uin = 0L;
        this.uip = 0;
        this.imei = "";
        this.x = 0.0d;
        this.y = 0.0d;
        this.pf = "";
        this.version = "";
        this.is_login = true;
        this.fr = "";
        this.nettp = "";
        this.channel = "";
        this.user_id = j;
        this.session_id = str;
        this.uin = j2;
        this.uip = i;
        this.imei = str2;
        this.x = d;
        this.y = d2;
        this.pf = str3;
        this.version = str4;
        this.is_login = z;
        this.fr = str5;
        this.nettp = str6;
        this.channel = str7;
    }

    @Override // com.tencent.mapsdk.internal.p
    public String className() {
        return "navsns.user_login_t";
    }

    @Override // com.tencent.mapsdk.internal.p
    public void readFrom(m mVar) {
        this.user_id = mVar.a(this.user_id, 0, true);
        this.session_id = mVar.b(1, true);
        this.uin = mVar.a(this.uin, 2, true);
        this.uip = mVar.a(this.uip, 3, true);
        this.imei = mVar.b(4, false);
        this.x = mVar.a(this.x, 5, false);
        this.y = mVar.a(this.y, 6, false);
        this.pf = mVar.b(7, false);
        this.version = mVar.b(8, false);
        this.is_login = mVar.a(this.is_login, 9, false);
        this.fr = mVar.b(10, false);
        this.nettp = mVar.b(11, false);
        this.channel = mVar.b(12, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public void writeTo(n nVar) {
        nVar.a(this.user_id, 0);
        nVar.a(this.session_id, 1);
        nVar.a(this.uin, 2);
        nVar.a(this.uip, 3);
        String str = this.imei;
        if (str != null) {
            nVar.a(str, 4);
        }
        nVar.a(this.x, 5);
        nVar.a(this.y, 6);
        String str2 = this.pf;
        if (str2 != null) {
            nVar.a(str2, 7);
        }
        String str3 = this.version;
        if (str3 != null) {
            nVar.a(str3, 8);
        }
        nVar.a(this.is_login, 9);
        String str4 = this.fr;
        if (str4 != null) {
            nVar.a(str4, 10);
        }
        String str5 = this.nettp;
        if (str5 != null) {
            nVar.a(str5, 11);
        }
        String str6 = this.channel;
        if (str6 != null) {
            nVar.a(str6, 12);
        }
    }
}
