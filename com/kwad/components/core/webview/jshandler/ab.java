package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ab.class */
public final class ab implements com.kwad.sdk.core.webview.b.a {
    private final WebView Lc;
    private Handler Sw;
    private com.kwad.sdk.core.webview.b.c Sx;
    private boolean Tn;
    private b cX;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ab$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/ab$b.class */
    public interface b {
        void a(a aVar);
    }

    public ab(com.kwad.sdk.core.webview.b bVar, b bVar2) {
        this(bVar, bVar2, true);
    }

    private ab(com.kwad.sdk.core.webview.b bVar, b bVar2, boolean z) {
        this.Tn = true;
        this.Sw = new Handler(Looper.getMainLooper());
        this.Lc = bVar.Lc;
        this.cX = bVar2;
        this.Tn = true;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ab.this.Lc != null && ab.this.Tn) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ab.this.Lc.getLayoutParams();
                        marginLayoutParams.width = -1;
                        marginLayoutParams.height = aVar.height;
                        marginLayoutParams.leftMargin = aVar.leftMargin;
                        marginLayoutParams.rightMargin = aVar.rightMargin;
                        marginLayoutParams.bottomMargin = aVar.bottomMargin;
                        ab.this.Lc.setLayoutParams(marginLayoutParams);
                    }
                    if (ab.this.cX != null) {
                        ab.this.cX.a(aVar);
                    }
                }
            });
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (ab.this.Sx != null) {
                        ab.this.Sx.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sx = null;
        this.cX = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
