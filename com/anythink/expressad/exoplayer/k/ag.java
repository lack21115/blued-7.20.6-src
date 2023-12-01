package com.anythink.expressad.exoplayer.k;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/ag.class */
public final class ag {
    private ag() {
    }

    private static String a(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1);
    }

    private static boolean a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    private static boolean a(XmlPullParser xmlPullParser, String str) {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    private static boolean b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    private static boolean b(XmlPullParser xmlPullParser, String str) {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    private static boolean c(XmlPullParser xmlPullParser, String str) {
        return b(xmlPullParser) && a(xmlPullParser.getName()).equals(str);
    }

    private static String d(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                return null;
            }
            if (xmlPullParser.getAttributeName(i2).equals(str)) {
                return xmlPullParser.getAttributeValue(i2);
            }
            i = i2 + 1;
        }
    }

    private static String e(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                return null;
            }
            if (a(xmlPullParser.getAttributeName(i2)).equals(str)) {
                return xmlPullParser.getAttributeValue(i2);
            }
            i = i2 + 1;
        }
    }
}
