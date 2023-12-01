package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$TextResult$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$TextResult$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.TextResult> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.TextResult>> childElementBinders;

    public GetWebPageAuditJobResponse$TextResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.TextResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Text", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textResult.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textResult.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Suggestion", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textResult.suggestion = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                textResult.pornInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                textResult.terrorismInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                textResult.politicsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetWebPageAuditJobResponse.TextResult>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResult$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
                textResult.adsInfo = (TextAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, TextAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.TextResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.TextResult textResult = new GetWebPageAuditJobResponse.TextResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textResult;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.TextResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "TextResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.TextResult textResult, String str) throws IOException, XmlPullParserException {
        if (textResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "TextResult";
        }
        xmlSerializer.startTag("", str2);
        if (textResult.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(textResult.text));
            xmlSerializer.endTag("", "Text");
        }
        if (textResult.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(textResult.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "Suggestion");
        xmlSerializer.text(String.valueOf(textResult.suggestion));
        xmlSerializer.endTag("", "Suggestion");
        if (textResult.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, textResult.pornInfo, "PornInfo");
        }
        if (textResult.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, textResult.terrorismInfo, "TerrorismInfo");
        }
        if (textResult.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, textResult.politicsInfo, "PoliticsInfo");
        }
        if (textResult.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, textResult.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
