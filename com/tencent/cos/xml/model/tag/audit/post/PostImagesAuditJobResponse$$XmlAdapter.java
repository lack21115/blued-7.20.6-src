package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditJobsDetail;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostImagesAuditJobResponse$$XmlAdapter.class */
public class PostImagesAuditJobResponse$$XmlAdapter implements IXmlAdapter<PostImagesAuditJobResponse> {
    private HashMap<String, ChildElementBinder<PostImagesAuditJobResponse>> childElementBinders;

    public PostImagesAuditJobResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostImagesAuditJobResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobsDetail", new ChildElementBinder<PostImagesAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAuditJobResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAuditJobResponse postImagesAuditJobResponse, String str) throws IOException, XmlPullParserException {
                if (postImagesAuditJobResponse.jobsDetail == null) {
                    postImagesAuditJobResponse.jobsDetail = new ArrayList();
                }
                postImagesAuditJobResponse.jobsDetail.add(QCloudXml.fromXml(xmlPullParser, ImageAuditJobsDetail.class, "JobsDetail"));
            }
        });
        this.childElementBinders.put("RequestId", new ChildElementBinder<PostImagesAuditJobResponse>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAuditJobResponse$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAuditJobResponse postImagesAuditJobResponse, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                postImagesAuditJobResponse.requestId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostImagesAuditJobResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostImagesAuditJobResponse postImagesAuditJobResponse = new PostImagesAuditJobResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postImagesAuditJobResponse;
            }
            if (i == 2) {
                ChildElementBinder<PostImagesAuditJobResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postImagesAuditJobResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postImagesAuditJobResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostImagesAuditJobResponse postImagesAuditJobResponse, String str) throws IOException, XmlPullParserException {
        if (postImagesAuditJobResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "JobsDetail");
        if (postImagesAuditJobResponse.jobsDetail != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= postImagesAuditJobResponse.jobsDetail.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, postImagesAuditJobResponse.jobsDetail.get(i2), "JobsDetail");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "JobsDetail");
        if (postImagesAuditJobResponse.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(postImagesAuditJobResponse.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.endTag("", str2);
    }
}
