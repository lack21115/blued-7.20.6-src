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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse>> childElementBinders;

    public GetDocumentAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<GetDocumentAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse getDocumentAuditJobResponse, String str) throws IOException, XmlPullParserException {
                getDocumentAuditJobResponse.jobsDetail = (GetDocumentAuditJobResponse.DocumentAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<GetDocumentAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse getDocumentAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getDocumentAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse getDocumentAuditJobResponse = new GetDocumentAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getDocumentAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getDocumentAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getDocumentAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse getDocumentAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (getDocumentAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getDocumentAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, getDocumentAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (getDocumentAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getDocumentAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
