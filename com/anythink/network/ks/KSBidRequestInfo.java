package com.anythink.network.ks;

import android.drm.DrmInfoRequest;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSBidRequestInfo.class */
public class KSBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    String f6179a;
    JSONObject b = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    int f6180c;
    String d;
    String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KSBidRequestInfo(Map<String, Object> map, Map<String, Object> map2) {
        int parseDouble;
        int parseDouble2;
        try {
            String str = (String) map.get(DrmInfoRequest.ACCOUNT_ID);
            String str2 = (String) map.get("position_id");
            if (map.containsKey("orientation")) {
                this.f6180c = Integer.parseInt(map.get("orientation").toString());
            }
            if (map2 != null) {
                this.d = map2.get(SearchIndexablesContract.RawData.COLUMN_USER_ID) != null ? map2.get(SearchIndexablesContract.RawData.COLUMN_USER_ID).toString() : "";
                this.e = map2.get("user_custom_data") != null ? map2.get("user_custom_data").toString() : "";
            }
            if (!TextUtils.isEmpty(this.e) && this.e.contains("{network_placement_id}")) {
                this.e = this.e.replace("{network_placement_id}", String.valueOf(str2));
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.d)) {
                hashMap.put("thirdUserId", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("extraData", this.e);
            }
            KsScene.Builder screenOrientation = new KsScene.Builder(Long.parseLong(str2)).adNum(1).screenOrientation(this.f6180c == 2 ? 2 : 1);
            KsScene.Builder rewardCallbackExtraData = hashMap.isEmpty() ? screenOrientation : screenOrientation.rewardCallbackExtraData(hashMap);
            Object obj = null;
            Object obj2 = map2.containsKey("key_width") ? map2.get("key_width") : null;
            obj = map2.containsKey("key_height") ? map2.get("key_height") : obj;
            if (obj2 != null && (parseDouble2 = (int) Double.parseDouble(obj2.toString())) > 0) {
                rewardCallbackExtraData.width(parseDouble2);
            }
            if (obj != null && (parseDouble = (int) Double.parseDouble(obj.toString())) > 0) {
                rewardCallbackExtraData.height(parseDouble);
            }
            this.f6179a = KsAdSDK.getLoadManager().getBidRequestTokenV2(rewardCallbackExtraData.build());
            this.b.put(DrmInfoRequest.ACCOUNT_ID, str);
            this.b.put("unit_id", str2);
            this.b.put("bid_token", this.f6179a);
        } catch (Throwable th) {
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f6179a);
    }

    public JSONObject toRequestJSONObject() {
        return this.b;
    }
}
