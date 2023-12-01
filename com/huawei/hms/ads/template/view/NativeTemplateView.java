package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.df;
import com.huawei.hms.ads.dl;
import com.huawei.hms.ads.dq;
import com.huawei.hms.ads.dr;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kz;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.R;
import com.huawei.hms.ads.template.util.ImageLoader;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.d;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.m;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/NativeTemplateView.class */
public class NativeTemplateView extends PPSNativeView {
    private DynamicTemplateView B;
    private DTAppDownloadButton C;
    private boolean D;
    private int F;
    private n I;
    private boolean L;
    private OnEventListener S;

    /* renamed from: a  reason: collision with root package name */
    private String f8918a;
    private BannerAdSize b;

    /* renamed from: c  reason: collision with root package name */
    private AdListener f8919c;
    private NativeAdConfiguration d;
    private VideoOperator e;
    private VideoOperator.VideoLifecycleListener f;
    private boolean g;
    private boolean h;
    private int i;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/NativeTemplateView$OnEventListener.class */
    public interface OnEventListener {
        void onHandleClickEvent(View view, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/NativeTemplateView$a.class */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Object tag = view.getTag(R.id.hiad_pps_view_store_click_event);
            if (tag instanceof String) {
                ge.Code("NativeTemplateView", "handle click event: %s", tag);
                if ("dislike_ad".equals(tag)) {
                    if (dt.Code(NativeTemplateView.this.getContext()).V()) {
                        NativeTemplateView.this.F();
                        NativeTemplateView.this.destroy();
                        NativeTemplateView.this.removeAllViews();
                    } else {
                        NativeTemplateView.this.Code();
                    }
                }
                if (NativeTemplateView.this.S != null) {
                    NativeTemplateView.this.S.onHandleClickEvent(view, (String) tag);
                }
            }
        }
    }

    public NativeTemplateView(Context context) {
        super(context);
        this.L = true;
        this.g = true;
        this.h = false;
        L();
        setImageLoader(context);
        this.i = l.I(context);
    }

