package com.zk_oaction.adengine.lk_variable;

import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/a.class */
public class a implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28313a;
    private String b;

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28313a = cVar;
    }

    private void a(XmlPullParser xmlPullParser, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (xmlPullParser.getName().equals("Variable")) {
            arrayList.add(xmlPullParser.getAttributeValue(null, "name"));
            arrayList2.add(xmlPullParser.getAttributeValue(null, "column"));
        }
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        String attributeValue = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue != null) {
            this.b = attributeValue;
        } else {
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "uriFormat");
            if (attributeValue2 == null) {
                return false;
            }
            new com.zk_oaction.adengine.lk_expression.b(this.f28313a, attributeValue2, xmlPullParser.getAttributeValue(null, "uriParas"), this);
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "columns");
        String[] split = attributeValue3 != null ? attributeValue3.split(",") : null;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "where");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, ProcessBridgeProvider.KEY_ARGS);
        String[] split2 = attributeValue5 != null ? attributeValue5.split(",") : null;
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "order");
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "countName");
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    a(xmlPullParser, arrayList, arrayList2);
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    this.f28313a.k.a(this.b, split, attributeValue4, split2, attributeValue6, attributeValue7, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList.size()]));
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        this.b = str;
    }
}
