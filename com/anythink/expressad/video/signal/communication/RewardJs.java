package com.anythink.expressad.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/communication/RewardJs.class */
public class RewardJs extends BaseRewardJs implements IRewardBridge {
    private Handler j = new Handler(Looper.getMainLooper());

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(final Object obj, final String str) {
        if (t.b()) {
            super.cai(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.9
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.cai(obj, str);
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

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(final Object obj, final String str) {
        if (t.b()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.1
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(final Object obj, final String str) {
        if (t.b()) {
            super.gial(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.10
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.gial(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(final Object obj, final String str) {
        if (t.b()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.7
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.handlerPlayableException(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(final Object obj, final String str) {
        if (t.b()) {
            super.install(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.2
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.install(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.3
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(final Object obj, final String str) {
        if (t.b()) {
            super.openURL(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.8
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.openURL(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(final Object obj, final String str) {
        if (t.b()) {
            super.setOrientation(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.6
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.setOrientation(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.4
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(final Object obj, final String str) {
        if (t.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.j.post(new Runnable() { // from class: com.anythink.expressad.video.signal.communication.RewardJs.5
                @Override // java.lang.Runnable
                public void run() {
                    RewardJs.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }
}
