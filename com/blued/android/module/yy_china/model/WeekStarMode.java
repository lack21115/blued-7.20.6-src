package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/WeekStarMode.class */
public final class WeekStarMode {
    private final ArrayList<String> goods_ids;
    private final WeekStarInfoMode new_info;
    private final WeekStarInfoMode star_info;

    public WeekStarMode(ArrayList<String> goods_ids, WeekStarInfoMode star_info, WeekStarInfoMode new_info) {
        Intrinsics.e(goods_ids, "goods_ids");
        Intrinsics.e(star_info, "star_info");
        Intrinsics.e(new_info, "new_info");
        this.goods_ids = goods_ids;
        this.star_info = star_info;
        this.new_info = new_info;
    }

    public static /* synthetic */ WeekStarMode copy$default(WeekStarMode weekStarMode, ArrayList arrayList, WeekStarInfoMode weekStarInfoMode, WeekStarInfoMode weekStarInfoMode2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = weekStarMode.goods_ids;
        }
        if ((i & 2) != 0) {
            weekStarInfoMode = weekStarMode.star_info;
        }
        if ((i & 4) != 0) {
            weekStarInfoMode2 = weekStarMode.new_info;
        }
        return weekStarMode.copy(arrayList, weekStarInfoMode, weekStarInfoMode2);
    }

    public final ArrayList<String> component1() {
        return this.goods_ids;
    }

    public final WeekStarInfoMode component2() {
        return this.star_info;
    }

    public final WeekStarInfoMode component3() {
        return this.new_info;
    }

    public final WeekStarMode copy(ArrayList<String> goods_ids, WeekStarInfoMode star_info, WeekStarInfoMode new_info) {
        Intrinsics.e(goods_ids, "goods_ids");
        Intrinsics.e(star_info, "star_info");
        Intrinsics.e(new_info, "new_info");
        return new WeekStarMode(goods_ids, star_info, new_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WeekStarMode) {
            WeekStarMode weekStarMode = (WeekStarMode) obj;
            return Intrinsics.a(this.goods_ids, weekStarMode.goods_ids) && Intrinsics.a(this.star_info, weekStarMode.star_info) && Intrinsics.a(this.new_info, weekStarMode.new_info);
        }
        return false;
    }

    public final ArrayList<String> getGoods_ids() {
        return this.goods_ids;
    }

    public final WeekStarInfoMode getNew_info() {
        return this.new_info;
    }

    public final WeekStarInfoMode getStar_info() {
        return this.star_info;
    }

    public int hashCode() {
        return (((this.goods_ids.hashCode() * 31) + this.star_info.hashCode()) * 31) + this.new_info.hashCode();
    }

    public String toString() {
        return "WeekStarMode(goods_ids=" + this.goods_ids + ", star_info=" + this.star_info + ", new_info=" + this.new_info + ')';
    }
}
