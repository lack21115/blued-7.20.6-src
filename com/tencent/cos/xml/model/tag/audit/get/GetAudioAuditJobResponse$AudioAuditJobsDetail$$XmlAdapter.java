package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.class */
public class GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter implements IXmlAdapter<GetAudioAuditJobResponse.AudioAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>> childElementBinders;

    public GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Object", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("AudioText", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.audioText = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                audioAuditJobsDetail.pornInfo = (GetAudioAuditJobResponse.AudioAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                audioAuditJobsDetail.terrorismInfo = (GetAudioAuditJobResponse.AudioAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                audioAuditJobsDetail.politicsInfo = (GetAudioAuditJobResponse.AudioAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                audioAuditJobsDetail.adsInfo = (GetAudioAuditJobResponse.AudioAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo.class, "AdsInfo");
            }
        });
        this.childElementBinders.put("Section", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                if (audioAuditJobsDetail.section == null) {
                    audioAuditJobsDetail.section = new ArrayList();
                }
                audioAuditJobsDetail.section.add(QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioSection.class, "Section"));
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditJobsDetail$$XmlAdapter.16
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetAudioAuditJobResponse.AudioAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail = new GetAudioAuditJobResponse.AudioAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return audioAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<GetAudioAuditJobResponse.AudioAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, audioAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return audioAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetAudioAuditJobResponse.AudioAuditJobsDetail audioAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (audioAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        if (audioAuditJobsDetail.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.object));
            xmlSerializer.endTag("", "Object");
        }
        if (audioAuditJobsDetail.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.url));
            xmlSerializer.endTag("", "Url");
        }
        if (audioAuditJobsDetail.audioText != null) {
            xmlSerializer.startTag("", "AudioText");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.audioText));
            xmlSerializer.endTag("", "AudioText");
        }
        if (audioAuditJobsDetail.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioAuditJobsDetail.pornInfo, "PornInfo");
        }
        if (audioAuditJobsDetail.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioAuditJobsDetail.terrorismInfo, "TerrorismInfo");
        }
        if (audioAuditJobsDetail.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioAuditJobsDetail.politicsInfo, "PoliticsInfo");
        }
        if (audioAuditJobsDetail.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, audioAuditJobsDetail.adsInfo, "AdsInfo");
        }
        xmlSerializer.startTag("", "Section");
        if (audioAuditJobsDetail.section != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= audioAuditJobsDetail.section.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, audioAuditJobsDetail.section.get(i2), "Section");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Section");
        if (audioAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (audioAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (audioAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (audioAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (audioAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (audioAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (audioAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (audioAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(audioAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
