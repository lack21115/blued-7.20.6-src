package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostDocumentAudit$$XmlAdapter.class */
public class PostDocumentAudit$$XmlAdapter implements IXmlAdapter<PostDocumentAudit> {
    private HashMap<String, ChildElementBinder<PostDocumentAudit>> childElementBinders;

    public PostDocumentAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostDocumentAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostDocumentAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit postDocumentAudit, String str) throws IOException, XmlPullParserException {
                postDocumentAudit.input = (PostDocumentAudit.DocumentAuditInput) QCloudXml.fromXml(xmlPullParser, PostDocumentAudit.DocumentAuditInput.class, "Input");
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostDocumentAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit postDocumentAudit, String str) throws IOException, XmlPullParserException {
                postDocumentAudit.conf = (AuditConf) QCloudXml.fromXml(xmlPullParser, AuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostDocumentAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostDocumentAudit postDocumentAudit = new PostDocumentAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postDocumentAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostDocumentAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postDocumentAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postDocumentAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostDocumentAudit postDocumentAudit, String str) throws IOException, XmlPullParserException {
        if (postDocumentAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postDocumentAudit.input != null) {
            QCloudXml.toXml(xmlSerializer, postDocumentAudit.input, "Input");
        }
        if (postDocumentAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postDocumentAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
