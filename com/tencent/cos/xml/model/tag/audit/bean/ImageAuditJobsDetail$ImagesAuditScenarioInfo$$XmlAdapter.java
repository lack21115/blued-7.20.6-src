package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.class */
public class ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<ImageAuditJobsDetail.ImagesAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>> childElementBinders;

    public ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.code = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Msg", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.msg = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditScenarioInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (imagesAuditScenarioInfo.ocrResults == null) {
                    imagesAuditScenarioInfo.ocrResults = new ArrayList();
                }
                imagesAuditScenarioInfo.ocrResults.add(QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults"));
            }
        });
        this.childElementBinders.put("ObjectResults", new ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail$ImagesAuditScenarioInfo$$XmlAdapter.8
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (imagesAuditScenarioInfo.objectResults == null) {
                    imagesAuditScenarioInfo.objectResults = new ArrayList();
                }
                imagesAuditScenarioInfo.objectResults.add(QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.ObjectResults.class, "ObjectResults"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ImageAuditJobsDetail.ImagesAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo = new ImageAuditJobsDetail.ImagesAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imagesAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<ImageAuditJobsDetail.ImagesAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imagesAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ImagesAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imagesAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ImageAuditJobsDetail.ImagesAuditScenarioInfo imagesAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (imagesAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ImagesAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Code");
        xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.code));
        xmlSerializer.endTag("", "Code");
        if (imagesAuditScenarioInfo.msg != null) {
            xmlSerializer.startTag("", "Msg");
            xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.msg));
            xmlSerializer.endTag("", "Msg");
        }
        if (imagesAuditScenarioInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        if (imagesAuditScenarioInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(imagesAuditScenarioInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        xmlSerializer.startTag("", "OcrResults");
        if (imagesAuditScenarioInfo.ocrResults != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= imagesAuditScenarioInfo.ocrResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, imagesAuditScenarioInfo.ocrResults.get(i2), "OcrResults");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "OcrResults");
        xmlSerializer.startTag("", "ObjectResults");
        if (imagesAuditScenarioInfo.objectResults != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= imagesAuditScenarioInfo.objectResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, imagesAuditScenarioInfo.objectResults.get(i4), "ObjectResults");
                i3 = i4 + 1;
            }
        }
        xmlSerializer.endTag("", "ObjectResults");
        xmlSerializer.endTag("", str2);
    }
}
