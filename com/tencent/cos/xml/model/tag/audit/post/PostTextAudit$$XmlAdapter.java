package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostTextAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit$$XmlAdapter.class */
public class PostTextAudit$$XmlAdapter implements IXmlAdapter<PostTextAudit> {
    private HashMap<String, ChildElementBinder<PostTextAudit>> childElementBinders;

    public PostTextAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostTextAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostTextAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit postTextAudit, String str) throws IOException, XmlPullParserException {
                postTextAudit.input = (PostTextAudit.TextAuditInput) QCloudXml.fromXml(xmlPullParser, PostTextAudit.TextAuditInput.class, "Input");
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostTextAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit postTextAudit, String str) throws IOException, XmlPullParserException {
                postTextAudit.conf = (PostTextAudit.TextAuditConf) QCloudXml.fromXml(xmlPullParser, PostTextAudit.TextAuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostTextAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostTextAudit postTextAudit = new PostTextAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postTextAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostTextAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postTextAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postTextAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostTextAudit postTextAudit, String str) throws IOException, XmlPullParserException {
        if (postTextAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postTextAudit.input != null) {
            QCloudXml.toXml(xmlSerializer, postTextAudit.input, "Input");
        }
        if (postTextAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postTextAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
