package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveJoinRoomExtraModel.class */
public final class LiveJoinRoomExtraModel implements Serializable {
    private GoodsDot goods;
    private RechargeDot recharge;
    private RedDot red_dot;

    public LiveJoinRoomExtraModel(RedDot red_dot, RechargeDot recharge, GoodsDot goods) {
        Intrinsics.e(red_dot, "red_dot");
        Intrinsics.e(recharge, "recharge");
        Intrinsics.e(goods, "goods");
        this.red_dot = red_dot;
        this.recharge = recharge;
        this.goods = goods;
    }

    public static /* synthetic */ LiveJoinRoomExtraModel copy$default(LiveJoinRoomExtraModel liveJoinRoomExtraModel, RedDot redDot, RechargeDot rechargeDot, GoodsDot goodsDot, int i, Object obj) {
        if ((i & 1) != 0) {
            redDot = liveJoinRoomExtraModel.red_dot;
        }
        if ((i & 2) != 0) {
            rechargeDot = liveJoinRoomExtraModel.recharge;
        }
        if ((i & 4) != 0) {
            goodsDot = liveJoinRoomExtraModel.goods;
        }
        return liveJoinRoomExtraModel.copy(redDot, rechargeDot, goodsDot);
    }

    public final RedDot component1() {
        return this.red_dot;
    }

    public final RechargeDot component2() {
        return this.recharge;
    }

    public final GoodsDot component3() {
        return this.goods;
    }

    public final LiveJoinRoomExtraModel copy(RedDot red_dot, RechargeDot recharge, GoodsDot goods) {
        Intrinsics.e(red_dot, "red_dot");
        Intrinsics.e(recharge, "recharge");
        Intrinsics.e(goods, "goods");
        return new LiveJoinRoomExtraModel(red_dot, recharge, goods);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveJoinRoomExtraModel) {
            LiveJoinRoomExtraModel liveJoinRoomExtraModel = (LiveJoinRoomExtraModel) obj;
            return Intrinsics.a(this.red_dot, liveJoinRoomExtraModel.red_dot) && Intrinsics.a(this.recharge, liveJoinRoomExtraModel.recharge) && Intrinsics.a(this.goods, liveJoinRoomExtraModel.goods);
        }
        return false;
    }

    public final GoodsDot getGoods() {
        return this.goods;
    }

    public final RechargeDot getRecharge() {
        return this.recharge;
    }

    public final RedDot getRed_dot() {
        return this.red_dot;
    }

    public int hashCode() {
        return (((this.red_dot.hashCode() * 31) + this.recharge.hashCode()) * 31) + this.goods.hashCode();
    }

    public final void setGoods(GoodsDot goodsDot) {
        Intrinsics.e(goodsDot, "<set-?>");
        this.goods = goodsDot;
    }

    public final void setRecharge(RechargeDot rechargeDot) {
        Intrinsics.e(rechargeDot, "<set-?>");
        this.recharge = rechargeDot;
    }

    public final void setRed_dot(RedDot redDot) {
        Intrinsics.e(redDot, "<set-?>");
        this.red_dot = redDot;
    }

    public String toString() {
        return "LiveJoinRoomExtraModel(red_dot=" + this.red_dot + ", recharge=" + this.recharge + ", goods=" + this.goods + ')';
    }
}
