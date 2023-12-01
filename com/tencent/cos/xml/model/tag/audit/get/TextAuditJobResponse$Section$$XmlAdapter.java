package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/TextAuditJobResponse$Section$$XmlAdapter.class */
public class TextAuditJobResponse$Section$$XmlAdapter implements IXmlAdapter<TextAuditJobResponse.Section> {
    private HashMap<String, ChildElementBinder<TextAuditJobResponse.Section>> childElementBinders;

    public TextAuditJobResponse$Section$$XmlAdapter() {
        HashMap<String, ChildElementBinder<TextAuditJobResponse.Section>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("StartByte", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                section.startByte = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                section.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                section.result = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("IllegalInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.illegalInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "IllegalInfo");
            }
        });
        this.childElementBinders.put("AbuseInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.abuseInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "AbuseInfo");
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.pornInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.terrorismInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.politicsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<TextAuditJobResponse.Section>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$Section$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
                section.adsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public TextAuditJobResponse.Section fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        TextAuditJobResponse.Section section = new TextAuditJobResponse.Section();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return section;
            }
            if (i == 2) {
                ChildElementBinder<TextAuditJobResponse.Section> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, section, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Section" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return section;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, TextAuditJobResponse.Section section, String str) throws IOException, XmlPullParserException {
        if (section == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Section";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "StartByte");
        xmlSerializer.text(String.valueOf(section.startByte));
        xmlSerializer.endTag("", "StartByte");
        if (section.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(section.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "Result");
        xmlSerializer.text(String.valueOf(section.result));
        xmlSerializer.endTag("", "Result");
        if (section.illegalInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.illegalInfo, "IllegalInfo");
        }
        if (section.abuseInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.abuseInfo, "AbuseInfo");
        }
        if (section.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.pornInfo, "PornInfo");
        }
        if (section.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.terrorismInfo, "TerrorismInfo");
        }
        if (section.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.politicsInfo, "PoliticsInfo");
        }
        if (section.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, section.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
