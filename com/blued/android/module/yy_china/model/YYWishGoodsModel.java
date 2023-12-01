package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.StringUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYWishGoodsModel.class */
public class YYWishGoodsModel {
    public String beans;
    public boolean enableDelete;
    public String goods_id;
    public String images_static;
    public String name;
    public String wish_current;
    public String wish_total;

    public void cleanGoods() {
        this.enableDelete = false;
        this.goods_id = "";
        this.images_static = "";
        this.name = "";
        this.wish_current = "";
        this.wish_total = "";
    }

    public boolean isCompleted() {
        boolean z = false;
        if (StringUtils.a(this.wish_total, 0) == StringUtils.a(this.wish_current, 0)) {
            z = true;
        }
        return z;
    }
}
