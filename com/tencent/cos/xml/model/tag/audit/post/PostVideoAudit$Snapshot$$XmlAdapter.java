package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit$Snapshot$$XmlAdapter.class */
public class PostVideoAudit$Snapshot$$XmlAdapter implements IXmlAdapter<PostVideoAudit.Snapshot> {
    private HashMap<String, ChildElementBinder<PostVideoAudit.Snapshot>> childElementBinders;

    public PostVideoAudit$Snapshot$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PostVideoAudit.Snapshot>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Mode", new ChildElementBinder<PostVideoAudit.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$Snapshot$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.mode = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Count", new ChildElementBinder<PostVideoAudit.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$Snapshot$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.count = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("TimeInterval", new ChildElementBinder<PostVideoAudit.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit$Snapshot$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PostVideoAudit.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.timeInterval = Float.parseFloat(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PostVideoAudit.Snapshot fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PostVideoAudit.Snapshot snapshot = new PostVideoAudit.Snapshot();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return snapshot;
            }
            if (i == 2) {
                ChildElementBinder<PostVideoAudit.Snapshot> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, snapshot, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Snapshot" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return snapshot;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PostVideoAudit.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
        if (snapshot == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Snapshot";
        }
        xmlSerializer.startTag("", str2);
        if (snapshot.mode != null) {
            xmlSerializer.startTag("", "Mode");
            xmlSerializer.text(String.valueOf(snapshot.mode));
            xmlSerializer.endTag("", "Mode");
        }
        xmlSerializer.startTag("", "Count");
        xmlSerializer.text(String.valueOf(snapshot.count));
        xmlSerializer.endTag("", "Count");
        if (snapshot.timeInterval != 0.0f) {
            xmlSerializer.startTag("", "TimeInterval");
            xmlSerializer.text(String.valueOf(snapshot.timeInterval));
            xmlSerializer.endTag("", "TimeInterval");
        }
        xmlSerializer.endTag("", str2);
    }
}
