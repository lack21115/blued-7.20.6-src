package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostImagesAudit$$XmlAdapter.class */
public class PostImagesAudit$$XmlAdapter implements IXmlAdapter<PostImagesAudit> {
    private HashMap<String, ChildElementBinder<PostImagesAudit>> childElementBinders;

    public PostImagesAudit$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostImagesAudit>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Input", new ChildElementBinder<PostImagesAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$$XmlAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit postImagesAudit, String str) throws IOException, XmlPullParserException {
                if (postImagesAudit.input == null) {
                    postImagesAudit.input = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        postImagesAudit.input.add(QCloudXml.fromXml(xmlPullParser, PostImagesAudit.ImagesAuditInput.class, "Input"));
                    } else if (i == 3 && "Input".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
        this.childElementBinders.put("Conf", new ChildElementBinder<PostImagesAudit>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostImagesAudit$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostImagesAudit postImagesAudit, String str) throws IOException, XmlPullParserException {
                postImagesAudit.conf = (AuditConf) QCloudXml.fromXml(xmlPullParser, AuditConf.class, "Conf");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostImagesAudit fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostImagesAudit postImagesAudit = new PostImagesAudit();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return postImagesAudit;
            }
            if (i == 2) {
                ChildElementBinder<PostImagesAudit> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, postImagesAudit, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Request" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return postImagesAudit;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostImagesAudit postImagesAudit, String str) throws IOException, XmlPullParserException {
        if (postImagesAudit == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Request";
        }
        xmlSerializer.startTag("", str2);
        if (postImagesAudit.input != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= postImagesAudit.input.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, postImagesAudit.input.get(i2), "Input");
                i = i2 + 1;
            }
        }
        if (postImagesAudit.conf != null) {
            QCloudXml.toXml(xmlSerializer, postImagesAudit.conf, "Conf");
        }
        xmlSerializer.endTag("", str2);
    }
}
