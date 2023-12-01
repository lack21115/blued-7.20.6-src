package com.zk_oaction.adengine.lk_variable;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28314a;
    private String[] b = new String[4];

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28314a = cVar;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        this.f28314a.k.a(attributeValue, this.b);
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Variable")) {
                    this.b[Integer.parseInt(xmlPullParser.getAttributeValue(null, "index"))] = xmlPullParser.getAttributeValue(null, "name");
                }
                next = xmlPullParser.next();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
