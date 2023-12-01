package com.tencent.cos.xml.model.tag.audit.bean;

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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditScenarioInfo$$XmlAdapter.class */
public class ImageAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<ImageAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<ImageAuditScenarioInfo>> childElementBinders;

    public ImageAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ImageAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<ImageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<ImageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<ImageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageAuditScenarioInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<ImageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$$XmlAdapter.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (imageAuditScenarioInfo.ocrResults == null) {
                    imageAuditScenarioInfo.ocrResults = new ArrayList();
                }
                imageAuditScenarioInfo.ocrResults.add(QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults"));
            }
        });
        this.childElementBinders.put("ObjectResults", new ChildElementBinder<ImageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$$XmlAdapter.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (imageAuditScenarioInfo.objectResults == null) {
                    imageAuditScenarioInfo.objectResults = new ArrayList();
                }
                imageAuditScenarioInfo.objectResults.add(QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.ObjectResults.class, "ObjectResults"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ImageAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ImageAuditScenarioInfo imageAuditScenarioInfo = new ImageAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imageAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<ImageAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imageAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ImageAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imageAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ImageAuditScenarioInfo imageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (imageAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ImageAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(imageAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(imageAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        if (imageAuditScenarioInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(imageAuditScenarioInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        xmlSerializer.startTag("", "OcrResults");
        if (imageAuditScenarioInfo.ocrResults != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= imageAuditScenarioInfo.ocrResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, imageAuditScenarioInfo.ocrResults.get(i2), "OcrResults");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "OcrResults");
        xmlSerializer.startTag("", "ObjectResults");
        if (imageAuditScenarioInfo.objectResults != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= imageAuditScenarioInfo.objectResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, imageAuditScenarioInfo.objectResults.get(i4), "ObjectResults");
                i3 = i4 + 1;
            }
        }
        xmlSerializer.endTag("", "ObjectResults");
        xmlSerializer.endTag("", str2);
    }
}
