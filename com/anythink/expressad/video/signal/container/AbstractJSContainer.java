package com.anythink.expressad.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.signal.b;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import com.anythink.expressad.video.signal.factory.a;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import com.anythink.expressad.videocommon.a;
import com.anythink.expressad.videocommon.c.c;
import com.anythink.expressad.videocommon.e.d;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/container/AbstractJSContainer.class */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {
    protected static final String k = "AbstractJSContainer";

    /* renamed from: a  reason: collision with root package name */
    private int f8712a;
    private int b;
    public Activity l;
    public String m;
    public String n;
    public d o;
    protected String p;
    public c q;
    protected String r;
    protected int s;
    public boolean t;
    protected boolean u;
    public int v;
    protected int w;
    protected int x;
    public boolean y;
    protected IJSFactory z;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f8712a = 0;
        this.b = 1;
        this.s = 2;
        this.t = false;
        this.u = false;
        this.y = false;
        this.z = new a();
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8712a = 0;
        this.b = 1;
        this.s = 2;
        this.t = false;
        this.u = false;
        this.y = false;
        this.z = new a();
    }

    private static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(k, "code to string is error");
            return "";
        }
    }

    private static void a(WindVaneWebView windVaneWebView, String str, String str2) {
        j.a();
        j.a((WebView) windVaneWebView, str, Base64.encodeToString(str2.getBytes(), 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Object obj, String str) {
        j.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private void b(Object obj) {
        j.a().b(obj, a(this.b));
    }

    private static void b(Object obj, String str) {
        j.a().a(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private boolean b(int i) {
        try {
            if (i == 1) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.l.setRequestedOrientation(12);
                    return true;
                }
                this.l.setRequestedOrientation(1);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.l.setRequestedOrientation(11);
                    return true;
                }
                this.l.setRequestedOrientation(0);
                return true;
            }
        } catch (Throwable th) {
            o.b(k, th.getMessage(), th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(d dVar, com.anythink.expressad.foundation.d.c cVar) {
        if (c(cVar) == 1) {
            return;
        }
        boolean z = false;
        if (cVar != null) {
            c.C0143c M = cVar.M();
            z = false;
            if (M != null) {
                z = b(M.c());
            }
        }
        if (z || dVar == null) {
            return;
        }
        b(this.o.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Object obj) {
        j.a().a(obj, a(this.f8712a));
    }

    public void a(String str) {
        o.d(k, str);
        Activity activity = this.l;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.anythink.expressad.video.signal.a.j b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        a.C0164a a2 = com.anythink.expressad.videocommon.a.a(this.t ? 287 : 94, cVar);
        if (a2 == null || !a2.c()) {
            return null;
        }
        WindVaneWebView a3 = a2.a();
        if (a3.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
            o.d(k, "JSCommon 进来");
            return (com.anythink.expressad.video.signal.a.j) a3.getObject();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b() {
        d dVar;
        return (!TextUtils.isEmpty(this.n) || (dVar = this.o) == null || TextUtils.isEmpty(dVar.O())) ? this.n : this.o.O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.video.signal.a.j b = b(cVar);
        if (b != null) {
            return b.d();
        }
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        return this.z.getActivityProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.z.getIJSRewardVideoV1();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public b getJSBTModule() {
        return this.z.getJSBTModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        return this.z.getJSCommon();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        return this.z.getJSContainerModule();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.z.getJSNotifyProxy();
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        return this.z.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.n;
    }

    public String getUnitId() {
        return this.m;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().g()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().g()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().g()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().g()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.anythink.expressad.foundation.f.b.f7818c) {
            return;
        }
        if (getJSCommon().g()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().g()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().g()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.z = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.l = activity;
    }

    public void setBidCampaign(boolean z) {
        this.u = z;
    }

    public void setBigOffer(boolean z) {
        this.y = z;
    }

    public void setIV(boolean z) {
        this.t = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.v = i;
        this.w = i2;
        this.x = i3;
    }

    public void setMute(int i) {
        this.s = i;
    }

    public void setPlacementId(String str) {
        this.n = str;
    }

    public void setReward(com.anythink.expressad.videocommon.c.c cVar) {
        this.q = cVar;
    }

    public void setRewardId(String str) {
        this.r = str;
    }

    public void setRewardUnitSetting(d dVar) {
        this.o = dVar;
    }

    public void setUnitId(String str) {
        this.m = str;
    }

    public void setUserId(String str) {
        this.p = str;
    }
}
