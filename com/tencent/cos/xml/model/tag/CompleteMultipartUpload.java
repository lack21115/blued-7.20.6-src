package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CompleteMultipartUpload.class */
public class CompleteMultipartUpload {
    public List<Part> parts;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part.class */
    public static class Part {
        public String eTag;
        public int partNumber;
    }
}
