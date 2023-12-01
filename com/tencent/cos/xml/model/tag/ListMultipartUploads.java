package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListMultipartUploads.class */
public class ListMultipartUploads {
    public String bucket;
    public List<CommonPrefixes> commonPrefixes;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String keyMarker;
    public String maxUploads;
    public String nextKeyMarker;
    public String nextUploadIdMarker;
    public String prefix;
    public String uploadIdMarker;
    public List<Upload> uploads;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes.class */
    public static class CommonPrefixes {
        public String prefix;

        public String toString() {
            return "{CommonPrefixes:\nPrefix:" + this.prefix + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator.class */
    public static class Initiator {
        public String displayName;
        public String id;
        public String uin;

        public String toString() {
            return "{Initiator:\nUin:" + this.uin + "\nId:" + this.id + "\nDisplayName:" + this.displayName + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListMultipartUploads$Owner.class */
    public static class Owner {
        public String displayName;
        public String id;
        public String uid;

        public String toString() {
            return "{Owner:\nUid:" + this.uid + "\nId:" + this.id + "\nDisplayName:" + this.displayName + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListMultipartUploads$Upload.class */
    public static class Upload {
        public String initiated;
        public Initiator initiator;
        public String key;
        public Owner owner;
        public String storageClass;
        public String uploadID;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Upload:\n");
            sb.append("Key:");
            sb.append(this.key);
            sb.append("\n");
            sb.append("UploadID:");
            sb.append(this.uploadID);
            sb.append("\n");
            sb.append("StorageClass:");
            sb.append(this.storageClass);
            sb.append("\n");
            Initiator initiator = this.initiator;
            if (initiator != null) {
                sb.append(initiator.toString());
                sb.append("\n");
            }
            Owner owner = this.owner;
            if (owner != null) {
                sb.append(owner.toString());
                sb.append("\n");
            }
            sb.append("Initiated:");
            sb.append(this.initiated);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListMultipartUploads:\n");
        sb.append("Bucket:");
        sb.append(this.bucket);
        sb.append("\n");
        sb.append("Encoding-Type:");
        sb.append(this.encodingType);
        sb.append("\n");
        sb.append("KeyMarker:");
        sb.append(this.keyMarker);
        sb.append("\n");
        sb.append("UploadIdMarker:");
        sb.append(this.uploadIdMarker);
        sb.append("\n");
        sb.append("NextKeyMarker:");
        sb.append(this.nextKeyMarker);
        sb.append("\n");
        sb.append("NextUploadIdMarker:");
        sb.append(this.nextUploadIdMarker);
        sb.append("\n");
        sb.append("MaxUploads:");
        sb.append(this.maxUploads);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        sb.append("Prefix:");
        sb.append(this.prefix);
        sb.append("\n");
        sb.append("Delimiter:");
        sb.append(this.delimiter);
        sb.append("\n");
        List<Upload> list = this.uploads;
        if (list != null) {
            for (Upload upload : list) {
                if (upload != null) {
                    sb.append(upload.toString());
                    sb.append("\n");
                }
            }
        }
        List<CommonPrefixes> list2 = this.commonPrefixes;
        if (list2 != null) {
            for (CommonPrefixes commonPrefixes : list2) {
                if (commonPrefixes != null) {
                    sb.append(commonPrefixes.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
