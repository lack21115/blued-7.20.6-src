package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListParts.class */
public class ListParts {
    public String bucket;
    public String encodingType;
    public Initiator initiator;
    public boolean isTruncated;
    public String key;
    public String maxParts;
    public String nextPartNumberMarker;
    public Owner owner;
    public String partNumberMarker;
    public List<Part> parts;
    public String storageClass;
    public String uploadId;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListParts$Initiator.class */
    public static class Initiator {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Initiator:\nId:" + this.id + "\nDisPlayName:" + this.disPlayName + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListParts$Owner.class */
    public static class Owner {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Owner:\nId:" + this.id + "\nDisPlayName:" + this.disPlayName + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListParts$Part.class */
    public static class Part {
        public String eTag;
        public String lastModified;
        public String partNumber;
        public String size;

        public String toString() {
            return "{Part:\nPartNumber:" + this.partNumber + "\nLastModified:" + this.lastModified + "\nETag:" + this.eTag + "\nSize:" + this.size + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListParts:\n");
        sb.append("Bucket:");
        sb.append(this.bucket);
        sb.append("\n");
        sb.append("Encoding-Type:");
        sb.append(this.encodingType);
        sb.append("\n");
        sb.append("Key:");
        sb.append(this.key);
        sb.append("\n");
        sb.append("UploadId:");
        sb.append(this.uploadId);
        sb.append("\n");
        Owner owner = this.owner;
        if (owner != null) {
            sb.append(owner.toString());
            sb.append("\n");
        }
        sb.append("PartNumberMarker:");
        sb.append(this.partNumberMarker);
        sb.append("\n");
        Initiator initiator = this.initiator;
        if (initiator != null) {
            sb.append(initiator.toString());
            sb.append("\n");
        }
        sb.append("StorageClass:");
        sb.append(this.storageClass);
        sb.append("\n");
        sb.append("NextPartNumberMarker:");
        sb.append(this.nextPartNumberMarker);
        sb.append("\n");
        sb.append("MaxParts:");
        sb.append(this.maxParts);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        List<Part> list = this.parts;
        if (list != null) {
            for (Part part : list) {
                if (part != null) {
                    sb.append(part.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
