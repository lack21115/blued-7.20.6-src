package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.BaseAuditJobsDetail;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostAuditJobResponse$$XmlAdapter.class */
public class PostAuditJobResponse$$XmlAdapter implements IXmlAdapter<PostAuditJobResponse> {
    private HashMap<String, ChildElementBinder<PostAuditJobResponse>> childElementBinders;

    public PostAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<PostAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAuditJobResponse postAuditJobResponse, String str) throws IOException, XmlPullParserException {
                postAuditJobResponse.jobsDetail = (BaseAuditJobsDetail) QCloudXml.fromXml(xmlPullParser, BaseAuditJobsDetail.class, "JobsDetail");
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<PostAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAuditJobResponse postAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                postAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostAuditJobResponse postAuditJobResponse = new PostAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<PostAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostAuditJobResponse postAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (postAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (postAuditJobResponse.jobsDetail != null) {
            QCloudXml.toXml(xmlSerializer, postAuditJobResponse.jobsDetail, "JobsDetail");
        }
        if (postAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(postAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
