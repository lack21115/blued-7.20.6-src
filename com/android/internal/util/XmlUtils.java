package com.android.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.anythink.expressad.foundation.d.l;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/XmlUtils.class */
public class XmlUtils {

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/XmlUtils$ReadMapCallback.class */
    public interface ReadMapCallback {
        Object readThisUnknownObjectXml(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException;
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/XmlUtils$WriteMapCallback.class */
    public interface WriteMapCallback {
        void writeUnknownObject(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException;
    }

    public static final void beginDocument(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!xmlPullParser.getName().equals(str)) {
            throw new XmlPullParserException("Unexpected start tag: found " + xmlPullParser.getName() + ", expected " + str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r3.equals("TRUE") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean convertValueToBoolean(java.lang.CharSequence r3, boolean r4) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            if (r0 != 0) goto L8
            r0 = r4
            return r0
        L8:
            r0 = r3
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L25
            r0 = r3
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L25
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.String r1 = "TRUE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
        L25:
            r0 = 1
            r4 = r0
        L27:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.util.XmlUtils.convertValueToBoolean(java.lang.CharSequence, boolean):boolean");
    }

    public static final int convertValueToInt(CharSequence charSequence, int i) {
        int i2;
        if (charSequence == null) {
            return i;
        }
        String charSequence2 = charSequence.toString();
        int i3 = 1;
        int i4 = 0;
        int length = charSequence2.length();
        int i5 = 10;
        if ('-' == charSequence2.charAt(0)) {
            i3 = -1;
            i4 = 0 + 1;
        }
        if ('0' != charSequence2.charAt(i4)) {
            i2 = i4;
            if ('#' == charSequence2.charAt(i4)) {
                i2 = i4 + 1;
                i5 = 16;
            }
        } else if (i4 == length - 1) {
            return 0;
        } else {
            char charAt = charSequence2.charAt(i4 + 1);
            if ('x' == charAt || 'X' == charAt) {
                i2 = i4 + 2;
                i5 = 16;
            } else {
                i2 = i4 + 1;
                i5 = 8;
            }
        }
        return Integer.parseInt(charSequence2.substring(i2), i5) * i3;
    }

    public static final int convertValueToList(CharSequence charSequence, String[] strArr, int i) {
        if (charSequence != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= strArr.length) {
                    break;
                } else if (charSequence.equals(strArr[i3])) {
                    return i3;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return i;
    }

    public static int convertValueToUnsignedInt(String str, int i) {
        return str == null ? i : parseUnsignedIntAttribute(str);
    }

    public static final void nextElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }

    public static boolean nextElementWithin(XmlPullParser xmlPullParser, int i) throws IOException, XmlPullParserException {
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return false;
            }
            if (next == 3 && xmlPullParser.getDepth() == i) {
                return false;
            }
            if (next == 2 && xmlPullParser.getDepth() == i + 1) {
                return true;
            }
        }
    }

    public static int parseUnsignedIntAttribute(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int i = 0;
        int length = charSequence2.length();
        int i2 = 10;
        if ('0' == charSequence2.charAt(0)) {
            if (length - 1 == 0) {
                return 0;
            }
            char charAt = charSequence2.charAt(1);
            if ('x' == charAt || 'X' == charAt) {
                i = 0 + 2;
                i2 = 16;
            } else {
                i = 0 + 1;
                i2 = 8;
            }
        } else if ('#' == charSequence2.charAt(0)) {
            i = 0 + 1;
            i2 = 16;
        }
        return (int) Long.parseLong(charSequence2.substring(i), i2);
    }

    public static Bitmap readBitmapAttribute(XmlPullParser xmlPullParser, String str) {
        byte[] readByteArrayAttribute = readByteArrayAttribute(xmlPullParser, str);
        if (readByteArrayAttribute != null) {
            return BitmapFactory.decodeByteArray(readByteArrayAttribute, 0, readByteArrayAttribute.length);
        }
        return null;
    }

    public static boolean readBooleanAttribute(XmlPullParser xmlPullParser, String str) {
        return Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, str));
    }

    public static boolean readBooleanAttribute(XmlPullParser xmlPullParser, String str, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? z : Boolean.parseBoolean(attributeValue);
    }

