package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$Labels$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$Labels$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse.Labels> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.Labels>> childElementBinders;

    public GetDocumentAuditJobResponse$Labels$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.Labels>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("PornInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Labels>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Labels$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Labels labels, String str) throws IOException, XmlPullParserException {
                labels.pornInfo = (GetDocumentAuditJobResponse.DocumentAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Labels>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Labels$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Labels labels, String str) throws IOException, XmlPullParserException {
                labels.terrorismInfo = (GetDocumentAuditJobResponse.DocumentAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Labels>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Labels$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Labels labels, String str) throws IOException, XmlPullParserException {
                labels.politicsInfo = (GetDocumentAuditJobResponse.DocumentAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetDocumentAuditJobResponse.Labels>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$Labels$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.Labels labels, String str) throws IOException, XmlPullParserException {
                labels.adsInfo = (GetDocumentAuditJobResponse.DocumentAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse.Labels fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse.Labels labels = new GetDocumentAuditJobResponse.Labels();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return labels;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse.Labels> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, labels, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Labels" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return labels;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse.Labels labels, String str) throws IOException, XmlPullParserException {
        if (labels == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Labels";
        }
        xmlSerializer.startTag("", str2);
        if (labels.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, labels.pornInfo, "PornInfo");
        }
        if (labels.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, labels.terrorismInfo, "TerrorismInfo");
        }
        if (labels.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, labels.politicsInfo, "PoliticsInfo");
        }
        if (labels.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, labels.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
