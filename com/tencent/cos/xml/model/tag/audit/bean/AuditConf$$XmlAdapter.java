package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditConf$$XmlAdapter.class */
public class AuditConf$$XmlAdapter implements IXmlAdapter<AuditConf> {
    private HashMap<String, ChildElementBinder<AuditConf>> childElementBinders;

    public AuditConf$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditConf>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("DetectType", new ChildElementBinder<AuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditConf$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditConf auditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditConf.detectType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Callback", new ChildElementBinder<AuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditConf$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditConf auditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditConf.callback = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BizType", new ChildElementBinder<AuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditConf$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditConf auditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditConf.bizType = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditConf fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditConf auditConf = new AuditConf();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditConf;
            }
            if (i == 2) {
                ChildElementBinder<AuditConf> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditConf, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Conf" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditConf;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditConf auditConf, String str) throws IOException, XmlPullParserException {
        if (auditConf == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Conf";
        }
        xmlSerializer.startTag("", str2);
        if (auditConf.detectType != null) {
            xmlSerializer.startTag("", "DetectType");
            xmlSerializer.text(String.valueOf(auditConf.detectType));
            xmlSerializer.endTag("", "DetectType");
        }
        if (auditConf.callback != null) {
            xmlSerializer.startTag("", "Callback");
            xmlSerializer.text(String.valueOf(auditConf.callback));
            xmlSerializer.endTag("", "Callback");
        }
        if (auditConf.bizType != null) {
            xmlSerializer.startTag("", "BizType");
            xmlSerializer.text(String.valueOf(auditConf.bizType));
            xmlSerializer.endTag("", "BizType");
        }
        xmlSerializer.endTag("", str2);
    }
}
