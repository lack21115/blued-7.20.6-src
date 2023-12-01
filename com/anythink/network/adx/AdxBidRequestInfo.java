package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.a.b;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxBidRequestInfo.class */
public class AdxBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    JSONObject f6008a;

    public AdxBidRequestInfo(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        this.f6008a = jSONObject;
        try {
            jSONObject.put("tpl_ver", 1);
            d b = e.a(context).b(str);
            if (b != null) {
                int au = b.au();
                if (au > 0) {
                    List a2 = b.a().a(au);
                    if (a2.size() > 0) {
                        this.f6008a.put("exclude_ids", a(a2));
                    }
                }
                int at = b.at();
                if (at > 0) {
                    List b2 = b.a().b(at);
                    if (b2.size() > 0) {
                        this.f6008a.put("install_ids", a(b2));
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private static JSONObject a(List<com.anythink.core.common.a.d> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap hashMap = new HashMap();
            for (com.anythink.core.common.a.d dVar : list) {
                List list2 = (List) hashMap.get(dVar.a());
                ArrayList arrayList = list2;
                if (list2 == null) {
                    arrayList = new ArrayList();
                    hashMap.put(dVar.a(), arrayList);
                }
                arrayList.add(dVar.b());
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
            }
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    public void fillAdAcceptType() {
        try {
            if (this.f6008a != null) {
                this.f6008a.put("adp_accept_type", new JSONArray("[1]"));
            }
        } catch (Throwable th) {
        }
    }

    public void fillBannerData(Map<String, Object> map) {
        try {
            String obj = map.get(OapsKey.KEY_SIZE).toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            String[] split = obj.split("x");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            this.f6008a.put("ad_width", parseInt);
            this.f6008a.put("ad_height", parseInt2);
            this.f6008a.put("adp_accept_type", new JSONArray("[1]"));
        } catch (Throwable th) {
        }
    }

    public void fillInterstitial(Map<String, Object> map) {
        try {
            if (map.containsKey("unit_type")) {
                String stringFromMap = ATInitMediation.getStringFromMap(map, "unit_type");
                if (!TextUtils.isEmpty(stringFromMap)) {
                    this.f6008a.put("unit_type", Integer.parseInt(stringFromMap));
                }
                if (TextUtils.equals(ATInitMediation.getStringFromMap(map, "inter_type", "1"), "1")) {
                    fillAdAcceptType();
                }
            }
        } catch (Throwable th) {
        }
    }

    public void fillSplashData() {
        try {
            this.f6008a.put("get_offer", 2);
            fillAdAcceptType();
        } catch (Throwable th) {
        }
    }

    public JSONObject toRequestJSONObject() {
        return this.f6008a;
    }
}
