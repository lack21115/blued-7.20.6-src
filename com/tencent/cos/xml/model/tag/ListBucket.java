package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListBucket.class */
public class ListBucket {
    public List<CommonPrefixes> commonPrefixesList;
    public List<Contents> contentsList;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String marker;
    public int maxKeys;
    public String name;
    public String nextMarker;
    public String prefix;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes.class */
    public static class CommonPrefixes {
        public String prefix;

        public String toString() {
            return "{CommonPrefixes:\nPrefix:" + this.prefix + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListBucket$Contents.class */
    public static class Contents {
        public String eTag;
        public String key;
        public String lastModified;
        public Owner owner;
        public long size;
        public String storageClass;

        public String toString() {
            StringBuilder sb = new StringBuilder("{Contents:\n");
            sb.append("Key:");
            sb.append(this.key);
            sb.append("\n");
            sb.append("LastModified:");
            sb.append(this.lastModified);
            sb.append("\n");
            sb.append("ETag:");
            sb.append(this.eTag);
            sb.append("\n");
            sb.append("Size:");
            sb.append(this.size);
            sb.append("\n");
            Owner owner = this.owner;
            if (owner != null) {
                sb.append(owner.toString());
                sb.append("\n");
            }
            sb.append("StorageClass:");
            sb.append(this.storageClass);
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListBucket$Owner.class */
    public static class Owner {
        public String id;

        public String toString() {
            return "{Owner:\nId:" + this.id + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListBucket:\n");
        sb.append("Name:");
        sb.append(this.name);
        sb.append("\n");
        sb.append("Encoding-Type:");
        sb.append(this.encodingType);
        sb.append("\n");
        sb.append("Prefix:");
        sb.append(this.prefix);
        sb.append("\n");
        sb.append("Marker:");
        sb.append(this.marker);
        sb.append("\n");
        sb.append("MaxKeys:");
        sb.append(this.maxKeys);
        sb.append("\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        sb.append("NextMarker:");
        sb.append(this.nextMarker);
        sb.append("\n");
        List<Contents> list = this.contentsList;
        if (list != null) {
            for (Contents contents : list) {
                if (contents != null) {
                    sb.append(contents.toString());
                    sb.append("\n");
                }
            }
        }
        List<CommonPrefixes> list2 = this.commonPrefixesList;
        if (list2 != null) {
            for (CommonPrefixes commonPrefixes : list2) {
                if (commonPrefixes != null) {
                    sb.append(commonPrefixes.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("Delimiter:");
        sb.append(this.delimiter);
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }
}
