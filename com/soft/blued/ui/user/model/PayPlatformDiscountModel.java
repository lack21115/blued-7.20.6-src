package com.soft.blued.ui.user.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PayPlatformDiscountModel.class */
public class PayPlatformDiscountModel {
    public _channel channel;
    public int strategy_num;
    public String type;
    public _vip vip;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PayPlatformDiscountModel$_channel.class */
    public static class _channel {
        public _discountDesc alipay;
        public _discountDesc huabei;
        public _discountDesc weixin;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PayPlatformDiscountModel$_discountDesc.class */
    public class _discountDesc {
        public String desc;
        public int is_choose;

        public _discountDesc() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PayPlatformDiscountModel$_vip.class */
    public class _vip {
        public int contract;
        public int is_upgrade;

        public _vip() {
        }
    }
}
