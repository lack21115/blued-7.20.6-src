package com.anythink.network.gdt;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRequestInfo.class */
public class GDTATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f8954a;

    public GDTATRequestInfo(String str, String str2) {
        this.networkFirmId = 8;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f8954a = hashMap;
        hashMap.put("app_id", str);
        this.f8954a.put("unit_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public Map<String, Object> getRequestParamMap() {
        return this.f8954a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = GDTATSplashAdapter.class.getName();
    }
}
