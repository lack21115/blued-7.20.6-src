package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYItemRainMode.class */
public final class YYItemRainMode {
    private final String goods_id;
    private final String rain;

    public YYItemRainMode(String goods_id, String rain) {
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(rain, "rain");
        this.goods_id = goods_id;
        this.rain = rain;
    }

    public static /* synthetic */ YYItemRainMode copy$default(YYItemRainMode yYItemRainMode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYItemRainMode.goods_id;
        }
        if ((i & 2) != 0) {
            str2 = yYItemRainMode.rain;
        }
        return yYItemRainMode.copy(str, str2);
    }

    public final String component1() {
        return this.goods_id;
    }

    public final String component2() {
        return this.rain;
    }

    public final YYItemRainMode copy(String goods_id, String rain) {
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(rain, "rain");
        return new YYItemRainMode(goods_id, rain);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYItemRainMode) {
            YYItemRainMode yYItemRainMode = (YYItemRainMode) obj;
            return Intrinsics.a((Object) this.goods_id, (Object) yYItemRainMode.goods_id) && Intrinsics.a((Object) this.rain, (Object) yYItemRainMode.rain);
        }
        return false;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getRain() {
        return this.rain;
    }

    public int hashCode() {
        return (this.goods_id.hashCode() * 31) + this.rain.hashCode();
    }

    public String toString() {
        return "YYItemRainMode(goods_id=" + this.goods_id + ", rain=" + this.rain + ')';
    }
}
