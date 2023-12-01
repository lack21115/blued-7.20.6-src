package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.MediaInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Subtitle$$XmlAdapter.class */
public class MediaInfo$Subtitle$$XmlAdapter implements IXmlAdapter<MediaInfo.Subtitle> {
    private HashMap<String, ChildElementBinder<MediaInfo.Subtitle>> childElementBinders;

    public MediaInfo$Subtitle$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfo.Subtitle>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Index", new ChildElementBinder<MediaInfo.Subtitle>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Subtitle$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Subtitle subtitle, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                subtitle.index = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Language", new ChildElementBinder<MediaInfo.Subtitle>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Subtitle$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Subtitle subtitle, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                subtitle.language = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfo.Subtitle fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfo.Subtitle subtitle = new MediaInfo.Subtitle();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return subtitle;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfo.Subtitle> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, subtitle, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Subtitle" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return subtitle;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfo.Subtitle subtitle, String str) throws IOException, XmlPullParserException {
        if (subtitle == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Subtitle";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Index");
        xmlSerializer.text(String.valueOf(subtitle.index));
        xmlSerializer.endTag("", "Index");
        if (subtitle.language != null) {
            xmlSerializer.startTag("", "Language");
            xmlSerializer.text(String.valueOf(subtitle.language));
            xmlSerializer.endTag("", "Language");
        }
        xmlSerializer.endTag("", str2);
    }
}
