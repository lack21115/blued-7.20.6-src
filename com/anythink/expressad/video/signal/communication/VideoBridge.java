package com.anythink.expressad.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/communication/VideoBridge.class */
public class VideoBridge extends BaseVideoBridge {
    private Handler j = new Handler(Looper.getMainLooper());

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendSubView(final Object obj, final String str) {
        if (t.b()) {
            super.appendSubView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.38
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.appendSubView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendViewTo(final Object obj, final String str) {
        if (t.b()) {
            super.appendViewTo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.39
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.appendViewTo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void bringViewToFront(final Object obj, final String str) {
        if (t.b()) {
            super.bringViewToFront(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.42
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.bringViewToFront(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void broadcast(final Object obj, final String str) {
        if (t.b()) {
            super.broadcast(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.68
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.broadcast(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void cai(final Object obj, final String str) {
        if (t.b()) {
            super.cai(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.21
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.cai(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void clearAllCache(final Object obj, final String str) {
        if (t.b()) {
            super.clearAllCache(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.79
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.clearAllCache(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void click(final Object obj, final String str) {
        if (t.b()) {
            super.click(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.click(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeAd(final Object obj, final String str) {
        if (t.b()) {
            super.closeAd(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.67
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.closeAd(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeVideoOperte(final Object obj, final String str) {
        if (t.b()) {
            super.closeVideoOperte(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.8
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.closeVideoOperte(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeWeb(final Object obj, final String str) {
        if (t.b()) {
            super.closeWeb(obj, str);
            return;
        }
        this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.24
            @Override // java.lang.Runnable
            public void run() {
                VideoBridge.super.closeWeb(obj, str);
            }
        });
        o.d("JS-Video-Brigde", "type".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createNativeEC(final Object obj, final String str) {
        if (t.b()) {
            super.createNativeEC(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.75
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.createNativeEC(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createPlayerView(final Object obj, final String str) {
        if (t.b()) {
            super.createPlayerView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.32
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.createPlayerView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createSubPlayTemplateView(final Object obj, final String str) {
        if (t.b()) {
            super.createSubPlayTemplateView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.33
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.createSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createView(final Object obj, final String str) {
        if (t.b()) {
            super.createView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.31
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.createView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createWebview(final Object obj, final String str) {
        if (t.b()) {
            super.createWebview(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.30
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.createWebview(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void destroyComponent(final Object obj, final String str) {
        if (t.b()) {
            super.destroyComponent(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.34
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.destroyComponent(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackLayoutOperate(Object obj, String str) {
        super.feedbackLayoutOperate(obj, str);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackOperate(Object obj, String str) {
        super.feedbackOperate(obj, str);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackPopupOperate(Object obj, String str) {
        super.feedbackPopupOperate(obj, str);
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAllCache(final Object obj, final String str) {
        if (t.b()) {
            super.getAllCache(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.78
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getAllCache(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAppSetting(final Object obj, final String str) {
        if (t.b()) {
            super.getAppSetting(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.81
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getAppSetting(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getComponentOptions(final Object obj, final String str) {
        if (t.b()) {
            super.getComponentOptions(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.35
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getComponentOptions(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCurrentProgress(final Object obj, final String str) {
        if (t.b()) {
            super.getCurrentProgress(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.11
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getCurrentProgress(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCutout(final Object obj, final String str) {
        if (t.b()) {
            super.getCutout(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.80
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getCutout(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getEncryptPrice(final Object obj, final String str) {
        if (t.b()) {
            super.getEncryptPrice(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.85
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getEncryptPrice(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getFileInfo(final Object obj, final String str) {
        if (t.b()) {
            super.getFileInfo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.26
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getFileInfo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardSetting(final Object obj, final String str) {
        if (t.b()) {
            super.getRewardSetting(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.82
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getRewardSetting(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardUnitSetting(final Object obj, final String str) {
        if (t.b()) {
            super.getRewardUnitSetting(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.83
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getRewardUnitSetting(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getSDKInfo(final Object obj, final String str) {
        if (t.b()) {
            super.getSDKInfo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.25
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getSDKInfo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getUnitSetting(final Object obj, final String str) {
        if (t.b()) {
            super.getUnitSetting(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.84
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.getUnitSetting(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void gial(final Object obj, final String str) {
        if (t.b()) {
            super.gial(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.22
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.gial(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handleNativeObject(final Object obj, final String str) {
        if (t.b()) {
            super.handleNativeObject(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.73
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.handleNativeObject(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handlerH5Exception(final Object obj, final String str) {
        if (t.b()) {
            super.handlerH5Exception(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.16
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.handlerH5Exception(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void hideView(final Object obj, final String str) {
        if (t.b()) {
            super.hideView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.43
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.hideView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void increaseOfferFrequence(final Object obj, final String str) {
        if (t.b()) {
            super.increaseOfferFrequence(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.72
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.increaseOfferFrequence(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void init(final Object obj, final String str) {
        if (t.b()) {
            super.init(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.init(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewAbove(final Object obj, final String str) {
        if (t.b()) {
            super.insertViewAbove(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.48
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.insertViewAbove(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewBelow(final Object obj, final String str) {
        if (t.b()) {
            super.insertViewBelow(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.49
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.insertViewBelow(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void isSystemResume(final Object obj, final String str) {
        if (t.b()) {
            super.isSystemResume(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.17
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.isSystemResume(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void ivRewardAdsWithoutVideo(final Object obj, final String str) {
        if (t.b()) {
            super.ivRewardAdsWithoutVideo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.69
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.ivRewardAdsWithoutVideo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadads(final Object obj, final String str) {
        if (t.b()) {
            super.loadads(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.27
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.loadads(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadingResourceStatus(final Object obj, final String str) {
        if (t.b()) {
            super.loadingResourceStatus(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.74
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.loadingResourceStatus(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void notifyCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.14
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendSubView(final Object obj, final String str) {
        if (t.b()) {
            super.onlyAppendSubView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.40
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.onlyAppendSubView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendViewTo(final Object obj, final String str) {
        if (t.b()) {
            super.onlyAppendViewTo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.41
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.onlyAppendViewTo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewAbove(final Object obj, final String str) {
        if (t.b()) {
            super.onlyInsertViewAbove(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.50
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.onlyInsertViewAbove(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewBelow(final Object obj, final String str) {
        if (t.b()) {
            super.onlyInsertViewBelow(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.51
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.onlyInsertViewBelow(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void openURL(final Object obj, final String str) {
        if (t.b()) {
            super.openURL(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.20
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.openURL(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playVideoFinishOperate(final Object obj, final String str) {
        if (t.b()) {
            super.playVideoFinishOperate(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.19
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playVideoFinishOperate(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerGetMuteState(final Object obj, final String str) {
        if (t.b()) {
            super.playerGetMuteState(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.63
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerGetMuteState(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerMute(final Object obj, final String str) {
        if (t.b()) {
            super.playerMute(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.61
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerMute(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPause(final Object obj, final String str) {
        if (t.b()) {
            super.playerPause(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.57
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerPause(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPlay(final Object obj, final String str) {
        if (t.b()) {
            super.playerPlay(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.56
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerPlay(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerResume(final Object obj, final String str) {
        if (t.b()) {
            super.playerResume(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.58
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerResume(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetRenderType(final Object obj, final String str) {
        if (t.b()) {
            super.playerSetRenderType(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.65
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerSetRenderType(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetSource(final Object obj, final String str) {
        if (t.b()) {
            super.playerSetSource(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.64
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerSetSource(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerStop(final Object obj, final String str) {
        if (t.b()) {
            super.playerStop(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.59
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerStop(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUnmute(final Object obj, final String str) {
        if (t.b()) {
            super.playerUnmute(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.62
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerUnmute(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUpdateFrame(final Object obj, final String str) {
        if (t.b()) {
            super.playerUpdateFrame(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.60
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.playerUpdateFrame(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void preloadSubPlayTemplateView(final Object obj, final String str) {
        if (t.b()) {
            super.preloadSubPlayTemplateView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.66
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.preloadSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressBarOperate(final Object obj, final String str) {
        if (t.b()) {
            super.progressBarOperate(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.10
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.progressBarOperate(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressOperate(final Object obj, final String str) {
        if (t.b()) {
            super.progressOperate(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.9
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.progressOperate(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reactDeveloper(final Object obj, final String str) {
        if (t.b()) {
            super.reactDeveloper(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.28
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.reactDeveloper(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void readyStatus(final Object obj, final String str) {
        o.b("JS-Video-Brigde", "VIDEOBridge readyStatus");
        if (t.b()) {
            super.readyStatus(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.18
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.readyStatus(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeCacheItem(final Object obj, final String str) {
        if (t.b()) {
            super.removeCacheItem(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.77
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.removeCacheItem(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeFromSuperView(final Object obj, final String str) {
        if (t.b()) {
            super.removeFromSuperView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.37
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.removeFromSuperView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reportUrls(final Object obj, final String str) {
        if (t.b()) {
            super.reportUrls(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.29
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.reportUrls(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setCacheItem(final Object obj, final String str) {
        if (t.b()) {
            super.setCacheItem(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.76
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setCacheItem(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setScaleFitXY(final Object obj, final String str) {
        if (t.b()) {
            super.setScaleFitXY(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.13
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setScaleFitXY(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setSubPlayTemplateInfo(final Object obj, final String str) {
        if (t.b()) {
            super.setSubPlayTemplateInfo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.70
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setSubPlayTemplateInfo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewAlpha(final Object obj, final String str) {
        if (t.b()) {
            super.setViewAlpha(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.46
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setViewAlpha(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewBgColor(final Object obj, final String str) {
        if (t.b()) {
            super.setViewBgColor(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.45
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setViewBgColor(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewRect(final Object obj, final String str) {
        if (t.b()) {
            super.setViewRect(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.36
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setViewRect(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewScale(final Object obj, final String str) {
        if (t.b()) {
            super.setViewScale(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.47
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.setViewScale(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showAlertView(final Object obj, final String str) {
        if (t.b()) {
            super.showAlertView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.23
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.showAlertView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoClickView(final Object obj, final String str) {
        if (t.b()) {
            super.showVideoClickView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.12
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.showVideoClickView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoLocation(final Object obj, final String str) {
        if (t.b()) {
            super.showVideoLocation(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.5
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.showVideoLocation(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showView(final Object obj, final String str) {
        if (t.b()) {
            super.showView(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.44
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.showView(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void soundOperate(final Object obj, final String str) {
        if (t.b()) {
            super.soundOperate(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.soundOperate(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void statistics(final Object obj, final String str) {
        if (t.b()) {
            super.statistics(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.statistics(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void toggleCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.15
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void triggerCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.triggerCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void videoOperate(final Object obj, final String str) {
        if (t.b()) {
            super.videoOperate(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.7
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.videoOperate(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewFireEvent(final Object obj, final String str) {
        if (t.b()) {
            super.webviewFireEvent(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.71
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.webviewFireEvent(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoBack(final Object obj, final String str) {
        if (t.b()) {
            super.webviewGoBack(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.54
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.webviewGoBack(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoForward(final Object obj, final String str) {
        if (t.b()) {
            super.webviewGoForward(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.55
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.webviewGoForward(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewLoad(final Object obj, final String str) {
        if (t.b()) {
            super.webviewLoad(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.52
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.webviewLoad(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewReload(final Object obj, final String str) {
        if (t.b()) {
            super.webviewReload(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.VideoBridge.53
                @Override // java.lang.Runnable
                public void run() {
                    VideoBridge.super.webviewReload(obj, str);
                }
            });
        }
    }
}
