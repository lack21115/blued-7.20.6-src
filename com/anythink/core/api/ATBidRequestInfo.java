package com.anythink.core.api;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.c.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.v;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATBidRequestInfo.class */
public abstract class ATBidRequestInfo {
    public static final String BIDDING_REQUEST_TIMEOUT_TYPE = "Request Timeout.";
    public static final String BIDTOKEN_EMPTY_ERROR_TYPE = "Network BidToken or Custom bid info is Empty.";
    public static final String BIDTOKEN_OBTAIN_TIMEOUT_TYPE = "Request Token or Custom bid info Timeout.";
    public static final String INIT_ERROR_TYPE = "Network init error.";
    public static final String NO_ADAPTER_ERROR_TYPE = "There is no Network Adapter.";
    public static final String NO_SUPPORT_BIDDING_TYPE = "This network don't support header bidding in current TopOn's version.";
    public static final String RETURN_PARAMS_ERROR_TYPE = "The parameter is abnormal.";

    public static void fillBaseCommonParams(JSONObject jSONObject, String str, d dVar, ai aiVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, str);
                jSONObject.put("ad_source_id", aiVar.t());
                jSONObject.put("nw_firm_id", aiVar.c());
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, aiVar.a(dVar));
                if (n.a().u()) {
                    jSONObject.put("test", 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public String getExtInfoForBuyerId(String str) {
        return v.a().g(str);
    }

    public abstract JSONObject toRequestJSONObject();
}
