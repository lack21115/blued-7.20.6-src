package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents103Model.class */
public final class IMJsonContents103Model {
    private final String gift_mp4;
    private final String gift_type;
    private final String hit_batch;
    private final String hit_count;
    private final String hit_id;
    private final String is_luck_gift;

    public IMJsonContents103Model(String hit_id, String hit_batch, String is_luck_gift, String gift_mp4, String gift_type, String hit_count) {
        Intrinsics.e(hit_id, "hit_id");
        Intrinsics.e(hit_batch, "hit_batch");
        Intrinsics.e(is_luck_gift, "is_luck_gift");
        Intrinsics.e(gift_mp4, "gift_mp4");
        Intrinsics.e(gift_type, "gift_type");
        Intrinsics.e(hit_count, "hit_count");
        this.hit_id = hit_id;
        this.hit_batch = hit_batch;
        this.is_luck_gift = is_luck_gift;
        this.gift_mp4 = gift_mp4;
        this.gift_type = gift_type;
        this.hit_count = hit_count;
    }

    public static /* synthetic */ IMJsonContents103Model copy$default(IMJsonContents103Model iMJsonContents103Model, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMJsonContents103Model.hit_id;
        }
        if ((i & 2) != 0) {
            str2 = iMJsonContents103Model.hit_batch;
        }
        if ((i & 4) != 0) {
            str3 = iMJsonContents103Model.is_luck_gift;
        }
        if ((i & 8) != 0) {
            str4 = iMJsonContents103Model.gift_mp4;
        }
        if ((i & 16) != 0) {
            str5 = iMJsonContents103Model.gift_type;
        }
        if ((i & 32) != 0) {
            str6 = iMJsonContents103Model.hit_count;
        }
        return iMJsonContents103Model.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.hit_id;
    }

    public final String component2() {
        return this.hit_batch;
    }

    public final String component3() {
        return this.is_luck_gift;
    }

    public final String component4() {
        return this.gift_mp4;
    }

    public final String component5() {
        return this.gift_type;
    }

    public final String component6() {
        return this.hit_count;
    }

    public final IMJsonContents103Model copy(String hit_id, String hit_batch, String is_luck_gift, String gift_mp4, String gift_type, String hit_count) {
        Intrinsics.e(hit_id, "hit_id");
        Intrinsics.e(hit_batch, "hit_batch");
        Intrinsics.e(is_luck_gift, "is_luck_gift");
        Intrinsics.e(gift_mp4, "gift_mp4");
        Intrinsics.e(gift_type, "gift_type");
        Intrinsics.e(hit_count, "hit_count");
        return new IMJsonContents103Model(hit_id, hit_batch, is_luck_gift, gift_mp4, gift_type, hit_count);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents103Model) {
            IMJsonContents103Model iMJsonContents103Model = (IMJsonContents103Model) obj;
            return Intrinsics.a((Object) this.hit_id, (Object) iMJsonContents103Model.hit_id) && Intrinsics.a((Object) this.hit_batch, (Object) iMJsonContents103Model.hit_batch) && Intrinsics.a((Object) this.is_luck_gift, (Object) iMJsonContents103Model.is_luck_gift) && Intrinsics.a((Object) this.gift_mp4, (Object) iMJsonContents103Model.gift_mp4) && Intrinsics.a((Object) this.gift_type, (Object) iMJsonContents103Model.gift_type) && Intrinsics.a((Object) this.hit_count, (Object) iMJsonContents103Model.hit_count);
        }
        return false;
    }

    public final String getGift_mp4() {
        return this.gift_mp4;
    }

    public final String getGift_type() {
        return this.gift_type;
    }

    public final String getHit_batch() {
        return this.hit_batch;
    }

    public final String getHit_count() {
        return this.hit_count;
    }

    public final String getHit_id() {
        return this.hit_id;
    }

    public int hashCode() {
        return (((((((((this.hit_id.hashCode() * 31) + this.hit_batch.hashCode()) * 31) + this.is_luck_gift.hashCode()) * 31) + this.gift_mp4.hashCode()) * 31) + this.gift_type.hashCode()) * 31) + this.hit_count.hashCode();
    }

    public final String is_luck_gift() {
        return this.is_luck_gift;
    }

    public String toString() {
        return "IMJsonContents103Model(hit_id=" + this.hit_id + ", hit_batch=" + this.hit_batch + ", is_luck_gift=" + this.is_luck_gift + ", gift_mp4=" + this.gift_mp4 + ", gift_type=" + this.gift_type + ", hit_count=" + this.hit_count + ')';
    }
}
