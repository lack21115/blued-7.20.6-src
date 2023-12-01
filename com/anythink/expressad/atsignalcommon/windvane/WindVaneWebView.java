package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import com.anythink.expressad.atsignalcommon.base.BaseWebView;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/WindVaneWebView.class */
public class WindVaneWebView extends BaseWebView {

    /* renamed from: a  reason: collision with root package name */
    private Object f4260a;
    private Object b;

    /* renamed from: c  reason: collision with root package name */
    private String f4261c;
    private e d;
    protected o f;
    protected d g;
    protected i h;
    private String i;
    private boolean j;
    private float k;
    private float l;

    public WindVaneWebView(Context context) {
        super(context);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    static /* synthetic */ boolean a(WindVaneWebView windVaneWebView) {
        windVaneWebView.j = true;
        return true;
    }

    @Override // com.anythink.expressad.atsignalcommon.base.BaseWebView
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        try {
            WebSettings settings = getSettings();
            settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        } catch (Throwable th) {
            WebSettings settings2 = getSettings();
            settings2.setUserAgentString(com.anythink.core.common.k.d.i() + " WindVane/3.0.2");
        }
        if (this.f == null) {
            this.f = new o(this);
        }
        setWebViewChromeClient(this.f);
        this.mWebViewClient = new p();
        setWebViewClient(this.mWebViewClient);
        if (this.g == null) {
            m mVar = new m(this.e);
            this.g = mVar;
            setSignalCommunication(mVar);
        }
        this.h = new i(this.e, this);
    }

    public void clearWebView() {
        if (this.j) {
            return;
        }
        loadUrl("about:blank");
    }

    public String getCampaignId() {
        return this.f4261c;
    }

    public Object getJsObject(String str) {
        i iVar = this.h;
        if (iVar == null) {
            return null;
        }
        return iVar.a(str);
    }

    public Object getMraidObject() {
        return this.b;
    }

    public Object getObject() {
        return this.f4260a;
    }

    public String getRid() {
        return this.i;
    }

    public d getSignalCommunication() {
        return this.g;
    }

    public e getWebViewListener() {
        return this.d;
    }

    public boolean isDestroyed() {
        return this.j;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWebViewClient != null && (this.mWebViewClient.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.k = motionEvent.getRawX();
                    this.l = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.k;
                    float y = motionEvent.getY() - this.l;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48.0f) && ((rawX <= 0.0f || rawX <= 48.0f) && ((y >= 0.0f || (-1.0f) * y <= 48.0f) && (y <= 0.0f || y <= 48.0f)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        if (this.h == null) {
            return;
        }
        i.a(cls);
    }

    public void release() {
        try {
            removeAllViews();
            setDownloadListener(null);
            this.f4260a = null;
            int j = t.j(getContext());
            if (j != 0) {
                com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.a(WindVaneWebView.this);
                        WindVaneWebView.this.destroy();
                    }
                }, j * 1000);
                return;
            }
            this.j = true;
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        i iVar = this.h;
        if (iVar != null) {
            iVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        i iVar = this.h;
        if (iVar != null) {
            iVar.a(obj);
        }
    }

    public void setCampaignId(String str) {
        this.f4261c = str;
    }

    public void setMraidObject(Object obj) {
        this.b = obj;
    }

    public void setObject(Object obj) {
        this.f4260a = obj;
    }

    public void setRid(String str) {
        this.i = str;
    }

    public void setSignalCommunication(d dVar) {
        this.g = dVar;
        dVar.a(this);
    }

    public void setWebViewChromeClient(o oVar) {
        this.f = oVar;
        setWebChromeClient(oVar);
    }

    public void setWebViewListener(e eVar) {
        this.d = eVar;
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(eVar);
        }
        if (this.mWebViewClient != null) {
            this.mWebViewClient.a(eVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }
}
