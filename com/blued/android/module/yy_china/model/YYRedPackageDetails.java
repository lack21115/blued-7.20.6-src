package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRedPackageDetails.class */
public final class YYRedPackageDetails {
    private String delay_time;
    private List<YYRedPackageGiftItems> goods_lists;
    private String id;
    private int is_checked;
    private String total_beans;
    private String total_num;

    public YYRedPackageDetails(int i, String id, String total_beans, String total_num, String delay_time, List<YYRedPackageGiftItems> goods_lists) {
        Intrinsics.e(id, "id");
        Intrinsics.e(total_beans, "total_beans");
        Intrinsics.e(total_num, "total_num");
        Intrinsics.e(delay_time, "delay_time");
        Intrinsics.e(goods_lists, "goods_lists");
        this.is_checked = i;
        this.id = id;
        this.total_beans = total_beans;
        this.total_num = total_num;
        this.delay_time = delay_time;
        this.goods_lists = goods_lists;
    }

    public static /* synthetic */ YYRedPackageDetails copy$default(YYRedPackageDetails yYRedPackageDetails, int i, String str, String str2, String str3, String str4, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYRedPackageDetails.is_checked;
        }
        if ((i2 & 2) != 0) {
            str = yYRedPackageDetails.id;
        }
        if ((i2 & 4) != 0) {
            str2 = yYRedPackageDetails.total_beans;
        }
        if ((i2 & 8) != 0) {
            str3 = yYRedPackageDetails.total_num;
        }
        if ((i2 & 16) != 0) {
            str4 = yYRedPackageDetails.delay_time;
        }
        if ((i2 & 32) != 0) {
            list = yYRedPackageDetails.goods_lists;
        }
        return yYRedPackageDetails.copy(i, str, str2, str3, str4, list);
    }

    public final int component1() {
        return this.is_checked;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.total_beans;
    }

    public final String component4() {
        return this.total_num;
    }

    public final String component5() {
        return this.delay_time;
    }

    public final List<YYRedPackageGiftItems> component6() {
        return this.goods_lists;
    }

    public final YYRedPackageDetails copy(int i, String id, String total_beans, String total_num, String delay_time, List<YYRedPackageGiftItems> goods_lists) {
        Intrinsics.e(id, "id");
        Intrinsics.e(total_beans, "total_beans");
        Intrinsics.e(total_num, "total_num");
        Intrinsics.e(delay_time, "delay_time");
        Intrinsics.e(goods_lists, "goods_lists");
        return new YYRedPackageDetails(i, id, total_beans, total_num, delay_time, goods_lists);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRedPackageDetails) {
            YYRedPackageDetails yYRedPackageDetails = (YYRedPackageDetails) obj;
            return this.is_checked == yYRedPackageDetails.is_checked && Intrinsics.a((Object) this.id, (Object) yYRedPackageDetails.id) && Intrinsics.a((Object) this.total_beans, (Object) yYRedPackageDetails.total_beans) && Intrinsics.a((Object) this.total_num, (Object) yYRedPackageDetails.total_num) && Intrinsics.a((Object) this.delay_time, (Object) yYRedPackageDetails.delay_time) && Intrinsics.a(this.goods_lists, yYRedPackageDetails.goods_lists);
        }
        return false;
    }

    public final String getDelay_time() {
        return this.delay_time;
    }

    public final List<YYRedPackageGiftItems> getGoods_lists() {
        return this.goods_lists;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTotal_beans() {
        return this.total_beans;
    }

    public final String getTotal_num() {
        return this.total_num;
    }

    public int hashCode() {
        return (((((((((this.is_checked * 31) + this.id.hashCode()) * 31) + this.total_beans.hashCode()) * 31) + this.total_num.hashCode()) * 31) + this.delay_time.hashCode()) * 31) + this.goods_lists.hashCode();
    }

    public final int is_checked() {
        return this.is_checked;
    }

    public final void setDelay_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.delay_time = str;
    }

    public final void setGoods_lists(List<YYRedPackageGiftItems> list) {
        Intrinsics.e(list, "<set-?>");
        this.goods_lists = list;
    }

    public final void setId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.id = str;
    }

    public final void setTotal_beans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.total_beans = str;
    }

    public final void setTotal_num(String str) {
        Intrinsics.e(str, "<set-?>");
        this.total_num = str;
    }

    public final void set_checked(int i) {
        this.is_checked = i;
    }

    public String toString() {
        return "YYRedPackageDetails(is_checked=" + this.is_checked + ", id=" + this.id + ", total_beans=" + this.total_beans + ", total_num=" + this.total_num + ", delay_time=" + this.delay_time + ", goods_lists=" + this.goods_lists + ')';
    }
}
