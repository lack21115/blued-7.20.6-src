package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.MediaInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Stream$$XmlAdapter.class */
public class MediaInfo$Stream$$XmlAdapter implements IXmlAdapter<MediaInfo.Stream> {
    private HashMap<String, ChildElementBinder<MediaInfo.Stream>> childElementBinders;

    public MediaInfo$Stream$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfo.Stream>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Video", new ChildElementBinder<MediaInfo.Stream>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Stream$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Stream stream, String str) throws IOException, XmlPullParserException {
                stream.video = (MediaInfo.Video) QCloudXml.fromXml(xmlPullParser, MediaInfo.Video.class, "Video");
            }
        });
        this.childElementBinders.put("Audio", new ChildElementBinder<MediaInfo.Stream>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Stream$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Stream stream, String str) throws IOException, XmlPullParserException {
                stream.audio = (MediaInfo.Audio) QCloudXml.fromXml(xmlPullParser, MediaInfo.Audio.class, "Audio");
            }
        });
        this.childElementBinders.put("Subtitle", new ChildElementBinder<MediaInfo.Stream>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$Stream$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo.Stream stream, String str) throws IOException, XmlPullParserException {
                stream.subtitle = (MediaInfo.Subtitle) QCloudXml.fromXml(xmlPullParser, MediaInfo.Subtitle.class, "Subtitle");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfo.Stream fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfo.Stream stream = new MediaInfo.Stream();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return stream;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfo.Stream> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, stream, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Stream" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return stream;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfo.Stream stream, String str) throws IOException, XmlPullParserException {
        if (stream == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Stream";
        }
        xmlSerializer.startTag("", str2);
        if (stream.video != null) {
            QCloudXml.toXml(xmlSerializer, stream.video, "Video");
        }
        if (stream.audio != null) {
            QCloudXml.toXml(xmlSerializer, stream.audio, "Audio");
        }
        if (stream.subtitle != null) {
            QCloudXml.toXml(xmlSerializer, stream.subtitle, "Subtitle");
        }
        xmlSerializer.endTag("", str2);
    }
}
