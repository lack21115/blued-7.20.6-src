package com.kwad.components.offline.api.core.adlive.model;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/model/KSAdLiveRoomItemInfo.class */
public class KSAdLiveRoomItemInfo extends BaseOfflineCompoJsonParse<KSAdLiveRoomItemInfo> implements Serializable {
    private static final long serialVersionUID = -6149616231567033413L;
    public String imageUrl;
    public String itemId;
    public String price;
    public String title;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveRoomItemInfo.itemId = jSONObject.optString("itemId");
        if (jSONObject.opt("itemId") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.itemId = "";
        }
        kSAdLiveRoomItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (jSONObject.opt("imageUrl") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.imageUrl = "";
        }
        kSAdLiveRoomItemInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.title = "";
        }
        kSAdLiveRoomItemInfo.price = jSONObject.optString("templateVersion");
        if (jSONObject.opt(OapsKey.KEY_PRICE) == JSONObject.NULL) {
            kSAdLiveRoomItemInfo.price = "";
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo) {
        return toJson(kSAdLiveRoomItemInfo, (JSONObject) null);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        String str = kSAdLiveRoomItemInfo.itemId;
        if (str != null && !str.equals("")) {
            t.putValue(jSONObject2, "itemId", kSAdLiveRoomItemInfo.itemId);
        }
        String str2 = kSAdLiveRoomItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            t.putValue(jSONObject2, "imageUrl", kSAdLiveRoomItemInfo.imageUrl);
        }
        String str3 = kSAdLiveRoomItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            t.putValue(jSONObject2, "title", kSAdLiveRoomItemInfo.title);
        }
        String str4 = kSAdLiveRoomItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            t.putValue(jSONObject2, OapsKey.KEY_PRICE, kSAdLiveRoomItemInfo.price);
        }
        return jSONObject2;
    }
}
