package com.anythink.network.baidu.impression;

import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/BDImpressionInterface.class */
public interface BDImpressionInterface {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
