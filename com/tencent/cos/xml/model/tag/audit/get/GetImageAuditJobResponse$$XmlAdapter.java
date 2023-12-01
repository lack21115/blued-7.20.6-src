package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetImageAuditJobResponse$$XmlAdapter.class */
public class GetImageAuditJobResponse$$XmlAdapter implements IXmlAdapter<GetImageAuditJobResponse> {
    private HashMap<String, ChildElementBinder<GetImageAuditJobResponse>> childElementBinders;

    public GetImageAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetImageAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<GetImageAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetImageAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetImageAuditJobResponse getImageAuditJobResponse, String str) throws IOException, XmlPullParserException {
                getImageAuditJobResponse.jobsDetail = (ImageAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<GetImageAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetImageAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetImageAuditJobResponse getImageAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getImageAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetImageAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetImageAuditJobResponse getImageAuditJobResponse = new GetImageAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getImageAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<GetImageAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getImageAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getImageAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetImageAuditJobResponse getImageAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (getImageAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getImageAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, getImageAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (getImageAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getImageAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
