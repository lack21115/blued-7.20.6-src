package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftMode.class */
public final class YYPackGiftMode {
    private final long round_end_time;
    private final ArrayList<YYPackGiftTrueGiftInfoMode> true_love_gift_info;
    private final YYPackGiftInfoMode unlock_privileges;

    public YYPackGiftMode(long j, YYPackGiftInfoMode unlock_privileges, ArrayList<YYPackGiftTrueGiftInfoMode> true_love_gift_info) {
        Intrinsics.e(unlock_privileges, "unlock_privileges");
        Intrinsics.e(true_love_gift_info, "true_love_gift_info");
        this.round_end_time = j;
        this.unlock_privileges = unlock_privileges;
        this.true_love_gift_info = true_love_gift_info;
    }

    public static /* synthetic */ YYPackGiftMode copy$default(YYPackGiftMode yYPackGiftMode, long j, YYPackGiftInfoMode yYPackGiftInfoMode, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            j = yYPackGiftMode.round_end_time;
        }
        if ((i & 2) != 0) {
            yYPackGiftInfoMode = yYPackGiftMode.unlock_privileges;
        }
        if ((i & 4) != 0) {
            arrayList = yYPackGiftMode.true_love_gift_info;
        }
        return yYPackGiftMode.copy(j, yYPackGiftInfoMode, arrayList);
    }

    public final long component1() {
        return this.round_end_time;
    }

    public final YYPackGiftInfoMode component2() {
        return this.unlock_privileges;
    }

    public final ArrayList<YYPackGiftTrueGiftInfoMode> component3() {
        return this.true_love_gift_info;
    }

    public final YYPackGiftMode copy(long j, YYPackGiftInfoMode unlock_privileges, ArrayList<YYPackGiftTrueGiftInfoMode> true_love_gift_info) {
        Intrinsics.e(unlock_privileges, "unlock_privileges");
        Intrinsics.e(true_love_gift_info, "true_love_gift_info");
        return new YYPackGiftMode(j, unlock_privileges, true_love_gift_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftMode) {
            YYPackGiftMode yYPackGiftMode = (YYPackGiftMode) obj;
            return this.round_end_time == yYPackGiftMode.round_end_time && Intrinsics.a(this.unlock_privileges, yYPackGiftMode.unlock_privileges) && Intrinsics.a(this.true_love_gift_info, yYPackGiftMode.true_love_gift_info);
        }
        return false;
    }

    public final long getRound_end_time() {
        return this.round_end_time;
    }

    public final ArrayList<YYPackGiftTrueGiftInfoMode> getTrue_love_gift_info() {
        return this.true_love_gift_info;
    }

    public final YYPackGiftInfoMode getUnlock_privileges() {
        return this.unlock_privileges;
    }

    public int hashCode() {
        return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.round_end_time) * 31) + this.unlock_privileges.hashCode()) * 31) + this.true_love_gift_info.hashCode();
    }

    public String toString() {
        return "YYPackGiftMode(round_end_time=" + this.round_end_time + ", unlock_privileges=" + this.unlock_privileges + ", true_love_gift_info=" + this.true_love_gift_info + ')';
    }
}
