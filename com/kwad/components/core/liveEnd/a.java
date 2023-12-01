package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.aq;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/liveEnd/a.class */
public final class a extends b {
    private IAdLiveEndRequest fW;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.fW = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getBodyMap() {
        return this.fW.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.fW;
        if (iAdLiveEndRequest == null || iAdLiveEndRequest.getHeader() == null || this.fW.getHeader().size() <= 0) {
            return super.getHeader();
        }
        for (String str : this.fW.getHeader().keySet()) {
            if (!TextUtils.isEmpty(this.fW.getHeader().get(str))) {
                addHeader(str, this.fW.getHeader().get(str));
            }
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return aq.appendUrl(this.fW.getUrl(), this.fW.getUrlParam());
    }
}
