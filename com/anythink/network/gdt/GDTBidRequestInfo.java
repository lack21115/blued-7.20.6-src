package com.anythink.network.gdt;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.qq.e.comm.managers.GDTAdSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTBidRequestInfo.class */
public class GDTBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    String f8971a;
    JSONObject b = new JSONObject();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GDTBidRequestInfo(Map<String, Object> map) {
        try {
            String obj = map.get("app_id").toString();
            String obj2 = map.get("unit_id").toString();
            HashMap hashMap = new HashMap();
            GDTATInitManager.getInstance();
            GDTATInitManager.a(hashMap, map);
            this.f8971a = GDTAdSdk.getGDTAdManger().getBuyerId(hashMap);
            this.b.put("app_id", obj);
            this.b.put("unit_id", obj2);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID, this.f8971a);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, GDTAdSdk.getGDTAdManger().getSDKInfo(obj2));
        } catch (Throwable th) {
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f8971a);
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.b;
    }
}
