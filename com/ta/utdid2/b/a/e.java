package com.ta.utdid2.b.a;

import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.anythink.expressad.foundation.d.l;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/b/a/e.class */
class e {
    public static final Object a(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            } else if (eventType == 4) {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            } else {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception e) {
                    throw new XmlPullParserException("Unexpected call next(): " + xmlPullParser.getName());
                }
            }
        }
        return b(xmlPullParser, strArr);
    }

    public static final ArrayList a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final HashMap a(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) a(newPullParser, new String[1]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final HashMap m6848a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object b = b(xmlPullParser, strArr);
                if (strArr[0] == null) {
                    throw new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                }
                hashMap.put(strArr[0], b);
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final void a(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.l);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, com.igexin.push.core.b.l);
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
        } else {
            if (obj instanceof Integer) {
                str2 = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = TypedValues.Custom.S_FLOAT;
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (!(obj instanceof Boolean)) {
                if (obj instanceof byte[]) {
                    a((byte[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof int[]) {
                    a((int[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof Map) {
                    a((Map) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof List) {
                    a((List) obj, str, xmlSerializer);
                    return;
                } else if (!(obj instanceof CharSequence)) {
                    throw new RuntimeException("writeValueXml: unable to write value " + obj);
                } else {
                    xmlSerializer.startTag(null, "string");
                    if (str != null) {
                        xmlSerializer.attribute(null, "name", str);
                    }
                    xmlSerializer.text(obj.toString());
                    xmlSerializer.endTag(null, "string");
                    return;
                }
            } else {
                str2 = TypedValues.Custom.S_BOOLEAN;
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.attribute(null, "value", obj.toString());
            xmlSerializer.endTag(null, str2);
        }
    }

    public static final void a(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.l);
            xmlSerializer.endTag(null, com.igexin.push.core.b.l);
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                xmlSerializer.endTag(null, "list");
                return;
            } else {
                a(list.get(i2), (String) null, xmlSerializer);
                i = i2 + 1;
            }
        }
    }

    public static final void a(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        a aVar = new a();
        aVar.setOutput(outputStream, "utf-8");
        aVar.startDocument(null, true);
        aVar.setFeature(a.d(), true);
        a(map, (String) null, (XmlSerializer) aVar);
        aVar.endDocument();
    }

    public static final void a(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.l);
            xmlSerializer.endTag(null, com.igexin.push.core.b.l);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Map.Entry entry : map.entrySet()) {
            a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
    }

    public static final void a(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.l);
            xmlSerializer.endTag(null, com.igexin.push.core.b.l);
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = bArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.text(sb.toString());
                xmlSerializer.endTag(null, "byte-array");
                return;
            }
            byte b = bArr[i2];
            int i3 = b >> 4;
            sb.append(i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i4 = b & 255;
            sb.append(i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
            i = i2 + 1;
        }
    }

    public static final void a(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, com.igexin.push.core.b.l);
            xmlSerializer.endTag(null, com.igexin.push.core.b.l);
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = iArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.endTag(null, "int-array");
                return;
            }
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Integer.toString(iArr[i2]));
            xmlSerializer.endTag(null, "item");
            i = i2 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final int[] m6849a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d))];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            while (true) {
                if (eventType != 2) {
                    i = i2;
                    if (eventType == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            return iArr;
                        }
                        if (!xmlPullParser.getName().equals("item")) {
                            throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                        }
                        i = i2 + 1;
                    }
                } else if (!xmlPullParser.getName().equals("item")) {
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                } else {
                    try {
                        iArr[i2] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                        i = i2;
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                }
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    throw new XmlPullParserException("Document ended before " + str + " end tag");
                }
                i2 = i;
            }
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    private static Object b(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int next;
        Integer num = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals(com.igexin.push.core.b.l)) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    }
                    if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    } else if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                num = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            } else if (name.equals("long")) {
                num = Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals(TypedValues.Custom.S_FLOAT)) {
                num = Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("double")) {
                num = Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (!name.equals(TypedValues.Custom.S_BOOLEAN)) {
                if (name.equals("int-array")) {
                    xmlPullParser.next();
                    int[] m6849a = m6849a(xmlPullParser, "int-array", strArr);
                    strArr[0] = attributeValue;
                    return m6849a;
                } else if (name.equals("map")) {
                    xmlPullParser.next();
                    HashMap m6848a = m6848a(xmlPullParser, "map", strArr);
                    strArr[0] = attributeValue;
                    return m6848a;
                } else if (name.equals("list")) {
                    xmlPullParser.next();
                    ArrayList a2 = a(xmlPullParser, "list", strArr);
                    strArr[0] = attributeValue;
                    return a2;
                } else {
                    throw new XmlPullParserException("Unknown tag: " + name);
                }
            } else {
                num = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + SimpleComparison.GREATER_THAN_OPERATION);
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return num;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }
}
