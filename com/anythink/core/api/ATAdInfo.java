package com.anythink.core.api;

import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdInfo.class */
public abstract class ATAdInfo {
    public abstract int getABTestId();

    public abstract String getAdNetworkType();

    public abstract String getAdsourceId();

    public abstract int getAdsourceIndex();

    public abstract String getChannel();

    public abstract String getCountry();

    public abstract String getCurrency();

    public abstract String getCustomRule();

    public abstract int getDismissType();

    public abstract double getEcpm();

    public abstract int getEcpmLevel();

    public abstract String getEcpmPrecision();

    public abstract Map<String, Object> getExtInfoMap();

    public abstract Map<String, Object> getLocalExtra();

    public abstract int getNetworkFirmId();

    public abstract String getNetworkPlacementId();

    public abstract Double getPublisherRevenue();

    public abstract String getRewardUserCustomData();

    public abstract String getScenarioId();

    public abstract String getScenarioRewardName();

    public abstract int getScenarioRewardNumber();

    public abstract int getSegmentId();

    public abstract String getShowId();

    public abstract String getSubChannel();

    public abstract String getTopOnAdFormat();

    public abstract String getTopOnPlacementId();

    public abstract String getTpBidId();

    public abstract int isHeaderBiddingAdsource();
}
