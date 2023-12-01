package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditInput$$XmlAdapter.class */
public class AuditInput$$XmlAdapter implements IXmlAdapter<AuditInput> {
    private HashMap<String, ChildElementBinder<AuditInput>> childElementBinders;

    public AuditInput$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditInput>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Object", new ChildElementBinder<AuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditInput$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditInput auditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditInput.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<AuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditInput$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditInput auditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditInput.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<AuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditInput$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditInput auditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditInput.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditInput fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditInput auditInput = new AuditInput();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditInput;
            }
            if (i == 2) {
                ChildElementBinder<AuditInput> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditInput, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Input" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditInput;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditInput auditInput, String str) throws IOException, XmlPullParserException {
        if (auditInput == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Input";
        }
        xmlSerializer.startTag("", str2);
        if (auditInput.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(auditInput.object));
            xmlSerializer.endTag("", "Object");
        }
        if (auditInput.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(auditInput.url));
            xmlSerializer.endTag("", "Url");
        }
        if (auditInput.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(auditInput.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
