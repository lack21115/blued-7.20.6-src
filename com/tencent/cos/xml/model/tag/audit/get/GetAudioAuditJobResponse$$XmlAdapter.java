package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$$XmlAdapter.class */
public class GetAudioAuditJobResponse$$XmlAdapter implements IXmlAdapter<GetAudioAuditJobResponse> {
    private HashMap<String, ChildElementBinder<GetAudioAuditJobResponse>> childElementBinders;

    public GetAudioAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetAudioAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<GetAudioAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse getAudioAuditJobResponse, String str) throws IOException, XmlPullParserException {
                getAudioAuditJobResponse.jobsDetail = (GetAudioAuditJobResponse.AudioAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, GetAudioAuditJobResponse.AudioAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<GetAudioAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse getAudioAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getAudioAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetAudioAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetAudioAuditJobResponse getAudioAuditJobResponse = new GetAudioAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getAudioAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<GetAudioAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getAudioAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getAudioAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetAudioAuditJobResponse getAudioAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (getAudioAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getAudioAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, getAudioAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (getAudioAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getAudioAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
