package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.Tagging;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging$$XmlAdapter.class */
public class Tagging$$XmlAdapter implements IXmlAdapter<Tagging> {
    private HashMap<String, ChildElementBinder<Tagging>> childElementBinders;

    public Tagging$$XmlAdapter() {
        HashMap<String, ChildElementBinder<Tagging>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("TagSet", new ChildElementBinder<Tagging>() { // from class: com.tencent.cos.xml.model.tag.Tagging$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, Tagging tagging, String str) throws IOException, XmlPullParserException {
                tagging.tagSet = (Tagging.TagSet) QCloudXml.fromXml(xmlPullParser, Tagging.TagSet.class, "TagSet");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public Tagging fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        Tagging tagging = new Tagging();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return tagging;
            }
            if (i == 2) {
                ChildElementBinder<Tagging> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, tagging, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Tagging" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return tagging;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, Tagging tagging, String str) throws IOException, XmlPullParserException {
        if (tagging == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Tagging";
        }
        xmlSerializer.startTag("", str2);
        if (tagging.tagSet != null) {
            QCloudXml.toXml(xmlSerializer, tagging.tagSet, "TagSet");
        }
        xmlSerializer.endTag("", str2);
    }
}
