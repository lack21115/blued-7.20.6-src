package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditSection$$XmlAdapter.class */
public class AuditSection$$XmlAdapter implements IXmlAdapter<AuditSection> {
    private HashMap<String, ChildElementBinder<AuditSection>> childElementBinders;

    public AuditSection$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditSection>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("PornInfo", new ChildElementBinder<AuditSection>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditSection$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditSection auditSection, String str) throws IOException, XmlPullParserException {
                auditSection.pornInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<AuditSection>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditSection$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditSection auditSection, String str) throws IOException, XmlPullParserException {
                auditSection.terrorismInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<AuditSection>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditSection$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditSection auditSection, String str) throws IOException, XmlPullParserException {
                auditSection.politicsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<AuditSection>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditSection$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditSection auditSection, String str) throws IOException, XmlPullParserException {
                auditSection.adsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditSection fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditSection auditSection = new AuditSection();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditSection;
            }
            if (i == 2) {
                ChildElementBinder<AuditSection> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditSection, null);
                }
            } else if (i == 3) {
                if ((str == null ? "AuditSection" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditSection;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditSection auditSection, String str) throws IOException, XmlPullParserException {
        if (auditSection == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "AuditSection";
        }
        xmlSerializer.startTag("", str2);
        if (auditSection.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, auditSection.pornInfo, "PornInfo");
        }
        if (auditSection.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, auditSection.terrorismInfo, "TerrorismInfo");
        }
        if (auditSection.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, auditSection.politicsInfo, "PoliticsInfo");
        }
        if (auditSection.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, auditSection.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
