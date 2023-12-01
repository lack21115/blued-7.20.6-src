package com.anythink.network.baidu;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATRequestInfo.class */
public class BaiduATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f8892a;

    public BaiduATRequestInfo(String str, String str2) {
        this.networkFirmId = 22;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f8892a = hashMap;
        hashMap.put("app_id", str);
        this.f8892a.put("ad_place_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public Map<String, Object> getRequestParamMap() {
        return this.f8892a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = BaiduATSplashAdapter.class.getName();
    }
}
