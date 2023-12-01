package com.zk_oaction.adengine.lk_command;

import com.huawei.hms.push.constant.RemoteMessageConst;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/f.class */
public class f extends b {
    private String i;
    private float j;
    private boolean k;
    private boolean l;

    public f(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.j = 1.0f;
        this.k = false;
        this.l = false;
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void a() {
        this.f28218a.k.a(this.i, this.j, this.k, this.l);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, RemoteMessageConst.Notification.SOUND);
            this.i = attributeValue;
            if (attributeValue == null) {
                return false;
            }
            String str2 = this.f28218a.l + this.i;
            this.i = str2;
            this.f28218a.k.a(str2);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "volume");
            if (attributeValue2 != null) {
                this.j = Float.parseFloat(attributeValue2);
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "loop");
            if (attributeValue3 != null) {
                this.k = Boolean.parseBoolean(attributeValue3);
            }
            String attributeValue4 = xmlPullParser.getAttributeValue(null, "keepCur");
            if (attributeValue4 != null) {
                this.l = Boolean.parseBoolean(attributeValue4);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
