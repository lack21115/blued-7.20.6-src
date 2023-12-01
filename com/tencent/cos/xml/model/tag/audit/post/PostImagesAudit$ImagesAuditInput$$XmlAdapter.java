package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostImagesAudit$ImagesAuditInput$$XmlAdapter.class */
public class PostImagesAudit$ImagesAuditInput$$XmlAdapter implements IXmlAdapter<PostImagesAudit.ImagesAuditInput> {
    private HashMap<String, ChildElementBinder<PostImagesAudit.ImagesAuditInput>> childElementBinders;

    public PostImagesAudit$ImagesAuditInput$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostImagesAudit.ImagesAuditInput>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Interval", new ChildElementBinder<PostImagesAudit.ImagesAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$ImagesAuditInput$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditInput.interval = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("MaxFrames", new ChildElementBinder<PostImagesAudit.ImagesAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$ImagesAuditInput$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditInput.maxFrames = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Object", new ChildElementBinder<PostImagesAudit.ImagesAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$ImagesAuditInput$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditInput.object = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Url", new ChildElementBinder<PostImagesAudit.ImagesAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$ImagesAuditInput$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditInput.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<PostImagesAudit.ImagesAuditInput>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$ImagesAuditInput$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imagesAuditInput.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostImagesAudit.ImagesAuditInput fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostImagesAudit.ImagesAuditInput imagesAuditInput = new PostImagesAudit.ImagesAuditInput();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imagesAuditInput;
            }
            if (i == 2) {
                ChildElementBinder<PostImagesAudit.ImagesAuditInput> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imagesAuditInput, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Input" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imagesAuditInput;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostImagesAudit.ImagesAuditInput imagesAuditInput, String str) throws IOException, XmlPullParserException {
        if (imagesAuditInput == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Input";
        }
        xmlSerializer.startTag("", str2);
        if (imagesAuditInput.interval != 0) {
            xmlSerializer.startTag("", "Interval");
            xmlSerializer.text(String.valueOf(imagesAuditInput.interval));
            xmlSerializer.endTag("", "Interval");
        }
        if (imagesAuditInput.maxFrames != 0) {
            xmlSerializer.startTag("", "MaxFrames");
            xmlSerializer.text(String.valueOf(imagesAuditInput.maxFrames));
            xmlSerializer.endTag("", "MaxFrames");
        }
        if (imagesAuditInput.object != null) {
            xmlSerializer.startTag("", "Object");
            xmlSerializer.text(String.valueOf(imagesAuditInput.object));
            xmlSerializer.endTag("", "Object");
        }
        if (imagesAuditInput.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(imagesAuditInput.url));
            xmlSerializer.endTag("", "Url");
        }
        if (imagesAuditInput.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(imagesAuditInput.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
