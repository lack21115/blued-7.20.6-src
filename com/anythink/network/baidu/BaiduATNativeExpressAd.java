package com.anythink.network.baidu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.baidu.impression.BDImpressionTracker;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.StyleParams;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeExpressAd.class */
public class BaiduATNativeExpressAd extends CustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    BDImpressionTracker f8880a;
    private NativeResponse b;

    /* renamed from: c  reason: collision with root package name */
    private FeedNativeView f8881c;
    private StyleParams d;
    private Context e;
    private FrameLayout f;

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeExpressAd$1.class */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((XAdNativeResponse) BaiduATNativeExpressAd.this.b).setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.anythink.network.baidu.BaiduATNativeExpressAd.1.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public final void onDislikeClick() {
                    BaiduATNativeExpressAd.this.notifyAdDislikeClick();
                }
            });
        }
    }

    public BaiduATNativeExpressAd(Context context, NativeResponse nativeResponse, StyleParams styleParams) {
        this.e = context.getApplicationContext();
        this.f = new FrameLayout(this.e);
        this.b = nativeResponse;
        this.d = styleParams;
        this.f8880a = new BDImpressionTracker(this.e, 50);
    }

    private List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if ((view instanceof ViewGroup) && view != this.f) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                arrayList.addAll(a(viewGroup.getChildAt(i2)));
                i = i2 + 1;
            }
        } else {
            arrayList.add(view);
        }
        return arrayList;
    }

    private void a(Context context) {
        if (this.f8881c == null) {
            FeedNativeView feedNativeView = new FeedNativeView(context);
            this.f8881c = feedNativeView;
            feedNativeView.setAdData((XAdNativeResponse) this.b);
            this.f8881c.changeViewLayoutParams(this.d);
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
            this.f.addView(this.f8881c);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        this.f = null;
        this.d = null;
        BDImpressionTracker bDImpressionTracker = this.f8880a;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.f8880a = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressHeight() {
        FeedNativeView feedNativeView = this.f8881c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressWidth() {
        FeedNativeView feedNativeView = this.f8881c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(View view) {
        NativeResponse nativeResponse = this.b;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0072, code lost:
        if (r0.size() == 0) goto L27;
     */
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepare(android.view.View r9, com.anythink.nativead.api.ATNativePrepareInfo r10) {
        /*
            r8 = this;
            r0 = r9
            if (r0 == 0) goto Lc
            r0 = r9
            android.content.Context r0 = r0.getContext()
            r11 = r0
            goto L11
        Lc:
            r0 = r8
            android.content.Context r0 = r0.e
            r11 = r0
        L11:
            r0 = r8
            com.baidu.mobads.sdk.api.FeedNativeView r0 = r0.f8881c
            if (r0 != 0) goto L5d
            com.baidu.mobads.sdk.api.FeedNativeView r0 = new com.baidu.mobads.sdk.api.FeedNativeView
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            r11 = r0
            r0 = r8
            r1 = r11
            r0.f8881c = r1
            r0 = r11
            r1 = r8
            com.baidu.mobads.sdk.api.NativeResponse r1 = r1.b
            com.baidu.mobads.sdk.api.XAdNativeResponse r1 = (com.baidu.mobads.sdk.api.XAdNativeResponse) r1
            r0.setAdData(r1)
            r0 = r8
            com.baidu.mobads.sdk.api.FeedNativeView r0 = r0.f8881c
            r1 = r8
            com.baidu.mobads.sdk.api.StyleParams r1 = r1.d
            r0.changeViewLayoutParams(r1)
            android.os.Handler r0 = new android.os.Handler
            r1 = r0
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            com.anythink.network.baidu.BaiduATNativeExpressAd$1 r1 = new com.anythink.network.baidu.BaiduATNativeExpressAd$1
            r2 = r1
            r3 = r8
            r2.<init>()
            boolean r0 = r0.post(r1)
            r0 = r8
            android.widget.FrameLayout r0 = r0.f
            r1 = r8
            com.baidu.mobads.sdk.api.FeedNativeView r1 = r1.f8881c
            r0.addView(r1)
        L5d:
            r0 = r10
            java.util.List r0 = r0.getClickViewList()
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L75
            r0 = r12
            r11 = r0
            r0 = r12
            int r0 = r0.size()
            if (r0 != 0) goto L7b
        L75:
            r0 = r8
            r1 = r9
            java.util.List r0 = r0.a(r1)
            r11 = r0
        L7b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.anythink.nativead.api.ATNativePrepareExInfo
            if (r0 == 0) goto La0
            r0 = r10
            com.anythink.nativead.api.ATNativePrepareExInfo r0 = (com.anythink.nativead.api.ATNativePrepareExInfo) r0
            java.util.List r0 = r0.getCreativeClickViewList()
            r10 = r0
            r0 = r10
            if (r0 == 0) goto La0
            r0 = r12
            r1 = r10
            boolean r0 = r0.addAll(r1)
        La0:
            r0 = r8
            com.baidu.mobads.sdk.api.NativeResponse r0 = r0.b
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = (com.baidu.mobads.sdk.api.XAdNativeResponse) r0
            r1 = r9
            r2 = r11
            r3 = r12
            com.anythink.network.baidu.BaiduATNativeExpressAd$2 r4 = new com.anythink.network.baidu.BaiduATNativeExpressAd$2
            r5 = r4
            r6 = r8
            r5.<init>()
            r0.registerViewForInteraction(r1, r2, r3, r4)
            r0 = r8
            com.anythink.network.baidu.impression.BDImpressionTracker r0 = r0.f8880a     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto Lcd
            r0 = r8
            com.anythink.network.baidu.impression.BDImpressionTracker r0 = r0.f8880a     // Catch: java.lang.Throwable -> Lce
            r1 = r9
            com.anythink.network.baidu.BaiduATNativeExpressAd$3 r2 = new com.anythink.network.baidu.BaiduATNativeExpressAd$3     // Catch: java.lang.Throwable -> Lce
            r3 = r2
            r4 = r8
            r3.<init>()     // Catch: java.lang.Throwable -> Lce
            r0.addView(r1, r2)     // Catch: java.lang.Throwable -> Lce
        Lcd:
            return
        Lce:
            r9 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.baidu.BaiduATNativeExpressAd.prepare(android.view.View, com.anythink.nativead.api.ATNativePrepareInfo):void");
    }
}
