package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets.class */
public class ListAllMyBuckets {
    public List<Bucket> buckets;
    public Owner owner;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket.class */
    public static class Bucket {
        public String createDate;
        public String location;
        public String name;
        public String type;

        public String toString() {
            return "{Bucket:\nName:" + this.name + "\nLocation:" + this.location + "\nCreateDate:" + this.createDate + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner.class */
    public static class Owner {
        public String disPlayName;
        public String id;

        public String toString() {
            return "{Owner:\nID:" + this.id + "\nDisPlayName:" + this.disPlayName + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListAllMyBuckets:\n");
        Owner owner = this.owner;
        if (owner != null) {
            sb.append(owner.toString());
            sb.append("\n");
        }
        sb.append("Buckets:\n");
        for (Bucket bucket : this.buckets) {
            if (bucket != null) {
                sb.append(bucket.toString());
                sb.append("\n");
            }
        }
        sb.append("}");
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }
}
