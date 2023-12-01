package com.anythink.network.toutiao;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATCustomAdSlotBuilder.class */
public class TTATCustomAdSlotBuilder extends AdSlot.Builder {

    /* renamed from: a  reason: collision with root package name */
    private final String f6258a = getClass().getSimpleName();

    private TTATCustomAdSlotBuilder() {
    }

    public TTATCustomAdSlotBuilder(String str, Map<String, Object> map, Map<String, Object> map2) {
        setCodeId(str);
        try {
            if (map.containsKey("anythink_adload_seq")) {
                int intValue = ((Integer) map.get("anythink_adload_seq")).intValue();
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i(this.f6258a, "adLoadSeq: ".concat(String.valueOf(intValue)));
                }
                setAdloadSeq(intValue);
            }
        } catch (Throwable th) {
        }
        try {
            if (map.containsKey("anythink_content")) {
                String optString = new JSONObject((String) map.get("anythink_content")).optString("slot_id", "");
                if (!TextUtils.isEmpty(optString)) {
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i(this.f6258a, "primeRit: ".concat(String.valueOf(optString)));
                    }
                    setPrimeRit(optString);
                }
            }
        } catch (Throwable th2) {
        }
        if (map2 == null || !map2.containsKey(TTATConst.AD_LOAD_TYPE)) {
            return;
        }
        Object obj = map2.get(TTATConst.AD_LOAD_TYPE);
        if (obj instanceof TTAdLoadType) {
            setAdLoadType((TTAdLoadType) obj);
        }
    }
}
