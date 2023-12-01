package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.b;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.c;
import com.huawei.openalliance.ad.views.PPSBannerView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jh.class */
public class jh extends hg<lc> implements jx<lc> {
    private int B;
    private com.huawei.openalliance.ad.inter.i C;
    private RequestOptions D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Location L;
    private Context S;

    /* renamed from: a  reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.t f22499a;
    private Integer b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f22500c;
    private Integer d;
    private boolean e = false;
    private String f;

    public jh(Context context, lc lcVar) {
        Code((jh) lcVar);
        this.S = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.huawei.openalliance.ad.inter.data.g gVar;
        long parseLong;
        if (this.B == 1 || (gVar = this.F) == null) {
            return;
        }
        String str = null;
        if (gVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            str = ((com.huawei.openalliance.ad.inter.data.n) gVar).ak();
        }
        ge.V("BannerPresenter", "setBannerRefresh: %s", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("N".equalsIgnoreCase(str)) {
            parseLong = 0;
        } else if ("Y".equalsIgnoreCase(str)) {
            parseLong = fk.Code(this.S).o();
        } else {
            try {
                parseLong = Long.parseLong(str);
            } catch (NumberFormatException e) {
                ge.I("BannerPresenter", "parseIntOrDefault exception: " + e.getClass().getSimpleName());
                return;
            }
        }
        final long j = parseLong;
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.4
            @Override // java.lang.Runnable
            public void run() {
                jh.this.I().Code(j);
            }
        });
    }

    private SourceParam Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return null;
        }
        fk Code = fk.Code(this.S);
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        sourceParam.Code(Code == null ? 52428800 : Code.q());
        return sourceParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.openalliance.ad.inter.data.g Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        if (map != null) {
            for (Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>> entry : map.entrySet()) {
                Iterator<com.huawei.openalliance.ad.inter.data.g> it = entry.getValue().iterator();
                if (it.hasNext()) {
                    return it.next();
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.6
            @Override // java.lang.Runnable
            public void run() {
                jh.this.I().Code(i);
                if (i == 499) {
                    jh.this.I().B();
                }
            }
        });
    }

    private void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.e = gVar.d_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.F;
        if (gVar == null) {
            ge.I("BannerPresenter", "downLoadBitmap nativeAd is null");
            Code(499);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.k> Z = gVar.Z();
        if (aa.Code(Z)) {
            ge.I("BannerPresenter", "downLoadBitmap imageInfo is null");
            Code(499);
            return;
        }
        final com.huawei.openalliance.ad.inter.data.k kVar = Z.get(0);
        Code(this.F);
        SourceParam Code = Code(kVar);
        Code.Code(this.Code);
        com.huawei.openalliance.ad.utils.y.Code(this.S, Code, this.F.D(), new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jh.5
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                ge.I("BannerPresenter", "loadImage onFail");
                jh.this.Code(499);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, final Drawable drawable) {
                if (TextUtils.equals(str, kVar.Z())) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            jh.this.I().Code(drawable, jh.this.F);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Context context, final ImageView imageView, final Drawable drawable) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.jh.8
            @Override // java.lang.Runnable
            public void run() {
                final Drawable Code = com.huawei.openalliance.ad.utils.w.Code(context, drawable, 5.0f, 8.0f);
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setBackground(Code);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.jx
    public boolean B() {
        return com.huawei.openalliance.ad.utils.v.Code(this.S);
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(final Context context, final ImageView imageView, Drawable drawable) {
        if (this.e) {
            try {
                if (drawable instanceof BitmapDrawable) {
                    imageView.setBackground(com.huawei.openalliance.ad.utils.w.Code(context, drawable, 5.0f, 8.0f));
                } else if (drawable instanceof fb) {
                    ((fb) drawable).Code(new fb.a() { // from class: com.huawei.hms.ads.jh.7
                        @Override // com.huawei.hms.ads.fb.a
                        public void Code(Bitmap bitmap) {
                            jh.this.V(context, imageView, new BitmapDrawable(context.getResources(), bitmap));
                        }
                    });
                }
            } catch (Throwable th) {
                ge.I("BannerPresenter", "set banner background encounter exception: " + th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(Location location) {
        this.L = location;
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(RequestOptions requestOptions) {
        this.D = requestOptions;
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.F = nVar;
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(com.huawei.openalliance.ad.inter.data.t tVar) {
        this.f22499a = tVar;
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(Integer num) {
        this.b = num;
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(String str, int i, List<String> list, int i2) {
        if (str == null || str.isEmpty()) {
            ge.I("BannerPresenter", "adId is null or empty when load ad");
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.1
                @Override // java.lang.Runnable
                public void run() {
                    jh.this.I().Code(702);
                }
            });
            return;
        }
        ge.Code("BannerPresenter", "loadAd ,adId:%s", str);
        this.B = i2;
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(this.S, new String[]{str}, i, list);
        this.C = mVar;
        if (mVar instanceof com.huawei.openalliance.ad.inter.m) {
            mVar.Code(this.L);
            ((com.huawei.openalliance.ad.inter.m) this.C).Z(Integer.valueOf(this.B));
        }
        this.C.Code(dr.Code(this.D));
        this.C.Code(this.b);
        b bannerSize = (I() == null || !(I() instanceof PPSBannerView)) ? null : ((PPSBannerView) I()).getBannerSize();
        if (bannerSize != null) {
            this.C.V(Integer.valueOf(bannerSize.I()));
            this.C.I(Integer.valueOf(bannerSize.Z()));
        } else {
            this.C.V(this.f22500c);
            this.C.I(this.d);
        }
        String str2 = this.f;
        if (str2 != null) {
            this.C.Z(str2);
        }
        com.huawei.openalliance.ad.inter.data.t tVar = this.f22499a;
        if (tVar != null) {
            this.C.Code(tVar.Code());
            this.C.Code(this.f22499a.V());
            this.C.V(this.f22499a.I());
            this.C.I(this.f22499a.Z());
        }
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.l() { // from class: com.huawei.hms.ads.jh.2
            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(final int i3) {
                ge.Code("BannerPresenter", "loadAd onAdFailed");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        jh.this.I().Code(i3);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
                ge.Code("BannerPresenter", "loadAd onAdsLoaded");
                jh jhVar = jh.this;
                jhVar.F = jhVar.Code(map);
                com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.hms.ads.jh.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        jh.this.S();
                    }
                });
                jh.this.C();
            }
        });
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.d() { // from class: com.huawei.hms.ads.jh.3
            @Override // com.huawei.openalliance.ad.inter.listeners.d
            public void Code(final List<String> list2) {
                ge.Code("BannerPresenter", "loadAd onInValidContentIdsGot");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jh.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        jh.this.I().Code(list2);
                    }
                });
            }
        });
        this.C.Code(com.huawei.openalliance.ad.utils.l.I(this.S), null, false);
    }

    @Override // com.huawei.hms.ads.jx
    public void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j) {
        if (gVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            AdContentData l = ((com.huawei.openalliance.ad.inter.data.n) gVar).l();
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(str);
            analysisEventReport.Code(l);
            analysisEventReport.Code(j);
            if (l != null) {
                analysisEventReport.S(l.az());
                analysisEventReport.F(l.C());
                analysisEventReport.C(l.S());
                analysisEventReport.I(l.aA());
            }
            com.huawei.openalliance.ad.ipc.g.V(this.S).Code("rptAdInvalidEvt", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
        }
    }

    @Override // com.huawei.hms.ads.jx
    public boolean Code(b bVar, float f) {
        if (I() instanceof PPSBannerView) {
            PPSBannerView pPSBannerView = (PPSBannerView) I();
            Context applicationContext = pPSBannerView.getContext().getApplicationContext();
            int width = pPSBannerView.getWidth();
            int height = pPSBannerView.getHeight();
            if (ge.Code()) {
                ge.Code("BannerPresenter", "banner view width: %s, height: %s", Integer.valueOf(width), Integer.valueOf(height));
            }
            DisplayMetrics C = c.C(this.S);
            if (width > C.widthPixels || height > C.heightPixels) {
                ge.I("BannerPresenter", "Ad view is off screen");
                return false;
            }
            int Code = bVar.Code();
            int V = bVar.V();
            float f2 = Code - width;
            float f3 = Code;
            float f4 = f2 / f3;
            float f5 = V - height;
            float f6 = V;
            boolean z = f4 < f && f5 / f6 < f;
            if (!z) {
                float a2 = c.a(applicationContext);
                if (a2 > 0.0f) {
                    ge.I("BannerPresenter", "Not enough space to show ad. Needs %s×%s dp, but only has %s×%s dp", Integer.valueOf(Math.round(f3 / a2)), Integer.valueOf(Math.round(f6 / a2)), Integer.valueOf(Math.round(width / a2)), Integer.valueOf(Math.round(height / a2)));
                }
            }
            return z;
        }
        return false;
    }

    @Override // com.huawei.hms.ads.jx
    public void I(Integer num) {
        this.d = num;
    }

    @Override // com.huawei.hms.ads.jx
    public void V(Integer num) {
        this.f22500c = num;
    }

    @Override // com.huawei.hms.ads.jx
    public void V(String str) {
        this.f = str;
    }
}
