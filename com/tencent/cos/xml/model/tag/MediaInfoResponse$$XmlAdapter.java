package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfoResponse$$XmlAdapter.class */
public class MediaInfoResponse$$XmlAdapter implements IXmlAdapter<MediaInfoResponse> {
    private HashMap<String, ChildElementBinder<MediaInfoResponse>> childElementBinders;

    public MediaInfoResponse$$XmlAdapter() {
        HashMap<String, ChildElementBinder<MediaInfoResponse>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("MediaInfo", new ChildElementBinder<MediaInfoResponse>() { // from class: com.tencent.cos.xml.model.tag.MediaInfoResponse$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, MediaInfoResponse mediaInfoResponse, String str) throws IOException, XmlPullParserException {
                mediaInfoResponse.mediaInfo = (MediaInfo) QCloudXml.fromXml(xmlPullParser, MediaInfo.class, "MediaInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public MediaInfoResponse fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        MediaInfoResponse mediaInfoResponse = new MediaInfoResponse();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return mediaInfoResponse;
            }
            if (i == 2) {
                ChildElementBinder<MediaInfoResponse> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, mediaInfoResponse, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return mediaInfoResponse;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, MediaInfoResponse mediaInfoResponse, String str) throws IOException, XmlPullParserException {
        if (mediaInfoResponse == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (mediaInfoResponse.mediaInfo != null) {
            QCloudXml.toXml(xmlSerializer, mediaInfoResponse.mediaInfo, "MediaInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
