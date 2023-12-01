package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/VeiledRoomInfoMode.class */
public final class VeiledRoomInfoMode {
    private final YYGiftModel goods_info;
    private final String open_beans;
    private final List<String> veiled_card_goods_id;

    public VeiledRoomInfoMode(String open_beans, YYGiftModel goods_info, List<String> veiled_card_goods_id) {
        Intrinsics.e(open_beans, "open_beans");
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(veiled_card_goods_id, "veiled_card_goods_id");
        this.open_beans = open_beans;
        this.goods_info = goods_info;
        this.veiled_card_goods_id = veiled_card_goods_id;
    }

    public static /* synthetic */ VeiledRoomInfoMode copy$default(VeiledRoomInfoMode veiledRoomInfoMode, String str, YYGiftModel yYGiftModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = veiledRoomInfoMode.open_beans;
        }
        if ((i & 2) != 0) {
            yYGiftModel = veiledRoomInfoMode.goods_info;
        }
        if ((i & 4) != 0) {
            list = veiledRoomInfoMode.veiled_card_goods_id;
        }
        return veiledRoomInfoMode.copy(str, yYGiftModel, list);
    }

    public final String component1() {
        return this.open_beans;
    }

    public final YYGiftModel component2() {
        return this.goods_info;
    }

    public final List<String> component3() {
        return this.veiled_card_goods_id;
    }

    public final VeiledRoomInfoMode copy(String open_beans, YYGiftModel goods_info, List<String> veiled_card_goods_id) {
        Intrinsics.e(open_beans, "open_beans");
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(veiled_card_goods_id, "veiled_card_goods_id");
        return new VeiledRoomInfoMode(open_beans, goods_info, veiled_card_goods_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VeiledRoomInfoMode) {
            VeiledRoomInfoMode veiledRoomInfoMode = (VeiledRoomInfoMode) obj;
            return Intrinsics.a((Object) this.open_beans, (Object) veiledRoomInfoMode.open_beans) && Intrinsics.a(this.goods_info, veiledRoomInfoMode.goods_info) && Intrinsics.a(this.veiled_card_goods_id, veiledRoomInfoMode.veiled_card_goods_id);
        }
        return false;
    }

    public final YYGiftModel getGoods_info() {
        return this.goods_info;
    }

    public final String getOpen_beans() {
        return this.open_beans;
    }

    public final List<String> getVeiled_card_goods_id() {
        return this.veiled_card_goods_id;
    }

    public int hashCode() {
        return (((this.open_beans.hashCode() * 31) + this.goods_info.hashCode()) * 31) + this.veiled_card_goods_id.hashCode();
    }

    public String toString() {
        return "VeiledRoomInfoMode(open_beans=" + this.open_beans + ", goods_info=" + this.goods_info + ", veiled_card_goods_id=" + this.veiled_card_goods_id + ')';
    }
}
