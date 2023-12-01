package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/IBasicCPUAggregation.class */
public interface IBasicCPUAggregation {

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/IBasicCPUAggregation$ICpuHotNativeStatus.class */
    public interface ICpuHotNativeStatus {
        void onNotifyPerformance(String str);
    }

    String getContentId();

    List<String> getImagesList();

    String getLongTitle();

    String getShortTitle();

    String getTitle();

    void registerViewForInteraction(View view, List<View> list, ICpuHotNativeStatus iCpuHotNativeStatus);
}
