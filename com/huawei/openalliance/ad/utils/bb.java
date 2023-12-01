package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/bb.class */
public class bb {
    private static final String Code = "HUAApi";
    private static final String V = "handleUriAction";

    public static <T> T Code(final Context context, final AdContentData adContentData, final int i, final Class<T> cls) {
        if (adContentData == null) {
            ge.V(Code, "contentRecord is null");
            return null;
        }
        return (T) aw.Code(new Callable<T>() { // from class: com.huawei.openalliance.ad.utils.bb.1
            @Override // java.util.concurrent.Callable
            public T call() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("content_id", AdContentData.this.S());
                    jSONObject.put(com.huawei.openalliance.ad.constant.at.C, AdContentData.this.az());
                    jSONObject.put(com.huawei.openalliance.ad.constant.at.ac, AdContentData.this.C());
                    jSONObject.put(com.huawei.openalliance.ad.constant.at.S, AdContentData.this.aA());
                    jSONObject.put(com.huawei.openalliance.ad.constant.at.R, i);
                    jSONObject.put(com.huawei.openalliance.ad.constant.at.X, bb.V(AdContentData.this));
                    return com.huawei.openalliance.ad.ipc.b.Code(context).Code(bb.V, jSONObject.toString(), cls).getData();
                } catch (Throwable th) {
                    ge.I(bb.Code, "handle harmony service enter action fail");
                    return null;
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject V(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.at.Y, adContentData.B());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.O, adContentData.ap());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.N, adContentData.ao());
            return jSONObject;
        } catch (Throwable th) {
            ge.I(Code, "getParamContent ex:%s", th.getClass().getSimpleName());
            return jSONObject;
        }
    }
}
