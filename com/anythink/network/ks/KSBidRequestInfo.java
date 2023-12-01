package com.anythink.network.ks;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSBidRequestInfo.class */
public class KSBidRequestInfo extends ATBidRequestInfo {

    /* renamed from: a  reason: collision with root package name */
    String f9019a;
    JSONObject b = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    int f9020c;
    String d;
    String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KSBidRequestInfo(Map<String, Object> map, Map<String, Object> map2) {
        int parseDouble;
        int parseDouble2;
        try {
            String str = (String) map.get("account_id");
            String str2 = (String) map.get("position_id");
            if (map.containsKey("orientation")) {
                this.f9020c = Integer.parseInt(map.get("orientation").toString());
            }
            if (map2 != null) {
                this.d = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
                this.e = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
            }
            if (!TextUtils.isEmpty(this.e) && this.e.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.e = this.e.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, String.valueOf(str2));
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.d)) {
                hashMap.put("thirdUserId", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("extraData", this.e);
            }
            KsScene.Builder screenOrientation = new KsScene.Builder(Long.parseLong(str2)).adNum(1).screenOrientation(this.f9020c == 2 ? 2 : 1);
            KsScene.Builder rewardCallbackExtraData = hashMap.isEmpty() ? screenOrientation : screenOrientation.rewardCallbackExtraData(hashMap);
            Object obj = null;
            Object obj2 = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? map2.get(ATAdConst.KEY.AD_WIDTH) : null;
            obj = map2.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map2.get(ATAdConst.KEY.AD_HEIGHT) : obj;
            if (obj2 != null && (parseDouble2 = (int) Double.parseDouble(obj2.toString())) > 0) {
                rewardCallbackExtraData.width(parseDouble2);
            }
            if (obj != null && (parseDouble = (int) Double.parseDouble(obj.toString())) > 0) {
                rewardCallbackExtraData.height(parseDouble);
            }
            this.f9019a = KsAdSDK.getLoadManager().getBidRequestTokenV2(rewardCallbackExtraData.build());
            this.b.put("account_id", str);
            this.b.put("unit_id", str2);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN, this.f9019a);
        } catch (Throwable th) {
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f9019a);
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.b;
    }
}
