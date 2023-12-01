package com.anythink.core.common.k.a;

import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/b.class */
public interface b {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
