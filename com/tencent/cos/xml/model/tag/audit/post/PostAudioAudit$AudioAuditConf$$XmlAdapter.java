package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostAudioAudit$AudioAuditConf$$XmlAdapter.class */
public class PostAudioAudit$AudioAuditConf$$XmlAdapter implements IXmlAdapter<PostAudioAudit.AudioAuditConf> {
    private HashMap<String, ChildElementBinder<PostAudioAudit.AudioAuditConf>> childElementBinders;

    public PostAudioAudit$AudioAuditConf$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostAudioAudit.AudioAuditConf>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("CallbackVersion", new ChildElementBinder<PostAudioAudit.AudioAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$AudioAuditConf$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit.AudioAuditConf audioAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditConf.callbackVersion = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DetectType", new ChildElementBinder<PostAudioAudit.AudioAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$AudioAuditConf$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit.AudioAuditConf audioAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditConf.detectType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Callback", new ChildElementBinder<PostAudioAudit.AudioAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$AudioAuditConf$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit.AudioAuditConf audioAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditConf.callback = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BizType", new ChildElementBinder<PostAudioAudit.AudioAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit$AudioAuditConf$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostAudioAudit.AudioAuditConf audioAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditConf.bizType = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostAudioAudit.AudioAuditConf fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostAudioAudit.AudioAuditConf audioAuditConf = new PostAudioAudit.AudioAuditConf();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return audioAuditConf;
            }
            if (i == 2) {
                ChildElementBinder<PostAudioAudit.AudioAuditConf> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, audioAuditConf, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Conf" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return audioAuditConf;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostAudioAudit.AudioAuditConf audioAuditConf, String str) throws IOException, XmlPullParserException {
        if (audioAuditConf == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Conf";
        }
        xmlSerializer.startTag("", str2);
        if (audioAuditConf.callbackVersion != null) {
            xmlSerializer.startTag("", "CallbackVersion");
            xmlSerializer.text(String.valueOf(audioAuditConf.callbackVersion));
            xmlSerializer.endTag("", "CallbackVersion");
        }
        if (audioAuditConf.detectType != null) {
            xmlSerializer.startTag("", "DetectType");
            xmlSerializer.text(String.valueOf(audioAuditConf.detectType));
            xmlSerializer.endTag("", "DetectType");
        }
        if (audioAuditConf.callback != null) {
            xmlSerializer.startTag("", "Callback");
            xmlSerializer.text(String.valueOf(audioAuditConf.callback));
            xmlSerializer.endTag("", "Callback");
        }
        if (audioAuditConf.bizType != null) {
            xmlSerializer.startTag("", "BizType");
            xmlSerializer.text(String.valueOf(audioAuditConf.bizType));
            xmlSerializer.endTag("", "BizType");
        }
        xmlSerializer.endTag("", str2);
    }
}
