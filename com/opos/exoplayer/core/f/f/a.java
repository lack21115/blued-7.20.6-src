package com.opos.exoplayer.core.f.f;

import android.media.TtmlUtils;
import android.text.Layout;
import android.text.style.SuggestionSpan;
import com.google.common.net.HttpHeaders;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.i.v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/f/a.class */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11687a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11688c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C0494a e = new C0494a(30.0f, 1, 1);
    private final XmlPullParserFactory f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/f/a$a.class */
    public static final class C0494a {

        /* renamed from: a  reason: collision with root package name */
        final float f11689a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f11690c;

        C0494a(float f, int i, int i2) {
            this.f11689a = f;
            this.b = i;
            this.f11690c = i2;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x011b, code lost:
        if (r0.equals("s") != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.lang.String r9, com.opos.exoplayer.core.f.f.a.C0494a r10) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.f.a.a(java.lang.String, com.opos.exoplayer.core.f.f.a$a):long");
    }

    private C0494a a(XmlPullParser xmlPullParser) {
        String[] split;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(" ").length != 2) {
                throw new com.opos.exoplayer.core.f.f("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
        }
        int i = e.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = e.f11690c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new C0494a(parseInt * f, i, i2);
    }

    private b a(b bVar) {
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b();
        }
        return bVar2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private b a(XmlPullParser xmlPullParser, b bVar) {
        boolean z;
        StringBuilder sb;
        String str;
        boolean z2;
        b a2;
        Layout.Alignment alignment;
        boolean z3;
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            b bVar2 = bVar;
            if (i2 >= attributeCount) {
                return bVar2;
            }
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    bVar = bVar2;
                    if ("style".equals(xmlPullParser.getName())) {
                        bVar = a(bVar2).b(attributeValue);
                        continue;
                    }
                    i = i2 + 1;
                case true:
                    bVar = a(bVar2);
                    try {
                        bVar.b(com.opos.exoplayer.core.i.d.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        sb = new StringBuilder();
                        str = "Failed parsing background value: ";
                        break;
                    }
                    i = i2 + 1;
                case true:
                    bVar = a(bVar2);
                    try {
                        bVar.a(com.opos.exoplayer.core.i.d.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException e3) {
                        sb = new StringBuilder();
                        str = "Failed parsing color value: ";
                        break;
                    }
                    i = i2 + 1;
                case true:
                    bVar = a(bVar2).a(attributeValue);
                    continue;
                    i = i2 + 1;
                case true:
                    bVar = bVar2;
                    try {
                        b a3 = a(bVar2);
                        a(attributeValue, a3);
                        bVar = a3;
                        continue;
                    } catch (com.opos.exoplayer.core.f.f e4) {
                        sb = new StringBuilder();
                        str = "Failed parsing fontSize value: ";
                        break;
                    }
                    i = i2 + 1;
                case true:
                    bVar = a(bVar2).c("bold".equalsIgnoreCase(attributeValue));
                    continue;
                    i = i2 + 1;
                case true:
                    bVar = a(bVar2).d("italic".equalsIgnoreCase(attributeValue));
                    continue;
                    i = i2 + 1;
                case true:
                    String d2 = u.d(attributeValue);
                    switch (d2.hashCode()) {
                        case -1364013995:
                            z2 = true;
                            if (d2.equals("center")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 100571:
                            z2 = true;
                            if (d2.equals("end")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 3317767:
                            z2 = true;
                            if (d2.equals("left")) {
                                z2 = false;
                                break;
                            }
                            break;
                        case 108511772:
                            z2 = true;
                            if (d2.equals("right")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 109757538:
                            z2 = true;
                            if (d2.equals("start")) {
                                z2 = true;
                                break;
                            }
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                    if (!z2 || z2) {
                        a2 = a(bVar2);
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    } else if (z2 || z2) {
                        a2 = a(bVar2);
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else if (!z2) {
                        bVar = bVar2;
                        continue;
                        i = i2 + 1;
                    } else {
                        a2 = a(bVar2);
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    }
                    bVar = a2.a(alignment);
                    i = i2 + 1;
                    break;
                case true:
                    String d3 = u.d(attributeValue);
                    switch (d3.hashCode()) {
                        case -1461280213:
                            z3 = true;
                            if (d3.equals("nounderline")) {
                                z3 = true;
                                break;
                            }
                            break;
                        case -1026963764:
                            z3 = true;
                            if (d3.equals("underline")) {
                                z3 = true;
                                break;
                            }
                            break;
                        case 913457136:
                            z3 = true;
                            if (d3.equals("nolinethrough")) {
                                z3 = true;
                                break;
                            }
                            break;
                        case 1679736913:
                            z3 = true;
                            if (d3.equals("linethrough")) {
                                z3 = false;
                                break;
                            }
                            break;
                        default:
                            z3 = true;
                            break;
                    }
                    if (!z3) {
                        bVar = a(bVar2).a(true);
                    } else if (z3) {
                        bVar = a(bVar2).a(false);
                    } else if (z3) {
                        bVar = a(bVar2).b(true);
                    } else if (!z3) {
                        bVar = bVar2;
                        continue;
                    } else {
                        bVar = a(bVar2).b(false);
                    }
                    i = i2 + 1;
                default:
                    bVar = bVar2;
                    continue;
                    i = i2 + 1;
            }
            sb.append(str);
            sb.append(attributeValue);
            com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private c a(XmlPullParser xmlPullParser, c cVar, Map<String, d> map, C0494a c0494a) {
        long j;
        long j2;
        long j3;
        boolean z;
        long a2;
        long j4;
        long j5;
        String str;
        String[] strArr;
        int attributeCount = xmlPullParser.getAttributeCount();
        b a3 = a(xmlPullParser, (b) null);
        String[] strArr2 = null;
        String str2 = "";
        int i = 0;
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        long j8 = com.anythink.expressad.exoplayer.b.b;
        while (true) {
            long j9 = j8;
            if (i >= attributeCount) {
                if (cVar != null) {
                    j2 = j6;
                    j = j7;
                    if (cVar.d != com.anythink.expressad.exoplayer.b.b) {
                        long j10 = j6;
                        if (j6 != com.anythink.expressad.exoplayer.b.b) {
                            j10 = j6 + cVar.d;
                        }
                        j2 = j10;
                        j = j7;
                        if (j7 != com.anythink.expressad.exoplayer.b.b) {
                            j = j7 + cVar.d;
                            j2 = j10;
                        }
                    }
                } else {
                    j = j7;
                    j2 = j6;
                }
                if (j == com.anythink.expressad.exoplayer.b.b) {
                    if (j9 != com.anythink.expressad.exoplayer.b.b) {
                        j3 = j2 + j9;
                    } else if (cVar != null && cVar.e != com.anythink.expressad.exoplayer.b.b) {
                        j3 = cVar.e;
                    }
                    return c.a(xmlPullParser.getName(), j2, j3, a3, strArr2, str2);
                }
                j3 = j;
                return c.a(xmlPullParser.getName(), j2, j3, a3, strArr2, str2);
            }
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals(TtmlUtils.TAG_REGION)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 99841:
                    if (attributeName.equals(TtmlUtils.ATTR_DURATION)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                a2 = a(attributeValue, c0494a);
                j4 = j9;
                j5 = j7;
                str = str2;
                strArr = strArr2;
            } else if (z) {
                j5 = a(attributeValue, c0494a);
                a2 = j6;
                strArr = strArr2;
                str = str2;
                j4 = j9;
            } else if (z) {
                j4 = a(attributeValue, c0494a);
                a2 = j6;
                strArr = strArr2;
                str = str2;
                j5 = j7;
            } else if (z) {
                String[] a4 = a(attributeValue);
                a2 = j6;
                strArr = strArr2;
                str = str2;
                j5 = j7;
                j4 = j9;
                if (a4.length > 0) {
                    strArr = a4;
                    a2 = j6;
                    str = str2;
                    j5 = j7;
                    j4 = j9;
                }
            } else if (!z) {
                a2 = j6;
                strArr = strArr2;
                str = str2;
                j5 = j7;
                j4 = j9;
            } else {
                a2 = j6;
                strArr = strArr2;
                str = str2;
                j5 = j7;
                j4 = j9;
                if (map.containsKey(attributeValue)) {
                    str = attributeValue;
                    a2 = j6;
                    strArr = strArr2;
                    j5 = j7;
                    j4 = j9;
                }
            }
            i++;
            j6 = a2;
            strArr2 = strArr;
            str2 = str;
            j7 = j5;
            j8 = j4;
        }
    }

    private Map<String, b> a(XmlPullParser xmlPullParser, Map<String, b> map, Map<String, d> map2) {
        d b2;
        do {
            xmlPullParser.next();
            if (v.b(xmlPullParser, "style")) {
                String c2 = v.c(xmlPullParser, "style");
                b a2 = a(xmlPullParser, new b());
                if (c2 != null) {
                    String[] a3 = a(c2);
                    int length = a3.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        a2.a(map.get(a3[i2]));
                        i = i2 + 1;
                    }
                }
                if (a2.i() != null) {
                    map.put(a2.i(), a2);
                }
            } else if (v.b(xmlPullParser, TtmlUtils.TAG_REGION) && (b2 = b(xmlPullParser)) != null) {
                map2.put(b2.f11695a, b2);
            }
        } while (!v.a(xmlPullParser, "head"));
        return map;
    }

    private static void a(String str, b bVar) {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f11688c.matcher(str);
        } else if (split.length != 2) {
            throw new com.opos.exoplayer.core.f.f("Invalid number of entries for fontSize: " + split.length + ".");
        } else {
            matcher = f11688c.matcher(split[1]);
            com.opos.cmn.an.f.a.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new com.opos.exoplayer.core.f.f("Invalid expression for fontSize: '" + str + "'.");
        }
        String group = matcher.group(3);
        boolean z = true;
        int hashCode = group.hashCode();
        if (hashCode != 37) {
            if (hashCode != 3240) {
                if (hashCode == 3592 && group.equals("px")) {
                    z = false;
                }
            } else if (group.equals("em")) {
                z = true;
            }
        } else if (group.equals("%")) {
            z = true;
        }
        if (!z) {
            bVar.c(1);
        } else if (z) {
            bVar.c(2);
        } else if (!z) {
            throw new com.opos.exoplayer.core.f.f("Invalid unit for fontSize: '" + group + "'.");
        } else {
            bVar.c(3);
        }
        bVar.a(Float.valueOf(matcher.group(1)).floatValue());
    }

    private String[] a(String str) {
        return str.split("\\s+");
    }

    private d b(XmlPullParser xmlPullParser) {
        String str;
        StringBuilder sb;
        String str2;
        int i;
        String c2 = v.c(xmlPullParser, "id");
        if (c2 == null) {
            return null;
        }
        String c3 = v.c(xmlPullParser, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        if (c3 != null) {
            Matcher matcher = d.matcher(c3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String c4 = v.c(xmlPullParser, "extent");
                    if (c4 != null) {
                        Matcher matcher2 = d.matcher(c4);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String c5 = v.c(xmlPullParser, "displayAlign");
                                if (c5 != null) {
                                    String d2 = u.d(c5);
                                    boolean z = true;
                                    int hashCode = d2.hashCode();
                                    if (hashCode != -1364013995) {
                                        if (hashCode == 92734940 && d2.equals(SuggestionSpan.SUGGESTION_SPAN_PICKED_AFTER)) {
                                            z = true;
                                        }
                                    } else if (d2.equals("center")) {
                                        z = false;
                                    }
                                    if (!z) {
                                        parseFloat2 += parseFloat4 / 2.0f;
                                        i = 1;
                                    } else if (z) {
                                        parseFloat2 += parseFloat4;
                                        i = 2;
                                    }
                                    return new d(c2, parseFloat, parseFloat2, 0, i, parseFloat3);
                                }
                                i = 0;
                                return new d(c2, parseFloat, parseFloat2, 0, i, parseFloat3);
                            } catch (NumberFormatException e2) {
                                sb = new StringBuilder();
                                str2 = "Ignoring region with malformed extent: ";
                            }
                        } else {
                            sb = new StringBuilder();
                            str2 = "Ignoring region with unsupported extent: ";
                        }
                    } else {
                        str = "Ignoring region without an extent";
                    }
                } catch (NumberFormatException e3) {
                    sb = new StringBuilder();
                    str2 = "Ignoring region with malformed origin: ";
                }
            } else {
                sb = new StringBuilder();
                str2 = "Ignoring region with unsupported origin: ";
            }
            sb.append(str2);
            sb.append(c3);
            str = sb.toString();
        } else {
            str = "Ignoring region without an origin";
        }
        com.opos.cmn.an.f.a.c("TtmlDecoder", str);
        return null;
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(TtmlUtils.TAG_BODY) || str.equals(TtmlUtils.TAG_DIV) || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals(TtmlUtils.TAG_STYLING) || str.equals("layout") || str.equals(TtmlUtils.TAG_REGION) || str.equals(TtmlUtils.TAG_METADATA) || str.equals(TtmlUtils.TAG_SMPTE_IMAGE) || str.equals(TtmlUtils.TAG_SMPTE_DATA) || str.equals(TtmlUtils.TAG_SMPTE_INFORMATION);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public f a(byte[] bArr, int i, boolean z) {
        C0494a c0494a;
        f fVar;
        int i2;
        try {
            XmlPullParser newPullParser = this.f.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            f fVar2 = null;
            hashMap2.put("", new d(null));
            int i3 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            C0494a c0494a2 = e;
            while (eventType != 1) {
                c cVar = (c) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0494a2 = a(newPullParser);
                        }
                        if (!b(name)) {
                            com.opos.cmn.an.f.a.a("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if ("head".equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                            c0494a = c0494a2;
                            fVar = fVar2;
                            i2 = i3;
                        } else {
                            try {
                                c a2 = a(newPullParser, cVar, hashMap2, c0494a2);
                                linkedList.addLast(a2);
                                c0494a = c0494a2;
                                fVar = fVar2;
                                i2 = i3;
                                if (cVar != null) {
                                    cVar.a(a2);
                                    c0494a = c0494a2;
                                    fVar = fVar2;
                                    i2 = i3;
                                }
                            } catch (com.opos.exoplayer.core.f.f e2) {
                                com.opos.cmn.an.f.a.c("TtmlDecoder", "Suppressing parser error", e2);
                            }
                        }
                        i2 = i3 + 1;
                        c0494a = c0494a2;
                        fVar = fVar2;
                    } else if (eventType == 4) {
                        cVar.a(c.a(newPullParser.getText()));
                        c0494a = c0494a2;
                        fVar = fVar2;
                        i2 = i3;
                    } else {
                        c0494a = c0494a2;
                        fVar = fVar2;
                        i2 = i3;
                        if (eventType == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                fVar2 = new f((c) linkedList.getLast(), hashMap, hashMap2);
                            }
                            linkedList.removeLast();
                            c0494a = c0494a2;
                            fVar = fVar2;
                            i2 = i3;
                        }
                    }
                } else {
                    if (eventType != 2) {
                        c0494a = c0494a2;
                        fVar = fVar2;
                        i2 = i3;
                        if (eventType == 3) {
                            i2 = i3 - 1;
                            c0494a = c0494a2;
                            fVar = fVar2;
                        }
                    }
                    i2 = i3 + 1;
                    c0494a = c0494a2;
                    fVar = fVar2;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
                c0494a2 = c0494a;
                fVar2 = fVar;
                i3 = i2;
            }
            return fVar2;
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new com.opos.exoplayer.core.f.f("Unable to decode source", e4);
        }
    }
}
