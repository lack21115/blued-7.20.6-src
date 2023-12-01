package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/model/c.class */
public final class c {
    private final d aiD;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/model/c$a.class */
    public static final class a {
        private BusinessType aEC;
        private SubBusinessType aED;
        private d aEE;
        private JSONObject aEF;
        private final String mCategory;
        private String mEventId;
        private String mTag;
        private JSONObject msg;

        private a(String str) {
            this.mCategory = str;
        }

        public static a Gc() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Gd() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final c Ge() {
            if (com.kwai.adclient.kscommerciallogger.a.FS().isDebug()) {
                if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.FS().FU() && !com.kwai.adclient.kscommerciallogger.b.fe(this.mEventId)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                return null;
            } else {
                if (com.kwai.adclient.kscommerciallogger.a.FS().FU() && !com.kwai.adclient.kscommerciallogger.b.fe(this.mEventId)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.FS().FT() != null) {
                this.aEF = com.kwai.adclient.kscommerciallogger.a.FS().FT();
            }
            return new c(this, (byte) 0);
        }

        public final a P(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aED = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aEE = dVar;
            return this;
        }

        public final a c(BusinessType businessType) {
            this.aEC = businessType;
            return this;
        }

        public final a ff(String str) {
            this.mTag = str;
            return this;
        }

        public final a fg(String str) {
            this.mEventId = str;
            return this;
        }
    }

    private c(a aVar) {
        this.category = aVar.mCategory;
        this.biz = aVar.aEC;
        this.subBiz = aVar.aED;
        this.tag = aVar.mTag;
        this.aiD = aVar.aEE;
        this.extraParam = aVar.aEF;
        this.eventId = aVar.mEventId;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String FV() {
        return this.category;
    }

    public final BusinessType FW() {
        return this.biz;
    }

    public final SubBusinessType FX() {
        return this.subBiz;
    }

    public final d FY() {
        return this.aiD;
    }

    public final JSONObject FZ() {
        return this.msg;
    }

    public final JSONObject Ga() {
        return this.extraParam;
    }

    public final String Gb() {
        return this.eventId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.biz != null) {
                jSONObject.put("biz", this.biz.value);
            }
            if (this.subBiz != null) {
                jSONObject.put("sub_biz", this.subBiz.value);
            }
            jSONObject.put("tag", this.tag);
            if (this.aiD != null) {
                jSONObject.put("type", this.aiD.getValue());
            }
            if (this.msg != null) {
                jSONObject.put("msg", this.msg);
            }
            if (this.extraParam != null) {
                jSONObject.put("extra_param", this.extraParam);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
