package com.kwad.sdk.commercial.model;

import com.alipay.sdk.app.statistic.c;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/commercial/model/WebViewCommercialMsg.class */
public class WebViewCommercialMsg extends a implements b, Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public JSONObject msg;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public com.kwai.adclient.kscommerciallogger.model.b type;

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception e) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has(c.b)) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString(c.b));
            } catch (Exception e2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b(jSONObject.optString("type"));
            } catch (Exception e3) {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b("OTHER");
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, c.b, this.biz.value);
        t.putValue(jSONObject, "subBiz", this.subBiz.value);
        t.putValue(jSONObject, "type", this.type.getValue());
    }
}
