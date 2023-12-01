package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveSyntheticFragmentSuccessModel.class */
public final class LiveSyntheticFragmentSuccessModel implements Serializable {
    private final int count;
    private final int goods_id;
    private final String goods_name;
    private final String image;

    public LiveSyntheticFragmentSuccessModel(String image, String goods_name, int i, int i2) {
        Intrinsics.e(image, "image");
        Intrinsics.e(goods_name, "goods_name");
        this.image = image;
        this.goods_name = goods_name;
        this.goods_id = i;
        this.count = i2;
    }

    public static /* synthetic */ LiveSyntheticFragmentSuccessModel copy$default(LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = liveSyntheticFragmentSuccessModel.image;
        }
        if ((i3 & 2) != 0) {
            str2 = liveSyntheticFragmentSuccessModel.goods_name;
        }
        if ((i3 & 4) != 0) {
            i = liveSyntheticFragmentSuccessModel.goods_id;
        }
        if ((i3 & 8) != 0) {
            i2 = liveSyntheticFragmentSuccessModel.count;
        }
        return liveSyntheticFragmentSuccessModel.copy(str, str2, i, i2);
    }

    public final String component1() {
        return this.image;
    }

    public final String component2() {
        return this.goods_name;
    }

    public final int component3() {
        return this.goods_id;
    }

    public final int component4() {
        return this.count;
    }

    public final LiveSyntheticFragmentSuccessModel copy(String image, String goods_name, int i, int i2) {
        Intrinsics.e(image, "image");
        Intrinsics.e(goods_name, "goods_name");
        return new LiveSyntheticFragmentSuccessModel(image, goods_name, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveSyntheticFragmentSuccessModel) {
            LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel = (LiveSyntheticFragmentSuccessModel) obj;
            return Intrinsics.a((Object) this.image, (Object) liveSyntheticFragmentSuccessModel.image) && Intrinsics.a((Object) this.goods_name, (Object) liveSyntheticFragmentSuccessModel.goods_name) && this.goods_id == liveSyntheticFragmentSuccessModel.goods_id && this.count == liveSyntheticFragmentSuccessModel.count;
        }
        return false;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getImage() {
        return this.image;
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + this.goods_name.hashCode()) * 31) + this.goods_id) * 31) + this.count;
    }

    public String toString() {
        return "LiveSyntheticFragmentSuccessModel(image='" + this.image + "', goods_name='" + this.goods_name + "', goods_id=" + this.goods_id + ", count=" + this.count + ')';
    }
}
