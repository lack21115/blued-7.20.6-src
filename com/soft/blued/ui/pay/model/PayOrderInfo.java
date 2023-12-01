package com.soft.blued.ui.pay.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/PayOrderInfo.class */
public class PayOrderInfo {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/PayOrderInfo$AlipayOrder.class */
    public class AlipayOrder {
        public String info;
        public String orderinfo;
        public String sign;
        public String sign_type;

        public AlipayOrder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/PayOrderInfo$WXpayOrder.class */
    public static class WXpayOrder {
        public String appid;
        public String noncestr;
        public String out_trade_no;
        public String packageValue;
        public String partnerid;
        public String prepayid;
        public String sign;
        public String timestamp;
    }
}
