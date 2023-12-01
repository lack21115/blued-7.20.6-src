package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRomanticCityListModel.class */
public final class YYRomanticCityListModel {
    private final YYGiftModel goods_info;
    private final ArrayList<YYRomanticCityModel> regions;

    public YYRomanticCityListModel(ArrayList<YYRomanticCityModel> regions, YYGiftModel goods_info) {
        Intrinsics.e(regions, "regions");
        Intrinsics.e(goods_info, "goods_info");
        this.regions = regions;
        this.goods_info = goods_info;
    }

    public static /* synthetic */ YYRomanticCityListModel copy$default(YYRomanticCityListModel yYRomanticCityListModel, ArrayList arrayList, YYGiftModel yYGiftModel, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = yYRomanticCityListModel.regions;
        }
        if ((i & 2) != 0) {
            yYGiftModel = yYRomanticCityListModel.goods_info;
        }
        return yYRomanticCityListModel.copy(arrayList, yYGiftModel);
    }

    public final ArrayList<YYRomanticCityModel> component1() {
        return this.regions;
    }

    public final YYGiftModel component2() {
        return this.goods_info;
    }

    public final YYRomanticCityListModel copy(ArrayList<YYRomanticCityModel> regions, YYGiftModel goods_info) {
        Intrinsics.e(regions, "regions");
        Intrinsics.e(goods_info, "goods_info");
        return new YYRomanticCityListModel(regions, goods_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRomanticCityListModel) {
            YYRomanticCityListModel yYRomanticCityListModel = (YYRomanticCityListModel) obj;
            return Intrinsics.a(this.regions, yYRomanticCityListModel.regions) && Intrinsics.a(this.goods_info, yYRomanticCityListModel.goods_info);
        }
        return false;
    }

    public final YYGiftModel getGoods_info() {
        return this.goods_info;
    }

    public final ArrayList<YYRomanticCityModel> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        return (this.regions.hashCode() * 31) + this.goods_info.hashCode();
    }

    public String toString() {
        return "YYRomanticCityListModel(regions=" + this.regions + ", goods_info=" + this.goods_info + ')';
    }
}
