package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ac.class */
public class ac implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private BaiduNativeManager.FeedAdListener f9298a;

    public ac(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f9298a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse, int i) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9298a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }
}
