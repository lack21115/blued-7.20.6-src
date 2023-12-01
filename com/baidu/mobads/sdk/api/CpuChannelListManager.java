package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.l;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuChannelListManager.class */
public class CpuChannelListManager {
    private static final String TAG = CpuChannelListManager.class.getSimpleName();
    private l mCPUChannelListProd;
    private CpuChannelListListener mChannelIdListListener;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuChannelListManager$CpuChannelListListener.class */
    public interface CpuChannelListListener {
        void onChannelListError(String str, int i);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        l lVar = new l(context);
        this.mCPUChannelListProd = lVar;
        this.mChannelIdListListener = cpuChannelListListener;
        lVar.a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bq.a().c(TAG, "SubChannelId is null!");
            CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", bm.INTERFACE_USE_PROBLEM.b());
            }
        } else if (TextUtils.isEmpty(str)) {
            bq.a().c(TAG, "appsid is null!");
            CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", bm.INTERFACE_USE_PROBLEM.b());
            }
        } else {
            try {
                int parseInt = Integer.parseInt(str2);
                l lVar = this.mCPUChannelListProd;
                if (lVar != null) {
                    lVar.a(str, parseInt);
                    this.mCPUChannelListProd.a();
                }
            } catch (Exception e) {
                bq.a().c(TAG, "SubChannelId is not Integer!");
                CpuChannelListListener cpuChannelListListener3 = this.mChannelIdListListener;
                if (cpuChannelListListener3 != null) {
                    cpuChannelListListener3.onChannelListError("SubChannelId is not Integer!", bm.INTERFACE_USE_PROBLEM.b());
                }
            }
        }
    }
}
