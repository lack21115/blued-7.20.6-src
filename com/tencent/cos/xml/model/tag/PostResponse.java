package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/PostResponse.class */
public class PostResponse {
    public String bucket;
    public String eTag;
    public String key;
    public String location;

    public String toString() {
        return "{PostResponse:\nLocation:" + this.location + "\nBucket:" + this.bucket + "\nKey:" + this.key + "\nETag:" + this.eTag + "\n}";
    }
}
