package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/WebCardVideoPositionHandler.class */
public final class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.b.a {
    private a Ui;
    private VideoPosition Uh = new VideoPosition();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/WebCardVideoPositionHandler$VideoPosition.class */
    public static final class VideoPosition extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/WebCardVideoPositionHandler$VideoPosition$KSAdJSCornerModel.class */
        public static class KSAdJSCornerModel extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public final void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                KSAdJSCornerModel kSAdJSCornerModel = new KSAdJSCornerModel();
                this.cornerRadius = kSAdJSCornerModel;
                kSAdJSCornerModel.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/WebCardVideoPositionHandler$a.class */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.Ui = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.Uh.parseJson(new JSONObject(str));
            if (this.Ui != null) {
                this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebCardVideoPositionHandler.this.Ui.a(WebCardVideoPositionHandler.this.Uh);
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
