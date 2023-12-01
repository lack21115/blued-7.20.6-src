package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;
import com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostAudioAudit$$XmlAdapter.class */
public class PostAudioAudit$$XmlAdapter implements IXmlAdapter<PostAudioAudit> {
    private HashMap<String, ChildElementBinder<PostAudioAudit>> childElementBinders;

    public PostAudioAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostAudioAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostAudioAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit postAudioAudit, String str) throws IOException, XmlPullParserException {
                postAudioAudit.input = (AuditInput) QCloudXml.fromXml(xmlPullParser, AuditInput.class, "Input");
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostAudioAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit postAudioAudit, String str) throws IOException, XmlPullParserException {
                postAudioAudit.conf = (PostAudioAudit.AudioAuditConf) QCloudXml.fromXml(xmlPullParser, PostAudioAudit.AudioAuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostAudioAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostAudioAudit postAudioAudit = new PostAudioAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postAudioAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostAudioAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postAudioAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postAudioAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostAudioAudit postAudioAudit, String str) throws IOException, XmlPullParserException {
        if (postAudioAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postAudioAudit.input != null) {
            QCloudXml.toXml(xmlSerializer, postAudioAudit.input, "Input");
        }
        if (postAudioAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postAudioAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
