package com.anythink.core.api;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATAdSourceStatusListener.class */
public interface ATAdSourceStatusListener {
    void onAdSourceAttempt(ATAdInfo aTAdInfo);

    void onAdSourceBiddingAttempt(ATAdInfo aTAdInfo);

    void onAdSourceBiddingFail(ATAdInfo aTAdInfo, AdError adError);

    void onAdSourceBiddingFilled(ATAdInfo aTAdInfo);

    void onAdSourceLoadFail(ATAdInfo aTAdInfo, AdError adError);

    void onAdSourceLoadFilled(ATAdInfo aTAdInfo);
}
