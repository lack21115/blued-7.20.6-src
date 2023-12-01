package com.anythink.core.common.e;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/l.class */
public class l {
    public static final int EXPIRE_LOSS = 1;
    public static final int LOW_PRICE_LOSS = 2;
    public static final int NO_LOSS_NOTICE = 3;
    public ATBiddingNotice biddingNotice;
    public ATAdConst.CURRENCY currency;
    public String displayNoticeUrl;
    public String errorMsg;
    protected boolean isSuccess;
    public String loseNoticeUrl;
    public double originPrice;
    protected double price;
    protected double sortPrice;
    public String token;
    public int useType = 1;
    public String winNoticeUrl;

    public l(boolean z, double d, String str, ATBiddingNotice aTBiddingNotice, String str2, ATAdConst.CURRENCY currency) {
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.biddingNotice = aTBiddingNotice;
        this.errorMsg = str2;
        this.currency = currency;
    }

    public l(boolean z, double d, String str, String str2, String str3, String str4, String str5, ATAdConst.CURRENCY currency) {
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.winNoticeUrl = str2;
        this.loseNoticeUrl = str3;
        this.displayNoticeUrl = str4;
        this.errorMsg = str5;
        this.currency = currency;
    }

    public double getPrice() {
        return this.price;
    }

    public double getSortPrice() {
        return this.sortPrice;
    }

    public boolean isSuccessWithUseType() {
        return this.isSuccess && this.useType == 1;
    }

    public void setBiddingNotice(ATBiddingNotice aTBiddingNotice) {
        this.biddingNotice = aTBiddingNotice;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setSortPrice(double d) {
        this.sortPrice = d;
    }
}
