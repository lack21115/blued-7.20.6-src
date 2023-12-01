package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.MediaInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Format$$XmlAdapter.class */
public class MediaInfo$Format$$XmlAdapter implements IXmlAdapter<MediaInfo.Format> {
    private HashMap<String, ChildElementBinder<MediaInfo.Format>> childElementBinders;

    public MediaInfo$Format$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfo.Format>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("NumStream", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.numStream = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("NumProgram", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.numProgram = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("FormatName", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.formatName = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("FormatLongName", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.formatLongName = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("StartTime", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.startTime = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Duration", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.duration = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Bitrate", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.bitrate = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Size", new ChildElementBinder<MediaInfo.Format>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Format$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                format.size = Float.parseFloat(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfo.Format fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfo.Format format = new MediaInfo.Format();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return format;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfo.Format> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, format, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Format" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return format;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfo.Format format, String str) throws IOException, XmlPullParserException {
        if (format == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Format";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "NumStream");
        xmlSerializer.text(String.valueOf(format.numStream));
        xmlSerializer.endTag("", "NumStream");
        xmlSerializer.startTag("", "NumProgram");
        xmlSerializer.text(String.valueOf(format.numProgram));
        xmlSerializer.endTag("", "NumProgram");
        if (format.formatName != null) {
            xmlSerializer.startTag("", "FormatName");
            xmlSerializer.text(String.valueOf(format.formatName));
            xmlSerializer.endTag("", "FormatName");
        }
        if (format.formatLongName != null) {
            xmlSerializer.startTag("", "FormatLongName");
            xmlSerializer.text(String.valueOf(format.formatLongName));
            xmlSerializer.endTag("", "FormatLongName");
        }
        xmlSerializer.startTag("", "StartTime");
        xmlSerializer.text(String.valueOf(format.startTime));
        xmlSerializer.endTag("", "StartTime");
        xmlSerializer.startTag("", "Duration");
        xmlSerializer.text(String.valueOf(format.duration));
        xmlSerializer.endTag("", "Duration");
        xmlSerializer.startTag("", "Bitrate");
        xmlSerializer.text(String.valueOf(format.bitrate));
        xmlSerializer.endTag("", "Bitrate");
        xmlSerializer.startTag("", "Size");
        xmlSerializer.text(String.valueOf(format.size));
        xmlSerializer.endTag("", "Size");
        xmlSerializer.endTag("", str2);
    }
}
