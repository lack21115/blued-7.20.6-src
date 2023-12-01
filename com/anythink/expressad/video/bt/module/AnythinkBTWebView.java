package com.anythink.expressad.video.bt.module;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.expressad.atsignalcommon.a.a;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.videocommon.e.d;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTWebView.class */
public class AnythinkBTWebView extends BTBaseView implements IMraidJSBridge {
    private static final String s = "portrait";
    private static final String t = "landscape";
    private j A;
    private WebView B;
    private String p;
    private String q;
    private String r;
    private boolean u;
    private ImageView v;
    private boolean w;
    private d x;
    private List<c> y;
    private WindVaneWebView z;

    public AnythinkBTWebView(Context context) {
        super(context);
        this.u = false;
        this.w = false;
    }

    public AnythinkBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = false;
        this.w = false;
    }

    private void a(com.anythink.expressad.atsignalcommon.base.c cVar) {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setFilter(cVar);
        }
    }

    private void b() {
        try {
            getMraidCampaign();
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.z != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", n);
                jSONObject2.put("id", this.d);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.z, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.z, "broadcast", this.d);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        WebView webView = this.B;
        if (webView != null) {
            a(webView, "onPlayerCloseBtnClicked", this.d);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z) {
    }

    public List<c> getCampaigns() {
        return this.y;
    }

    public String getFilePath() {
        return this.q;
    }

    public String getFileURL() {
        return this.p;
    }

    public String getHtml() {
        return this.r;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public c getMraidCampaign() {
        return this.b;
    }

    public d getRewardUnitSetting() {
        return this.x;
    }

    public WindVaneWebView getWebView() {
        return this.z;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        this.z = windVaneWebView;
        windVaneWebView.setBackgroundColor(0);
        this.z.setVisibility(0);
        j jVar = new j(null, this.b, this.y);
        this.A = jVar;
        jVar.a(this.f5496c);
        this.z.setObject(this.A);
        this.z.setMraidObject(this);
        this.z.setWebViewListener(new a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.1
            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
            public final void a(Object obj) {
                String str;
                super.a(obj);
                try {
                    String i = AnythinkBTWebView.this.A != null ? AnythinkBTWebView.this.A.i() : "";
                    if (TextUtils.isEmpty(i)) {
                        o.a("RVWindVaneWebView", "getEndScreenInfo failed");
                        str = "";
                    } else {
                        str = Base64.encodeToString(i.getBytes(), 2);
                        o.a("RVWindVaneWebView", "getEndScreenInfo success");
                    }
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, str);
                } catch (Throwable th) {
                    o.a("RVWindVaneWebView", th.getMessage());
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.d);
                        jSONObject2.put("result", 1);
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e.getMessage());
                        o.a("RVWindVaneWebView", e.getMessage());
                    }
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.z);
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", str);
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e.getMessage());
                        o.a("RVWindVaneWebView", e.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", AnythinkBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", AnythinkBTWebView.this.d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", sslError.toString());
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, e.getMessage());
                        o.a("RVWindVaneWebView", e.getMessage());
                    }
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i) {
                super.readyState(webView, i);
            }
        });
        addView(this.z, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (AnythinkBTWebView.this.B != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.n);
                        jSONObject.put("id", AnythinkBTWebView.this.d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTWebView.this.B, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(AnythinkBTWebView.this.B, "onClicked", AnythinkBTWebView.this.d);
                    }
                }
            }
        });
        try {
            ImageView imageView = new ImageView(getContext());
            this.v = imageView;
            imageView.setImageResource(findDrawable("anythink_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.setMargins(30, 30, 30, 30);
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(this.u ? 4 : 8);
            if (this.b != null && this.b.H()) {
                this.v.setVisibility(4);
            }
            this.v.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    AnythinkBTWebView.this.close();
                }
            });
            addView(this.v);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void notifyEvent(String str) {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            a(windVaneWebView, str, this.d);
        }
    }

    public void onBackPressed() {
        if (this.z != null) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a((WebView) this.z, "onSystemBackPressed", this.d);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.z != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", "landscape");
                } else {
                    jSONObject.put("orientation", "portrait");
                }
                jSONObject.put("instanceId", this.d);
                String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) this.z, "orientation", encodeToString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        if (this.w) {
            return;
        }
        this.w = true;
        try {
            if (this.z != null) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((WebView) this.z, "onSystemDestory", this.d);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTWebView.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (AnythinkBTWebView.this.z != null) {
                            AnythinkBTWebView.this.z.clearWebView();
                            AnythinkBTWebView.this.z.release();
                        }
                        AnythinkBTWebView.this.p = null;
                        AnythinkBTWebView.this.q = null;
                        AnythinkBTWebView.this.r = null;
                        if (AnythinkBTWebView.this.B != null) {
                            AnythinkBTWebView.this.B = null;
                        }
                    } catch (Throwable th) {
                        o.a(BTBaseView.TAG, th.getMessage());
                    }
                }
            }, 500L);
            setOnClickListener(null);
            removeAllViews();
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        try {
            String ad = this.b.ad();
            if (!TextUtils.isEmpty(str)) {
                this.b.p(str);
                getMraidCampaign();
            }
            new com.anythink.expressad.a.a(getContext(), this.f5496c);
            this.b.p(ad);
        } catch (Throwable th) {
            o.d(BTBaseView.TAG, th.getMessage());
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.p)) {
            this.z.loadUrl(this.p);
        } else if (!TextUtils.isEmpty(this.q)) {
            this.z.loadUrl(this.q);
        } else if (TextUtils.isEmpty(this.r)) {
        } else {
            this.z.loadDataWithBaseURL("", this.r, ClipDescription.MIMETYPE_TEXT_HTML, "UTF-8", null);
        }
    }

    public void setCampaigns(List<c> list) {
        this.y = list;
    }

    public void setCreateWebView(WebView webView) {
        this.B = webView;
    }

    public void setFilePath(String str) {
        this.q = str;
    }

    public void setFileURL(String str) {
        this.p = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean contains = str.contains(s.a.f5135c);
        setWebviewClickable(!contains);
        if (contains) {
            com.anythink.expressad.atsignalcommon.base.c cVar = new com.anythink.expressad.atsignalcommon.base.c();
            WindVaneWebView windVaneWebView = this.z;
            if (windVaneWebView != null) {
                windVaneWebView.setFilter(cVar);
            }
        }
    }

    public void setHtml(String str) {
        this.r = str;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setRewardUnitSetting(d dVar) {
        this.x = dVar;
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z) {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        try {
            this.v.setVisibility(z ? 4 : 0);
        } catch (Throwable th) {
            o.d(BTBaseView.TAG, th.getMessage());
        }
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.z.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.z.goForward();
        return true;
    }

    public void webviewLoad(int i) {
        if (this.A == null) {
            this.A = new j(null, this.b, this.y);
        }
        if (this.b != null) {
            this.A.a(this.b);
        } else {
            List<c> list = this.y;
            if (list != null && list.size() > 0) {
                this.A.a(this.y);
                if (this.y.size() == 1) {
                    this.A.a(this.y.get(0));
                }
            }
        }
        d dVar = this.x;
        if (dVar != null) {
            this.A.a(dVar);
        }
        this.A.a(this.f5496c);
        this.A.c(this.d);
        if (i == 1) {
            this.A.q();
        }
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.A);
        }
        if (this.b != null && this.b.H()) {
            this.v.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.z;
        if (windVaneWebView != null) {
            windVaneWebView.reload();
            return true;
        }
        return false;
    }
}
