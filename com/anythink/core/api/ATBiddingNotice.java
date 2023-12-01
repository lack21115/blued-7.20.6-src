package com.anythink.core.api;

import com.anythink.core.api.ATAdConst;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATBiddingNotice.class */
public interface ATBiddingNotice {
    public static final String ADN_ID = "adn_id";

    ATAdConst.CURRENCY getNoticePriceCurrency();

    void notifyBidDisplay(boolean z, double d);

    void notifyBidLoss(String str, double d, Map<String, Object> map);

    void notifyBidWin(double d);
}
