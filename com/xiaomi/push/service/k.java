package com.xiaomi.push.service;

import com.xiaomi.push.gi;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gw;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/k.class */
public class k implements gr {
    public static gi a(XmlPullParser xmlPullParser) {
        String str;
        ArrayList arrayList;
        String[] strArr;
        String[] strArr2;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            strArr2 = new String[xmlPullParser.getAttributeCount()];
            strArr = new String[xmlPullParser.getAttributeCount()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= xmlPullParser.getAttributeCount()) {
                    break;
                }
                strArr2[i2] = xmlPullParser.getAttributeName(i2);
                strArr[i2] = gw.b(xmlPullParser.getAttributeValue(i2));
                i = i2 + 1;
            }
            str = null;
            arrayList = null;
        } else {
            str = null;
            arrayList = null;
            strArr = null;
            strArr2 = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new gi(name, namespace, strArr2, strArr, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                }
                gi a2 = a(xmlPullParser);
                arrayList = arrayList2;
                if (a2 != null) {
                    arrayList2.add(a2);
                    arrayList = arrayList2;
                }
            }
        }
    }

    public void a() {
        gs.a().a("all", "xm:chat", this);
    }

    public gi b(XmlPullParser xmlPullParser) {
        int i;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = eventType;
            if (i == 1 || i == 2) {
                break;
            }
            eventType = xmlPullParser.next();
        }
        if (i == 2) {
            return a(xmlPullParser);
        }
        return null;
    }
}
