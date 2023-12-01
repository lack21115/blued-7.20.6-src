package com.alipay.sdk.packet.impl;

import com.tencent.open.utils.SystemUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/impl/c.class */
public class c extends com.alipay.sdk.packet.e {
    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.packet.e.a("cashier", "gentid");
    }

    @Override // com.alipay.sdk.packet.e
    public String b() {
        return SystemUtils.QQ_VERSION_NAME_5_0_0;
    }
}
