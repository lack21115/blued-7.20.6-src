package com.cmic.gen.sdk.tencent.c.b;

import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/h.class */
public class h extends a {
    protected String x = "";
    protected String y = "";

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    protected String a(String str) {
        return this.b + this.f8024c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.x + this.y + this.w;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.a
    public void a_(String str) {
        this.v = t(str);
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f8023a);
            jSONObject.put("sdkver", this.b);
            jSONObject.put("appid", this.f8024c);
            jSONObject.put("imsi", this.d);
            jSONObject.put("operatortype", this.e);
            jSONObject.put("networktype", this.f);
            jSONObject.put("mobilebrand", this.g);
            jSONObject.put("mobilemodel", this.h);
            jSONObject.put("mobilesystem", this.i);
            jSONObject.put("clienttype", this.j);
            jSONObject.put("interfacever", this.k);
            jSONObject.put("expandparams", this.l);
            jSONObject.put("msgid", this.m);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("subimsi", this.o);
            jSONObject.put(com.anythink.expressad.d.a.b.d, this.p);
            jSONObject.put("apppackage", this.q);
            jSONObject.put("appsign", this.r);
            jSONObject.put("ipv4_list", this.s);
            jSONObject.put("ipv6_list", this.t);
            jSONObject.put("sdkType", this.u);
            jSONObject.put("tempPDR", this.v);
            jSONObject.put("scrip", this.x);
            jSONObject.put("userCapaid", this.y);
            jSONObject.put("funcType", this.w);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        return this.f8023a + ContainerUtils.FIELD_DELIMITER + this.b + ContainerUtils.FIELD_DELIMITER + this.f8024c + ContainerUtils.FIELD_DELIMITER + this.d + ContainerUtils.FIELD_DELIMITER + this.e + ContainerUtils.FIELD_DELIMITER + this.f + ContainerUtils.FIELD_DELIMITER + this.g + ContainerUtils.FIELD_DELIMITER + this.h + ContainerUtils.FIELD_DELIMITER + this.i + ContainerUtils.FIELD_DELIMITER + this.j + ContainerUtils.FIELD_DELIMITER + this.k + ContainerUtils.FIELD_DELIMITER + this.l + ContainerUtils.FIELD_DELIMITER + this.m + ContainerUtils.FIELD_DELIMITER + this.n + ContainerUtils.FIELD_DELIMITER + this.o + ContainerUtils.FIELD_DELIMITER + this.p + ContainerUtils.FIELD_DELIMITER + this.q + ContainerUtils.FIELD_DELIMITER + this.r + "&&" + this.s + ContainerUtils.FIELD_DELIMITER + this.t + ContainerUtils.FIELD_DELIMITER + this.u + ContainerUtils.FIELD_DELIMITER + this.v + ContainerUtils.FIELD_DELIMITER + this.x + ContainerUtils.FIELD_DELIMITER + this.y + ContainerUtils.FIELD_DELIMITER + this.w;
    }

    public void v(String str) {
        this.x = t(str);
    }

    public void w(String str) {
        this.y = t(str);
    }
}
