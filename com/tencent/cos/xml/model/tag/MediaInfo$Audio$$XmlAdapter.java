package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.MediaInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Audio$$XmlAdapter.class */
public class MediaInfo$Audio$$XmlAdapter implements IXmlAdapter<MediaInfo.Audio> {
    private HashMap<String, ChildElementBinder<MediaInfo.Audio>> childElementBinders;

    public MediaInfo$Audio$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfo.Audio>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Index", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.index = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("CodecName", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.codecName = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CodecLongName", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.codecLongName = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CodecTimeBase", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.codecTimeBase = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CodecTagString", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.codecTagString = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CodecTag", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.codecTag = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SampleFmt", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.sampleFmt = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SampleRate", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.sampleRate = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Channel", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.channel = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("ChannelLayout", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.channelLayout = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Timebase", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.timebase = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("StartTime", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.12
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.startTime = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Duration", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.13
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.duration = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Bitrate", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.14
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.bitrate = Float.parseFloat(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Language", new ChildElementBinder<MediaInfo.Audio>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Audio$$XmlAdapter.15
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audio.language = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfo.Audio fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfo.Audio audio = new MediaInfo.Audio();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return audio;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfo.Audio> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, audio, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Audio" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return audio;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfo.Audio audio, String str) throws IOException, XmlPullParserException {
        if (audio == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Audio";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Index");
        xmlSerializer.text(String.valueOf(audio.index));
        xmlSerializer.endTag("", "Index");
        if (audio.codecName != null) {
            xmlSerializer.startTag("", "CodecName");
            xmlSerializer.text(String.valueOf(audio.codecName));
            xmlSerializer.endTag("", "CodecName");
        }
        if (audio.codecLongName != null) {
            xmlSerializer.startTag("", "CodecLongName");
            xmlSerializer.text(String.valueOf(audio.codecLongName));
            xmlSerializer.endTag("", "CodecLongName");
        }
        if (audio.codecTimeBase != null) {
            xmlSerializer.startTag("", "CodecTimeBase");
            xmlSerializer.text(String.valueOf(audio.codecTimeBase));
            xmlSerializer.endTag("", "CodecTimeBase");
        }
        if (audio.codecTagString != null) {
            xmlSerializer.startTag("", "CodecTagString");
            xmlSerializer.text(String.valueOf(audio.codecTagString));
            xmlSerializer.endTag("", "CodecTagString");
        }
        if (audio.codecTag != null) {
            xmlSerializer.startTag("", "CodecTag");
            xmlSerializer.text(String.valueOf(audio.codecTag));
            xmlSerializer.endTag("", "CodecTag");
        }
        if (audio.sampleFmt != null) {
            xmlSerializer.startTag("", "SampleFmt");
            xmlSerializer.text(String.valueOf(audio.sampleFmt));
            xmlSerializer.endTag("", "SampleFmt");
        }
        xmlSerializer.startTag("", "SampleRate");
        xmlSerializer.text(String.valueOf(audio.sampleRate));
        xmlSerializer.endTag("", "SampleRate");
        xmlSerializer.startTag("", "Channel");
        xmlSerializer.text(String.valueOf(audio.channel));
        xmlSerializer.endTag("", "Channel");
        if (audio.channelLayout != null) {
            xmlSerializer.startTag("", "ChannelLayout");
            xmlSerializer.text(String.valueOf(audio.channelLayout));
            xmlSerializer.endTag("", "ChannelLayout");
        }
        if (audio.timebase != null) {
            xmlSerializer.startTag("", "Timebase");
            xmlSerializer.text(String.valueOf(audio.timebase));
            xmlSerializer.endTag("", "Timebase");
        }
        xmlSerializer.startTag("", "StartTime");
        xmlSerializer.text(String.valueOf(audio.startTime));
        xmlSerializer.endTag("", "StartTime");
        xmlSerializer.startTag("", "Duration");
        xmlSerializer.text(String.valueOf(audio.duration));
        xmlSerializer.endTag("", "Duration");
        xmlSerializer.startTag("", "Bitrate");
        xmlSerializer.text(String.valueOf(audio.bitrate));
        xmlSerializer.endTag("", "Bitrate");
        if (audio.language != null) {
            xmlSerializer.startTag("", "Language");
            xmlSerializer.text(String.valueOf(audio.language));
            xmlSerializer.endTag("", "Language");
        }
        xmlSerializer.endTag("", str2);
    }
}
