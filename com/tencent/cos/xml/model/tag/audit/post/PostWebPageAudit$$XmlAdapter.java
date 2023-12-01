package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;
import com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostWebPageAudit$$XmlAdapter.class */
public class PostWebPageAudit$$XmlAdapter implements IXmlAdapter<PostWebPageAudit> {
    private HashMap<String, ChildElementBinder<PostWebPageAudit>> childElementBinders;

    public PostWebPageAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostWebPageAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostWebPageAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit postWebPageAudit, String str) throws IOException, XmlPullParserException {
                postWebPageAudit.input = (AuditInput) QCloudXml.fromXml(xmlPullParser, AuditInput.class, "Input");
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostWebPageAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit postWebPageAudit, String str) throws IOException, XmlPullParserException {
                postWebPageAudit.conf = (PostWebPageAudit.WebPageAuditConf) QCloudXml.fromXml(xmlPullParser, PostWebPageAudit.WebPageAuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostWebPageAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostWebPageAudit postWebPageAudit = new PostWebPageAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postWebPageAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostWebPageAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postWebPageAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postWebPageAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostWebPageAudit postWebPageAudit, String str) throws IOException, XmlPullParserException {
        if (postWebPageAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postWebPageAudit.input != null) {
            QCloudXml.toXml(xmlSerializer, postWebPageAudit.input, "Input");
        }
        if (postWebPageAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postWebPageAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
