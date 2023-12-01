package com.anythink.network.directly;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/directly/DirectlyBidRequestInfo.class */
public class DirectlyBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    JSONObject f8917a = new JSONObject();

    public void fillBannerData(Map<String, Object> map) {
        try {
            String obj = map.get("size").toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            String[] split = obj.split("x");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            this.f8917a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, parseInt);
            this.f8917a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, parseInt2);
        } catch (Throwable th) {
        }
    }

    public void fillSplashData() {
        try {
            this.f8917a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
        } catch (Throwable th) {
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.f8917a;
    }
}
