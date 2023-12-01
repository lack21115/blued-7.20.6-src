package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/b.class */
public abstract class b implements g {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        onCreate();
        buildBaseHeader();
        buildBaseBody();
        if (encryptDisable()) {
            addHeader("x-ksad-ignore-decrypt", "true");
        }
        addHeader("cookie", e.wc().wd());
        com.kwad.sdk.core.kwai.d.d(getHeader());
        addHeader("User-Agent", q.getUserAgent());
        addHeader("BrowserUa", q.wh());
        addHeader("SystemUa", q.wg());
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    public boolean encryptDisable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        t.putValue(jSONObject, "version", eVar.getSDKVersion());
        t.putValue(jSONObject, "appId", !TextUtils.isEmpty(be.getAppId()) ? be.getAppId() : eVar.getAppId());
        t.putValue(jSONObject, "message", com.kwad.sdk.core.kwai.d.bV(this.mBodyParams.toString()));
        com.kwad.sdk.core.kwai.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    protected String getRequestHost() {
        return com.kwad.sdk.c.sb();
    }

    @Override // com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String getUrl();

    public void onCreate() {
    }

    public void putBody(String str, byte b) {
        t.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, double d) {
        t.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, float f) {
        t.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, int i) {
        t.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, long j) {
        t.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        t.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, String str2) {
        t.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        t.putValue(this.mBodyParams, str, list);
    }

    public void putBody(String str, JSONArray jSONArray) {
        t.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, JSONObject jSONObject) {
        t.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, boolean z) {
        t.putValue(this.mBodyParams, str, z);
    }
}
