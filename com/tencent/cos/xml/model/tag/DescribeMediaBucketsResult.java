package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DescribeMediaBucketsResult.class */
public class DescribeMediaBucketsResult {
    public List<MediaBucketList> mediaBucketList;
    public int pageNumber;
    public int pageSize;
    public String requestId;
    public int totalCount;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DescribeMediaBucketsResult$MediaBucketList.class */
    public static class MediaBucketList {
        public String bucketId;
        public String createTime;
        public String name;
        public String region;
    }
}
