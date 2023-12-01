package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/UrlUploadPolicy.class */
public class UrlUploadPolicy {
    private final Type downloadType;
    private final long fileLength;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/UrlUploadPolicy$Type.class */
    public enum Type {
        NOTSUPPORT,
        RANGE,
        ENTIRETY
    }

    public UrlUploadPolicy(Type type, long j) {
        this.downloadType = type;
        this.fileLength = j;
    }

    public Type getDownloadType() {
        return this.downloadType;
    }

    public long getFileLength() {
        return this.fileLength;
    }
}
