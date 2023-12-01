package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.Tagging;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging$Tag$$XmlAdapter.class */
public class Tagging$Tag$$XmlAdapter implements IXmlAdapter<Tagging.Tag> {
    private HashMap<String, ChildElementBinder<Tagging.Tag>> childElementBinders;

    public Tagging$Tag$$XmlAdapter() {
        HashMap<String, ChildElementBinder<Tagging.Tag>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Key", new ChildElementBinder<Tagging.Tag>() { // from class: com.tencent.cos.xml.model.tag.Tagging$Tag$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, Tagging.Tag tag, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                tag.key = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Value", new ChildElementBinder<Tagging.Tag>() { // from class: com.tencent.cos.xml.model.tag.Tagging$Tag$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, Tagging.Tag tag, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                tag.value = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public Tagging.Tag fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        Tagging.Tag tag = new Tagging.Tag();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return tag;
            }
            if (i == 2) {
                ChildElementBinder<Tagging.Tag> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, tag, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Tag" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return tag;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, Tagging.Tag tag, String str) throws IOException, XmlPullParserException {
        if (tag == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Tag";
        }
        xmlSerializer.startTag("", str2);
        if (tag.key != null) {
            xmlSerializer.startTag("", "Key");
            xmlSerializer.text(String.valueOf(tag.key));
            xmlSerializer.endTag("", "Key");
        }
        if (tag.value != null) {
            xmlSerializer.startTag("", "Value");
            xmlSerializer.text(String.valueOf(tag.value));
            xmlSerializer.endTag("", "Value");
        }
        xmlSerializer.endTag("", str2);
    }
}
