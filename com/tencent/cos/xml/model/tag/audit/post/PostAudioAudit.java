package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostAudioAudit.class */
public class PostAudioAudit {
    public AuditInput input = new AuditInput();
    public AudioAuditConf conf = new AudioAuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostAudioAudit$AudioAuditConf.class */
    public static class AudioAuditConf extends AuditConf {
        public String callbackVersion;
    }
}
