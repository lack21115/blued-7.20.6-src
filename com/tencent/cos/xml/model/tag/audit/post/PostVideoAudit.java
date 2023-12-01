package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit.class */
public class PostVideoAudit {
    public AuditInput input = new AuditInput();
    public VideoAuditConf conf = new VideoAuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit$Snapshot.class */
    public static class Snapshot {
        public int count;
        public String mode;
        public float timeInterval;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostVideoAudit$VideoAuditConf.class */
    public static class VideoAuditConf extends AuditConf {
        public String callbackVersion;
        public int detectContent;
        public Snapshot snapshot = new Snapshot();
    }
}
