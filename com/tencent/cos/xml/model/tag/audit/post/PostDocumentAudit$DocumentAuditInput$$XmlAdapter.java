package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostDocumentAudit$DocumentAuditInput$$XmlAdapter.class */
public class PostDocumentAudit$DocumentAuditInput$$XmlAdapter implements IXmlAdapter<PostDocumentAudit.DocumentAuditInput> {
    private HashMap<String, ChildElementBinder<PostDocumentAudit.DocumentAuditInput>> childElementBinders;

    public PostDocumentAudit$DocumentAuditInput$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostDocumentAudit.DocumentAuditInput>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Type", new ChildElementBinder<PostDocumentAudit.DocumentAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$DocumentAuditInput$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit.DocumentAuditInput documentAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditInput.type = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Object", new ChildElementBinder<PostDocumentAudit.DocumentAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$DocumentAuditInput$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit.DocumentAuditInput documentAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditInput.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<PostDocumentAudit.DocumentAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$DocumentAuditInput$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit.DocumentAuditInput documentAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditInput.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<PostDocumentAudit.DocumentAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit$DocumentAuditInput$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostDocumentAudit.DocumentAuditInput documentAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditInput.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostDocumentAudit.DocumentAuditInput fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostDocumentAudit.DocumentAuditInput documentAuditInput = new PostDocumentAudit.DocumentAuditInput();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return documentAuditInput;
            }
            if (i == 2) {
                ChildElementBinder<PostDocumentAudit.DocumentAuditInput> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, documentAuditInput, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Input" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return documentAuditInput;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostDocumentAudit.DocumentAuditInput documentAuditInput, String str) throws IOException, XmlPullParserException {
        if (documentAuditInput == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Input";
        }
        xmlSerializer.startTag("", str2);
        if (documentAuditInput.type != null) {
            xmlSerializer.startTag("", "Type");
            xmlSerializer.text(String.valueOf(documentAuditInput.type));
            xmlSerializer.endTag("", "Type");
        }
        if (documentAuditInput.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(documentAuditInput.object));
            xmlSerializer.endTag("", "Object");
        }
        if (documentAuditInput.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(documentAuditInput.url));
            xmlSerializer.endTag("", "Url");
        }
        if (documentAuditInput.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(documentAuditInput.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
