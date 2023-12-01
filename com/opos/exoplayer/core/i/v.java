package com.opos.exoplayer.core.i;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/v.class */
public final class v {
    public static boolean a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static String c(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                return null;
            }
            if (str.equals(xmlPullParser.getAttributeName(i2))) {
                return xmlPullParser.getAttributeValue(i2);
            }
            i = i2 + 1;
        }
    }
}
