package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativePortraitVideoAd.class */
public class BaiduATNativePortraitVideoAd extends BaiduATNativeAd {
    BaiduNativeManager e;
    RequestParameters f;
    boolean g;
    private FeedPortraitVideoView h;
    private Context i;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativePortraitVideoAd$LoadCallbackListener.class */
    public interface LoadCallbackListener {
        void onFail(String str, String str2);

        void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd);
    }

    public BaiduATNativePortraitVideoAd(Context context, BaiduNativeManager baiduNativeManager, RequestParameters requestParameters, boolean z) {
        this.i = context;
        this.e = baiduNativeManager;
        this.f = requestParameters;
        this.g = z;
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void destroy() {
        super.destroy();
        FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
            this.h = null;
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public View getAdMediaView(Object... objArr) {
        if (this.f6034a != null) {
            if (this.h == null) {
                FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(this.b);
                this.h = feedPortraitVideoView;
                feedPortraitVideoView.setAdData(this.f6034a);
                this.h.setVideoMute(this.d);
                this.h.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.2
                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void pauseBtnClick() {
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void playCompletion() {
                        BaiduATNativePortraitVideoAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void playError() {
                        BaiduATNativePortraitVideoAd.this.notifyAdVideoVideoPlayFail("", "BaiduATNativePortraitVideoAd video play error");
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void playPause() {
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void playRenderingStart() {
                        BaiduATNativePortraitVideoAd.this.notifyAdVideoStart();
                    }

                    @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                    public final void playResume() {
                    }
                });
            }
            return this.h;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public double getVideoProgress() {
        FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.getCurrentPosition() / 1000.0d;
        }
        return 0.0d;
    }

    public void load(final LoadCallbackListener loadCallbackListener) {
        this.e.loadPortraitVideoAd(this.f, new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
            public final void onAdClick() {
                BaiduATNativePortraitVideoAd.this.notifyAdClicked();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeFail(int i, String str) {
                loadCallbackListener.onFail(String.valueOf(i), str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    loadCallbackListener.onFail("", "callback onNativeLoad but no ad");
                    return;
                }
                NativeResponse nativeResponse = list.get(0);
                BaiduATNativePortraitVideoAd baiduATNativePortraitVideoAd = BaiduATNativePortraitVideoAd.this;
                baiduATNativePortraitVideoAd.a(baiduATNativePortraitVideoAd.i, nativeResponse);
                loadCallbackListener.onSuccess(nativeResponse, BaiduATNativePortraitVideoAd.this);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNoAd(int i, String str) {
                loadCallbackListener.onFail(String.valueOf(i), str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadSuccess() {
            }
        });
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
        super.pauseVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        FeedPortraitVideoView feedPortraitVideoView;
        super.prepare(view, aTNativePrepareInfo);
        if (!this.g || (feedPortraitVideoView = this.h) == null) {
            return;
        }
        feedPortraitVideoView.play();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
        super.resumeVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }
}
