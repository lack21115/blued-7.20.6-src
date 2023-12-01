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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse.DocumentAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>> childElementBinders;

    public GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Suggestion", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.suggestion = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Object", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PageCount", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.pageCount = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Labels", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                documentAuditJobsDetail.labels = (GetDocumentAuditJobResponse.Labels) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.Labels.class, "Labels");
            }
        });
        this.childElementBinders.put("PageSegment", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                documentAuditJobsDetail.pageSegment = (GetDocumentAuditJobResponse.PageSegment) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.PageSegment.class, "PageSegment");
            }
        });
        this.childElementBinders.put("Code", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditJobsDetail$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse.DocumentAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail = new GetDocumentAuditJobResponse.DocumentAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return documentAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, documentAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return documentAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse.DocumentAuditJobsDetail documentAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (documentAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Suggestion");
        xmlSerializer.text(String.valueOf(documentAuditJobsDetail.suggestion));
        xmlSerializer.endTag("", "Suggestion");
        if (documentAuditJobsDetail.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.object));
            xmlSerializer.endTag("", "Object");
        }
        if (documentAuditJobsDetail.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.url));
            xmlSerializer.endTag("", "Url");
        }
        xmlSerializer.startTag("", "PageCount");
        xmlSerializer.text(String.valueOf(documentAuditJobsDetail.pageCount));
        xmlSerializer.endTag("", "PageCount");
        if (documentAuditJobsDetail.labels != null) {
            QCloudXml.toXml(xmlSerializer, documentAuditJobsDetail.labels, "Labels");
        }
        if (documentAuditJobsDetail.pageSegment != null) {
            QCloudXml.toXml(xmlSerializer, documentAuditJobsDetail.pageSegment, "PageSegment");
        }
        if (documentAuditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (documentAuditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (documentAuditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (documentAuditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (documentAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (documentAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (documentAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (documentAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(documentAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
