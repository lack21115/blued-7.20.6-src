package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$Results$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$Results$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse.Results> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.Results>> childElementBinders;

    public GetDocumentAuditJobResponse$Results$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.Results>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Url", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PageNumber", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.pageNumber = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("SheetNumber", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.sheetNumber = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Suggestion", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                results.suggestion = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                results.pornInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                results.terrorismInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                results.politicsInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Results>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Results$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
                results.adsInfo = (ImageAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse.Results fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse.Results results = new GetDocumentAuditJobResponse.Results();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return results;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse.Results> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, results, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Results" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return results;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse.Results results, String str) throws IOException, XmlPullParserException {
        if (results == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Results";
        }
        xmlSerializer.startTag("", str2);
        if (results.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(results.url));
            xmlSerializer.endTag("", "Url");
        }
        if (results.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(results.text));
            xmlSerializer.endTag("", "Text");
        }
        xmlSerializer.startTag("", "PageNumber");
        xmlSerializer.text(String.valueOf(results.pageNumber));
        xmlSerializer.endTag("", "PageNumber");
        xmlSerializer.startTag("", "SheetNumber");
        xmlSerializer.text(String.valueOf(results.sheetNumber));
        xmlSerializer.endTag("", "SheetNumber");
        if (results.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(results.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "Suggestion");
        xmlSerializer.text(String.valueOf(results.suggestion));
        xmlSerializer.endTag("", "Suggestion");
        if (results.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, results.pornInfo, "PornInfo");
        }
        if (results.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, results.terrorismInfo, "TerrorismInfo");
        }
        if (results.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, results.politicsInfo, "PoliticsInfo");
        }
        if (results.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, results.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
