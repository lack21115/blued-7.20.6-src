package com.tencent.cos.xml.model.tag.audit.bean;

import com.google.common.net.HttpHeaders;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditOcrLocation$$XmlAdapter.class */
public class AuditOcrLocation$$XmlAdapter implements IXmlAdapter<AuditOcrLocation> {
    private HashMap<String, ChildElementBinder<AuditOcrLocation>> childElementBinders;

    public AuditOcrLocation$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditOcrLocation>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("X", new ChildElementBinder<AuditOcrLocation>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrLocation$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrLocation.x = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Y", new ChildElementBinder<AuditOcrLocation>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrLocation$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrLocation.y = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Height", new ChildElementBinder<AuditOcrLocation>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrLocation$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrLocation.height = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Width", new ChildElementBinder<AuditOcrLocation>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrLocation$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrLocation.width = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Rotate", new ChildElementBinder<AuditOcrLocation>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrLocation$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrLocation.rotate = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditOcrLocation fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditOcrLocation auditOcrLocation = new AuditOcrLocation();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditOcrLocation;
            }
            if (i == 2) {
                ChildElementBinder<AuditOcrLocation> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditOcrLocation, null);
                }
            } else if (i == 3) {
                if ((str == null ? HttpHeaders.LOCATION : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditOcrLocation;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditOcrLocation auditOcrLocation, String str) throws IOException, XmlPullParserException {
        if (auditOcrLocation == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = HttpHeaders.LOCATION;
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "X");
        xmlSerializer.text(String.valueOf(auditOcrLocation.x));
        xmlSerializer.endTag("", "X");
        xmlSerializer.startTag("", "Y");
        xmlSerializer.text(String.valueOf(auditOcrLocation.y));
        xmlSerializer.endTag("", "Y");
        xmlSerializer.startTag("", "Height");
        xmlSerializer.text(String.valueOf(auditOcrLocation.height));
        xmlSerializer.endTag("", "Height");
        xmlSerializer.startTag("", "Width");
        xmlSerializer.text(String.valueOf(auditOcrLocation.width));
        xmlSerializer.endTag("", "Width");
        xmlSerializer.startTag("", "Rotate");
        xmlSerializer.text(String.valueOf(auditOcrLocation.rotate));
        xmlSerializer.endTag("", "Rotate");
        xmlSerializer.endTag("", str2);
    }
}
