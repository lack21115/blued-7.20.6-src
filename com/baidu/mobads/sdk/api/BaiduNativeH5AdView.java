package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.dc;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeH5AdView.class */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement mAdPlacement;
    private dc mAdProd;
    private BaiduNativeH5EventListner mAdViewListener;
    private RequestParameters mRequestParameters;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeH5AdView$BaiduNativeH5EventListner.class */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        this.mAdViewListener = null;
        initView(context, i);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdViewListener = null;
        initView(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdViewListener = null;
        initView(context, 0);
    }

    private void cancel() {
    }

    private void initView(Context context, int i) {
        if (i != 0) {
            setBackgroundResource(i);
        }
    }

    private void onDetach() {
        cancel();
        dc dcVar = this.mAdProd;
        if (dcVar != null) {
            dcVar.e();
        }
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.mAdPlacement;
    }

    public boolean isAdDataLoaded() {
        dc dcVar = this.mAdProd;
        if (dcVar != null) {
            return dcVar.g();
        }
        return false;
    }

    public void makeRequest(RequestParameters requestParameters) {
        RequestParameters requestParameters2 = requestParameters;
        if (requestParameters == null) {
            requestParameters2 = new RequestParameters.Builder().build();
        }
        this.mRequestParameters = requestParameters2;
        if (this.mAdProd != null) {
            onDetach();
        }
        dc dcVar = new dc(getContext(), IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        this.mAdProd = dcVar;
        dcVar.a(requestParameters2);
        this.mAdProd.a(this.mAdPlacement);
        this.mAdProd.a(this.mAdPlacement.getSessionId());
        this.mAdProd.c(this.mAdPlacement.getPosistionId());
        this.mAdProd.d(this.mAdPlacement.getSequenceId());
        BaiduNativeH5EventListner baiduNativeH5EventListner = this.mAdViewListener;
        if (baiduNativeH5EventListner != null) {
            this.mAdProd.a(baiduNativeH5EventListner);
        }
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement != null) {
            if (!baiduNativeAdPlacement.hasValidResponse()) {
                this.mAdProd.c(false);
                if (this.mAdPlacement.getRequestStarted()) {
                    return;
                }
                this.mAdPlacement.setRequestStarted(true);
            } else if (this.mAdProd.f()) {
                return;
            }
        }
        this.mAdProd.a();
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement == null || baiduNativeAdPlacement.getResponse() == null || this.mAdPlacement.isWinSended()) {
            return;
        }
        this.mAdProd.a(this, this.mAdPlacement.getResponse().S());
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) ar.a(obj, "getApId", new Class[0], new Object[0]));
        String str = (String) ar.a(obj, "getAppSid", new Class[0], new Object[0]);
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.mAdViewListener = baiduNativeH5EventListner;
    }
}
