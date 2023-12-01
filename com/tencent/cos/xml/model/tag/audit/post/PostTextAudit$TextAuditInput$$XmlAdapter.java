package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostTextAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit$TextAuditInput$$XmlAdapter.class */
public class PostTextAudit$TextAuditInput$$XmlAdapter implements IXmlAdapter<PostTextAudit.TextAuditInput> {
    private HashMap<String, ChildElementBinder<PostTextAudit.TextAuditInput>> childElementBinders;

    public PostTextAudit$TextAuditInput$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostTextAudit.TextAuditInput>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Content", new ChildElementBinder<PostTextAudit.TextAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditInput$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditInput textAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditInput.content = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Object", new ChildElementBinder<PostTextAudit.TextAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditInput$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditInput textAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditInput.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<PostTextAudit.TextAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditInput$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditInput textAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditInput.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<PostTextAudit.TextAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostTextAudit$TextAuditInput$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostTextAudit.TextAuditInput textAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditInput.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostTextAudit.TextAuditInput fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostTextAudit.TextAuditInput textAuditInput = new PostTextAudit.TextAuditInput();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textAuditInput;
            }
            if (i == 2) {
                ChildElementBinder<PostTextAudit.TextAuditInput> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textAuditInput, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Input" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textAuditInput;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostTextAudit.TextAuditInput textAuditInput, String str) throws IOException, XmlPullParserException {
        if (textAuditInput == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Input";
        }
        xmlSerializer.startTag("", str2);
        if (textAuditInput.content != null) {
            xmlSerializer.startTag("", "Content");
            xmlSerializer.text(String.valueOf(textAuditInput.content));
            xmlSerializer.endTag("", "Content");
        }
        if (textAuditInput.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(textAuditInput.object));
            xmlSerializer.endTag("", "Object");
        }
        if (textAuditInput.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(textAuditInput.url));
            xmlSerializer.endTag("", "Url");
        }
        if (textAuditInput.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(textAuditInput.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
