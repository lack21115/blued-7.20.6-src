package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$$XmlAdapter.class */
public class GetVideoAuditJobResponse$$XmlAdapter implements IXmlAdapter<GetVideoAuditJobResponse> {
    private HashMap<String, ChildElementBinder<GetVideoAuditJobResponse>> childElementBinders;

    public GetVideoAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetVideoAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("RequestId", new ChildElementBinder<GetVideoAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse getVideoAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getVideoAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobsDetail", new ChildElementBinder<GetVideoAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse getVideoAuditJobResponse, String str) throws IOException, XmlPullParserException {
                getVideoAuditJobResponse.jobsDetail = (GetVideoAuditJobResponse.VideoAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.VideoAuditJobsDetail.class, "JobsDetail");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetVideoAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetVideoAuditJobResponse getVideoAuditJobResponse = new GetVideoAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getVideoAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<GetVideoAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getVideoAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getVideoAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetVideoAuditJobResponse getVideoAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (getVideoAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getVideoAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getVideoAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        if (getVideoAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, getVideoAuditJobResponse.jobsDetail, "JobsDetail");
        }
        xmlSerializer.endTag("", str2);
    }
}
