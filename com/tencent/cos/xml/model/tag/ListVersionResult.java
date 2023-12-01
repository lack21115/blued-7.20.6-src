package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListVersionResult.class */
public class ListVersionResult {
    public List<CommonPrefixes> commonPrefixes;
    public List<DeleteMarker> deleteMarkers;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String keyMarker;
    public int maxKeys;
    public String name;
    public String nextKeyMarker;
    public String nextVersionIdMarker;
    public String prefix;
    public String versionIdMarker;
    public List<Version> versions;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListVersionResult$CommonPrefixes.class */
    public static class CommonPrefixes {
        public String prefix;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListVersionResult$DeleteMarker.class */
    public static class DeleteMarker {
        public boolean isLatest;
        public String key;
        public String lastModified;
        public Owner owner;
        public String versionId;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListVersionResult$Owner.class */
    public static class Owner {
        public String displayName;
        public String id;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListVersionResult$Version.class */
    public static class Version {
        public String etag;
        public boolean isLatest;
        public String key;
        public String lastModified;
        public Owner owner;
        public long size;
        public String storageClass;
        public String versionID;
    }
}
