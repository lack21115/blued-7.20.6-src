package com.opos.mobad.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.e;
import com.opos.mobad.e.a.f;
import com.opos.mobad.e.a.g;
import com.opos.mobad.e.a.i;
import com.opos.mobad.e.a.k;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b.class */
public final class b implements f {
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f25992c;
    String d;
    Object e;
    Object f;
    int g;
    Map h;
    Map<String, String> i;
    HashMap<ZkViewSDK.KEY, Object> j;
    com.opos.mobad.e.a.a k;
    e l;
    i m;
    com.opos.mobad.e.a.b n;
    com.opos.mobad.e.a.c o;
    com.opos.mobad.e.a.d p;
    k q;

    /* renamed from: a  reason: collision with root package name */
    boolean f25991a = true;
    private final com.opos.mobad.e.a.a.a.b r = new com.opos.mobad.e.a.a.a.a();
    private final com.opos.mobad.e.a.a.a.b s = new com.opos.mobad.e.a.a.a.c();

    private g a(Context context, String str, String str2, String str3, com.opos.mobad.e.a.a.a.b bVar) {
        String str4;
        com.opos.cmn.an.f.a.b("MatLoader", "Start load view!Loader:" + toString());
        if (context == null) {
            i iVar = this.m;
            if (iVar != null) {
                iVar.a(this.h, "Context is null!");
            }
            str4 = "context is empty!";
        } else {
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                com.opos.cmn.an.f.a.d("MatLoader", "adId or matId is empty!");
            }
            Context applicationContext = context.getApplicationContext();
            com.opos.mobad.e.a.a.b.a.a();
            a.C0691a a2 = com.opos.mobad.e.a.a.b.a.a(UUID.randomUUID().toString() + "-" + System.currentTimeMillis(), str2, str3, this.i);
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.opos.cmn.an.f.a.b("MatLoader", "load path:" + str + ",adId:" + str2 + ",matId:" + str3 + ",exist:" + new File(str).exists());
                    boolean z = this.f25991a;
                    if (this.j == null) {
                        this.j = new HashMap<>();
                    }
                    if (!TextUtils.isEmpty(this.b)) {
                        this.j.put(ZkViewSDK.KEY.KEY_AD_TITLE, this.b);
                    }
                    if (!TextUtils.isEmpty(this.f25992c)) {
                        this.j.put(ZkViewSDK.KEY.KEY_AD_DESC, this.f25992c);
                    }
                    if (!TextUtils.isEmpty(this.d)) {
                        this.j.put(ZkViewSDK.KEY.KEY_AD_ACTION, this.d);
                    }
                    if (this.e != null) {
                        this.j.put(ZkViewSDK.KEY.KEY_AD_IMAGE, this.e);
                    }
                    if (this.f != null) {
                        this.j.put(ZkViewSDK.KEY.KEY_AD_LOGO, this.f);
                    }
                    return new c(applicationContext, bVar.a(applicationContext, str, z, this.j, this.h, new a(applicationContext, this, a2, str)), a2);
                } catch (Exception e) {
                    com.opos.mobad.e.a.a.b.a.a();
                    com.opos.mobad.e.a.a.b.a.d().a(a2).d("0").e("load view error!msg:" + e.getMessage()).a(applicationContext);
                    com.opos.cmn.an.f.a.d("MatLoader", "Load view error!", e);
                    return null;
                }
            }
            i iVar2 = this.m;
            if (iVar2 != null) {
                iVar2.a(this.h, "Path is empty!");
            }
            com.opos.mobad.e.a.a.b.a.a();
            com.opos.mobad.e.a.a.b.a.d().a(a2).d("6").e("loadView path is empty!").a(applicationContext);
            str4 = "path is empty!";
        }
        com.opos.cmn.an.f.a.d("MatLoader", str4);
        return null;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(com.opos.mobad.e.a.a aVar) {
        this.k = aVar;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(i iVar) {
        this.m = iVar;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(Object obj) {
        this.e = obj;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(String str) {
        this.b = str;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f a(boolean z) {
        this.f25991a = z;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final g a(Context context, String str, String str2, String str3) {
        return a(context, str, str2, str3, this.s);
    }

    @Override // com.opos.mobad.e.a.f
    public final f b(Object obj) {
        this.f = obj;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f b(String str) {
        this.f25992c = str;
        return this;
    }

    @Override // com.opos.mobad.e.a.f
    public final f c(String str) {
        this.d = str;
        return this;
    }

    public final String toString() {
        return "MatLoader{autoPlay=" + this.f25991a + ", matTitle='" + this.b + "', matDesc='" + this.f25992c + "', matAction='" + this.d + "', mMatImage=" + this.e + ", mMatLogo=" + this.f + ", skipTime=" + this.g + ", mTansMap=" + this.h + ", mReportMap=" + this.i + ", mMatMap=" + this.j + ", mClickListener=" + this.k + ", mExposeListener=" + this.l + ", mRenderListener=" + this.m + ", mExClickListener=" + this.n + ", mExExposeListener=" + this.o + ", mExRenderListener=" + this.p + ", mVideoListener=" + this.q + ", mFullLoader=" + this.r + ", mInsideLoader=" + this.s + '}';
    }
}
