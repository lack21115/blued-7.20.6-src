package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/RequestProgress.class */
public class RequestProgress {
    private Boolean enabled;

    public RequestProgress(Boolean bool) {
        this.enabled = bool;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public RequestProgress withEnabled(Boolean bool) {
        setEnabled(bool);
        return this;
    }
}
