package com.soft.blued.ui.pay.model;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/BluedCoupon.class */
public class BluedCoupon implements Serializable {
    public String discount;
    public String discount_desc;
    public int discount_type;
    public String end_time;
    public int id;
    public int is_available;
    public String money;
    public String name;
    public String not_available_desc;
    public String start_time;
    public String tag;
    public int type;
    public boolean ifShowUrlVisited = false;
    public boolean ifChoosed = false;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/BluedCoupon$COUPON_DISCOUNT_TYPE.class */
    public interface COUPON_DISCOUNT_TYPE {
        public static final int CASH = 0;
        public static final int FULL_GIFT = 2;
        public static final int RATE = 1;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/model/BluedCoupon$COUPON_PRODUCT_TYPE.class */
    public interface COUPON_PRODUCT_TYPE {
        public static final int ALL = 9;
        public static final int HELLO = 4;
        public static final int NONE = 0;
        public static final int SUPER_EXPLOSURE = 3;
        public static final int SVIP = 2;
        public static final int VIP = 1;
    }
}
