package com.anythink.core.common.k.a;

import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/a.class */
public abstract class a implements b {
    private static final int DEFAULT_IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    private static final int DEFAULT_IMPRESSION_MIN_TIME_VIEWED_MS = 500;
    private boolean mImpressionRecorded;
    private int mImpressionMinTimeViewed = 500;
    private int mImpressionMinPercentageViewed = 50;
    private Integer mImpressionMinVisiblePx = null;

    @Override // com.anythink.core.common.k.a.b
    public int getImpressionMinPercentageViewed() {
        return this.mImpressionMinPercentageViewed;
    }

    @Override // com.anythink.core.common.k.a.b
    public int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    @Override // com.anythink.core.common.k.a.b
    public final Integer getImpressionMinVisiblePx() {
        return this.mImpressionMinVisiblePx;
    }

    @Override // com.anythink.core.common.k.a.b
    public final boolean isImpressionRecorded() {
        return this.mImpressionRecorded;
    }

    @Override // com.anythink.core.common.k.a.b
    public abstract void recordImpression(View view);

    @Override // com.anythink.core.common.k.a.b
    public final void setImpressionRecorded() {
        this.mImpressionRecorded = true;
    }
}
