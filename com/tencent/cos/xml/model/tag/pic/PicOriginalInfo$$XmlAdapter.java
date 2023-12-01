package com.tencent.cos.xml.model.tag.pic;

import com.google.common.net.HttpHeaders;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/PicOriginalInfo$$XmlAdapter.class */
public class PicOriginalInfo$$XmlAdapter implements IXmlAdapter<PicOriginalInfo> {
    private HashMap<String, ChildElementBinder<PicOriginalInfo>> childElementBinders;

    public PicOriginalInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PicOriginalInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Key", new ChildElementBinder<PicOriginalInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.PicOriginalInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PicOriginalInfo picOriginalInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                picOriginalInfo.key = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<PicOriginalInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.PicOriginalInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PicOriginalInfo picOriginalInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                picOriginalInfo.location = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("ETag", new ChildElementBinder<PicOriginalInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.PicOriginalInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PicOriginalInfo picOriginalInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                picOriginalInfo.etag = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("ImageInfo", new ChildElementBinder<PicOriginalInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.PicOriginalInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PicOriginalInfo picOriginalInfo, String str) throws IOException, XmlPullParserException {
                picOriginalInfo.imageInfo = (ImageInfo) QCloudXml.fromXml(xmlPullParser, ImageInfo.class, "ImageInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PicOriginalInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PicOriginalInfo picOriginalInfo = new PicOriginalInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return picOriginalInfo;
            }
            if (i == 2) {
                ChildElementBinder<PicOriginalInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, picOriginalInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "OriginalInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return picOriginalInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PicOriginalInfo picOriginalInfo, String str) throws IOException, XmlPullParserException {
        if (picOriginalInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "OriginalInfo";
        }
        xmlSerializer.startTag("", str2);
        if (picOriginalInfo.key != null) {
            xmlSerializer.startTag("", "Key");
            xmlSerializer.text(String.valueOf(picOriginalInfo.key));
            xmlSerializer.endTag("", "Key");
        }
        if (picOriginalInfo.location != null) {
            xmlSerializer.startTag("", HttpHeaders.LOCATION);
            xmlSerializer.text(String.valueOf(picOriginalInfo.location));
            xmlSerializer.endTag("", HttpHeaders.LOCATION);
        }
        if (picOriginalInfo.etag != null) {
            xmlSerializer.startTag("", "ETag");
            xmlSerializer.text(String.valueOf(picOriginalInfo.etag));
            xmlSerializer.endTag("", "ETag");
        }
        if (picOriginalInfo.imageInfo != null) {
            QCloudXml.toXml(xmlSerializer, picOriginalInfo.imageInfo, "ImageInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
