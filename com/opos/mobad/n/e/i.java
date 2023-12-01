package com.opos.mobad.n.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/i.class */
public class i implements c {

    /* renamed from: a  reason: collision with root package name */
    String f12961a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f12962c;
    Object d;
    Object e;
    Object f;
    Object g;
    Object h;
    int i;
    String j;
    String k;
    Map l;
    Map<String, String> m;
    HashMap<ZkViewSDK.KEY, Object> n;
    b o;
    e p;
    f q;
    g r;
    View s;

    private HashMap<ZkViewSDK.KEY, Object> a() {
        if (this.n == null) {
            this.n = new HashMap<>();
        }
        if (!TextUtils.isEmpty(this.f12961a)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_TITLE, this.f12961a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_DESC, this.b);
        }
        if (!TextUtils.isEmpty(this.f12962c)) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_ACTION, this.f12962c);
        }
        if (this.d != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_IMAGE, this.d);
        }
        if (this.e != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_IMAGE_LIST, this.e);
        }
        if (this.g != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_LOGO, this.g);
        }
        if (this.f != null) {
            this.n.put(ZkViewSDK.KEY.KEY_VIDEO_EXTERNAL, this.f);
        }
        if (!TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.k)) {
            this.n.put(ZkViewSDK.KEY.KEY_APP_DEVELOPER, this.j);
            this.n.put(ZkViewSDK.KEY.KEY_APP_VERSION, this.k);
        }
        if (this.h != null) {
            this.n.put(ZkViewSDK.KEY.KEY_AD_ICON, this.h);
        }
        this.n.put(ZkViewSDK.KEY.KEY_VIDEO_PROGRESS_STEP, 1000);
        return this.n;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(b bVar) {
        this.o = bVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(f fVar) {
        this.q = fVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(g gVar) {
        this.r = gVar;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(Object obj) {
        this.d = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(String str) {
        this.f12961a = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c a(String str, String str2) {
        this.j = str;
        this.k = str2;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public d a(Context context, String str) {
        String str2;
        com.opos.cmn.an.f.a.b("ZKDynamicLoader", "Start load view!Loader:" + toString());
        if (context == null) {
            f fVar = this.q;
            if (fVar != null) {
                fVar.a("Context is null!");
            }
            str2 = "context is empty!";
        } else {
            Context applicationContext = context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.opos.cmn.an.f.a.b("ZKDynamicLoader", "load path:" + str + ",exist:" + new File(str).exists());
                    View a2 = ZkViewSDK.a().a(applicationContext, str, false, a(), this.l, new k(this, str));
                    this.s = a2;
                    return new j(applicationContext, a2);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("ZKDynamicLoader", "Load view error!", e);
                    return null;
                }
            }
            f fVar2 = this.q;
            if (fVar2 != null) {
                fVar2.a("Path is empty!");
            }
            str2 = "path is empty!";
        }
        com.opos.cmn.an.f.a.d("ZKDynamicLoader", str2);
        return null;
    }

    @Override // com.opos.mobad.n.e.c
    public c b(Object obj) {
        this.e = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c c(Object obj) {
        this.f = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c c(String str) {
        this.f12962c = str;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c d(Object obj) {
        this.g = obj;
        return this;
    }

    @Override // com.opos.mobad.n.e.c
    public c e(Object obj) {
        this.h = obj;
        return this;
    }

    public String toString() {
        return "MatLoader{matTitle='" + this.f12961a + "', matDesc='" + this.b + "', matAction='" + this.f12962c + "', appDeveloper='" + this.j + "', appVersion=" + this.k + ", mMatLogo=" + this.g + ", skipTime=" + this.i + ", mTansMap=" + this.l + ", mReportMap=" + this.m + ", mMatMap=" + this.n + ", mClickListener=" + this.o + ", mExposeListener=" + this.p + ", mRenderListener=" + this.q + ", mVideoListener=" + this.r + '}';
    }
}
