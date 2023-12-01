package com.tencent.cos.xml.model.tag.audit.bean;

import com.google.common.net.HttpHeaders;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditOcrResults$$XmlAdapter.class */
public class AuditOcrResults$$XmlAdapter implements IXmlAdapter<AuditOcrResults> {
    private HashMap<String, ChildElementBinder<AuditOcrResults>> childElementBinders;

    public AuditOcrResults$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditOcrResults>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Text", new ChildElementBinder<AuditOcrResults>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrResults auditOcrResults, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrResults.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Keywords", new ChildElementBinder<AuditOcrResults>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrResults auditOcrResults, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditOcrResults.keywords = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<AuditOcrResults>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditOcrResults auditOcrResults, String str) throws IOException, XmlPullParserException {
                auditOcrResults.location = (AuditOcrLocation) QCloudXml.fromXml(xmlPullParser, AuditOcrLocation.class, HttpHeaders.LOCATION);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditOcrResults fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditOcrResults auditOcrResults = new AuditOcrResults();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditOcrResults;
            }
            if (i == 2) {
                ChildElementBinder<AuditOcrResults> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditOcrResults, null);
                }
            } else if (i == 3) {
                if ((str == null ? "OcrResults" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditOcrResults;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditOcrResults auditOcrResults, String str) throws IOException, XmlPullParserException {
        if (auditOcrResults == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "OcrResults";
        }
        xmlSerializer.startTag("", str2);
        if (auditOcrResults.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(auditOcrResults.text));
            xmlSerializer.endTag("", "Text");
        }
        if (auditOcrResults.keywords != null) {
            xmlSerializer.startTag("", "Keywords");
            xmlSerializer.text(String.valueOf(auditOcrResults.keywords));
            xmlSerializer.endTag("", "Keywords");
        }
        if (auditOcrResults.location != null) {
            QCloudXml.toXml(xmlSerializer, auditOcrResults.location, HttpHeaders.LOCATION);
        }
        xmlSerializer.endTag("", str2);
    }
}
