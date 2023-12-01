package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.class */
public class GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter implements IXmlAdapter<GetVideoAuditJobResponse.VideoAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>> childElementBinders;

    public GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Object", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SnapshotCount", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.snapshotCount = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                videoAuditJobsDetail.pornInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                videoAuditJobsDetail.terrorismInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                videoAuditJobsDetail.politicsInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                videoAuditJobsDetail.adsInfo = (AuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, AuditScenarioInfo.class, "AdsInfo");
            }
        });
        this.childElementBinders.put("Snapshot", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.8
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                if (videoAuditJobsDetail.snapshot == null) {
                    videoAuditJobsDetail.snapshot = new ArrayList();
                }
                videoAuditJobsDetail.snapshot.add(QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.Snapshot.class, "Snapshot"));
            }
        });
        this.childElementBinders.put("AudioSection", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                if (videoAuditJobsDetail.audioSection == null) {
                    videoAuditJobsDetail.audioSection = new ArrayList();
                }
                videoAuditJobsDetail.audioSection.add(QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioSection.class, "AudioSection"));
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.16
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$VideoAuditJobsDetail$$XmlAdapter.17
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetVideoAuditJobResponse.VideoAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail = new GetVideoAuditJobResponse.VideoAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return videoAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<GetVideoAuditJobResponse.VideoAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, videoAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "VideoAuditJobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return videoAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetVideoAuditJobResponse.VideoAuditJobsDetail videoAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (videoAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "VideoAuditJobsDetail";
        }
        xmlSerializer.startTag("", str2);
        if (videoAuditJobsDetail.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.object));
            xmlSerializer.endTag("", "Object");
        }
        if (videoAuditJobsDetail.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.url));
            xmlSerializer.endTag("", "Url");
        }
        if (videoAuditJobsDetail.snapshotCount != null) {
            xmlSerializer.startTag("", "SnapshotCount");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.snapshotCount));
            xmlSerializer.endTag("", "SnapshotCount");
        }
        if (videoAuditJobsDetail.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.pornInfo, "PornInfo");
        }
        if (videoAuditJobsDetail.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.terrorismInfo, "TerrorismInfo");
        }
        if (videoAuditJobsDetail.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.politicsInfo, "PoliticsInfo");
        }
        if (videoAuditJobsDetail.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.adsInfo, "AdsInfo");
        }
        xmlSerializer.startTag("", "Snapshot");
        if (videoAuditJobsDetail.snapshot != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= videoAuditJobsDetail.snapshot.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.snapshot.get(i2), "Snapshot");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Snapshot");
        xmlSerializer.startTag("", "AudioSection");
        if (videoAuditJobsDetail.audioSection != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= videoAuditJobsDetail.audioSection.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, videoAuditJobsDetail.audioSection.get(i4), "AudioSection");
                i3 = i4 + 1;
            }
        }
        xmlSerializer.endTag("", "AudioSection");
        if (videoAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (videoAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (videoAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (videoAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (videoAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (videoAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (videoAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (videoAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(videoAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
