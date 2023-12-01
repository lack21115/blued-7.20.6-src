package com.soft.blued.ui.user.model;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOption.class */
public class VIPBuyOption extends GoodsOptionBasic implements Serializable {
    public boolean choosen;
    public int days;
    public int default_checked;
    public String icon;
    public int is_entrust_giver;
    public int is_hot;
    public _item item;
    public double money;
    public int month;
    public double original_money;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPBuyOption$_item.class */
    public class _item implements Serializable {
        public String button;
        public String description;
        public String name;
        public String price_copy;
        public String remark;
        public String tag;
        public String tag1;
        public String tag2;
        public String tag_bottom;
        public String tag_up;
        public String title;

        public _item() {
        }
    }
}
