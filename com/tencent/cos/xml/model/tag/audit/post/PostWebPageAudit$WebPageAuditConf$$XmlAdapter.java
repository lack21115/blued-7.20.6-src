package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostWebPageAudit$WebPageAuditConf$$XmlAdapter.class */
public class PostWebPageAudit$WebPageAuditConf$$XmlAdapter implements IXmlAdapter<PostWebPageAudit.WebPageAuditConf> {
    private HashMap<String, ChildElementBinder<PostWebPageAudit.WebPageAuditConf>> childElementBinders;

    public PostWebPageAudit$WebPageAuditConf$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostWebPageAudit.WebPageAuditConf>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("ReturnHighlightHtml", new ChildElementBinder<PostWebPageAudit.WebPageAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$WebPageAuditConf$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit.WebPageAuditConf webPageAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditConf.returnHighlightHtml = Boolean.parseBoolean(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("DetectType", new ChildElementBinder<PostWebPageAudit.WebPageAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$WebPageAuditConf$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit.WebPageAuditConf webPageAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditConf.detectType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Callback", new ChildElementBinder<PostWebPageAudit.WebPageAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$WebPageAuditConf$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit.WebPageAuditConf webPageAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditConf.callback = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BizType", new ChildElementBinder<PostWebPageAudit.WebPageAuditConf>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit$WebPageAuditConf$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostWebPageAudit.WebPageAuditConf webPageAuditConf, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditConf.bizType = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostWebPageAudit.WebPageAuditConf fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostWebPageAudit.WebPageAuditConf webPageAuditConf = new PostWebPageAudit.WebPageAuditConf();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return webPageAuditConf;
            }
            if (i == 2) {
                ChildElementBinder<PostWebPageAudit.WebPageAuditConf> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, webPageAuditConf, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Conf" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return webPageAuditConf;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostWebPageAudit.WebPageAuditConf webPageAuditConf, String str) throws IOException, XmlPullParserException {
        if (webPageAuditConf == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Conf";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "ReturnHighlightHtml");
        xmlSerializer.text(String.valueOf(webPageAuditConf.returnHighlightHtml));
        xmlSerializer.endTag("", "ReturnHighlightHtml");
        if (webPageAuditConf.detectType != null) {
            xmlSerializer.startTag("", "DetectType");
            xmlSerializer.text(String.valueOf(webPageAuditConf.detectType));
            xmlSerializer.endTag("", "DetectType");
        }
        if (webPageAuditConf.callback != null) {
            xmlSerializer.startTag("", "Callback");
            xmlSerializer.text(String.valueOf(webPageAuditConf.callback));
            xmlSerializer.endTag("", "Callback");
        }
        if (webPageAuditConf.bizType != null) {
            xmlSerializer.startTag("", "BizType");
            xmlSerializer.text(String.valueOf(webPageAuditConf.bizType));
            xmlSerializer.endTag("", "BizType");
        }
        xmlSerializer.endTag("", str2);
    }
}
