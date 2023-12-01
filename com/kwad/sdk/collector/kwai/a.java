package com.kwad.sdk.collector.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/kwai/a.class */
public final class a extends d {
    private C0382a abj;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/kwai/a$a.class */
    static final class C0382a {
        private List<String> abk;

        public C0382a(List<String> list) {
            this.abk = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "packageName", this.abk);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0382a c0382a = new C0382a(list);
        this.abj = c0382a;
        putBody("targetAppInfo", c0382a.toJson());
        putBody("sdkVersion", "3.3.40");
        putBody("sdkVersionCode", 3034000);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sk();
    }
}
