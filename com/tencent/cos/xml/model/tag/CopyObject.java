package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CopyObject.class */
public class CopyObject {
    public String eTag;
    public String lastModified;

    public String toString() {
        return "{CopyObject:\nETag:" + this.eTag + "\nLastModified:" + this.lastModified + "\n}";
    }
}
