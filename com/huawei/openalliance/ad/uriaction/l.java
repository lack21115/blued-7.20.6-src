package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/l.class */
public class l extends q {
    private static String C = "arContentVertify";
    private static String S = "1";
    private static final String V = "OpenArAction";
    Map<String, String> Code;

    public l(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.Code = map;
    }

    private boolean Code(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", adContentData.S());
            jSONObject.put(at.C, adContentData.az());
            jSONObject.put(at.ac, adContentData.C());
            jSONObject.put(at.S, adContentData.aA());
            String str = (String) com.huawei.openalliance.ad.ipc.b.Code(this.I).Code(C, jSONObject.toString(), String.class).getData();
            ge.V(V, "result:" + str);
            if (au.Code(str) || !S.equalsIgnoreCase(str)) {
                eh.Code(this.I, adContentData.S(), adContentData, str);
                return false;
            }
            return true;
        } catch (JSONException e) {
            ge.I(V, "isArContentPrepared JSONException");
            return false;
        }
    }

    private boolean V(AdContentData adContentData) {
        if (ds.Code(this.I, adContentData, this.Code)) {
            Code(s.L);
            return true;
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        if (this.Z == null) {
            ge.I(V, "contentRecord is null");
            eh.Code(this.I, "", (AdContentData) null, com.huawei.openalliance.ad.constant.m.Code);
            return V();
        } else if (Code(this.Z)) {
            return V(this.Z);
        } else {
            ge.V(V, "ar content is not prepared");
            return V();
        }
    }
}
