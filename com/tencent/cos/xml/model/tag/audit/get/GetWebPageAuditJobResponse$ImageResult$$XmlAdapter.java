package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$ImageResult$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.ImageResult> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>> childElementBinders;

    public GetWebPageAuditJobResponse$ImageResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Url", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageResult.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageResult.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageResult.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Suggestion", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageResult.suggestion = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                imageResult.pornInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                imageResult.terrorismInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                imageResult.politicsInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResult$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
                imageResult.adsInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.ImageResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.ImageResult imageResult = new GetWebPageAuditJobResponse.ImageResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imageResult;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.ImageResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imageResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ImageResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imageResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.ImageResult imageResult, String str) throws IOException, XmlPullParserException {
        if (imageResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ImageResult";
        }
        xmlSerializer.startTag("", str2);
        if (imageResult.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(imageResult.url));
            xmlSerializer.endTag("", "Url");
        }
        if (imageResult.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(imageResult.text));
            xmlSerializer.endTag("", "Text");
        }
        if (imageResult.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(imageResult.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "Suggestion");
        xmlSerializer.text(String.valueOf(imageResult.suggestion));
        xmlSerializer.endTag("", "Suggestion");
        if (imageResult.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageResult.pornInfo, "PornInfo");
        }
        if (imageResult.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageResult.terrorismInfo, "TerrorismInfo");
        }
        if (imageResult.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageResult.politicsInfo, "PoliticsInfo");
        }
        if (imageResult.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, imageResult.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
