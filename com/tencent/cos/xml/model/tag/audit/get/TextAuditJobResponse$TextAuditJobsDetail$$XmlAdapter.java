package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.class */
public class TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter implements IXmlAdapter<TextAuditJobResponse.TextAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>> childElementBinders;

    public TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Content", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.content = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SectionCount", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.sectionCount = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.pornInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.terrorismInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.politicsInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.adsInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "AdsInfo");
            }
        });
        this.childElementBinders.put("IllegalInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.illegalInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "IllegalInfo");
            }
        });
        this.childElementBinders.put("AbuseInfo", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                textAuditJobsDetail.abuseInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "AbuseInfo");
            }
        });
        this.childElementBinders.put("Section", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                if (textAuditJobsDetail.section == null) {
                    textAuditJobsDetail.section = new ArrayList();
                }
                textAuditJobsDetail.section.add(QCloudXml.fromXml(xmlPullParser, TextAuditJobResponse.Section.class, "Section"));
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.16
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$TextAuditJobsDetail$$XmlAdapter.17
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public TextAuditJobResponse.TextAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail = new TextAuditJobResponse.TextAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<TextAuditJobResponse.TextAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, TextAuditJobResponse.TextAuditJobsDetail textAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (textAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        if (textAuditJobsDetail.content != null) {
            xmlSerializer.startTag("", "Content");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.content));
            xmlSerializer.endTag("", "Content");
        }
        xmlSerializer.startTag("", "SectionCount");
        xmlSerializer.text(String.valueOf(textAuditJobsDetail.sectionCount));
        xmlSerializer.endTag("", "SectionCount");
        if (textAuditJobsDetail.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.pornInfo, "PornInfo");
        }
        if (textAuditJobsDetail.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.terrorismInfo, "TerrorismInfo");
        }
        if (textAuditJobsDetail.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.politicsInfo, "PoliticsInfo");
        }
        if (textAuditJobsDetail.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.adsInfo, "AdsInfo");
        }
        if (textAuditJobsDetail.illegalInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.illegalInfo, "IllegalInfo");
        }
        if (textAuditJobsDetail.abuseInfo != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.abuseInfo, "AbuseInfo");
        }
        xmlSerializer.startTag("", "Section");
        if (textAuditJobsDetail.section != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= textAuditJobsDetail.section.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, textAuditJobsDetail.section.get(i2), "Section");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Section");
        if (textAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (textAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (textAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (textAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (textAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (textAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (textAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (textAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(textAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
