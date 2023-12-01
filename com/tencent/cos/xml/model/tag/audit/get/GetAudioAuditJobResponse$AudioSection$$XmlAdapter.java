package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioSection$$XmlAdapter.class */
public class GetAudioAuditJobResponse$AudioSection$$XmlAdapter implements IXmlAdapter<GetAudioAuditJobResponse.AudioSection> {
    private HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioSection>> childElementBinders;

    public GetAudioAuditJobResponse$AudioSection$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioSection>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Url", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OffsetTime", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.offsetTime = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Duration", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.duration = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioSection.result = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                audioSection.pornInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                audioSection.terrorismInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                audioSection.politicsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioSection>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioSection$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
                audioSection.adsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetAudioAuditJobResponse.AudioSection fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetAudioAuditJobResponse.AudioSection audioSection = new GetAudioAuditJobResponse.AudioSection();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return audioSection;
            }
            if (i == 2) {
                ChildElementBinder<GetAudioAuditJobResponse.AudioSection> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, audioSection, null);
                }
            } else if (i == 3) {
                if ((str == null ? "AudioSection" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return audioSection;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetAudioAuditJobResponse.AudioSection audioSection, String str) throws IOException, XmlPullParserException {
        if (audioSection == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "AudioSection";
        }
        xmlSerializer.startTag("", str2);
        if (audioSection.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(audioSection.url));
            xmlSerializer.endTag("", "Url");
        }
        if (audioSection.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(audioSection.text));
            xmlSerializer.endTag("", "Text");
        }
        xmlSerializer.startTag("", "OffsetTime");
        xmlSerializer.text(String.valueOf(audioSection.offsetTime));
        xmlSerializer.endTag("", "OffsetTime");
        xmlSerializer.startTag("", "Duration");
        xmlSerializer.text(String.valueOf(audioSection.duration));
        xmlSerializer.endTag("", "Duration");
        if (audioSection.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(audioSection.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "Result");
        xmlSerializer.text(String.valueOf(audioSection.result));
        xmlSerializer.endTag("", "Result");
        if (audioSection.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioSection.pornInfo, "PornInfo");
        }
        if (audioSection.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioSection.terrorismInfo, "TerrorismInfo");
        }
        if (audioSection.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioSection.politicsInfo, "PoliticsInfo");
        }
        if (audioSection.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioSection.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
