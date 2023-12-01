package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bs;
import com.huawei.hms.ads.kz;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeView.class */
public class NativeView extends PPSNativeView implements INativeView {
    private View B;
    private View C;
    private View D;
    private View F;
    private ChoicesView I;
    private View L;
    private View S;
    private final Map<String, View> V;

    /* renamed from: a  reason: collision with root package name */
    private MediaView f8912a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f8913c;
    private View d;
    private bs e;

    public NativeView(Context context) {
        super(context);
        this.V = new HashMap();
    }

    public NativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = new HashMap();
    }

    public NativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = new HashMap();
    }

    public NativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.V = new HashMap();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void destroy() {
        this.V.clear();
        bs bsVar = this.e;
        if (bsVar != null) {
            bsVar.destroy();
        }
        MediaView mediaView = this.f8912a;
        if (mediaView != null) {
            mediaView.Code();
        }
        this.Code.I();
        super.B();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getAdSourceView() {
        return this.V.get("5");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getCallToActionView() {
        return this.V.get("2");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public ChoicesView getChoicesView() {
        View view = this.V.get("11");
        if (view instanceof ChoicesView) {
            return (ChoicesView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getDescriptionView() {
        return this.V.get("4");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getIconView() {
        return this.V.get("3");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getImageView() {
        return this.V.get("8");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getMarketView() {
        return this.V.get("6");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public MediaView getMediaView() {
        View view = this.V.get("10");
        if (view instanceof MediaView) {
            return (MediaView) view;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getPriceView() {
        return this.V.get("7");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getRatingView() {
        return this.V.get("9");
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public View getTitleView() {
        return this.V.get("1");
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void gotoWhyThisAdPage() {
        super.gotoWhyThisAdPage();
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void hideAdvertiserInfoDialog() {
        super.hideAdvertiserInfoDialog();
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView, com.huawei.hms.ads.nativead.INativeView
    public void onViewUpdate() {
        super.onViewUpdate();
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public boolean register(AppDownloadButton appDownloadButton) {
        return super.Code((kz) appDownloadButton);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setAdSourceView(View view) {
        this.B = view;
        this.V.put("5", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setCallToActionView(View view) {
        this.S = view;
        this.V.put("2", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setChoicesView(ChoicesView choicesView) {
        this.I = choicesView;
        this.V.put("11", choicesView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setDescriptionView(View view) {
        this.C = view;
        this.V.put("4", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setIconView(View view) {
        this.D = view;
        this.V.put("3", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setImageView(View view) {
        this.L = view;
        this.V.put("8", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMarketView(View view) {
        this.d = view;
        this.V.put("6", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setMediaView(MediaView mediaView) {
        this.f8912a = mediaView;
        this.V.put("10", mediaView);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setNativeAd(NativeAd nativeAd) {
        NativeAdConfiguration ad;
        if (nativeAd instanceof bs) {
            bs bsVar = (bs) nativeAd;
            this.e = bsVar;
            bsVar.Code(this);
            setIsCustomDislikeThisAdEnabled(nativeAd.isCustomDislikeThisAdEnabled());
            NativeVideoView nativeVideoView = null;
            MediaView mediaView = this.f8912a;
            if (mediaView != null) {
                b mediaViewAdapter = mediaView.getMediaViewAdapter();
                mediaViewAdapter.Code(nativeAd);
                View B = mediaViewAdapter.B();
                VideoOperator videoOperator = this.e.getVideoOperator();
                nativeVideoView = B;
                if (videoOperator instanceof c) {
                    ((c) videoOperator).Code(this.f8912a);
                    nativeVideoView = B;
                }
            }
            g Code = this.e.Code();
            List<View> arrayList = new ArrayList<>();
            arrayList.add(this);
            View callToActionView = getCallToActionView();
            if (callToActionView != null && callToActionView.isEnabled()) {
                arrayList.add(callToActionView);
            }
            if ((Code instanceof n) && (ad = ((n) Code).ad()) != null) {
                setChoiceViewPosition(ad.getChoicesPosition());
            }
            if (nativeVideoView instanceof NativeWindowImageView) {
                Code(Code, arrayList, (NativeWindowImageView) nativeVideoView);
            } else if (!(nativeVideoView instanceof NativeVideoView)) {
                Code(Code, arrayList);
            } else {
                NativeVideoView nativeVideoView2 = nativeVideoView;
                arrayList.add(nativeVideoView2.getPreviewImageView());
                Code(Code, arrayList, nativeVideoView2);
            }
        }
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setPriceView(View view) {
        this.b = view;
        this.V.put("7", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setRatingView(View view) {
        this.f8913c = view;
        this.V.put("9", view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void setTitleView(View view) {
        this.F = view;
        this.V.put("1", view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void showAdvertiserInfoDialog(View view, boolean z) {
        super.showAdvertiserInfoDialog(view, z);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    public void showFeedback(View view) {
        super.showFeedback(view);
    }

    @Override // com.huawei.hms.ads.nativead.INativeView
    public void unregister(AppDownloadButton appDownloadButton) {
        super.V((kz) appDownloadButton);
    }
}
