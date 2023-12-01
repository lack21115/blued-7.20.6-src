package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftCardFrameModel.class */
public final class LiveGiftCardFrameModel implements Serializable {
    private LiveGiftBasic basic;
    private int decoration_id;
    private String decoration_type;
    private String expire_time;
    private int is_forever;
    private int is_hide_expire_time;
    private int is_wear;
    private int status;

    public LiveGiftCardFrameModel(LiveGiftBasic basic, int i, String decoration_type, String expire_time, int i2, int i3, int i4, int i5) {
        Intrinsics.e(basic, "basic");
        Intrinsics.e(decoration_type, "decoration_type");
        Intrinsics.e(expire_time, "expire_time");
        this.basic = basic;
        this.decoration_id = i;
        this.decoration_type = decoration_type;
        this.expire_time = expire_time;
        this.is_hide_expire_time = i2;
        this.is_forever = i3;
        this.is_wear = i4;
        this.status = i5;
    }

    public /* synthetic */ LiveGiftCardFrameModel(LiveGiftBasic liveGiftBasic, int i, String str, String str2, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveGiftBasic, i, str, str2, (i6 & 16) != 0 ? 0 : i2, i3, i4, i5);
    }

    public static /* synthetic */ LiveGiftCardFrameModel copy$default(LiveGiftCardFrameModel liveGiftCardFrameModel, LiveGiftBasic liveGiftBasic, int i, String str, String str2, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            liveGiftBasic = liveGiftCardFrameModel.basic;
        }
        if ((i6 & 2) != 0) {
            i = liveGiftCardFrameModel.decoration_id;
        }
        if ((i6 & 4) != 0) {
            str = liveGiftCardFrameModel.decoration_type;
        }
        if ((i6 & 8) != 0) {
            str2 = liveGiftCardFrameModel.expire_time;
        }
        if ((i6 & 16) != 0) {
            i2 = liveGiftCardFrameModel.is_hide_expire_time;
        }
        if ((i6 & 32) != 0) {
            i3 = liveGiftCardFrameModel.is_forever;
        }
        if ((i6 & 64) != 0) {
            i4 = liveGiftCardFrameModel.is_wear;
        }
        if ((i6 & 128) != 0) {
            i5 = liveGiftCardFrameModel.status;
        }
        return liveGiftCardFrameModel.copy(liveGiftBasic, i, str, str2, i2, i3, i4, i5);
    }

    public final LiveGiftBasic component1() {
        return this.basic;
    }

    public final int component2() {
        return this.decoration_id;
    }

    public final String component3() {
        return this.decoration_type;
    }

    public final String component4() {
        return this.expire_time;
    }

    public final int component5() {
        return this.is_hide_expire_time;
    }

    public final int component6() {
        return this.is_forever;
    }

    public final int component7() {
        return this.is_wear;
    }

    public final int component8() {
        return this.status;
    }

    public final LiveGiftCardFrameModel copy(LiveGiftBasic basic, int i, String decoration_type, String expire_time, int i2, int i3, int i4, int i5) {
        Intrinsics.e(basic, "basic");
        Intrinsics.e(decoration_type, "decoration_type");
        Intrinsics.e(expire_time, "expire_time");
        return new LiveGiftCardFrameModel(basic, i, decoration_type, expire_time, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftCardFrameModel) {
            LiveGiftCardFrameModel liveGiftCardFrameModel = (LiveGiftCardFrameModel) obj;
            return Intrinsics.a(this.basic, liveGiftCardFrameModel.basic) && this.decoration_id == liveGiftCardFrameModel.decoration_id && Intrinsics.a((Object) this.decoration_type, (Object) liveGiftCardFrameModel.decoration_type) && Intrinsics.a((Object) this.expire_time, (Object) liveGiftCardFrameModel.expire_time) && this.is_hide_expire_time == liveGiftCardFrameModel.is_hide_expire_time && this.is_forever == liveGiftCardFrameModel.is_forever && this.is_wear == liveGiftCardFrameModel.is_wear && this.status == liveGiftCardFrameModel.status;
        }
        return false;
    }

    public final LiveGiftBasic getBasic() {
        return this.basic;
    }

    public final int getDecoration_id() {
        return this.decoration_id;
    }

    public final String getDecoration_type() {
        return this.decoration_type;
    }

    public final String getExpire_time() {
        return this.expire_time;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((((((this.basic.hashCode() * 31) + this.decoration_id) * 31) + this.decoration_type.hashCode()) * 31) + this.expire_time.hashCode()) * 31) + this.is_hide_expire_time) * 31) + this.is_forever) * 31) + this.is_wear) * 31) + this.status;
    }

    public final int is_forever() {
        return this.is_forever;
    }

    public final int is_hide_expire_time() {
        return this.is_hide_expire_time;
    }

    public final int is_wear() {
        return this.is_wear;
    }

    public final void setBasic(LiveGiftBasic liveGiftBasic) {
        Intrinsics.e(liveGiftBasic, "<set-?>");
        this.basic = liveGiftBasic;
    }

    public final void setDecoration_id(int i) {
        this.decoration_id = i;
    }

    public final void setDecoration_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.decoration_type = str;
    }

    public final void setExpire_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.expire_time = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void set_forever(int i) {
        this.is_forever = i;
    }

    public final void set_hide_expire_time(int i) {
        this.is_hide_expire_time = i;
    }

    public final void set_wear(int i) {
        this.is_wear = i;
    }

    public String toString() {
        return "LiveGiftCardFrameModel(basic=" + this.basic + ", decoration_id=" + this.decoration_id + ", decoration_type=" + this.decoration_type + ", expire_time=" + this.expire_time + ", is_hide_expire_time=" + this.is_hide_expire_time + ", is_forever=" + this.is_forever + ", is_wear=" + this.is_wear + ", status=" + this.status + ')';
    }
}
