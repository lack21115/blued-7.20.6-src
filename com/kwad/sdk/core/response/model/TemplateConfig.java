package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/TemplateConfig.class */
public class TemplateConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -6943205584670122269L;
    public String h5Checksum;
    public String h5Url;
    public String h5Version;

    public boolean notEmpty() {
        return (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.h5Version) || TextUtils.isEmpty(this.h5Checksum)) ? false : true;
    }
}
