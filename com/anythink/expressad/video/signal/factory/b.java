package com.anythink.expressad.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.module.AnythinkContainerView;
import com.anythink.expressad.video.module.AnythinkVideoView;
import com.anythink.expressad.video.signal.a.h;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.video.signal.a.k;
import com.anythink.expressad.video.signal.a.l;
import com.anythink.expressad.video.signal.a.m;
import com.anythink.expressad.video.signal.a.n;
import com.anythink.expressad.video.signal.c;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/factory/b.class */
public class b extends a {
    private Activity h;
    private WebView i;
    private AnythinkVideoView j;
    private AnythinkContainerView k;
    private c l;
    private AnythinkBTContainer m;
    private List<c> n;
    private c.a o;
    private String p;

    public b(Activity activity) {
        this.h = activity;
    }

    private b(Activity activity, WebView webView, AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar) {
        this.h = activity;
        this.i = webView;
        this.j = anythinkVideoView;
        this.k = anythinkContainerView;
        this.l = cVar;
    }

    public b(Activity activity, WebView webView, AnythinkVideoView anythinkVideoView, AnythinkContainerView anythinkContainerView, com.anythink.expressad.foundation.d.c cVar, c.a aVar) {
        this.h = activity;
        this.i = webView;
        this.j = anythinkVideoView;
        this.k = anythinkContainerView;
        this.l = cVar;
        this.o = aVar;
        this.p = anythinkVideoView.getUnitId();
    }

    public b(Activity activity, AnythinkBTContainer anythinkBTContainer, WebView webView) {
        this.h = activity;
        this.m = anythinkBTContainer;
        this.i = webView;
    }

    public final void a(j jVar) {
        this.b = jVar;
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.n = list;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        if (this.i == null) {
            return super.getActivityProxy();
        }
        if (this.f5874a == null) {
            this.f5874a = new h(this.i);
        }
        return this.f5874a;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.k == null || this.h == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f == null) {
            this.f = new m(this.h, this.k);
        }
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        if (this.h == null || this.m == null) {
            return super.getJSBTModule();
        }
        if (this.g == null) {
            this.g = new com.anythink.expressad.video.signal.a.i(this.h, this.m);
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        if (this.h == null || this.l == null) {
            return super.getJSCommon();
        }
        if (this.b == null) {
            this.b = new j(this.h, this.l);
        }
        if (this.l.k() == 5 && this.n != null && (this.b instanceof j)) {
            ((j) this.b).a(this.n);
        }
        this.b.a(this.h);
        this.b.a(this.p);
        this.b.a(this.o);
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        if (this.k == null) {
            return super.getJSContainerModule();
        }
        if (this.e == null) {
            this.e = new k(this.k);
        }
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.i == null) {
            return super.getJSNotifyProxy();
        }
        if (this.d == null) {
            this.d = new l(this.i);
        }
        return this.d;
    }

    @Override // com.anythink.expressad.video.signal.factory.a, com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        if (this.j == null) {
            return super.getJSVideoModule();
        }
        if (this.f5875c == null) {
            this.f5875c = new n(this.j);
        }
        return this.f5875c;
    }
}
