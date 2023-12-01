package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditJobsDetail$$XmlAdapter.class */
public class ImageAuditJobsDetail$$XmlAdapter implements IXmlAdapter<ImageAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<ImageAuditJobsDetail>> childElementBinders;

    public ImageAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ImageAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Score", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Object", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CompressionResult", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.compressionResult = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                imageAuditJobsDetail.pornInfo = (ImageAuditJobsDetail.ImagesAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                imageAuditJobsDetail.terrorismInfo = (ImageAuditJobsDetail.ImagesAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                imageAuditJobsDetail.politicsInfo = (ImageAuditJobsDetail.ImagesAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                imageAuditJobsDetail.adsInfo = (ImageAuditJobsDetail.ImagesAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo.class, "AdsInfo");
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.16
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.17
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<ImageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$$XmlAdapter.18
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ImageAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ImageAuditJobsDetail imageAuditJobsDetail = new ImageAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imageAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<ImageAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imageAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imageAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ImageAuditJobsDetail imageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (imageAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(imageAuditJobsDetail.score));
        xmlSerializer.endTag("", "Score");
        if (imageAuditJobsDetail.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        if (imageAuditJobsDetail.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.text));
            xmlSerializer.endTag("", "Text");
        }
        if (imageAuditJobsDetail.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.url));
            xmlSerializer.endTag("", "Url");
        }
        if (imageAuditJobsDetail.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.object));
            xmlSerializer.endTag("", "Object");
        }
        xmlSerializer.startTag("", "CompressionResult");
        xmlSerializer.text(String.valueOf(imageAuditJobsDetail.compressionResult));
        xmlSerializer.endTag("", "CompressionResult");
        if (imageAuditJobsDetail.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageAuditJobsDetail.pornInfo, "PornInfo");
        }
        if (imageAuditJobsDetail.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageAuditJobsDetail.terrorismInfo, "TerrorismInfo");
        }
        if (imageAuditJobsDetail.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageAuditJobsDetail.politicsInfo, "PoliticsInfo");
        }
        if (imageAuditJobsDetail.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageAuditJobsDetail.adsInfo, "AdsInfo");
        }
        if (imageAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (imageAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (imageAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (imageAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (imageAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (imageAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (imageAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (imageAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(imageAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
