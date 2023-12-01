package com.anythink.network.gdt;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATRequestInfo.class */
public class GDTATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f6114a;

    public GDTATRequestInfo(String str, String str2) {
        this.networkFirmId = 8;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f6114a = hashMap;
        hashMap.put("app_id", str);
        this.f6114a.put("unit_id", str2);
    }

    public Map<String, Object> getRequestParamMap() {
        return this.f6114a;
    }

    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = GDTATSplashAdapter.class.getName();
    }
}
