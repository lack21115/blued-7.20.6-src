package com.heytap.msp.mobad.api.ad;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/IBidding.class */
public interface IBidding {
    public static final int CODE_RANK_LOSE_OTHER = 4;
    public static final int CODE_RANK_LOSS_AD_FAIL = 3;
    public static final int CODE_RANK_LOSS_LOW_PRICE = 1;
    public static final int CODE_RANK_LOSS_TIMEOUT = 2;

    int getECPM();

    void notifyRankLoss(int i, String str, int i2);

    void notifyRankWin(int i);

    void setBidECPM(int i);
}
