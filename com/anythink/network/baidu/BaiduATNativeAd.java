package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.baidu.impression.BDImpressionTracker;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/BaiduATNativeAd.class */
public class BaiduATNativeAd extends CustomNativeAd {
    private static final String e = BaiduATNativeAd.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected NativeResponse f8874a;
    protected Context b;

    /* renamed from: c  reason: collision with root package name */
    BDImpressionTracker f8875c;
    boolean d = true;
    private XNativeView f;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduATNativeAd() {
    }

    public BaiduATNativeAd(Context context, NativeResponse nativeResponse) {
        a(context, nativeResponse);
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

    private void a(View view, View.OnClickListener onClickListener) {
        if (!(view instanceof ViewGroup) || view == this.f) {
            view.setOnClickListener(onClickListener);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i2), onClickListener);
            i = i2 + 1;
        }
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup) || view == this.f) {
            view.setOnClickListener(null);
            view.setClickable(false);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            b(viewGroup.getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, NativeResponse nativeResponse) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f8875c = new BDImpressionTracker(applicationContext, 50);
        this.f8874a = nativeResponse;
        setData(nativeResponse);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        b(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.f8874a = null;
        XNativeView xNativeView = this.f;
        if (xNativeView != null) {
            xNativeView.setNativeItem(null);
            this.f.setNativeViewClickListener(null);
            this.f = null;
        }
        this.b = null;
        BDImpressionTracker bDImpressionTracker = this.f8875c;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.f8875c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeResponse nativeResponse = this.f8874a;
        if (nativeResponse == null || nativeResponse.getMaterialType() != NativeResponse.MaterialType.VIDEO) {
            return null;
        }
        if (this.f == null) {
            XNativeView xNativeView = new XNativeView(this.b);
            this.f = xNativeView;
            xNativeView.setNativeItem(this.f8874a);
            this.f.setVideoMute(this.d);
            this.f.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.3
                @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                public final void onNativeViewClick(XNativeView xNativeView2) {
                    BaiduATNativeAd.this.notifyAdClicked();
                }
            });
        }
        return this.f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        NativeResponse nativeResponse = this.f8874a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        NativeResponse nativeResponse = this.f8874a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, final ATShakeViewListener aTShakeViewListener) {
        NativeResponse nativeResponse = this.f8874a;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.4
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                public final void onDismiss() {
                    ATShakeViewListener aTShakeViewListener2 = aTShakeViewListener;
                    if (aTShakeViewListener2 != null) {
                        aTShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(View view) {
        NativeResponse nativeResponse = this.f8874a;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r0.size() == 0) goto L13;
     */
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepare(android.view.View r9, com.anythink.nativead.api.ATNativePrepareInfo r10) {
        /*
            r8 = this;
            r0 = r8
            com.baidu.mobads.sdk.api.NativeResponse r0 = r0.f8874a
            if (r0 == 0) goto L60
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.anythink.nativead.api.ATNativePrepareExInfo
            if (r0 == 0) goto L2e
            r0 = r10
            com.anythink.nativead.api.ATNativePrepareExInfo r0 = (com.anythink.nativead.api.ATNativePrepareExInfo) r0
            java.util.List r0 = r0.getCreativeClickViewList()
            r13 = r0
            r0 = r12
            r11 = r0
            r0 = r13
            if (r0 == 0) goto L2e
            r0 = r13
            r11 = r0
        L2e:
            r0 = r10
            java.util.List r0 = r0.getClickViewList()
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L46
            r0 = r12
            r10 = r0
            r0 = r12
            int r0 = r0.size()
            if (r0 != 0) goto L4c
        L46:
            r0 = r8
            r1 = r9
            java.util.List r0 = r0.a(r1)
            r10 = r0
        L4c:
            r0 = r8
            com.baidu.mobads.sdk.api.NativeResponse r0 = r0.f8874a
            r1 = r9
            r2 = r10
            r3 = r11
            com.anythink.network.baidu.BaiduATNativeAd$1 r4 = new com.anythink.network.baidu.BaiduATNativeAd$1
            r5 = r4
            r6 = r8
            r5.<init>()
            r0.registerViewForInteraction(r1, r2, r3, r4)
        L60:
            r0 = r8
            com.baidu.mobads.sdk.api.XNativeView r0 = r0.f
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L6d
            r0 = r10
            r0.render()
        L6d:
            r0 = r8
            com.anythink.network.baidu.impression.BDImpressionTracker r0 = r0.f8875c     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L84
            r0 = r8
            com.anythink.network.baidu.impression.BDImpressionTracker r0 = r0.f8875c     // Catch: java.lang.Throwable -> L85
            r1 = r9
            com.anythink.network.baidu.BaiduATNativeAd$2 r2 = new com.anythink.network.baidu.BaiduATNativeAd$2     // Catch: java.lang.Throwable -> L85
            r3 = r2
            r4 = r8
            r3.<init>()     // Catch: java.lang.Throwable -> L85
            r0.addView(r1, r2)     // Catch: java.lang.Throwable -> L85
        L84:
            return
        L85:
            r9 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.baidu.BaiduATNativeAd.prepare(android.view.View, com.anythink.nativead.api.ATNativePrepareInfo):void");
    }

    public void setData(NativeResponse nativeResponse) {
        setIconImageUrl(nativeResponse.getIconUrl());
        int i = 0;
        if (TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls != null && multiPicUrls.size() > 0) {
                setMainImageUrl(multiPicUrls.get(0));
                setMainImageWidth(nativeResponse.getMainPicWidth());
                setMainImageHeight(nativeResponse.getMainPicHeight());
            }
        } else {
            setMainImageUrl(nativeResponse.getImageUrl());
            setMainImageWidth(nativeResponse.getMainPicWidth());
            setMainImageHeight(nativeResponse.getMainPicHeight());
        }
        setMainImageWidth(nativeResponse.getMainPicWidth());
        setMainImageHeight(nativeResponse.getMainPicHeight());
        setImageUrlList(nativeResponse.getMultiPicUrls());
        setVideoUrl(nativeResponse.getVideoUrl());
        setVideoDuration(nativeResponse.getDuration());
        setAdChoiceIconUrl(nativeResponse.getBaiduLogoUrl());
        setTitle(nativeResponse.getTitle());
        setDescriptionText(nativeResponse.getDesc());
        setCallToActionText(nativeResponse.getActButtonString());
        setAdvertiserName(nativeResponse.getBrandName());
        if (nativeResponse.getAdActionType() == 1) {
            i = 2;
        }
        if (nativeResponse.getAdActionType() == 2) {
            i = 1;
        }
        if (nativeResponse.getAdActionType() == 3) {
            i = 3;
        }
        setNativeInteractionType(i);
        if (nativeResponse.getAdActionType() == 2) {
            setAdAppInfo(new BaiduATDownloadAppInfo(nativeResponse));
        }
        if (TextUtils.equals(nativeResponse.getAdMaterialType(), NativeResponse.MaterialType.VIDEO.getValue())) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        this.d = z;
        XNativeView xNativeView = this.f;
        if (xNativeView != null) {
            xNativeView.setVideoMute(z);
        }
    }
}
