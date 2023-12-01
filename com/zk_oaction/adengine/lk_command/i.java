package com.zk_oaction.adengine.lk_command;

import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/i.class */
public class i extends b {
    private String i;
    private String j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private com.zk_oaction.adengine.lk_expression.a l;
    private com.zk_oaction.adengine.lk_expression.a m;

    public i(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void a() {
        if (this.l.a() != -1.0f) {
            float a2 = this.l.a();
            this.f41909a.a(this.i, a2);
            this.f41909a.b(this.i, a2);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        if (this.j == null) {
            com.zk_oaction.adengine.lk_sdk.c cVar = this.f41909a;
            String str = this.i;
            boolean z3 = this.k.a() == 1.0f;
            if (this.m.a() == 1.0f) {
                z = true;
            }
            cVar.a(str, z3, z);
            return;
        }
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f41909a;
        String str2 = this.i;
        String str3 = this.f41909a.l + this.j;
        String str4 = this.e;
        int i = this.f;
        com.zk_oaction.adengine.lk_expression.c cVar3 = this.g;
        cVar2.a(str2, str3, str4, i, cVar3 != null ? cVar3.a() : "", this.h);
        com.zk_oaction.adengine.lk_sdk.c cVar4 = this.f41909a;
        String str5 = this.i;
        if (this.m.a() == 1.0f) {
            z2 = true;
        }
        cVar4.a(str5, true, z2);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.i = xmlPullParser.getAttributeValue(null, "name");
            this.j = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
            this.k = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, "play", xmlPullParser.getAttributeValue(null, "play"), -1.0f, null, false);
            this.l = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, RemoteMessageConst.Notification.SOUND, xmlPullParser.getAttributeValue(null, RemoteMessageConst.Notification.SOUND), -1.0f, null, false);
            this.m = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, "reset", xmlPullParser.getAttributeValue(null, "reset"), 1.0f, null, false);
            a(xmlPullParser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
