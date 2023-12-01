package com.soft.blued.ui.user.model;

import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse.class */
public class PrivilegeBuyOptionForJsonParse {
    public PayPlatformDiscountModel._channel channel;
    public List<ProductBean> product;
    public int select_super_call;
    public List<ProductBean> super_call;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/PrivilegeBuyOptionForJsonParse$ProductBean.class */
    public static class ProductBean extends GoodsOptionBasic {
        public int average_beans;
        public float average_price;
        public int buy_num;
        public boolean choosen;
        public String desc;
        public String discount;
        public int discount_beans;
        public String discount_per;
        public float discount_price;
        public int is_recommend;
        public int is_signed;
        public String recommend_time;
        public boolean showBeans;
        public int total_beans;
        public double total_price;
        public String unit;
    }
}
