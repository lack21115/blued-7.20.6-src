package com.anythink.network.toutiao;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATRequestInfo.class */
public class TTATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f6294a;

    public TTATRequestInfo(String str, String str2, boolean z) {
        this.networkFirmId = 15;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f6294a = hashMap;
        hashMap.put("app_id", str);
        this.f6294a.put("slot_id", str2);
        this.f6294a.put("personalized_template", z ? "1" : "0");
    }

    public Map<String, Object> getRequestParamMap() {
        return this.f6294a;
    }

    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = TTATSplashAdapter.class.getName();
    }
}
