package com.anythink.network.baidu;

import com.anythink.core.api.ATMediationRequestInfo;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATRequestInfo.class */
public class BaiduATRequestInfo extends ATMediationRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f6052a;

    public BaiduATRequestInfo(String str, String str2) {
        this.networkFirmId = 22;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f6052a = hashMap;
        hashMap.put("app_id", str);
        this.f6052a.put("ad_place_id", str2);
    }

    public Map<String, Object> getRequestParamMap() {
        return this.f6052a;
    }

    public void setFormat(String str) {
        if ((str.hashCode() == 52 && str.equals("4")) ? false : true) {
            return;
        }
        this.className = BaiduATSplashAdapter.class.getName();
    }
}
