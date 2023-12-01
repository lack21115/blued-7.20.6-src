package com.anythink.core.api;

import com.anythink.core.common.b.n;
import java.util.Map;

@Deprecated
/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATMediationRequestInfo.class */
public abstract class ATMediationRequestInfo {
    protected String adSourceId;
    protected String className;
    protected int networkFirmId;

    public String getAdSourceId() {
        return this.adSourceId;
    }

    public String getClassName() {
        return this.className;
    }

    public int getNetworkFirmId() {
        return this.networkFirmId;
    }

    public abstract Map<String, Object> getRequestParamMap();

    public void setAdSourceId(String str) {
        this.adSourceId = str;
        n.a();
        n.n(str);
    }

    public abstract void setFormat(String str);
}
