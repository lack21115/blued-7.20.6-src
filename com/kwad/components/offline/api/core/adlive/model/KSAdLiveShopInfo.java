package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/model/KSAdLiveShopInfo.class */
public class KSAdLiveShopInfo extends BaseOfflineCompoJsonParse<KSAdLiveShopInfo> implements Serializable {
    private static final long serialVersionUID = -7139399767269744574L;
    public int changeType;
    public KSAdLiveRoomItemInfo itemInfo;
    public int shopCardType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveShopInfo.shopCardType = jSONObject.optInt("shopCardType");
        kSAdLiveShopInfo.changeType = jSONObject.optInt("changeType");
        KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo = new KSAdLiveRoomItemInfo();
        kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
        kSAdLiveRoomItemInfo.parseJson(jSONObject.optJSONObject("itemInfo"));
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo) {
        return toJson(kSAdLiveShopInfo, (JSONObject) null);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        JsonHelper.putValue(jSONObject2, "itemInfo", kSAdLiveShopInfo.itemInfo);
        int i = kSAdLiveShopInfo.shopCardType;
        if (i != 0) {
            t.putValue(jSONObject2, "shopCardType", i);
        }
        int i2 = kSAdLiveShopInfo.changeType;
        if (i2 != 0) {
            t.putValue(jSONObject2, "changeType", i2);
        }
        return jSONObject2;
    }
}
