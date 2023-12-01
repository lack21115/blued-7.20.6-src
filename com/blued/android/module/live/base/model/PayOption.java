package com.blued.android.module.live.base.model;

import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/PayOption.class */
public class PayOption {
    public String banner_url;
    public int has_payment_code;
    public int is_show_vip_icon;
    public List<_pay_list> pay_list;
    public String vip_link;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/PayOption$_item.class */
    public class _item {
        public String name = "";
        public String description = "";

        public _item() {
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/PayOption$_pay_list.class */
    public static class _pay_list {
        public float bonus;
        public boolean choosed;
        public String google_id;
        public long id;
        public int is_selected;
        public _item item;
        public double money;
        public int pretax;
        public double ratio;
    }
}