    public NativeTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = true;
        this.g = true;
        this.h = false;
        L();
        setImageLoader(context);
    }

    public NativeTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = true;
        this.g = true;
        this.h = false;
        L();
        setImageLoader(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(Context context, Integer num) {
        if (num != null && context != null && df.V.containsKey(num)) {
            return Code(context.getApplicationContext(), df.V.get(num));
        }
        ge.I("NativeTemplateView", "load default template error" + num);
        return null;
    }

    private String Code(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            inputStream2 = context.getResources().getAssets().open(str);
            inputStream = inputStream2;
        } catch (IOException e) {
            inputStream2 = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            at.Code((Closeable) inputStream);
            throw th;
        }
        try {
            try {
                String Code = at.Code(inputStream2);
                at.Code((Closeable) inputStream2);
                return Code;
            } catch (Throwable th2) {
                th = th2;
                at.Code((Closeable) inputStream);
                throw th;
            }
        } catch (IOException e2) {
            inputStream = inputStream2;
            ge.Z("NativeTemplateView", "loadTemplateFromAssets fail");
            at.Code((Closeable) inputStream2);
            return null;
        }
    }

    private void Code(Context context, String str, BannerAdSize bannerAdSize) {
        removeAllViews();
        long currentTimeMillis = System.currentTimeMillis();
        this.B = dl.Code(context).Code(str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (bannerAdSize != null) {
            int width = bannerAdSize.getWidth();
            int height = bannerAdSize.getHeight();
            if (width != 0) {
                layoutParams.width = width;
            }
            if (height != 0) {
                layoutParams.height = height;
            }
        }
        Z();
        addView(this.B, layoutParams);
        if (ge.Code()) {
            ge.Code("NativeTemplateView", "inflateTemplateView end duration: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        render();
    }

    private void Code(DTNativeVideoView dTNativeVideoView) {
        int i;
        DTRelativeLayout relativeLayout = this.B.getRelativeLayout();
        if (relativeLayout == null) {
            return;
        }
        if (relativeLayout.getHeight() == 0) {
            relativeLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i = relativeLayout.getMeasuredHeight();
        } else {
            i = relativeLayout.getLayoutParams().height;
        }
        float C = this.I.Z().get(0).C() / this.I.Z().get(0).B();
        dTNativeVideoView.getLayoutParams().height = this.b.getHeight() - i;
        dTNativeVideoView.getLayoutParams().width = (int) (dTNativeVideoView.getLayoutParams().height * C);
    }

    private void Code(m mVar, AdParam adParam) {
        if (adParam == null) {
            return;
        }
        if (adParam.Code() != null) {
            mVar.Code(adParam.Code());
        }
        mVar.Code(adParam.getGender());
        mVar.V(adParam.getTargetingContentUrl());
        mVar.I(adParam.I());
        mVar.Code(adParam.getKeywords());
        mVar.Code(dr.Code(adParam.V()));
        mVar.Z(adParam.C());
        HiAd.getInstance(getContext()).setCountryCode(adParam.Z());
    }

    private void Code(NativeVideoView nativeVideoView) {
        int i;
        if (nativeVideoView == null) {
            return;
        }
        NativeAdConfiguration nativeAdConfiguration = this.d;
        if (nativeAdConfiguration == null || nativeAdConfiguration.getVideoConfiguration() == null) {
            i = 1;
        } else {
            nativeVideoView.Code(this.d.getVideoConfiguration().isStartMuted());
            i = this.d.getVideoConfiguration().getAudioFocusType();
        }
        nativeVideoView.setAudioFocusType(i);
        nativeVideoView.setVideoEventListener(new NativeVideoView.a() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.8
            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code() {
                if (NativeTemplateView.this.f != null) {
                    if (NativeTemplateView.this.g) {
                        NativeTemplateView.this.f.onVideoStart();
                    } else {
                        NativeTemplateView.this.f.onVideoPlay();
                    }
                }
                NativeTemplateView.this.g = false;
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z) {
                if (NativeTemplateView.this.f != null) {
                    NativeTemplateView.this.f.onVideoMute(z);
                }
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z, int i2) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void I() {
                if (NativeTemplateView.this.f != null) {
                    NativeTemplateView.this.f.onVideoEnd();
                }
                NativeTemplateView.this.g = true;
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V() {
                if (NativeTemplateView.this.f != null) {
                    NativeTemplateView.this.f.onVideoPause();
                }
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V(boolean z, int i2) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Z() {
                if (NativeTemplateView.this.f != null) {
                    NativeTemplateView.this.f.onVideoPause();
                }
                NativeTemplateView.this.g = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<g>> map) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                if (NativeTemplateView.this.getContext() == null) {
                    ge.I("NativeTemplateView", "onTemplateAdsLoaded - activity doesn't exit anymore");
                    return;
                }
                Iterator it = map.entrySet().iterator();
                loop0: while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    int i = 10000;
                    for (g gVar : (List) ((Map.Entry) it.next()).getValue()) {
                        if (gVar instanceof n) {
                            n nVar = (n) gVar;
                            int i2 = i;
                            if (TextUtils.isEmpty(nVar.ah())) {
                                NativeTemplateView nativeTemplateView = NativeTemplateView.this;
                                String Code = nativeTemplateView.Code(nativeTemplateView.getContext(), Integer.valueOf(gVar.a()));
                                i2 = i;
                                if (!TextUtils.isEmpty(Code)) {
                                    nVar.Z(Code);
                                    nVar.Code(i);
                                    i2 = i + 1;
                                }
                            }
                            i = i2;
                            if (!TextUtils.isEmpty(nVar.ah())) {
                                NativeTemplateView.this.V(gVar);
                                z = true;
                                break loop0;
                            }
                        }
                    }
                }
                if (z) {
                    NativeTemplateView.this.a();
                } else {
                    NativeTemplateView.this.V(3);
                }
            }
        });
    }

    private void L() {
        setIsCustomDislikeThisAdEnabled(true);
        setChoiceViewPosition(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i) {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.6
            @Override // java.lang.Runnable
            public void run() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdFailed(dq.Code(i));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(d dVar) {
        if (!(dVar instanceof n)) {
            ge.I("NativeTemplateView", "ad is not native ad");
            return;
        }
        destroy();
        this.I = (n) dVar;
        Code(getContext(), this.I.ah(), this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final g gVar) {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeTemplateView.this.V((d) gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.5
            @Override // java.lang.Runnable
            public void run() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdLoaded();
                }
            }
        });
    }

    private void b() {
        DTAppDownloadButton dTAppDownloadButton;
        int i;
        DTAppDownloadButton nativeButton = this.B.getNativeButton();
        this.C = nativeButton;
        if (nativeButton != null) {
            if (Code((kz) nativeButton)) {
                this.C.Code();
                dTAppDownloadButton = this.C;
                i = 0;
            } else {
                dTAppDownloadButton = this.C;
                i = 8;
            }
            dTAppDownloadButton.setVisibility(i);
        }
    }

    private void c() {
        int i;
        DTTextView adSignTextView = this.B.getAdSignTextView();
        if (adSignTextView == null || this.I.L() == null) {
            return;
        }
        if ("2".equals(this.I.L())) {
            i = 0;
        } else if (!"1".equals(this.I.L())) {
            return;
        } else {
            i = 8;
        }
        adSignTextView.setVisibility(i);
    }

    private void d() {
        B();
        V((kz) this.C);
        this.I = null;
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        n nVar = this.I;
        boolean z = nVar != null && nVar.c_();
        DynamicTemplateView dynamicTemplateView = this.B;
        return z && (dynamicTemplateView != null && dynamicTemplateView.getNativeVideoView() != null);
    }

    private void f() {
        if (this.e != null) {
            return;
        }
        this.e = new VideoOperator() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.9
            @Override // com.huawei.hms.ads.VideoOperator
            public float getAspectRatio() {
                if (NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return 0.0f;
                }
                return NativeTemplateView.this.B.getNativeVideoView().getAspectRatio();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public VideoOperator.VideoLifecycleListener getVideoLifecycleListener() {
                return NativeTemplateView.this.f;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean hasVideo() {
                return NativeTemplateView.this.e();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isClickToFullScreenEnabled() {
                if (NativeTemplateView.this.d == null || NativeTemplateView.this.d.getVideoConfiguration() == null) {
                    return false;
                }
                return NativeTemplateView.this.d.getVideoConfiguration().isClickToFullScreenRequested();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isCustomizeOperateEnabled() {
                if (NativeTemplateView.this.d == null || NativeTemplateView.this.d.getVideoConfiguration() == null) {
                    return false;
                }
                return NativeTemplateView.this.d.getVideoConfiguration().isCustomizeOperateRequested();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isMuted() {
                return NativeTemplateView.this.L;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void mute(boolean z) {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                DTNativeVideoView nativeVideoView = NativeTemplateView.this.B.getNativeVideoView();
                if (z) {
                    nativeVideoView.C();
                } else {
                    nativeVideoView.F();
                }
                NativeTemplateView.this.L = z;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void pause() {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                NativeTemplateView.this.B.getNativeVideoView().L();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void play() {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                NativeTemplateView.this.B.getNativeVideoView().D();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void setVideoLifecycleListener(VideoOperator.VideoLifecycleListener videoLifecycleListener) {
                NativeTemplateView.this.f = videoLifecycleListener;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void stop() {
                if (isCustomizeOperateEnabled()) {
                    NativeTemplateView.this.g();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        DynamicTemplateView dynamicTemplateView = this.B;
        if (dynamicTemplateView == null || dynamicTemplateView.getNativeVideoView() == null) {
            return;
        }
        this.B.getNativeVideoView().S();
    }

    private void h() {
        setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.10
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdClicked();
                }
            }
        });
        setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.2
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdImpression();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdLeave();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdOpened();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                if (NativeTemplateView.this.f8919c != null) {
                    NativeTemplateView.this.f8919c.onAdClosed();
                }
            }
        });
    }

    private void setClickListenerForClickableViews(List<View> list) {
        a aVar = new a();
        for (View view : list) {
            view.setOnClickListener(aVar);
        }
    }

    private void setImageLoader(Context context) {
        DTManager.getInstance().setImageLoader(new ImageLoader(context.getApplicationContext(), new aj() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.7
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                NativeTemplateView.this.V(0);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, Drawable drawable) {
            }
        }));
    }

    public void destroy() {
        d();
    }

    public String getAdId() {
        return this.f8918a;
    }

    public AdListener getAdListener() {
        return this.f8919c;
    }

    public BannerAdSize getAdSize() {
        return this.b;
    }

    public int getTemplateId() {
        return this.F;
    }

    public VideoConfiguration getVideoConfiguration() {
        NativeAdConfiguration nativeAdConfiguration = this.d;
        if (nativeAdConfiguration != null) {
            return nativeAdConfiguration.getVideoConfiguration();
        }
        return null;
    }

    public VideoOperator getVideoOperator() {
        f();
        return this.e;
    }

    public boolean isLoading() {
        return this.D;
    }

    public void loadAd(AdParam adParam) {
        m mVar = new m(getContext(), new String[]{this.f8918a});
        mVar.V(1);
        mVar.Code(true);
        setIsCustomDislikeThisAdEnabled(false);
        mVar.Code(new com.huawei.openalliance.ad.inter.listeners.l() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.1
            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(int i) {
                ge.Z("NativeTemplateView", "Load ads failed, error : " + i);
                NativeTemplateView.this.D = false;
                NativeTemplateView.this.V(i);
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(Map<String, List<g>> map) {
                NativeTemplateView.this.D = false;
                NativeTemplateView.this.Code(map);
            }
        });
        NativeAdConfiguration nativeAdConfiguration = this.d;
        if (nativeAdConfiguration != null) {
            mVar.Code(nativeAdConfiguration);
        }
        Code(mVar, adParam);
        this.D = true;
        mVar.Code(this.i, false);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void pause() {
        VideoOperator videoOperator = this.e;
        if (videoOperator != null) {
            videoOperator.pause();
        }
    }

    public void render() {
        String str;
        if (this.I == null) {
            ge.Z("NativeTemplateView", "Ad info not set yet.");
        } else if (this.h) {
            ge.I("NativeTemplateView", "View has been rendered.");
        } else {
            try {
                this.B.Code(new JSONObject(this.I.ag()));
                List<View> clickableViews = this.B.getClickableViews();
                List<View> arrayList = new ArrayList<>();
                List<View> arrayList2 = new ArrayList<>();
                for (View view : clickableViews) {
                    if ("show_detail".equals(view.getTag(R.id.hiad_pps_view_store_click_event))) {
                        arrayList.add(view);
                    } else {
                        arrayList2.add(view);
                    }
                }
                DTNativeVideoView nativeVideoView = this.B.getNativeVideoView();
                if (this.b.getHeight() > 0) {
                    Code(nativeVideoView);
                }
                Code((NativeVideoView) nativeVideoView);
                Code(this.I, arrayList, nativeVideoView);
                c();
                b();
                setClickListenerForClickableViews(arrayList2);
                this.h = true;
            } catch (JSONException e) {
                str = "Render JSONException";
                ge.Z("NativeTemplateView", str);
            } catch (Exception e2) {
                str = "Render failed for " + e2.getClass().getSimpleName();
                ge.Z("NativeTemplateView", str);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void resume() {
    }

    public void setAdId(String str) {
        this.f8918a = str;
    }

    public void setAdListener(AdListener adListener) {
        this.f8919c = adListener;
        if (adListener != null) {
            h();
        }
    }

    public void setAdSize(BannerAdSize bannerAdSize) {
        this.b = bannerAdSize;
    }

    public void setEventListener(OnEventListener onEventListener) {
        this.S = onEventListener;
    }

    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.d = new NativeAdConfiguration.Builder().setVideoConfiguration(videoConfiguration).build();
        if (videoConfiguration != null) {
            this.L = videoConfiguration.isStartMuted();
        }
    }
}
