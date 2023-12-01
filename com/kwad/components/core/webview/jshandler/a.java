package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/a.class */
public final class a implements com.kwad.sdk.core.webview.b.a {

    /* renamed from: com.kwad.components.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/a$a.class */
    public static final class C0367a extends com.kwad.sdk.core.response.kwai.a {
        public boolean Sa;

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "isInstalled", this.Sa);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/a$b.class */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public String packageName;
    }

    private static boolean aJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.kwad.sdk.utils.ak.ah(ServiceProvider.getContext(), str);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "isAppInstalled";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x002f -> B:4:0x0014). Please submit an issue!!! */
    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (Exception e) {
        }
        C0367a c0367a = new C0367a();
        c0367a.Sa = aJ(bVar.packageName);
        cVar.a(c0367a);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
