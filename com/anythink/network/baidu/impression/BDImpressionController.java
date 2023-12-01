package com.anythink.network.baidu.impression;

import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/BDImpressionController.class */
public abstract class BDImpressionController implements BDImpressionInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6062a = 0;
    private static final int b = 50;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6063c;
    private int d = 0;
    private int e = 50;
    private Integer f = null;

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return this.e;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.d;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final Integer getImpressionMinVisiblePx() {
        return this.f;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.f6063c;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public abstract void recordImpression(View view);

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final void setImpressionRecorded() {
        this.f6063c = true;
    }
}
