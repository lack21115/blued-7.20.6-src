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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse>> childElementBinders;

    public GetWebPageAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<GetWebPageAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse getWebPageAuditJobResponse, String str) throws IOException, XmlPullParserException {
                getWebPageAuditJobResponse.jobsDetail = (GetWebPageAuditJobResponse.WebPageAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<GetWebPageAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse getWebPageAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getWebPageAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse getWebPageAuditJobResponse = new GetWebPageAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getWebPageAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getWebPageAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getWebPageAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse getWebPageAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (getWebPageAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getWebPageAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, getWebPageAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (getWebPageAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getWebPageAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
