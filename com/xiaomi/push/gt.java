package com.xiaomi.push;

import android.media.TtmlUtils;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import com.xiaomi.push.gj;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.service.bg;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.XMLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gt.class */
public class gt {

    /* renamed from: a  reason: collision with root package name */
    private static XmlPullParser f41456a;

    public static gi a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m11826a = gs.a().m11826a("all", "xm:chat");
        if (m11826a == null || !(m11826a instanceof com.xiaomi.push.service.k)) {
            return null;
        }
        return ((com.xiaomi.push.service.k) m11826a).b(xmlPullParser);
    }

    public static gj a(XmlPullParser xmlPullParser, fu fuVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        gj.a a2 = gj.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= xmlPullParser.getAttributeCount()) {
                break;
            }
            String attributeName = xmlPullParser.getAttributeName(i2);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
            i = i2 + 1;
        }
        gv gvVar = null;
        gp gpVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    gpVar = m11831a(xmlPullParser);
                } else {
                    gvVar = new gj();
                    gvVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        gv gvVar2 = gvVar;
        if (gvVar == null) {
            if (gj.a.f41439a == a2 || gj.a.b == a2) {
                gu guVar = new gu();
                guVar.k(attributeValue);
                guVar.m(attributeValue3);
                guVar.n(attributeValue2);
                guVar.a(gj.a.d);
                guVar.l(attributeValue4);
                guVar.a(new gp(gp.a.e));
                fuVar.a(guVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            gvVar2 = new gv();
        }
        gvVar2.k(attributeValue);
        gvVar2.m(attributeValue2);
        gvVar2.l(attributeValue4);
        gvVar2.n(attributeValue3);
        gvVar2.a(a2);
        gvVar2.a(gpVar);
        gvVar2.a(hashMap);
        return gvVar2;
    }

    public static gl a(XmlPullParser xmlPullParser) {
        String str;
        String str2;
        boolean z;
        boolean z2 = false;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            bg.b a2 = com.xiaomi.push.service.bg.a().a(attributeValue, attributeValue4);
            bg.b bVar = a2;
            if (a2 == null) {
                bVar = com.xiaomi.push.service.bg.a().a(attributeValue, attributeValue3);
            }
            if (bVar != null) {
                gl glVar = null;
                while (!z2) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new gf("error while receiving a encrypted message with wrong format");
                        }
                        if (xmlPullParser.next() != 4) {
                            throw new gf("error while receiving a encrypted message with wrong format");
                        }
                        String text = xmlPullParser.getText();
                        if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                            gk gkVar = new gk();
                            gkVar.l(attributeValue);
                            gkVar.b(true);
                            gkVar.n(attributeValue3);
                            gkVar.m(attributeValue4);
                            gkVar.k(attributeValue2);
                            gkVar.f(attributeValue5);
                            gi giVar = new gi("s", null, null, null);
                            giVar.m11812a(text);
                            gkVar.a(giVar);
                            return gkVar;
                        }
                        a(com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(bVar.h, attributeValue2), text));
                        f41456a.next();
                        glVar = a(f41456a);
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z2 = true;
                    }
                }
                if (glVar != null) {
                    return glVar;
                }
                throw new gf("error while receiving a encrypted message with wrong format");
            }
            throw new gf("the channel id is wrong while receiving a encrypted message");
        }
        gk gkVar2 = new gk();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        String str3 = attributeValue6;
        if (attributeValue6 == null) {
            str3 = "ID_NOT_AVAILABLE";
        }
        gkVar2.k(str3);
        gkVar2.m(xmlPullParser.getAttributeValue("", "to"));
        gkVar2.n(xmlPullParser.getAttributeValue("", "from"));
        gkVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        gkVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                gkVar2.b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                gkVar2.c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                gkVar2.d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                gkVar2.e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        gkVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        gkVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            gl.q();
            str2 = null;
            z = false;
        } else {
            gkVar2.j(b);
            z = false;
            str2 = null;
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                String str4 = namespace;
                if (TextUtils.isEmpty(namespace)) {
                    str4 = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    gkVar2.g(m11832a(xmlPullParser));
                } else if (name.equals(TtmlUtils.TAG_BODY)) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m11832a = m11832a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        gkVar2.h(m11832a);
                    } else {
                        gkVar2.a(m11832a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    gkVar2.a(m11831a(xmlPullParser));
                } else {
                    gkVar2.a(a(name, str4, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        gkVar2.i(str2);
        return gkVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gn m11829a(XmlPullParser xmlPullParser) {
        gn.b bVar = gn.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        gn.b bVar2 = bVar;
        if (attributeValue != null) {
            bVar2 = bVar;
            if (!attributeValue.equals("")) {
                try {
                    bVar2 = gn.b.valueOf(attributeValue);
                } catch (IllegalArgumentException e) {
                    System.err.println("Found invalid presence type ".concat(String.valueOf(attributeValue)));
                    bVar2 = bVar;
                }
            }
        }
        gn gnVar = new gn(bVar2);
        gnVar.m(xmlPullParser.getAttributeValue("", "to"));
        gnVar.n(xmlPullParser.getAttributeValue("", "from"));
        gnVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        String str = attributeValue2;
        if (attributeValue2 == null) {
            str = "ID_NOT_AVAILABLE";
        }
        gnVar.k(str);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    gnVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        gnVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        gnVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        gnVar.a(gn.a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode ".concat(String.valueOf(nextText)));
                    }
                } else if (name.equals("error")) {
                    gnVar.a(m11831a(xmlPullParser));
                } else {
                    gnVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY)) {
                z = true;
            }
        }
        return gnVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static go m11830a(XmlPullParser xmlPullParser) {
        go goVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                goVar = new go(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return goVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gp m11831a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = "-1";
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= xmlPullParser.getAttributeCount()) {
                break;
            }
            if (xmlPullParser.getAttributeName(i2).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i2).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i2).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
            i = i2 + 1;
        }
        String str4 = null;
        String str5 = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        if (str3 == null) {
            str3 = com.anythink.expressad.d.a.b.dO;
        }
        return new gp(Integer.parseInt(str), str3, str2, str4, str5, arrayList);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m11832a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            String str2 = str;
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str2;
            }
            str = str2 + xmlPullParser.getText();
        }
    }

    private static void a(byte[] bArr) {
        if (f41456a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f41456a = newPullParser;
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f41456a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    private static String b(XmlPullParser xmlPullParser) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= xmlPullParser.getAttributeCount()) {
                return null;
            }
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && XMLConstants.XML_NS_PREFIX.equals(xmlPullParser.getAttributePrefix(i)))) {
                break;
            }
            i2 = i + 1;
        }
        return xmlPullParser.getAttributeValue(i);
    }
}
