package com.zk_oaction.adengine.lk_variable;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f42010a;

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f42010a = cVar;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("ContentProviderBinder")) {
                    new a(this.f42010a).a(xmlPullParser, "ContentProviderBinder");
                } else if (xmlPullParser.getName().equals("SensorBinder")) {
                    new b(this.f42010a).a(xmlPullParser, "SensorBinder");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
