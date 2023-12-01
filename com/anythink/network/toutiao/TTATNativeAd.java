package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeAd.class */
public class TTATNativeAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    TTNativeAd f9117a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    String f9118c;
    boolean d = false;
    TTATCustomVideo e;
    double f;
    View g;

    /* renamed from: com.anythink.network.toutiao.TTATNativeAd$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeAd$3.class */
    final class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f9121a;

        AnonymousClass3(Activity activity) {
            this.f9121a = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (TTATNativeAd.this.f9117a == null) {
                return;
            }
            TTAdDislike dislikeDialog = TTATNativeAd.this.f9117a.getDislikeDialog(this.f9121a);
            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.anythink.network.toutiao.TTATNativeAd.3.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onCancel() {
                }

                @Deprecated
                public final void onRefuse() {
                }

                @Deprecated
                public final void onSelected(int i, String str) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onSelected(int i, String str, boolean z) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onShow() {
                }
            });
            if (dislikeDialog.isShow()) {
                return;
            }
            dislikeDialog.showDislikeDialog();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeAd$a.class */
    final class a implements TTNativeAd.AdInteractionListener {
        private a() {
        }

        /* synthetic */ a(TTATNativeAd tTATNativeAd, byte b) {
            this();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdClicked(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdShow(TTNativeAd tTNativeAd) {
            TTATInitManager.getInstance().a(TTATNativeAd.this.getShowId(), new WeakReference(tTNativeAd));
            TTATNativeAd.this.notifyAdImpression();
        }
    }

    public TTATNativeAd(Context context, String str, TTNativeAd tTNativeAd, boolean z, Bitmap bitmap, int i) {
        this.b = context.getApplicationContext();
        this.f9118c = str;
        this.f9117a = tTNativeAd;
        setNetworkInfoMap(tTNativeAd.getMediaExtraInfo());
        setAdData(z, bitmap, i);
    }

    private void a(Activity activity) {
        bindDislikeListener(new AnonymousClass3(activity));
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view.setOnClickListener(null);
            view.setClickable(false);
            return;
        }
        TTNativeAd tTNativeAd = this.f9117a;
        if (tTNativeAd == null || view != tTNativeAd.getAdView()) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
        }
    }

    private void a(List<View> list, View view) {
        if (!(view instanceof ViewGroup) || view == this.f9117a.getAdView()) {
            if (view != this.f9117a.getAdView()) {
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

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        try {
            if (this.f9117a != null) {
                this.f9117a.setActivityForDownloadApp(null);
            }
        } catch (Exception e) {
        }
        this.b = null;
        this.f9117a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        try {
            if (this.f9117a != null) {
                return this.f9117a.getAdLogo();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.g == null) {
            this.g = this.f9117a.getAdView();
        }
        return this.g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public ATCustomVideo getNativeCustomVideo() {
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0.size() == 0) goto L15;
     */
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepare(android.view.View r7, com.anythink.nativead.api.ATNativePrepareInfo r8) {
        /*
            r6 = this;
            r0 = r8
            java.util.List r0 = r0.getClickViewList()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L14
            r0 = r9
            r8 = r0
            r0 = r9
            int r0 = r0.size()
            if (r0 != 0) goto L22
        L14:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r6
            r1 = r8
            r2 = r7
            r0.a(r1, r2)
        L22:
            com.anythink.network.toutiao.TTATNativeAd$a r0 = new com.anythink.network.toutiao.TTATNativeAd$a
            r1 = r0
            r2 = r6
            r3 = 0
            r1.<init>(r2, r3)
            r9 = r0
            r0 = r8
            int r0 = r0.size()
            if (r0 <= 0) goto L48
            r0 = r6
            com.bytedance.sdk.openadsdk.TTNativeAd r0 = r0.f9117a
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = r8
            r3 = r8
            r4 = r9
            r0.registerViewForInteraction(r1, r2, r3, r4)
            goto L57
        L48:
            r0 = r6
            com.bytedance.sdk.openadsdk.TTNativeAd r0 = r0.f9117a
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = r7
            r3 = r9
            r0.registerViewForInteraction(r1, r2, r3)
        L57:
            r0 = r7
            android.content.Context r0 = r0.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L84
            r0 = r6
            com.bytedance.sdk.openadsdk.TTNativeAd r0 = r0.f9117a
            r1 = r7
            android.content.Context r1 = r1.getContext()
            android.app.Activity r1 = (android.app.Activity) r1
            r0.setActivityForDownloadApp(r1)
            r0 = r6
            com.anythink.network.toutiao.TTATNativeAd$3 r1 = new com.anythink.network.toutiao.TTATNativeAd$3
            r2 = r1
            r3 = r6
            r4 = r7
            android.content.Context r4 = r4.getContext()
            android.app.Activity r4 = (android.app.Activity) r4
            r2.<init>(r4)
            r0.bindDislikeListener(r1)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATNativeAd.prepare(android.view.View, com.anythink.nativead.api.ATNativePrepareInfo):void");
    }

    public void setAdData(boolean z, Bitmap bitmap, int i) {
        setTitle(this.f9117a.getTitle());
        setDescriptionText(this.f9117a.getDescription());
        setAdFrom(this.f9117a.getSource());
        setStarRating(Double.valueOf(this.f9117a.getAppScore()));
        setAppCommentNum(this.f9117a.getAppCommentNum());
        TTImage icon = this.f9117a.getIcon();
        if (icon != null) {
            setIconImageUrl(icon.getImageUrl());
        }
        List<TTImage> imageList = this.f9117a.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && imageList.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= imageList.size()) {
                    break;
                }
                TTImage tTImage = imageList.get(i3);
                if (tTImage != null) {
                    arrayList.add(tTImage.getImageUrl());
                    if (i3 == 0) {
                        setMainImageUrl(tTImage.getImageUrl());
                        setMainImageWidth(tTImage.getWidth());
                        setMainImageHeight(tTImage.getHeight());
                    }
                }
                i2 = i3 + 1;
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.f9117a.getButtonText());
        TTNativeAd tTNativeAd = this.f9117a;
        if (tTNativeAd instanceof TTDrawFeedAd) {
            TTFeedAd.CustomizeVideo customVideo = ((TTDrawFeedAd) tTNativeAd).getCustomVideo();
            if (customVideo != null) {
                setVideoUrl(customVideo.getVideoUrl());
                this.e = new TTATCustomVideo(customVideo);
            }
            ((TTDrawFeedAd) this.f9117a).setCanInterruptVideoPlay(z);
            if (bitmap != null && i > 0) {
                ((TTDrawFeedAd) this.f9117a).setPauseIcon(bitmap, i);
            }
        }
        ComplianceInfo complianceInfo = this.f9117a.getComplianceInfo();
        if (complianceInfo != null) {
            setAdAppInfo(new TTATDownloadAppInfo(complianceInfo, this.f9117a.getAppSize()));
        }
        int i4 = 0;
        if (this.f9117a.getInteractionType() == 4) {
            i4 = 1;
        }
        if (this.f9117a.getInteractionType() == 3) {
            i4 = 3;
        }
        if (this.f9117a.getInteractionType() == 2) {
            i4 = 2;
        }
        setNativeInteractionType(i4);
        TTNativeAd tTNativeAd2 = this.f9117a;
        if (tTNativeAd2 instanceof TTFeedAd) {
            TTFeedAd.CustomizeVideo customVideo2 = ((TTFeedAd) tTNativeAd2).getCustomVideo();
            if (customVideo2 != null) {
                setVideoUrl(customVideo2.getVideoUrl());
                this.e = new TTATCustomVideo(customVideo2);
            }
            setVideoDuration(((TTFeedAd) this.f9117a).getVideoDuration());
            ((TTFeedAd) this.f9117a).setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onProgressUpdate(long j, long j2) {
                    if (TTATNativeAd.this.getVideoDuration() == 0.0d) {
                        TTATNativeAd.this.setVideoDuration(j2 / 1000.0d);
                    }
                    TTATNativeAd.this.f = j / 1000.0d;
                    TTATNativeAd tTATNativeAd = TTATNativeAd.this;
                    tTATNativeAd.notifyAdVideoPlayProgress((int) tTATNativeAd.f);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdPaused(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoError(int i5, int i6) {
                    TTATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i5), String.valueOf(i6));
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
        }
        this.f9117a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.d) {
                    if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                    return;
                }
                TTATNativeAd.this.d = true;
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadFinish(j, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.f9117a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }
}
