package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;
import com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit$$XmlAdapter.class */
public class PostVideoAudit$$XmlAdapter implements IXmlAdapter<PostVideoAudit> {
    private HashMap<String, ChildElementBinder<PostVideoAudit>> childElementBinders;

    public PostVideoAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostVideoAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostVideoAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit postVideoAudit, String str) throws IOException, XmlPullParserException {
                postVideoAudit.input = (AuditInput) QCloudXml.fromXml(xmlPullParser, AuditInput.class, "Input");
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostVideoAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit postVideoAudit, String str) throws IOException, XmlPullParserException {
                postVideoAudit.conf = (PostVideoAudit.VideoAuditConf) QCloudXml.fromXml(xmlPullParser, PostVideoAudit.VideoAuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostVideoAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostVideoAudit postVideoAudit = new PostVideoAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postVideoAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostVideoAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postVideoAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postVideoAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostVideoAudit postVideoAudit, String str) throws IOException, XmlPullParserException {
        if (postVideoAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postVideoAudit.input != null) {
            QCloudXml.toXml(xmlSerializer, postVideoAudit.input, "Input");
        }
        if (postVideoAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postVideoAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
