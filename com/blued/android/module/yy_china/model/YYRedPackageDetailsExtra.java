package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRedPackageDetailsExtra.class */
public final class YYRedPackageDetailsExtra extends BluedEntityBaseExtra {
    private String close_time;
    private YYGiftModel goods_info;

    public YYRedPackageDetailsExtra(String close_time, YYGiftModel goods_info) {
        Intrinsics.e(close_time, "close_time");
        Intrinsics.e(goods_info, "goods_info");
        this.close_time = close_time;
        this.goods_info = goods_info;
    }

    public static /* synthetic */ YYRedPackageDetailsExtra copy$default(YYRedPackageDetailsExtra yYRedPackageDetailsExtra, String str, YYGiftModel yYGiftModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRedPackageDetailsExtra.close_time;
        }
        if ((i & 2) != 0) {
            yYGiftModel = yYRedPackageDetailsExtra.goods_info;
        }
        return yYRedPackageDetailsExtra.copy(str, yYGiftModel);
    }

    public final String component1() {
        return this.close_time;
    }

    public final YYGiftModel component2() {
        return this.goods_info;
    }

    public final YYRedPackageDetailsExtra copy(String close_time, YYGiftModel goods_info) {
        Intrinsics.e(close_time, "close_time");
        Intrinsics.e(goods_info, "goods_info");
        return new YYRedPackageDetailsExtra(close_time, goods_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRedPackageDetailsExtra) {
            YYRedPackageDetailsExtra yYRedPackageDetailsExtra = (YYRedPackageDetailsExtra) obj;
            return Intrinsics.a((Object) this.close_time, (Object) yYRedPackageDetailsExtra.close_time) && Intrinsics.a(this.goods_info, yYRedPackageDetailsExtra.goods_info);
        }
        return false;
    }

    public final String getClose_time() {
        return this.close_time;
    }

    public final YYGiftModel getGoods_info() {
        return this.goods_info;
    }

    public int hashCode() {
        return (this.close_time.hashCode() * 31) + this.goods_info.hashCode();
    }

    public final void setClose_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.close_time = str;
    }

    public final void setGoods_info(YYGiftModel yYGiftModel) {
        Intrinsics.e(yYGiftModel, "<set-?>");
        this.goods_info = yYGiftModel;
    }

    public String toString() {
        return "YYRedPackageDetailsExtra(close_time=" + this.close_time + ", goods_info=" + this.goods_info + ')';
    }
}
