package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPayMode.class */
public final class YYPayMode {
    private final long beans_current;
    private final YyWealthModel current_wealth;
    private final ArrayList<YYItemRainMode> goods_rain_list;
    private final YyWealthModel next_wealth;
    private final long users_sums_left;

    public YYPayMode(YyWealthModel next_wealth, YyWealthModel current_wealth, long j, long j2, ArrayList<YYItemRainMode> goods_rain_list) {
        Intrinsics.e(next_wealth, "next_wealth");
        Intrinsics.e(current_wealth, "current_wealth");
        Intrinsics.e(goods_rain_list, "goods_rain_list");
        this.next_wealth = next_wealth;
        this.current_wealth = current_wealth;
        this.beans_current = j;
        this.users_sums_left = j2;
        this.goods_rain_list = goods_rain_list;
    }

    public static /* synthetic */ YYPayMode copy$default(YYPayMode yYPayMode, YyWealthModel yyWealthModel, YyWealthModel yyWealthModel2, long j, long j2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            yyWealthModel = yYPayMode.next_wealth;
        }
        if ((i & 2) != 0) {
            yyWealthModel2 = yYPayMode.current_wealth;
        }
        if ((i & 4) != 0) {
            j = yYPayMode.beans_current;
        }
        if ((i & 8) != 0) {
            j2 = yYPayMode.users_sums_left;
        }
        if ((i & 16) != 0) {
            arrayList = yYPayMode.goods_rain_list;
        }
        return yYPayMode.copy(yyWealthModel, yyWealthModel2, j, j2, arrayList);
    }

    public final YyWealthModel component1() {
        return this.next_wealth;
    }

    public final YyWealthModel component2() {
        return this.current_wealth;
    }

    public final long component3() {
        return this.beans_current;
    }

    public final long component4() {
        return this.users_sums_left;
    }

    public final ArrayList<YYItemRainMode> component5() {
        return this.goods_rain_list;
    }

    public final YYPayMode copy(YyWealthModel next_wealth, YyWealthModel current_wealth, long j, long j2, ArrayList<YYItemRainMode> goods_rain_list) {
        Intrinsics.e(next_wealth, "next_wealth");
        Intrinsics.e(current_wealth, "current_wealth");
        Intrinsics.e(goods_rain_list, "goods_rain_list");
        return new YYPayMode(next_wealth, current_wealth, j, j2, goods_rain_list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPayMode) {
            YYPayMode yYPayMode = (YYPayMode) obj;
            return Intrinsics.a(this.next_wealth, yYPayMode.next_wealth) && Intrinsics.a(this.current_wealth, yYPayMode.current_wealth) && this.beans_current == yYPayMode.beans_current && this.users_sums_left == yYPayMode.users_sums_left && Intrinsics.a(this.goods_rain_list, yYPayMode.goods_rain_list);
        }
        return false;
    }

    public final long getBeans_current() {
        return this.beans_current;
    }

    public final YyWealthModel getCurrent_wealth() {
        return this.current_wealth;
    }

    public final ArrayList<YYItemRainMode> getGoods_rain_list() {
        return this.goods_rain_list;
    }

    public final YyWealthModel getNext_wealth() {
        return this.next_wealth;
    }

    public final long getUsers_sums_left() {
        return this.users_sums_left;
    }

    public int hashCode() {
        return (((((((this.next_wealth.hashCode() * 31) + this.current_wealth.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.beans_current)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.users_sums_left)) * 31) + this.goods_rain_list.hashCode();
    }

    public String toString() {
        return "YYPayMode(next_wealth=" + this.next_wealth + ", current_wealth=" + this.current_wealth + ", beans_current=" + this.beans_current + ", users_sums_left=" + this.users_sums_left + ", goods_rain_list=" + this.goods_rain_list + ')';
    }
}
