package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.Tagging;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging$TagSet$$XmlAdapter.class */
public class Tagging$TagSet$$XmlAdapter implements IXmlAdapter<Tagging.TagSet> {
    private HashMap<String, ChildElementBinder<Tagging.TagSet>> childElementBinders;

    public Tagging$TagSet$$XmlAdapter() {
        HashMap<String, ChildElementBinder<Tagging.TagSet>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Tags", new ChildElementBinder<Tagging.TagSet>() { // from class: com.tencent.cos.xml.model.tag.Tagging$TagSet$$XmlAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, Tagging.TagSet tagSet, String str) throws IOException, XmlPullParserException {
                if (tagSet.tags == null) {
                    tagSet.tags = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        tagSet.tags.add(QCloudXml.fromXml(xmlPullParser, Tagging.Tag.class, "Tag"));
                    } else if (i == 3 && "Tags".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public Tagging.TagSet fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        Tagging.TagSet tagSet = new Tagging.TagSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return tagSet;
            }
            if (i == 2) {
                ChildElementBinder<Tagging.TagSet> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, tagSet, null);
                }
            } else if (i == 3) {
                if ((str == null ? "TagSet" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return tagSet;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, Tagging.TagSet tagSet, String str) throws IOException, XmlPullParserException {
        if (tagSet == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "TagSet";
        }
        xmlSerializer.startTag("", str2);
        if (tagSet.tags != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= tagSet.tags.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, tagSet.tags.get(i2), "Tags");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", str2);
    }
}
