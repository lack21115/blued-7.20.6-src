package com.tencent.cos.xml.model.tag.pic;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/ImageInfo$$XmlAdapter.class */
public class ImageInfo$$XmlAdapter implements IXmlAdapter<ImageInfo> {
    private HashMap<String, ChildElementBinder<ImageInfo>> childElementBinders;

    public ImageInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ImageInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Format", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.format = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Width", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.width = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Height", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.height = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Quality", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.quality = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Ave", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.ave = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Orientation", new ChildElementBinder<ImageInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.ImageInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                imageInfo.orientation = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ImageInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ImageInfo imageInfo = new ImageInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imageInfo;
            }
            if (i == 2) {
                ChildElementBinder<ImageInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imageInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ImageInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imageInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ImageInfo imageInfo, String str) throws IOException, XmlPullParserException {
        if (imageInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ImageInfo";
        }
        xmlSerializer.startTag("", str2);
        if (imageInfo.format != null) {
            xmlSerializer.startTag("", "Format");
            xmlSerializer.text(String.valueOf(imageInfo.format));
            xmlSerializer.endTag("", "Format");
        }
        xmlSerializer.startTag("", "Width");
        xmlSerializer.text(String.valueOf(imageInfo.width));
        xmlSerializer.endTag("", "Width");
        xmlSerializer.startTag("", "Height");
        xmlSerializer.text(String.valueOf(imageInfo.height));
        xmlSerializer.endTag("", "Height");
        xmlSerializer.startTag("", "Quality");
        xmlSerializer.text(String.valueOf(imageInfo.quality));
        xmlSerializer.endTag("", "Quality");
        if (imageInfo.ave != null) {
            xmlSerializer.startTag("", "Ave");
            xmlSerializer.text(String.valueOf(imageInfo.ave));
            xmlSerializer.endTag("", "Ave");
        }
        xmlSerializer.startTag("", "Orientation");
        xmlSerializer.text(String.valueOf(imageInfo.orientation));
        xmlSerializer.endTag("", "Orientation");
        xmlSerializer.endTag("", str2);
    }
}
