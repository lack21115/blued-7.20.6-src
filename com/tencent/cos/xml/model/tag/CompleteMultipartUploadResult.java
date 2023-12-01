package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.pic.ImageInfo;
import com.tencent.cos.xml.model.tag.pic.PicObject;
import com.tencent.cos.xml.model.tag.pic.PicOriginalInfo;
import com.tencent.cos.xml.model.tag.pic.PicUploadResult;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CompleteMultipartUploadResult.class */
public class CompleteMultipartUploadResult {
    public String eTag;
    public ImageInfo imageInfo;
    public String key;
    public String location;
    public List<PicObject> processResults;

    public PicOriginalInfo getOriginInfo() {
        PicOriginalInfo picOriginalInfo = new PicOriginalInfo();
        picOriginalInfo.location = this.location;
        picOriginalInfo.key = this.key;
        picOriginalInfo.etag = this.eTag;
        picOriginalInfo.imageInfo = this.imageInfo;
        return picOriginalInfo;
    }

    public PicUploadResult getPicUploadResult() {
        PicUploadResult picUploadResult = new PicUploadResult();
        picUploadResult.processResults = this.processResults;
        picUploadResult.originalInfo = getOriginInfo();
        return picUploadResult;
    }
}
