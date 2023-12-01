package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostImagesAudit.class */
public class PostImagesAudit {
    public List<ImagesAuditInput> input = new ArrayList();
    public AuditConf conf = new AuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostImagesAudit$ImagesAuditInput.class */
    public static class ImagesAuditInput extends AuditInput {
        public int interval;
        public int maxFrames;
    }
}
