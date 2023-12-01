package com.anythink.network.ks;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATRequestInfo.class */
public class KSATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f9006a;

    public KSATRequestInfo(String str, String str2) {
        this.networkFirmId = 28;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f9006a = hashMap;
        hashMap.put("app_id", str);
        this.f9006a.put("position_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public Map<String, Object> getRequestParamMap() {
        return this.f9006a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = KSATSplashAdapter.class.getName();
    }
}
