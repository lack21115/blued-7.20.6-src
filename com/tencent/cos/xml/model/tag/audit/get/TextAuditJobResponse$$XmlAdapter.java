package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/TextAuditJobResponse$$XmlAdapter.class */
public class TextAuditJobResponse$$XmlAdapter implements IXmlAdapter<TextAuditJobResponse> {
    private HashMap<String, ChildElementBinder<TextAuditJobResponse>> childElementBinders;

    public TextAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<TextAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<TextAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse textAuditJobResponse, String str) throws IOException, XmlPullParserException {
                textAuditJobResponse.jobsDetail = (TextAuditJobResponse.TextAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, TextAuditJobResponse.TextAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<TextAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.get.TextAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditJobResponse textAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public TextAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        TextAuditJobResponse textAuditJobResponse = new TextAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<TextAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, TextAuditJobResponse textAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (textAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (textAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, textAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (textAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(textAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
