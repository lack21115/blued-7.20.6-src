package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.WebPageAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>> childElementBinders;

    public GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Suggestion", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.suggestion = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PageCount", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.pageCount = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("HighlightHtml", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.highlightHtml = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Labels", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                webPageAuditJobsDetail.labels = (GetWebPageAuditJobResponse.Labels) QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.Labels.class, "Labels");
            }
        });
        this.childElementBinders.put("PageSegment", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                webPageAuditJobsDetail.pageSegment = (GetWebPageAuditJobResponse.ImageResults) QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.ImageResults.class, "PageSegment");
            }
        });
        this.childElementBinders.put("TextResults", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                webPageAuditJobsDetail.textResults = (GetWebPageAuditJobResponse.TextResults) QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.TextResults.class, "TextResults");
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditJobsDetail$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.WebPageAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail = new GetWebPageAuditJobResponse.WebPageAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return webPageAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, webPageAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return webPageAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.WebPageAuditJobsDetail webPageAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (webPageAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Suggestion");
        xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.suggestion));
        xmlSerializer.endTag("", "Suggestion");
        if (webPageAuditJobsDetail.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.url));
            xmlSerializer.endTag("", "Url");
        }
        xmlSerializer.startTag("", "PageCount");
        xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.pageCount));
        xmlSerializer.endTag("", "PageCount");
        if (webPageAuditJobsDetail.highlightHtml != null) {
            xmlSerializer.startTag("", "HighlightHtml");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.highlightHtml));
            xmlSerializer.endTag("", "HighlightHtml");
        }
        if (webPageAuditJobsDetail.labels != null) {
            QCloudXml.toXml(xmlSerializer, webPageAuditJobsDetail.labels, "Labels");
        }
        if (webPageAuditJobsDetail.pageSegment != null) {
            QCloudXml.toXml(xmlSerializer, webPageAuditJobsDetail.pageSegment, "PageSegment");
        }
        if (webPageAuditJobsDetail.textResults != null) {
            QCloudXml.toXml(xmlSerializer, webPageAuditJobsDetail.textResults, "TextResults");
        }
        if (webPageAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (webPageAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (webPageAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (webPageAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (webPageAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (webPageAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (webPageAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (webPageAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(webPageAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
