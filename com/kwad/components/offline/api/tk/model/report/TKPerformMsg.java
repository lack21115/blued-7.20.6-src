package com.kwad.components.offline.api.tk.model.report;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/model/report/TKPerformMsg.class */
public class TKPerformMsg extends BaseOfflineCompoJsonParse<TKPerformMsg> implements Serializable {
    public static final int ENTER_SCENE = -1;
    public static final int OTHER_FAIL = 3;
    public static final int PAGE_STATUS_FAIL = 2;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    public static final int TK_NOT_READY = 4;
    private static final long serialVersionUID = -5293371882532982729L;
    public String errorReason;
    public long initTime;
    public long loadTime;
    public int renderState;
    public long renderTime;
    public int source;
    public String templateId;
    public String versionCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/model/report/TKPerformMsg$ERROR_REASON.class */
    public @interface ERROR_REASON {
        public static final String KSAD_TK_JS_EMPTY = "js_empty";
        public static final String KSAD_TK_NO_FILE = "no_file";
        public static final String KSAD_TK_NO_TEMPLATE = "no_template";
        public static final String KSAD_TK_OFFLINE_FAILED = "offline_failed";
        public static final String KSAD_TK_SO_FAIL = "so_fail";
    }

    public TKPerformMsg(int i) {
        setSource(i);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKPerformMsg.source = jSONObject.optInt("source");
        tKPerformMsg.renderState = jSONObject.optInt("render_state");
        tKPerformMsg.errorReason = jSONObject.optString("error_reason");
        if (jSONObject.opt("error_reason") == JSONObject.NULL) {
            tKPerformMsg.errorReason = "";
        }
        tKPerformMsg.renderTime = jSONObject.optLong("render_time");
        tKPerformMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            tKPerformMsg.templateId = "";
        }
        tKPerformMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKPerformMsg.versionCode = "";
        }
        tKPerformMsg.loadTime = jSONObject.optLong("load_time");
        tKPerformMsg.initTime = jSONObject.optLong("init_time");
    }

    public TKPerformMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKPerformMsg setInitTime(long j) {
        this.initTime = j;
        return this;
    }

    public TKPerformMsg setLoadTime(long j) {
        this.loadTime = j;
        return this;
    }

    public TKPerformMsg setRenderState(int i) {
        this.renderState = i;
        return this;
    }

    public TKPerformMsg setRenderTime(long j) {
        this.renderTime = j;
        return this;
    }

    public TKPerformMsg setSource(int i) {
        this.source = i;
        return this;
    }

    public TKPerformMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKPerformMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg) {
        return toJson(tKPerformMsg, (JSONObject) null);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        JsonHelper.putValue(jSONObject2, "render_state", tKPerformMsg.renderState);
        int i = tKPerformMsg.source;
        if (i != 0) {
            JsonHelper.putValue(jSONObject2, "source", i);
        }
        String str = tKPerformMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject2, "error_reason", tKPerformMsg.errorReason);
        }
        long j = tKPerformMsg.renderTime;
        if (j != 0) {
            JsonHelper.putValue(jSONObject2, "render_time", j);
        }
        String str2 = tKPerformMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject2, "template_id", tKPerformMsg.templateId);
        }
        String str3 = tKPerformMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject2, "version_code", tKPerformMsg.versionCode);
        }
        long j2 = tKPerformMsg.loadTime;
        if (j2 != 0) {
            JsonHelper.putValue(jSONObject2, "load_time", j2);
        }
        long j3 = tKPerformMsg.initTime;
        if (j3 != 0) {
            JsonHelper.putValue(jSONObject2, "init_time", j3);
        }
        return jSONObject2;
    }
}
