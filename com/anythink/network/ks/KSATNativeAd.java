package com.anythink.network.ks;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.expressad.d.b;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATNativeAd.class */
public class KSATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    Context f6161a;
    KsNativeAd b;

    /* renamed from: c  reason: collision with root package name */
    View f6162c;
    long d;
    FrameLayout e;
    boolean f;
    int g = 0;
    long h = 0;

    /* renamed from: com.anythink.network.ks.KSATNativeAd$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATNativeAd$1.class */
    final class AnonymousClass1 implements KsNativeAd.AdInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onAdClicked(View view, KsNativeAd ksNativeAd) {
            KSATNativeAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onAdShow(KsNativeAd ksNativeAd) {
            KSATInitManager.getInstance().a(KSATNativeAd.this.getShowId(), new WeakReference(ksNativeAd));
            KSATNativeAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }
    }

    /* renamed from: com.anythink.network.ks.KSATNativeAd$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATNativeAd$2.class */
    final class AnonymousClass2 implements KsAppDownloadListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd.this.mDownloadListener.onDownloadFail(KSATNativeAd.this.d, KSATNativeAd.this.h, "", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd.this.mDownloadListener.onDownloadFinish(KSATNativeAd.this.d, "", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd.this.mDownloadListener.onDownloadStart(KSATNativeAd.this.d, 0L, "", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd.this.mDownloadListener.onInstalled("", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            if (KSATNativeAd.this.mDownloadListener == null || !(KSATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            kSATNativeAd.h = (kSATNativeAd.d * i) / 100;
            KSATNativeAd.this.mDownloadListener.onDownloadUpdate(KSATNativeAd.this.d, KSATNativeAd.this.h, "", KSATNativeAd.this.getTitle());
        }
    }

    /* renamed from: com.anythink.network.ks.KSATNativeAd$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATNativeAd$3.class */
    final class AnonymousClass3 implements KsNativeAd.VideoPlayListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            KSATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            Log.i(b.f4297c, "KuaiShou Video play error:" + i + " " + i2);
            KSATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i), String.valueOf(i2));
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            KSATNativeAd.this.notifyAdVideoStart();
        }
    }

    public KSATNativeAd(Context context, KsNativeAd ksNativeAd, boolean z) {
        this.d = 0L;
        this.f6161a = context.getApplicationContext();
        this.b = ksNativeAd;
        this.f = z;
        setTitle(ksNativeAd.getAppName());
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(0));
        setNativeInteractionType(this.b.getInteractionType() == 2 ? 3 : this.b.getInteractionType() == 1 ? 1 : 0);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= imageList.size()) {
                    break;
                }
                KsImage ksImage = imageList.get(i2);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i2 == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
                i = i2 + 1;
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
            this.mAdSourceType = "2";
        }
        this.e = new FrameLayout(context.getApplicationContext());
    }

    private void a() {
        setTitle(this.b.getAppName());
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(0));
        int i = this.b.getInteractionType() == 1 ? 1 : 0;
        if (this.b.getInteractionType() == 2) {
            i = 3;
        }
        setNativeInteractionType(i);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= imageList.size()) {
                    break;
                }
                KsImage ksImage = imageList.get(i3);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i3 == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
                i2 = i3 + 1;
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
            this.mAdSourceType = "2";
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup) || view == this.f6162c) {
            view.setOnClickListener(null);
            view.setClickable(false);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            a(viewGroup.getChildAt(i));
        }
    }

    private void a(ViewGroup viewGroup, List<View> list) {
        this.b.registerViewForInteraction(viewGroup, list, new AnonymousClass1());
        this.b.setDownloadListener(new AnonymousClass2());
        this.b.setVideoPlayListener(new AnonymousClass3());
        boolean z = true;
        if (this.b.getMaterialType() == 1) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(this.f);
            int i = this.g;
            if (i > 0) {
                if (i == 1) {
                    z = false;
                }
                builder.videoSoundEnable(z);
            }
            View videoView = this.b.getVideoView(viewGroup.getContext(), builder.build());
            this.f6162c = videoView;
            if (videoView == null || this.e == null || videoView.getParent() != null) {
                return;
            }
            this.e.addView(this.f6162c);
        }
    }

    private void a(List<View> list, View view) {
        if (!(view instanceof ViewGroup) || view == this.f6162c) {
            if (view != this.f6162c) {
                list.add(view);
                return;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(list, viewGroup.getChildAt(i2));
            i = i2 + 1;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        KsNativeAd ksNativeAd = this.b;
        if (ksNativeAd != null) {
            ksNativeAd.setDownloadListener(null);
            try {
                this.b.registerViewForInteraction(null, null, null);
            } catch (Exception e) {
            }
        }
        this.f6161a = null;
        this.e = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        if (this.b.getMaterialType() == 1) {
            return this.e;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0.size() <= 0) goto L26;
     */
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepare(android.view.View r8, com.anythink.nativead.api.ATNativePrepareInfo r9) {
        /*
            r7 = this;
            r0 = r9
            java.util.List r0 = r0.getClickViewList()
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L18
            r0 = r12
            r9 = r0
            r0 = r12
            int r0 = r0.size()
            if (r0 > 0) goto L26
        L18:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r7
            r1 = r9
            r2 = r8
            r0.a(r1, r2)
        L26:
            r0 = r8
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r8 = r0
            r0 = r7
            com.kwad.sdk.api.KsNativeAd r0 = r0.b
            r1 = r8
            r2 = r9
            com.anythink.network.ks.KSATNativeAd$1 r3 = new com.anythink.network.ks.KSATNativeAd$1
            r4 = r3
            r5 = r7
            r4.<init>()
            r0.registerViewForInteraction(r1, r2, r3)
            r0 = r7
            com.kwad.sdk.api.KsNativeAd r0 = r0.b
            com.anythink.network.ks.KSATNativeAd$2 r1 = new com.anythink.network.ks.KSATNativeAd$2
            r2 = r1
            r3 = r7
            r2.<init>()
            r0.setDownloadListener(r1)
            r0 = r7
            com.kwad.sdk.api.KsNativeAd r0 = r0.b
            com.anythink.network.ks.KSATNativeAd$3 r1 = new com.anythink.network.ks.KSATNativeAd$3
            r2 = r1
            r3 = r7
            r2.<init>()
            r0.setVideoPlayListener(r1)
            r0 = r7
            com.kwad.sdk.api.KsNativeAd r0 = r0.b
            int r0 = r0.getMaterialType()
            r10 = r0
            r0 = 1
            r11 = r0
            r0 = r10
            r1 = 1
            if (r0 != r1) goto Ld2
            com.kwad.sdk.api.KsAdVideoPlayConfig$Builder r0 = new com.kwad.sdk.api.KsAdVideoPlayConfig$Builder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r7
            boolean r1 = r1.f
            com.kwad.sdk.api.KsAdVideoPlayConfig$Builder r0 = r0.videoSoundEnable(r1)
            r0 = r7
            int r0 = r0.g
            r10 = r0
            r0 = r10
            if (r0 <= 0) goto L9e
            r0 = r10
            r1 = 1
            if (r0 == r1) goto L94
            goto L97
        L94:
            r0 = 0
            r11 = r0
        L97:
            r0 = r9
            r1 = r11
            com.kwad.sdk.api.KsAdVideoPlayConfig$Builder r0 = r0.videoSoundEnable(r1)
        L9e:
            r0 = r7
            com.kwad.sdk.api.KsNativeAd r0 = r0.b
            r1 = r8
            android.content.Context r1 = r1.getContext()
            r2 = r9
            com.kwad.sdk.api.KsAdVideoPlayConfig r2 = r2.build()
            android.view.View r0 = r0.getVideoView(r1, r2)
            r8 = r0
            r0 = r7
            r1 = r8
            r0.f6162c = r1
            r0 = r8
            if (r0 == 0) goto Ld2
            r0 = r7
            android.widget.FrameLayout r0 = r0.e
            if (r0 == 0) goto Ld2
            r0 = r8
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto Ld2
            r0 = r7
            android.widget.FrameLayout r0 = r0.e
            r1 = r7
            android.view.View r1 = r1.f6162c
            r0.addView(r1)
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.ks.KSATNativeAd.prepare(android.view.View, com.anythink.nativead.api.ATNativePrepareInfo):void");
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        this.g = z ? 1 : 2;
    }
}
