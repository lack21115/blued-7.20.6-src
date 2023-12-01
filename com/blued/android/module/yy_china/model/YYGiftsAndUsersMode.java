package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGiftsAndUsersMode.class */
public final class YYGiftsAndUsersMode {
    private final String beans_current;
    private final ArrayList<YYGiftModel> goods_list;
    private final ArrayList<YYUsersMode> target_uids_info;

    public YYGiftsAndUsersMode(ArrayList<YYGiftModel> goods_list, String beans_current, ArrayList<YYUsersMode> target_uids_info) {
        Intrinsics.e(goods_list, "goods_list");
        Intrinsics.e(beans_current, "beans_current");
        Intrinsics.e(target_uids_info, "target_uids_info");
        this.goods_list = goods_list;
        this.beans_current = beans_current;
        this.target_uids_info = target_uids_info;
    }

    public static /* synthetic */ YYGiftsAndUsersMode copy$default(YYGiftsAndUsersMode yYGiftsAndUsersMode, ArrayList arrayList, String str, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = yYGiftsAndUsersMode.goods_list;
        }
        if ((i & 2) != 0) {
            str = yYGiftsAndUsersMode.beans_current;
        }
        if ((i & 4) != 0) {
            arrayList2 = yYGiftsAndUsersMode.target_uids_info;
        }
        return yYGiftsAndUsersMode.copy(arrayList, str, arrayList2);
    }

    public final ArrayList<YYGiftModel> component1() {
        return this.goods_list;
    }

    public final String component2() {
        return this.beans_current;
    }

    public final ArrayList<YYUsersMode> component3() {
        return this.target_uids_info;
    }

    public final YYGiftsAndUsersMode copy(ArrayList<YYGiftModel> goods_list, String beans_current, ArrayList<YYUsersMode> target_uids_info) {
        Intrinsics.e(goods_list, "goods_list");
        Intrinsics.e(beans_current, "beans_current");
        Intrinsics.e(target_uids_info, "target_uids_info");
        return new YYGiftsAndUsersMode(goods_list, beans_current, target_uids_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYGiftsAndUsersMode) {
            YYGiftsAndUsersMode yYGiftsAndUsersMode = (YYGiftsAndUsersMode) obj;
            return Intrinsics.a(this.goods_list, yYGiftsAndUsersMode.goods_list) && Intrinsics.a((Object) this.beans_current, (Object) yYGiftsAndUsersMode.beans_current) && Intrinsics.a(this.target_uids_info, yYGiftsAndUsersMode.target_uids_info);
        }
        return false;
    }

    public final String getBeans_current() {
        return this.beans_current;
    }

    public final ArrayList<YYGiftModel> getGoods_list() {
        return this.goods_list;
    }

    public final ArrayList<YYUsersMode> getTarget_uids_info() {
        return this.target_uids_info;
    }

    public int hashCode() {
        return (((this.goods_list.hashCode() * 31) + this.beans_current.hashCode()) * 31) + this.target_uids_info.hashCode();
    }

    public String toString() {
        return "YYGiftsAndUsersMode(goods_list=" + this.goods_list + ", beans_current=" + this.beans_current + ", target_uids_info=" + this.target_uids_info + ')';
    }
}
