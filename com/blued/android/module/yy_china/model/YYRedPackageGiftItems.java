package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRedPackageGiftItems.class */
public final class YYRedPackageGiftItems {
    private final String goods_id;
    private final String images_static;
    private final String num;

    public YYRedPackageGiftItems(String goods_id, String num, String images_static) {
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(num, "num");
        Intrinsics.e(images_static, "images_static");
        this.goods_id = goods_id;
        this.num = num;
        this.images_static = images_static;
    }

    public static /* synthetic */ YYRedPackageGiftItems copy$default(YYRedPackageGiftItems yYRedPackageGiftItems, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRedPackageGiftItems.goods_id;
        }
        if ((i & 2) != 0) {
            str2 = yYRedPackageGiftItems.num;
        }
        if ((i & 4) != 0) {
            str3 = yYRedPackageGiftItems.images_static;
        }
        return yYRedPackageGiftItems.copy(str, str2, str3);
    }

    public final String component1() {
        return this.goods_id;
    }

    public final String component2() {
        return this.num;
    }

    public final String component3() {
        return this.images_static;
    }

    public final YYRedPackageGiftItems copy(String goods_id, String num, String images_static) {
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(num, "num");
        Intrinsics.e(images_static, "images_static");
        return new YYRedPackageGiftItems(goods_id, num, images_static);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRedPackageGiftItems) {
            YYRedPackageGiftItems yYRedPackageGiftItems = (YYRedPackageGiftItems) obj;
            return Intrinsics.a((Object) this.goods_id, (Object) yYRedPackageGiftItems.goods_id) && Intrinsics.a((Object) this.num, (Object) yYRedPackageGiftItems.num) && Intrinsics.a((Object) this.images_static, (Object) yYRedPackageGiftItems.images_static);
        }
        return false;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getImages_static() {
        return this.images_static;
    }

    public final String getNum() {
        return this.num;
    }

    public int hashCode() {
        return (((this.goods_id.hashCode() * 31) + this.num.hashCode()) * 31) + this.images_static.hashCode();
    }

    public String toString() {
        return "YYRedPackageGiftItems(goods_id=" + this.goods_id + ", num=" + this.num + ", images_static=" + this.images_static + ')';
    }
}
