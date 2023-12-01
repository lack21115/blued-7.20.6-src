package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeCPUManager.class */
public class NativeCPUManager {
    private static final String TAG = NativeCPUManager.class.getSimpleName();
    private CPUAdListener mCPUAdListener;
    private ad mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeCPUManager$CPUAdListener.class */
    public interface CPUAdListener {
        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/NativeCPUManager$DataPostBackListener.class */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context == null || TextUtils.isEmpty(str)) {
            bq.a().c(TAG, "Init params error!");
            if (cPUAdListener != null) {
                cPUAdListener.onAdError("Input params error.", bm.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        this.mCPUAdListener = cPUAdListener;
        this.mContext = context;
        ad adVar = new ad(context, str, this);
        this.mCPUAdProd = adVar;
        adVar.a(cPUAdListener);
    }

    private void loadAd(int i, int[] iArr, boolean z) {
        if (i <= 0 || iArr == null) {
            bq.a().c(TAG, "LoadAd with terrible params!");
            return;
        }
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(i, this.mPageSize, iArr, z, this.mParams);
            this.mCPUAdProd.f();
            this.mCPUAdProd.a();
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        loadAd(i, new int[]{i2}, z);
    }

    public void openAppActivity(String str) {
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i) {
        if (i <= 0 || i > 20) {
            bq.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        } else {
            this.mPageSize = i;
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i) {
        ad adVar = this.mCPUAdProd;
        if (adVar != null) {
            adVar.a(i);
        }
    }
}
