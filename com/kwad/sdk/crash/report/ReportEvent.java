package com.kwad.sdk.crash.report;

import android.net.wifi.WifiEnterpriseConfig;
import android.speech.tts.TextToSpeech;
import com.kwad.sdk.utils.t;
import com.oplus.quickgame.sdk.hall.Constant;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/ReportEvent.class */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/ReportEvent$CustomStatEvent.class */
    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString("key");
            this.value = jSONObject.optString("value");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "key", this.key);
            t.putValue(jSONObject, "value", this.value);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/ReportEvent$ExceptionEvent.class */
    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "type", this.type);
            t.putValue(jSONObject, "message", this.message);
            t.a(jSONObject, "urlPackage", this.urlPackage);
            t.putValue(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/ReportEvent$StatPackage.class */
    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            t.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/ReportEvent$UrlPackage.class */
    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString(WBPageConstants.ParamKey.PAGE);
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString(WifiEnterpriseConfig.IDENTITY_KEY);
            this.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, WBPageConstants.ParamKey.PAGE, this.page);
            t.putValue(jSONObject, "params", this.params);
            t.putValue(jSONObject, WifiEnterpriseConfig.IDENTITY_KEY, this.identity);
            t.putValue(jSONObject, Constant.Param.KEY_RPK_PAGE_TYPE, this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString(TextToSpeech.Engine.KEY_PARAM_SESSION_ID);
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        t.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        t.putValue(jSONObject, TextToSpeech.Engine.KEY_PARAM_SESSION_ID, this.sessionId);
        t.a(jSONObject, "statPackage", this.statPackage);
        t.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
