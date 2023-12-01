package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.cv;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CPUNovelAd.class */
public class CPUNovelAd {
    private cv mCpuNovelProd;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CPUNovelAd$CpuNovelListener.class */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        cv cvVar = new cv(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = cvVar;
        cvVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        cv cvVar = this.mCpuNovelProd;
        if (cvVar != null) {
            cvVar.x();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.v();
    }
}
