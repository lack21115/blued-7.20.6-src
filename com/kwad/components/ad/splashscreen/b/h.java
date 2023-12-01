package com.kwad.components.ad.splashscreen.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.File;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/h.class */
public final class h extends e implements com.kwad.sdk.core.g.c {
    private ImageView Cj;
    private ImageView Ck;
    private AdInfo mAdInfo;
    private boolean Ci = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean Cl = false;
    private boolean Cm = false;
    private boolean Cn = false;
    private boolean Co = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.b.h$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/h$1.class */
    public final class AnonymousClass1 implements ImageLoadingListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.a(h.this, true);
            h.this.kv();
            h.this.Ck.setVisibility(0);
            GlobalThreadPools.xM().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Ck.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.this.Ck.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            if (h.this.Cl) {
                return;
            }
            h.this.Cg.f(0, "load image error");
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Cg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.4
            @Override // java.lang.Runnable
            public final void run() {
                float width = imageView.getWidth() / 1080.0f;
                float f = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f2 = width * 2340.0f;
                float height = imageView.getHeight();
                float f3 = (f2 - height) / 2.0f;
                float f4 = f2 - f;
                float f5 = (((f4 * 0.5589225f) - f3) - ((0.44107744f * f4) - f3)) / 2.0f;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (f5 - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Cg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo bP = com.kwad.sdk.core.response.a.a.bP(adInfo);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.3
            @Override // java.lang.Runnable
            public final void run() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = com.kwad.sdk.core.response.a.a.aM(adInfo).width;
                double d2 = bP.picHeight;
                double d3 = bP.viewTopMargin;
                double d4 = bP.safeAreaHeight;
                if (d2 <= 0.0d || d4 <= 0.0d) {
                    return;
                }
                double d5 = width / d;
                double d6 = d3 / (d2 - d4);
                double d7 = d3 * d5;
                double d8 = (d2 * d5) - height;
                double d9 = d8 / 2.0d;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) ((d9 - (d7 - (d7 - (d6 * d8)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.Cm = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv() {
        if (this.Co && this.Cm && !this.Cn) {
            this.Cn = true;
            this.Cg.kv();
        }
    }

    private void l(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        AnonymousClass1 anonymousClass1;
        if (i == 0) {
            this.Cj.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Cj.setVisibility(0);
            imageView = this.Cj;
            adTemplate = this.Cg.mAdTemplate;
            anonymousClass1 = new AnonymousClass1();
        } else {
            this.Ck.setVisibility(0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BS)) {
                a(this.Ck, this.mAdInfo);
            } else {
                a(this.Ck);
            }
            imageView = this.Ck;
            adTemplate = this.Cg.mAdTemplate;
            anonymousClass1 = new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    h.a(h.this, true);
                    h.this.kv();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    if (h.this.Cl) {
                        return;
                    }
                    h.this.Cg.f(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, anonymousClass1);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Ck = (ImageView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_background);
        this.Cj = (ImageView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_foreground);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        this.mAdInfo = cb;
        String str = com.kwad.sdk.core.response.a.a.aM(cb).materialUrl;
        this.Ck.setVisibility(0);
        int i = com.kwad.sdk.core.response.a.a.aM(this.mAdInfo).source;
        if (getContext() != null) {
            SplashPreloadManager.rV();
            File aW = SplashPreloadManager.aW(this.mAdInfo.adPreloadInfo.preloadId);
            String str2 = str;
            if (aW != null) {
                str2 = str;
                if (aW.exists()) {
                    str2 = str;
                    if (aW.length() > 0) {
                        str2 = Uri.fromFile(aW).toString();
                    }
                }
            }
            l(str2, i);
        }
        if (this.Cg.BH != null) {
            this.Cg.BH.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Cl = true;
        this.Cm = false;
        this.Cn = false;
        this.Co = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        this.Co = true;
        if (!this.Ci) {
            this.Ci = true;
            com.kwad.components.ad.splashscreen.local.c.R(getContext());
            com.kwad.components.core.r.b.pK().a(this.Cg.mAdTemplate, null, null);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
        }
        kv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.Cg.BH != null) {
            this.Cg.BH.b(this);
        }
    }
}
