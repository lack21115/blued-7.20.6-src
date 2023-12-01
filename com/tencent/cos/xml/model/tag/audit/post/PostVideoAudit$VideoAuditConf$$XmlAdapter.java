package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit$VideoAuditConf$$XmlAdapter.class */
public class PostVideoAudit$VideoAuditConf$$XmlAdapter implements IXmlAdapter<PostVideoAudit.VideoAuditConf> {
    private HashMap<String, ChildElementBinder<PostVideoAudit.VideoAuditConf>> childElementBinders;

    public PostVideoAudit$VideoAuditConf$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostVideoAudit.VideoAuditConf>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("CallbackVersion", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditConf.callbackVersion = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Snapshot", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                videoAuditConf.snapshot = (PostVideoAudit.Snapshot) QCloudXml.fromXml(xmlPullParser, PostVideoAudit.Snapshot.class, "Snapshot");
            }
        });
        this.childElementBinders.put("DetectContent", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditConf.detectContent = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("DetectType", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditConf.detectType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Callback", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditConf.callback = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BizType", new ChildElementBinder<PostVideoAudit.VideoAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$VideoAuditConf$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                videoAuditConf.bizType = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostVideoAudit.VideoAuditConf fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostVideoAudit.VideoAuditConf videoAuditConf = new PostVideoAudit.VideoAuditConf();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return videoAuditConf;
            }
            if (i == 2) {
                ChildElementBinder<PostVideoAudit.VideoAuditConf> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, videoAuditConf, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Conf" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return videoAuditConf;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostVideoAudit.VideoAuditConf videoAuditConf, String str) throws IOException, XmlPullParserException {
        if (videoAuditConf == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Conf";
        }
        xmlSerializer.startTag("", str2);
        if (videoAuditConf.callbackVersion != null) {
            xmlSerializer.startTag("", "CallbackVersion");
            xmlSerializer.text(String.valueOf(videoAuditConf.callbackVersion));
            xmlSerializer.endTag("", "CallbackVersion");
        }
        if (videoAuditConf.snapshot != null) {
            QCloudXml.toXml(xmlSerializer, videoAuditConf.snapshot, "Snapshot");
        }
        xmlSerializer.startTag("", "DetectContent");
        xmlSerializer.text(String.valueOf(videoAuditConf.detectContent));
        xmlSerializer.endTag("", "DetectContent");
        if (videoAuditConf.detectType != null) {
            xmlSerializer.startTag("", "DetectType");
            xmlSerializer.text(String.valueOf(videoAuditConf.detectType));
            xmlSerializer.endTag("", "DetectType");
        }
        if (videoAuditConf.callback != null) {
            xmlSerializer.startTag("", "Callback");
            xmlSerializer.text(String.valueOf(videoAuditConf.callback));
            xmlSerializer.endTag("", "Callback");
        }
        if (videoAuditConf.bizType != null) {
            xmlSerializer.startTag("", "BizType");
            xmlSerializer.text(String.valueOf(videoAuditConf.bizType));
            xmlSerializer.endTag("", "BizType");
        }
        xmlSerializer.endTag("", str2);
    }
}
