package com.youzan.androidsdkx5;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewCallbackClient;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanX5WebViewCallbackClient.class */
public class YouzanX5WebViewCallbackClient implements WebViewCallbackClient {

    /* renamed from: ˊ  reason: contains not printable characters */
    WebView f1123;

    public YouzanX5WebViewCallbackClient(WebView webView) {
        this.f1123 = webView;
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void computeScroll(View view) {
        this.f1123.super_computeScroll();
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return this.f1123.super_dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void invalidate() {
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return this.f1123.super_onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        this.f1123.super_onOverScrolled(i, i2, z, z2);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        this.f1123.super_onScrollChanged(i, i2, i3, i4);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return this.f1123.super_onTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return this.f1123.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }
}