    public static byte[] readByteArrayAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        byte[] bArr = null;
        if (attributeValue != null) {
            bArr = Base64.decode(attributeValue, 0);
        }
        return bArr;
    }

    public static float readFloatAttribute(XmlPullParser xmlPullParser, String str) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return Float.parseFloat(attributeValue);
        } catch (NumberFormatException e) {
            throw new ProtocolException("problem parsing " + str + "=" + attributeValue + " as long");
        }
    }

    public static int readIntAttribute(XmlPullParser xmlPullParser, String str) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return Integer.parseInt(attributeValue);
        } catch (NumberFormatException e) {
            throw new ProtocolException("problem parsing " + str + "=" + attributeValue + " as int");
        }
    }

    public static int readIntAttribute(XmlPullParser xmlPullParser, String str, int i) {
        try {
            return Integer.parseInt(xmlPullParser.getAttributeValue(null, str));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static final ArrayList readListXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (ArrayList) readValueXml(newPullParser, new String[1]);
    }

    public static long readLongAttribute(XmlPullParser xmlPullParser, String str) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        try {
            return Long.parseLong(attributeValue);
        } catch (NumberFormatException e) {
            throw new ProtocolException("problem parsing " + str + "=" + attributeValue + " as long");
        }
    }

    public static long readLongAttribute(XmlPullParser xmlPullParser, String str, long j) {
        try {
            return Long.parseLong(xmlPullParser.getAttributeValue(null, str));
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static final HashMap<String, ?> readMapXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) readValueXml(newPullParser, new String[1]);
    }

    public static final HashSet readSetXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashSet) readValueXml(newPullParser, new String[1]);
    }

    public static String readStringAttribute(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue(null, str);
    }

    public static final boolean[] readThisBooleanArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        int next;
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d));
            xmlPullParser.next();
            boolean[] zArr = new boolean[parseInt];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType != 2) {
                    i = i2;
                    if (eventType == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            return zArr;
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
                        zArr[i2] = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value")).booleanValue();
                        i = i2;
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                }
                next = xmlPullParser.next();
                eventType = next;
                i2 = i;
            } while (next != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in string-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    public static final double[] readThisDoubleArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        int next;
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d));
            xmlPullParser.next();
            double[] dArr = new double[parseInt];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType != 2) {
                    i = i2;
                    if (eventType == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            return dArr;
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
                        dArr[i2] = Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                        i = i2;
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                }
                next = xmlPullParser.next();
                eventType = next;
                i2 = i;
            } while (next != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in double-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in double-array");
        }
    }

    public static final int[] readThisIntArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        int next;
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d));
            xmlPullParser.next();
            int[] iArr = new int[parseInt];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
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
                next = xmlPullParser.next();
                eventType = next;
                i2 = i;
            } while (next != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static final ArrayList readThisListXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        return readThisListXml(xmlPullParser, str, strArr, null);
    }

    private static final ArrayList readThisListXml(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        int next;
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(readThisValueXml(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            next = xmlPullParser.next();
            eventType = next;
        } while (next != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final long[] readThisLongArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        int next;
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d));
            xmlPullParser.next();
            long[] jArr = new long[parseInt];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType != 2) {
                    i = i2;
                    if (eventType == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            return jArr;
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
                        jArr[i2] = Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                        i = i2;
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                }
                next = xmlPullParser.next();
                eventType = next;
                i2 = i;
            } while (next != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in long-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in long-array");
        }
    }

    public static final HashMap<String, ?> readThisMapXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        return readThisMapXml(xmlPullParser, str, strArr, null);
    }

    public static final HashMap<String, ?> readThisMapXml(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        int next;
        HashMap<String, ?> hashMap = new HashMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashMap.put(strArr[0], readThisValueXml(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            next = xmlPullParser.next();
            eventType = next;
        } while (next != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final Object readThisPrimitiveValueXml(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        Boolean bool = null;
        try {
            if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals("long")) {
                return Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals(TypedValues.Custom.S_FLOAT)) {
                return new Float(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("double")) {
                return new Double(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
                bool = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            return bool;
        } catch (NullPointerException e) {
            throw new XmlPullParserException("Need value attribute in <" + str + SimpleComparison.GREATER_THAN_OPERATION);
        } catch (NumberFormatException e2) {
            throw new XmlPullParserException("Not a number in value attribute in <" + str + SimpleComparison.GREATER_THAN_OPERATION);
        }
    }

    public static final HashSet readThisSetXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        return readThisSetXml(xmlPullParser, str, strArr, null);
    }

    private static final HashSet readThisSetXml(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        int next;
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(readThisValueXml(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashSet;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            next = xmlPullParser.next();
            eventType = next;
        } while (next != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final String[] readThisStringArrayXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        int i;
        int next;
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, l.d));
            xmlPullParser.next();
            String[] strArr2 = new String[parseInt];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType != 2) {
                    i = i2;
                    if (eventType == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            return strArr2;
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
                        strArr2[i2] = xmlPullParser.getAttributeValue(null, "value");
                        i = i2;
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                }
                next = xmlPullParser.next();
                eventType = next;
                i2 = i;
            } while (next != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in string-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final Object readThisValueXml(XmlPullParser xmlPullParser, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        Object obj;
        int next;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (name.equals(b.l)) {
            obj = null;
        } else if (name.equals("string")) {
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
        } else {
            Object readThisPrimitiveValueXml = readThisPrimitiveValueXml(xmlPullParser, name);
            obj = readThisPrimitiveValueXml;
            if (readThisPrimitiveValueXml == null) {
                if (name.equals("int-array")) {
                    int[] readThisIntArrayXml = readThisIntArrayXml(xmlPullParser, "int-array", strArr);
                    strArr[0] = attributeValue;
                    return readThisIntArrayXml;
                } else if (name.equals("long-array")) {
                    long[] readThisLongArrayXml = readThisLongArrayXml(xmlPullParser, "long-array", strArr);
                    strArr[0] = attributeValue;
                    return readThisLongArrayXml;
                } else if (name.equals("double-array")) {
                    double[] readThisDoubleArrayXml = readThisDoubleArrayXml(xmlPullParser, "double-array", strArr);
                    strArr[0] = attributeValue;
                    return readThisDoubleArrayXml;
                } else if (name.equals("string-array")) {
                    String[] readThisStringArrayXml = readThisStringArrayXml(xmlPullParser, "string-array", strArr);
                    strArr[0] = attributeValue;
                    return readThisStringArrayXml;
                } else if (name.equals("boolean-array")) {
                    boolean[] readThisBooleanArrayXml = readThisBooleanArrayXml(xmlPullParser, "boolean-array", strArr);
                    strArr[0] = attributeValue;
                    return readThisBooleanArrayXml;
                } else if (name.equals("map")) {
                    xmlPullParser.next();
                    HashMap<String, ?> readThisMapXml = readThisMapXml(xmlPullParser, "map", strArr);
                    strArr[0] = attributeValue;
                    return readThisMapXml;
                } else if (name.equals("list")) {
                    xmlPullParser.next();
                    ArrayList readThisListXml = readThisListXml(xmlPullParser, "list", strArr);
                    strArr[0] = attributeValue;
                    return readThisListXml;
                } else if (name.equals("set")) {
                    xmlPullParser.next();
                    HashSet readThisSetXml = readThisSetXml(xmlPullParser, "set", strArr);
                    strArr[0] = attributeValue;
                    return readThisSetXml;
                } else if (readMapCallback != null) {
                    Object readThisUnknownObjectXml = readMapCallback.readThisUnknownObjectXml(xmlPullParser, name);
                    strArr[0] = attributeValue;
                    return readThisUnknownObjectXml;
                } else {
                    throw new XmlPullParserException("Unknown tag: " + name);
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + SimpleComparison.GREATER_THAN_OPERATION);
            }
            if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    public static Uri readUriAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        Uri uri = null;
        if (attributeValue != null) {
            uri = Uri.parse(attributeValue);
        }
        return uri;
    }

    public static final Object readValueXml(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            }
            if (eventType == 4) {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
            int next = xmlPullParser.next();
            eventType = next;
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document");
            }
        }
        return readThisValueXml(xmlPullParser, strArr, null);
    }

    public static void skipCurrentTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    @Deprecated
    public static void writeBitmapAttribute(XmlSerializer xmlSerializer, String str, Bitmap bitmap) throws IOException {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
            writeByteArrayAttribute(xmlSerializer, str, byteArrayOutputStream.toByteArray());
        }
    }

    public static final void writeBooleanArrayXml(boolean[] zArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (zArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "boolean-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = zArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.endTag(null, "boolean-array");
                return;
            }
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Boolean.toString(zArr[i2]));
            xmlSerializer.endTag(null, "item");
            i = i2 + 1;
        }
    }

    public static void writeBooleanAttribute(XmlSerializer xmlSerializer, String str, boolean z) throws IOException {
        xmlSerializer.attribute(null, str, Boolean.toString(z));
    }

    public static void writeByteArrayAttribute(XmlSerializer xmlSerializer, String str, byte[] bArr) throws IOException {
        if (bArr != null) {
            xmlSerializer.attribute(null, str, Base64.encodeToString(bArr, 0));
        }
    }

    public static final void writeByteArrayXml(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
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

    public static final void writeDoubleArrayXml(double[] dArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (dArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "double-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = dArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.endTag(null, "double-array");
                return;
            }
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Double.toString(dArr[i2]));
            xmlSerializer.endTag(null, "item");
            i = i2 + 1;
        }
    }

    public static void writeFloatAttribute(XmlSerializer xmlSerializer, String str, float f) throws IOException {
        xmlSerializer.attribute(null, str, Float.toString(f));
    }

    public static final void writeIntArrayXml(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
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

    public static void writeIntAttribute(XmlSerializer xmlSerializer, String str, int i) throws IOException {
        xmlSerializer.attribute(null, str, Integer.toString(i));
    }

    public static final void writeListXml(List list, OutputStream outputStream) throws XmlPullParserException, IOException {
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, "utf-8");
        newSerializer.startDocument(null, true);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(list, null, newSerializer);
        newSerializer.endDocument();
    }

    public static final void writeListXml(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
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
                writeValueXml(list.get(i2), null, xmlSerializer);
                i = i2 + 1;
            }
        }
    }

    public static final void writeLongArrayXml(long[] jArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (jArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "long-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = jArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.endTag(null, "long-array");
                return;
            }
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Long.toString(jArr[i2]));
            xmlSerializer.endTag(null, "item");
            i = i2 + 1;
        }
    }

    public static void writeLongAttribute(XmlSerializer xmlSerializer, String str, long j) throws IOException {
        xmlSerializer.attribute(null, str, Long.toString(j));
    }

    public static final void writeMapXml(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        FastXmlSerializer fastXmlSerializer = new FastXmlSerializer();
        fastXmlSerializer.setOutput(outputStream, "utf-8");
        fastXmlSerializer.startDocument(null, true);
        fastXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(map, (String) null, fastXmlSerializer);
        fastXmlSerializer.endDocument();
    }

    public static final void writeMapXml(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        writeMapXml(map, str, xmlSerializer, null);
    }

    public static final void writeMapXml(Map map, String str, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        writeMapXml(map, xmlSerializer, writeMapCallback);
        xmlSerializer.endTag(null, "map");
    }

    public static final void writeMapXml(Map map, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws XmlPullParserException, IOException {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            writeValueXml(entry.getValue(), (String) entry.getKey(), xmlSerializer, writeMapCallback);
        }
    }

    public static final void writeSetXml(Set set, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (set == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Object obj : set) {
            writeValueXml(obj, null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "set");
    }

    public static final void writeStringArrayXml(String[] strArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (strArr == null) {
            xmlSerializer.startTag(null, b.l);
            xmlSerializer.endTag(null, b.l);
            return;
        }
        xmlSerializer.startTag(null, "string-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = strArr.length;
        xmlSerializer.attribute(null, l.d, Integer.toString(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                xmlSerializer.endTag(null, "string-array");
                return;
            }
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", strArr[i2]);
            xmlSerializer.endTag(null, "item");
            i = i2 + 1;
        }
    }

    public static void writeStringAttribute(XmlSerializer xmlSerializer, String str, String str2) throws IOException {
        if (str2 != null) {
            xmlSerializer.attribute(null, str, str2);
        }
    }

    public static void writeUriAttribute(XmlSerializer xmlSerializer, String str, Uri uri) throws IOException {
        if (uri != null) {
            xmlSerializer.attribute(null, str, uri.toString());
        }
    }

    public static final void writeValueXml(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        writeValueXml(obj, str, xmlSerializer, null);
    }

    private static final void writeValueXml(Object obj, String str, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, b.l);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, b.l);
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
                    writeByteArrayXml((byte[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof int[]) {
                    writeIntArrayXml((int[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof long[]) {
                    writeLongArrayXml((long[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof double[]) {
                    writeDoubleArrayXml((double[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof String[]) {
                    writeStringArrayXml((String[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof boolean[]) {
                    writeBooleanArrayXml((boolean[]) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof Map) {
                    writeMapXml((Map) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof List) {
                    writeListXml((List) obj, str, xmlSerializer);
                    return;
                } else if (obj instanceof Set) {
                    writeSetXml((Set) obj, str, xmlSerializer);
                    return;
                } else if (!(obj instanceof CharSequence)) {
                    if (writeMapCallback == null) {
                        throw new RuntimeException("writeValueXml: unable to write value " + obj);
                    }
                    writeMapCallback.writeUnknownObject(obj, str, xmlSerializer);
                    return;
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
}
