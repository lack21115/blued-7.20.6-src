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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$$XmlAdapter.class */
public class MediaInfo$$XmlAdapter implements IXmlAdapter<MediaInfo> {
    private HashMap<String, ChildElementBinder<MediaInfo>> childElementBinders;

    public MediaInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Stream", new ChildElementBinder<MediaInfo>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo mediaInfo, String str) throws IOException, XmlPullParserException {
                mediaInfo.stream = (MediaInfo.Stream) QCloudXml.fromXml(xmlPullParser, MediaInfo.Stream.class, "Stream");
            }
        });
        this.childElementBinders.put("Format", new ChildElementBinder<MediaInfo>() { // from class: com.tencent.cos.xml.model.tag.MediaInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfo mediaInfo, String str) throws IOException, XmlPullParserException {
                mediaInfo.format = (MediaInfo.Format) QCloudXml.fromXml(xmlPullParser, MediaInfo.Format.class, "Format");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfo mediaInfo = new MediaInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return mediaInfo;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, mediaInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "MediaInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return mediaInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfo mediaInfo, String str) throws IOException, XmlPullParserException {
        if (mediaInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "MediaInfo";
        }
        xmlSerializer.startTag("", str2);
        if (mediaInfo.stream != null) {
            QCloudXml.toXml(xmlSerializer, mediaInfo.stream, "Stream");
        }
        if (mediaInfo.format != null) {
            QCloudXml.toXml(xmlSerializer, mediaInfo.format, "Format");
        }
        xmlSerializer.endTag("", str2);
    }
}
