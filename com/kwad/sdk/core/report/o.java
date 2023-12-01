package com.kwad.sdk.core.report;

import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/o.class */
public final class o {
    public SubBusinessType aiC;
    public com.kwai.adclient.kscommerciallogger.model.d aiD;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String suffixRatio;
    public String tag;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/o$a.class */
    public static final class a {
        private String category;
        private String eventId;
        private JSONObject msg;
        private String tag;
        private BusinessType biz = BusinessType.OTHER;
        private SubBusinessType subBiz = SubBusinessType.OTHER;
        private com.kwai.adclient.kscommerciallogger.model.d aiD = com.kwai.adclient.kscommerciallogger.model.d.aEG;
        private String suffixRatio = "";

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final a a(SubBusinessType subBusinessType) {
            this.subBiz = subBusinessType;
            return this;
        }

        public final a a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
            this.aiD = dVar;
            return this;
        }

        public final a b(BusinessType businessType) {
            this.biz = businessType;
            return this;
        }

        public final a cE(String str) {
            this.category = str;
            return this;
        }

        public final a cF(String str) {
            this.eventId = str;
            return this;
        }

        public final a cG(String str) {
            this.tag = str;
            return this;
        }

        public final o xa() {
            return new o(this.category, this.biz, this.subBiz, this.aiD, this.eventId, this.tag, this.suffixRatio, this.msg, (byte) 0);
        }
    }

    private o(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, String str3, String str4, JSONObject jSONObject) {
        this.biz = BusinessType.OTHER;
        this.aiC = SubBusinessType.OTHER;
        this.aiD = com.kwai.adclient.kscommerciallogger.model.d.aEG;
        this.category = str;
        this.biz = businessType;
        this.aiC = subBusinessType;
        this.aiD = dVar;
        this.eventId = str2;
        this.tag = str3;
        this.suffixRatio = str4;
        this.msg = jSONObject;
    }

    /* synthetic */ o(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, String str3, String str4, JSONObject jSONObject, byte b) {
        this(str, businessType, subBusinessType, dVar, str2, str3, str4, jSONObject);
    }
}
