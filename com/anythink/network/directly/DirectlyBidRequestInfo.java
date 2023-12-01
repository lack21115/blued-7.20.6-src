package com.anythink.network.directly;

import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/directly/DirectlyBidRequestInfo.class */
public class DirectlyBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    JSONObject f6077a = new JSONObject();

    public void fillBannerData(Map<String, Object> map) {
        try {
            String obj = map.get(OapsKey.KEY_SIZE).toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            String[] split = obj.split("x");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            this.f6077a.put("ad_width", parseInt);
            this.f6077a.put("ad_height", parseInt2);
        } catch (Throwable th) {
        }
    }

    public void fillSplashData() {
        try {
            this.f6077a.put("get_offer", 2);
        } catch (Throwable th) {
        }
    }

    public JSONObject toRequestJSONObject() {
        return this.f6077a;
    }
}
