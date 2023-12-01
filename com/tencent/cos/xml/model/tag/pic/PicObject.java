package com.tencent.cos.xml.model.tag.pic;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/PicObject.class */
public class PicObject {
    public String etag;
    public String format;
    public int height;
    public String key;
    public String location;
    public int quality;
    public int size;
    public int width;

    public PicObject() {
    }

    public PicObject(String str, String str2, String str3, int i, int i2, int i3, int i4) {
        this.key = str;
        this.location = str2;
        this.format = str3;
        this.width = i;
        this.height = i2;
        this.size = i3;
        this.quality = i4;
    }
}
