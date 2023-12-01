package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostTextAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit$TextAuditConf$$XmlAdapter.class */
public class PostTextAudit$TextAuditConf$$XmlAdapter implements IXmlAdapter<PostTextAudit.TextAuditConf> {
    private HashMap<String, ChildElementBinder<PostTextAudit.TextAuditConf>> childElementBinders;

    public PostTextAudit$TextAuditConf$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostTextAudit.TextAuditConf>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("CallbackVersion", new ChildElementBinder<PostTextAudit.TextAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditConf$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditConf textAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditConf.callbackVersion = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DetectType", new ChildElementBinder<PostTextAudit.TextAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditConf$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditConf textAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditConf.detectType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Callback", new ChildElementBinder<PostTextAudit.TextAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditConf$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditConf textAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditConf.callback = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BizType", new ChildElementBinder<PostTextAudit.TextAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditConf$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditConf textAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditConf.bizType = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostTextAudit.TextAuditConf fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostTextAudit.TextAuditConf textAuditConf = new PostTextAudit.TextAuditConf();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textAuditConf;
            }
            if (i == 2) {
                ChildElementBinder<PostTextAudit.TextAuditConf> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textAuditConf, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Conf" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textAuditConf;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostTextAudit.TextAuditConf textAuditConf, String str) throws IOException, XmlPullParserException {
        if (textAuditConf == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Conf";
        }
        xmlSerializer.startTag("", str2);
        if (textAuditConf.callbackVersion != null) {
            xmlSerializer.startTag("", "CallbackVersion");
            xmlSerializer.text(String.valueOf(textAuditConf.callbackVersion));
            xmlSerializer.endTag("", "CallbackVersion");
        }
        if (textAuditConf.detectType != null) {
            xmlSerializer.startTag("", "DetectType");
            xmlSerializer.text(String.valueOf(textAuditConf.detectType));
            xmlSerializer.endTag("", "DetectType");
        }
        if (textAuditConf.callback != null) {
            xmlSerializer.startTag("", "Callback");
            xmlSerializer.text(String.valueOf(textAuditConf.callback));
            xmlSerializer.endTag("", "Callback");
        }
        if (textAuditConf.bizType != null) {
            xmlSerializer.startTag("", "BizType");
            xmlSerializer.text(String.valueOf(textAuditConf.bizType));
            xmlSerializer.endTag("", "BizType");
        }
        xmlSerializer.endTag("", str2);
    }
}
