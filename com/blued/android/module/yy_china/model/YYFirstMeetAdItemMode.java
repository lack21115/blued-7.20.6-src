package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetAdItemMode.class */
public final class YYFirstMeetAdItemMode implements MultiItemEntity {
    private final ArrayList<YYFirstMeetGiftsListItemMode> gifts_lists;
    private final YYGiftModel goods_info;
    private final int type;

    public YYFirstMeetAdItemMode(int i, YYGiftModel goods_info, ArrayList<YYFirstMeetGiftsListItemMode> gifts_lists) {
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(gifts_lists, "gifts_lists");
        this.type = i;
        this.goods_info = goods_info;
        this.gifts_lists = gifts_lists;
    }

    public static /* synthetic */ YYFirstMeetAdItemMode copy$default(YYFirstMeetAdItemMode yYFirstMeetAdItemMode, int i, YYGiftModel yYGiftModel, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYFirstMeetAdItemMode.type;
        }
        if ((i2 & 2) != 0) {
            yYGiftModel = yYFirstMeetAdItemMode.goods_info;
        }
        if ((i2 & 4) != 0) {
            arrayList = yYFirstMeetAdItemMode.gifts_lists;
        }
        return yYFirstMeetAdItemMode.copy(i, yYGiftModel, arrayList);
    }

    public final int component1() {
        return this.type;
    }

    public final YYGiftModel component2() {
        return this.goods_info;
    }

    public final ArrayList<YYFirstMeetGiftsListItemMode> component3() {
        return this.gifts_lists;
    }

    public final YYFirstMeetAdItemMode copy(int i, YYGiftModel goods_info, ArrayList<YYFirstMeetGiftsListItemMode> gifts_lists) {
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(gifts_lists, "gifts_lists");
        return new YYFirstMeetAdItemMode(i, goods_info, gifts_lists);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstMeetAdItemMode) {
            YYFirstMeetAdItemMode yYFirstMeetAdItemMode = (YYFirstMeetAdItemMode) obj;
            return this.type == yYFirstMeetAdItemMode.type && Intrinsics.a(this.goods_info, yYFirstMeetAdItemMode.goods_info) && Intrinsics.a(this.gifts_lists, yYFirstMeetAdItemMode.gifts_lists);
        }
        return false;
    }

    public final ArrayList<YYFirstMeetGiftsListItemMode> getGifts_lists() {
        return this.gifts_lists;
    }

    public final YYGiftModel getGoods_info() {
        return this.goods_info;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type * 31) + this.goods_info.hashCode()) * 31) + this.gifts_lists.hashCode();
    }

    public String toString() {
        return "YYFirstMeetAdItemMode(type=" + this.type + ", goods_info=" + this.goods_info + ", gifts_lists=" + this.gifts_lists + ')';
    }
}
