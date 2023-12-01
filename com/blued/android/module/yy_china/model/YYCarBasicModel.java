package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCarBasicModel.class */
public final class YYCarBasicModel {
    private final ConfigBean beans;
    private final YYCarPreviewModel default_car;
    private final GoodsModel goods_id;
    private final HonorInfo honor_info;
    private final List<YYCarTabModel> tab;

    public YYCarBasicModel(List<YYCarTabModel> tab, ConfigBean beans, GoodsModel goods_id, HonorInfo honor_info, YYCarPreviewModel default_car) {
        Intrinsics.e(tab, "tab");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(honor_info, "honor_info");
        Intrinsics.e(default_car, "default_car");
        this.tab = tab;
        this.beans = beans;
        this.goods_id = goods_id;
        this.honor_info = honor_info;
        this.default_car = default_car;
    }

    public static /* synthetic */ YYCarBasicModel copy$default(YYCarBasicModel yYCarBasicModel, List list, ConfigBean configBean, GoodsModel goodsModel, HonorInfo honorInfo, YYCarPreviewModel yYCarPreviewModel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = yYCarBasicModel.tab;
        }
        if ((i & 2) != 0) {
            configBean = yYCarBasicModel.beans;
        }
        if ((i & 4) != 0) {
            goodsModel = yYCarBasicModel.goods_id;
        }
        if ((i & 8) != 0) {
            honorInfo = yYCarBasicModel.honor_info;
        }
        if ((i & 16) != 0) {
            yYCarPreviewModel = yYCarBasicModel.default_car;
        }
        return yYCarBasicModel.copy(list, configBean, goodsModel, honorInfo, yYCarPreviewModel);
    }

    public final List<YYCarTabModel> component1() {
        return this.tab;
    }

    public final ConfigBean component2() {
        return this.beans;
    }

    public final GoodsModel component3() {
        return this.goods_id;
    }

    public final HonorInfo component4() {
        return this.honor_info;
    }

    public final YYCarPreviewModel component5() {
        return this.default_car;
    }

    public final YYCarBasicModel copy(List<YYCarTabModel> tab, ConfigBean beans, GoodsModel goods_id, HonorInfo honor_info, YYCarPreviewModel default_car) {
        Intrinsics.e(tab, "tab");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(honor_info, "honor_info");
        Intrinsics.e(default_car, "default_car");
        return new YYCarBasicModel(tab, beans, goods_id, honor_info, default_car);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYCarBasicModel) {
            YYCarBasicModel yYCarBasicModel = (YYCarBasicModel) obj;
            return Intrinsics.a(this.tab, yYCarBasicModel.tab) && Intrinsics.a(this.beans, yYCarBasicModel.beans) && Intrinsics.a(this.goods_id, yYCarBasicModel.goods_id) && Intrinsics.a(this.honor_info, yYCarBasicModel.honor_info) && Intrinsics.a(this.default_car, yYCarBasicModel.default_car);
        }
        return false;
    }

    public final ConfigBean getBeans() {
        return this.beans;
    }

    public final YYCarPreviewModel getDefault_car() {
        return this.default_car;
    }

    public final GoodsModel getGoods_id() {
        return this.goods_id;
    }

    public final HonorInfo getHonor_info() {
        return this.honor_info;
    }

    public final List<YYCarTabModel> getTab() {
        return this.tab;
    }

    public int hashCode() {
        return (((((((this.tab.hashCode() * 31) + this.beans.hashCode()) * 31) + this.goods_id.hashCode()) * 31) + this.honor_info.hashCode()) * 31) + this.default_car.hashCode();
    }

    public String toString() {
        return "YYCarBasicModel(tab=" + this.tab + ", beans=" + this.beans + ", goods_id=" + this.goods_id + ", honor_info=" + this.honor_info + ", default_car=" + this.default_car + ')';
    }
}
